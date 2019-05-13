/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nim;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Marcus Stewart
 */
public class Pile {
    int initialCount;
    int size;
    int xPosition;
    int yPosition;
    int diameter = 15;
    
    public Pile(int initialCount)
    {
        size = initialCount;
    }
    
    public int getSize(){
        return size;
    }
    
    public void remove(int count)
    {
        
        if(count > size || count < 0)
        {
        
        System.out.println(System.out);
        System.out.print("Do not enter a value greater than the pile or a negative amount of marbles.");
        System.out.println("Try again.");
        
        }
        size -= count;
    }
    
    public void printPile()
    {
        int printlns = size/10; //lines of circle
        
        int lastlns = size%10; //remainder after it prints out the circles of marbles in a row.
        
        for(int i = 0; i < printlns; i++)
        {
            
            System.out.println("oooooooooo");
            
            for(int j = 0; j < lastlns; j++)
            {
                System.out.print("o");
            }
            System.out.println();
        }
                     
    }
    
public void drawPile(Graphics g, int xPosition, int yPosition)
{
      int line = size;
      int temp = xPosition;
      
      for(int i = 0; i < line; i++)
      {
          if((i%9) == 0)
          {
              
          
          xPosition = temp;
          yPosition += diameter;
          }
      
      g.setColor(Color.BLUE);
      g.fillOval(xPosition, yPosition, diameter, diameter);
      xPosition += diameter;
      }

}

    public void setPileSize(int pS) {
        size = pS;
    }
}