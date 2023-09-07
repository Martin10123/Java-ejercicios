package ventana;

import java.util.ArrayList;
import java.util.Scanner;

public class Encriptar {

    static ArrayList<GuardarPassword> passwordList = new ArrayList<>();
    static ArrayList<Auth> usuariosList = new ArrayList<>();

    static String encriptarContra(String password, int cantidadCaracteres) {
        String[] caracteres = {
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"
        };

        String passwordEncript = "";

        for (int i = 0; i <= cantidadCaracteres; i++) {
            int longitud = (int) (Math.random() * caracteres.length);
            passwordEncript += caracteres[longitud];
        }

        String[] passwords = {password, passwordEncript};

        GuardarPassword passwordd = new GuardarPassword(passwords);
        passwordList.add(passwordd);

        return passwordEncript;

    }

    static void buscarPassword(String email, String password) {

        for (Auth user : usuariosList) {

            if (user.getEmail().equals(email)) {

                for (GuardarPassword passwordGuardada : passwordList) {

                    if (passwordGuardada.getPassword()[1].equals(user.getPassword())) {
                        System.out.println("Tú email es: " + user.getEmail());
                        System.out.println("Tu contraseña normal es: " + passwordGuardada.getPassword()[0]);
                        System.out.println("Tu contraseña encriptada es: " + passwordGuardada.getPassword()[1]);
                    }

                }

            }

        }

    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int i = 1;
        int o = 1;

        while (i <= 3) {

            System.out.println(i + ". Ingrese un email: ");
            String email = s.next();

            System.out.println("Ingrese una contraseña: ");
            String password = s.next();

            String passwordEncript = encriptarContra(password, 20);

            usuariosList.add(new Auth(email, passwordEncript));
            i++;
        }

        while (o <= 3) {

            System.out.println("");
            System.out.println("Hacer login ");
            System.out.println("");

            System.out.println("Ingrese un email: ");
            String email1 = s.next();

            System.out.println("Ingrese una contraseña: ");
            String password1 = s.next();

            buscarPassword(email1, password1);
            o++;
        }
    }

}
