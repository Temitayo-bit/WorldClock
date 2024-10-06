package world.clock;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class WorldClock1 extends JFrame {

    private JLabel[] clockLabels;

    public WorldClock1() {
        setTitle("");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create labels for each clock
        clockLabels = new JLabel[8];
        
        clockLabels[0] = createClockLabel("Nigeria", "Africa/Lagos");
        clockLabels[1] = createClockLabel("New York", "America/New_York");
        clockLabels[2] = createClockLabel("London", "Europe/London");
        clockLabels[3] = createClockLabel("Tokyo", "Asia/Tokyo");
        clockLabels[4] = createClockLabel("Sydney", "Australia/Sydney");    
        clockLabels[5] = createClockLabel("Chicago", "America/Chicago" );
        clockLabels[6] = createClockLabel("Melbourne", "Australia/Melbourne");
        clockLabels[7] = createClockLabel("Dubai", "Asia/Dubai");
        
        

        // Add the back button to the frame
        
        
    
     


        
        
         

        
        // Add labels to the frame
        setLayout(new GridLayout(4, 1));
        for (JLabel label : clockLabels) {
            add(label);
        }

        // Update the clocks every second
        Timer timer = new Timer(1000, e -> updateClocks());
        timer.start();
    }

    private JLabel createClockLabel(String cityName, String timeZoneId) {
        JLabel label = new JLabel();
        label.setFont(new Font("Arial", Font.PLAIN, 24));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBorder(BorderFactory.createTitledBorder(cityName));

        TimeZone timeZone = TimeZone.getTimeZone(timeZoneId);
        label.putClientProperty("timeZone", timeZone);

        return label;
    }

    private void updateClocks() {
        Date now = new Date();

        for (JLabel label : clockLabels) {
            TimeZone timeZone = (TimeZone) label.getClientProperty("timeZone");
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            sdf.setTimeZone(timeZone);
            label.setText(sdf.format(now));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            WorldClock1 app = new WorldClock1();
            app.setVisible(true);
        });
    }
     
    
        
        

}
