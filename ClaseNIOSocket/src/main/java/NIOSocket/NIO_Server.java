package NIOSocket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.google.gson.Gson;

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
	private final Gson json = new Gson();
	
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
	
	public static void main(String[] args) throws IOException {
		NIO_Server servidor = new NIO_Server();
		servidor.start(25565);
	}
}
