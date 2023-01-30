/*The Valid shortcuts of a string "abcd", are as follows:
abcd, abcd, a1cd, ab1d, abc1, 2cd, a2d, ab2, 1b1d, 1bc1,a1c1, 
1b2, 2c1, 3d, a3, 4

You are given a string S and shortcut string  SC, 
Your task is to find out whether the string matches with the 
given shortcut or not.
if matched print true, else false.

Note:
String S contains only lowercase letters and String SC contains 
only lowercase letters and digits.

Input Format:
-------------
Two space separated Strings S and SC

Output Format:
--------------
Print a boolean value


Sample Input-1:
---------------
internationalization i12iz4n

Sample Output-1:
----------------
true

Sample Input-2:
---------------
apple a2e

Sample Output-2:
----------------
false
*/



import java.util.*;
class Test{
    public static boolean ValidWord(String s1,String s2){
        if(s1==null || s2==null){
            return false;
        }
        int i = 0;
        int j = 0;
        while(i<s1.length() && j<s2.length()){
            if(s1.charAt(i)==s2.charAt(j)){
                i++;
                j++;
            }
            else if(s2.charAt(j)-'0'>=0 && s2.charAt(j)-'0'<=9){
                int k = 0;
                while(j<s2.length() && (s2.charAt(j)-'0'>=0 && s2.charAt(j)-'0'<=9)){
                    k = 10*k+(s2.charAt(j)-'0');
                    j++;
                }
                i+=k;
            }
            else{
                return false;
            }
        }
        return i==s1.length() && j==s2.length();
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(ValidWord(s1,s2));
    }
}