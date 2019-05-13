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
public class Shield extends GameObject {

    int width;
    int height;
    int shieldLives;

    public Shield(int xPosition, int yPosition, Color color, int shieldLives) {
        super(xPosition, yPosition, color);
        this.width = 48;
        this.height = 10;
        this.shieldLives = shieldLives;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(xPosition, yPosition, width, height);
    }

    //gets the shield lives
    public int shieldLives() {
        return shieldLives;
    }

    public int getWidth() {
        return width;
    }

    public int getShieldLives() {
        return shieldLives;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setShieldLives(int shieldLives) {
        this.shieldLives = shieldLives;
    }

    //method that decrements the amount of shield lives
    public void reduceShields() {
        shieldLives--;
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(xPosition, yPosition, 48, 10);
    }
}