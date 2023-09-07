package Main;

import Caracter.Caracter;

public class Ocurrencias {

    static Caracter menuCaracter = new Caracter();

    public static void main(String[] args) {
        String parrafo = "Hola mundo 423 fdskfdsl .-,.-.-".toLowerCase().trim().replace(" ", "");;

        for (int i = 0; i < parrafo.length(); i++) {

            menuCaracter.agregarLetra(parrafo.charAt(i), i);
        }

        menuCaracter.sumarNumeroCoincidencias();
        menuCaracter.eliminarElementosRepetidos();
        menuCaracter.mostrarLetrasSinRepetir();
    }
}
