package exercise1.Animal;

import java.util.Objects;

public class Gato extends Animal {

    public Gato(String type, String race, String name, int age, double weight, String color, String state) {
        super(type, race, name, age, weight, color, state);
    }

    @Override
    public String compareAnimals(Animal otherCat) {

        boolean isEqualsType = Objects.equals(this.type, otherCat.getType());
        boolean isEqualsRace = Objects.equals(this.race, otherCat.getRace());

        if (isEqualsRace && isEqualsType) {
            return "Los gatos SI son de la misma raza y el mismo tipo";
        } else {
            return "Los gatos NO son de la misma raza y el mismo tipo";
        }

    }

}
