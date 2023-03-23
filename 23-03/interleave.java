/*Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.

An interleaving of two strings s and t is a configuration where s and t are divided into n and m 
substrings
 respectively, such that:

s = s1 + s2 + ... + sn
t = t1 + t2 + ... + tm
|n - m| <= 1
The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
Note: a + b is the concatenation of strings a and b.

 Example 1:
Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
Output: true
Explanation: One way to obtain s3 is:
Split s1 into s1 = "aa" + "bc" + "c", and s2 into s2 = "dbbc" + "a".
Interleaving the two splits, we get "aa" + "dbbc" + "bc" + "a" + "c" = "aadbbcbcac".
Since s3 can be obtained by interleaving s1 and s2, we return true.

Example 2:
Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
Output: false
Explanation: Notice how it is impossible to interleave s2 with any other string to obtain s3.
Example 3:

Input: s1 = "", s2 = "", s3 = ""
Output: true
 

Constraints:

0 <= s1.length, s2.length <= 100
0 <= s3.length <= 200
s1, s2, and s3 consist of lowercase English letters.*/


import java.util.*;
class Test{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        String res = sc.next();
        System.out.println(fn(s1,s2,res));
    }
    public static boolean fn(String s1,String s2,String s3){
        int i = s1.length()-1;
        int j = s2.length()-1;
        int k = s3.length()-1;
        if(s1.length()+s2.length()!=s3.length()){
            return false;
        }
        else if(s1.length()==0){
            return s2.equals(s3);
        }
        else if(s2.length()==0){
            return s1.equals(s3);
        }
        else if(s3.length()==0){
            return false;
        }
        else{
            while(k>=0 && ((i>=0 && s1.charAt(i)==s3.charAt(k)) || (j>=0 && s2.charAt(j)==s3.charAt(k)))   ){
                //System.out.println(i+" "+j+" "+k);
                if(i>=0 && s1.charAt(i)==s3.charAt(k)) i--;
                else j--;
                k--;
            }
        }
        
        return (k==-1);
    }
}