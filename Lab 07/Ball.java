/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Questions;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Marcus Stewart
 */
public class Ball {
    int xPosition;
    int yPosition;
    int diameter;
    int xVelocity;
    int yVelocity;
    Color color;
    
    public Ball(int xPosition, int yPosition, int diameter, int xVelocity, int yVelocity, Color color){
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.diameter = diameter;
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
        this.color = color;
    }
    
    public int getXPosition(){
        return xPosition;
    }
    
    public int getYPosition(){
        return yPosition;
    }
    
    public int getXVelocity(){
        return xVelocity;
    }
    
    public int getYVelocity(){
        return yVelocity;
    }
    
    public int getDiameter(){
        return diameter;
    }
    
    public Color getColor(){
        return color;
    }
    
    public void setXPosition(int xPosition){
        this.xPosition = xPosition;
    }
    
    public void setYPosition(int yPosition){
        this.yPosition = yPosition;
    }
    
    public void setXVelocity(int xVelocity){
        this.xVelocity = xVelocity;
    }
    
    public void setYVelocity(int yVelocity){
        this.yVelocity = yVelocity;
    }
    
    public void setDiameter(int diameter){
        this.diameter = diameter;
    }
    
    public void setColor(Color color){
        this.color = color;
    }
    
    public void move(){
        xPosition += xVelocity;
        yPosition += yVelocity;
    }
    
    public void draw(Graphics g){
        g.setColor(color);
        g.fillOval(xPosition, yPosition, diameter, diameter);
    }
}