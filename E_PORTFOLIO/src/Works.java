import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JScrollBar;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;

public class Works extends JFrame {

	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public Works() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1066, 606);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
        setLocationRelativeTo(null); //relocate to the center
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon logo = new ImageIcon("icon.jpg");
	    setIconImage(logo.getImage());
		
		JButton Backbtn = new JButton("BACK");
		Backbtn.setFont(new Font("Showcard Gothic", Font.PLAIN, 18));
		Backbtn.setBackground(new Color(30, 144, 255));
		Backbtn.setBounds(472, 511, 144, 45);
		contentPane.add(Backbtn);
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
		
		JLabel lbllogoJW = new JLabel("");
		lbllogoJW.setIcon(new ImageIcon("works-removebg-preview (1).png"));
		lbllogoJW.setBounds(10, 0, 100, 109);
		contentPane.add(lbllogoJW);
		
		JLabel lblMYWORKS = new JLabel("My Works");
		lblMYWORKS.setHorizontalAlignment(SwingConstants.CENTER);
		lblMYWORKS.setFont(new Font("Showcard Gothic", Font.BOLD, 50));
		lblMYWORKS.setBounds(343, -17, 372, 152);
		contentPane.add(lblMYWORKS);
		
		JLabel lblSAMPLE = new JLabel("");
		lblSAMPLE.setIcon(new ImageIcon("Untitled design (1).png"));
		lblSAMPLE.setBounds(134, 78, 800, 415);
		contentPane.add(lblSAMPLE);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon("Background.5 (1).png"));
		lblBackground.setBounds(0, 0, 1254, 758);
		contentPane.add(lblBackground);
	}
}
