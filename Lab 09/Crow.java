/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Questions;

import ProvidedClasses.Tool;

/**
 *
 * @author Marcus Stewart
 */
public class Crow extends Bird {
    
    private Tool[] tool1 = new Tool[4];
    
    public Crow()
    {
        super();
        name = "Jacob";
        tool1[0] = Tool.CHAINSAW;
    }
    
    public void addTool(Tool tool)
    {
        int index = 0;
       
        while (index < tool1.length - 1)
        {
            if (tool1[index] == null)
            {
                tool1[index] = tool;
                break;
            }
            index++;
            
        }
    }
    
    public Tool[] getToolsUsed()
    {
        int nL = tool1.length;
        Tool [] c = new Tool[nL];
         
        for(int i = 0; i < c.length; i++)
        {            
            c[i] = tool1[i];          
        }
             
        return c;  

    }
    
 
    @Override
    public String toString()
    {
        String name = super.toString();
        for(int i = 0; i < tool1.length; i++)
        {
            if(tool1[i] != null)
            {
                name += ", " + tool1[i].toString();
            }
        }
        return name;
    }
}