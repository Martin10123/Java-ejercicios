package clases;

public class Medicamento {

    private int codigo;
    private String nombre;
    private String forma;
    private String fechaCaducidad;
    private String viaConsumo;
    private int dosis;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public String getViaConsumo() {
        return viaConsumo;
    }

    public void setViaConsumo(String viaConsumo) {
        this.viaConsumo = viaConsumo;
    }

    public int getDosis() {
        return dosis;
    }

    public void setDosis(int dosis) {
        this.dosis = dosis;
    }

}
