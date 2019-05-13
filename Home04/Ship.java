/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObjects;

import Controller.KeyboardController;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

/**
 *
 * @author Marcus Stewart
 */
public class Ship extends ControlledGameObject {

    private int width;
    private int height;
    private Bullet b;
    private KeyboardController control;
    private BufferedImage bi;

    public Ship(int xPosition, int yPosition, KeyboardController control, BufferedImage bi) {
        //sets the starting point for where the ship will be
        super(xPosition, yPosition, control, bi);
        height = 5;
        width = 3;
        this.control = control;
        this.bi = bi;
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(bi, xPosition, yPosition, null);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(xPosition, yPosition, bi.getWidth(), bi.getHeight());
    }

    public Bullet fire() {
        //once you hit space, the bullet fires from the ship and it shoots at a speed of 4.
        control.getKeyStatus(KeyEvent.VK_SPACE);
        b = new Bullet(xPosition + bi.getWidth() / 2, yPosition, width, Color.yellow);
        b.setYVelocity(6);
        return b;
    }

    @Override
    public void move() {
        //if you hit the left key, it goes to the left.
        if (control.getKeyStatus(KeyEvent.VK_LEFT)) {
            xPosition -= 5;
        } //if you hit the right key, it goes to the right.
        else if (control.getKeyStatus(KeyEvent.VK_RIGHT)) {
            xPosition += 5;
        }
        //Makes if so that the ship can go right and come from the left and go left and come from the right.
        if (xPosition > 800) {
            xPosition = 0;
        } else if (xPosition < 0) {
            xPosition = 800;
        }
    }
}