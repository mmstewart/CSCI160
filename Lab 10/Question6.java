package Questions.Files;

import ProvidedClasses.Student;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringTokenizer;


/**
 *
 * @author Marcus Stewart
 */
public class Question6 
{
   
    /* For this part of the assignment you will need to write some code that will parse a human-readable formatted text file.
       
        You can use the Scanner class to read the file (Chapter 11.5) 
       
        The file has the following format:
            Name,ID,GPA,Course1,Course2,...,courseN
        
            Name    - A String type representing a student's name
            ID      - An int type representing a student's ID number
            GPA     - A double type representing a student's GPA
            Course  - A String type representing a course the student is enrolled in.
       
        Note that there may be multiple courses. 
        Files may contain multiple lines following this format. 
       
        Your code should perform the following actions:
       
        1) Open the file specified by the parameter fileName for reading.
            * If the file cannot be found, return an empty ArrayList containing no students.
        2) Parse the file until you run out of input.
        3) For every line of the file, construct a new Student object and add it to an ArrayList that you will return later.
            * The Student constructor is of takes the following arguments (String, int, double, String[]) in that order.
            * If the file does not follow the specified format above, throw a new InputMismatchExcpetion with the message "Input file is malformed."
            * Note: You may need to catch an exception of this type first before throwing your own. 
            * Note: You may want to use the split method as part of your solution. 
        4) Return the ArrayList of Students. 
    */
    public static ArrayList<Student> parseStudentFile(String fileName) 
    {
        ArrayList<Student> listStudent = new ArrayList<>();
        try
        {
        Scanner s = new Scanner(new File(fileName));
            while(s.hasNext())
            {
                String[]values = s.nextLine().split(",");
                String name = values[0];
                int ID = Integer.parseInt(values[1]);
                double GPA = Double.parseDouble(values[2]);
                String [] v3 = new String[values.length-3];
                for(int i = 3; i < values.length;i++)
                {
                    v3[i-3]= values[i];
                }
                Student student1 = new Student(name, ID, GPA, v3);
                listStudent.add(student1);
            }   
            s.close();
        }
        catch (FileNotFoundException e) 
        {
            
        }
        catch (NumberFormatException e) 
        {
            throw new InputMismatchException("Input file is malformed.");
        }
        return listStudent;
    }

    
    public static void main(String[] args) 
    {
        for (Student s : parseStudentFile("files/question6/list1.txt"))
        {
            System.out.println(s.toString());
        }
    }
    
}