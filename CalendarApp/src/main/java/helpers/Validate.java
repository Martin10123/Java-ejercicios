package helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Validate {

    public static boolean validateEmail(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    public static String dateCreationEvent() {

        Calendar cal = Calendar.getInstance();

        int day = cal.get(Calendar.DAY_OF_MONTH);
        int mounth = cal.get(Calendar.MONTH) + 1;
        int year = cal.get(Calendar.YEAR);
        int hour = cal.get(Calendar.HOUR_OF_DAY);

        return day + "-" + mounth + "-" + year + "a las: " + hour;

    }

    public static boolean validateDate(String dateStart, String dateEnd) {
        Date dateOne = null;
        Date dateTwo = null;

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dateOne = dateFormat.parse(dateStart);
            dateTwo = dateFormat.parse(dateEnd);

        } catch (ParseException e) {
            System.out.println("La fecha ingresada no es válida");
            return false;
        }
        
          if (dateOne.getTime() < dateTwo.getTime()) {
                return true;
            } else {
                System.out.println("La fecha de inicio no puede ser menor a la fecha de finalización");
                return false;
            }

    }

}
