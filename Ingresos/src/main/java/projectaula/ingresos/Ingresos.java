package projectaula.ingresos;

import ClaseIngreso.IngresoPersonal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Ingresos {
    
    /* 
        Nombre de la app: Manejo de presupuesto personal 
        Resumen: Esta es una app que maneja el presupuesto personal de las personas, permite brindar un resumen de su presupuesto
                 tiene la opción de ingresar tus ingresos, tus gastos, te deja ver el resumen de total de tus gastos, el resumen
                 total de tus ingresos, fecha cuando la ingresaste y el saldo restante. 
                 Tienes la opción de eliminar todo el resumen general o de eliminar uno solo por id.
    */

    static ArrayList<IngresoPersonal> dataIngresos = new ArrayList<>();

    public static void main(String[] args) {

        Date fechaActual = new Date();
        String nombre = "Martin Elias";

        Scanner s = new Scanner(System.in);

        System.out.println("***** Bienvenidos al menu principal *****\n");
        System.out.println("1. Ingresar sus ingresos");
        System.out.println("2. Ver resumen de cuenta");
        System.out.println("3. Eliminar uno en especifico");
        System.out.println("4. Eliminar todo el resumen");
        System.out.println("0. Salir");

        System.out.print("\nElegir opción: ");

        // pedimos al usuario que elija una Opción
        byte option = s.nextByte();

        while (option < 0 || option > 4) {
            System.out.println();
            System.out.print("Este número no se encuentra, elija otro: ");

            option = s.nextByte();
            System.out.println();
        }

        while (option != 0) {

            if (option == 1) {

                System.out.print("Ingrese su ingreso: ");
                int ingreso = s.nextInt();

                System.out.print("Ingrese su gasto: ");
                int gasto = s.nextInt();

                IngresoPersonal ingresoPerso = new IngresoPersonal(dataIngresos.size() + 1, nombre, ingreso, gasto, fechaActual.toString());

                dataIngresos.add(ingresoPerso);

            } else if (option == 2) {

                int totalIngreso = 0;
                int totalGasto = 0;
                int teQuedan = 0;

                if (!dataIngresos.isEmpty()) {
                    for (IngresoPersonal data : dataIngresos) {
                        totalIngreso += data.getIngreso();
                        totalGasto += data.getGasto();
                        teQuedan = totalIngreso - totalGasto;

                        System.out.println("IdDoc: " + data.getIdDoc());
                        System.out.println("Nombre: " + data.getNombre());
                        System.out.println("Ingreso: " + data.getIngreso());
                        System.out.println("Gasto: " + data.getGasto());
                        System.out.println("Fecha: " + data.getFecha());
                        System.out.println("Total ingresos: " + totalIngreso);
                        System.out.println("Total gastos: " + totalGasto);
                        System.out.println("En total te quedan: " + teQuedan);
                        System.out.println("");
                    }
                } else {
                    System.out.println("");
                    System.out.println("No hay datos ingresados aún");
                    System.out.println("");
                }

            }  else if (option == 3) {
                
                for (IngresoPersonal data : dataIngresos) {
                      System.out.println("IdDoc: " + data.getIdDoc());
                      System.out.println("Nombre: " + data.getNombre());
                      System.out.println("Ingreso: " + data.getIngreso());
                      System.out.println("Gasto: " + data.getGasto());
                      System.out.println("Fecha: " + data.getFecha());
                      System.out.println("");
                }
                
                System.out.print("Ingrese su el idDoc que quiere eliminar: ");
                int datoaEliminar = s.nextInt();

                for (int i = 0; i < dataIngresos.size(); i++) {

                    if (dataIngresos.get(i).getIdDoc() == datoaEliminar) {
                        System.out.println("Se esta eliminando la información...");

                        System.out.println();
                        System.out.println("Se esta eliminando el siguiente array...");
                        System.out.println();
                        System.out.println(dataIngresos.get(i).toString());
                        System.out.println();

                        dataIngresos.remove(i);
                        System.out.println("Se elimino correctamente el dato seleccionado");

                    } else {
                        System.out.println();
                        System.out.println("Ese id no se encuentra en la lista, intentalo otra vez");
                        System.out.println();
                    }

                }
            } else if (option == 4) {

                dataIngresos.clear();

            }

            System.out.println("***** Bienvenidos al menu principal *****\n");
            System.out.println("1. Ingresar sus ingresos");
            System.out.println("2. Ver resumen de cuenta");
            System.out.println("3. Eliminar uno en especifico");
            System.out.println("4. Eliminar todo el resumen");
            System.out.println("0. Salir");

            System.out.print("\nElegir opción: ");

            // pedimos al usuario que elija una Opción
            option = s.nextByte();

            while (option < 0 || option > 4) {
                System.out.println();
                System.out.print("Este número no se encuentra, elija otro: ");

                option = s.nextByte();
                System.out.println();
            }
        }

    }

}
