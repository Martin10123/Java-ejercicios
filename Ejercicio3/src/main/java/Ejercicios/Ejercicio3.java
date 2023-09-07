package Ejercicios;

//        Usando estructuras repetitivas, elabore un algoritmo, que genere e
//        imprima las letras del abecedario de la siguiente forma:
//        Z Y X W V U T S R Q P O N M L K J I H G F E D C B A
//        Y X W V U T S R Q P O N M L K J I H G F E D C B A
//        X W V U T S R Q P O N M L K J I H G F E D C B A
//        W V U T S R Q P O N M L K J I H G F E D C B A
//        V U T S R Q P O N M L K J I H G F E D C B A
//        U T S R Q P O N M L K J I H G F E D C B A
//        T S R Q P O N M L K J I H G F E D C B A
//        S R Q P O N M L K J I H G F E D C B A
//        R Q P O N M L K J I H G F E D C B A
//        Q P O N M L K J I H G F E D C B A
//        P O N M L K J I H G F E D C B A
//        O N M L K J I H G F E D C B A
//        N M L K J I H G F E D C B A
//        M L K J I H G F E D C B A
//        L K J I H G F E D C B A
//        K J I H G F E D C B A
//        J I H G F E D C B A
//        I H G F E D C B A
//        H G F E D C B A
//        G F E D C B A
//        F E D C B A
//        E D C B A
//        D C B A
//        C B A
//        B A
//        A
public class Ejercicio3 {

    public static void main(String[] args) {

        String[] abecedario = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        for (int i = abecedario.length; i > 0; i--) {
            String letras = "";
            for (int j = i - 1; j >= 0; j--) {
                letras += abecedario[j] + " ";
            }

            System.out.println(letras);
        }

    }
}
