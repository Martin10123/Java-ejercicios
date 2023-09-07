package calendarr;

import java.io.*;
import java.util.ArrayList;

public class MenuEvent {

    ArrayList<Event> eventsList;

    public MenuEvent() {
        eventsList = new ArrayList<>();
       
         if (new File("listEvents.txt").exists()) {
            loadDataFromFile();
        }
        
    }

    public void addNewEvent(Event newEvent) {
        eventsList.add(newEvent);
        writeDataToFile();
    }

    public int sizeArrayEvent() {
        return eventsList.size();
    }

    public boolean knowIfDateIsNear(String dateEnd) {

       return true;
    }

    public ArrayList<Event> allEvents() {
        return eventsList;
    }

    public void seeAllEvents(String uidUserActive) {

        byte existEvent = 0;

        for (Event event : eventsList) {
            if (event.getUidUser().equals(uidUserActive)) {
                System.out.println(event.toString());
                existEvent++;
            }
            System.out.println("");
        }

        if (existEvent == 0) {
            System.out.println("");
            System.out.println("No tienes eventos aún");
            System.out.println("");
        }
    }

    public void deleteOneEvent(String idEvent) {

        boolean existEvent = false;

        for (int i = 0; i < eventsList.size(); i++) {

            if (eventsList.get(i).getIdEvent().equals(idEvent)) {
                System.out.println("Se esta eliminando la información...");

                System.out.println();
                System.out.println("Se esta eliminando el siguiente array...");
                System.out.println();
                System.out.println(eventsList.get(i).toString());
                System.out.println();

                eventsList.remove(i);
                System.out.println("Se elimino correctamente el array");

            }

        }

        if (!existEvent) {
            System.out.println("");
            System.out.println("No se encontro un evento con este id: " + idEvent);
            System.out.println("");
        }

    }

    public void updateEvent(int iPosition, Event eventUpdate) {
        eventsList.set(iPosition, eventUpdate);
    }

    public void deleteAllEvents() {
        eventsList.clear();
    }
    
      private void writeDataToFile() {
        try {
            File file = new File("listEvents.txt");
            FileWriter writer = new FileWriter(file, true);

            for (Event event : eventsList) {
                String eventData = event.getIdEvent() + "; " + event.getName() + "; " + event.getTitle() + "; " + event.getDescription() + "; " + event.getDateCreate() + "; " + event.getUidUser() + "; " + event.getDateStart() + "; " + event.getDateEnd() + "\n";
                writer.write(eventData);
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("Error en consola: " + e);
        }
    }

    private void loadDataFromFile() {
        try {
            File file = new File("listEvents.txt");
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] userData = line.split(";");
                
                System.out.println(userData[0]);
                
                Event user = new Event(userData[0], userData[1], userData[2], userData[3], userData[4], userData[5], userData[6], userData[7]);
                eventsList.add(user);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
