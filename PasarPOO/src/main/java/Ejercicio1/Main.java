package Ejercicio1;

public class Main {

    public static void main(String[] args) {

        Animal perro = new Animal("Perro", "Labrador", "Max", 3, 15.5, "Negro", "Sano");
        Animal gato = new Animal("Gato", "Siames", "Luna", 2, 6.8, "Blanco", "Enfermo");

        System.out.println(perro.esMismaRazaYTipo(gato));

        System.out.println("Dosis de analgésico para perro: " + perro.calcularAnalgésico());
        System.out.println("Dosis de analgésico para gato: " + gato.calcularAnalgésico());

        System.out.println("Información del perro: " + perro.obtenerInformacion());
        System.out.println("Información del gato: " + gato.obtenerInformacion());

    }

}
