package exercise5.players;

public abstract class Player {

    private String name;
    private String lastname;
    private String birthdate;
    private long identifi;
    private double weight;
    private double height;
    private double speed;

    protected abstract void score();
    protected abstract void infoPlayer();

    public Player(String name, String lastname, String birthdate, long identifi, double weight, double height, double speed) {
        this.name = name;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.identifi = identifi;
        this.weight = weight;
        this.height = height;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public long getIdentifi() {
        return identifi;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public double getSpeed() {
        return speed;
    }

}
