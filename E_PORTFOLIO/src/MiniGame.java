import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;


public class MiniGame extends MainMenu {
	private static final long serialVersionUID = 1L; // Specifies the serial version UID for object serialization.
	private JPanel contentPane; // Panel for the window content.
	private final int width = 700; // Window width (x-axis center).
	private int height = 500; // Window height (y-axis center).
	private int playerX = 400; // Player position on the x-axis.
	private int playerY = 400; // Player position on the y-axis.
	private int enemyX = 100; // Enemy position on the x-axis.
	private int enemyY = 100; // Enemy position on the y-axis.
	private int enemyWidth = 20; // Enemy width.
	private int enemyHeight = 20; // Enemy height.
	private int enemySpeed = 2; // Enemy speed.
	private boolean gameOver = false; // Indicates if the game is over.
	private int score = 0; // Score count.
	private Font font = new Font("Arial", Font.BOLD, 24); // Font style for text.
	private ImageIcon playerIcon; // Player icon.
	private ImageIcon enemyIcon; // Enemy icon.
	
    public MiniGame() {
		contentPane = new JPanel();// Create a new JPanel for the content.
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));// Set an empty border for the content panel.
		setContentPane(contentPane);// Set the content pane of the window.
		
		// Set the application icon
        ImageIcon logo = new ImageIcon("APPLICATION.png");
        setIconImage(logo.getImage());
            
        playerIcon = new ImageIcon("player.png"); // replace with your own png file
        enemyIcon = new ImageIcon("enemy.png"); // replace with your own png file

        contentPane = new JPanel() {
		private static final long serialVersionUID = 1L;
		// load the background image
        private ImageIcon bgIcon = new ImageIcon("grass.jpg");
        private Image bgImage = bgIcon.getImage();
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                // draw the background image
                g.drawImage(bgImage, 0, 0, 800, 600, null);
                if (!gameOver) {
                    g.drawImage(enemyIcon.getImage(), enemyX, enemyY, 40, 40, null);
                    g.drawImage(playerIcon.getImage(), playerX, playerY, 150, 150, null);

                    g.setFont(font);
                    g.drawString("Score: " + score, 10, 30);
                } else {
                    g.setFont(font);
                    g.drawString("Game Over! Final Score: " + score, 230, height / 2);
                }
            }
        };
        contentPane.setPreferredSize(new Dimension(width, height));       
        contentPane.setFocusable(true);
        add(contentPane);
        // Create Exit button and add an action listener to it       
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Thank you for testing my beta version!");
        System.exit(0);   
        }
    });
        // Create Back button and add an action listener to it
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {        
        int option = JOptionPane.showOptionDialog(null, "Are you sure you want to go back to the main menu?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
      
        if (option == JOptionPane.YES_OPTION) {
         // Create and show the other frame
         MainMenu main = new MainMenu();
         main.setVisible(true);
         // Close the current frame
         dispose();
            }
        }
    });
        // Create a panel to hold the buttons and add them to it
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(backButton);
        buttonPanel.add(exitButton);
        add(buttonPanel, "South");

         // Create a timer to control the game and repaint the panel
        Timer timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!gameOver) {
                    if (enemyX < playerX) {
                        enemyX += enemySpeed; // Move the enemy towards the player on the x-axis.
                    } else {
                        enemyX -= enemySpeed; // Move the enemy away from the player on the x-axis.
                    }

                    if (enemyY < playerY) {
                        enemyY += enemySpeed; // Move the enemy towards the player on the y-axis.
                    } else {
                        enemyY -= enemySpeed; // Move the enemy away from the player on the y-axis.
                    }

                    if (enemyX >= playerX - enemyWidth && enemyX <= playerX + 20
                            && enemyY >= playerY - enemyHeight && enemyY <= playerY + 20) {
                        gameOver = true; // If the enemy collides with the player, set the game over flag to true.
                    }

                    score++; // Increase the score.
                }
                contentPane.repaint(); // Repaint the content pane to update the game graphics.
            }
        });
        timer.start();
        
         // Add key listener to the panel to move the player
        contentPane.addKeyListener(new KeyListener() {
        	@Override
        	public void keyPressed(KeyEvent e) {
        	    int keyCode = e.getKeyCode();

        	    switch (keyCode) {
        	        case KeyEvent.VK_UP:
        	            playerY -= 10; // Move the player up by 10 units on the y-axis.
        	            break;
        	        case KeyEvent.VK_DOWN:
        	            playerY += 10; // Move the player down by 10 units on the y-axis.
        	            break;
        	        case KeyEvent.VK_LEFT:
        	            playerX -= 10; // Move the player left by 10 units on the x-axis.
        	            break;
        	        case KeyEvent.VK_RIGHT:
        	            playerX += 10; // Move the player right by 10 units on the x-axis.
        	            break;
        	        case KeyEvent.VK_W:
        	            playerY -= 10; // Move the player up by 10 units on the y-axis (alternative control).
        	            break;
        	        case KeyEvent.VK_S:
        	            playerY += 10; // Move the player down by 10 units on the y-axis (alternative control).
        	            break;
        	        case KeyEvent.VK_A:
        	            playerX -= 10; // Move the player left by 10 units on the x-axis (alternative control).
        	            break;
        	        case KeyEvent.VK_D:
        	            playerX += 10; // Move the player right by 10 units on the x-axis (alternative control).
        	            break;    
        	    }
        	}

        	@Override
        	public void keyReleased(KeyEvent e) {}

        	@Override
        	public void keyTyped(KeyEvent e) {}
        });
    }
    
}