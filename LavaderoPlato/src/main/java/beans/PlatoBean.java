package beans;

import Modelo.Plato;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.*;

@Named(value = "plataBean")
@SessionScoped
public class PlatoBean implements Serializable {
    
    Stack<Plato> platosAProcesar = new Stack<>();
    List<Plato> platosSucios = new ArrayList<>();
    List<Plato> platosLimpios = new ArrayList<>();
    List<Plato> platosDañados = new ArrayList<>();

    public PlatoBean() {
    }
    
    
    
}
