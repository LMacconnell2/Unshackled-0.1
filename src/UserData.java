import java.util.HashMap;
import java.util.Map;

public class UserData {
    private String user;
    private int userID;
    private Map<Integer, Integer> highScores;
    private int currentBalance;
    private Map<Integer, Event> events;

    public UserData() { //default constructor for gson. Initializes highScores and events automatically in case they are forgotten when the class is called.
        this.highScores = new HashMap<>();
        this.events = new HashMap<>();
    } 

    public UserData(String user, int userID, Map<Integer, Integer> highScores, int currentBalance,
             Map<Integer, Event> events) {
        this.user = user;
        this.userID = userID;
        this.highScores = highScores;
        this.currentBalance = currentBalance;
        this.events = events;
    } //More detailed constructor should it be necessary.

    // Getters ====================================
    public String getUser() {
        return user;
    }

    public int getUserID() {
        return userID;
    }

    public Map<Integer, Integer> getHighScores() {
        return highScores;
    }

    public int getCurrentBalance() {
        return currentBalance;
    }

    public Map<Integer, Event> getEvents() {
        return events;
    }

    // Setters ==================================
    public void setUser(String user) {
        this.user = user;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setHighScores(Map<Integer, Integer> highScores) {
        this.highScores = highScores;
    }

    public void setCurrentBalance(int currentBalance) {
        this.currentBalance = currentBalance;
    }

    public void setEvents(Map<Integer, Event> events) {
        this.events = events;
    }
}
