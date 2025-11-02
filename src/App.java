import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Welcome to Unshackled, a program to help you manage your time.");
        System.out.println("Select an option to begin:");
        System.out.println("================================================================================");

        Scanner scanner = new Scanner(System.in);
        EventHandler eventHandler = new EventHandler();
        UserData userData = new UserData();
        FileHandler fileHandler = new FileHandler(); //This line and the following line synch data between User Data and Event Data
        userData.setEvents(eventHandler.getEventsList());
        userData.setUser("Logan"); //Ideally this would be set by the user
        userData.setUserID(1); // Same as user

        while (true) {
            //Really basic menu displayed to the terminal
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
                //Calls a method in eventHandler to create a new Event object
                eventHandler.createEvent();
                System.out.println("[Creating new event...]");
                userData.setEvents(eventHandler.getEventsList()); //Always updates the list after a change is made.
                System.out.println();
            }
            else if (response.equals("2")) {
                //calls a method in eventHandler to edit the data in an Event object with a given ID
                eventHandler.displayEvents(null); //Displays all events first.
                eventHandler.editEvent();
                userData.setEvents(eventHandler.getEventsList()); //Always updates the list after a change is made.
                System.out.println();
            }
            else if (response.equals("3")) {
                //calls a method in eventHandler to delete an object.
                eventHandler.deleteEvent();
                userData.setEvents(eventHandler.getEventsList()); //Always updates the list after a change is made.
                System.out.println();
            }
            //Displays events based upon the date provided by the user.
            else if (response.equals("4")) {
                System.out.print("What date would you like to view? (mm-dd-yyyy): ");
                String date = scanner.nextLine();
                System.out.println("[Viewing calendar for " + date + "]");
                eventHandler.displayEvents(date);
                System.out.println();
            }
            // This is non-functioning at the moment. To be added at a future date.
            else if (response.equals("5")) {
                // UserData.DisplayHighScores();
                System.out.println("[Displaying high scores...]");
                System.out.println();
            }
            //Saves the current event and user data to a file.
            else if (response.equals("6")) {
                System.out.println("Choose a filepath: ");
                String filePath = scanner.nextLine();
                fileHandler.saveFile(filePath, userData);
                System.out.println();
            }
            //Loads data from a file.
            else if (response.equals("7")) {
                System.out.println("Choose a filepath: ");
                String filePath = scanner.nextLine();
                userData = fileHandler.openFile(filePath);
                eventHandler.setEventsList(userData.getEvents());
                System.out.println();
            }
            //Displays a notification in the bottom right of the screen with data from an Event determined by its ID
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
            //End the program
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
