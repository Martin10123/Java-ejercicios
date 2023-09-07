
package helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Validate {
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
