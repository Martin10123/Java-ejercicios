package MTaller1;

import java.util.ArrayList;

public class Presento {
    //Declaro un Arraylist, para guardar el texo
    ArrayList <Parrafo> cadenaTexto;

    public Presento(){
        // Constructor
        cadenaTexto = new ArrayList<>();
    }

    public void adicionarParrafo(Parrafo f) {
        cadenaTexto.add(f);
    }

    public String Cadena() {
        String cadenaString = "";
        for (Parrafo objPresento : cadenaTexto) {
            cadenaString += objPresento.nombre;
        }
        System.out.println("Numero de texto agregado es: " + cadenaTexto.size());
        return cadenaString;
        
    }

    
}