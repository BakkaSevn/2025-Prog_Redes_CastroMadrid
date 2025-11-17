package Tictactoe.Model;

public class Tablero {
    private final Celda[][] tablero;

    public Tablero() {
        tablero = new Celda[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = new Celda();
            }
        }
    }

    public synchronized boolean colocarSimbolo(int fila, int col, String simbolo) {
        if (fila < 0 || fila > 2 || col < 0 || col > 2) return false;
        if (!tablero[fila][col].esVacia()) return false;
        tablero[fila][col].marcar(simbolo);
        return true;
    }

    public synchronized boolean esGanador(String simbolo) {
        // filas
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0].getEstado().equals(simbolo) &&
                tablero[i][1].getEstado().equals(simbolo) &&
                tablero[i][2].getEstado().equals(simbolo)) return true;
        }
        // columnas
        for (int j = 0; j < 3; j++) {
            if (tablero[0][j].getEstado().equals(simbolo) &&
                tablero[1][j].getEstado().equals(simbolo) &&
                tablero[2][j].getEstado().equals(simbolo)) return true;
        }
        // diagonales
        if (tablero[0][0].getEstado().equals(simbolo) &&
            tablero[1][1].getEstado().equals(simbolo) &&
            tablero[2][2].getEstado().equals(simbolo)) return true;
        if (tablero[0][2].getEstado().equals(simbolo) &&
            tablero[1][1].getEstado().equals(simbolo) &&
            tablero[2][0].getEstado().equals(simbolo)) return true;
        return false;
    }

    public synchronized boolean esTableroCompleto() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (tablero[i][j].esVacia()) return false;
        return true;
    }

    public synchronized boolean esEmpate(String simboloX, String simboloO) {
        return esTableroCompleto() && !esGanador(simboloX) && !esGanador(simboloO);
    }

    public synchronized String mostrarTableroTexto() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append(" ");
            for (int j = 0; j < 3; j++) {
                sb.append(tablero[i][j].toString());
                if (j < 2) sb.append(" | ");
            }
            sb.append("\n");
            if (i < 2) sb.append("---+---+---\n");
        }
        return sb.toString();
    }

    public synchronized String serializarLinea() {
        // formato: fila0col0,fila0col1,... separados por ;
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<3;i++) {
            for (int j=0;j<3;j++) {
                sb.append(tablero[i][j].getEstado());
                if (!(i==2 && j==2)) sb.append(";");
            }
        }
        return sb.toString();
    }

    public synchronized void deserializarLinea(String linea) {
        String[] partes = linea.split(";");
        if (partes.length != 9) return;
        int k = 0;
        for (int i=0;i<3;i++) {
            for (int j=0;j<3;j++) {
                tablero[i][j].marcar(partes[k++].equals("VACIA")? "VACIA" : partes[k-1].equals("X")?"X":"O");
            }
        }
    }
}
