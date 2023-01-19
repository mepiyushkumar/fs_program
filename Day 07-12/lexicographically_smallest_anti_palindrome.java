/*
 Mr Shravan is given a word W, and W is a palindrome. Mr Shravan is 
allowed to replace only one letter in W, with any lowercase alphabet, 
such that the word W is not a palindrome again and which is the 
lexicographically smallest among all the possible options.

Examples of Lexicographical order are:
	- aaa is smaller than aab
	- abb is smaller than abc.

Return the lexicographically smallest string among all the possible options.

Input Format:
-------------
A String P, palindrome.

Output Format:
--------------
A String result.


Sample Input-1:
---------------
abcdcba

Sample Output-1:
----------------
aacdcba


Sample Input-2:
---------------
aaaa

Sample Output-2:
----------------
aaab


Sample Input-3:
---------------
aaabaaa

Sample Output-3:
----------------
aaabaab

 */


 import java.util.*;
class Test{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        
        System.out.println(pl(s));
    }
    public static boolean isp(String s){
        String res="";
        for(int i=0;i<s.length();i++){
            res=s.charAt(i)+res;
        }
        if(res.equals(s)){
            return true;
        }
        else{
            return false;
        }
    }  
        public static String pl(String s){
        for(int ind=0;ind<s.length();ind++){
            char ch=s.charAt(0);
            
                int i=0;
                String res="";
                while(i<s.length()){
                    if(s.charAt(i)!='a'){
                    res=s.substring(0,i)+"a"+s.substring(i+1,s.length());
                    if(!isp(res)){
                        
                        return res;
                       
                    }
                    }
                    res="";
                    if(i==s.length()-1){
                        char x=(char)((int)(s.charAt(i)+1));
                        System.out.println(x);
                        res=s.substring(0,i)+x;
                        return res;
                    }
                    i++;
                    
                }
        }
        return "";
        }
}


/*import java.util.*;
class Test{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int i = 0;
        while(i+1<s.length()){
            if(s.charAt(i+1)==s.charAt(i)){
                i++;
            }
            else{
                if(ispalin(s.substring(0,i)+"a"+s.substring(i+1))){
                    i++;   
                }
                else{
                    break;
                }
            }
        }
        //System.out.println(i);
        if(i==s.length()-1){
            System.out.println(s.substring(0,i)+"b");
        }
        else{
            System.out.println(s.substring(0,i)+"a"+s.substring(i+1));
        }
        
    }
    
    public static boolean ispalin(String s){
        int l = 0;
        int r = s.length()-1;
        while(r>l){
            if(s.charAt(l)!=s.charAt(r)) return false;
            r--;
            l++;
        }
        return true;
    }
}*/