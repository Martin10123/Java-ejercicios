package exercise4;

import javax.swing.JOptionPane;

public class MainMuseum {

    public static void main(String[] args) {

        Museum pintura1 = new Museum("Pintura", 1800, "Martin Elias", "Lienzo",
                100, 5, 80, 300, 200, 100000, 50000,
                "Un hermoso paisaje", "Atardecer sobre las montañas");

        Museum pintura2 = new Museum("Pintura", 2000, "Artista 1", "Lienzo",
                100, 5, 80, 100, 100, 100000, 50000,
                "Un hermoso paisaje", "Atardecer sobre las montañas");

        StringBuilder infoPaint = new StringBuilder();

        infoPaint.append("Pintura #1")
                .append("\n\n")
                .append("El espacio requerido para su ubicaciòn es de: ").append(pintura1.calculateSpace())
                .append("\n\n")
                .append("La antiguedad de la obra es: ").append(pintura1.determineSeniority())
                .append("\n\n")
                .append("Informaciòn de la obra: ").append(pintura1.getInformation())
                .append("\n\n")
                .append("Pintura #2")
                .append("\n\n")
                .append("El espacio requerido para su ubicaciòn es de: ").append(pintura2.calculateSpace())
                .append("\n\n")
                .append("La antiguedad de la obra es: ").append(pintura2.determineSeniority())
                .append("\n\n")
                .append("Informaciòn de la obra: ").append(pintura2.getInformation());

        JOptionPane.showMessageDialog(null, infoPaint.toString(), "Informaciòn de las pinturas", 1);

    }
}
