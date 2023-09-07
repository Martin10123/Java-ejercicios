package userInRoom;

import java.util.Arrays;

public class UserInRoom {

    private String name;
    private int phoneNumber;
    private byte[] howManyRooms;
    private byte howManyAreStaying;
    private int idDocument;
    private String formPay;
    private byte[] typeBedRooms;
    private String startDate;
    private String endDate;

    public UserInRoom(String name, int phoneNumber, byte[] howManyRooms, byte howManyAreStaying, int idDocument, String formPay, byte[] typeBedRooms, String startDate, String endDate) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.howManyRooms = howManyRooms;
        this.howManyAreStaying = howManyAreStaying;
        this.idDocument = idDocument;
        this.formPay = formPay;
        this.typeBedRooms = typeBedRooms;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public byte[] getHowManyRooms() {
        return howManyRooms;
    }

    public void setHowManyRooms(byte[] howManyRooms) {
        this.howManyRooms = howManyRooms;
    }

    public byte getHowManyAreStaying() {
        return howManyAreStaying;
    }

    public void setHowManyAreStaying(byte howManyAreStaying) {
        this.howManyAreStaying = howManyAreStaying;
    }

    public int getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(int idDocument) {
        this.idDocument = idDocument;
    }

    public String getFormPay() {
        return formPay;
    }

    public void setFormPay(String formPay) {
        this.formPay = formPay;
    }

    public byte[] getTypeBedRooms() {
        return typeBedRooms;
    }

    public void setTypeBedRooms(byte[] typeBedRooms) {
        this.typeBedRooms = typeBedRooms;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "name=" + name + ", phoneNumber=" + phoneNumber + ", howManyRooms=" + Arrays.toString(howManyRooms) + ", howManyAreStaying=" + howManyAreStaying + ", idDocument=" + idDocument + ", formPay=" + formPay + ", typeBedRooms=" + Arrays.toString(typeBedRooms) + ", startDate=" + startDate + ", endDate=" + endDate;
    }

}
