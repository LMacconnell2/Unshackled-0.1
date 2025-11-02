import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDateTime;

public class FileHandler {

    public FileHandler() {}

    public void saveFile(String filePath, UserData userData) {
        Gson gson = new GsonBuilder()
        .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
        .setPrettyPrinting()
        .create();

        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(userData, writer);
            System.out.println("Saved user data to JSON.");
        } catch (Exception err) {
            System.out.println("Failed to save user data to JSON: " + err.getMessage());
        }
    }

    public UserData openFile(String filePath) {
        Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
            .create();

        try (FileReader reader = new FileReader(filePath)) {
            UserData user = gson.fromJson(reader, UserData.class);
            System.out.println("Loaded user: " + user.getUser());
            return user;
        } catch (Exception err) {
            System.out.println("Failed to load user from JSON: " + err.getMessage());
            return null;
        }
    }
}