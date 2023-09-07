package dataHotel;

public class RoomData {

    int idBedRoom;
    String typeBedroom;
    int available;
    int nightValue;
    int oneRoom;
    int twoRooms;
    int threeRooms;
    int fourRooms;
    String information;

    public RoomData(int idBedRoom, String typeBedroom, int available, int nightValue, int oneRoom, int twoRooms, int threeRooms, int fourRooms, String information) {
        this.idBedRoom = idBedRoom;
        this.typeBedroom = typeBedroom;
        this.available = available;
        this.nightValue = nightValue;
        this.oneRoom = oneRoom;
        this.twoRooms = twoRooms;
        this.threeRooms = threeRooms;
        this.fourRooms = fourRooms;
        this.information = information;
    }

    public int getIdBedRoom() {
        return idBedRoom;
    }

    public void setIdBedRoom(int idBedRoom) {
        this.idBedRoom = idBedRoom;
    }

    public String getTypeBedroom() {
        return typeBedroom;
    }

    public void setTypeBedroom(String typeBedroom) {
        this.typeBedroom = typeBedroom;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public int getNightValue() {
        return nightValue;
    }

    public void setNightValue(int nightValue) {
        this.nightValue = nightValue;
    }

    public int getOneRoom() {
        return oneRoom;
    }

    public void setOneRoom(int oneRoom) {
        this.oneRoom = oneRoom;
    }

    public int getTwoRooms() {
        return twoRooms;
    }

    public void setTwoRooms(int twoRooms) {
        this.twoRooms = twoRooms;
    }

    public int getThreeRooms() {
        return threeRooms;
    }

    public void setThreeRooms(int threeRooms) {
        this.threeRooms = threeRooms;
    }

    public int getFourRooms() {
        return fourRooms;
    }

    public void setFourRooms(int fourRooms) {
        this.fourRooms = fourRooms;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

   
    

    @Override
   public String toString() {
        return "id de la Habitacion: " + idBedRoom + "\nTipo de habitación: " + typeBedroom + "\nDisponibles: " + available + "\nValor por noche: " + nightValue + "\nUna habitacion: " + oneRoom + "\nDos habitaciones: " + twoRooms + "\nTres habitaciones: " + threeRooms + "\nCuatro habitaciones: " + fourRooms + "\nInformación: " + information;
    }
    
    
}
