package userInRoom;

import java.util.ArrayList;

public class MenuRoom {

    ArrayList<UserInRoom> listUsersReserved;

    public MenuRoom() {
        listUsersReserved = new ArrayList<>();
    }

    public void addNewReserv(UserInRoom newReserv) {
        listUsersReserved.add(newReserv);
    }

    public void getAllRooms() {
        for (UserInRoom room : listUsersReserved) {
            System.out.println(room.toString());
        }
    }

    public void cancelMyReserve(int idDocument) {

        for (int i = 0; i < listUsersReserved.size(); i++) {

            if (listUsersReserved.get(i).getIdDocument() == (idDocument)) {
                System.out.println("Se esta eliminando la información...");

                System.out.println(listUsersReserved.get(i).toString());

                listUsersReserved.remove(i);
                System.out.println("Se cancelo todas tus reservas, y se le cobro un 20% de comisión del total pagado");

            }

        }

    }

    public void searchUserRoom(int idDocument) {

        byte existEvent = 0;

        for (UserInRoom room : listUsersReserved) {
            if (room.getIdDocument() == (idDocument)) {
                System.out.println(room.toString());
                existEvent++;
            }
            System.out.println("");
        }

        if (existEvent == 0) {
            System.out.println("");
            System.out.println("No tiene ninguna habitación rentada aún");
            System.out.println("");
        }

    }

}
