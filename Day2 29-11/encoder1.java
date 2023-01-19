/*
Mr.Bob and Mr.Cob are working on a Military Mission. 
They are supposed to encode the message and send the message to the under-cover team.

Where Cob has written a script. Where the Script says double all the ascii values other than mentioned in the bracket
(97,101,105,111,117,65,69,73,79,85) and place a '#' in between. 

Help Bob in writing the Code. 


Sample Test Case-1
input = attack the enemy
output = at#tt#tac#ck#k t#th#he en#nem#my#y*/

import java.util.*;
class Test{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String s[]=sc.nextLine().split(" ");
        System.out.println(encode(s));
    }
    public static String encode(String[] s){
       StringBuilder sb1=new StringBuilder();
        String ref="aeiouAEIOU";
        for(int i=0;i<s.length;i++){
            String temp=s[i];
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<temp.length();j++){
                if(ref.indexOf(temp.charAt(j))!=-1){
                    sb.append(temp.charAt(j));
                }
                else{
                    sb.append(temp.charAt(j));
                    sb.append("#");
                    sb.append(temp.charAt(j));
                }
            }
            sb1.append(sb.toString());
            sb1.append(" ");
        }
        return sb1.toString();
        
    }
}