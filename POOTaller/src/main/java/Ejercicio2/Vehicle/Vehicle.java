package Ejercicio2.Vehicle;

public abstract class Vehicle {

    private String brand;          // Marca
    private int model;             // Modelo
    private String color;          // Color
    private String faultDetected;  // Falla detectada
    private String ownerName;      // Nombre del Propietario
    private String ownerAddress;   // Dirección del Propietario
    private long ownerPhone;       // Teléfono del Propietario

    public Vehicle(String brand, int model, String color, String faultDetected, String ownerName, String ownerAddress, long ownerPhone) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.faultDetected = faultDetected;
        this.ownerName = ownerName;
        this.ownerAddress = ownerAddress;
        this.ownerPhone = ownerPhone;
    }

    public String informacionByModel() {

        StringBuilder info = new StringBuilder();

        int knowCurrentModel = 2023 - this.model;

        if (knowCurrentModel >= 5) {

            info.append("Marca: ").append(this.brand)
                    .append("\nNombre del Propietario: ").append(this.ownerName)
                    .append("\nfalla detectada: ").append(this.faultDetected);

        } else if (knowCurrentModel < 5 && knowCurrentModel > 2) {

            info.append("\nNombre del Propietario: ").append(this.ownerName)
                    .append("\nfalla detectada: ").append(this.faultDetected.toUpperCase())
                    .append("\nModelo: ").append(this.model);

        } else if (knowCurrentModel <= 2) {

            info.append("\nMarca: ").append(this.brand)
                    .append("\nfalla detectada: ").append(this.faultDetected);

        }

        return (info.toString());
    }

    public abstract String isTheSameBrandByObject(Vehicle vehicle1, Vehicle vehicle2);

    public String isSameBrand(String brandOtherVehicle) {

        StringBuilder info = new StringBuilder();

        if (this.brand.equals(brandOtherVehicle)) {

            info.append("ES IGUAL AL DE LA INSTANCIA")
                    .append("\nModelo: ").append(this.model)
                    .append("\nColor: ").append(this.color.toUpperCase());
        } else {
            return ("Objeto no pertenece a la marca suministrada");
        }

        return info.toString();

    }

    public String getBrand() {
        return brand;
    }

    public int getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public String getFaultDetected() {
        return faultDetected;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getOwnerAddress() {
        return ownerAddress;
    }

    public long getOwnerPhone() {
        return ownerPhone;
    }

}
