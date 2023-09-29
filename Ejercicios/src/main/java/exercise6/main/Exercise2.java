package exercise6.main;

import exercise6.partner.*;

public class Exercise2 {
    public static void main(String[] args) {
        
        System.out.println("X Empleado \n");
        
        Employee employee1 = new Employee("Martin", "Simarra", "12/06/2015", 2500000, 10, "Empleado");
        
        employee1.outlay();
        
        System.out.println("X Administrador \n");
        
        Administrative Administrative1 = new Administrative("Martin", "Simarra", "12/06/2015", 2500000, 10, "Administrador"); 
                
        Administrative1.outlay();
    }
}
