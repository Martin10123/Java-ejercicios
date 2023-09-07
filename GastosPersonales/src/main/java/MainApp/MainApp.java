package MainApp;

import java.util.ArrayList;
import java.util.Scanner;
import ClaseIngreso.IngresoPersonal;
import java.util.Date;

public class MainApp {

    static ArrayList<IngresoPersonal> dataIngresos = new ArrayList<>();

    static void personalExpensesMenu() {
        Scanner s = new Scanner(System.in);

        System.out.println("1. Ingresar ingresos");
        System.out.println("2. Ingresar gastos");
        System.out.println("3. Resumen de presupuesto");
        System.out.println("0. Cerrar");

        System.out.println("Ingrese su opción");
        byte option = s.nextByte();

        while (option < 0 || option > 4) {
            System.out.println();
            System.out.print("Este número no se encuentra, elija otro: ");

            option = s.nextByte();
            System.out.println();
        }

        Date fecha = new Date();
        String nombre = "Martin Elias";

        while (option != 0) {

            switch (option) {
                case 1:

                    System.out.print("Ingrese su ingreso: ");
                    int ingreso = s.nextInt();
                    
                    System.out.print("Ingrese su gasto: ");
                    int gasto = s.nextInt();

                    IngresoPersonal ingresoPerso = new IngresoPersonal(nombre, ingreso, gasto, fecha.getTime());

                    dataIngresos.add(ingresoPerso);

                case 2:

                    for (IngresoPersonal data : dataIngresos) {

                            System.out.println("+-----------+-----------+-----------+");
                            System.out.println("| Nombre | Ingreso | Gasto |  Fecha");
                            System.out.println("+-----------+-----------+-----------+");
                            System.out.println(data.getNombre() + data.getIngreso() + data.getGasto() + data.getFecha());
                            System.out.println("+-----------+-----------+-----------+");

                    }

                default:
                    break;
            }

            System.out.println("1. Ingresar ingresos");
            System.out.println("2. Ingresar gastos");
            System.out.println("3. Resumen de presupuesto");
            System.out.println("0. Cerrar");

            System.out.println("Ingrese su opción");
            option = s.nextByte();

            while (option < 0 || option > 4) {
                System.out.println();
                System.out.print("Este número no se encuentra, elija otro: ");

                option = s.nextByte();
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        personalExpensesMenu();
    }
}
