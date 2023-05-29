import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

// Class definition
public class MyProfileGUI extends JFrame implements ActionListener {

    // Variable declarations
    private int Frame1 = 1; // frame number
    private final JLabel label; // label to display text
    private final JButton nextButton; // button to go to next frame
    private final JButton exitButton; // button to exit program
    private final JButton backButton; // button to go to previous frame
    private final JPanel mainPanel; // main panel
    private final Font font = new Font("Arial", Font.BOLD, 24); // font for label

    // Constructor
    public MyProfileGUI() {
        setTitle("Developer profile"); // setting title of the frame
        setSize(600, 400); // setting size of the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // setting close operation
        setLayout(new BorderLayout()); 
       
        ImageIcon logo = new ImageIcon("APPLICATION.png");
        setIconImage(logo.getImage());
              
        // Initializing components
        label = new JLabel(); // initializing label
        label.setHorizontalAlignment(JLabel.CENTER); // setting horizontal alignment to center
        label.setFont(font); // setting font
    
        mainPanel = new JPanel(new BorderLayout()); // initializing main panel with border layout
        mainPanel.add(label, BorderLayout.CENTER); // adding label to center of main panel
        mainPanel.setBackground(Color.ORANGE); // setting background color of main panel

        nextButton = new JButton("Next"); // initializing next button
        nextButton.addActionListener(this); // adding action listener to next button

        exitButton = new JButton("Exit"); // initializing exit button
        exitButton.addActionListener(this); // adding action listener to exit button

        backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {       
        @Override
        public void actionPerformed(ActionEvent e) {        
        int option = JOptionPane.showOptionDialog(null, "Are you sure you want to go back to the main menu?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
      
        if (option == JOptionPane.YES_OPTION) {
         // Create and show the other frame
         Main main = new Main();
         main.setVisible(true);
         // Close the current frame
         dispose();
            }
        }
    });
        
        JPanel buttonPanel = new JPanel(); // creating button panel
        buttonPanel.setLayout(new GridLayout(1, 3)); // setting layout of button panel
        buttonPanel.add(backButton); // adding back button to button panel
        buttonPanel.add(nextButton); // adding next button to button panel
        buttonPanel.add(exitButton); // adding exit button to button panel

        mainPanel.add(buttonPanel, BorderLayout.SOUTH); // adding button panel to south of main panel
        add(mainPanel); // adding main panel to frame
        setVisible(true); // setting visibility of frame to true
        setLocationRelativeTo(null); // centering the frame on the screen
        updateUI(); // updating UI
    }    
    // Method to update UI according to current frame number
    private void updateUI() {
        switch (Frame1) {
            case 1:
                label.setText("<html>Do you want to know me?<br><br>Click Next if you want.<br><br>Click Exit if you don’t.</html>");
                backButton.setEnabled(true);
                break;
            case 2:
                label.setText("<html>Name: King Dheniel N. Concepcion<br><br>Call me: Dheniel or Niel</html>");
                backButton.setEnabled(true);
                break;
            case 3:
                label.setText("<html>When is your birthdate?<br><br>March 15, 2004");
                break;
            case 4:
                label.setText("<html>Hobbies:<br><br>- Playing video games<br>- Drawing<br>- Watching anime<br>- Documentary about dinosaurs</html>"); 
                break;
            case 5:
                label.setText("<html>Talents:<br><br>- Drawing<br>- Painting<br>- Digital art</html>");
                break;
            case 6:
                label.setText("<html>Achievements:<br><br>- Champion in Tangram Puzzle<br>- 5th Place in Poster Making<br>- SHS With Honors<br>- Conduct Awards</html>"); 
                break;
            case 7:
                label.setText("<html>Why did you take your course?<br><br>I take this course because I want to learn any logic and I want to become a professional programmer.</html>");  
                break;
            case 8:
                label.setText("<html>What is your strength and weakness as a student?<br><br>My strength is my family because they help me and provide all my needs. My weakness is time because I have a lack of time sometimes and attacking my pressure or anxiety.</html>");
                break;
            case 9:
                label.setText("<html>Thank you for reading all of my info!<br><br>You got to know me little by little but I have a mini game if you want. Click next to play.</html>");               
               break;
            case 10:
            label.setText("<html>Click play game in the top!<br><br>Click Exit if you want to close the program.</html>");
            nextButton.setEnabled(false);
            // add gameButton to gamePanel, and gamePanel to mainPanel
                JButton gameButton = new JButton("Play Game");
                gameButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        playGame();
                    }
                });
                JPanel gamePanel = new JPanel();
                gamePanel.add(gameButton);
                mainPanel.add(gamePanel, BorderLayout.NORTH);
                break;
        }
    }

               @Override
               public void actionPerformed(ActionEvent e) {
               if (e.getSource() == nextButton) { // if nextButton is clicked
               Frame1++; // increment Frame1 variable
               updateUI(); // update UI
               } else if (e.getSource() == exitButton) { // if exitButton is clicked
               System.exit(0); // exit the program
               } else if (e.getSource() == backButton) { // if backButton is clicked
               Frame1--; // decrement Frame1 variable
               updateUI(); // update UI       
        }
    }
            private void playGame() {
            //Object Option to Choose Game
            Object[] options = {"Guessing Game", "Elephant and the Hunter", "Cancel"};
            int choice = JOptionPane.showOptionDialog(this,"Which game would you like to play?","Choose a Game",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[2]);
            //Option Choice 1
            if (choice == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Let's start the game!");
            int answer = Integer.parseInt(JOptionPane.showInputDialog(null, "What is my age?"));
            if (answer == 19) {
            JOptionPane.showMessageDialog(null, "Congratulations! You won the game!");
            } else {
            JOptionPane.showMessageDialog(null, "Oops, wrong answer. Try again.");
            playGame();
        }
            //Option Choice 2
           } else if (choice == 1) {
    SwingUtilities.invokeLater(() -> {
        JOptionPane.showMessageDialog(MyProfileGUI.this, "Game will start now!");
        MiniGame miniGame = new MiniGame();
        miniGame.setVisible(true);
    });
    } else {
        // user canceled
        JOptionPane.showMessageDialog(this,
                "No problem, you can play the game later if you want!",
                "Game Canceled",
                JOptionPane.INFORMATION_MESSAGE);
        }
    }      
}

