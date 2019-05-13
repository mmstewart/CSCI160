/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Questions;

import ProvidedClasses.Animal;
import java.awt.Color;

/**
 *
 * @author Marcus Stewart
 */
public class Bird extends Animal{
        
    Color featherColor;
    
    public Bird() 
    {
        super();
        featherColor = Color.BLACK;
    }
    
    public Bird(String name, int birthYear, Color featherColor)
    {
        super(name, birthYear);
        this.featherColor = featherColor;
    }
    
    public Color getFeatherColor()
    {
        return featherColor;
    }
    
    @Override
    public String toString()
    {
        return super.toString() + ", " + featherColor.toString();
    }
}