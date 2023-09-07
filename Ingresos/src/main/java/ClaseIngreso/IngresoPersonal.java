package ClaseIngreso;

public class IngresoPersonal {

    private int idDoc; 
    private String nombre;
    private int ingreso;
    private int gasto;
    private String fecha;

    public IngresoPersonal(int idDoc, String nombre, int ingreso, int gasto, String fecha) {
        this.idDoc = idDoc;
        this.nombre = nombre;
        this.ingreso = ingreso;
        this.gasto = gasto;
        this.fecha = fecha;
    }

    public int getIdDoc() {
        return idDoc;
    }

    public void setIdDoc(int idDoc) {
        this.idDoc = idDoc;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getGasto() {
        return gasto;
    }

    public void setGasto(int gasto) {
        this.gasto = gasto;
    }

}
