package Tictactoe.Client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    private final String host;
    private final int puerto;

    public Cliente(String host, int puerto) {
        this.host = host;
        this.puerto = puerto;
    }

    public void conectarConServidor() {
        try (Socket socket = new Socket(host, puerto);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             Scanner sc = new Scanner(System.in)) {

            String serverLine;
            // Authenticate
            while ((serverLine = in.readLine()) != null) {
                if (serverLine.startsWith("REQUEST_NAME")) {
                    System.out.print("Ingrese su nombre: "); String nombre = sc.nextLine();
                    out.println(nombre);
                } else if (serverLine.startsWith("START:")) {
                    System.out.println("Partida iniciada -> " + serverLine);
                } else if (serverLine.startsWith("UPDATE:")) {
                    String datos = serverLine.substring(7);
                    mostrarTableroDesdeSerial(datos);
                } else if (serverLine.startsWith("STATUS:")) {
                    System.out.println("Estado: " + serverLine.substring(7));
                } else if (serverLine.startsWith("YOUR_TURN")) {
                    System.out.println("Es tu turno. Ingresa movimiento como fila,col (0..2): "); String mv = sc.nextLine();
                    out.println("MOVE:" + mv);
                } else if (serverLine.startsWith("INVALID_MOVE")) {
                    System.out.println("Movimiento inválido. Intenta de nuevo."); 
                } else if (serverLine.startsWith("END:")) {
                    System.out.println(serverLine.substring(4));
                    break;
                } else if (serverLine.startsWith("OPPONENT_TURN")) {
                    System.out.println("Turno del oponente. Esperando..."); 
                } else {
                    // general print
                    System.out.println(serverLine);
                }
            }

        } catch (IOException e) {
            System.err.println("Error en cliente: " + e.getMessage());
        }
    }

    private void mostrarTableroDesdeSerial(String serial) {
        String[] partes = serial.split(";"); // 9 elementos
        System.out.println("+---+---+---+");
        for (int i=0;i<3;i++) {
            System.out.print("| ");
            for (int j=0;j<3;j++) {
                String v = partes[i*3 + j];
                if ("VACIA".equals(v)) v = " ";
                System.out.print(("X".equals(v)||"O".equals(v) ? v : " ") + " | ");
            }
            System.out.println();
            System.out.println("+---+---+---+");
        }
    }

    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 5000;
        Cliente cliente = new Cliente(host, puerto);
        cliente.conectarConServidor();
    }
}
