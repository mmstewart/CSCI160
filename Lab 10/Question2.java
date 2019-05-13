package Questions.Exceptions;

/**
 *
 * @author Marcus Stewart
 */
public class Question2 
{
    // Do not modify
    private static String[] firstNames = {"James", "Larry", "Kathy", "Richard", "Judy"}; 
    private static String[] lastNames; 
    
    /*  The following code is very unsafe and will generate several types of run-time exceptions including:
            * ArithmeticException (Dividing by zero)
            * ArrayIndexOutOfBoundsException (Accessing a non-existant array element)
            * NullPointerException (Attempting to interact with a non-existant object)
    
        Place the unsafe code inside of a try block and make a catch block for each of the Exception types listed above
        The catch blocks should impelement the following behavior:
    
        1) If you catch an ArithmeticException set first to "Billy" and set last to "Jones".
        2) If you catch an ArrayIndexOutOfBoundsException set first to "Stacy" and set last to "Smith".
        3) If you catch a NullPointerException set last to null. 
    
        Regardless of what happens, make sure the method still returns a value. 
    */
    public static String[] Question2(int input)
    {
        String first = ""; 
        String last  = ""; 
        
        
        try 
        {
            int index = 10 / input; 
            int index2 = input % 5; 
            first = firstNames[index];
            last  = lastNames[index2]; 
        } 
        catch (ArithmeticException e) 
        {
            first += "Billy";
            last += "Jones";
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            first += "Stacy";
            last += "Smith";
        }
        catch(NullPointerException e)
        {
            last = null;
        }
        // unsafe code
        
        // return statement
        return new String[] {first, last}; 
        
    }
    
    
}