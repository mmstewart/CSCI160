public class Question4 
{
    public static Object[] question4(Student student1, Student student2)
    {
        /*  For this exercise you will be using for loops to calculate various values.
            You will be making use of the following object references which are passed as arguments to this method:
                A Student object reference student1
                A Student object reference student2
            You will need to use various accessor methods of the Student class to complete this assignment. 
            Additional variables that you will use have already been declared.

            1) Set the value of student1HighestGrade to the highest grade for student1
            2) Set the value of student2HighestGrade to the highest grade for student2
            3) Set the value of student1AverageGrade to the average grade for student1
            4) Set the value of student2AverageGrade to the average grade for student2
            5) Assign the bestHighGradeStudent object reference whichever student has the best high grade
            6) Assign the bestAverageGradeStudent object reference whichever student has the best average grade

            This program contains a main method that can be used to manually test your code by right-clicking Question3.java
            and selecting "Run File"   
        */
        
        int student1HighestGrade = 0;
        double student1total = 0;
        double student2total = 0;
        int student2HighestGrade = 0; 
        double student1AverageGrade = 0;
        double student2AverageGrade = 0; 
        Student bestAverageGradeStudent = student1;
        Student bestHighGradeStudent = student2; 
        
        // Your code goes Here:
        for(int i = 0; i < 8; i++)
        {
        if(student1HighestGrade < student1.getExamScore(i))
        {
                
            student1HighestGrade = student1.getExamScore(i);
        }
        
        if(student2HighestGrade < student2.getExamScore(i))
        {
                student2HighestGrade = student2.getExamScore(i);
        }
        
        }
        if (bestHighGradeStudent == student2)
        {
            bestHighGradeStudent = student2;
        }
        else 
        {
            bestAverageGradeStudent = student1;
        }
          
        
        
        
        for(int c = 0;c < 8; c++)
        {
            student1total += student1.getExamScore(c);
        }
        student1AverageGrade = student1total/8;
        
        for(int d = 0; d < 8; d++)
        {
            student2total += student2.getExamScore(d);
        }
        student2AverageGrade = student2total/8;
        
        
           
        
        // Necessary for Unit Test  
        return new Object[] {student1HighestGrade, student2HighestGrade, student1AverageGrade, student2AverageGrade, bestHighGradeStudent, bestAverageGradeStudent}; 
    }
    
    public static void main(String[] args) 
    {
        Student s1 = new Student(); 
        Student s2 = new Student(); 
        s2.setName("John Doe");
        
        System.out.println("Student1: " + s1);
        System.out.println("Student2: " + s2);
        
        Object[] o = question4(s1, s2);
        
        System.out.println("student1HighestGrade    = " + (int)o[0]);
        System.out.println("student2HighestGrade    = " + (int)o[1]);
        System.out.println("student1AverageGrade    = " + (double)o[2]);
        System.out.println("student2AverageGrade    = " + (double)o[3]);
        System.out.println("bestHighGradeStudent    = " + ((Student)o[4]).getName());
        System.out.println("bestAverageGradeStudent = " + ((Student)o[5]).getName());  
    }
}