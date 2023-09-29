package beans;

import clases.*;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

@Named(value = "medicamentoBean")
@SessionScoped
public class MedicamentoBean implements Serializable {

    private final String ARCHIVOMEDICAMENTOS = "medicamentos.txt";
    private final String ARCHIVOMEDICAMENTOSCAPSULA = "medicamentosCapsula.txt";
    private final String ARCHIVOMEDICAMENTOSJARABE = "medicamentosJarabe.txt";

    private Medicamento medicamento = new Medicamento();
    private List<Medicamento> listaMedicamentos;
    private List<Medicamento> listaMedicamentosCapsula;
    private List<Medicamento> listaMedicamentosJarabe;

    public MedicamentoBean() {
        listaMedicamentos = ManejarDatos.leerMedicamentos(ARCHIVOMEDICAMENTOS);
        listaMedicamentosCapsula = ManejarDatos.leerMedicamentos(ARCHIVOMEDICAMENTOSCAPSULA);
        listaMedicamentosJarabe = ManejarDatos.leerMedicamentos(ARCHIVOMEDICAMENTOSJARABE);
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    public List<Medicamento> getListaMedicamentos() {
        return listaMedicamentos;
    }

    public void setListaMedicamentos(List<Medicamento> listaMedicamentos) {
        this.listaMedicamentos = listaMedicamentos;
    }

    public List<Medicamento> getListaMedicamentosCapsula() {
        return listaMedicamentosCapsula;
    }

    public void setListaMedicamentosCapsula(List<Medicamento> listaMedicamentosCapsula) {
        this.listaMedicamentosCapsula = listaMedicamentosCapsula;
    }

    public List<Medicamento> getListaMedicamentosJarabe() {
        return listaMedicamentosJarabe;
    }

    public void setListaMedicamentosJarabe(List<Medicamento> listaMedicamentosJarabe) {
        this.listaMedicamentosJarabe = listaMedicamentosJarabe;
    }

    public void agregarMedicamento() {

        boolean estaRepetido = false;

        for (Medicamento medi : this.listaMedicamentos) {
            if (medi.getCodigo() == this.medicamento.getCodigo()) {
                estaRepetido = true;
            }
        }

        if (estaRepetido) {
            System.out.println("Este codigo ya se encuentra en la lista");
        } else {
            this.listaMedicamentos.add(this.medicamento);
            ManejarDatos.guardarEnArchivo(ARCHIVOMEDICAMENTOS, this.medicamento);
            medicamento = new Medicamento();
        }

    }

    public void agregarMedicamentosATabla(Medicamento med) {

        if (med.getForma().equals("Capsula")) {
            this.listaMedicamentosCapsula.add(med);

            this.listaMedicamentos.remove(med);
            ManejarDatos.guardarEnArchivo(ARCHIVOMEDICAMENTOSCAPSULA, med);
            ManejarDatos.eliminarMedicamento(ARCHIVOMEDICAMENTOS, String.valueOf(med.getCodigo()));
        }

        if (med.getForma().equals("Liquido")) {
            listaMedicamentosJarabe.add(med);

            listaMedicamentos.remove(med);
            ManejarDatos.guardarEnArchivo(ARCHIVOMEDICAMENTOSJARABE, med);
            ManejarDatos.eliminarMedicamento(ARCHIVOMEDICAMENTOS, String.valueOf(med.getCodigo()));
        }

    }

    public void eliminarDeLaTabla(Medicamento med) {

        if (med.getForma().equals("Capsula")) {
            this.listaMedicamentosCapsula.remove(med);
            
            this.listaMedicamentos.add(med);
            
            ManejarDatos.eliminarMedicamento(ARCHIVOMEDICAMENTOSCAPSULA, String.valueOf(med.getCodigo()));
            ManejarDatos.guardarEnArchivo(ARCHIVOMEDICAMENTOS, med);
        }

        if (med.getForma().equals("Liquido")) {
            this.listaMedicamentosJarabe.remove(med);
            
            this.listaMedicamentos.add(med);
            ManejarDatos.eliminarMedicamento(ARCHIVOMEDICAMENTOSJARABE, String.valueOf(med.getCodigo()));
            ManejarDatos.guardarEnArchivo(ARCHIVOMEDICAMENTOS, med);
        }

    }

}
