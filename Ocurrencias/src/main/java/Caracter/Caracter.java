package Caracter;

import java.util.ArrayList;

public class Caracter {

    ArrayList<Letra> caracteres;

    public Caracter() {
        caracteres = new ArrayList<>();

    }

    public void agregarLetra(char letra, int posicion) {

        caracteres.add(new Letra(letra, 0, posicion));
    }

    public void sumarNumeroCoincidencias() {
        for (Letra element : caracteres) {
            for (Letra element2 : caracteres) {
                if (Character.compare(element.getLetra(), element2.getLetra()) == 0) {
                    element.setNumeroOcurrencias(element.getNumeroOcurrencias() + 1);
                }
            }
        }

    }

    public void eliminarElementosRepetidos() {
        for (int i = 0; i < caracteres.size(); i++) {

            for (int j = i + 1; j < caracteres.size(); j++) {
                if (Character.compare(caracteres.get(i).getLetra(), caracteres.get(j).getLetra()) == 0) {
                    caracteres.remove(j);
                    j--;
                }
            }
        }
    }

    public void mostrarLetrasSinRepetir() {
        for (Letra caractere : caracteres) {
            System.out.println(caractere.toString());
        }
    }
}
