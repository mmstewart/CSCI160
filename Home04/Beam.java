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
public class Beam extends MovingGameObject {

    //for the enemies
    protected int height;
    protected int width;
    protected int diameter;

    public Beam(int xPosition, int yPosition, int xVelocity, int yVelocity, int width, int height, int diameter, Color color) {
        super(xPosition, yPosition, null, color);
        this.width = 2;
        this.height = 4;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(xPosition, yPosition, width, height);
    }

    //makes it so that the beams shoot down
    public void move() {
        yPosition += yVelocity;
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(xPosition, yPosition, width, height);
    }
}