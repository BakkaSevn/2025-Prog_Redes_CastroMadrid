package Tictactoe.Model;

public class Celda {
    private String estado; // "VACIA", "X", "O"

    public Celda() {
        this.estado = "VACIA";
    }

    public synchronized void vaciar() {
        this.estado = "VACIA";
    }

    public synchronized void marcar(String simbolo) {
        if (simbolo == null) return;
        this.estado = simbolo;
    }

    public synchronized boolean esVacia() {
        return "VACIA".equals(this.estado);
    }

    public synchronized String getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        if ("VACIA".equals(estado)) return " ";
        return estado;
    }
}
