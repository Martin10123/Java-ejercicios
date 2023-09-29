package exercise2.Vehicle;

public class Motorbike extends Vehicle {

    public Motorbike(String brand, int model, String color, String faultDetected, String ownerName, String ownerAddress, long ownerPhone) {
        super(brand, model, color, faultDetected, ownerName, ownerAddress, ownerPhone);
    }

    @Override
    public String isTheSameBrandByObject(Vehicle motorbike1, Vehicle motorbike2) {
        if (motorbike1.getBrand().equals(motorbike2.getBrand())) {
            return ("Las motos SI son de la misma marca");
        } else {
            return ("Las motos NO son de la misma marca");
        }
    }

}
