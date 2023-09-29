package Bean;

import Modelo.Envase;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.*;

@Named(value = "envaseBean")
@SessionScoped
public class EnvaseBean implements Serializable {

    private Stack<Envase> pilaEnvasesSinEstadarizar = new Stack<>();
    private List<Envase> listaEnvasesEstandarizados = new ArrayList<>();
    private List<Envase> listaEnvasesTerminados = new ArrayList<>();

    private Envase envase = new Envase();
    private Envase envaseAEstandarizar = new Envase();

    List<Double> tamaniosPermitidos = new ArrayList<>();

    public EnvaseBean() {
        this.tamaniosPermitidos.add(6.0);
        this.tamaniosPermitidos.add(8.0);
        this.tamaniosPermitidos.add(12.0);
    }

    public Stack<Envase> getPilaEnvasesSinEstadarizar() {
        return pilaEnvasesSinEstadarizar;
    }

    public void setPilaEnvasesSinEstadarizar(Stack<Envase> pilaEnvasesSinEstadarizar) {
        this.pilaEnvasesSinEstadarizar = pilaEnvasesSinEstadarizar;
    }

    public List<Envase> getListaEnvasesEstandarizados() {
        return listaEnvasesEstandarizados;
    }

    public void setListaEnvasesEstandarizados(List<Envase> listaEnvasesEstandarizados) {
        this.listaEnvasesEstandarizados = listaEnvasesEstandarizados;
    }

    public List<Envase> getListaEnvasesTerminados() {
        return listaEnvasesTerminados;
    }

    public void setListaEnvasesTerminados(List<Envase> listaEnvasesTerminados) {
        this.listaEnvasesTerminados = listaEnvasesTerminados;
    }

    public Envase getEnvase() {
        return envase;
    }

    public void setEnvase(Envase envase) {
        this.envase = envase;
    }

    public Envase getEnvaseAEstandarizar() {
        return envaseAEstandarizar;
    }

    public void setEnvaseAEstandarizar(Envase envaseAEstandarizar) {
        this.envaseAEstandarizar = envaseAEstandarizar;
    }

    public void agregarNuevoEnvase() {
        if (this.envase.getTamanio() <= 0 || this.envase.getTipo().isEmpty() || this.envase.getColor().isEmpty()) {
            MensajesAlertas.showError("Error al agregar un nuevo envase", "Debes de llenar todo el formulario");
            return;
        }

        if (this.tamaniosPermitidos.contains(this.envase.getTamanio())) {
            this.envase.setEstado("Estandarizado");
            this.listaEnvasesEstandarizados.add(this.envase);
            MensajesAlertas.showInfo("Agregaste un nuevo envase", "Se agrego el envase con los estandares correctos");
        } else {
            this.envase.setEstado("Sin estandarizar");
            this.pilaEnvasesSinEstadarizar.push(this.envase);
            MensajesAlertas.showWarn("Se almaceno el envase en la pila de los no estandarizados", "Se agrego el envase con los no estandarizados, modifica el tamaño pa sacarlo");
        }

        this.envase = new Envase();
    }

    public void elegirEnvaseNoEstandarizado() {

        if (this.envaseAEstandarizar.getTipo() == null) {
            this.envaseAEstandarizar = this.pilaEnvasesSinEstadarizar.pop();
            MensajesAlertas.showInfo("Seleccionaste un envase para estandarizarlo", "");
        }

    }

    public void moverEnvaseALaListaDeEstandarizados() {
        
        if (this.envaseAEstandarizar.getTipo() == null) {
            MensajesAlertas.showError("No hay envase seleccionado", "Debe de seleccionar un envase para poder estandarizarlo");
            return;
        }

        if (this.envaseAEstandarizar.getTamanio() <= 0) {
            MensajesAlertas.showError("El tamaño no puede ser negativo", "El tamaño debe ser un numero mayor a 0");
            return;
        }

        if (this.tamaniosPermitidos.contains(this.envaseAEstandarizar.getTamanio())) {
            this.envaseAEstandarizar.setEstado("Estandarizado");
            this.listaEnvasesEstandarizados.add(this.envaseAEstandarizar);
            MensajesAlertas.showInfo("Agregaste un nuevo envase", "Se agrego el envase con los estandares correctos");
        } else {
            this.envaseAEstandarizar.setEstado("Sin estandarizar");
            this.pilaEnvasesSinEstadarizar.push(this.envaseAEstandarizar);
            MensajesAlertas.showWarn("Se almaceno el envase en la pila de los no estandarizados", "Se agrego el envase con los no estandarizados, modifica el tamaño pa sacarlo");
        }

        this.envaseAEstandarizar = new Envase();
    }

    public void terminarEnvaseEstandarizado(Envase envaseTerminado) {
        this.listaEnvasesEstandarizados.remove(envaseTerminado);
        this.listaEnvasesTerminados.add(envaseTerminado);
        MensajesAlertas.showInfo("Envase en lista de terminados", "Envase listo");
    }
}
