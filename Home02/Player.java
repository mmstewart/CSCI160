/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nim;

import java.util.Random;


/**
 *
 * @author Marcus Stewart
 */
public class Player {
    Random rand = new Random();
    String name;
    int idealMoveProbability;
    boolean isComputerControlled;
    int randomNumber;
    int pileSize;

    public Player(String name) {
        this.name = name;
        this.isComputerControlled = false;
        
    }
    
    public Player(String name, int idealMoveProbability){
        this.name = name;
        this.idealMoveProbability = idealMoveProbability;
        
        idealMoveProbability = rand.nextInt(101);
        this.isComputerControlled = true;
        
        
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String n)
    {
        name = n;
    }
    
    public boolean isComputerControlled(){
       if(isComputerControlled)
       {
           return true;
       } 
       else 
       {
           return false;
       }
       
    }
    
    public int takeComputerTurn(int pileSize)
    {
        
        if(idealMoveProbability == 100)
        {
            
            if((pileSize-1)%4==0)
            {
                return 1;
            }
                
            
           else if((pileSize-2)%4==0)
            {
               return 2;
            }
           else if((pileSize-3)%4==0)
           {
               return 3;
           }
         else
        {
            return rand.nextInt(3)+1;
   
        }  
                    
        }
        else
        {
            return rand.nextInt(3)+1;
   
        }
    }
    
    public Player getBadAIPlayerInstance(){
        if(randomNumber == 100)
        {
            randomNumber = 100;
        }
        return new Player("BADAI", 1);
    }
    
    public Player getPoorAIPlayerInstance(){
                if(randomNumber >= 66)
        {
            randomNumber = 100;
        }
        return new Player("POORAI", 33);
    }
    
    public Player getOkayAIPlayerInstance(){
                if(randomNumber >= 33)
        {
            randomNumber = 100;
        }
        return new Player("OKAYAI", 66);
    }
    
    public Player getGoodPlayerInstance(){
               if(randomNumber >= 0)
        {
            randomNumber = 100;
        } 
        return new Player("GOODAI", 100);
    }
    
    @Override
    public String toString()
    {
        String result = "Name; " + name + " is Computered Controlled: " + isComputerControlled;
        
        
        return result;
    }
}