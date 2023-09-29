package Modelo;

public class Plato {

    private String codigo;
    private String estado;
    private String tipo;

    public Plato() {
    }

    public Plato(String codigo, String estado, String tipo) {
        this.codigo = codigo;
        this.estado = estado;
        this.tipo = tipo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
