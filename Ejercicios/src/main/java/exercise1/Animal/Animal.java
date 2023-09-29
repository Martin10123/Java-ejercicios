package exercise1.Animal;

public abstract class Animal {

    protected String type;
    protected String race;
    protected String name;
    protected int age;
    protected double weight;
    protected String color;
    protected String state;

    public Animal(String type, String race, String name, int age, double weight, String color, String state) {
        this.type = type;
        this.race = race;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = color;
        this.state = state;
    }

    public String getQuantityAnalgesic() {
        String quantityRecommend;

        if (this.weight < 10) {
            quantityRecommend = "5cc";
        } else if (this.weight >= 10 && this.weight <= 20) {
            quantityRecommend = "8cc";
        } else if (this.weight >= 20 && this.weight <= 30) {
            quantityRecommend = "12cc";
        } else {
            quantityRecommend = "15cc";
        }

        return name + " puedes suministrarle la cantidad de " + quantityRecommend + " analgesicos.";

    }

    public String getAnimalInfo() {
        StringBuilder info = new StringBuilder();

        if (this.state.equals("Sano")) {

            info.append("Nombre: ").append(this.name.toUpperCase()).append("\nRaza: ").append(this.race)
                    .append("\nTipo: ").append(this.type)
                    .append("\nAños: ").append(this.age);
        } else if (this.state.equals("Enfermo")) {

            String nameWithFirstLetterUpperCase = this.name.substring(0, 1).toUpperCase() + this.name.substring(1).toLowerCase();

            info.append("Nombre: ").append(nameWithFirstLetterUpperCase).append("\nTipo: ").append(this.type)
                    .append("\nAños: ").append(this.age)
                    .append("\nPeso: ").append(this.weight)
                    .append("\nColor: ").append(this.color);
        }

        return info.toString();
    }

    public abstract String compareAnimals(Animal animal);

    public String getType() {
        return type;
    }

    public String getRace() {
        return race;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public String getState() {
        return state;
    }

}
