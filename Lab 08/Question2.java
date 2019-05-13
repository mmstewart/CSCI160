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
public class Question2 {
    
    public static Object[] Question2(double[] input)
    {
        /**
         *  For this part of the assignment you will be doing simple array
         *   processing on an array of double double with the identifier input
         *   that is being passed as a parameter to this method. 
         * 
         *  You should calculate and return the following values as elements of
         *   an array of type Object in the following order:
         * 
         *  1) An int value representing the count (number of elements in the array)
         *  2) A double value representing the sum (total of elements in the array)
         *  3) A double value representing the value of the smallest element in the array
         *      *Note: If there are no elements, return the special value Double.NaN
         *  4) A double value representing the value of the largest element in the array
         *      *Note: If there are no elements, return the special value Double.NaN
         */
        
        
        



        
        
        // Create your Object[] here and return it
        int count = input.length;

        double sumTotal = 0.0;
        for (int i = 0; i < input.length; i++) {
            sumTotal += input[i];
        }

        double valSmall = 0.0;
        if (input.length > 0) {
            for (int c = 0; c < input.length; c++) {
                valSmall = input[c];
            }
        } else {
            valSmall = Double.NaN;
        }

        double valLarge = 0.0;
        if (input.length > 0) {
            for (int b = 0; b < input.length; b++) {
                if (input[b] > valLarge) {
                    valLarge = input[b];
                }
            }
        } else {
            valLarge = Double.NaN;
        }
  


        
    return new Object[]{count,sumTotal,valSmall,valLarge};
 }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Questions.Chapter8;

/**
 *
 * @author Francis
 */
public class ArrayUtilities {

    public static boolean arraysAreEqual(int [] array1, int [] array2)
    {
        boolean d = true;
        if (array1 != null || array2 != null) 
        {
            if (array1.length != array2.length) 
            {
                d = false;
            } 
            else 
            {
                for (int i = 0; i < array2.length; i++) 
                {
                    if (array2[i] != array1[i]) 
                    {
                        d = false;
                    }
                }
            }
        } 
        else 
        {
            d = false;
        }
        return d;
    }
    
    private static int [] resizeArray(int [] array, int factor)
    {
        int[]a = new int[array.length*factor];
        for(int i = 0;i < array.length;i++)
        {
            a[i] = array[i];
        }
        
        return a;
    }
    
    public static int [] resizeArray(int []array)
    {
        return resizeArray(array, 2);
    }
    
    public static int [] copyArray(int []array)
    {
        return resizeArray(array, 1);
    }
}