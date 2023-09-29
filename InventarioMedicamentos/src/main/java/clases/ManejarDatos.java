package clases;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ManejarDatos {

    public static void guardarEnArchivo(String nombreDelArchivo, Medicamento medicamento) {
        try {
            String escritorioPath = System.getProperty("user.home") + "/Desktop/";
            FileWriter writer = new FileWriter(escritorioPath + nombreDelArchivo, true);

            try (BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
                bufferedWriter.write(String.valueOf(medicamento.getCodigo()));
                bufferedWriter.write(",");
                bufferedWriter.write(medicamento.getNombre());
                bufferedWriter.write(",");
                bufferedWriter.write(medicamento.getForma());
                bufferedWriter.write(",");
                bufferedWriter.write(medicamento.getFechaCaducidad());
                bufferedWriter.write(",");
                bufferedWriter.write(medicamento.getViaConsumo());
                bufferedWriter.write(",");
                bufferedWriter.write(String.valueOf(medicamento.getDosis()));
                bufferedWriter.newLine();

                bufferedWriter.close();
                System.out.println("El objeto se ha guardado correctamente en el archivo.");
            }

        } catch (IOException e) {
            e.printStackTrace(System.out);
            System.out.println("GUARDAR: Ocurrió un error al guardar el medicamento en el archivo: " + e.getMessage());
        }

    }

    public static List<Medicamento> leerMedicamentos(String nombreDelArchivo) {

        List<Medicamento> listPersonas = new ArrayList<>();

        try {
            String escritorioPath = System.getProperty("user.home") + "/Desktop/";
            FileReader reader = new FileReader(escritorioPath + nombreDelArchivo);

            try (BufferedReader bufferedReader = new BufferedReader(reader)) {
                String linea;
                while ((linea = bufferedReader.readLine()) != null) {
                    String[] partes = linea.split(",");

                    if (partes.length >= 6) {
                        Medicamento medicamento = new Medicamento();
                        medicamento.setCodigo(Integer.parseInt(partes[0]));
                        medicamento.setNombre(partes[1]);
                        medicamento.setForma(partes[2]);
                        medicamento.setFechaCaducidad(partes[3]);
                        medicamento.setViaConsumo(partes[4]);
                        medicamento.setDosis(Integer.parseInt(partes[5]));

                        listPersonas.add(medicamento);
                    } else {
                        System.out.println("Saltar linea insuficiente: " + linea);
                    }

                }

            }
        } catch (IOException e) {
            e.printStackTrace(System.out);
            System.out.println("LEER: Ocurrió un error al leer el medicamento en el archivo: " + e.getMessage());
        }

        return listPersonas;
    }

    public static void eliminarMedicamento(String nombreDelArchivo, String codigoAEliminar) {
        
        try {
            String escritorioPath = System.getProperty("user.home") + "/Desktop/";

            File archivo = new File(escritorioPath + nombreDelArchivo);
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            List<String> lineas = new ArrayList<>();
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");

                if (partes.length > 0 && !partes[0].equals(codigoAEliminar)) {
                    lineas.add(linea);
                }
            }

            br.close();

            BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));

            for (String lineaActualizada : lineas) {
                bw.write(lineaActualizada);
                bw.newLine();
            }

            bw.close();

            System.out.println("La línea con el código " + codigoAEliminar + " fue eliminada exitosamente.");
        } catch (IOException e) {
            e.printStackTrace(System.out);
            System.err.println("Ocurrió un error al leer/escribir el archivo: " + e.getMessage());
        }
    }
}
