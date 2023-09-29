/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.modelo;

/**
 *
 * @author docente
 */
public class Medicamento {

    private String codigo;
    private String nombre;
    private String forma;
    private double fechacaducidad;
    private String vconsumo;
    private double dosis;

    public Medicamento() {
    }

    public Medicamento(String codigo, String nombre, String forma, double fechacaducidad, String vconsumo, double dosis) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.forma = forma;
        this.fechacaducidad = fechacaducidad;
        this.vconsumo = vconsumo;
        this.dosis = dosis;
    }

    

    public String colorconsumo() {
        String color = "";        
        if (this.getVconsumo().equals("oral")) {
            color = "blue";
        }
        if (this.getVconsumo().equals("inyectada")) {
            color = "orange";
        }
        
        return color;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the forma
     */
    public String getForma() {
        return forma;
    }

    /**
     * @param forma the forma to set
     */
    public void setForma(String forma) {
        this.forma = forma;
    }

    /**
     * @return the fechacaducidad
     */
    public double getFechacaducidad() {
        return fechacaducidad;
    }

    /**
     * @param fechacaducidad the fechacaducidad to set
     */
    public void setFechacaducidad(double fechacaducidad) {
        this.fechacaducidad = fechacaducidad;
    }

    /**
     * @return the vconsumo
     */
    public String getVconsumo() {
        return vconsumo;
    }

    /**
     * @param vconsumo the vconsumo to set
     */
    public void setVconsumo(String vconsumo) {
        this.vconsumo = vconsumo;
    }

    /**
     * @return the dosis
     */
    public double getDosis() {
        return dosis;
    }

    /**
     * @param dosis the dosis to set
     */
    public void setDosis(double dosis) {
        this.dosis = dosis;
    }

    

}    /**
     * @return the placas
     */
    