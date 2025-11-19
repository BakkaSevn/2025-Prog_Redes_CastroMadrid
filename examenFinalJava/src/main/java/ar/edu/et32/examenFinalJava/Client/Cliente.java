package ar.edu.et32.examenFinalJava.Client;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

import ar.edu.et32.examenFinalJava.Utils.Connection;
import ar.edu.et32.examenFinalJava.Utils.EnumType;

public class Cliente extends Connection implements AutoCloseable {
	private DataInputStream disClient;
	
	public Cliente(EnumType type, String IP, int port) throws UnknownHostException, IOException{
		super(type, IP, port);
	}
	
	PrintStream ps = new PrintStream(System.out);
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	boolean isConnected = false;
	private String sharedKey = "";
	
	public void clienteOn() {
		try {
			isConnected = true;
			this.disClient = new DataInputStream(sockC.getInputStream());
			dosClient = new DataOutputStream(sockC.getOutputStream());
			if(sockC.isConnected()) {
				ps.println(ar.edu.et32.examenFinalJava.Utils.Colors.ANSI_YELLOW + "Ingrese su ID: " + ar.edu.et32.examenFinalJava.Utils.Colors.ANSI_RESET);
				String ID = br.readLine();
				if(ID == null) ID = "Anon";
				ps.println(ar.edu.et32.examenFinalJava.Utils.Colors.ANSI_YELLOW + "Ingrese la clave secreta compartida (misma para todos los clientes):" + ar.edu.et32.examenFinalJava.Utils.Colors.ANSI_RESET);
                String clave = br.readLine();
                if (clave == null) clave = "";
                this.sharedKey = clave;
				dosClient.writeUTF(ID);
				dosClient.flush();
				ps.println(ar.edu.et32.examenFinalJava.Utils.Colors.ANSI_YELLOW + "Bienvenido al chat: " + ID + ar.edu.et32.examenFinalJava.Utils.Colors.ANSI_RESET);
				
				
				
	
				Thread enviarMensaje = new Thread(() -> {
		            String msg = "";
		            try {
		            	dosClient.writeUTF("aaaaaa");
		                while (true) {
		                    msg = br.readLine();
		                    if (msg != null) 
		                    {
		                    	msg = msg.trim();
		                    
			                    if (msg.equals("")) { ps.print("\t->"); continue; }
			                    if (msg.equalsIgnoreCase("/salir")) {
			                        dosClient.writeUTF("/salir");
			                        dosClient.flush();
			                        break;
			                    } else if (msg.equalsIgnoreCase("/listar")) {
			                        dosClient.writeUTF("/listar");
			                        dosClient.flush();
			                    } else if (msg.equalsIgnoreCase("/verComandos") || msg.equalsIgnoreCase("/ayuda")) {
			                        mostrarComandos();  
			                    }else {
			                    	dosClient.writeUTF(msg);
			                        dosClient.flush();
			                    }
			                    ps.print("\t->");
		                    }
		                }
		            } catch (Exception e) {
		                e.printStackTrace();
		            } finally {
		            	System.out.println("assassa");
		                try {
		                    if (dosClient != null) dosClient.close();
		                    if (sockC != null) sockC.close();
		                } catch (Exception ex) {}
		            }
		        }, "Envio");
				
				Thread recibirMensaje = new Thread(()->{
					try {
		                while (isConnected) {
		                    String token = disClient.readUTF();
		                    if ("RESP::LIST".equals(token)) {
		                        String lista = disClient.readUTF();
		                        ps.println(ar.edu.et32.examenFinalJava.Utils.Colors.ANSI_YELLOW + "Usuarios: " + lista + ar.edu.et32.examenFinalJava.Utils.Colors.ANSI_RESET);
		                    } else if ("RESP::NOTFOUND".equals(token)) {
		                        String t = disClient.readUTF();
		                        ps.println(ar.edu.et32.examenFinalJava.Utils.Colors.ANSI_YELLOW + "Usuario no encontrado: " + t + ar.edu.et32.examenFinalJava.Utils.Colors.ANSI_RESET);
		                    } else if ("INCOMING::PRIVATE".equals(token) || "INCOMING::BROADCAST".equals(token)) {
		                        String from = disClient.readUTF();
		                        int ivLen = disClient.readInt();
		                        byte[] iv = new byte[ivLen];
		                        disClient.readFully(iv);
		                        int cipherLen = disClient.readInt();
		                        byte[] cipherBytes = new byte[cipherLen];
		                        disClient.readFully(cipherBytes);
		                        String type = disClient.readUTF();
		                        String extra = disClient.readUTF();
		                        byte[] plainBytes = ar.edu.et32.examenFinalJava.Utils.Bytes.decriptarBytes(sharedKey, iv, cipherBytes);
		                        if (plainBytes == null) {
		                            ps.println(ar.edu.et32.examenFinalJava.Utils.Colors.ANSI_YELLOW + "Error al descifrar mensaje de " + from + ar.edu.et32.examenFinalJava.Utils.Colors.ANSI_RESET);
		                        } else {
		                            if ("TEXT".equals(type)) {
		                                String plain = new String(plainBytes, java.nio.charset.StandardCharsets.UTF_8);
		                                if ("INCOMING::PRIVATE".equals(token)) {
		                                    ps.println(ar.edu.et32.examenFinalJava.Utils.Colors.ANSI_YELLOW + "[PRIVADO de " + from + "] " + plain + ar.edu.et32.examenFinalJava.Utils.Colors.ANSI_RESET);
		                                } else {
		                                    ps.println(ar.edu.et32.examenFinalJava.Utils.Colors.ANSI_YELLOW + "[" + from + "] " + plain + ar.edu.et32.examenFinalJava.Utils.Colors.ANSI_RESET);
		                                }
		                            }
		                        }
		                    } else {
		                        ps.println(ar.edu.et32.examenFinalJava.Utils.Colors.ANSI_YELLOW + token + ar.edu.et32.examenFinalJava.Utils.Colors.ANSI_RESET);
		                    }
		                    ps.print("\t->");
		                }
		            } catch (Exception e) {
		                try { if (sockC != null) sockC.close(); } catch (Exception ex) {}
		            }
				},"Recibir");
				
				recibirMensaje.start();
				enviarMensaje.start();				
				
				
				
				
			}
			ps.print("\t->");
		}catch(Exception e) {
			Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, e);
		}
		

	}
	
    private void mostrarComandos() {
        ps.println(ar.edu.et32.examenFinalJava.Utils.Colors.ANSI_YELLOW + "Comandos disponibles:" + ar.edu.et32.examenFinalJava.Utils.Colors.ANSI_RESET);
        ps.println("/salir - desconectarse");
        ps.println("/listar - ver usuarios conectados");
        ps.println("/verComandos - mostrar comandos");
        ps.println("/ayuda - ayuda");
    }
	
	public void close() throws IOException{
		if(disClient != null) disClient.close();
		if(dosClient != null) dosClient.close();
		if(sockC != null && !sockC.isClosed()) sockC.close();
	}

	public void disconnect(DataInputStream i, DataOutputStream o) {
		if(dosClient != null) {
			try {
				dosClient.writeUTF("Cliente se desconecta");
				dosClient.flush();
			}catch(IOException e) {
				Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, e);
			}
		}
		
		try {
			if(disClient != null) disClient.close();
			if(dosClient != null) dosClient.close();
			if(sockC != null && !sockC.isClosed()) sockC.close();
			ps.println("Cliente desconectado correctamente.");
		}catch(IOException e) {
			Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, e);
		}
	}
}
