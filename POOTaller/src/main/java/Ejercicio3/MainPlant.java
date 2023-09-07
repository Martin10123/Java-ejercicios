package Ejercicio3;

import javax.swing.JOptionPane;

public class MainPlant {

    public static void main(String[] args) {
        Plant sunflower = new Plant("codigo123", 150, 20, 10, "Helianthus annuus", "Girasol", "Amarillo", "flor");
        Plant rose = new Plant("codigo456", 250, 40, 10, "Rosa sp", "Rosa", "blanca-roja", "flor");

        StringBuilder infoFlowers = new StringBuilder();

        infoFlowers.append("Flor #1 - Girasol")
                .append("\n\n")
                .append(sunflower.showMoreInformationPlant())
                .append("\n\n")
                .append(sunflower.showLessInformationPlant())
                .append("\n\n")
                .append(sunflower.showMessageDependsHeight())
                .append("\n\n")
                .append("Flor #2 - Rosa")
                .append("\n\n")
                .append(rose.showMoreInformationPlant())
                .append("\n\n")
                .append(rose.showLessInformationPlant())
                .append("\n\n")
                .append(rose.showMessageDependsHeight());

        JOptionPane.showMessageDialog(null, infoFlowers.toString(), "Informaciòn de la planta", 1);
    }

}
