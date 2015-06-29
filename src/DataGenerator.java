/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author roylee
 */
import java.util.*;
import javax.swing.*;
//import java.math.*;
public class DataGenerator {
    private static Vector<Integer> vowelPos = new Vector<Integer>();

    public static void main(String[] args){

        //Taman Pertama Jalan Senohong
       // String anyVal// = "TamAn Amanah";

        String anyVal = JOptionPane.showInputDialog(null, "Please enter a sentence.");
        
        char[] c = convertInit(anyVal);
        char[] cmp = convertFinal(anyVal);
        getVowelPos(c);
        calcCombinations();
        System.out.println(new String(c));
        while(strcmp(c,cmp) != 0)
            incr(c,vowelPos.get(vowelPos.size() -1),vowelPos.size() -1);//new Thread(new threadForIncr(c)).start();

    }

    public static void incr(char[] c, int indx,int vPos){

       if(Character.toLowerCase(c[indx]) == 'u'){
           if(Character.isLowerCase(c[indx]))
               c[indx] = 'a';
           else
               c[indx] = 'A';
           incr(c,vowelPos.get(vPos -1), vPos -1);
       }else{
           c[indx] = addOne(c[indx]);
           System.out.println(new String(c));
       }
   }
    public static boolean isVowel(char charc){
        boolean isVowel;
        switch(charc){
            case 'a': case 'e' : case 'i' : case 'o' : case 'u':
            case 'A': case 'E' : case 'I' : case 'O' : case 'U':isVowel = true;break;
            default: isVowel = false;
        }
        return isVowel;
    }
    public static char addOne(char token){
        char incr = ' ';
        switch(token)
        {
            case 'a':incr = 'e';
            break;
            case 'e':incr = 'i';
            break;
            case 'i':incr = 'o';
            break;
            case 'o':incr = 'u';
            break;
            case 'A':incr = 'E';
            break;
            case 'E':incr = 'I';
            break;
            case 'I':incr = 'O';
            break;
            case 'O':incr = 'U';
            break;
            default: break;
        }
        return incr;
    }
    public static int strcmp(char[] c, char[] cmp){
        int ret = 0;
        for(int i = 0; i < c.length; i++){
            if(c[i] != cmp[i]){
                ret = 1;
                break;
            }
        }
        return ret;
    }
    public static char[] convertFinal(String a){
      char[] hel =  a.toCharArray();
        for(int i = 0; i < hel.length; i++){
            if(isVowel(hel[i])){
                if(Character.isLowerCase(hel[i]))
                    hel[i] = 'u';
                else
                    hel[i] = 'U';
            }
        }
     return hel;
   }

    public static char[] convertInit(String a){
      char[] hel =  a.toCharArray();
        for(int i = 0; i < hel.length; i++){
            if(isVowel(hel[i])){
                if(Character.isLowerCase(hel[i]))
                    hel[i] = 'a';
                else
                    hel[i] = 'A';
            }
        }
     return hel;
   }

    public static void getVowelPos(char[] charA){
        for(int i = 0 ; i < charA.length ; i++){
            if(isVowel(charA[i])){
                vowelPos.add(i);
            }
        }
   }
    public static void calcCombinations(){
        System.out.println("No of Results: " +(int)Math.pow(5, vowelPos.size()));
        System.out.println("-------------------");
   }
}
/**
 *    public static int getFirst(char[] charA){
        for(int i = charA.length -1 ; i >= 0 ; i--){
            if(isVowel(charA[i])){
              return i;
            }
        }
        return -1;
    }
    public static int getNext(char[] charA,int init){
        for(int i = init-1 ; i >= 0 ; i--){
            if(isVowel(charA[i])){
              return i;
            }
        }
        return -1;
    }
 */