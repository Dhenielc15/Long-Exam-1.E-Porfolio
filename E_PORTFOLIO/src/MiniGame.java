
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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;


public class MiniGame extends JFrame {
    private JPanel panel;
    private final int width = 700;
    private int height = 500;
    private int playerX = 400;
    private int playerY = 400;
    private int enemyX = 100;
    private int enemyY = 100;
    private int enemyWidth = 20;
    private int enemyHeight = 20;
    private int enemySpeed = 2;
    private boolean gameOver = false;
    private int score = 0;
    private Font font = new Font("Arial", Font.BOLD, 24);
    private ImageIcon playerIcon;
    private ImageIcon enemyIcon;
    
    public MiniGame() {
        setTitle("Elephant and the Hunter");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null); //relocate to the center

        ImageIcon logo = new ImageIcon("APPLICATION.png");
        setIconImage(logo.getImage());
            
        playerIcon = new ImageIcon("player.png"); // replace with your own gif file
        enemyIcon = new ImageIcon("enemy.png"); // replace with your own gif file

        panel = new JPanel() {
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
        panel.setPreferredSize(new Dimension(width, height));       
        panel.setFocusable(true);
        add(panel);
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
         Main main = new Main();
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
                        enemyX += enemySpeed;
                    } else {
                        enemyX -= enemySpeed;
                    }

                    if (enemyY < playerY) {
                        enemyY += enemySpeed;
                    } else {
                        enemyY -= enemySpeed;
                    }

                    if (enemyX >= playerX - enemyWidth && enemyX <= playerX + 20
                            && enemyY >= playerY - enemyHeight && enemyY <= playerY + 20) {
                        gameOver = true;
                    }

                    score++;
                }
                panel.repaint();
            }
        });
        timer.start();
        
         // Add key listener to the panel to move the player
        panel.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();

                switch (keyCode) {
                case KeyEvent.VK_UP:
                    playerY -= 10;
                    break;
                case KeyEvent.VK_DOWN:
                    playerY += 10;
                    break;
                case KeyEvent.VK_LEFT:
                    playerX -= 10;
                    break;
                case KeyEvent.VK_RIGHT:
                    playerX += 10;
                    break;
                case KeyEvent.VK_W:
                    playerY -= 10;
                    break;
                case KeyEvent.VK_S:
                    playerY += 10;
                    break;
                case KeyEvent.VK_A:
                    playerX -= 10;
                    break;
                case KeyEvent.VK_D:
                    playerX += 10;
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

