package exercise5.players;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class PlayerBasketball extends Player {

    private int twoPoint;
    private int threePoint;
    private String saltability;
    private int foults;
    private int assist;

    public PlayerBasketball(String name, String lastname, String birthdate, long identifi, double weight, double height, double speed, int twoPoint, int threePoint, String saltability, int foults, int assist) {
        super(name, lastname, birthdate, identifi, weight, height, speed);
        this.twoPoint = twoPoint;
        this.threePoint = threePoint;
        this.saltability = saltability;
        this.foults = foults;
        this.assist = assist;
    }

    @Override
    public void score() {
        String howScore
                = """
                ¿Como realizar una anotación (canasta)?
                  
                En el baloncesto, un jugador anota puntos al lanzar la pelota a través del aro del equipo contrario. 
                Hay varias formas de hacer esto, como tiros libres, tiros de campo y tiros de tres puntos. Los jugadores 
                también pueden anotar puntos al realizar mates, que implican volcar la pelota en el aro después de un salto.
                La cantidad de puntos que se otorgan varía según la distancia y las circunstancias del tiro.
                """;

        String requirement = """
                             
                            ¿Que se requiere para anotar una canasta?
                             
                            Para anotar en un partido de baloncesto, se requiere lo siguiente:
                             
                            - Habilidad de dribbling: Los jugadores deben ser capaces de controlar y driblar la pelota mientras se mueven por la cancha.
                            - Tiro preciso: Deben tener la capacidad de realizar tiros precisos desde diferentes distancias, incluyendo tiros libres, tiros de campo y tiros de tres puntos.
                            - Conocimiento del juego: Entender las estrategias del equipo, moverse en la cancha para encontrar oportunidades de tiro y trabajar en conjunto con los compañeros de equipo es fundamental.
                            - Agilidad y capacidad atlética: Los jugadores necesitan la agilidad, la velocidad y la capacidad atlética para superar a los defensores y llegar al aro con eficacia.
                             """;

        JOptionPane.showMessageDialog(null, howScore + requirement, "Jugador de basketbol", 1);
    }

    @Override
    public void infoPlayer() {

        DecimalFormat decimalFormatquality = new DecimalFormat("###,###.###");

        String infoPlayerShow = "Nombre del jugador: " + super.getName() + " " + super.getLastname() + "\n"
                + "Asistencias: " + decimalFormatquality.format(this.assist) + "\n"
                + "punto de 3: " + decimalFormatquality.format(this.threePoint) + "\n"
                + "punto de 2: " + decimalFormatquality.format(this.twoPoint) + "\n";

        JOptionPane.showMessageDialog(null, infoPlayerShow, "Información jugador de basketbol", 2);
    }

}
