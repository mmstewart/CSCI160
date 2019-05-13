/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Questions;

import ProvidedClasses.Animal;
import java.util.ArrayList;

/**
 *
 * @author Marcus Stewart
 */
public class Zoo{
    
    private ArrayList<Animal>animal1 = new ArrayList<>();
    
    public Zoo()
    {
        animal1 = new ArrayList<>(3);
    }
    
    public void addAnimal(Animal animal)
    {
        animal1.add(animal);
    }
    
    public String listAnimals()
    {
        String zoo = "";
        for(int i = 0; i < animal1.size(); i++)
        {
            zoo += animal1.get(i) + "\n";
        }
        return zoo;
    }
}