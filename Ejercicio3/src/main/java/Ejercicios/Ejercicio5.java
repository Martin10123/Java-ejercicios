package Ejercicios;

import java.util.Scanner;

// Este ejercicio fue un examen que nos pusieron en python en primer semetre
// Se base en categorizar peliculas y saber la fecha de estreno, que tipo de pelicula es y cuantos dias puedes 
// alquilarla depende de la cantidad en inventario y de su año

public class Ejercicio5 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Ingrese el nombre de la pelicula: ");
        String movieName = entrada.nextLine();

        System.out.print("Ingrese el año de lanzamiento de la pelicula: ");
        int movieYearPremier = entrada.nextInt();

        System.out.print("Ingrese la cantidad de inventario de la pelicula: ");
        int movieInvent = entrada.nextInt();

        int movieYearCurrent = 2023;
        int movieYearRelease = movieYearCurrent - movieYearPremier;

        if (movieYearPremier < 0) {
            
            System.out.println("El año ingresado no es valido");
            
        } else if (movieInvent < 0) {
            
            System.out.println("La cantidad de inventario ingresada no es valido");
            
        } else if (movieYearRelease == 0) {
            
            System.out.println("La pelicula " + movieName
                    + "esta en estreno, solo la puedes rentar por 1 dia");
            
        } else if (movieYearRelease >= 1 && movieYearRelease <= 5 && movieInvent >= 7) {
            
            System.out.println("La pelicula " + movieName + " tiene " + movieYearRelease
                    + " años de estreno y la cantidad en inventario es de " + movieInvent + "(Normal)"
                    + " asi que la puedes alquilar por 3 dias");
            
        } else if (movieYearRelease >= 1 && movieYearRelease <= 5 && movieInvent < 7) {
            
            System.out.println("La pelicula " + movieName + " tiene " + movieYearRelease
                    + " años de estreno y la cantidad en inventario es de " + movieInvent + "(Normal)"
                    + " asi que la puedes alquilar por 2 dias");
            
        } else if (movieYearRelease > 5 && movieInvent >= 7) {
            
            System.out.println("La pelicula " + movieName + " tiene " + movieYearRelease
                    + " años de estreno y la cantidad en inventario es de " + movieInvent + "(Clásico)"
                    + " asi que la puedes alquilar por 5 dias");
            
        } else if (movieYearRelease > 5 && movieInvent < 7) {
            
            System.out.println("La pelicula " + movieName + " tiene " + movieYearRelease
                    + " años de estreno y la cantidad en inventario es de " + movieInvent + "(Clásico)"
                    + " asi que la puedes alquilar por 3 dias");
            
        } else {
            System.out.println("Que intentas hacer ?");
        }
    }
}
