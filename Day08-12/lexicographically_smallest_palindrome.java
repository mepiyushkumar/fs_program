/*/*
Mr Shravan is given a word W, and W cosists of lowercase alphabets and '#'. 
Mr Shravan is allowed to replace the '#' with any one lowercase alphabet, 
such that the word W is a palindrome and it has to be the lexicographically
smallest among all the possible options.

Your task is to help Mr Sharavan to return the lexicographically smallest 
palindrome string among all the possible options. 
OR "invlaid" if it is not possible.

Input Format:
-------------
A String W, consists of lowercase letters and #.

Output Format:
--------------
A String result.


Sample Input-1:
---------------
r#d#v##er

Sample Output-1:
----------------
redavader


Sample Input-2:
--------------

r#d#v#cer

Sample Output-2:
----------------
invalid
 */



 import java.util.*;
class Test{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String ss = sc.next();
        
        char s[] = ss.toCharArray();
        
        int flag = 0;
        
        for(int i = 0;i<s.length/2;i++){
            if(s[i]=='#' && s[s.length-i-1]=='#'){
                s[i]=s[s.length-i-1]='a';
            }
            else if(s[i]=='#'){
                s[i] = s[s.length-i-1];  
            }
            else if(s[s.length-i-1]=='#'){
                s[s.length-i-1] = s[i];
            }
            else if(s[i]!=s[s.length-i-1]){
                flag = 1;
                break;
            }
        }
        
        if(flag==1){
            System.out.println("invalid");
        }
        else{
            if(s.length%2!=0 && s[s.length/2]=='#'){
                s[s.length/2]='a';
                String str = String.copyValueOf(s);
                System.out.println(str);
            }
            else{
                String str = String.copyValueOf(s);
                System.out.println(str);
            }
        }
    }
}