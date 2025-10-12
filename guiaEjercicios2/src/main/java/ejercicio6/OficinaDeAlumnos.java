package ejercicio6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OficinaDeAlumnos implements Runnable {
	
	public static List<Alumnos> listaAlumnos = Collections.synchronizedList(new ArrayList<>());
	private String nombre, apellido;
	
	public OficinaDeAlumnos(String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
		}
	
	private static int getRandom(int min, int max) {
		int range = (max - min) + 1;
     		int random = (int) ((range * Math.random()) + min);
		return random;
		}
	
	private void OficinaDeAlumno(List<Alumnos> asistencia) {}
	
	private int[] Assist(int limit) {
		int[] facts = new int[9];
		for(int i = 0; i < limit; i++) {
			int faltas = OficinaDeAlumnos.getRandom(1, 20);
			facts[i] = faltas;
			};
			return facts;
			}
	
	private int[] Grade(int limit) {
		int[] notas = new int[3];
		for(int i = 0; i < limit; i++) {
			int faltas = OficinaDeAlumnos.getRandom(1, 10);
			notas[i] = faltas;
			};
			return notas;
			}
	
	@Override
	public void run() {
		boolean esAlumnoR = true;
		Alumnos alumno = new Alumnos(nombre, apellido, Assist(9), Grade(3), esAlumnoR);
		listaAlumnos.add(alumno);
		OficinaDeAlumno(listaAlumnos);
		System.out.println(alumno);
		}
	}
