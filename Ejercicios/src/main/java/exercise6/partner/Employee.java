package exercise6.partner;

import java.text.DecimalFormat;

public class Employee extends Partner {

    public Employee(String name, String lastName, String joinDate, double salary, float contributionPercentage, String occupation) {
        super(name, lastName, joinDate, salary, contributionPercentage, occupation);
    }

    @Override
    public void outlay() {

        DecimalFormat decimalFormatquality = new DecimalFormat("###,###.###");

        for (int cuota = super.MINQUOTA; cuota <= super.MAXQUOTASEMPLOYEE; cuota++) {

            double MaximumAmount = super.getMaximumValue(this.getSalary(), this.getJoinDate());
            double valueQuota = MaximumAmount / super.MAXQUOTASEMPLOYEE;
            double previousBalance = MaximumAmount - (cuota - 1) * valueQuota;
            double newBalance = MaximumAmount - cuota * valueQuota;

            System.out.println("Numero de cuota: " + decimalFormatquality.format(cuota));
            System.out.println("Valor: " + decimalFormatquality.format(valueQuota));
            System.out.println("Saldo Anterior: " + decimalFormatquality.format(previousBalance));
            System.out.println("Nuevo Saldo: " + decimalFormatquality.format(newBalance) + "\n");

        }

    }

}
