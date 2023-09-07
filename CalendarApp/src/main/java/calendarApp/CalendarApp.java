package calendarApp;

import calendarr.Event;
import calendarr.MenuEvent;
import auth.*;
import helpers.Validate;
import java.util.ArrayList;
import java.util.Scanner;

// Aplicación para guardar notas importantes en un espacio
// cuenta con un login y un register, y los datos se guardan en un archivo txt. 
// Tiene un crud tambien
// Inventado por mi

public class CalendarApp {

    static MenuRegister menuRegister = new MenuRegister();
    static MenuEvent menuEvents = new MenuEvent();
    
    public static void main(String[] args) {

        byte option = mainMenuApp();

        while (option != 0) {
            switch (option) {
                case 1 ->
                    registerNewUser();
                case 2 -> {
                    loginApp();
                }
                default ->
                    System.out.println("Esta opción no se encuentra");
            }

            option = mainMenuApp();
        }
    }

    static void registerNewUser() {

        Scanner s = new Scanner(System.in);

        System.out.print("Ingrese su nombre: ");
        String name = s.nextLine();

        while (name.length() < 3) {
            System.out.print("El nombre debe de ser más largo: ");
            name = s.nextLine();
        }
        
        System.out.print("Ingrese su email: ");
        String email = s.nextLine();

        while(!Validate.validateEmail(email)) {
            System.out.println("");
            System.out.println("Ingrese un correo electronico valido");
            email = s.nextLine();
            System.out.println("");
        }
        
        System.out.print("Ingrese su contraseña: ");
        String password = s.nextLine();

        while (password.length() < 6) {
            System.out.print("La contraseña no puede ser menor de 6 letras ");
            password = s.nextLine();
        }
        String uidUser = name + Math.random() * (1000000 + 5) + password;

        User newUser = new User(name, email, password, uidUser);

        menuRegister.addNewUser(newUser);
        menuCalendarApp(name, uidUser);

    }

    public static void loginApp() {

        Scanner s = new Scanner(System.in);

        System.out.print("Ingrese su email: ");
        String email = s.nextLine();

        System.out.print("Ingrese su contraseña: ");
        String password = s.nextLine();

        System.out.println(menuRegister);

        User userLogin = menuRegister.existUser(email, password);

        if (userLogin != null) {
            menuCalendarApp(userLogin.getName(), userLogin.getUidUser());
        } else {
            System.out.println("");
            System.out.println("Usuario y contraseña incorrectos");
            System.out.println("");
        }
    }

    static byte mainMenuApp() {
        System.out.print("Bienvenido a nuestra app\n");

        System.out.print("1. Registrarse\n");
        System.out.print("2. Ingresar\n");
        System.out.print("0. Cerrar programa\n\n");

        Scanner s = new Scanner(System.in);

        System.out.print("Ingrese una opción: ");
        byte option = s.nextByte();

        while (option < 0 || option > 2) {
            System.out.println("");
            System.out.print("Este número no se encuentra, elija otro: ");

            option = s.nextByte();
            System.out.println("");
        }

        return option;
    }

    static void menuCalendarApp(String name, String uidUser) {

        Scanner s = new Scanner(System.in);

        System.out.println("Bienvenido " + name + " abajo encontraras el meno con las diferentes opciones\n");
        System.out.println("Opciones del calendario\n");

        System.out.println("1. Agregar un nuevo evento");
        System.out.println("2. Ver todos mis eventos");
        System.out.println("3. Actualizar un eventos");
        System.out.println("4. Eliminar un eventos");
        System.out.println("5. Eliminar todos mis eventos");
        System.out.println("0. Cerrar sesión");

        System.out.print("Ingrese una opción: ");
        byte option = s.nextByte();

        while (option < 0 || option > 5) {
            System.out.println("");
            System.out.print("Este número no se encuentra, elija otro: ");

            option = s.nextByte();
            System.out.println("");
        }

        while (option != 0) {

            switch (option) {
                case 1 -> {
                    System.out.println("");
                    System.out.println("Agregar un nuevo evento al calendario");
                    System.out.println("");
                    s.nextLine();

                    System.out.println("Ingrese el titulo del evento: ");
                    String title = s.nextLine();

                    System.out.println("Ingrese una breve descripción del evento: ");
                    String description = s.nextLine();

                    System.out.print("Introduzca la fecha de inicio (dd/mm/yyyy): ");
                    String startDate = s.nextLine();

                    System.out.print("Introduzca la fecha de finalización (dd/mm/yyyy): ");
                    String endDate = s.nextLine();

                    boolean isValidDate = Validate.validateDate(startDate, endDate);

                    while (!isValidDate) {
                        System.out.println("");
                        System.out.print("Introduzca la fecha de inicio (dd/mm/yyyy): ");
                        startDate = s.nextLine();

                        System.out.print("Introduzca la fecha de finalización (dd/mm/yyyy): ");
                        endDate = s.nextLine();

                        isValidDate = Validate.validateDate(startDate, endDate);
                        System.out.println("");
                    }

                    String dateEvent = Validate.dateCreationEvent();

                    String idEvent = name + menuEvents.sizeArrayEvent() + Math.random() * 100;

                    Event newEvent = new Event(idEvent, name, title, description, dateEvent, uidUser, startDate, endDate);

                    menuEvents.addNewEvent(newEvent);

                    System.out.println("");
                    System.out.println("Se agrego correctamente el evento");
                    System.out.println("");

                }
                case 2 -> {

                    System.out.println("");
                    System.out.println("Tus eventos");
                    System.out.println("");

                    menuEvents.seeAllEvents(uidUser);

                }
                case 3 -> {

                    System.out.println("");
                    System.out.println("Actualizar un evento");
                    System.out.println("");

                    System.out.println("Todos tus eventos creados: ");
                    System.out.println("");

                    menuEvents.seeAllEvents(uidUser);
                    System.out.println("");
                    s.nextLine();

                    System.out.println("Elige un evento a actualizar mediante el id del evento (idEvent): ");
                    String idEventUpdate = s.nextLine();

                    boolean existEvent = false;

                    ArrayList<Event> eventsList = menuEvents.allEvents();

                    for (int i = 0; i < eventsList.size(); i++) {
                        existEvent = true;
                        if (eventsList.get(i).getIdEvent().equals(idEventUpdate)) {
                            System.out.print("Actualize el titulo del evento: ");
                            String updateTitle = s.nextLine();

                            System.out.print("Actualize la descripción del evento: ");
                            String updateDescription = s.nextLine();

                            System.out.print("Introduzca la fecha de inicio (dd/mm/yyyy): ");
                            String startDate = s.nextLine();

                            System.out.print("Introduzca la fecha de finalización (dd/mm/yyyy): ");
                            String endDate = s.nextLine();

                            boolean isValidDate = Validate.validateDate(startDate, endDate);

                            while (!isValidDate) {
                                System.out.println("");
                                System.out.print("Introduzca la fecha de inicio (dd/mm/yyyy): ");
                                startDate = s.nextLine();

                                System.out.print("Introduzca la fecha de finalización (dd/mm/yyyy): ");
                                endDate = s.nextLine();

                                isValidDate = Validate.validateDate(startDate, endDate);
                                System.out.println("");
                            }

                            menuEvents.updateEvent(i, new Event(eventsList.get(i).getIdEvent(), name, updateTitle, updateDescription, eventsList.get(i).getDateCreate(), uidUser, startDate, endDate));

                            System.out.println("");
                            System.out.println("Se actualizo correctamente el evento");
                            System.out.println("");
                            break;
                        }
                    }

                    if (!existEvent) {
                        System.out.println("");
                        System.out.println("No se encontro un evento con este id: " + idEventUpdate);
                        System.out.println("");
                    }

                }
                case 4 -> {
                    System.out.println("");
                    System.out.println("Eliminar un evento");
                    System.out.println("");

                    System.out.println("Todos tus eventos creados: ");
                    System.out.println("");

                    menuEvents.seeAllEvents(uidUser);
                    System.out.println("");
                    s.nextLine();

                    System.out.println("Elige un evento a eliminar mediante el id del evento (idEvent): ");
                    String idEventDelete = s.nextLine();

                    boolean existEvent = false;

                    ArrayList<Event> eventsList = menuEvents.allEvents();

                    for (int i = 0; i < eventsList.size(); i++) {
                        if (eventsList.get(i).getIdEvent().equals(idEventDelete)) {
                            menuEvents.deleteOneEvent(idEventDelete);
                        }
                    }

                    if (!existEvent) {
                        System.out.println("");
                        System.out.println("No se encontro un evento con este id: " + idEventDelete);
                        System.out.println("");
                    }

                }
                case 5 -> {
                    menuEvents.deleteAllEvents();
                }
                case 0 -> {
                    System.out.println("Cerraste cesión");

                    mainMenuApp();
                }
                default ->
                    System.out.println("Esta opción no se encontro dentro del menu");
            }

            System.out.println("");
            System.out.println("1. Agregar un nuevo evento");
            System.out.println("2. Ver todos mis eventos");
            System.out.println("3. Actualizar un eventos");
            System.out.println("4. Eliminar un eventos");
            System.out.println("5. Eliminar todos mis eventos");
            System.out.println("0. Cerrar sesión");

            System.out.print("Ingrese una opción: ");
            option = s.nextByte();

            while (option < 0 || option > 5) {
                System.out.println("");
                System.out.print("Este número no se encuentra, elija otro: ");

                option = s.nextByte();
                System.out.println("");
            }
            System.out.println("");
        }
    }

    
}
