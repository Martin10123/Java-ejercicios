package Beans;

import Modelo.Caja;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;

@Named(value = "cajaBean")
@SessionScoped
public class CajaBean implements Serializable {

    private Stack<Caja> listaCajasPlataforma = new Stack<>();
    private Stack<Caja> pilaCajasEnCamion = new Stack();
    private List<Caja> listaCajasPlataformaAforo = new ArrayList<>();

    private List<Caja> listaCajasDanadas = new ArrayList<>();
    private List<Caja> listaCajasConAnomalias = new ArrayList<>();
    private List<Caja> listaCajasNormales = new ArrayList<>();

    private Caja caja = new Caja();
    private Caja cajaSeleccionadaPlataforma = new Caja();
    private Caja cajaBajadaDelCamionAInspeccionar = new Caja();

    public CajaBean() {
    }

    public Stack<Caja> getListaCajasPlataforma() {
        return listaCajasPlataforma;
    }

    public void setListaCajasPlataforma(Stack<Caja> listaCajasPlataforma) {
        this.listaCajasPlataforma = listaCajasPlataforma;
    }

    public Stack<Caja> getPilaCajasEnCamion() {
        return pilaCajasEnCamion;
    }

    public void setPilaCajasEnCamion(Stack<Caja> pilaCajasEnCamion) {
        this.pilaCajasEnCamion = pilaCajasEnCamion;
    }

    public List<Caja> getListaCajasPlataformaAforo() {
        return listaCajasPlataformaAforo;
    }

    public void setListaCajasPlataformaAforo(List<Caja> listaCajasPlataformaAforo) {
        this.listaCajasPlataformaAforo = listaCajasPlataformaAforo;
    }

    public List<Caja> getListaCajasDanadas() {
        return listaCajasDanadas;
    }

    public void setListaCajasDanadas(List<Caja> listaCajasDanadas) {
        this.listaCajasDanadas = listaCajasDanadas;
    }

    public List<Caja> getListaCajasConAnomalias() {
        return listaCajasConAnomalias;
    }

    public void setListaCajasConAnomalias(List<Caja> listaCajasConAnomalias) {
        this.listaCajasConAnomalias = listaCajasConAnomalias;
    }

    public List<Caja> getListaCajasNormales() {
        return listaCajasNormales;
    }

    public void setListaCajasNormales(List<Caja> listaCajasNormales) {
        this.listaCajasNormales = listaCajasNormales;
    }

    public Caja getCaja() {
        return caja;
    }

    public void setCaja(Caja caja) {
        this.caja = caja;
    }

    public Caja getCajaSeleccionadaPlataforma() {
        return cajaSeleccionadaPlataforma;
    }

    public void setCajaSeleccionadaPlataforma(Caja cajaSeleccionadaPlataforma) {
        this.cajaSeleccionadaPlataforma = cajaSeleccionadaPlataforma;
    }

    public Caja getCajaBajadaDelCamionAInspeccionar() {
        return cajaBajadaDelCamionAInspeccionar;
    }

    public void setCajaBajadaDelCamionAInspeccionar(Caja cajaBajadaDelCamionAInspeccionar) {
        this.cajaBajadaDelCamionAInspeccionar = cajaBajadaDelCamionAInspeccionar;
    }

    public void cajaAPlataforma() {

        if (this.caja.getCodigo().isEmpty() || this.caja.getAncho() <= 0.0 || this.caja.getAltura() <= 0.0 || this.caja.getPeso() <= 0.0) {
            MensajesAlertas.showError("Debe llenar todo el formulario", "");
            return;
        }

        this.listaCajasPlataforma.add(this.caja);
        this.caja = new Caja();

        MensajesAlertas.showInfo("Caja a plataforma", "Se agrego una caja a la plataforma");
    }

    public void seleccionarCajaDePlataforma() {
        this.cajaSeleccionadaPlataforma = this.listaCajasPlataforma.pop();
        MensajesAlertas.showInfo("Seleccionaste caja de plataforma", "Seleccionaste la caja con codigo: " + this.cajaSeleccionadaPlataforma.getCodigo());
    }

    public void suministrarInfoAdicionalCaja() {
        if (this.cajaSeleccionadaPlataforma.getFechaSalida().before(this.cajaSeleccionadaPlataforma.getFechaEntrada())) {
            MensajesAlertas.showError("Error en las fechas", "La fecha de salida no puede ser inferior a la fecha de entrada.");
            return;
        }

        this.cajaSeleccionadaPlataforma.setHoraSalida(obtenerHoraActual());
        this.pilaCajasEnCamion.add(this.cajaSeleccionadaPlataforma);
        MensajesAlertas.showInfo("Subiste caja al camión", "Subiste la caja con codigo: " + this.cajaSeleccionadaPlataforma.getCodigo());
        this.cajaSeleccionadaPlataforma = new Caja();

    }

    public void dividirCajasSegunEstado() {

        this.cajaBajadaDelCamionAInspeccionar = this.pilaCajasEnCamion.pop();
        
        this.cajaBajadaDelCamionAInspeccionar.setFechaEntrada(generarFechaDeHoy());
        this.cajaBajadaDelCamionAInspeccionar.setHoraSalida(obtenerHoraActual());

        switch (this.cajaBajadaDelCamionAInspeccionar.getEstado()) {
            case "Normal":
                this.listaCajasNormales.add(this.cajaBajadaDelCamionAInspeccionar);
                break;
            case "Con anomalias":
                this.listaCajasConAnomalias.add(this.cajaBajadaDelCamionAInspeccionar);
                break;
            case "Dañada":
                this.listaCajasDanadas.add(this.cajaBajadaDelCamionAInspeccionar);
                break;
            default:
                break;
        }
    }

    public String obtenerHoraActual() {
        Date fechaActual = new Date();
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
        return formatoHora.format(fechaActual);
    }

    public Date generarFechaDeHoy() {
        Date fechaActual = new Date();
        return fechaActual;
    }

}
