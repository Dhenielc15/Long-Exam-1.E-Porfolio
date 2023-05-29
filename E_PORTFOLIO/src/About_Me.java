import java.awt.Font;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class About_Me extends MainMenu {

	private static final long serialVersionUID = 1L; //Serialization compatibility field
    private JPanel contentPane; //Main panel of the frame.
	/**
	 * Create the frame.
	 */
	public About_Me() {		
		contentPane = new JPanel(); // Create a new JPanel to serve as the content pane
    	setContentPane(contentPane); // Set the content pane of the frame to the newly created JPanel
    	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); // Add an empty border to the content pane
    	contentPane.setLayout(null); // Set the layout manager of the content pane to null layout

    	// Set the application icon
        ImageIcon logo = new ImageIcon("icon.jpg");
        setIconImage(logo.getImage()); // Set the application icon image to the specified image file
        
		// Label for the JW logo
		JLabel lbllogoJW = new JLabel("");
		lbllogoJW.setIcon(new ImageIcon("works-removebg-preview (1).png"));
		lbllogoJW.setBounds(10, 0, 100, 109);
		contentPane.add(lbllogoJW);

		// Label for displaying the image
		JLabel lblImageme = new JLabel("");
		lblImageme.setIcon(new ImageIcon("IMG_1607 (1).jpg"));
		lblImageme.setBounds(148, 76, 144, 151);
		contentPane.add(lblImageme);

		// Label for "About Me" heading
		JLabel lblaboutme = new JLabel("About Me");
		lblaboutme.setBackground(new Color(0, 0, 0));
		lblaboutme.setVerticalAlignment(SwingConstants.BOTTOM);
		lblaboutme.setHorizontalAlignment(SwingConstants.CENTER);
		lblaboutme.setFont(new Font("Showcard Gothic", Font.PLAIN, 50));
		lblaboutme.setBounds(377, 11, 307, 63);
		contentPane.add(lblaboutme);

		// Text area for displaying personal information
		JTextArea Text_1 = new JTextArea();
		Text_1.setFont(new Font("Monospaced", Font.BOLD, 16));
		Text_1.setText("\r\n\r\n\r\n\r\n\r\n\r\n\r\n Name: King Dheniel N. Concepcion\r\n Bday:03/15/2004\r\n Age: 19\r\n  \r\n Hobbies:\r\n -Drawing\r\n -Watching Anime\r\n -Watching documentary about Dinosaurs\r\n -Playing Video Games\r\n\r\n\r\n \r\n\r\n");
		Text_1.setBounds(120, 76, 442, 427);
		Text_1.setEditable(false);
		contentPane.add(Text_1);

		// Text area for displaying strengths and weaknesses
		JTextArea Text_2 = new JTextArea();
		Text_2.setText("\r\nMy Strength:\r\n-My family and friends\r\n-Time Management\r\n\r\nMy Weakness:\r\n-Anxiety Attack\r\n\r\n");
		Text_2.setFont(new Font("Monospaced", Font.BOLD, 16));
		Text_2.setBounds(561, 76, 426, 427);
		Text_2.setEditable(false);
		contentPane.add(Text_2);

		// Back Button
		JButton Backbtn = new JButton("BACK");
		Backbtn.setBackground(new Color(30, 144, 255));
		Backbtn.setFont(new Font("Showcard Gothic", Font.PLAIN, 18));
		Backbtn.setBounds(463, 515, 144, 45);
		Backbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Display confirmation dialog
				int option = JOptionPane.showOptionDialog(null, "Are you sure you want to go back to the main menu?",
						"Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

				if (option == JOptionPane.YES_OPTION) {
					// Create and show the main menu frame
					MainMenu main = new MainMenu();
					main.setVisible(true);
					// Close the current frame
					dispose();
				}
			}
		});
		
		contentPane.add(Backbtn);

		// Background label
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon("Background.5 (1).png"));
		lblBackground.setBounds(0, 0, 1120, 646); // Adjusted bounds to cover the entire content pane
		contentPane.add(lblBackground);
	}
}