package folder1;
import MTaller1.Parrafo;
import MTaller1.Presento;
 import java.util.Scanner;

public class Presentacion {

    static Scanner p = new Scanner(System.in);
    static Presento objTexto;
    static String mayus = "";
    static String minus = "";
    static String numeros = "";
    static String letras = "";
    static String entrada;

    static int n_mayus = 0;
    static int n_minus = 0;
    static int n_numeros = 0;
    static int n_letras = 0;
    static int n_espacios = 0;


    public static void main(String[] args) {
        
        boolean in = true;
        byte opcion;
        objTexto = new Presento();

        do {
            System.out.println("***Bienvenido al menu*** \n"
                            +"1. ingrese parrafo. \n"
                            +"2. ver parrafo y caracteres especiales \n "
                            +"3. salir \n");
            System.out.println("Ingrese una opcion: ");                
                            opcion = p.nextByte();
            if (opcion == 1) {
                Registro();
            }
            if (opcion == 2) {
                Mostrar();
            }
            if (opcion == 3) {
                System.out.println("Regrese pronto... Adios.");
                in = false;
            }                

        } while (in);
    }
    private static void Registro() {
        System.out.println("****Creacion del parrafo****");
        int i =0;
        while (i < 2) {
            System.out.println("Ingrese el parrafo: " + (i+1));
            entrada = p.nextLine();
            objTexto.adicionarParrafo(new Parrafo(entrada));
            i++;
            for (i = 0; i < entrada.length(); i++) {
                if (Character.isLetter(entrada.charAt(i))) {
                    n_letras++;
                    letras += entrada.charAt(i) + " . ";
                }
                if (Character.isUpperCase(entrada.charAt(i))) {
                    n_mayus++;
                    mayus += entrada.charAt(i)  + " . ";
                }
                if (Character.isLowerCase(entrada.charAt(i))) {
                    n_minus++;
                    minus += entrada.charAt(i)  + " . ";
                }
                if (Character.isDigit(entrada.charAt(i))) {
                    n_numeros++;
                    numeros += entrada.charAt(i)  + " . ";
                }
                if (Character.isSpaceChar(entrada.charAt(i))) {
                    n_espacios++;
                }
            }    
        }
        
    }
    private static void Mostrar() {
        System.out.println("****Listado parrafo****");
        System.out.println(objTexto.Cadena());

        System.out.println("Cadena original " + entrada);
        System.out.println("Mayusculas (" + n_mayus + "):" +mayus);
        System.out.println("Minuscula (" + n_minus + "): " + minus);
        System.out.println("Numeros (" + n_numeros + "):" + numeros);
        System.out.println("Letras (" + n_letras + "):" + letras);
        System.out.println("espacio (" + n_espacios + "):" );
    }
}    
    
