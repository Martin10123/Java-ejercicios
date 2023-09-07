package Ejercicio1;

import Ejercicio1.Animal.*;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {

        Perro dog1 = new Perro("Perro", "Pastor aleman", "Scoot", 4, 25, "Blanco", "Sano");
        Perro dog2 = new Perro("Perro", "Pastor aleman", "Scoot 2", 6, 40, "Blanco y negro", "Enfermo");

        JOptionPane.showMessageDialog(null, dog1.compareAnimals(dog2), "COMPARA SI LOS PERROS SON DE LA MISMA RAZA Y TIPO", 1);
        JOptionPane.showMessageDialog(null, dog1.getQuantityAnalgesic(), "SABER CUANTO ANALGESICO DEBE SUMINISTRARLE", 1);
        JOptionPane.showMessageDialog(null, dog2.getAnimalInfo(), "INFORMACION DEL PERRO SI ESTA SANO O ENFERMO", 1);

        Gato cat1 = new Gato("Gato", "Gato callejero", "Miau1", 2, 25, "Blanco", "Sano");
        Gato cat2 = new Gato("Gato", "Gato de casa", "Miau2", 10, 40, "Blanco y negro", "Enfermo");

        JOptionPane.showMessageDialog(null, cat1.compareAnimals(cat2), "COMPARA SI LOS GATOS SON DE LA MISMA RAZA Y TIPO", 1);
        JOptionPane.showMessageDialog(null, cat1.getQuantityAnalgesic(), "SABER CUANTO ANALGESICO DEBE SUMINISTRARLE", 1);
        JOptionPane.showMessageDialog(null, cat2.getAnimalInfo(), "INFORMACION DEL GATO SI ESTA SANO O ENFERMO", 1);

    }

}
