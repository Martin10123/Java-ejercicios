package dataHotel;

import java.util.ArrayList;

public class DataHotel {

    ArrayList<RoomData> listHotels;

    public DataHotel() {

        listHotels = new ArrayList<>();

        listHotels.add(new RoomData(1, "Suite", 5, 1000000, 2, 3, 0, 0, ": también conocida como “semi suite” ofrece espacios privados y confortables al igual que la suite. Por norma general, disponen de salón, hall, amplio baño y área de oficina."));
        listHotels.add(new RoomData(2, "Presidencial", 10, 500000, 5, 5, 0, 0, "ocupan grandes espacios, incluso un piso entero. Las suites presidenciales solo están disponibles en alojamientos de categoría superior. Cuentan con varios dormitorios con sus respectivos cuartos de baño, salón, comedor y cocina."));
        listHotels.add(new RoomData(3, "Habitación doble", 15, 350000, 0, 15, 0, 0, "La habitación doble es la modalidad más común y frecuente entre amigos, compañeros de trabajo y familiares. Podemos encontrar habitaciones dobles con dos camas individuales o una cama doble ideales para hospedar a dos adultos y, en situaciones especiales, a una o dos personas más. En el caso de los niños, cada hotel tiene la libertad de establecer sus propias normas como por ejemplo incluir o no cunas o camas supletorias a menores de 12 años sin coste adicional."));
        listHotels.add(new RoomData(4, "Habitación individual", 16, 200000, 16, 0, 0, 0, "Los hoteles suelen ofrecer la habitación individual (también conocida como single) cuando el establecimiento no tiene disponibilidad para ofrecer otro tipo de habitación. Cuentan con una cama individual y una superficie que puede variar entre los 8 y 14 metros cuadrados. "));
        listHotels.add(new RoomData(5, "Suite doble", 8, 2500000, 3, 5, 0, 0, " cuenta con dos dormitorios (uno con cama matrimonial y otro con dos camas individuales). Cada dormitorio posee su propio baño."));
        listHotels.add(new RoomData(6, "Habitación cuádruple", 20, 150000, 5, 5, 5, 5, "En función de los tipos de hoteles que existen, la superficie de una habitación cuádruple puede variar entre los 17,5 metros cuadrados (hoteles de 1 estrella) y los 25 metros cuadrados (hoteles de 5 estrellas) Están compuestas por 2 camas grandes o 4 camas individuales para un máximo de 4 huéspedes."));
        listHotels.add(new RoomData(7, "Habitación doble con terraza", 30, 100000, 15, 15, 0, 0, "Son habitaciones que se encuentran ubicadas en las plantas más altas del edificio. Al contar con vistas privilegiadas y otros servicios adicionales exclusivos suelen ser más caras."));

    }

    public void showAllRooms() {
        for (RoomData listHotel : listHotels) {
            System.out.println(listHotel.toString());
            System.out.println("");
        }

    }

    public boolean roomSelectedChanges(byte idBedRoom, byte howManyRooms) {

        for (RoomData hotel : listHotels) {

            if (hotel.getIdBedRoom() == idBedRoom) {
                switch (howManyRooms) {
                    case 1 -> {
                        if (hotel.getOneRoom() != 0) {
                            hotel.setAvailable(hotel.getAvailable() - 1);
                            hotel.setOneRoom(hotel.getOneRoom() - 1);

                        } else {
                            System.out.println("Lo siento, por el momento no tenemos habitaciones con la cantidad de cuartos que quieres, cantidad: " + howManyRooms);

                            return false;
                        }
                    }
                    case 2 -> {
                        if (hotel.getTwoRooms() != 0) {
                            hotel.setAvailable(hotel.getAvailable() - 1);
                            hotel.setTwoRooms(hotel.getTwoRooms() - 1);

                        } else {
                            System.out.println("Lo siento, por el momento no tenemos habitaciones con la cantidad de cuartos que quieres, cantidad: " + howManyRooms);

                            return false;
                        }
                    }
                    case 3 -> {
                        if (hotel.getThreeRooms() != 0) {
                            hotel.setAvailable(hotel.getAvailable() - 1);
                            hotel.setThreeRooms(hotel.getThreeRooms() - 1);

                        } else {
                            System.out.println("Lo siento, por el momento no tenemos habitaciones con la cantidad de cuartos que quieres, cantidad: " + howManyRooms);

                            return false;
                        }
                    }
                    case 4 -> {
                        if (hotel.getFourRooms() != 0) {
                            hotel.setAvailable(hotel.getAvailable() - 1);
                            hotel.setFourRooms(hotel.getFourRooms() - 1);

                        } else {
                            System.out.println("Lo siento, por el momento no tenemos habitaciones con la cantidad de cuartos que quieres, cantidad: " + howManyRooms);

                            return false;
                        }
                    }
                }

            }
        }

        return true;

    }

    public int[] totalPriceToPay(byte[] idBedRoom, byte[] howManyRooms, String formPay) {

        int totalPriceToReturn = 0;
        int totalPriceIfHaveDiscount = 0;

        for (RoomData hotel : listHotels) {

            for (byte idTypeRoom : idBedRoom) {

                if (hotel.getIdBedRoom() == idTypeRoom) {

                    for (byte howManyRoom : howManyRooms) {

                        switch (howManyRoom) {
                            case 1 -> {
                                totalPriceToReturn += hotel.getNightValue();
                            }
                            case 2 -> {
                                totalPriceToReturn += hotel.getNightValue() + 50000;
                            }
                            case 3 -> {
                                totalPriceToReturn += hotel.getNightValue() + 100000;
                            }
                            case 4 -> {
                                totalPriceToReturn += hotel.getNightValue() + 150000;
                            }

                        }

                    }

                }

            }

        }
        
         if (formPay.equals("Tarjeta de credito")) {
            totalPriceIfHaveDiscount = (int) (totalPriceToReturn - (totalPriceToReturn * 0.10));
        }
        
        int[] prices = {totalPriceToReturn, totalPriceIfHaveDiscount};
        
        return prices;

    }

    public void whereIsRooms(int idDocument) {

        
    }

}
