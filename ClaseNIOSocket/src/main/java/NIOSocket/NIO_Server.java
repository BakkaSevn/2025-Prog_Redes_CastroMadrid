package NIOSocket;

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class NIO_Server {
	// Códigos ANSI para colores en consola
    private static final String RESET = "\u001B[0m";
    private static final String ROJO = "\u001B[31m";
    private static final String VERDE = "\u001B[32m";
    private static final String AMARILLO = "\u001B[33m";
    private static final String AZUL = "\u001B[34m";
    private static final String MAGENTA = "\u001B[35m";
    private static final String CIAN = "\u001B[36m";
	
	private Selector selector;
	private ServerSocketChannel serverChannel;
	
	private boolean running = false;	
	private final Gson gson = new Gson();
	PrintStream ps = new PrintStream(System.out);
	
	private Map<SocketChannel, String> usuarios = new HashMap<>();
	private Map<String, SocketChannel> canalesPorNombre = new HashMap<>();
	
	public void start(int PORT) throws IOException {
		selector = Selector.open();
		serverChannel = ServerSocketChannel.open();
		serverChannel.configureBlocking(false);
		serverChannel.register(selector, SelectionKey.OP_ACCEPT);
		serverChannel.bind(new InetSocketAddress(PORT));
		
		
		new Thread( ()->{
			running = true;
			try {
				// Colocar mensaje de servidor iniciado.
				System.out.print("Servidor iniciado en el puerto: " + PORT);
				while(running){
					selector.select();
					
					Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
					while(iterator.hasNext()) {
						SelectionKey key = iterator.next();
						if(!key.isValid()) continue;
						if(key.isAcceptable()) {
							ServerSocketChannel server = (ServerSocketChannel) key.channel();
							SocketChannel client = server.accept();
							
							if(client != null) {
								client.configureBlocking(false);
								client.register(selector, SelectionKey.OP_READ);
								System.out.print("Cliente conectado." + client.getRemoteAddress());
								sendMessage(client);
								JsonObject json = new JsonObject();
								json.addProperty("type", "info");
								json.addProperty("text", "Bienvenido!! Registrese enviando su nombre de usuario, gilipollas: ");
								gson.toJson(json);
								ByteBuffer bb = ByteBuffer.wrap(gson.toJson(json).getBytes());
								int ByteLeidos = 0;
								try {
									ByteLeidos = client.read(bb);
									client.write(bb);
								}catch(IOException e) {
									ps.println(ROJO + "[ERROR] no se puede enviar mensaje" + RESET);
									disconnectClient(key, client);
									return;
								}
								if(ByteLeidos == -1) {
									disconnectClient(key, client);
									return;
								}
								
								bb.flip();
								String msg = new String(bb.array(), 0, bb.limit()).trim();
								
								ps.println(AMARILLO + 
										"[INFO] Mensaje recibido del cliente " + 
										client.getLocalAddress().toString()+ 
										":" + RESET);
								try {
									JsonObject json2 = JsonParser.parseString(msg).getAsJsonObject();
									String tipo = json2.get("type").getAsString();
									
									if("command".equals(msg)) {
										String comando = json2.get("command").getAsString().trim().toLowerCase();
										handlerCommand(comando, client);
										return;
									}
									
									switch(tipo) {
									case "register" ->{
										
										}
									case "message" ->{
										
										}
									
									case "private" ->{}
									
									default ->{}
									}
									
								}catch(Exception ex) {}
							}							
						}else if(key.isReadable()) {
							readFromClient(key);
						}
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
					}finally {
						running = false;
						if(selector != null && selector.isOpen()) selector.close();
						if(serverChannel != null && serverChannel.isOpen()) serverChannel.close();
						System.out.print("No rompas los huevos, servidor apagado.");
					}
			}).start();
	}
	
	private void  readFromClient(SelectionKey key) {
		SocketChannel client = (SocketChannel) key.channel();
		ByteBuffer rb = ByteBuffer.allocate(2048);
		try {
			client.read(rb);
		}catch(IOException e) {
			ps.println(ROJO + "[ERROR] No se pudo leer el mensaje" + RESET);
			
		}
	}
	
	private void handlerCommand(String cmd, SocketChannel cli) {
		switch(cmd) {
		case "/listUsers" ->{
			//Mandar mensaje a todos los users
			Set<String> listadoUsers = new HashSet<>(usuarios.values());
			
			JsonObject json = new JsonObject();
			json.addProperty("type", "cmd_response");
			json.addProperty("cmd", "/listUsers");
			json.addProperty("text", "Usuarios conectados: " + String.join(",\n" , listadoUsers));
			sendToClient(gson.toJson(json), cli);
			ps.println(AZUL + "[CMD] Comando /listUsers solicitado por " + cli.getRemoteAddress().toString());
			}
		
		case "/logout" ->{
			//Desconectando al cliente
			sendInfo(cli, "Desconectando...");
			ps.println(AMARILLO + "[INFO] Desconectando al cliente" +
			cli.getRemoteAddress().toString()
			+ RESET);
			disconnectClient(cli.keyFor(selector), cli);
			}
		
		default ->{
			sendError(cli, "Comando desconocido..." + cmd);
			ps.println(AMARILLO + "[INFO] Desconectando al cliente" +
			cmd + RESET);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		NIO_Server servidor = new NIO_Server();
		servidor.start(25565);
	}
}
