package Bean;

import Datos.ManejarDatos;
import Modelo.Examen;
import Modelo.ExamenEstudiante;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.*;

@Named(value = "examenBean")
@SessionScoped
public class ExamenBean implements Serializable {
    
    private Stack<ExamenEstudiante> listExamenesEntregados;
    private List<ExamenEstudiante> listaExamenesCalificados;

    private Examen nuevoExamen = new Examen();
    private ExamenEstudiante nuevoExamenEstudiante = new ExamenEstudiante();
    private ExamenEstudiante nuevoExamenEstudianteACalificar = new ExamenEstudiante();
    private Examen nuevoExamenCreado;

    public ExamenBean() {
        listExamenesEntregados = ManejarDatos.leerExamenesEntregados();
        listaExamenesCalificados = ManejarDatos.leerExamenesCalificados();
        nuevoExamenCreado = ManejarDatos.leerExamenNuevoCreado();
    }

    public Stack<ExamenEstudiante> getListExamenesEntregados() {
        return listExamenesEntregados;
    }

    public void setListExamenesEntregados(Stack<ExamenEstudiante> listExamenesEntregados) {
        this.listExamenesEntregados = listExamenesEntregados;
    }

    public List<ExamenEstudiante> getListaExamenesCalificados() {
        return listaExamenesCalificados;
    }

    public void setListaExamenesCalificados(List<ExamenEstudiante> listaExamenesCalificados) {
        this.listaExamenesCalificados = listaExamenesCalificados;
    }

    public Examen getNuevoExamen() {
        return nuevoExamen;
    }

    public void setNuevoExamen(Examen nuevoExamen) {
        this.nuevoExamen = nuevoExamen;
    }

    public ExamenEstudiante getNuevoExamenEstudiante() {
        return nuevoExamenEstudiante;
    }

    public void setNuevoExamenEstudiante(ExamenEstudiante nuevoExamenEstudiante) {
        this.nuevoExamenEstudiante = nuevoExamenEstudiante;
    }

    public ExamenEstudiante getNuevoExamenEstudianteACalificar() {
        return nuevoExamenEstudianteACalificar;
    }

    public void setNuevoExamenEstudianteACalificar(ExamenEstudiante nuevoExamenEstudianteACalificar) {
        this.nuevoExamenEstudianteACalificar = nuevoExamenEstudianteACalificar;
    }

    public Examen getNuevoExamenCreado() {
        return nuevoExamenCreado;
    }

    public void setNuevoExamenCreado(Examen nuevoExamenCreado) {
        this.nuevoExamenCreado = nuevoExamenCreado;
    }

    public void aceptarExamen() {

        if (nuevoExamen.getCodigo().isEmpty() || nuevoExamen.getNumeroPreguntas() == 0) {
            return;
        }

        ManejarDatos.guardarExamenCreado(this.nuevoExamen);
        this.nuevoExamenCreado = this.nuevoExamen;
        this.nuevoExamen = new Examen();
    }

    public void entregarExamen() {

        if (this.nuevoExamenEstudiante.getCodigo().isEmpty() || this.nuevoExamenEstudiante.getNombreEstudiante().isEmpty()) {
            return;
        }
        
        ManejarDatos.guardarExamenEntregado(this.nuevoExamenEstudiante);
        this.listExamenesEntregados.add(this.nuevoExamenEstudiante);
        this.nuevoExamenEstudiante = new ExamenEstudiante();
    }

    public void escogerUltimoExamenDeLaPila() {

        if (this.listExamenesEntregados.isEmpty()) {
            return;
        }
        
        this.nuevoExamenEstudianteACalificar = this.listExamenesEntregados.pop();
    }

    public void entregarExamencalificado() {

        double caliExam = this.nuevoExamenEstudianteACalificar.notaDelExamen(this.nuevoExamenCreado);

        this.nuevoExamenEstudianteACalificar.setEstado(caliExam >= 3 ? "Examen ganado" : "Examen perdido");
        this.nuevoExamenEstudianteACalificar.setNotaExamen(caliExam);

        // Guarda el examen calificado
        ManejarDatos.guardarExamenCalificado(this.nuevoExamenEstudianteACalificar);
        
        // Elimina el examen calificado de la lista de entregados
        ManejarDatos.eliminarExamenEntregado(this.nuevoExamenEstudianteACalificar.getCodigo());
        
        this.listaExamenesCalificados.add(this.nuevoExamenEstudianteACalificar);
        this.nuevoExamenEstudianteACalificar = new ExamenEstudiante();
    }

}
