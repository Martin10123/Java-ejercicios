package calendarr;

public class Event {

    private String idEvent;
    private String name;
    private String title;
    private String description;
    private String dateCreate;
    private String uidUser;
    private String dateStart;
    private String dateEnd;

    public Event(String idEvent, String name, String title, String description, String dateCreate, String uidUser, String dateStart, String dateEnd) {
        this.idEvent = idEvent;
        this.name = name;
        this.title = title;
        this.description = description;
        this.dateCreate = dateCreate;
        this.uidUser = uidUser;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    public String getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(String idEvent) {
        this.idEvent = idEvent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getUidUser() {
        return uidUser;
    }

    public void setUidUser(String uidUser) {
        this.uidUser = uidUser;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }
    
    @Override
    public String toString() {
        return "idEvent: " + idEvent + "\nname: " + name + "\ntitle: " + title + "\ndescription: " + description + "\ndateCreate: " + dateCreate + "\nuidUser: " + uidUser + "\ndateStart: " + dateStart + "\ndateEnd: " + dateEnd;
    }

}
