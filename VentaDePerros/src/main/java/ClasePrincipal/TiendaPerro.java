package ClasePrincipal;

import SubClases.Perro;
import SubClases.MenuDePerro;
import java.util.Scanner;

public class TiendaPerro {
    
    static MenuDePerro tenerTodosLosMetodos = new MenuDePerro();

    public static void main(String[] args) {
        
        

        System.out.println("Bienvenidos a mi aplicación");
        System.out.println("1. Agregar un nuevo perro");

        Scanner s = new Scanner(System.in);
        

        System.out.println("Ingrese una opción: ");
        byte option = s.nextByte();

        if (option == 1) {
           

            System.out.println("Cuantos perros deseas ingresar: ");
            int cuantosPerros = s.nextInt();
            
            while (cuantosPerros <= 0) {
                
                System.out.println("Cuantos perros deseas ingresar: ");
                cuantosPerros = s.nextInt();
                
            }

            int contador = 1;

            while (contador <= cuantosPerros) {

                s.nextLine();
                
                System.out.println("Ingrese la raza del perro " + (contador));
                String raza = s.nextLine();

                System.out.println("Ingrese el color del perro " + (contador));
                String color = s.nextLine();

                System.out.println("Ingrese la edad del perro " + (contador));
                int edad = s.nextInt();

                System.out.println("Ingrese el precio del perro " + (contador));
                int precio = s.nextInt();

                System.out.println("Ingrese el nombre del perro " + (contador));
                String nombre = s.nextLine();
                
                Perro nuevoPerroCreado = new Perro(raza, color, edad, precio, nombre);
                
                tenerTodosLosMetodos.AgregarUnNuevoPerro(nuevoPerroCreado);
                
                contador++;

            }
        } else {
            System.out.println("Saliste");
        }

        
        System.out.println("Todos los objetos " + tenerTodosLosMetodos.obtenerTodosLosPerros());
    }
}
