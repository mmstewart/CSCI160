package Questions.Exceptions;

/**
 *
 * @author Marcus Stewart
 */
public class Question1 
{
    /* For this part of the assignment you will need to make a custom Exception class
        before you continue. 
    
       1) Create a class (in this same package) with the name MyException
           that inherits directly from the Exception class.
       2) Complete the body of the method below by adding a single line that
            generates an instance of the exception class you just created. 
          Your exceptions should use the following message as an argument:
            "Look ma, I can throw exceptions now."
       3) Make sure to modify the method header to declare that the method
            throws instances of the MyException class. 
    
    */
    public static void Question1() throws MyException  
    { 
        throw new MyException(null);
    }
}