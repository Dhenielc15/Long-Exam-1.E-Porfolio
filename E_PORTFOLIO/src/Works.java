import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Works extends MainMenu {
	
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    /**
     * Create the frame.
     */
    public Works() {   	
    	contentPane = new JPanel(); // Create a new JPanel to serve as the content pane
    	setContentPane(contentPane); // Set the content pane of the frame to the newly created JPanel
    	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); // Add an empty border to the content pane
    	contentPane.setLayout(null); // Set the layout manager of the content pane to null layout
    	
        // Set application icon
        ImageIcon logo = new ImageIcon("icon.jpg");
        setIconImage(logo.getImage());

        // Logo for "My Works"
        JLabel lbllogoJW = new JLabel("");
        lbllogoJW.setIcon(new ImageIcon("works-removebg-preview (1).png"));
        lbllogoJW.setBounds(10, 0, 100, 109);
        contentPane.add(lbllogoJW);

        // Label for "My Works" heading
        JLabel lblMYWORKS = new JLabel("My Works");
        lblMYWORKS.setHorizontalAlignment(SwingConstants.CENTER);
        lblMYWORKS.setFont(new Font("Showcard Gothic", Font.BOLD, 50));
        lblMYWORKS.setBounds(343, -17, 372, 152);
        contentPane.add(lblMYWORKS);

        // Sample image
        JLabel lblSAMPLE = new JLabel("");
        lblSAMPLE.setIcon(new ImageIcon("Untitled design (2) (1).png"));
        lblSAMPLE.setBounds(134, 78, 800, 415);
        contentPane.add(lblSAMPLE);

        // Back Button
        JButton Backbtn = new JButton("BACK");
        Backbtn.setFont(new Font("Showcard Gothic", Font.PLAIN, 18));
        Backbtn.setBackground(new Color(30, 144, 255));
        Backbtn.setBounds(472, 511, 144, 45);
        contentPane.add(Backbtn);
        Backbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Display confirmation dialog
                int option = JOptionPane.showOptionDialog(null, "Are you sure you want to go back to the main menu?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

                if (option == JOptionPane.YES_OPTION) {
                    // Create and show the main menu frame
                    MainMenu main = new MainMenu();
                    main.setVisible(true);
                    // Close the current frame
                    dispose();
                }
            }
        });
        // Background label
        JLabel lblBackground = new JLabel("");
        lblBackground.setIcon(new ImageIcon("Background.5 (1).png"));
        lblBackground.setBounds(0, 0, 1254, 758);
        contentPane.add(lblBackground);
    }
}