import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Main extends JFrame implements ActionListener {

    JButton betaButton, profileButton, exitButton, backButton; // Declare backButton
    private File soundFile = new File("GAME SOUND.wav");
    private Clip clip;
    
    public Main() {
        // Set up the main frame
        setTitle("Elephant anf the Hunter Beta Version");
        setSize(420, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

       ImageIcon logo = new ImageIcon("APPLICATION.png");
       setIconImage(logo.getImage());
       
        // Create the content panel with the background image
        JPanel contentPanel = new JPanel() {
            BufferedImage image = null;
            {
                try {
                    image = ImageIO.read(new File("APPLICATION.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (image != null) {
                    g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
                }
            }
        };
        contentPanel.setLayout(new BorderLayout()); //relocate to the center

        // Add buttons
        betaButton = new JButton("Play Test Game");
        betaButton.setFont(new Font("Arial", Font.PLAIN, 18));
        betaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Starting Beta Game...");
                dispose(); // Close current frame
                MiniGame game = new MiniGame(); // Open new frame
                game.setVisible(true);
            }
        });
        profileButton = new JButton("Developer Profile");
        profileButton.setFont(new Font("Arial", Font.PLAIN, 18));
        profileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Opening Developer Profile...");
                dispose(); // Close current frame
                MyProfileGUI myProfileGUI = new MyProfileGUI(); // Open new frame
            }
        });
        
        // Create a panel to hold the buttons and add them to it
        exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arial", Font.PLAIN, 18));
        exitButton.addActionListener(this);
        backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.PLAIN, 18));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close current frame
                Main main = new Main(); // Open new frame
                main.setVisible(true);
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close current frame
                Mainclass main = new Mainclass();
                main.setVisible(true);
            }
        });      
        JButton musicButton = new JButton("Music: ON");
        musicButton.setFont(new Font("Arial", Font.PLAIN, 18));
        musicButton.addActionListener(new ActionListener() {
            boolean musicOn = true;
            public void actionPerformed(ActionEvent e) {
                if (musicOn) {
                    stopSound();
                    musicButton.setText("Music: On");
                    musicOn = false;
                } else {
                    playSound();
                    musicButton.setText("Music: Off");
                    musicOn = true;
                }
            }
        });
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(betaButton);
        buttonPanel.add(profileButton);
        buttonPanel.add(backButton); 
        buttonPanel.add(musicButton);// Add backButton
        buttonPanel.add(exitButton);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 40, 10));
        contentPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Add the content panel to the frame
        setContentPane(contentPanel);

        // Center the frame on the screen
        setLocationRelativeTo(null);

        setVisible(true); // Show the frame
    }
    private void playSound() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
        }
    }
    private void stopSound() {
        if (clip != null) {
            clip.stop();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exitButton) {
            dispose(); // Close the frame
        }
    
    }
    
}
