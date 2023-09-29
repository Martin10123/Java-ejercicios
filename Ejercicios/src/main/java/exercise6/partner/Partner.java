package exercise6.partner;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

public abstract class Partner {

    protected String name;
    protected String lastName;
    protected String joinDate;
    protected double salary;
    protected float contributionPercentage;
    protected String occupation;

    protected final int MAXSALARY = 4000000;
    protected final int GETSMV = 1200000;
    protected final int MAXQUOTASEMPLOYEE = 12;
    protected final int MAXQUOTASADMINISTRATIVE = 15;
    protected final int MINQUOTA = 1;

    public Partner(String name, String lastName, String joinDate, double salary, float contributionPercentage, String occupation) {
        this.name = name;
        this.lastName = lastName;
        this.joinDate = joinDate;
        this.salary = salary;
        this.contributionPercentage = contributionPercentage;
        this.occupation = occupation;
    }

    protected abstract void outlay();

    protected double getMaximumValue(double getSalaryEOA, String joinDate) {
        int antiquity = getYearAntiquity(joinDate);

        double maximumSum = 0;

        if (getSalaryEOA < MAXSALARY) {

            if (antiquity < 1) {
                maximumSum = ((getSalaryEOA * 2) + 15 * GETSMV);
            } else if (antiquity > 1 && antiquity <= 2) {
                maximumSum = ((getSalaryEOA * 4) + 18 * GETSMV);
            } else if (antiquity > 2 && antiquity <= 4) {
                maximumSum = ((getSalaryEOA * 8) + 21 * GETSMV);
            } else if (antiquity > 4) {
                maximumSum = ((getSalaryEOA * 12) + 25 * GETSMV);
            }

        } else {
            if (antiquity <= 1) {
                maximumSum = 3 * getSalaryEOA + 15 * GETSMV;
            } else if (antiquity <= 2) {
                maximumSum = 5 * getSalaryEOA + 20 * GETSMV;
            } else if (antiquity <= 4) {
                maximumSum = 10 * getSalaryEOA + 22 * GETSMV;
            } else {
                maximumSum = 15 * getSalaryEOA + 26 * GETSMV;
            }
        }

        return maximumSum;
    }

    ;
    
    protected int getYearAntiquity(String joinDate) {
        LocalDate hoy = LocalDate.now();
        LocalDate hireDateEmployee = LocalDate.parse(joinDate, DateTimeFormatter.ofPattern("d/M/yyyy"));

        int antiquity = hoy.compareTo(hireDateEmployee);

        return antiquity;
    }

    protected void showMessageJoption(String message) {
        JOptionPane.showMessageDialog(null, message, "Info sobre el valor maximo", 2);
    }

    public String getFirstName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public double getSalary() {
        return salary;
    }

    public float getContributionPercentage() {
        return contributionPercentage;
    }

    public String getOccupation() {
        return occupation;
    }

}
