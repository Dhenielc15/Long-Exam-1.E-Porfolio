import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class Mainclass extends JFrame {

	private JPanel contentPane;
	private File soundFile = new File("Welcome to Jurassic World.wav");
	private Clip clip;
	private boolean musicOn = true;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
					Mainclass frame = new Mainclass();
					frame.setVisible(true);
				}
	/**
	 * Create the frame.
	 */
	public Mainclass() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1136, 685);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
        setLocationRelativeTo(null); //relocate to the center
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon logo = new ImageIcon("icon.jpg");
	    setIconImage(logo.getImage());
	       
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
		contentPane.add(BUTTONABOUTME);
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
		
		JLabel lblEPORTFOLIO = new JLabel("E-PORTFOLIO");
		lblEPORTFOLIO.setBackground(new Color(0, 0, 0));
		lblEPORTFOLIO.setVerticalAlignment(SwingConstants.BOTTOM);
		lblEPORTFOLIO.setFont(new Font("Showcard Gothic", Font.BOLD, 50));
		lblEPORTFOLIO.setBounds(182, 86, 425, 81);
		contentPane.add(lblEPORTFOLIO);
		
		JLabel lblCoollets = new JLabel("WELCOME TO");
		lblCoollets.setBackground(new Color(0, 0, 0));
		lblCoollets.setVerticalAlignment(SwingConstants.BOTTOM);
		lblCoollets.setFont(new Font("Showcard Gothic", Font.BOLD, 50));
		lblCoollets.setBounds(43, 11, 425, 81);
		contentPane.add(lblCoollets);
		
		    
		JButton musicButton = new JButton("");
		musicButton.setIcon(new ImageIcon("sound-removebg-preview (1) (1).png"));
		musicButton.setBounds(955, 11, 79, 67);
		musicButton.setOpaque(false); // set button to be transparent
		musicButton.setBackground(new Color(0,0,0,0)); // set background color to transparent
		musicButton.setBorder(null); // remove button border
		musicButton.setFocusPainted(false); // disable default click highlight
		musicButton.addActionListener(new ActionListener() {
		    boolean musicOn = true;
		    public void actionPerformed(ActionEvent e) {
		        if (musicOn) {
		            try {
		                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
		                clip = AudioSystem.getClip();
		                clip.open(audioInputStream);
		                clip.loop(Clip.LOOP_CONTINUOUSLY);
		            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
		                System.out.println("Error playing sound.");
		                ex.printStackTrace();
		            }
		            musicOn = false;
		        } else {
		            clip.stop();
		            clip.close();
		            musicOn = true;
		        }
		    }
		});
		contentPane.add(musicButton);
	
		
		contentPane.add(musicButton);
		JButton Exitbtn = new JButton("");
		Exitbtn.setIcon(new ImageIcon("exit (1).png"));
		Exitbtn.setBounds(1037, 566, 62, 53);
		Exitbtn.setOpaque(false); // set button to be transparent
		Exitbtn.setBackground(new Color(0,0,0,0)); // set background color to transparent
		Exitbtn.setBorder(null); // remove button border
		Exitbtn.setFocusPainted(false); // disable default click highlight
		contentPane.add(Exitbtn);
		Exitbtn.addActionListener(new ActionListener() {	       
	        public void actionPerformed(ActionEvent e) {
	        	 int option = JOptionPane.showOptionDialog(null, "            Are you sure?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
			      
			        if (option == JOptionPane.YES_OPTION) {
	        System.exit(0);   
			        }
	        	}
	    	});
		
		JButton BUTTONWORKS = new JButton("Works");
		BUTTONWORKS.setIcon(new ImageIcon("Icon1.png"));
		BUTTONWORKS.setOpaque(false);
		BUTTONWORKS.setForeground(Color.BLACK);
		BUTTONWORKS.setFont(new Font("Showcard Gothic", Font.PLAIN, 28));
		BUTTONWORKS.setFocusPainted(false);
		BUTTONWORKS.setBorder(null);
		BUTTONWORKS.setBackground(new Color(0, 0, 0, 0));
		BUTTONWORKS.setBounds(397, 229, 312, 157);
		contentPane.add(BUTTONWORKS);
		BUTTONWORKS.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			   int option = JOptionPane.showOptionDialog(null, "Do you want to Continue?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
			      
		        if (option == JOptionPane.YES_OPTION) {
		         // Create and show the other frame
		         Works main = new Works();
		         main.setVisible(true);
		         // Close the current frame
		         dispose();
		            }
		        }
		    });
				
		JButton BTNSKILL = new JButton("Skills");
		BTNSKILL.setForeground(new Color(0, 0, 0));
		BTNSKILL.setIcon(new ImageIcon("Icon1.png"));
		BTNSKILL.setFont(new Font("Showcard Gothic", Font.PLAIN, 28));
		BTNSKILL.setBounds(62, 397, 275, 157);
		BTNSKILL.setOpaque(false); // set button to be transparent
		BTNSKILL.setBackground(new Color(0,0,0,0)); // set background color to transparent
		BTNSKILL.setBorder(null); // remove button border
		BTNSKILL.setFocusPainted(false); // disable default click highlight
		contentPane.add(BTNSKILL);
		BTNSKILL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				   int option = JOptionPane.showOptionDialog(null, "Do you want to Continue?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
				      
			        if (option == JOptionPane.YES_OPTION) {
			         // Create and show the other frame
			         Skills main = new Skills();
			         main.setVisible(true);
			         // Close the current frame
			         dispose();
			            }
			        }
			    });
			
		JButton SECRETBTN = new JButton("");
		SECRETBTN.setIcon(new ImageIcon("BUTTON GAME.PNG"));
		SECRETBTN.setBounds(712, 330, 408, 327);
		SECRETBTN.setOpaque(false); // set button to be transparent
		SECRETBTN.setBackground(new Color(0,0,0,0)); // set background color to transparent
		SECRETBTN.setBorder(null); // remove button border
		SECRETBTN.setFocusPainted(false); // disable default click highlight
		contentPane.add(SECRETBTN);
		SECRETBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				   int option = JOptionPane.showOptionDialog(null, "Do you want to Continue?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
				      
			        if (option == JOptionPane.YES_OPTION) {
			         // Create and show the other frame
			         Main main = new Main();
			         main.setVisible(true);
			         // Close the current frame
			         dispose();
			            }
			        }
			    });	
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon("BACKGROUND.PNG"));
		lblBackground.setBounds(0, 0, 1120, 646);
		contentPane.add(lblBackground);
	}           
}

