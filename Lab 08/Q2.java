package Questions.Chapter9;

import java.util.Random;

/**
 *
 * @author Marcus Stewart
 */
public class Q2 
{
    /*  For this exercise, you will be instantiating multidimensional arrays based on the data given. 
        Once you have instantiated these arrays, you will need to store them as elements in an 
            Object array that will be returned by the method.
    
        1) A sports columnist at the paper wants to know how many downs each member of the Bison Football team played during the
            regular season. You should construct a two-dimensional array where the number of rows represent the 107 players on the 
            team's roster and the columns represent the 13 games of the regular season.
        2) One of your friends majoring in Geology is interested in storing and processing data related to the average snowfall in 
            North Dakota over the past 100 years. Instantiate a 2D array that can handle floating-point numbers 
            where the rows are the previous 100 years and the columns are the months (November - May) 
        3) You're cousin has started a side-business selling ice cream cones and wants to start tracking the popularity of her different
            flavors. Create a multi-dimensional array that will be able to track sales for each of her three carts for each of the 52 weeks
            in a year for each of the 17 flavors of ice cream that she sells from her carts. 
        4) Mr. Radermacher's friend's brother Daz is convinced that the government is out to get him and has devised a plan to change his name
            to something new every day. Create a multi-dimensional array that will help him store a new name for every day of year for the next 3 years.
            Daz is convinced that government spy planes don't work on leap days so we don't have to worry about leap years.
        5) You want to impress your friends by convincing them that your computer is psychic. Do to so you are going to take advantage of the psuedo-random
            nature of the Random class. Construct a multi-dimensional array that will be able to store instances of the Random class capable of generating
            it's exact index position within the multi-dimensional array based the first five numbers it randomly generates in the range 0 - 9 (inclusive).
        6) Create a single-dimensional array of type Object and add each of the arrays that you've instantiated 
            to that array in the order in which they were created base on the instructions above.
            This array should be returned by the method. 
    
    */
    public Object[] Question2()
    {
         int[][]ftbl = new int[107][13];
         double[][]snowfall = new double[100][7];
         int[][][]iceCream = new int[3][52][17];
         String[][]id = new String[365][3];
         Random[][][][][]psychicComp = new Random[10][10][10][10][10];
         
         return new Object[]{ftbl, snowfall, iceCream, id, psychicComp};
    }
    
}