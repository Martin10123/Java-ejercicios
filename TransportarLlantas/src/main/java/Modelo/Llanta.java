package Modelo;

import java.util.Date;

public class Llanta {

    private String radicado;
    private Date fechaEntrada;
    private String estado;
    private Date fechaSalida;
    private String horaEntrada;
    private String horaSalida;
    private double radio;
    private double peso;
    private double ancho;
    private String codigo;
    private Etiqueta etiqueta;

    public Llanta() {
    }

    public Llanta(String radicado, Date fechaEntrada, String estado, Date fechaSalida, String horaEntrada, String horaSalida, double radio, double peso, double ancho, String codigo, Etiqueta etiqueta) {
        this.radicado = radicado;
        this.fechaEntrada = fechaEntrada;
        this.estado = estado;
        this.fechaSalida = fechaSalida;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.radio = radio;
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

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
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
