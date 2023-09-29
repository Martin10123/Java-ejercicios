/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.controller;

import com.modelo.Medicamento;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author docente
 */
@ManagedBean
@SessionScoped
public class MediControl {

    private Medicamento medi = new Medicamento();
    private List<Medicamento>mas =new ArrayList();//General
    private List<Medicamento> medicamentos= new ArrayList();//Capsulas
    private List<Medicamento>medis= new ArrayList();//Liquidos

    /**
     * Creates a new instance of MotoController
     */
    public MediControl() {
    }

    public void agregar() {
        if (!existeMedicamento(medi)) {
            medi.setVconsumo("capsula");
            medicamentos.add(medi);
            medi = new Medicamento();
            medi.setVconsumo("externo");
            medis.add(medi);
            medi = new Medicamento();
            
            FacesUtil.addInfoMessage("Se registro Exitosamente");
        } else {
            FacesUtil.addErrorMessage("Ya el medicamento existe");
        }

    }

    public void quitar(Medicamento med) {
        mas.remove(med);
        FacesUtil.addErrorMessage("Se elimino el medicamento con exito");
    }
    public void colocaroral(Medicamento med){
        med.setVconsumo("capsula");
    }
    
    public void colocarexterno(Medicamento med){
        med.setVconsumo("externo");
    }
    public void alquilar(Medicamento med){
        if(med.getVconsumo().equals("externo")){
            med.setVconsumo("capsula");
            medicamentos.remove (med);
            medis.remove(med);
            mas.add(med);
        }else{
            FacesUtil.addErrorMessage("El medicamento se devolvió con exito");
        }
    }
      public void devolver(Medicamento med){
        if(med.getVconsumo().equals("capsula")){
            med.setVconsumo("externo");
            medicamentos.remove (med);
            medis.remove(med);
            mas.add(med);
        }else{
            FacesUtil.addErrorMessage("El medicamento se devolvió con exito");
        }
    }
    public boolean existeMedicamento(Medicamento med) {
        boolean existe = false;
        for (Medicamento m : mas) {
            if (m.getCodigo().equals(m.getCodigo())) {
                existe = true;
                break;
            }
        }
        return existe;
    }

    /**
     * @return the medi
     */
    public Medicamento getMedi() {
        return medi;
    }

    /**
     * @param medi the medi to set
     */
    public void setMedi(Medicamento medi) {
        this.medi = medi;
    }

    /**
     * @return the medicamentos
     */
    public List<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    /**
     * @param medicamentos the medicamentos to set
     */
    public void setMedicamentos(List<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }

    /**
     * @return the me
     */
    public List<Medicamento> getMed() {
        return mas;
    }

  
    public void setMe(List<Medicamento> med) {
        this.mas= med;
    }

}    /**
     * @return the medicamento 
     */
    
