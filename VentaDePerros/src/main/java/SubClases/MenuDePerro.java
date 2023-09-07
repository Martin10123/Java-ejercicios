package SubClases;

import java.util.ArrayList;

public class MenuDePerro {

    // Creamos la referencia al array, por ahora esta vacio: []
    ArrayList<Perro> listaDePerrosQueGuardare;

    public MenuDePerro() {
        
        // Creamos el contructor y instanciamos un objecto
        
        listaDePerrosQueGuardare = new ArrayList<>();
    }
    
    public void AgregarUnNuevoPerro (Perro NuevoPerro) {
        listaDePerrosQueGuardare.add(NuevoPerro);   
    }
    
    
    public ArrayList<Perro> obtenerTodosLosPerros() {
        return listaDePerrosQueGuardare;
    }
    
}
