/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObjects;

import Controller.KeyboardController;
import Interfaces.Drawable;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author Marcus Stewart
 */
public abstract class GameObject implements Drawable {
    
    protected int xPosition;
    protected int yPosition;
    protected Color color;
    protected Rectangle rect;
    protected BufferedImage bi;
    protected KeyboardController control;
    
    GameObject(int xPosition, int yPosition, BufferedImage bi, KeyboardController control)
    {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.bi = bi;
        this.control = control;
    }

    GameObject(int xPosition, int yPosition, Color color) 
    {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.color = color;
    }
    
    public abstract Rectangle getBounds();
    
    public int getXPosition()
    {
        return xPosition;
    }
    
    public int getYPosition()
    {
        return yPosition;
    }
    
    public Color getColor()
    {
        return color;
    }
    
    public void setXPosition(int xPosition)
    {
        this.xPosition = xPosition;
    }
    
    public void setYPosition(int yPosition)
    {
        this.yPosition = yPosition;
    }
    
    public void setColor(Color color)
    {
        this.color = color;
    }
    
    public boolean isColliding(GameObject other)
    {
        Rectangle r1 = getBounds();
        Rectangle r2 = other.getBounds();
        
        if(r1.intersects(r2))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}