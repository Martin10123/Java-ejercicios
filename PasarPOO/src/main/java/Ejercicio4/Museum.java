package Ejercicio4;

public class Museum {

    private String type;             // tipo de la obra
    private int creationYear;        // año de creación de la obra
    private String author;           // autor de la obra
    private String material;         // material de la obra
    private double height;           // altura de la obra
    private double weight;           // peso de la obra
    private double width;            // ancho de la obra
    private double diameter;         // diámetro de la obra
    private double thickness;        // espesor de la obra
    private double commercialValue;  // valor comercial de la obra
    private double historicalValue;  // valor histórico de la obra
    private String description;      // descripción de la obra
    private String titleOfWork;      // título de la obra

    public Museum(String type, int creationYear, String author, String material, double height, double weight, double width, double diameter, double thickness, double commercialValue, double historicalValue, String description, String titleOfWork) {
        this.type = type;
        this.creationYear = creationYear;
        this.author = author;
        this.material = material;
        this.height = height;
        this.weight = weight;
        this.width = width;
        this.diameter = diameter;
        this.thickness = thickness;
        this.commercialValue = commercialValue;
        this.historicalValue = historicalValue;
        this.description = description;
        this.titleOfWork = titleOfWork;
    }

    public double calculateSpace() {
        return this.height * this.width * this.thickness;
    }

    public String determineSeniority() {
        int year = 2023 - this.creationYear;

        if (year < 10) {
            return "Contemporáneo";
        } else if (year >= 10 && year < 30) {
            return "Arte Moderno";
        } else if (year >= 30 && year <= 100) {
            return "Antiguo";
        } else {
            return "Reliquia";
        }
    }

    public String getInformation() {
        String antiquity = determineSeniority();

        if (antiquity.equals("Contemporáneo")) {
            return this.titleOfWork.substring(0, 1).toUpperCase() + this.titleOfWork.substring(1) + ": " + this.description.toLowerCase();
        } else if (antiquity.equals("Reliquia")) {
            return this.author + ", " + this.titleOfWork.toUpperCase() + " - " + this.material;
        } else {
            return "Información no disponible para esta antigüedad.";
        }
    }

}
