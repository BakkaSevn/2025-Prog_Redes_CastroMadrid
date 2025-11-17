package Tictactoe.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import Tictactoe.Model.Jugador;
import Tictactoe.Model.Tablero;

public class Servidor {
    private final int puerto;
    private final ExecutorService pool;

    public Servidor(int puerto) {
        this.puerto = puerto;
        this.pool = Executors.newCachedThreadPool();
    }

    public void iniciarServidor() {
        System.out.println("Iniciando servidor en puerto " + puerto);
        try (ServerSocket serverSocket = new ServerSocket(puerto)) {
            while (true) {
                System.out.println("Esperando jugadores... (se aceptan pares)"); 
                Socket s1 = serverSocket.accept();
                System.out.println("Jugador 1 conectado: " + s1.getRemoteSocketAddress());
                Socket s2 = serverSocket.accept();
                System.out.println("Jugador 2 conectado: " + s2.getRemoteSocketAddress());

                GameHandler partida = new GameHandler(s1, s2);
                pool.submit(partida);
            }
        } catch (IOException e) {
            System.err.println("Error en servidor: " + e.getMessage());
        } finally {
            pool.shutdown();
        }
    }

    public static void main(String[] args) {
        int puerto = 5000;
        Servidor servidor = new Servidor(puerto);
        servidor.iniciarServidor();
    }
}
