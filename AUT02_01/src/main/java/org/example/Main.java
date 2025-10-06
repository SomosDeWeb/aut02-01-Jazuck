package org.example;

import java.util.ArrayList;
import java.util.Scanner;
import java.text.DecimalFormat;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static Scanner sc = new Scanner(System.in);

    static class Estudiante {
        private String nombre;
        private int edad;
        private double notaMedia;
        private boolean matriculado;

        public Estudiante(String nombre, int edad, double notaMedia, boolean matriculado) {
            this.nombre = nombre;
            this.edad = edad;
            this.notaMedia = notaMedia;
            this.matriculado = matriculado;
        }

        public String getNombre() {
            return nombre;
        }

        public int getEdad() {
            return edad;
        }

        public double getNotaMedia() {
            return notaMedia;
        }

        public boolean getMatriculado() {
            return matriculado;
        }

        @Override
        public String toString() {
            String estado = matriculado ? "Si" : "No";
            return nombre
                    + "\n — Edad: " + edad
                    + "\n — Nota: " + notaMedia
                    + "\n — Matriculado: " + estado;
        }
    }

    private static ArrayList<Estudiante> estudiantesList = new ArrayList<>();

    public static void main(String[] args) {

        estudiantesList.add(new Estudiante("Ana", 20, 8.5, true));
        estudiantesList.add(new Estudiante("Luis", 18, 9.5, false));
        estudiantesList.add(new Estudiante("María", 19, 5.5, true));

        System.out.println("=== GESTOR DE ESTUDIANTES ===");
        boolean continuar = true;
        int opcion;

        do{
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    aniadirEstudiante();
                    break;
                case 2:
                    listarEstudiantes();
                    break;
                case 3:
                    buscarNombre();
                    break;
                case 4:
                    calcularMedia();
                    break;
                case 5:
                    mejorEstudiante();
                    break;
                case 6:
                    continuar = false;
                    System.out.println("Has salido del programa...");
                    sc.close();
                    break;
                default:
                    System.out.println("Opción inválida, intente de nuevo.");
            }
        }while (continuar);
    }

    private static void mostrarMenu() {
        System.out.println("1. Añadir estudiante");
        System.out.println("2. Listar estudiantes");
        System.out.println("3. Buscar por nombre");
        System.out.println("4. Calcular nota media general");
        System.out.println("5. Mostrar mejor estudiante");
        System.out.println("6. Salir");
    }

    private static void aniadirEstudiante() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        int edad = leerEntero("Edad: ");
        double notaMedia = leerDouble("Nota: ");
        boolean matriculado = comprobarMatriculado();

        estudiantesList.add(new Estudiante(nombre, edad, notaMedia, matriculado));
        System.out.println("Estudiante añadido correctamente.");
    }

    private static int leerEntero(String mensaje){
        int numero;

        do{
            System.out.print(mensaje);
            try {
                numero = Integer.parseInt(sc.nextLine());
                return numero;
            } catch (NumberFormatException e) {
                System.out.println("Introduzca un número válido.");
            }
        }while (true);
    }

    private static double leerDouble(String mensaje) {
        double numero;
        while (true) {
            System.out.print(mensaje);
            try {
                numero = Double.parseDouble(sc.nextLine());
                return numero;
            } catch (NumberFormatException e) {
                System.out.println("Introduzca un número válido (usa punto).");
            }
        }
    }

    private static boolean comprobarMatriculado(){
        boolean respuestaValida = false;
        boolean matriculado = false;

        do {
            System.out.print("¿Está matriculado? (si/no): ");
            String respuesta = sc.nextLine().trim().toLowerCase();

            if (respuesta.equals("si")) {
                matriculado = true;
                respuestaValida = true;
            } else if (respuesta.equals("no")) {
                matriculado = false;
                respuestaValida = true;
            } else {
                System.out.println("Incorrecto. Debe escribir 'si' o 'no'.");
            }

        } while (!respuestaValida);

        return matriculado;
    }

    private static void listarEstudiantes() {
        System.out.println("\n=== LISTA DE ESTUDIANTES ===");
        if (estudiantesList.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }

        for (Estudiante e : estudiantesList) {
            System.out.println(e);
            System.out.println("------------------------");
        }
    }

    private static void buscarNombre() {
        System.out.print("Introduzca nombre del estudiante: ");
        String nombreBusqueda = sc.nextLine().trim().toLowerCase();

        boolean busqueda = false;

        for (Estudiante e : estudiantesList) {
            if (e.getNombre().toLowerCase().contains(nombreBusqueda)) {
                System.out.println("Estudiante encontrado:\n" + e);
                busqueda = true;
            }
        }

        if (!busqueda) {
            System.out.println("No se encontró ese nombre.");
        }
    }

    private static void calcularMedia() {

        double notaMediaGlobal=0;

        for (Estudiante e : estudiantesList) {
            notaMediaGlobal+= e.getNotaMedia();
        }

        notaMediaGlobal= notaMediaGlobal/estudiantesList.size();
        System.out.printf("Nota media general: %.2f%n", notaMediaGlobal);
    }
    private static void mejorEstudiante() {
        if (estudiantesList.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }

        Estudiante masNota = estudiantesList.get(0);
        for (Estudiante e : estudiantesList) {
            if (e.getNotaMedia() > masNota.getNotaMedia()) {
                masNota = e;
            }
        }

        System.out.println("Estudiante con la mejor nota: \n" + masNota);
        
    }
}
