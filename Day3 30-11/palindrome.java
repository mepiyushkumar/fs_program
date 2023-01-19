/*
Mr. Parandamayya is working with Strings.
He is given a String S. He has to find the palindromes in S, 
A palindrome can be a substring of S (Strictly substrings only, not subsequences).

Your task is to find the count the number of palindromes can be formed from S.

NOTE: Count each occurence of palindromes if duplicate substrings found. 

Input Format:
-------------
A string S

Output Format:
--------------
Print an integer, number of palindromes.


Sample Input-1:
---------------
divider

Sample Output-1:
----------------
9

Explanation:
-------------
Palindromes are d, i, v, i, d, e, r, ivi, divid

Sample Input-2:
---------------
abcdef

Sample Output-2:
----------------
6

Explanation:
-------------
Palindromes are a, b, c, d, e, f.
*/

/* 
import java.util.*;
class Test{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();
        int c = 0;
        for(int i = 0;i<s.length();i++){
            for(int j = i+1;j<=s.length();j++){
                if(ispalin(s.substring(i,j))) c++;
            }
        }
        System.out.println(c);
    }
    public static boolean ispalin(String s){
        int i = 0;
        int j = s.length()-1;
        while(j>i){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            j--;
            i++;
        }
        return true;
    }
}


*/

import java.util.*;
class Test{
    public static int count = 0;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int c = 0;
        for(int i = 0;i<s.length();i++){
            ispalin(s,i,i);
            ispalin(s,i,i+1);
        }
        System.out.println(count);
        sc.close();
    }
    public static void ispalin(String s,int l,int r){
        while(l>=0 && r<s.length()){
            if(s.charAt(l)==s.charAt(r)){
                count++;
                l--;
                r++;
            }
            else{
                break;
            }
        }
    }
}