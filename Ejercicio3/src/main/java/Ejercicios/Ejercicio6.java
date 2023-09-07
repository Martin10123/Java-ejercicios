package Ejercicios;

// App que lleva un listado de estudiantes que ganaron, perdieron, y tienen que nivelar
// genera las notas de los estudiantes automaticamente

public class Ejercicio6 {

    public static void main(String[] args) {

        String[] names = {"Lucia", "Pablo", "Juan", "Eduardo", "Jose", "Victoria", "Ana", "Julia", "Andres", "Miguel", "Mario", "Fernando", "Sofia", "Diana", "Carlos"};
        double[][] notes = new double[15][5];
        double[] finalNotes = new double[15];
        String[] lostStudents = new String[15];
        String[] studentsInLeveling = new String[15];
        
        int winSemester = 0;

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                notes[i][j] = Math.random() * (5 - 0) + 0;
            }
        }

        for (int i = 0; i < 15; i++) {
            double sumNotes = 0;
            for (int j = 0; j < 5; j++) {
                sumNotes += notes[i][j];
            }
            finalNotes[i] = sumNotes / 5;
        }

        int majorNote = 0;
        for (int i = 0; i < 15; i++) {
            if (finalNotes[i] > finalNotes[majorNote]) {
                majorNote = i;
            }
        }
        
        System.out.println("");
        
        System.out.println("El estudiante con la mayor nota definitiva es: " + names[majorNote]);

        int numberStudentsLost = 0;
        for (int i = 0; i < 15; i++) {
            if (finalNotes[i] < 2.0) {
                lostStudents[numberStudentsLost] = names[i];
                numberStudentsLost++;
            }
        }
        
        System.out.println("");
        
        System.out.println("Los estudiantes que perdieron la materia son: ");
        for (int i = 0; i < numberStudentsLost; i++) {
            System.out.println(lostStudents[i]);
        }
        
        System.out.println("");

        int numberStudentsLeveling = 0;
        
        for (int i = 0; i < 15; i++) {
            if (finalNotes[i] > 2.0 && finalNotes[i] < 3.0) {
                studentsInLeveling[numberStudentsLeveling] = names[i];
                numberStudentsLeveling++;
            }
        }
        
        System.out.println("");
        
        System.out.println("Los estudiantes que tendrían que habilitar la materia son: ");
        for (int i = 0; i < numberStudentsLeveling; i++) {
            System.out.println(studentsInLeveling[i]);
        }
        
        System.out.println("");

        for (int i = 0; i < 15; i++) {
            if (finalNotes[i] >= 3.0) {
                winSemester++;
            }
        }
        System.out.println("La cantidad de estudiantes que ganaron la materia es: " + winSemester);
    }
}
