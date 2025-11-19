package ar.edu.et32.examenFinalJava.Client;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import ar.edu.et32.examenFinalJava.Utils.EnumType;

public class mainCliente {

	public static void main(String[] args) {
		try(Cliente cli = new Cliente(EnumType.CLIENT, "127.0.0.1", 2006) )
		{
			cli.clienteOn();
		}catch(IOException e) {
			Logger.getLogger(mainCliente.class.getName()).log(Level.SEVERE, null, e);
		}
	}

}
