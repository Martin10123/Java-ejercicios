package exercise1.Animal;

import java.util.Objects;

public class Perro extends Animal {

    public Perro(String type, String race, String name, int age, double weight, String color, String state) {
        super(type, race, name, age, weight, color, state);
    }

    @Override
    public String compareAnimals(Animal otherDog) {

        boolean isEqualsType = Objects.equals(this.type, otherDog.getType());
        boolean isEqualsRace = Objects.equals(this.race, otherDog.getRace());

        if (isEqualsRace && isEqualsType) {
            return "Los perros SI son de la misma raza y el mismo tipo";
        } else {
            return "Los perros NO son de la misma raza y el mismo tipo";
        }

    }

}
