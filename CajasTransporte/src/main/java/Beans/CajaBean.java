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
    List<Caja> listaCajasPlataformaAforo = new ArrayList<>();

    private Caja caja = new Caja();
    private Caja cajaSeleccionadaPlataforma = new Caja();
    private Caja cajaBajadaDelCamion = new Caja();

    public CajaBean() {
    }

    public Caja getCaja() {
        return caja;
    }

    public void setCaja(Caja caja) {
        this.caja = caja;
    }

    public List<Caja> getListaCajasPlataforma() {
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

    public Caja getCajaSeleccionadaPlataforma() {
        return cajaSeleccionadaPlataforma;
    }

    public void setCajaSeleccionadaPlataforma(Caja cajaSeleccionadaPlataforma) {
        this.cajaSeleccionadaPlataforma = cajaSeleccionadaPlataforma;
    }

    public List<Caja> getListaCajasPlataformaAforo() {
        return listaCajasPlataformaAforo;
    }

    public void setListaCajasPlataformaAforo(List<Caja> listaCajasPlataformaAforo) {
        this.listaCajasPlataformaAforo = listaCajasPlataformaAforo;
    }

    public Caja getCajaBajadaDelCamion() {
        return cajaBajadaDelCamion;
    }

    public void setCajaBajadaDelCamion(Caja cajaBajadaDelCamion) {
        this.cajaBajadaDelCamion = cajaBajadaDelCamion;
    }

    public void cajaAPlataforma() {
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

        this.pilaCajasEnCamion.add(this.cajaSeleccionadaPlataforma);
        this.cajaSeleccionadaPlataforma = new Caja();
        MensajesAlertas.showInfo("Subiste caja al camión", "Subiste la caja con codigo: " + this.cajaSeleccionadaPlataforma.getCodigo());

    }

    public void bajarCajaDelCamion() {
        this.cajaBajadaDelCamion = pilaCajasEnCamion.pop();
        MensajesAlertas.showInfo("Bajaste caja del camión", "Bajaste la caja con codigo: " + this.cajaSeleccionadaPlataforma.getCodigo());
    }

    public String obtenerHoraActual() {
        Date fechaActual = new Date();
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
        return formatoHora.format(fechaActual);
    }

}
