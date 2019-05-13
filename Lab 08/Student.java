/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Questions.Chapter8;

/**
 *
 * @author Marcus Stewart
 */
public class Student {
    String name;
    private int ID;
    private int [] examScore;
    private int [] assignmentScore;
    
    public Student(String name, int ID)
    {
        
        setID(ID);
        
        if(name == null || name == "")
        {
            name = "Unknown";
        }
        else
        {
          this.name = name;
        }
        
        examScore = new int[4];
        assignmentScore = new int[10];
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getID()
    {
        return ID;
    }
    
    public int getExamScore(int index)
    {
        if(index < 0)
        {
            return examScore[0];
        }
        if(index > 3) 
        {
            return examScore[3];
        }
            return examScore[index];
    }
    
    public int getAssignmentScore(int index)
    {
        if(index < 0)
        {
            index = 0;
        }
        
        if(index >= 10)
        {
            index = 9;
        }
            return assignmentScore[index];
    }
    
    
    
    public void setName(String name)
    {
        if(name == null || name == "")
        {
            return;
        }
        else
        {
            this.name = name;
        }
    }
    
    public void setID(int ID)
    {
        if(ID < 0)
        {
            this.ID = ID*-1;
        }
        else if(ID > 999999)
        {
            this.ID = ID%10000000;
        }
        else
        {
            this.ID = ID;
        }
    }
    

    public void setExamScore(int index, int score)
    {
        if(index > examScore.length || index < 0)
        {
            System.out.println("You cannot choose that value.");
        }
        else
        {
        if(score < 0)
        {
            score = 0;
        }
        else if(score > 100)
        {
            score = 100;
        }
        examScore[index] = score;
        }
    }
        
    public void setAssignmentScore(int index, int score)
    {
        if(index > assignmentScore.length || index < 0)
        {
            System.out.println("You cannot choose that value.");
        }
        else
        {
          if(score < 0)
          {
              score = 0;
          }
          else if(score > 100) 
          {
              score = 100;
          }

          assignmentScore[index] = score;
        }    
    }
        
        public String toString()
        {
           return " Name: " + name + " ID: " + ID;
        }
        
        public boolean equals(Object o)
        {
           if(o == null)
           {
               return false;
           }
           
           if(o instanceof Student)
           {
               if(getID() == ((Student) o).getID())
                {
                   if(getName()==((Student) o).getName())
                   {
                       return true;
                   }
                }
            }
        return false;  
    }
}