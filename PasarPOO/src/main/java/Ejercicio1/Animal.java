package Ejercicio1;

public class Animal {

    private String tipo;
    private String raza;
    private String nombre;
    private int edad;
    private double peso;
    private String color;
    private String estado;

    public Animal(String tipo, String raza, String nombre, int edad, double peso, String color, String estado) {
        this.tipo = tipo;
        this.raza = raza;
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.color = color;
        this.estado = estado;
    }

    public String esMismaRazaYTipo(Animal otroAnimal) {

        if (this.raza.equals(otroAnimal.raza) && this.tipo.equals(otroAnimal.tipo)) {
            return "Los animales son de la misma raza y tipo";
        } else {
            return "Los animales no son de la misma raza y tipo";
        }

    }

    public String calcularAnalgésico() {
        if (peso < 10) {
            return "5cc";
        } else if (peso >= 10 && peso <= 20) {
            return "8cc";
        } else if (peso > 20 && peso <= 30) {
            return "12cc";
        } else {
            return "15cc";
        }
    }

    public String obtenerInformacion() {
        if (estado.equals("Sano")) {
            return nombre.toUpperCase() + " - " + raza + ", " + tipo + ", " + edad;
        } else if (estado.equals("Enfermo")) {
            return nombre.substring(0, 1).toUpperCase() + nombre.substring(1) + " - "
                    + tipo + ", " + edad + "-" + peso + ", " + color;
        } else {
            return "Estado desconocido";
        }
    }
}
