package Modelo;

public class ExamenEstudiante {

    private String nombreEstudiante;
    private String codigo;
    private int preguntasBuenas;
    private String estado;
    private double notaExamen;

    public ExamenEstudiante() {
    }

    public ExamenEstudiante(String nombreEstudiante, String codigo, int preguntasBuenas, String estado) {
        this.nombreEstudiante = nombreEstudiante;
        this.codigo = codigo;
        this.preguntasBuenas = preguntasBuenas;
        this.estado = estado;
    }

    public double notaDelExamen(Examen ex) {
        return this.getPreguntasBuenas() * 5 / ex.getNumeroPreguntas();
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getPreguntasBuenas() {
        return preguntasBuenas;
    }

    public void setPreguntasBuenas(int preguntasBuenas) {
        this.preguntasBuenas = preguntasBuenas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getNotaExamen() {
        return notaExamen;
    }

    public void setNotaExamen(double notaExamen) {
        this.notaExamen = notaExamen;
    }

}
