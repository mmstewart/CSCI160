/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Marcus Stewart
 */
public class Bullet extends MovingGameObject {

    //for the ship
    private int diameter;

    public Bullet(int xPosition, int yPosition, int diameter, Color color) {
        super(xPosition, yPosition, color);
        this.diameter = 5;
    }

    public int getDiameter() {
        return diameter;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(xPosition, yPosition, diameter, diameter);
    }

    //bullets fire up the screen.
    public void move() {
        yPosition -= yVelocity;
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(xPosition, yPosition, diameter, diameter);
    }

    //if the yposiition and diamterer of the bullet is out of the screen, it is true, else, false.
    public boolean isOutOfBounds() {
        if (yPosition + diameter < 0) {
            return true;
        } else {
            return false;
        }
    }
}