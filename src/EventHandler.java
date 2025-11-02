import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EventHandler {
    private Map<Integer, Event> eventsList;
    private Scanner scanner;

    public EventHandler() {
        eventsList = new HashMap<>();
        scanner = new Scanner(System.in);
    }

    public Map<Integer, Event> getEventsList() {
        return eventsList;
    }

    public void setEventsList(Map<Integer, Event> eventsList) {
        this.eventsList = eventsList;
    }

    private int getNextEventID() {
        if (eventsList.isEmpty()) return 1;
        return eventsList.keySet().stream().max(Integer::compare).get() + 1;
    }

    public void createEvent() {
        int eventID = getNextEventID();

        System.out.print("Event Type: ");
        String eventType = scanner.nextLine();

        System.out.print("Event Name: ");
        String eventTitle = scanner.nextLine();

        System.out.print("Event Description: ");
        String eventDesc = scanner.nextLine();

        System.out.print("Event Start Date-Time (MM-dd-yyyy HH:mm): ");
        String startStr = scanner.nextLine();
        //AI assisted in writing the following line, LocaleDateTime is still new to me.
        LocalDateTime eventStartDateTime = LocalDateTime.parse(startStr, DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm"));

        System.out.print("Event End Date-Time (MM-dd-yyyy HH:mm): ");
        String endStr = scanner.nextLine();
        LocalDateTime eventEndDateTime = LocalDateTime.parse(endStr, DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm"));

        System.out.print("Event Points: ");
        int eventPoints = Integer.parseInt(scanner.nextLine());

        boolean completed = false;

        Event event = new Event(eventID, eventType, eventTitle, eventDesc,
                eventStartDateTime, eventEndDateTime, eventPoints, completed);

        eventsList.put(eventID, event);

        System.out.println("Event created successfully with ID " + eventID + ".");
    }

    public void editEvent() {
        System.out.print("Enter event ID to edit: ");
        int eventID = Integer.parseInt(scanner.nextLine());

        Event event = eventsList.get(eventID);
        if (event == null) {
            System.out.println("Event"+ eventID +"not found.");
            return;
        }

        System.out.print("New Event Name (leave blank to keep current): ");
        String newName = scanner.nextLine();
        if (!newName.isEmpty()) event.setEventName(newName);

        System.out.print("New Description (leave blank to keep current): ");
        String newDesc = scanner.nextLine();
        if (!newDesc.isEmpty()) event.setEventDesc(newDesc);

        System.out.print("New Event Start Date-Time (MM-dd-yyyy HH:mm): ");
        String newStartStr = scanner.nextLine();
        if (!newStartStr.isEmpty()) 
        {
            event.setEventStartDateTime(LocalDateTime.parse(newStartStr, DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm")));
        }

        System.out.print("New Event End Date-Time (MM-dd-yyyy HH:mm): ");
        String newEndStr = scanner.nextLine();
        if (!newEndStr.isEmpty()) 
        {
            event.setEventEndDateTime(LocalDateTime.parse(newEndStr, DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm")));
        }

        System.out.print("New Points value (leave blank to keep current): ");
        String newPointsStr = scanner.nextLine();
        if (!newPointsStr.isEmpty()) {
            int newPoints = Integer.parseInt(newPointsStr);
            event.setEventPoints(newPoints);
        }

        System.out.print("Event Completed? (true/false or leave blank): ");
        String newCompletedStr = scanner.nextLine();
        if (!newCompletedStr.isEmpty()) {
            boolean newCompleted = Boolean.parseBoolean(newCompletedStr);
            event.setCompleted(newCompleted);
        }

        System.out.println("Event updated successfully.");
    }

    // Delete an event
    public void deleteEvent() {
        System.out.print("Enter event ID to delete: ");
        int eventID = Integer.parseInt(scanner.nextLine());

        if (eventsList.containsKey(eventID)) {
            System.out.print("Are you sure you want to delete this event? (yes/no): ");
            String confirm = scanner.nextLine().toLowerCase();

            if (confirm.equals("yes")) {
                eventsList.remove(eventID);
                System.out.println("🗑️ Event " + eventID + " deleted.");
            } else {
                System.out.println("Deletion canceled.");
            }
        } else {
            System.out.println("❌ Event not found.");
        }
    }

    public void displayEvents(String dateInput) {
        if (eventsList.isEmpty()) {
            System.out.println("No events found.");
            return;
        }

        LocalDate filterDate = null;

        if (dateInput != null && !dateInput.isEmpty()) {
        try {
            filterDate = LocalDate.parse(dateInput, DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please use MM-dd-yyyy.");
            return;
        }
    }

        boolean anyFound = false;

    for (Map.Entry<Integer, Event> entry : eventsList.entrySet()) {
        Event event = entry.getValue();
        LocalDate eventDate = event.getEventStartDateTime().toLocalDate();

        if (filterDate == null || eventDate.equals(filterDate)) {
            anyFound = true;
            System.out.println("ID: " + event.getEventID() + " | " + event.getEventTitle() + " (" + event.getEventType() + ")");
            System.out.println("Time: " + event.getEventStartDateTime() + " - " + event.getEventEndDateTime());
            System.out.println("Description: " + event.getEventDesc());
            System.out.println("Completed: " + event.getCompleted());
        }
    }

    if (!anyFound) {
        System.out.println("No events found for " + dateInput + ".");
    }
}
}