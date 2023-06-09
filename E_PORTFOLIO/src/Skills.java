import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class Skills extends MainMenu {
    private static final long serialVersionUID = 1L; // Serialization compatibility field
    private JPanel contentPane; // Main panel of the frame.
    /**
     * Create the frame.
     */
    public Skills() {
    	contentPane = new JPanel(); // Create a new JPanel to serve as the content pane
    	setContentPane(contentPane); // Set the content pane of the frame to the newly created JPanel
    	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); // Add an empty border to the content pane
    	contentPane.setLayout(null); // Set the layout manager of the content pane to null layout

        // Set the application icon
        ImageIcon logo = new ImageIcon("icon.jpg");
        setIconImage(logo.getImage());

        // Label for "My Skills" title
        JLabel lblmyskills = new JLabel("My Skills");
        lblmyskills.setHorizontalAlignment(SwingConstants.CENTER);
        lblmyskills.setFont(new Font("Showcard Gothic", Font.PLAIN, 50));
        lblmyskills.setBounds(327, 0, 473, 126);
        contentPane.add(lblmyskills);

        // Label for displaying an image (DNA)
        JLabel lblMRDNA = new JLabel("");
        lblMRDNA.setHorizontalAlignment(SwingConstants.CENTER);
        lblMRDNA.setIcon(new ImageIcon("DNA-removebg-preview.png"));
        lblMRDNA.setBounds(150, 102, 764, 404);
        contentPane.add(lblMRDNA);
        
        // Create and configure labels for different skills
        JLabel lblVIDEOEDITING = new JLabel("Video Editing");
        lblVIDEOEDITING.setIcon(new ImageIcon("video__1_-removebg-preview (1).png"));
        lblVIDEOEDITING.setForeground(Color.WHITE);
        lblVIDEOEDITING.setFont(new Font("Showcard Gothic", Font.PLAIN, 18));
        lblVIDEOEDITING.setBounds(704, 73, 249, 135);
        contentPane.add(lblVIDEOEDITING);

        JLabel lblPROGRAMMING = new JLabel("Computer Troubleshooting");
        lblPROGRAMMING.setIcon(new ImageIcon("troubleshoot-removebg-preview (1).png"));
        lblPROGRAMMING.setForeground(Color.WHITE);
        lblPROGRAMMING.setFont(new Font("Showcard Gothic", Font.PLAIN, 18));
        lblPROGRAMMING.setBounds(687, 411, 352, 135);
        contentPane.add(lblPROGRAMMING);

        JLabel lblRENDERING = new JLabel("Rendering");
        lblRENDERING.setIcon(new ImageIcon("render.png"));
        lblRENDERING.setForeground(Color.WHITE);
        lblRENDERING.setFont(new Font("Showcard Gothic", Font.PLAIN, 18));
        lblRENDERING.setBounds(843, 243, 249, 135);
        contentPane.add(lblRENDERING);

        JLabel lblPAINTING = new JLabel("Painting");
        lblPAINTING.setIcon(new ImageIcon("art-painting-icon-image-gallery-10 (1).png"));
        lblPAINTING.setForeground(Color.WHITE);
        lblPAINTING.setFont(new Font("Showcard Gothic", Font.PLAIN, 18));
        lblPAINTING.setBounds(42, 243, 249, 135);
        contentPane.add(lblPAINTING);

        JLabel lblJAVA = new JLabel("JAVA PROGRAMMING");
        lblJAVA.setIcon(new ImageIcon("java (1).png"));
        lblJAVA.setForeground(Color.WHITE);
        lblJAVA.setFont(new Font("Showcard Gothic", Font.PLAIN, 18));
        lblJAVA.setBounds(175, 419, 299, 118);
        contentPane.add(lblJAVA);

        JLabel lblVIRTUALART = new JLabel("VIRTUAL ART");
        lblVIRTUALART.setForeground(new Color(255, 255, 255));
        lblVIRTUALART.setFont(new Font("Showcard Gothic", Font.PLAIN, 18));
        lblVIRTUALART.setIcon(new ImageIcon("VIRTUAL ART (1).png"));
        lblVIRTUALART.setBounds(200, 73, 249, 135);
        contentPane.add(lblVIRTUALART);

        // Button for going back to the main menu
        JButton Backbtn = new JButton("BACK");
        Backbtn.setFont(new Font("Showcard Gothic", Font.PLAIN, 18));
        Backbtn.setBackground(new Color(30, 144, 255));
        Backbtn.setBounds(502, 521, 144, 45);
        contentPane.add(Backbtn);
        Backbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Show a confirmation dialog before going back to the main menu
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

        // Label for the background image
        JLabel lblBackground = new JLabel("");
        lblBackground.setIcon(new ImageIcon("Background.5 (1).png"));
        lblBackground.setBounds(0, 0, 1142, 607);
        contentPane.add(lblBackground);
    }
}
