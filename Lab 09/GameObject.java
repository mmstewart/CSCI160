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
public abstract class GameObject implements Drawable{
    protected int xPos;
    protected int yPos;
    protected Color color;
    
    public abstract void draw(Graphics g);
    
    public abstract Rectangle getBounds();
}