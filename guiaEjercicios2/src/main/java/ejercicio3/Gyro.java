package ejercicio3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Gyro implements Runnable {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintStream ps = new PrintStream(System.out);
	static PrintStream err = new PrintStream(System.err);
	
	public static int probability(int min, int max) {
		int rango = (max - min) + 1;
		int random = (int) ((rango * Math.random()) + min);
		return random;
	}

	public void run() {
		int casillaActual = 0;
		while(casillaActual <= 70) {
			ps.println("Te encuentras en la casilla: " + casillaActual);
			int prob = probability(1,100);
			if(casillaActual < 0) casillaActual = 0;
			if( prob > 0 && prob <= 35 ) {
				casillaActual = casillaActual + 3;
				ps.println("Gyro utiliza sus habilidades del Spin para avanzar. Te mueves 3 casillas.");
			}else if(prob > 35 && prob <= 49) {
				casillaActual = casillaActual - 9;
				if(casillaActual < 0) casillaActual = 0;
				ps.println("Gyro es atacado por unos jinetes usuarios de stand. Retrocedes 9 casillas.");
			}else if(prob > 49 && prob <= 70) {
				casillaActual = casillaActual + 1;
				if(casillaActual < 0) casillaActual = 0;
				ps.println("Gyro utiliza sus habilidades de jinete para avanzar entre la multitud. Avanza una casilla.");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				}
			}	
			}
		}
	}