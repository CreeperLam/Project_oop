import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Menu extends JFrame {

    public Menu() {
        setTitle("Plant Vs Zombies");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1100, 650); // Set appropriate size according to the image
        // Create a JPanel to hold the background image
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                try {
                    // Load the image from the path and resize it
                    BufferedImage image = ImageIO.read(getClass().getResource("/images/PVsZ_Wallpaper.png"));
                    Image scaledImage = image.getScaledInstance(1100, 650, Image.SCALE_SMOOTH);
                    g.drawImage(scaledImage, 0, 0, null);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        };

        // Set the background color of backgroundPanel to banana color
        backgroundPanel.setBackground(new Color(218, 235, 124));

        // Use BoxLayout for backgroundPanel
        backgroundPanel.setLayout(new BoxLayout(backgroundPanel, BoxLayout.Y_AXIS));

        // Create a JPanel to hold the button group
        JPanel buttonGroupPanel = new JPanel();
        buttonGroupPanel.setLayout(new BoxLayout(buttonGroupPanel, BoxLayout.Y_AXIS)); // Vertical row

        // Set the background color of buttonGroupPanel to match the background color of the image
        buttonGroupPanel.setOpaque(false);

        // New size for the JButtons
        Dimension buttonSize = new Dimension(200, 60); // Width: 250, Height: 60

        // Add buttons to buttonGroupPanel
        JButton button1 = new JButton("Play Game");
        button1.setMaximumSize(buttonSize);
        button1.setBackground(new Color(0, 128, 0)); // Green color
        button1.setFont(new Font("Segoe UI Black", Font.BOLD, 24));
        button1.setForeground(new Color(51, 51, 0));
        button1.setAlignmentX(Component.CENTER_ALIGNMENT); // Set button to center horizontally

        JButton button2 = new JButton("Button 2");
        button2.setMaximumSize(buttonSize);
        button2.setBackground(new Color(0, 128, 0)); // Green color
        button2.setFont(new Font("Segoe UI Black", Font.BOLD, 24));
        button2.setForeground(new Color(51, 51, 0));
        button2.setAlignmentX(Component.CENTER_ALIGNMENT); // Set button to center horizontally

        JButton button3 = new JButton("Exit Game");
        button3.setMaximumSize(buttonSize);
        button3.setBackground(new Color(0, 128, 0)); // Green color
        button3.setFont(new Font("Segoe UI Black", Font.BOLD, 24));
        button3.setForeground(new Color(51, 51, 0));
        button3.setAlignmentX(Component.CENTER_ALIGNMENT); // Set button to center horizontally

        // Register ActionListener for button1
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add action when button2 is clicked
                GameWindow.begin();
            }
        });

        // Register ActionListener for button3
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add action when button3 is clicked
                int choice = JOptionPane.showConfirmDialog(null, "Do you want to exit the game?", "Exit Game", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    System.exit(0); // Exit the application
                }
            }
        });

        buttonGroupPanel.add(Box.createVerticalStrut(10)); // Spacing between button 1 and button 2
        buttonGroupPanel.add(button1);
        buttonGroupPanel.add(Box.createVerticalStrut(50)); // Spacing between button 2 and button 3
        buttonGroupPanel.add(button3);

        // Set buttonGroupPanel to the center of backgroundPanel
        backgroundPanel.add(Box.createVerticalGlue()); // Top spacing
        backgroundPanel.add(buttonGroupPanel);
        backgroundPanel.add(Box.createVerticalGlue()); // Bottom spacing

        // Display JFrame
        getContentPane().add(backgroundPanel);
        setVisible(true);
    }
}
