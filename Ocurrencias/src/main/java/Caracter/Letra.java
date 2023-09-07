package Caracter;

public class Letra {

    private char letra;
    private int numeroOcurrencias;
    private int posicion;

    public Letra(char letra, int numeroOcurrencias, int posicion) {
        this.letra = letra;
        this.numeroOcurrencias = numeroOcurrencias;
        this.posicion = posicion;
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public int getNumeroOcurrencias() {
        return numeroOcurrencias;
    }

    public void setNumeroOcurrencias(int numeroOcurrencias) {
        this.numeroOcurrencias = numeroOcurrencias;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    @Override
    public String toString() {
        return "letra: " + letra + ", numeroOcurrencias: " + numeroOcurrencias + " posición: " + posicion;
    }

}
