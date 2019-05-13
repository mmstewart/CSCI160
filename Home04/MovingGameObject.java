/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObjects;

import Interfaces.Moveable;
import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author Marcus Stewart
 */
public abstract class MovingGameObject extends GameObject implements Moveable
{

    protected int yVelocity;
    protected int xVelocity;
    
    protected BufferedImage bi;
    
    public MovingGameObject(int xPosition, int yPosition, BufferedImage bi, Color color) {
        super(xPosition, yPosition, bi, null);
    }
    
    public MovingGameObject(int xPosition, int yPosition, Color color) {
        super(xPosition, yPosition, color);
    }
    
    public MovingGameObject(int xPosition, int yPosition, int xVelocity, int yVelocity, BufferedImage bi)
    {
        super(xPosition, yPosition, bi, null);
        this.yVelocity = yVelocity;
        this.xVelocity = xVelocity;
    }
    
    public int getYPosition()
    {
        return yPosition;
    }
    
    public int getXVelocity()
    {
        return xVelocity;
    }
    
    public void setYVelocity(int yVelocity)
    {
        this.yVelocity = yVelocity;
    }
    
    public void setXVelocity(int xVelocity)
    {
        this.xVelocity = xVelocity;
    }
    
    @Override
    public void move()
    {
        xPosition += xVelocity;
        yPosition += yVelocity;
    }
    
}