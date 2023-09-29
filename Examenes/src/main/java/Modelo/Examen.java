package Modelo;

public class Examen {

    private String codigo;
    private int numeroPreguntas;

    public Examen() {
    }

    public Examen(String codigo, int numeroPreguntas) {
        this.codigo = codigo;
        this.numeroPreguntas = numeroPreguntas;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getNumeroPreguntas() {
        return numeroPreguntas;
    }

    public void setNumeroPreguntas(int numeroPreguntas) {
        this.numeroPreguntas = numeroPreguntas;
    }

}
