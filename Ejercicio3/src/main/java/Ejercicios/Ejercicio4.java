package Ejercicios;

import java.util.Scanner;

// Aplicación que te genera un descuento depende la cantidad de articulo que compres

public class Ejercicio4 {

    public static void main(String[] args) {

        double costoArticulo;
        double descuento;
        int cantidad;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduzca el costo del artículo: ");
        costoArticulo = scanner.nextDouble();
        System.out.println("Introduzca la cantidad de artículos: ");
        cantidad = scanner.nextInt();

        double total = costoArticulo * cantidad;
        if (cantidad <= 5) {
            descuento = total * 0.05;
            System.out.println("Se le aplicará un descuento del 5%");
        } else if (cantidad <= 10) {
            descuento = total * 0.10;
            System.out.println("Se le aplicará un descuento del 10%");
        } else if (cantidad <= 20) {
            descuento = total * 0.15;
            System.out.println("Se le aplicará un descuento del 15%");
        } else if (cantidad <= 30) {
            descuento = total * 0.20;
            System.out.println("Se le aplicará un descuento del 20%");
        } else {
            descuento = 0;
            System.out.println("No se le aplicará descuento");
        }

        System.out.println("Valor del descuento: " + descuento);
    }

}
