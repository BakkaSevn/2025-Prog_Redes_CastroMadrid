package ejercicio5;

import java.io.File;

public class main {

	public static void main(String[] args) {
		File carpeta = new File(".\\documentos");
		File[] archivos = carpeta.listFiles();
		int count = 0;
		
		for(int i = 0; i < archivos.length ; i++) {
			Thread proceso = new Thread(new LeerArchivo(archivos[i]));
			proceso.start();
		}
		
	}
}
