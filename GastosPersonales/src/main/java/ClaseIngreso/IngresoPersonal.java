package ClaseIngreso;

public class IngresoPersonal {

    private String nombre;
    private int ingreso;
    private int gasto;
    private long fecha;

    public IngresoPersonal(String nombre, int ingreso, int gasto, long fecha) {
        this.nombre = nombre;
        this.ingreso = ingreso;
        this.gasto = gasto;
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIngreso() {
        return ingreso;
    }

    public void setIngreso(int ingreso) {
        this.ingreso = ingreso;
    }

    public int getGasto() {
        return gasto;
    }

    public void setGasto(int gasto) {
        this.gasto = gasto;
    }

    public long getFecha() {
        return fecha;
    }

    public void setFecha(long fecha) {
        this.fecha = fecha;
    }

}
