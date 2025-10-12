package ejercicio6;

public class main {

	public static void main(String[] args){
		Thread proceso = new Thread(new OficinaDeAlumnos("Benjamín","Castro Madrid"));
		Thread proceso2 = new Thread(new OficinaDeAlumnos("Melina","Castro Madrid"));
		proceso.start();
		proceso2.start();
		
	}

}
