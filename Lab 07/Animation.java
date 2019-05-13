/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Questions;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JApplet;
import javax.swing.Timer;

/**
 *
 * @author Marcus Stewart
 */
public class Animation extends JApplet
{
    
    /*  For this portion of the assignment, you will be creating a simple animation 
        of a ball that moves around the screen of an applet and bounces off of the
        walls.
    
        As part of this assignment, you will need to have first completed the Ball class. 
    
        1) Create an instance of the Ball class and make sure it can draw itself
        2) Complete the detectCollisions method that determines when your Ball object
            has collided with any of the walls, in which case it should reverse direction.
        3) Create an instance of the Timer class and assign it an ActionListener that
            moves the ball around and repaints the screen every time it triggers its event
    */
    Ball b1;
    
    public void init() 
    {
        b1 = new Ball(30, 90, 20, 5, 5, Color.RED);
        Timer t = new Timer(200, new ActionListener()
        {
        
        public void actionPerformed(ActionEvent e) 
        {
            update();
            repaint();
        }
       });
        t.start();
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        b1.draw(g);
    }
    
    public void detectCollisions()
    {
       if(b1.getXPosition() >= getWidth() || (b1.getXPosition() <= 0))
       {
           b1.setXVelocity(-b1.getXVelocity());
       }
       
       if(b1.getYPosition() >= getHeight() || (b1.getYPosition() <= 0))
       {
           b1.setYVelocity(-b1.getYVelocity());
       }
    }
    
    public void update()
    {
        detectCollisions();
        b1.move();
    }    
}