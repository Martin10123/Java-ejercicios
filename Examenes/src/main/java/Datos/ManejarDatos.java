package Datos;

import Modelo.*;
import java.io.*;
import java.util.*;

public class ManejarDatos {

    public static void guardarExamenCalificado(ExamenEstudiante examen) {
        try {
            FileWriter writer = new FileWriter("ExamenesCalificados.txt", true);

            try (BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
                bufferedWriter.write(examen.getCodigo());
                bufferedWriter.write(",");
                bufferedWriter.write(examen.getNombreEstudiante());
                bufferedWriter.write(",");
                bufferedWriter.write(String.valueOf(examen.getPreguntasBuenas()));
                bufferedWriter.write(",");
                bufferedWriter.write(examen.getEstado());
                bufferedWriter.write(",");
                bufferedWriter.write(String.valueOf(examen.getNotaExamen()));
                bufferedWriter.write(",");
                
                bufferedWriter.newLine();

                bufferedWriter.close();
                System.out.println("El objeto se ha guardado correctamente en el archivo.");
            }

        } catch (IOException e) {
            e.printStackTrace(System.out);
            System.out.println("GUARDAREXAMENCALIFICADO: Ocurrió un error al guardar el medicamento en el archivo: " + e.getMessage());
        }
    }

    public static void guardarExamenEntregado(ExamenEstudiante examen) {
        try {
            FileWriter writer = new FileWriter("ExamenesEntregados.txt", true);

            try (BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
                bufferedWriter.write(examen.getCodigo());
                bufferedWriter.write(",");
                bufferedWriter.write(examen.getNombreEstudiante());
                bufferedWriter.write(",");
                bufferedWriter.newLine();

                bufferedWriter.close();
                System.out.println("El objeto se ha guardado correctamente en el archivo.");
            }

        } catch (IOException e) {
            e.printStackTrace(System.out);
            System.out.println("GUARDAREXAMENENTREGADO: Ocurrió un error al guardar el medicamento en el archivo: " + e.getMessage());
        }
    }

    public static void guardarExamenCreado(Examen examen) {
        try {
            FileWriter writer = new FileWriter("ExamenesCreadosNuevos.txt");

            try (BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
                bufferedWriter.write(examen.getCodigo());
                bufferedWriter.write(",");
                bufferedWriter.write(String.valueOf(examen.getNumeroPreguntas()));
                bufferedWriter.write(",");
                bufferedWriter.newLine();

                bufferedWriter.close();
                System.out.println("El objeto se ha guardado correctamente en el archivo.");
            }

        } catch (IOException e) {
            e.printStackTrace(System.out);
            System.out.println("GUARDAREXAMEN: Ocurrió un error al guardar el medicamento en el archivo: " + e.getMessage());
        }
    }

    public static List<ExamenEstudiante> leerExamenesCalificados() {

        List<ExamenEstudiante> listExamanes = new ArrayList<>();

        try {
            FileReader reader = new FileReader("ExamenesCalificados.txt");

            try (BufferedReader bufferedReader = new BufferedReader(reader)) {
                String linea;
                while ((linea = bufferedReader.readLine()) != null) {
                    String[] partes = linea.split(",");

                    if (partes.length >= 5) {
                        ExamenEstudiante examenCalificado = new ExamenEstudiante();
                        examenCalificado.setCodigo((partes[0]));
                        examenCalificado.setNombreEstudiante(partes[1]);
                        examenCalificado.setPreguntasBuenas(Integer.parseInt(partes[2]));
                        examenCalificado.setEstado(partes[3]);
                        examenCalificado.setNotaExamen(Double.parseDouble(partes[4]));

                        listExamanes.add(examenCalificado);
                    } else {
                        System.out.println("Saltar linea insuficiente: " + linea);
                    }

                }

            }
        } catch (IOException e) {
            e.printStackTrace(System.out);
            System.out.println("LEEREXAMENCALIFICADO: Ocurrió un error al leer el medicamento en el archivo: " + e.getMessage());
        }

        return listExamanes;
    }

    public static Stack<ExamenEstudiante> leerExamenesEntregados() {

        Stack<ExamenEstudiante> listExamanes = new Stack<>();

        try {
            FileReader reader = new FileReader("ExamenesEntregados.txt");

            try (BufferedReader bufferedReader = new BufferedReader(reader)) {
                String linea;
                while ((linea = bufferedReader.readLine()) != null) {
                    String[] partes = linea.split(",");

                    if (partes.length >= 2) {
                        ExamenEstudiante examenCalificado = new ExamenEstudiante();
                        examenCalificado.setCodigo((partes[0]));
                        examenCalificado.setNombreEstudiante(partes[1]);

                        listExamanes.add(examenCalificado);
                    } else {
                        System.out.println("Saltar linea insuficiente: " + linea);
                    }

                }

            }
        } catch (IOException e) {
            e.printStackTrace(System.out);
            System.out.println("LEEREXAMENCALIFICADO: Ocurrió un error al leer el medicamento en el archivo: " + e.getMessage());
        }

        return listExamanes;
    }

    public static Examen leerExamenNuevoCreado() {

        Examen examenCreado = new Examen();

        try {
            FileReader reader = new FileReader("ExamenesCreadosNuevos.txt");

            try (BufferedReader bufferedReader = new BufferedReader(reader)) {
                String linea;
                while ((linea = bufferedReader.readLine()) != null) {
                    String[] partes = linea.split(",");

                    if (partes.length >= 2) {
                        Examen examenNuevoCreado = new Examen();
                        examenNuevoCreado.setCodigo((partes[0]));
                        examenNuevoCreado.setNumeroPreguntas(Integer.parseInt(partes[1]));

                        examenCreado = examenNuevoCreado;
                    } else {
                        System.out.println("Saltar linea insuficiente: " + linea);
                    }

                }

            }
        } catch (IOException e) {
            e.printStackTrace(System.out);
            System.out.println("LEEREXAMENCREADONUEVO: Ocurrió un error al leer el medicamento en el archivo: " + e.getMessage());
        }

        return examenCreado;
    }

    public static void eliminarExamenEntregado(String codigoAEliminar) {
        
        System.out.println("CODIGOAELIMINAR: " + codigoAEliminar);
        
        try {
            File archivo = new File("ExamenesEntregados.txt");
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            List<String> lineas = new ArrayList<>();
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");

                if (partes.length > 0 && partes[0].equals(codigoAEliminar)) {
                    // No agregamos esta línea a la lista (la estamos eliminando)
                    System.out.println("El examen entregado con código " + codigoAEliminar + " fue eliminado exitosamente.");
                } else {
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

        } catch (IOException e) {
            e.printStackTrace(System.out);
            System.err.println("Ocurrió un error al leer/escribir el archivo: " + e.getMessage());
        }
    }
}
