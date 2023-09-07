package bookhotel;

import dataHotel.DataHotel;
import helpers.Validate;
import java.util.Scanner;
import userInRoom.MenuRoom;
import userInRoom.UserInRoom;

// Es una aplicación que te permite reservar cuartos en un hotel, te otorga varias opciones
// donde puedes reservar, ver la información del hotel, saber en que habitacion reservaste y cancelarlas
// Tiene un crud, calculos etc.
// Fue inventado por mi

public class BookHotel {

    static DataHotel listHotels = new DataHotel();
    static MenuRoom listUsersInRooms = new MenuRoom();

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        System.out.println("");
        System.out.println("Bienvenidos al hotel super start");
        System.out.println("");

        System.out.println("1. Reservar");
        System.out.println("2. Ver información del hotel");
        System.out.println("3. Cancelar mi reservación");
        System.out.println("4. En que habitación estoy?");
        System.out.println("0. Cerrar programa");

        System.out.println("Elegir una opción");
        byte option = s.nextByte();

        while (option < 0 || option > 4) {
            System.out.println("Esta opción no se encuentra dentro de la lista, ingrese otro");
            option = s.nextByte();
        }

        while (option != 0) {

            switch (option) {
                case 1 -> {

                    listHotels.showAllRooms();

                    System.out.println("Cuantas habitaciones deseas rentar?");
                    byte howManyRoomsRent = s.nextByte();

                    byte[] listTypeBedRooms = new byte[howManyRoomsRent];
                    byte[] listHowManyEachRooms = new byte[howManyRoomsRent];
                    boolean[] selectAtLeastOne = new boolean[howManyRoomsRent];

                    for (int i = 0; i < howManyRoomsRent; i++) {

                        System.out.println("Que tipo de habitación elige?");
                        byte idBedRoom = s.nextByte();

                        while (idBedRoom < 1 || idBedRoom > 7) {

                            System.out.println("Esta opción no se encuentra dentro de la lista, ingrese otro");
                            idBedRoom = s.nextByte();

                        }

                        listTypeBedRooms[i] = idBedRoom;

                        System.out.println("Cuantos cuartos?");
                        byte howManyRooms = s.nextByte();

                        while (howManyRooms < 1 || howManyRooms > 4) {

                            System.out.println("Esta opción no se encuentra dentro de la lista, ingrese otro");
                            howManyRooms = s.nextByte();

                        }

                        listHowManyEachRooms[i] = howManyRooms;

                        boolean isCorrectRoom = listHotels.roomSelectedChanges(idBedRoom, howManyRooms);

                        selectAtLeastOne[i] = isCorrectRoom;

                        while (!isCorrectRoom) {

                            System.out.println("Te gustaria elegir otra opción?");

                            System.out.println("1. Si!");
                            System.out.println("2. No!");

                            byte optionRee = s.nextByte();

                            if (optionRee == 1) {

                                System.out.println("Que tipo de habitación elige?");
                                idBedRoom = s.nextByte();

                                while (idBedRoom < 1 || idBedRoom > 7) {

                                    System.out.println("Esta opción no se encuentra dentro de la lista, ingrese otro");
                                    idBedRoom = s.nextByte();

                                }

                                listTypeBedRooms[i] = idBedRoom;

                                System.out.println("Cuantos cuartos?");
                                howManyRooms = s.nextByte();

                                while (howManyRooms < 1 || howManyRooms > 4) {

                                    System.out.println("Esta opción no se encuentra dentro de la lista, ingrese otro");
                                    howManyRooms = s.nextByte();

                                }

                                listHowManyEachRooms[i] = howManyRooms;

                                isCorrectRoom = listHotels.roomSelectedChanges(idBedRoom, howManyRooms);

                                selectAtLeastOne[i] = isCorrectRoom;

                            } else {
                                isCorrectRoom = true;
                                selectAtLeastOne[i] = false;
                            }

                        }

                    }

                    boolean thereOne = false;

                    for (boolean b : selectAtLeastOne) {
                        if (b == true) {
                            thereOne = true;
                            break;
                        }
                    }

                    if (!thereOne) {
                        System.out.println("Se cerro el programa");
                        return;
                    }

                    System.out.println("Cual es su nombre?");
                    String name = s.next();

                    System.out.println("Cual es su número de telefono?");
                    int phoneNumber = s.nextInt();

                    System.out.println("Cuantas personas se hospedan?");
                    byte howManyAreStaying = s.nextByte();

                    System.out.println("Cual es su número de documento?");
                    int idDocument = s.nextInt();

                    System.out.println("Forma en la que quieres pagar?");
                    System.out.println("1. Tarjeta de credito");
                    System.out.println("2. Pago en efectivo");

                    byte howPay = s.nextByte();

                    String formPay = howPay == 1 ? "Tarjeta de credito" : "Pago en efectivo";

                    int[] totalPay = listHotels.totalPriceToPay(listTypeBedRooms, listHowManyEachRooms, formPay);

                    System.out.println("Serian en total por todo: " + totalPay[0]);

                    if (totalPay[1] != 0) {
                        System.out.println("Por comprar con tarjeta de credito se le hace un descuento del 10%, ahora el valor a pagar es: ");
                        System.out.println(totalPay[1]);
                    }

                    System.out.print("Introduzca la fecha de inicio (dd/mm/yyyy): ");
                    String startDate = s.next();

                    System.out.print("Introduzca la fecha de finalización (dd/mm/yyyy): ");
                    String endDate = s.next();

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

                    UserInRoom newUserInRoom = new UserInRoom(name, phoneNumber, listHowManyEachRooms, howManyAreStaying, idDocument, formPay, listTypeBedRooms, startDate, endDate);

                    listUsersInRooms.addNewReserv(newUserInRoom);

                    System.out.println("Se registro al usuario");

                    listHotels.showAllRooms();
                }

                case 2 -> {
                    System.out.println("Información sobre nuestro hotel");
                    System.out.println("");

                    System.out.println("El hotel Luxury Suites ofrece a sus huéspedes una experiencia de lujo sin igual. Ubicado en una zona privilegiada, este hotel lujoso cuenta con habitaciones y suites modernas y equipadas con todas las comodidades para garantizar la mejor experiencia de sus huéspedes. \nLos huéspedes que realicen sus pagos con tarjeta de crédito recibirán un descuento del 10% sobre el precio total de la habitación. \nLos huéspedes que deseen cancelar su reservación deberán tener en cuenta que se les cobrará un 20% del precio total de la reservación. Para cancelar una reservación se recomienda hacerlo con anticipación para evitar gastos innecesarios.");
                }
                case 3 -> {
                    
                    System.out.println("Aqui puedes cancelar todas tus reservas");
                    System.out.println("");

                    System.out.println("Ingrese el número de documento: ");
                    int idDocument = s.nextInt();

                    listUsersInRooms.cancelMyReserve(idDocument);
                    
                }
                case 4 -> {

                    System.out.println("Aqui puedes ver los cuartos que has reservado");
                    System.out.println("");

                    System.out.println("Ingrese el número de documento: ");
                    int idDocument = s.nextInt();

                    listUsersInRooms.searchUserRoom(idDocument);

                }
                case 0 -> {
                    System.out.println("Cerraste el programa");
                    return;
                }
                default ->
                    throw new AssertionError();
            }

            System.out.println("");
            System.out.println("1. Reservar");
            System.out.println("2. Ver información del hotel");
            System.out.println("3. Cancelar mi reservación");
            System.out.println("4. En que habitación estoy?");
            System.out.println("0. Cerrar programa");

            System.out.println("Elegir una opción");
            option = s.nextByte();

            while (option < 0 || option > 4) {
                System.out.println("Esta opción no se encuentra dentro de la lista, ingrese otro");
                option = s.nextByte();
            }

        }
    }

}
