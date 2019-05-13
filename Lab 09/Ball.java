/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Questions;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Marcus Stewart
 */
public class Ball extends GameObject implements Moveable{
    private int diameter;
    private int xVel;
    private int yVel;
    
    public Ball(int xPosition, int yPosition, int diameter, Color color)
    {
       
        this.color = color;
        this.diameter = diameter;
        this.xPos = xPosition;
        this.yPos = yPosition;
        this.yVel = 5;
        this.xVel = 4;
    }
    
    

    @Override
    public void move() 
    {
        xPos += xVel;
        yPos += yVel;
    }

    @Override
    public void draw(Graphics g) 
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Rectangle getBounds() 
    {
        Rectangle r = new Rectangle(xPos, yPos, diameter, diameter);
        return r;
    }

}