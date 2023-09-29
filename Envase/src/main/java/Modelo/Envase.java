package Modelo;

public class Envase {

    private String tipo;
    private String estado;
    private double tamanio;
    private String color;

    public Envase() {
    }

    public Envase(String tipo, String estado, double tamanio, String color) {
        this.tipo = tipo;
        this.estado = estado;
        this.tamanio = tamanio;
        this.color = color;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getTamanio() {
        return tamanio;
    }

    public void setTamanio(double tamanio) {
        this.tamanio = tamanio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
