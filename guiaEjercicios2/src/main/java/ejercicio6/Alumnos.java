package ejercicio6;

import java.util.Arrays;

public class Alumnos {

    private String nombre, apellido;
    private int[] asistencia, notas;
    private boolean esAlumnoRegular;

    public Alumnos(String nombre, String apellido, int[] asistencia, int[] notas, boolean esAlumnoRegular) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.asistencia = asistencia;
        this.notas = notas;
        this.esAlumnoRegular = esAlumnoRegular;
        }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", asistencia=" + Arrays.toString(asistencia) +
                ", notas=" + Arrays.toString(notas) +
                ", esAlumnoRegular=" + esAlumnoRegular +
                '}';
        }
    }
