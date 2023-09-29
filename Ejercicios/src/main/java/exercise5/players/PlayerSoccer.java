package exercise5.players;

import javax.swing.JOptionPane;

public class PlayerSoccer extends Player {

    private final String skillfulLeg;
    private final int ShootingPower;
    private final boolean dribble;
    private final int passingPercentage;

    public PlayerSoccer(String name, String lastname, String birthdate, long identifi, double weight, double height, double speed, String skillfulLeg, int ShootingPower, boolean dribble, int passingPercentage) {
        super(name, lastname, birthdate, identifi, weight, height, speed);
        this.skillfulLeg = skillfulLeg;
        this.ShootingPower = ShootingPower;
        this.dribble = dribble;
        this.passingPercentage = passingPercentage;
    }

    @Override
    public void score() {

        String howScore
                = """
                ¿Como realizar una anotación (gol)?
                  
                En el f\u00fatbol, un jugador anota un gol al introducir el bal\u00f3n en la porter\u00eda del equipo contrario. 
                Esto se puede lograr de varias maneras, pero generalmente involucra disparar el bal\u00f3n con los pies hacia la porter\u00eda. 
                Los jugadores pueden utilizar diferentes t\u00e9cnicas, como tiros de larga distancia, 
                tiros de cabeza o tiros rasos desde cerca del arco, dependiendo de la situaci\u00f3n y la ubicaci\u00f3n en el campo.
                """;

        String requirement = """
                             
                             ¿Que se requiere para anotar un gol?
                             
                             Para anotar en un partido de f\u00fatbol, generalmente se requiere lo siguiente:
                             
                             - Control del bal\u00f3n: Los jugadores deben ser capaces de controlar el bal\u00f3n con sus pies, muslos, pecho u otras partes permitidas del cuerpo.
                             - Habilidad de disparo: Los jugadores deben tener la capacidad de disparar con precisi\u00f3n y fuerza hacia la porter\u00eda.
                             - Oportunidad: Deben estar en una posici\u00f3n adecuada para recibir un pase o un rebote que les permita disparar a la porter\u00eda contraria.
                             - Destrezas t\u00e1cticas: Comprender las estrategias del equipo, aprovechar las oportunidades de juego y colaborar con los compa\u00f1eros de equipo tambi\u00e9n es esencial.""";

        JOptionPane.showMessageDialog(null, howScore + requirement, "Jugador de futbol", 1);
    }

    @Override
    public void infoPlayer() {

        String knowIfKnowDribbling = this.dribble ? "Si" : "No";

        String infoPlayerShow = "Nombre del jugador: " + super.getName() + " " + super.getLastname() + "\n"
                + "Pierna habil: " + this.skillfulLeg + "\n"
                + "Potencia de tiro: " + this.ShootingPower + "\n"
                + "Dribling: " + knowIfKnowDribbling + "\n"
                + "Porcentaje de pases: " + this.passingPercentage + "%" + "\n";

        JOptionPane.showMessageDialog(null, infoPlayerShow, "Información jugador de futbol", 2);

    }

}
