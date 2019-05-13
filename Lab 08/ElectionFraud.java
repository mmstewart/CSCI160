/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Questions.Chapter9;

import ProvidedClasses.Election;
import ProvidedClasses.VotingMachine;

/**
 *
 * @author araderma
 */
public class ElectionFraud 
{
    /*  For this exercise you are going to help Mr. Radermacher commit massive election fraud in order that he might be elected President.
        Mr. Radermacher does have enough dead relatives in the cemetary to "win" the election through traditional means, so he's entrusted
        you to assist with this endevor by exploiting weaknesses in the programming of the voting machine software. 
    
        You will want to create a new instance of the Election class.
        Because everyone wants to ensure an honest election, public access has been provided to the voting machine used in the election so
        you can access it. 
          - You can do this by calling the getVotingMachine() method on your instance of the Election class. 
            This method will return a VotingMachine type. 
          - To get the raw election data you can call the getResults() method on a VotingMachine object reference.
            This method will return an int[][] type which contains vote counts. 
    
        You can check out the results of the election by calling the printResults() method on your instance of the Election class.
    
        Because the getResults() method of the VotingMachine class returns a reference to its instance variable you can manipulate the 
         vote count. 
    
        You will want to make sure that Mr. Radermacher wins the election for President and that the ballot measure to install
         Mr. Radermacher as dictator for life also succeeds. 
        
        Once you've managed to modify the vote, print out the results to verify your success. 
    
        Your method should also return the Election instance you create so the unit tests can verify your results. 
    */
    public static Election unsafeInstanceVariables()
    {
        Election election1 = new Election();
        
        
        VotingMachine vm1 = election1.getVotingMachine();
        int[][] copy = vm1.getResults();
        copy[1][0] = 9999;
//        copy[2][0] = 9999;
        copy[0][2] = 9999;
        
        election1.printResults();
        
        
        return election1;
    }
    
    /*  Although Mr. Radermacher has promised to be a benevolent dictator, you are beginning to have second doubts.
        In fact, you've decided that it would probably be a good idea for you to patch the security hole in the voting machine. 
    
        Modify the getSafeResults method in the VotingMachine class so that it returns a reference to a copy of its instance variable
        instead of returning the instance variable itself. 
         *Note: The method is located at the end of the VotingMachine.java class file
         *Note: The VotingMachine class is located in the ProvidedClasses package. 
    
        If you have done this successfully, you should be able to verify that your fixes work by repeating the process you used above, 
        but calling the getSafeResults() method on the VotingMachine instead of the getResults() method.  
    
        Your method should also return the Election instance you create so the unit tests can verify your results.
    */
    public static Election safeInstanceVariables()
    {
        Election election1 = new Election();
        
        
        VotingMachine vm1 = election1.getVotingMachine();
        int[][] copy = vm1.getSafeResults();
        copy[1][0] = 9999;
//        copy[2][0] = 9999;
        copy[0][2] = 9999;
        
        election1.printResults();
        

        
        return election1;  
    }
    
    public static void main(String[] args)
    {
        unsafeInstanceVariables(); 
        safeInstanceVariables(); 
    }
    
    
}