/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author roylee
 */
public class tryRecurseGenerate {
    public static void main(String[] args){
        char[] c = {'a','a','a'};
        char[] cmp = {'u','u','u'};

        while(strcmp(c,cmp) != 0)
            incr(c,2);
        
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

   public static void incr(char[] c, int indx){
       if(c[indx] == 'u'){
           c[indx] = 'a';
           incr(c,(indx-1));
       }else{
           c[indx] = addOne(c[indx]);
           System.out.println(new String(c));
       }
   }
    public static char addOne(char token){
        char incr = ' ';
        switch(token)
        {
            case 'a':incr='e';
            break;
            case 'e':incr='i';
            break;
            case 'i':incr='o';
            break;
            case 'o':incr='u';
            break;
            default: break;
        }

        return incr;
    }

}
