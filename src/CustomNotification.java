import java.awt.*;
import javax.swing.*;

public class CustomNotification {
    public static void showNotification(Event event) {
        SwingUtilities.invokeLater(() -> {
            JFrame notificationFrame = new JFrame();
            notificationFrame.setUndecorated(true);
            notificationFrame.setSize(600, 120);
            notificationFrame.setLayout(new BorderLayout());

            String message = "<html><b>" + event.getEventTitle() + "</b><br>"
                             + event.getEventDesc() + "<br>"
                             + "Points: " + event.getEventPoints() + "</html>";

            JLabel notificationLabel = new JLabel(message, SwingConstants.CENTER);
            notificationLabel.setFont(new Font("Roboto", Font.BOLD, 14));
            notificationFrame.add(notificationLabel, BorderLayout.CENTER);

            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int x = screenSize.width - notificationFrame.getWidth() - 20;
            int y = screenSize.height - notificationFrame.getHeight() - 60;
            notificationFrame.setLocation(x, y);

            notificationFrame.setAlwaysOnTop(true);
            notificationFrame.setVisible(true);

            new Timer(5000, e -> notificationFrame.dispose()).start();
        });
    }
}
