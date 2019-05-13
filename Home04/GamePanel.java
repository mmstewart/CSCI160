/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import Controller.KeyboardController;
import GameObjects.Beam;
import GameObjects.Bullet;
import GameObjects.Enemy;
import GameObjects.Shield;
import GameObjects.Ship;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author araderma
 */
public class GamePanel extends JPanel {

    private Ship ship;
    private Enemy enemy;
    private Bullet bullet1;
    private Timer beamT;

    public int lives;
    public String livesLeft;

    ArrayList<Enemy> enemies;
    ArrayList<Bullet> bullets;
    ArrayList<Beam> beams;
    ArrayList<Shield> shields;

    boolean paused = false;

    // Required components. Do not remove!
    private Timer gameTimer;
    private KeyboardController controller;

    // Controls size of game window and framerate
    private final int gameWidth = 800;
    private final int gameHeight = 720;
    private final int framesPerSecond = 60;
    private int score;

    public final void setupGame() throws IOException {
        // Initialize field values here
        enemies = new ArrayList<>();
        bullets = new ArrayList<>();
        beams = new ArrayList<>();
        shields = new ArrayList<>();

        BufferedImage ship1 = ImageIO.read(new File("zpship.png"));
        ship = new Ship(400, 625, controller, ship1);
        BufferedImage enemy1 = ImageIO.read(new File("alien4home04.png"));
        enemy = new Enemy(0, 0, 40, 30, enemy1);

        //makes a row of 9 and a column of four. total of 36 enemies. speed is 2/2
        for (int row = 1; row < 10; row++) {
            for (int column = 1; column < 5; column++) {
                enemies.add(new Enemy(40 * (0 + row), 40 * (0 + column), 3, 0, enemy1));
            }
        }

        //sets a default lives to 20 and the score to 0
        lives = 20;
        livesLeft = " 20 lives remaining";
        score = 0;

        //adds 5 shields in an array
        shields.add(new Shield(120, 580, Color.RED, 25));
        shields.add(new Shield(240, 580, Color.RED, 25));
        shields.add(new Shield(360, 580, Color.RED, 25));
        shields.add(new Shield(480, 580, Color.RED, 25));
        shields.add(new Shield(600, 580, Color.RED, 25));
        bullet1 = new Bullet(10, 20, 3, Color.RED);

        //timer so that the beams fire every 5 seconds
        beamT = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < enemies.size(); i++) {
                    beams.add(enemies.get(i).fire());
                }
                repaint();
            }
        });
        beamT.setRepeats(true);
        beamT.start();

    }

    @Override
    public void paint(Graphics g) {
        // Draw GameObjects here
        super.paint(g);

        ship.draw(g);

        //sets the lives indicator in the top left
        g.setColor(Color.WHITE);
        g.drawString(livesLeft, 7, 35);

        //draws the score on the top left
        g.setColor(Color.WHITE);
        g.drawString("Score: " + String.valueOf(score), 10, 20);

        //enhanced for loops draw all of the shields, bullets, enemies, and beams out
        for (Shield shield : shields) {
            shield.draw(g);
        }

        for (Bullet bullet1 : bullets) {
            bullet1.draw(g);
        }

        for (Enemy enemie : enemies) {
            enemie.draw(g);
        }

        for (Beam bea : beams) {
            bea.draw(g);
        }
    }

    public void updateGameState(int frameNumber) {
        // Move GameObjects and check for collisions here   
        //if the game is not paused, everything is running. press p to pause, u to unpause.
        if (!paused) {
            ship.move();

            ArrayList<Bullet> bulletList = new ArrayList<>();
            ArrayList<Beam> beamList = new ArrayList<>();
            ArrayList<Enemy> enemyL = new ArrayList<>();
            ArrayList<Shield> shieldL = new ArrayList<>();

            //makes it so that when the bullet is not on the screen, you are able to shoot.
            for (Bullet bullet1 : bullets) {
                bullet1.move();

                if (bullet1.isOutOfBounds()) {
                    bulletList.add(bullet1);
                }
            }
            bullets.removeAll(bulletList);

            //if the beams are out of the game, remove the beams and let them fire again
            //also makes them shoot at an 5 velocity speed.
            for (Beam bea : beams) {
                bea.move();
                bea.setYVelocity(5);
                if (bea.getYPosition() > 720) {
                    beamList.removeAll(beams);
                }
            }

            //makes the enemies be able to move
            for (Enemy enemie : enemies) {

                enemie.move();
            }

            //once collided, it sets the velocity to 10
            for (Enemy enemie : enemies) {
                if (enemy.detectCollision()) {
                    enemie.setYVelocity(10);
                    enemie.move();
                    enemie.setYVelocity(0);
                }
            }

            //space bar to shoot
            if (controller.getKeyStatus(KeyEvent.VK_SPACE)) {
                if (bullets.isEmpty()) {
                    bullets.add(ship.fire());
                }
            }

            //makes it so that when you shoot from the ship, it makes the enemies disappear.
            for (int i = 0; i < bullets.size(); i++) {
                for (int j = 0; j < enemies.size(); j++) {
                    if (enemies.get(j).isColliding(bullets.get(i))) {
                        bulletList.add(bullets.get(i));
                        enemyL.add(enemies.get(j));
                        score += 50;

                        break;
                    }
                }
                enemies.removeAll(enemyL);
            }
            bullets.removeAll(bulletList);

            //press p to pause the game
            if (controller.getKeyStatus(KeyEvent.VK_P)) {
                paused = true;
            }

            //makes it so that when the bullets collide with the shield, the bullets disappear
            for (int i = 0; i < bullets.size(); i++) {
                for (int j = 0; j < shields.size(); j++) {
                    if (shields.get(j).isColliding(bullets.get(i))) {
                        bulletList.add(bullets.get(i));
                        break;
                    }
                }
            }
            bullets.removeAll(bulletList);

            //makes it so that when the beams collide with the shields, they break and eventually dissapear.
            for (int i = 0; i < beams.size(); i++) {
                for (int j = 0; j < shields.size(); j++) {
                    if (shields.get(j).isColliding(beams.get(i))) {
                        beamList.add(beams.get(i));
                        //reduces the amount of shields and once it reaches 0, the shield is gone.
                        shields.get(j).reduceShields();
                        if (shields.get(j).shieldLives() == 0) {
                            shieldL.add(shields.get(j));
                        }
                    }
                }
            }
            beams.removeAll(beamList);
            shields.removeAll(shieldL);

            //if the beam is coliding with the ship, you lose a life and your score decreases by 25
            for (int i = 0; i < beams.size(); i++) {
                if (beams.get(i).isColliding(ship)) {
                    beamList.add(beams.get(i));
                    lives--;
                    score -= 25;
                    livesLeft = lives + " lives left";
                }
            }
            beams.removeAll(beamList);

            //if there are no enemies, you win the game
            if (enemies.isEmpty()) {
                JOptionPane.showMessageDialog(null, "You Win!");
                int response = JOptionPane.showConfirmDialog(null, "Do you want to play again?");

                if (response == 0) {
                    try {
                        setupGame();
                    } catch (IOException ex) {
                        Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (response == 1 || response == 2) {
                    JOptionPane.showMessageDialog(null, "Thank you for playing");
                    System.exit(0);

                }
            } else 
            
            //if you have no lives, you lose the game
            if (lives <= 0) {
                JOptionPane.showMessageDialog(null, "You Lose");
                int response = JOptionPane.showConfirmDialog(null, "Do you want to play again?");

                if (response == 1) {
                    JOptionPane.showMessageDialog(null, "Thank you for playing");
                    System.exit(0);
                }
                try {
                    setupGame();
                } catch (IOException e) {
                    Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, e);
                }
            } else {

            }
            //if the enemies reach an yposition of 520, the game ends
            for (int i = 0; i < enemies.size(); i++) {
                if (enemies.get(i).getYPosition() > 520) {
                    JOptionPane.showMessageDialog(null, "You Lose");
                    String words = JOptionPane.showInputDialog(null, "Do you want to play again?");
                    if (words.equals("yes")) {
                        try {
                            setupGame();
                        } catch (IOException ex) {
                            Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Thank you for playing");
                        System.exit(0);
                    }
                }
            }
        }

        //press u to unpause the game 
        if (controller.getKeyStatus(KeyEvent.VK_U)) {
            paused = false;
        }
    }

    /**
     * Constructor method for GamePanel class. It is not necessary for you to
     * modify this code at all
     *
     * @throws java.io.IOException
     */
    public GamePanel() throws IOException {
        // Set the size of the Panel

        this.setSize(gameWidth, gameHeight);
        this.setPreferredSize(new Dimension(gameWidth, gameHeight));

        this.setBackground(Color.BLACK);

        // Register KeyboardController as KeyListener
        controller = new KeyboardController();
        this.addKeyListener(controller);

        // Call setupGame to initialize fields
        this.setupGame();

        this.setFocusable(true);
        this.requestFocusInWindow();
    }

    /**
     * Method to start the Timer that drives the animation for the game. It is
     * not necessary for you to modify this code unless you need to in order to
     * add some functionality.
     */
    public void start() {
        // Set up a new Timer to repeat every 20 milliseconds (50 FPS)
        gameTimer = new Timer(1000 / framesPerSecond, new ActionListener() {

            // Tracks the number of frames that have been produced.
            // May be useful for limiting action rates
            private int frameNumber = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                // Update the game's state and repaint the screen
                updateGameState(frameNumber++);
                repaint();
            }
        });
        gameTimer.setRepeats(true);
        gameTimer.start();
    }
}