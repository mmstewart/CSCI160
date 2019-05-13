/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Questions.Chapter8;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Marcus Stewart
 */
public class ShakespearanGenerator {
    static String[] adjective = {"bawdy ", "craven ", "dankish ", "frothy ", "lumpish ", "pribbling ", "surly ", "villainous "};
    static String[] adjective2 = {" beef-writted " , " clay-brained " , "dizzy-eyed", "flap-mouthed", " ill-nurtured ", " motley-minded ", " sheep-biting ", " tickle-brained "};
    static String[] noun = {" bugbear ", " clotpole ", " harpy ", " lout ", " miscreant ", " molwarp ", " puttock ", " wagtail "};
    static String[][] insultG = {adjective, adjective2, noun};
    

    
    public static String randomGenerator()
    {
        Random r = new Random();
        int randWord = r.nextInt(7);
        String sent = "";
        sent += insultG[0][randWord];
        randWord = r.nextInt(7);
        sent += insultG[1][randWord];
        randWord = r.nextInt(7);
        sent += insultG[2][randWord];
        randWord = r.nextInt(7);
        
        return sent;
        
    }
    
    public static void main(String[] args) 
    {
        
        System.out.println(randomGenerator());
    }
    
}