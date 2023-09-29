package Beans;

import Modelo.Caja;
import Modelo.Etiqueta;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;

@Named(value = "cajaBean")
@SessionScoped
public class CajaBean implements Serializable {

    private Stack<Caja> listaCajasPlataformaDistribucion = new Stack<>();
    private List<Caja> listCajasEnElCamion = new ArrayList();
    private List<Caja> listaCajasPlataformaAforo = new ArrayList<>();

    private List<Caja> listaCajasDanadas = new ArrayList<>();
    private List<Caja> listaCajasConAnomalias = new ArrayList<>();
    private List<Caja> listaCajasNormales = new ArrayList<>();

    private Etiqueta etiqueta = new Etiqueta();
    private Caja caja = new Caja();
    private Caja cajaAModificarParaSubirAlCamion = new Caja();
    private Caja cajaBajadaDelCamionAInspeccionar = new Caja();
    private Caja cajaDividirSegunEstado = new Caja();

    public CajaBean() {
    }

    public Etiqueta getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(Etiqueta etiqueta) {
        this.etiqueta = etiqueta;
    }

    public Stack<Caja> getListaCajasPlataformaDistribucion() {
        return listaCajasPlataformaDistribucion;
    }

    public void setListaCajasPlataformaDistribucion(Stack<Caja> listaCajasPlataformaDistribucion) {
        this.listaCajasPlataformaDistribucion = listaCajasPlataformaDistribucion;
    }

    public List<Caja> getListCajasEnElCamion() {
        return listCajasEnElCamion;
    }

    public void setListCajasEnElCamion(List<Caja> listCajasEnElCamion) {
        this.listCajasEnElCamion = listCajasEnElCamion;
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

    public Caja getCajaAModificarParaSubirAlCamion() {
        return cajaAModificarParaSubirAlCamion;
    }

    public void setCajaAModificarParaSubirAlCamion(Caja cajaAModificarParaSubirAlCamion) {
        this.cajaAModificarParaSubirAlCamion = cajaAModificarParaSubirAlCamion;
    }

    public Caja getCajaBajadaDelCamionAInspeccionar() {
        return cajaBajadaDelCamionAInspeccionar;
    }

    public void setCajaBajadaDelCamionAInspeccionar(Caja cajaBajadaDelCamionAInspeccionar) {
        this.cajaBajadaDelCamionAInspeccionar = cajaBajadaDelCamionAInspeccionar;
    }

    public Caja getCajaDividirSegunEstado() {
        return cajaDividirSegunEstado;
    }

    public void setCajaDividirSegunEstado(Caja cajaDividirSegunEstado) {
        this.cajaDividirSegunEstado = cajaDividirSegunEstado;
    }

    public void agregarCajaAPlataformaDistribucion() {

        if (this.caja.getCodigo().isEmpty() || this.caja.getAncho() <= 0.0 || this.caja.getAltura() <= 0.0 || this.caja.getPeso() <= 0.0) {
            MensajesAlertas.showError("Para agregar una nueva caja", "Debe llenar todo el formulario");
            return;
        }

        this.listaCajasPlataformaDistribucion.add(this.caja);
        this.caja = new Caja();

        MensajesAlertas.showInfo("Caja a plataforma", "Se agrego una caja a la plataforma");
    }

    public void seleccionarCajaDePlataformaDistribucion() {
        this.cajaAModificarParaSubirAlCamion = this.listaCajasPlataformaDistribucion.pop();
        MensajesAlertas.showInfo("Seleccionaste caja de plataforma", "Seleccionaste la caja con codigo: " + this.cajaAModificarParaSubirAlCamion.getCodigo());
    }

    public void subirCajaModificadaAlCamion() {
        if (this.cajaAModificarParaSubirAlCamion.getRadicado().isEmpty() || this.cajaAModificarParaSubirAlCamion.getFechaEntrada().toString().isEmpty()) {
            MensajesAlertas.showError("Para modificar una caja", "Debe llenar todo el formulario de modificacion");
            return;
        }

        this.cajaAModificarParaSubirAlCamion.setHoraSalida(obtenerHoraActual());
        this.listCajasEnElCamion.add(this.cajaAModificarParaSubirAlCamion);
        MensajesAlertas.showInfo("Subiste caja al camión", "Subiste la caja con codigo: " + this.cajaAModificarParaSubirAlCamion.getCodigo());
        this.cajaAModificarParaSubirAlCamion = new Caja();
    }

    public void bajaCajaDelCamion(Caja cajaBajada) {
        this.cajaBajadaDelCamionAInspeccionar = cajaBajada;

        this.listCajasEnElCamion.remove(this.cajaBajadaDelCamionAInspeccionar);
        this.listaCajasPlataformaAforo.add(this.cajaBajadaDelCamionAInspeccionar);
        MensajesAlertas.showInfo("Bajaste una caja del camión", "Bajaste la caja con codigo: " + this.cajaBajadaDelCamionAInspeccionar.getCodigo() + " del camión");
    }

    public void elegirCajaDePlataformaAforo(Caja cajaElegida) {
        this.cajaDividirSegunEstado = cajaElegida;
        this.listaCajasPlataformaAforo.remove(cajaElegida);
    }

    public void dividirCajasSegunEstado() {
        if (this.cajaDividirSegunEstado.getFechaSalida().before(this.cajaDividirSegunEstado.getFechaEntrada())) {
            MensajesAlertas.showError("Para modificar una caja", "La fecha de salida no puede ser anterior a la fecha de entrada");
            return;
        }

        this.cajaDividirSegunEstado.setHoraSalida(obtenerHoraActual());

        if (this.cajaDividirSegunEstado.getEstado().equals("Normal")) {
            this.etiqueta.setColor("Verde");
            this.cajaDividirSegunEstado.setEtiqueta(this.etiqueta);
            this.listaCajasNormales.add(this.cajaDividirSegunEstado);
            MensajesAlertas.showInfo("Agregaste caja", "Estado de la caja normal");
            return;
        }

        if ((this.cajaDividirSegunEstado.getEstado().equals("Con anomalias") || this.cajaDividirSegunEstado.getEstado().equals("Dañada"))
                && this.etiqueta.getDescripcion().isEmpty()
                && this.etiqueta.getColor().isEmpty()
                && this.etiqueta.getId() <= 0) {

            MensajesAlertas.showError("Error a la hora de agregar una caja dañada o con anomalias", "Debes de agregarle una etiqueta con su id, descripción y color");

        }

        if (this.cajaDividirSegunEstado.getEstado().equals("Con anomalias")) {
            this.etiqueta.setColor("Naranja");
            this.cajaDividirSegunEstado.setEtiqueta(this.etiqueta);
            this.listaCajasConAnomalias.add(this.cajaDividirSegunEstado);
            MensajesAlertas.showInfo("Agregaste caja", "Estado de la caja con anomalias");
        } else if (this.cajaDividirSegunEstado.getEstado().equals("Dañada")) {
            this.etiqueta.setColor("Rojo");
            this.cajaDividirSegunEstado.setEtiqueta(this.etiqueta);
            this.listaCajasDanadas.add(this.cajaDividirSegunEstado);
            MensajesAlertas.showInfo("Agregaste caja", "Estado de la caja dañada");
        }
        
        this.etiqueta = new Etiqueta();
        this.cajaDividirSegunEstado = new Caja();
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

    public String mostrarFechaDeHoyCorta(Date fechaActual) {
        SimpleDateFormat formatoFechaCorta = new SimpleDateFormat("dd-MM-yyyy");

        return formatoFechaCorta.format(fechaActual);
    }

}
