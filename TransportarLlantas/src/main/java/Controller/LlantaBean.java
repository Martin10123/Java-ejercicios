package Controller;

import Modelo.Etiqueta;
import Modelo.Llanta;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;

@Named(value = "llantaBean")
@SessionScoped
public class LlantaBean implements Serializable {

    private Stack<Llanta> pilaLlantasPlataformaDistribucion = new Stack<>();
    private Stack<Llanta> pilaLlantasEnElCamion = new Stack<>();
    private List<Llanta> listaLlantasPlataformaAforo = new ArrayList<>();

    private List<Llanta> listaLlantasDanadas = new ArrayList<>();
    private List<Llanta> listaLlantasConAnomalias = new ArrayList<>();
    private List<Llanta> listaLlantasNormales = new ArrayList<>();

    private Etiqueta etiqueta = new Etiqueta();
    private Llanta llanta = new Llanta();
    private Llanta llantaAModificarParaSubirAlCamion = new Llanta();
    private Llanta llantaBajadaDelCamionAInspeccionar = new Llanta();
    private Llanta llantaDividirSegunEstado = new Llanta();

    private Date horaEntradaDate = new Date();
    private Date horaSalidaDate = new Date();

    public LlantaBean() {
    }

    public void agregarLlantaAPlataformaDistribucion() {

        System.out.println("ENTRE AQUI");

        if (this.llanta.getCodigo().isEmpty() || this.llanta.getAncho() <= 0.0 || this.llanta.getRadio() <= 0.0 || this.llanta.getPeso() <= 0.0) {
            MensajesAlertas.showError("Para agregar una nueva Llanta", "Debe llenar todo el formulario");
            return;
        }

        System.out.println("PASE ENTRE AQUI");

        this.pilaLlantasPlataformaDistribucion.push(this.llanta);
        this.llanta = new Llanta();

        MensajesAlertas.showInfo("Llanta a plataforma", "Se agrego una llanta a la plataforma");
    }

    public void seleccionarLlantaDePlataformaDistribucion() {
        this.llantaAModificarParaSubirAlCamion = this.pilaLlantasPlataformaDistribucion.pop();
        MensajesAlertas.showInfo("Seleccionaste llanta de plataforma", "Seleccionaste la llanta con codigo: " + this.llantaAModificarParaSubirAlCamion.getCodigo());
    }

    public void subirLlantaModificadaAlCamion() {
        if (this.llantaAModificarParaSubirAlCamion.getRadicado().isEmpty() || this.llantaAModificarParaSubirAlCamion.getFechaEntrada().toString().isEmpty()) {
            MensajesAlertas.showError("Para modificar una llanta", "Debe llenar todo el formulario de modificacion");
            return;
        }

        this.llantaAModificarParaSubirAlCamion.setHoraEntrada(this.horaEntradaDate.toString());
        this.pilaLlantasEnElCamion.push(this.llantaAModificarParaSubirAlCamion);
        MensajesAlertas.showInfo("Subiste llanta al camión", "Subiste la llanta con codigo: " + this.llantaAModificarParaSubirAlCamion.getCodigo());
        this.llantaAModificarParaSubirAlCamion = new Llanta();
        this.horaEntradaDate = new Date();
    }

    public void bajaLlantaDelCamion() {
        if (this.llantaBajadaDelCamionAInspeccionar.getCodigo() == null) {

            this.llantaBajadaDelCamionAInspeccionar = this.pilaLlantasEnElCamion.pop();
            this.listaLlantasPlataformaAforo.add(this.llantaBajadaDelCamionAInspeccionar);

            MensajesAlertas.showInfo("Bajaste una llanta del camión", "Bajaste la llanta con codigo: " + this.llantaBajadaDelCamionAInspeccionar.getCodigo() + " del camión");
            this.llantaBajadaDelCamionAInspeccionar = new Llanta();
        }
    }

    public void elegirLlantaDePlataformaAforo(Llanta LlantaElegida, String estadoLlanta) {
        if (this.llantaDividirSegunEstado.getCodigo() == null) {

            this.llantaDividirSegunEstado = LlantaElegida;
            this.llantaDividirSegunEstado.setEstado(estadoLlanta);
            this.listaLlantasPlataformaAforo.remove(LlantaElegida);

        }
    }

    public void dividirLlantasSegunEstado() {

        if (this.llantaDividirSegunEstado.getCodigo() == null || this.llantaDividirSegunEstado.getFechaSalida() == null) {
            return;
        }

        if (this.llantaDividirSegunEstado.getFechaSalida().before(this.llantaDividirSegunEstado.getFechaEntrada())) {
            MensajesAlertas.showError("Para modificar una llanta", "La fecha de salida no puede ser anterior a la fecha de entrada");
            return;
        }

        this.llantaDividirSegunEstado.setHoraSalida(this.horaSalidaDate.toString());

        if (this.llantaDividirSegunEstado.getEstado().equals("Normal")) {
            this.etiqueta.setColor("Verde");
            this.llantaDividirSegunEstado.setEtiqueta(this.etiqueta);
            this.listaLlantasNormales.add(this.llantaDividirSegunEstado);
            MensajesAlertas.showInfo("Agregaste llanta", "Estado de la llanta normal");

            this.etiqueta = new Etiqueta();
            this.llantaDividirSegunEstado = new Llanta();
            this.horaSalidaDate = new Date();
            return;
        }

        if ((this.llantaDividirSegunEstado.getEstado().equals("Con anomalias") || this.llantaDividirSegunEstado.getEstado().equals("Dañada"))
                && this.etiqueta.getDescripcion().isEmpty()
                && this.etiqueta.getId() <= 0) {

            MensajesAlertas.showError("Error a la hora de agregar una llanta dañada o con anomalias", "Debes de agregarle una etiqueta con su id, descripción");

            return;
        }

        if (this.llantaDividirSegunEstado.getEstado().equals("Con anomalias")) {
            this.etiqueta.setColor("Naranja");
            this.llantaDividirSegunEstado.setEtiqueta(this.etiqueta);
            this.listaLlantasConAnomalias.add(this.llantaDividirSegunEstado);
            MensajesAlertas.showInfo("Agregaste Llanta", "Estado de la Llanta con anomalias");
        } else if (this.llantaDividirSegunEstado.getEstado().equals("Dañada")) {
            this.etiqueta.setColor("Rojo");
            this.llantaDividirSegunEstado.setEtiqueta(this.etiqueta);
            this.listaLlantasDanadas.add(this.llantaDividirSegunEstado);
            MensajesAlertas.showInfo("Agregaste Llanta", "Estado de la Llanta dañada");
        }

        this.etiqueta = new Etiqueta();
        this.llantaDividirSegunEstado = new Llanta();
        this.horaSalidaDate = new Date();

    }

    public String mostrarFechaDeHoyCorta(Date fechaActual) {
        SimpleDateFormat formatoFechaCorta = new SimpleDateFormat("dd-MM-yyyy");

        return formatoFechaCorta.format(fechaActual);
    }

//    Getters y Setters tanto de las listas como de las llantas y etiqueta
    public Stack<Llanta> getPilaLlantasPlataformaDistribucion() {
        return pilaLlantasPlataformaDistribucion;
    }

    public void setPilaLlantasPlataformaDistribucion(Stack<Llanta> pilaLlantasPlataformaDistribucion) {
        this.pilaLlantasPlataformaDistribucion = pilaLlantasPlataformaDistribucion;
    }

    public Stack<Llanta> getPilaLlantasEnElCamion() {
        return pilaLlantasEnElCamion;
    }

    public void setPilaLlantasEnElCamion(Stack<Llanta> pilaLlantasEnElCamion) {
        this.pilaLlantasEnElCamion = pilaLlantasEnElCamion;
    }

    public List<Llanta> getListaLlantasPlataformaAforo() {
        return listaLlantasPlataformaAforo;
    }

    public void setListaLlantasPlataformaAforo(List<Llanta> listaLlantasPlataformaAforo) {
        this.listaLlantasPlataformaAforo = listaLlantasPlataformaAforo;
    }

    public List<Llanta> getListaLlantasDanadas() {
        return listaLlantasDanadas;
    }

    public void setListaLlantasDanadas(List<Llanta> listaLlantasDanadas) {
        this.listaLlantasDanadas = listaLlantasDanadas;
    }

    public List<Llanta> getListaLlantasConAnomalias() {
        return listaLlantasConAnomalias;
    }

    public void setListaLlantasConAnomalias(List<Llanta> listaLlantasConAnomalias) {
        this.listaLlantasConAnomalias = listaLlantasConAnomalias;
    }

    public List<Llanta> getListaLlantasNormales() {
        return listaLlantasNormales;
    }

    public void setListaLlantasNormales(List<Llanta> listaLlantasNormales) {
        this.listaLlantasNormales = listaLlantasNormales;
    }

    public Etiqueta getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(Etiqueta etiqueta) {
        this.etiqueta = etiqueta;
    }

    public Llanta getLlanta() {
        return llanta;
    }

    public void setLlanta(Llanta llanta) {
        this.llanta = llanta;
    }

    public Llanta getLlantaAModificarParaSubirAlCamion() {
        return llantaAModificarParaSubirAlCamion;
    }

    public void setLlantaAModificarParaSubirAlCamion(Llanta llantaAModificarParaSubirAlCamion) {
        this.llantaAModificarParaSubirAlCamion = llantaAModificarParaSubirAlCamion;
    }

    public Llanta getLlantaBajadaDelCamionAInspeccionar() {
        return llantaBajadaDelCamionAInspeccionar;
    }

    public void setLlantaBajadaDelCamionAInspeccionar(Llanta llantaBajadaDelCamionAInspeccionar) {
        this.llantaBajadaDelCamionAInspeccionar = llantaBajadaDelCamionAInspeccionar;
    }

    public Llanta getLlantaDividirSegunEstado() {
        return llantaDividirSegunEstado;
    }

    public void setLlantaDividirSegunEstado(Llanta llantaDividirSegunEstado) {
        this.llantaDividirSegunEstado = llantaDividirSegunEstado;
    }

    public Date getHoraEntradaDate() {
        return horaEntradaDate;
    }

    public void setHoraEntradaDate(Date horaEntradaDate) {
        this.horaEntradaDate = horaEntradaDate;
    }

    public Date getHoraSalidaDate() {
        return horaSalidaDate;
    }

    public void setHoraSalidaDate(Date horaSalidaDate) {
        this.horaSalidaDate = horaSalidaDate;
    }
    
}
