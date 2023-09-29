package Modelo;

import java.util.Date;

public class Caja {

    private String radicado;
    private Date fechaEntrada;
    private String estado;
    private Date fechaSalida;
    private String horaSalida;
    private double altura;
    private double peso;
    private double ancho;
    private String codigo;
    private Etiqueta etiqueta;

    public Caja() {
    }

    public Caja(String radicado, Date fechaEntrada, String estado, Date fechaSalida, String horaSalida, double altura, double peso, double ancho, String codigo, Etiqueta etiqueta) {
        this.radicado = radicado;
        this.fechaEntrada = fechaEntrada;
        this.estado = estado;
        this.fechaSalida = fechaSalida;
        this.horaSalida = horaSalida;
        this.altura = altura;
        this.peso = peso;
        this.ancho = ancho;
        this.codigo = codigo;
        this.etiqueta = etiqueta;
    }

    public String getRadicado() {
        return radicado;
    }

    public void setRadicado(String radicado) {
        this.radicado = radicado;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Etiqueta getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(Etiqueta etiqueta) {
        this.etiqueta = etiqueta;
    }

}
