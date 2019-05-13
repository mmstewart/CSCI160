/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Questions;
import java.util.Scanner;

/**
 *
 * @author Marcus Stewart
 */
public class MenuHelper {
    String message;
    int min; 
    int max;
    
    public static int displayMenu(String message, int min, int max)
    {
        int input;
        String garbage;
        System.out.println(message);
        System.out.println("Chosse a selection between " + min + " and " + max + ": ");
        Scanner s  = new Scanner(System.in);
        
        while(!s.hasNextInt())
        {
            garbage = s.nextLine();
            System.out.println("Please chose an option between " + min + " and " + max + ": ");
            
        }
        
        input = s.nextInt();
        while(input < min || input > max)
        {
            System.out.println("Please choose an option between " + min + " and " + max + ": ");
            input = s.nextInt();
        }
        return input;
    }
    public static void main(String[] args) {
        int menuChoice1 = MenuHelper.displayMenu("Please choose an entree: \n1) Chicken \n2) Beef \n3) Pork ", 1, 3);
        int menuChoice2 = MenuHelper.displayMenu("Please choose an side: \n1) Baked Potato \n2) Mashed Potato \n3) Salad \n4) Soup ", 1, 4);
        int menuChoice3 = MenuHelper.displayMenu("Please choose an side: \n1) Basked Potato \n2) Mashed Potato \n3) Salad \n4) Soup ", 1, 4);
        System.out.println("You chose: " + menuChoice1 + ", " + menuChoice2 + ", " + menuChoice3);
    }
}