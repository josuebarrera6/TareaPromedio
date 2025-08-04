package org.example;

import java.util.Scanner;

public class Promedio {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);


        System.out.print("¿Cuántos estudiantes quieres registrar? (máximo 5): ");
        int cantidad = teclado.nextInt();

        if (cantidad > 5) {
            cantidad = 5;
            System.out.println("Solo puedes registrar máximo 5.");
        }


        String[] nombres = new String[5];
        double[] nota1 = new double[5];
        double[] nota2 = new double[5];
        double[] nota3 = new double[5];
        double[] promedios = new double[5];


        for (int i = 0; i < cantidad; i++) {
            System.out.println("\n--- Estudiante " + (i + 1) + " ---");


            System.out.print("Nombre: ");
            teclado.nextLine();
            nombres[i] = teclado.nextLine();


            System.out.print("Nota 1: ");
            nota1[i] = teclado.nextDouble();

            System.out.print("Nota 2: ");
            nota2[i] = teclado.nextDouble();

            System.out.print("Nota 3: ");
            nota3[i] = teclado.nextDouble();


            promedios[i] = calcularPromedio(nota1[i], nota2[i], nota3[i]);
        }


        mostrarResumen(nombres, promedios, cantidad);

        teclado.close();
    }


    public static double calcularPromedio(double n1, double n2, double n3) {
        return (n1 + n2 + n3) / 3;
    }


    public static boolean aprobo(double promedio) {
        if (promedio >= 61) {
            return true;
        } else {
            return false;
        }
    }


    public static void mostrarResumen(String[] nombres, double[] promedios, int cantidad) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("Resumen de estudiantes:");
        System.out.println("-".repeat(50));

        for (int i = 0; i < cantidad; i++) {
            System.out.print("Nombre: " + nombres[i]);
            System.out.print("    Promedio: " + String.format("%.2f", promedios[i]));

            if (aprobo(promedios[i])) {
                System.out.println("    Estado: Aprobado");
            } else {
                System.out.println("    Estado: Reprobado");
            }
        }

        System.out.println("=".repeat(50));
    }
}