/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Questions;

import java.awt.Color;

/**
 *
 * @author Marcus Stewart
 */
public class Parrot extends Bird {
    
    private String[]wordsKnown;
    
    public Parrot()
    {
        super("Polly", 2010, Color.GREEN);
        wordsKnown = new String[1];
        wordsKnown[0] = getName(); 
    }
    
    public void addWord(String word)
    {
        String[]index = new String[wordsKnown.length +1];
       
        for(int i = 0; i < wordsKnown.length; i++)
        {
            index[i] = wordsKnown[i];
        }
            
        wordsKnown = index;
        index = null;
        wordsKnown[wordsKnown.length - 1] = word;
            
        }
    
    
    public String listWordsKnown()
    {
         String list = "";
         for(int j = 0; j < wordsKnown.length; j++)
         {
             list = "Polly; " + wordsKnown[j] + "; ";
         }
         return list;
    }
    
    @Override
    public String toString()
    {
        return super.toString()+ ", " + listWordsKnown();
    }
}