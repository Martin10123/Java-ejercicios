package Ejercicio2.Vehicle;

public class Car extends Vehicle {

    public Car(String brand, int model, String color, String faultDetected, String ownerName, String ownerAddress, long ownerPhone) {
        super(brand, model, color, faultDetected, ownerName, ownerAddress, ownerPhone);
    }

    @Override
    public String isTheSameBrandByObject(Vehicle car1, Vehicle car2) {
        if (car1.getBrand().equals(car2.getBrand())) {
            return ("Los carros SI son de la misma marca");
        } else {
            return ("Los carros NO son de la misma marca");
        }
    }

}
