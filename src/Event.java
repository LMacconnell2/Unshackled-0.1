import java.time.LocalDateTime;

public class Event {
    private int eventID;
    private String eventType;
    private String eventTitle;
    private String eventDesc;
    private LocalDateTime eventStartDateTime;
    private LocalDateTime eventEndDateTime;
    private int eventPoints;
    private boolean completed;
        
    public Event() {} //default constructor for gson

    public Event(int eventID, String eventType, String eventTitle, String eventDesc,
             LocalDateTime eventStartDateTime, LocalDateTime eventEndDateTime,
             int eventPoints, boolean completed) {
        this.eventID = eventID;
        this.eventType = eventType;
        this.eventTitle = eventTitle;
        this.eventDesc = eventDesc;
        this.eventStartDateTime = eventStartDateTime;
        this.eventEndDateTime = eventEndDateTime;
        this.eventPoints = eventPoints;
        this.completed = completed;
    }

    //Getters =================================================================
    public int getEventID() {
        return eventID;
    }

    public String getEventType() {
        return eventType;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public String getEventDesc() {
        return eventDesc;
    }

    public LocalDateTime getEventStartDateTime() {
        return eventStartDateTime;
    }

    public LocalDateTime getEventEndDateTime() {
        return eventEndDateTime;
    }

    public int getEventPoints() {
        return eventPoints;
    }

    public boolean getCompleted() {
        return completed;
    }

    //Setters ===================================================================
    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public void setEventName(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public void setEventDesc(String eventDesc) {
        this.eventDesc = eventDesc;
    }

    public void setEventStartDateTime(LocalDateTime eventStartDateTime) {
        this.eventStartDateTime = eventStartDateTime;
    }

    public void setEventEndDateTime(LocalDateTime eventEndDateTime) {
        this.eventEndDateTime = eventEndDateTime;
    }

    public void setEventPoints(int eventPoints) {
        this.eventPoints = eventPoints;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
