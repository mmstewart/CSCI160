import java.util.Scanner;

public class Question3 
{
     /* For this exercise, you will be writing a simple program that calculates 
         basic statistics for a list of user entered numbers
    
        1) Declare and instantiate a Scanner object to read in user input. 
         
        2) Declare three variables minimum, maximum, and average that will keep 
            track of the minimum, maximum, and average values for the user entered input. 
            
        3) Write a for loop that will read in exactly 10 integer values entered by the user. 
    
        4) Make sure that your program is type safe and will not crash if a user enters bad data.
    
        5) Store the largest value entered by the user inside of the variable maximum
    
        6) Store the smallest value entered by the user inside of the variable minimum
    
        7) Store the average of all values entered by the user inside of the variable average
 
    */  
    public static Object[] question3()
    {
        // Your code goes here
        Scanner s = new Scanner(System.in);
        int minimum = -10;
        int maximum = 350;
        double total = 0;
        double average;
        
        
       for(int a = 0; a < 10; a++)
       {
       while(!s.hasNextInt())
       {
            s.nextLine();
            System.out.println("Please print something else.");
       }
           
        if(s.hasNextInt())
        {
            int value = s.nextInt();
            if(a == 0){
             maximum = value;
             minimum = value;   
            }       
        else 
        {
            if(value >= maximum)
            {
                maximum = value;
            }
            else if(value <= minimum)
            {
                minimum = value;
            }
            
            
        }
            total = total + value;
        }
       }
       average = total/10;
       
       
       
      
       
        
        
        
        
        // Necessary for Unit Test
        return new Object[] {minimum, maximum, average}; 
    }
    
    public static void main(String[] args) 
    {
        Object[] o = question3();
        
        System.out.println("Minimum: " + (int)o[0]);
        System.out.println("Maximum: " + (int)o[1]);
        
        double average; 
        try 
        {
            average = (double)o[2];
        } catch (Exception e) 
        {
            average = (double)((int)o[2]);
        }
        
        System.out.println("Average: " + average);
    }
    
}