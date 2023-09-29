package exercise2.main;

import exercise2.Vehicle.*;
import javax.swing.JOptionPane;

public class MainTaller {

    public static void main(String[] args) {

        Vehicle car1 = new Car("Chevrolet", 2020, "Roja", "Falla en el compartimiento", "Martin", "Cartagena", 300);
        Vehicle car2 = new Car("Chevrolet", 2018, "Gris", "Falla en la parte delantera", "Pedro", "Cartagena", 300);

        JOptionPane.showMessageDialog(null, car1.informacionByModel(), "MUESTRA INFORMACIÒN DEPENDIENDO EL MODELO", 2);
        JOptionPane.showMessageDialog(null, car1.isTheSameBrandByObject(car1, car2), "DEMOSTRAR SI SON DE LA MISMA MARCA", 2);
        JOptionPane.showMessageDialog(null, car1.isSameBrand(car2.getBrand()), "DEMOSTRAR SI UN OBJETO ES IGUAL AL DE LA INSTANCIA", 2);

        Vehicle moto1 = new Motorbike("Pulsar", 2022, "Roja", "Falla en el motor", "Ramirez", "Cartagena", 300);
        Vehicle moto2 = new Motorbike("Kawasaki ", 2014, "Verde", "Falla en los cambios", "Daniel", "Cartagena", 300);
        
        JOptionPane.showMessageDialog(null, moto1.informacionByModel(), "MUESTRA INFORMACIÒN DEPENDIENDO EL MODELO", 2);
        JOptionPane.showMessageDialog(null, moto1.isTheSameBrandByObject(moto1, moto2), "DEMOSTRAR SI SON DE LA MISMA MARCA", 2);
        JOptionPane.showMessageDialog(null, moto1.isSameBrand(moto2.getBrand()), "DEMOSTRAR SI UN OBJETO ES IGUAL AL DE LA INSTANCIA", 2);

    }

}
