import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Welcome to Unshackled, a program to help you manage your time.");
        System.out.println("Select an option to begin:");
        System.out.println("================================================================================");

        Scanner scanner = new Scanner(System.in);
        EventHandler eventHandler = new EventHandler();
        UserData userData = new UserData();
        FileHandler fileHandler = new FileHandler();
        userData.setEvents(eventHandler.getEventsList());
        userData.setUser("Logan");
        userData.setUserID(1);

        while (true) {
            System.out.println();
            System.out.println("1. Create New Event");
            System.out.println("2. Edit an Event");
            System.out.println("3. Remove an Event");
            System.out.println("4. View Calendar");
            System.out.println("5. View High Scores");
            System.out.println("6. Save Progress");
            System.out.println("7. Load Progress");
            System.out.println("8. Show Notification");
            System.out.println("9. Quit");
            System.out.print("Enter your choice: ");

            String response = scanner.nextLine();

            System.out.println();

            if (response.equals("1")) {
                eventHandler.createEvent();
                System.out.println("[Creating new event...]");
                userData.setEvents(eventHandler.getEventsList());
                System.out.println();
            }
            else if (response.equals("2")) {
                eventHandler.displayEvents(null);
                eventHandler.editEvent();
                userData.setEvents(eventHandler.getEventsList());
                System.out.println();
            }
            else if (response.equals("3")) {
                eventHandler.deleteEvent();
                userData.setEvents(eventHandler.getEventsList());
                System.out.println();
            }
            else if (response.equals("4")) {
                System.out.print("What date would you like to view? (mm-dd-yyyy): ");
                String date = scanner.nextLine();
                System.out.println("[Viewing calendar for " + date + "]");
                eventHandler.displayEvents(date);
                System.out.println();
            }
            else if (response.equals("5")) {
                // UserData.DisplayHighScores();
                System.out.println("[Displaying high scores...]");
                System.out.println();
            }
            else if (response.equals("6")) {
                System.out.println("Choose a filepath: ");
                String filePath = scanner.nextLine();
                fileHandler.saveFile(filePath, userData);
                System.out.println();
            }
            else if (response.equals("7")) {
                System.out.println("Choose a filepath: ");
                String filePath = scanner.nextLine();
                userData = fileHandler.openFile(filePath);
                eventHandler.setEventsList(userData.getEvents());
                System.out.println();
            }
            else if (response.equals("8")) {
                System.out.print("Choose an Event ID: ");
                int input = Integer.parseInt(scanner.nextLine());
                Event event = eventHandler.getEventsList().get(input);
                if (event != null) {
                    CustomNotification.showNotification(event);
                } else {
                    System.out.println("Event not found!");
                }
            }
            else if (response.equals("9")) {
                break;
            }
            else {
                System.out.println("Invalid input. Please try again.");
            }

            System.out.println("================================================================================");
        }

        scanner.close();
    }
}
