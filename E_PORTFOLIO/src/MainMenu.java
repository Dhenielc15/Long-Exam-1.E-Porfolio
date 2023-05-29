import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MainMenu extends JFrame {

    private static final long serialVersionUID = 1L; //Serialization compatibility field
    private JPanel contentPane; //Main panel of the frame.
    private Clip clip;//Audio clip for playing sound.
    private boolean musicOn = true;//Indicates if music is playing.
    private File soundFile = new File("Welcome to Jurassic World.wav");//File object representing the "Welcome to Jurassic World.wav" audio file


    public MainMenu() {
    	super("E-Portfolio"); // Create a JFrame with the title "E-Portfolio"
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set the default close operation to exit the application when the frame is closed
    	setBounds(100, 100, 1120, 646); // Set the position and size of the frame to (x, y, width, height)
    	contentPane = new JPanel(); // Create a new JPanel to serve as the content pane
    	setResizable(false); // Disable frame resizing
    	setContentPane(contentPane); // Set the content pane of the frame to the newly created JPanel
    	contentPane.setLayout(null); // Set the layout manager of the content pane to null, allowing for absolute positioning of components
    	setLocationRelativeTo(null); // Set the location of the frame relative to null, which centers the frame on the screen

        ImageIcon logo = new ImageIcon("icon.jpg");
        setIconImage(logo.getImage()); // Set the application icon image to the specified image file
     // "Welcome to" Label
        JLabel lblWELCOME = new JLabel("Welcome to");
        lblWELCOME.setBackground(new Color(0, 0, 0));
        lblWELCOME.setVerticalAlignment(SwingConstants.BOTTOM);
        lblWELCOME.setFont(new Font("Showcard Gothic", Font.BOLD, 50));
        lblWELCOME.setBounds(43, 11, 425, 81);
        contentPane.add(lblWELCOME);

        
     // "e-PORTFOLIO" Label
        JLabel lblEPORTFOLIO = new JLabel("e-PORTFOLIO");
        lblEPORTFOLIO.setBackground(new Color(0, 0, 0));
        lblEPORTFOLIO.setVerticalAlignment(SwingConstants.BOTTOM);
        lblEPORTFOLIO.setFont(new Font("Showcard Gothic", Font.BOLD, 50));
        lblEPORTFOLIO.setBounds(182, 86, 425, 81);
        contentPane.add(lblEPORTFOLIO);

     // Music Button
        JButton musicButton = new JButton("");
        musicButton.setIcon(new ImageIcon("sound-removebg-preview (1) (1).png"));
        musicButton.setBounds(955, 11, 79, 67);
        musicButton.setOpaque(false); // set button to be transparent
        musicButton.setBackground(new Color(0, 0, 0, 0)); // set background color to transparent
        musicButton.setBorder(null); // remove button border
        musicButton.setFocusPainted(false); // disable default click highlight
        musicButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (musicOn) {
                    // If music is currently off, play the music
                    try {
                        // Load the audio file and create a Clip object
                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
                        
                        // Open the audioInputStream and set the clip to loop continuously
                        clip = AudioSystem.getClip();
                        clip.open(audioInputStream);
                        clip.loop(Clip.LOOP_CONTINUOUSLY);
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                        System.out.println("Error playing sound.");
                        ex.printStackTrace();
                    }
                    musicOn = false; // Set musicOn flag to false indicating music is playing
                } else {
                    // If music is currently on, stop and close the clip
                    clip.stop();
                    clip.close();
                    musicOn = true; // Set musicOn flag to true indicating music is stopped
                }
            }
        });
        contentPane.add(musicButton);
      
        JButton btnachieve = new JButton("");
		btnachieve.setIcon(new ImageIcon("achievement-removebg-preview (1).png"));
		btnachieve.setBounds(1021, 11, 89, 75);
		btnachieve.setOpaque(false); // set button to be transparent
		btnachieve.setBackground(new Color(0,0,0,0)); // set background color to transparent
		btnachieve.setBorder(null); // remove button border
		btnachieve.setFocusPainted(false); // disable default click highlight
		contentPane.add(btnachieve);
		btnachieve.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
		        JOptionPane.showMessageDialog(null, "Achievements:\n- Champion in Tangram Puzzle\n- 5th Place in Poster Making\n- SHS With Honors\n- Conduct Awards", "Achievements", JOptionPane.INFORMATION_MESSAGE);
		    }
		});
        
        JButton BUTTONABOUTME = new JButton("About Me");
        BUTTONABOUTME.setForeground(new Color(0, 0, 0));
        BUTTONABOUTME.setIcon(new ImageIcon("Icon1.png"));
        BUTTONABOUTME.setFont(new Font("Showcard Gothic", Font.PLAIN, 28));
        BUTTONABOUTME.setBounds(62, 229, 325, 157);
        BUTTONABOUTME.setOpaque(false); // set button to be transparent
        BUTTONABOUTME.setBackground(new Color(0,0,0,0)); // set background color to transparent
        BUTTONABOUTME.setBorder(null); // remove button border
        BUTTONABOUTME.setFocusPainted(false); // disable default click highlight
        BUTTONABOUTME.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showOptionDialog(null, "Do you want to Continue?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

                if (option == JOptionPane.YES_OPTION) {
                    // Create and show the other frame
                    About_Me main = new About_Me();
                    main.setVisible(true);
                    // Close the current frame
                    dispose();
                }
            }
        });
        contentPane.add(BUTTONABOUTME);
        
        JButton Skillsbtn = new JButton("Skills");
        Skillsbtn.setForeground(new Color(0, 0, 0));
        Skillsbtn.setIcon(new ImageIcon("Icon1.png"));
        Skillsbtn.setFont(new Font("Showcard Gothic", Font.PLAIN, 28));
        Skillsbtn.setBounds(62, 397, 275, 157);
        Skillsbtn.setOpaque(false); // set button to be transparent
        Skillsbtn.setBackground(new Color(0, 0, 0, 0)); // set background color to transparent
        Skillsbtn.setBorder(null); // remove button border
        Skillsbtn.setFocusPainted(false); // disable default click highlight
        Skillsbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Display a confirmation dialog
                int option = JOptionPane.showOptionDialog(null, "Do you want to continue?", "Confirmation",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

                if (option == JOptionPane.YES_OPTION) {
                    // If user selects "Yes", open the Skills frame and close the current frame
                    Skills main = new Skills();
                    main.setVisible(true);
                    // Close the current frame
                    dispose();
                }
            }
        });
        contentPane.add(Skillsbtn);

        JButton Worksbtn = new JButton("Works");
        Worksbtn.setForeground(new Color(0, 0, 0));
        Worksbtn.setIcon(new ImageIcon("Icon1.png"));
        Worksbtn.setFont(new Font("Showcard Gothic", Font.PLAIN, 28));
        Worksbtn.setBounds(427, 229, 275, 157);
        Worksbtn.setOpaque(false); // set button to be transparent
        Worksbtn.setBackground(new Color(0, 0, 0, 0)); // set background color to transparent
        Worksbtn.setBorder(null); // remove button border
        Worksbtn.setFocusPainted(false); // disable default click highlight
        Worksbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Display a confirmation dialog
                int option = JOptionPane.showOptionDialog(null, "Do you want to continue?", "Confirmation",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

                if (option == JOptionPane.YES_OPTION) {
                    // If user selects "Yes", open the Works frame and close the current frame
                	Works main = new Works();
                    main.setVisible(true);
                    // Close the current frame
                    dispose();
                }
            }
        });
        contentPane.add(Worksbtn);

     // Exit Button
        JButton Exitbtn = new JButton("");
        Exitbtn.setIcon(new ImageIcon("exit (1).png"));
        Exitbtn.setBounds(1042, 554, 62, 53);
        Exitbtn.setOpaque(false); // set button to be transparent
        Exitbtn.setBackground(new Color(0, 0, 0, 0)); // set background color to transparent
        Exitbtn.setBorder(null); // remove button border
        Exitbtn.setFocusPainted(false); // disable default click highlight
        Exitbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Display a confirmation dialog
                int option = JOptionPane.showOptionDialog(null, "Do you want to exit?", "Confirmation",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

                if (option == JOptionPane.YES_OPTION) {
                    // If user selects "Yes", exit the application
                    System.exit(0);
                }
            }
        });
        contentPane.add(Exitbtn);
        
        // Secret Button
        JButton Secretbtn = new JButton("");
        Secretbtn.setIcon(new ImageIcon("BUTTON GAME.PNG"));
        Secretbtn.setBounds(702, 310, 408, 327);
        Secretbtn.setOpaque(false); // set button to be transparent
        Secretbtn.setBackground(new Color(0, 0, 0, 0)); // set background color to transparent
        Secretbtn.setBorder(null); // remove button border
        Secretbtn.setFocusPainted(false); // disable default click highlight
        Secretbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Display a confirmation dialog
                int option = JOptionPane.showOptionDialog(null, "Do you want to test the game?", "Confirmation",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

                if (option == JOptionPane.YES_OPTION) {
                    // If user selects "Yes", open the Main frame and close the current frame
                	MiniGame game = new MiniGame();
                    game.setVisible(true);
                    dispose();
                }
            }
        });
        contentPane.add(Secretbtn);

        // Background Label
        JLabel lblBackground = new JLabel("");
        lblBackground.setIcon(new ImageIcon("BACKGROUND.PNG"));
        lblBackground.setBounds(0, 0, 1104, 607);
        contentPane.add(lblBackground);
    }
    /**
	 * Launch the application.
	 */
    public static void main(String[] args) {
        MainMenu frame = new MainMenu();
        frame.setVisible(true);
    }	
}