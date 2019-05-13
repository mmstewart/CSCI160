/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author Marcus Stewart
 */
public class Enemy extends MovingGameObject {

    private BufferedImage bi;

    public Enemy(int xPosition, int yPosition, int xVelocity, int yVelocity, BufferedImage bi) {
        super(xPosition, yPosition, xVelocity, yVelocity, bi);
        this.bi = bi;
    }

    //detects if the enemy is within the xPosition, if true the game plays, if not, the game ends
    public boolean detectCollision() {
        if (xPosition < 0 || xPosition >= 800) {
            return true;
        } else {
            return false;
        }
    }

    public Beam fire() {
        return new Beam(xPosition, yPosition, 0, 10, 5, 6, 0, Color.RED);
    }

    //moves the enemy
    @Override
    public void move() {
        xPosition += xVelocity;
        yPosition += yVelocity;

        //moves it a certain speed and down the y position.
        if (detectCollision() == true) {
            xVelocity = xVelocity * -1;
            yPosition = yPosition + 20;
        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(bi, xPosition, yPosition, null);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(xPosition, yPosition, bi.getWidth(), bi.getHeight());
    }
}