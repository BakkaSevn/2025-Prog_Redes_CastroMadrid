package ar.edu.et32.examenFinalJava.Server;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.channels.SocketChannel;
import java.util.logging.Level;
import java.util.logging.Logger;
import ar.edu.et32.examenFinalJava.Utils.Connection;

public class Server extends Connection implements AutoCloseable {

	private DataInputStream disServer = null;
	private BufferedReader br = null;
	
	public Server(ar.edu.et32.examenFinalJava.Utils.EnumType type) throws UnknownHostException, IOException {
		super(type);
	}
	
	public void serverOn() {
		try {
			ps.printf("");
			ps.printf(ar.edu.et32.examenFinalJava.Utils.Colors.ANSI_YELLOW + "Esperando conexion de cliente\n\tPort:%s\n" + ar.edu.et32.examenFinalJava.Utils.Colors.ANSI_RESET,
					getPort());

			sockC = sockS.accept();

			ps.printf("%s - %s \n", sockC.getInetAddress().getHostAddress(), sockC.getInetAddress().getHostName());

			dosClient = new DataOutputStream(sockC.getOutputStream());
			disServer = new DataInputStream(sockC.getInputStream());
			ps.println(ar.edu.et32.examenFinalJava.Utils.Colors.ANSI_GREEN + "Cliente conectado con exito." + ar.edu.et32.examenFinalJava.Utils.Colors.ANSI_RESET);
			
			Thread.sleep(200);
			
			String id = disServer.readUTF();
			
			String msg = "";
			while( true ) {
				if( (msg = disServer.readUTF()) != null )
					ps.printf(ar.edu.et32.examenFinalJava.Utils.Colors.ANSI_YELLOW + "\tMensaje de " + id + ":" + msg + ar.edu.et32.examenFinalJava.Utils.Colors.ANSI_RESET);
				//dosClient.flush();
				//sockC.close();
			}
			
			//ps.printf("SALIENDO DEL SERVER");
			
		} catch (IOException | InterruptedException ex) {
			Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			/*
			try {
				sockC.close();
				if (br != null)
					br.close();

				if (disServer != null)
					disServer.close();

				dosClient.close();
				// sockS.close();
			} catch (IOException ex) {
				Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
			}
			*/
		}
	}
	
	@Override
	public void close() throws IOException {
		sockC.close();
		if (br != null)
			br.close();

		if (disServer != null)
			disServer.close();

		dosClient.close();
		sockS.close();
	}

	/**
	 * 
	 * @param   {@link Socket} sock esto es para reccibir algo
	 * @param p esto recibe eotra cosa
	 */
	}