/*
Given a string s, return true if a permutation of the string could form a palindrome and false otherwise.

Example 1:

Input: s = "code"
Output: false

Example 2:
Input: s = "aab"
Output: true
Example 3:

Input: s = "carerac"
Output: true
 

Constraints:


1 <= s.length <= 5000
s consists of only lowercase English letters.
 */

 import java.util.*;
class patel{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int k = 0;
        for(int i = 0;i<s.length();i++){
            k = k^s.charAt(i);
        }
        
        if((k>=97 && k<=122) || k==0){
            System.out.println(true);
        }
        else{
            System.out.println(false);
        }
    }
}