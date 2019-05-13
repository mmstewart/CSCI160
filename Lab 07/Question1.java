import java.util.Scanner;

public class Question1 
{
    public static int[] question1()
    {
        /** For this part of the assignment you will be creating a while loop that reads
         *   in integer values entered by a user using the console until they enter a 
         *   negative number, at which point the loop should quit and display the 
         *   following information: 
         * 
         *   count - the number of iterations made by the loop
         *   total - the total of all values entered (excluding the negative value)
         *   minimum - the smallest number entered by the user (-1 if no values entered)
         *   maximum - the largest number entered by the user (-1 if no values entered)
         * 
         *  When outputting the results it should be of a form similar to the following:
         * 
         *   Output:
         *   count: 4
         *   total: 24
         *   minimum: 0
         *   maximum: 20
         * 
         *  Your loop should also be type-safe in that the program will not crash if 
         *   non-integer data is encountered. You should display a message similar 
         *   to the following if the user enters a non-integer value: 
         *   "That is not an integer, please try again." 
         * 
         *  Additionally, you should declare int variables with the identifiers count, total,
         *   minimum, and maximum to store the various values above. 
         * 
         *  Note: Make sure to include a message prompting a user to enter integer
         *   numbers or a negative number to quit before reading any input. 
        */
        
        // Your code goes here:
        Scanner s = new Scanner(System.in);
        int count = 0;
        int total = 0;
        int minimum = Integer.MAX_VALUE;
        int maximum = 0;
        
        System.out.print("Please enter a negative integer.");
        
       while(true)
       {
        while (!s.hasNextInt())
        {
            s.nextLine();
            System.out.println("That is not an integer.");
            System.out.print("Enter a negative value: ");
        }
        int num = s.nextInt();
        s.nextLine();
        if(num >= 0)
        {
            count++;
            total += num;
            if(num < minimum)
            {
                minimum = num;
            }
            else if(num > maximum)
            {
                maximum = num;
            }
                
        }
        else
        {
            if(num < 0)
            {
                break;
            }
        }
       }
       if(count==0)
       {
       minimum = -1;
       maximum = -1;
       }
        System.out.println("count: " + count);
        System.out.println("total: " + total);
        System.out.println("minimum: " + minimum);
        System.out.println("maximum: " + maximum);
       
       
        
        
        

        // necessary for unit test, do not remove
        return new int[] {count, total, minimum, maximum}; 
    }
    
    public static void main(String[] args) 
    {
        int[] results = question1(); 
        System.out.println("\nAfter run stats:");
        System.out.println("count: " + results[0]);
        System.out.println("total: " + results[1]);
        System.out.println("minimum: " + results[2]);
        System.out.println("maximum: " + results[3]);
    }
}