/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nim;



import java.util.Random;
import java.util.Scanner;



/**
 *
 * @author Marcus Stewart
 */
public class TextNim {

    Player player1;
    Player cP; //current player
    Player player2;
    int firstTurn;
    
    Pile pile; //marbles
    int pileSize;
    int valOne;
    int valTwo;
    //static Player choosePlayer;
    int valThree;
    int valFour;
    int value;
    int idealMoveProbability;
    String message;
    
    Random r = new Random();
    int rN; //random number
    int rC; //random choice
    boolean p1Turn, p2Turn;
    
    Scanner s = new Scanner(System.in);
    
    public TextNim()
    {
    
    }
    
    public TextNim(Player player1, Player player2)
    {
        this.player1 = player1;
        this.player2 = player2;
    }
 

 
    
    public TextNim setupGame()
    {
        System.out.println("Welcome to the game of NIM");
        one2two(1, 2);
        System.out.println("\nWhat will you be playing?");
        System.out.println("1) Human vs. Human \n2) Human vs. Computer \n3) Computer vs. Computer");
        int option = one2three(1, 3);

       if(option == 1){
            System.out.println("\nEnter Player's One name.");
            String pl1Name = s.next();
            player1 = new Player(pl1Name);
            System.out.println("\nEnter Player's Two name.");
            String pl2Name = s.next();
            player2 =  new Player(pl2Name);
            TextNim newGame = new TextNim(player1, player2);
            System.out.println("\nHow many marbles will we play with?");
            System.out.println("1) Custom \n2) Random Number(17 - 57) \n3) Standard Number of 21");
            int select = one2three(1, 3);
            CreatePile(select);
            return newGame;
     

        }
        else if(option == 2)
        {
            System.out.println("Enter Player One's name.");
            String p1Name = s.next();
            player1 = new Player(p1Name);
            
            System.out.println("Select two player's names: \n1) Adam  \n2) Ness \n3) Alex \n4) Eric");
            int one2four = one2for(1, 4);
            player2 = choosePlayerType(one2four);
            
            if(one2four == 1)
            {
                player2 = player2.getGoodPlayerInstance();
            } 
            else if (one2four == 2)
            {
                player2 = player2.getOkayAIPlayerInstance();
            }
            else if(one2four == 3)
            { 
                player2 = player2.getPoorAIPlayerInstance();
            } 
            else 
            {
                player2 = player2.getBadAIPlayerInstance();
            }
            int select = one2three(1, 3);
            CreatePile(select);
            
            TextNim newG = new TextNim(player1, player2);
            return newG;
        } 
        else 
        {
            System.out.println("");   
            String p1Name = s.next();
            int one2four = one2three(1, 4);
            player2 = choosePlayerType(one2four);
            
            if(one2four == 1)
            {
                player1 = player1.getGoodPlayerInstance();
            } 
            else if (one2four == 2)
            {
                player1 = player1.getOkayAIPlayerInstance();
            }
            else if(one2four == 3)
            { 
                player1 = player1.getPoorAIPlayerInstance();
            } 
            else 
            {
                player1 = player1.getBadAIPlayerInstance();
            }
            
            player2 = choosePlayerType(one2four);
            
            if(one2four == 1)
            {
                player2 = player2.getGoodPlayerInstance();
            } 
            else if (one2four == 2)
            {
                player2 = player2.getOkayAIPlayerInstance();
            }
            else if(one2four == 3)
            { 
                player2 = player2.getPoorAIPlayerInstance();
            } 
            else 
            {
                player2 = player2.getBadAIPlayerInstance();
            }

            System.out.println("Please enter the amount of marbles: ");
            System.out.println("1) Custom \n2) Random Number(17 - 57) \n3) Standard Number of 21");
            int select = one2three(1, 3);
            CreatePile(select);

            
        }
            
            
        TextNim newG = new TextNim(player1, player2);
        return newG;
    }
    
    private int CreatePile(int select)
    {
        int marbles = 0;
        if(select == 1)
            {
                
                marbles = one2two2(1, 100);
                pile = new Pile(marbles);
            } 
            else if (select == 2)
            {
                Random rand = new Random();
                marbles = rand.nextInt(57 - 17 + 1) + 17;
                pile = new Pile(marbles);

            } 
            else 
            {
                marbles = 21;
                pile = new Pile(marbles);
            }
        return marbles;
    }
    
    private void displayTurnInformation() //Displays the turn information.
    {
        nextPlayer();
        System.out.println("The current player is; " + cP.getName());
        System.out.println("The pile size is: " + pile.getSize());
    }
    
    
    public int one2two(int valOne, int valTwo) //represents the value that you choose from, one - two
    {
        int value;
        System.out.println("Would you like to play a game of nim?");
        System.out.println("1) Yes \n2) No ");
        Scanner s  = new Scanner(System.in);
        
       while(!s.hasNextInt()) //type-safe, so they actually have to enter an interger instead of any other character
        {
            s.nextLine();
            System.out.println("\nWould you like to play a game of nim?");
            System.out.println("1) Yes \n2) No ");
            
        }
        
        value = s.nextInt();
        while(value < 1 || value > 2)
        {
            System.out.println("\nWould you like to play a game of nim?");
            System.out.println("1) Yes \n2) No ");
            value = s.nextInt();
        }
        return value;
    }
    
    public int one2two2(int valOne, int valTwo) //represents the value that you choose from, one - two
    {
        int value;
        String garbage;
        System.out.println("Choose a value between 1 and 100.");
        Scanner s  = new Scanner(System.in);
        
       while(!s.hasNextInt()) //type-safe, so they actually have to enter an interger instead of any other character
        {
            garbage = s.nextLine();
            System.out.println("Choose a value between 1 and 100.");
            
        }
        
        value = s.nextInt();
        while(value < 1 || value > 100)
        {
            System.out.println("Choose a value between 1 and 100.");
            value = s.nextInt();
        }
        return value;
    }
    
    public int one2three(int valOne, int valThree) //represents the value that you choose from, one - three
    {
        int value;
        String garbage;
        System.out.println("\nPlease chose an option between " + valOne + " and " + valThree + ": ");
        Scanner s  = new Scanner(System.in);
        
       while(!s.hasNextInt())
        {
            garbage = s.nextLine();
            System.out.println("\nPlease chose an option between " + valOne + " and " + valThree + ": ");
            
        }
        
        value = s.nextInt();
        while(value < 1 || value > 3)
        {
            System.out.println("\nPlease chose an option between " + valOne + " and " + valThree + ": ");
            value = s.nextInt();
        }
        return value;
    }

    public int one2for(int valOne, int valFour) //represents the value that you choose from, one - three
    {
        int value;
        String garbage;
        System.out.println("Please chose an option between " + valOne + " and " + valFour + ": ");
        Scanner s  = new Scanner(System.in);
        
       while(!s.hasNextInt())
        {
            garbage = s.nextLine();
            System.out.println("Please chose an option between " + valOne + " and " + valFour + ": ");
            
        }
        
        value = s.nextInt();
        while(value < 1 || value > 4)
        {
            System.out.println("Please chose an option between " + valOne + " and " + valFour + ": ");
            value = s.nextInt();
        }
        return value;
    }
    
    private void  takeTurn()
    {
        if(player1.isComputerControlled())
        {
            player1.takeComputerTurn(pile.getSize());
        }
        else
        {
            System.out.println("Enter the amount of marbles you want to take: " );
            Scanner s = new Scanner(System.in);
            
            System.out.println("Please enter a value between 1 and 3: ");
            while(!s.hasNextInt())
            {
                s.nextInt();
                System.out.println("That's not an int, try again.");
                
            }
            
            value = s.nextInt();
            while(value < 1 || value > 3)
            {
                System.out.println("\nPlease chose an option between 1 and 3");
                value = s.nextInt();
            }

    }
    }



    
private void nextPlayer()
    {
        if(player1 == cP)
        {

           cP = player2;
        }
        else
        {
            cP = player1;
        }
    }
    
    public void start()
    {

        firstTurn = r.nextInt(2) + 1;
        
        if(firstTurn == 1)
        {
            cP = player1;
        } 
        else 
        {
            cP = player2;
        }
        
        System.out.println("\nThe pile size is " + pile.getSize());
        
        while(pile.getSize() > 0)
        {
            if(cP == player1)
            {
                System.out.println("\n" + player1.getName() + " take your turn.");
            } 
            else 
            {
                System.out.println("\n" + player1.getName() + " take your turn.");
            }
            
            pile.printPile();
            
            if(cP.isComputerControlled())
            { 
                cP.takeComputerTurn(pile.getSize());
            } 
            else 
            {
                takeTurn();
            }
                nextPlayer();
            }
        
        
        if(cP == player1)
        {
            System.out.println(player2.getName() + " is the winner.");
        }
        else 
        {
            System.out.println(player1.getName() + " is the winner.");
        }
        
        
    }
    
    public static Player choosePlayerType(int one2four)
    {
    switch(one2four)
     {
        case 1:
        System.out.println("You chose bad player.");
        case 2:
        System.out.println("You chose poor player.");
        case 3:
        System.out.println("You chose okay player.");
        case 4:
        System.out.println("You chose good player.");
        default:
            System.out.println(one2four + " is not an option, try again.");
            return null;
      }
    }
    
    public static void main(String[] args) {
        TextNim game = new TextNim();
        game.setupGame();
        
        game.start();
    }
    
//    @Override
//    public String toString()
//    {
//
//    }

}