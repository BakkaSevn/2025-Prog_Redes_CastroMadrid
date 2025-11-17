package Tictactoe.Server;

import java.io.*;
import java.net.Socket;

import Tictactoe.Model.Jugador;
import Tictactoe.Model.Tablero;

public class GameHandler implements Runnable {
    private final Socket s1;
    private final Socket s2;
    private Tablero tablero = new Tablero();
    private Jugador jugador1;
    private Jugador jugador2;
    private volatile boolean turnoJugador1 = true; // true -> jugador1's turn

    public GameHandler(Socket s1, Socket s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    @Override
    public void run() {
        System.out.println("Iniciando partida entre " + s1.getRemoteSocketAddress() + " y " + s2.getRemoteSocketAddress());
        try (
            BufferedReader in1 = new BufferedReader(new InputStreamReader(s1.getInputStream()));
            PrintWriter out1 = new PrintWriter(s1.getOutputStream(), true);
            BufferedReader in2 = new BufferedReader(new InputStreamReader(s2.getInputStream()));
            PrintWriter out2 = new PrintWriter(s2.getOutputStream(), true);
        ) {
            // Autenticación simple
            out1.println("REQUEST_NAME");
            String name1 = in1.readLine();
            out2.println("REQUEST_NAME");
            String name2 = in2.readLine();
            jugador1 = new Jugador(name1 == null ? "Jugador1" : name1, "X");
            jugador2 = new Jugador(name2 == null ? "Jugador2" : name2, "O");

            out1.println("START:" + jugador1.getSimbolo() + ":" + true);
            out2.println("START:" + jugador2.getSimbolo() + ":" + false);

            boolean partidaActiva = true;
            while (partidaActiva) {
                // Enviar estado a ambos
                enviarActualizacion(out1, out2, "IN_PROGRESS");

                if (turnoJugador1) {
                    out1.println("YOUR_TURN");
                    out2.println("OPPONENT_TURN");
                    String line = in1.readLine();
                    if (line == null) break;
                    if (line.startsWith("MOVE:")) {
                        String coords = line.substring(5);
                        String[] p = coords.split(","); int f = Integer.parseInt(p[0]); int c = Integer.parseInt(p[1]);
                        synchronized (tablero) {
                            if (tablero.colocarSimbolo(f,c,jugador1.getSimbolo())) {
                                if (tablero.esGanador(jugador1.getSimbolo())) {
                                    enviarActualizacion(out1, out2, "X_WINS"); out1.println("END:Has ganado!"); out2.println("END:Has perdido."); partidaActiva = false; break;
                                } else if (tablero.esEmpate("X","O")) {
                                    enviarActualizacion(out1, out2, "DRAW"); out1.println("END:Empate."); out2.println("END:Empate."); partidaActiva = false; break;
                                } else {
                                    turnoJugador1 = false;
                                }
                            } else {
                                out1.println("INVALID_MOVE"); // try again
                            }
                        }
                    }
                } else {
                    out2.println("YOUR_TURN");
                    out1.println("OPPONENT_TURN");
                    String line = in2.readLine();
                    if (line == null) break;
                    if (line.startsWith("MOVE:")) {
                        String coords = line.substring(5);
                        String[] p = coords.split(","); int f = Integer.parseInt(p[0]); int c = Integer.parseInt(p[1]);
                        synchronized (tablero) {
                            if (tablero.colocarSimbolo(f,c,jugador2.getSimbolo())) {
                                if (tablero.esGanador(jugador2.getSimbolo())) {
                                    enviarActualizacion(out1, out2, "O_WINS"); out2.println("END:Has ganado!"); out1.println("END:Has perdido."); partidaActiva = false; break;
                                } else if (tablero.esEmpate("X","O")) {
                                    enviarActualizacion(out1, out2, "DRAW"); out1.println("END:Empate."); out2.println("END:Empate."); partidaActiva = false; break;
                                } else {
                                    turnoJugador1 = true;
                                }
                            } else {
                                out2.println("INVALID_MOVE"); // try again
                            }
                        }
                    }
                }
            }

        } catch (IOException e) {
            System.err.println("Error en partida: " + e.getMessage());
        } finally {
            try { s1.close(); } catch (IOException ignored) {}
            try { s2.close(); } catch (IOException ignored) {}
        }
    }

    private void enviarActualizacion(PrintWriter out1, PrintWriter out2, String estado) {
        String serial = tablero.serializarLinea();
        out1.println("UPDATE:" + serial);
        out1.println("STATUS:" + estado);
        out2.println("UPDATE:" + serial);
        out2.println("STATUS:" + estado);
    }
}
