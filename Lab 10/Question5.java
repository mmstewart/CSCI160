package Questions.Files;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 *
 * @author Marcus Stewart
 */
public class Question5 
{
    /*  For this portion of the assignment, you will be writing a method to 
         append to an existing file. 
        Your method will use the following two parameters:
            fileName - A String representing the file that you will append data to.
            message  - A String representing the data that you will write to the file.
    
        You can use the PrintWriter class to write to a file (Chapter 11.4)
    
        Your code should perform the following actions: 
    
        1) Check to see if fileName is null. If it is your method should immediately return (i.e. take no further action)
        2) Open the specified file location for writing and set the mode to append. 
        3) Write the parameter message to the file.
            * Make sure to close the file so that changes are saved. 
        
        *Note: Your code should not throw any checked exceptions. 
        *Note: You will need to import classes from the java.io package. 
    */
    public static void Part1(String fileName, String message)
    {
        try 
        {
            FileOutputStream fos;
            
            fos = new FileOutputStream(fileName, true);
            
            PrintWriter pw = new PrintWriter(fos);
            
            pw.println(message);
            
            pw.close();
        } 
        catch (FileNotFoundException e) 
        {
            
        }
    }
    
    /*  For this portion of the assignment you will be directly appending some text to a specified file.
        
        Your code should perform the following actions:
    
        1)  Open the file "files/question5/song.txt" for writting
            * Make sure that you append to the file.
        2)  Write the following lines to the file (You should NOT include the quotes):
                "Oh, I'm glad I'm not an Oscar Mayer wiener."
                "That is what I'd never want to be."
                "Cause if I were an Oscar Mayer wiener."
                "There would soon be nothing left of me!"
        3)  Make sure to close the file so that it saves your changes. 
    
        *Note: Your code should not throw any unchecked exceptions. 
  */
    
    public static void Part2()
    {
        try
        {
        FileOutputStream fo;
        fo = new FileOutputStream("files/question5/song.txt", true);
        
        PrintWriter pw = new PrintWriter(fo);
        pw.println("Oh, I'm glad I'm not an Oscar Mayer wiener.");
        pw.println("That is what I'd never want to be.");
        pw.println("Cause if I were an Oscar Mayer wiener.");
        pw.println("There would soon be nothing left of me!");
        
        
        pw.close();
        }
        catch (FileNotFoundException e)
        {
            
        }
    }
    
    public static void main(String[] args) 
    {
        Part1("files/question5/default.txt", "All in all, it's just another line in the file.");
        Part2();
    }
}