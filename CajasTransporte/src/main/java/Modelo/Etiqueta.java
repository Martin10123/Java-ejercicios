package Modelo;

public class Etiqueta {

    private String descripcion;
    private int id;
    private String color;

    public Etiqueta() {
    }

    public Etiqueta(String descripcion, int id, String color) {
        this.descripcion = descripcion;
        this.id = id;
        this.color = color;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
