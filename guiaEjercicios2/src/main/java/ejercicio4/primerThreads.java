package ejercicio4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class primerThreads implements Runnable {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintStream ps = new PrintStream(System.out);
	static PrintStream err = new PrintStream(System.err);
	
	public void calculoThread(int[][] matriz, int[][] matriz2, int i, int j) {
		int matrizF [][] = new int [4][4];
		//long end = System.currentTimeMillis() - start;
		long start = System.currentTimeMillis();
		for(int i1 = i; i < 4; i++){
			for(int j1 = j; j < 4; j++) {
				matrizF[i][j] = matriz[i][j] * matriz2[i][j];
			}
		}
		long end = System.currentTimeMillis() - start;
		var output = "El cálculo tardó: " + end;
		ps.print(Arrays.deepToString(matrizF));
		JOptionPane.showMessageDialog(null, output);
	}
	
	public void run() {
		calculoThread();
	}
}
