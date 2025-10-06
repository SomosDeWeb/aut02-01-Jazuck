package org.example;

import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

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

    private static int leerEntero(String mensaje){
        Scanner sc = new Scanner(System.in);
        int numero;

        while (true) {
            System.out.print(mensaje);
            try {
                numero = Integer.parseInt(sc.nextLine());
                return numero;
            } catch (NumberFormatException e) {
                System.out.println("Introduzca un número válido.");
            }
        }
    }

    private static void aniadirEstudiante() {}
    private static void listarEstudiantes() {}
    private static void buscarNombre() {}
    private static void calcularMedia() {}
    private static void mejorEstudiante() {}
}