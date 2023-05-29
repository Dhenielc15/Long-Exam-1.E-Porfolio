import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class About_Me extends JFrame {

	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public About_Me() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1113, 621);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
        setLocationRelativeTo(null); //relocate to the center
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon logo = new ImageIcon("icon.jpg");
	    setIconImage(logo.getImage());
	    
		JButton Backbtn = new JButton("BACK");
		Backbtn.setBackground(new Color(30, 144, 255));
		Backbtn.setFont(new Font("Showcard Gothic", Font.PLAIN, 18));
		Backbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				       
				        int option = JOptionPane.showOptionDialog(null, "Are you sure you want to go back to the main menu?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
				      
				        if (option == JOptionPane.YES_OPTION) {
				         // Create and show the other frame
				         Mainclass main = new Mainclass();
				         main.setVisible(true);
				         // Close the current frame
				         dispose();
				            }
				        }
				    });
		
		JLabel lblImageme = new JLabel("");
		lblImageme.setIcon(new ImageIcon("IMG_1607 (1).jpg"));
		lblImageme.setBounds(148, 76, 144, 151);
		contentPane.add(lblImageme);
		Backbtn.setBounds(463, 515, 144, 45);
		contentPane.add(Backbtn);
		
		JLabel lblaboutme = new JLabel("About Me");
		lblaboutme.setBackground(new Color(0, 0, 0));
		lblaboutme.setVerticalAlignment(SwingConstants.BOTTOM);
		lblaboutme.setHorizontalAlignment(SwingConstants.CENTER);
		lblaboutme.setFont(new Font("Showcard Gothic", Font.PLAIN, 50));
		lblaboutme.setBounds(377, 11, 307, 63);
		contentPane.add(lblaboutme);
		
		JTextArea Text_1 = new JTextArea();
		Text_1.setFont(new Font("Monospaced", Font.BOLD, 16));
		Text_1.setText("\r\n\r\n\r\n\r\n\r\n\r\n\r\n Name: King Dheniel N. Concepcion\r\n Bday:03/15/2004\r\n Age: 19\r\n  \r\n Hobbies:\r\n -Drawing\r\n -Watching Anime\r\n -Watching documentary about Dinosaurs\r\n -Playing Video Games\r\n\r\n\r\n \r\n\r\n");
		Text_1.setBounds(120, 76, 442, 427);
		Text_1.setEditable(false);
		contentPane.add(Text_1);
		
		JTextArea Text_2 = new JTextArea();
		Text_2.setText("\r\nMy Strength:\r\n-My family and friends\r\n-Time Management\r\n\r\nMy Weakness:\r\n-Anxiety Attack\r\n\r\n");
		Text_2.setFont(new Font("Monospaced", Font.BOLD, 16));
		Text_2.setBounds(561, 76, 426, 427);
		Text_2.setEditable(false);
		contentPane.add(Text_2);
		
		JLabel lbllogoJW = new JLabel("");
		lbllogoJW.setIcon(new ImageIcon("works-removebg-preview (1).png"));
		lbllogoJW.setBounds(10, 0, 100, 109);
		contentPane.add(lbllogoJW);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon("Background.5 (1).png"));
		lblBackground.setBounds(-17, 0, 1144, 582);
		contentPane.add(lblBackground);
	}
}
