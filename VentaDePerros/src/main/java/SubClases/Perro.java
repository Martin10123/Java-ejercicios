package SubClases;

public class Perro {

    String raza;
    String color;
    int edad;
    int precio;
    String nombre;

    public Perro(String raza, String color, int edad, int precio, String nombre) {
        this.raza = raza;
        this.color = color;
        this.edad = edad;
        this.precio = precio;
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Perro{" + "raza=" + raza + ", color=" + color + ", edad=" + edad + ", precio=" + precio + ", nombre=" + nombre + '}';
    }

}
