package Ejercicio3;

public class Plant {

    private String code;             // Código
    private double height;           // Altura
    private double neckDiameter;     // Diámetro de cuello
    private double rootVolume;       // Volumen de raíz
    private String scientificName;   // Nombre Científico
    private String commonName;       // Nombre Popular
    private String leafColor;        // Color Hojas
    private String type;             // Tipo

    public Plant(String code, double height, double neckDiameter, double rootVolume, String scientificName, String commonName, String leafColor, String type) {
        this.code = code;
        this.height = height;
        this.neckDiameter = neckDiameter;
        this.rootVolume = rootVolume;
        this.scientificName = scientificName;
        this.commonName = commonName;
        this.leafColor = leafColor;
        this.type = type;
    }

    public String showMoreInformationPlant() {

        StringBuilder info = new StringBuilder();

        info.append("Codigo: ").append(this.code).append(" : ").append("Nombre Científico: ").append(this.scientificName)
                .append("\n")
                .append(String.format("%35s Nombre Popular: %-20s%n", " ", this.commonName))
                .append(String.format("%35s Altura: ", "")).append(this.height)
                .append(", Diámetro de cuello: ").append(this.neckDiameter)
                .append(", Volumen de raíz: ").append(this.rootVolume)
                .append(", Color Hojas: ").append(this.leafColor)
                .append(", Tipo: ").append(this.type);

        return info.toString();

    }
    
    public String showLessInformationPlant() {

        StringBuilder info = new StringBuilder();

        info.append("Codigo: ").append(this.code).append(" : ").append("Nombre Popular: ").append(this.commonName)
                .append("\n")
                .append("------------------------------------------------------------")
                .append("\n")
                .append(String.format("%35s Color Hojas: ", "")).append(this.leafColor)
                .append(", Tipo: ").append(this.type);

        return info.toString();

    }

    public String showMessageDependsHeight() {

        if (this.height > 200) {
            return "Su altura es de: " + this.height + "cm. PARA EXTERIORES";
        } else {
            return "Su altura es de: " + this.height + "cm. PARA INFERIORES";
        }

    }

}
