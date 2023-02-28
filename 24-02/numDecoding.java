/*
 A message containing letters from A-Z can be encoded into numbers 
using the following mapping:

'A' -> "1"
'B' -> "2"
...
'Z' -> "26"
To decode an encoded message, all the digits must be grouped then 
mapped back into letters using the reverse of the mapping above 
(there may be multiple ways). For example, "11106" can be mapped 
into:

"AAJF" with the grouping (1 1 10 6)
"KJF" with the grouping (11 10 6)

Note that the grouping (1 11 06) is invalid because "06" 
cannot be mapped into 'F' since "6" is different from "06".

Given a string s containing only digits, 
return the decoded Strings.

Example 1:
Input: s = "12"
Output:AB 
L
Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
Example 2:

Input: s = "226"
Output: BBF
VF
BZ

Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
Example 3:
Input: s = "06"
Output: F

Explanation: "06" cannot be mapped to "F" because of the 
leading zero ("6" is different from "06").

*/

/*
 
import java.util.*;
class Test{
    public static List<String> l = new ArrayList<>();
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        char ch[] = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        String s = sc.next();
        rec(s,ch,"",0);
        // Collections.sort(l,(a,b)->{
        //     if(a.length()==b.length()){
        //         return b.compareTo(a);
        //     }
        //     else{
        //         return b.length()-a.length();
        //     }
        // });
        if(l.size()==0) System.out.println("F"); 
        else{
            for(String i :l){
                System.out.println(i);
            }
        }
    }
    public static void rec(String s,char[] ch,String ans,int i){
        if(i==s.length()){
            if(ans.length()>0) l.add(ans);
            return;
        }
        if(s.charAt(i)=='0') return;
        rec(s,ch,ans+ch[Integer.parseInt(s.charAt(i)+"")-1],i+1);
        if(fn(s,ch,i)){
            rec(s,ch,ans+ch[Integer.parseInt(s.charAt(i)+""+s.charAt(i+1))-1],i+2);
        }
        
    }
    
    public static boolean fn(String s,char[] ch,int i){
        if(i==s.length()-1) return false;
        int k = Integer.parseInt(s.charAt(i)+""+s.charAt(i+1)+"");
        if(k>26) return false;
        return true;
    }
    
}
        */


import java.util.*;
public class Test {
  public static void main(String[] args) {
	  Scanner sc=new Scanner(System.in);
    int n = sc.nextInt();
    List<String> results = new ArrayList<>();
    results.add("");
    results = decodeIntsToString(results, 0, n);
    for (String s : results) {
      System.out.println(s );
    }
  }

 
  public static List<String> decodeIntsToString(List<String> results, int index, int integer) {
    int intPower = (int) Math.pow(10, index);
    // Grab the right-most digit
    int currInt1Digit = (integer / intPower ) % 10;
    // Grab the 2 right-most digits
    int currInt2Digits = (integer / intPower ) % 100; 
    if (currInt2Digits == 0) { // Base case. We're done!
      return results;
    } else {
      char char1Digit = convertIntToChar(currInt1Digit);
      char char2Digits = convertIntToChar(currInt2Digits);
      
	  List<String> newResults = new ArrayList<>();

      for (String string : results) {
        if (string.length() > 0 && string.charAt(0) == '-') {
          newResults.add(string.substring(1));
        } else {
          if (char1Digit != '\u0000') {
            newResults.add(char1Digit + string);
          }
          if (char2Digits != '\u0000' && char2Digits > 'I') {
            newResults.add("-" + char2Digits + string);
          }
        }
      }

      return decodeIntsToString(newResults, index + 1, integer);
    }
  }
 
  private static char convertIntToChar(int integer) {
    char c = '\u0000';
    if (integer > 0 && integer <= 26) {
      c = (char) (integer + 64);
    }
    return c;
  }

}



/*import java.util.*;
class Test{
    public static List<String> l = new ArrayList<>();
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        char ch[] = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        String s = sc.next();
        rec(s,ch,"",0);
        // Collections.sort(l,(a,b)->{
        //     if(a.length()==b.length()){
        //         return b.compareTo(a);
        //     }
        //     else{
        //         return b.length()-a.length();
        //     }
        // });
        if(l.size()==0) System.out.println("F"); 
        else{
            for(String i :l){
                System.out.println(i);
            }
        }
    }
    public static void rec(String s,char[] ch,String ans,int i){
        if(i==s.length()){
            if(ans.length()>0) l.add(ans);
            return;
        }
        if(s.charAt(i)=='0') return;
        rec(s,ch,ans+ch[Integer.parseInt(s.charAt(i)+"")-1],i+1);
        if(fn(s,ch,i)){
            rec(s,ch,ans+ch[Integer.parseInt(s.charAt(i)+""+s.charAt(i+1))-1],i+2);
        }
        
    }
    
    public static boolean fn(String s,char[] ch,int i){
        if(i==s.length()-1) return false;
        int k = Integer.parseInt(s.charAt(i)+""+s.charAt(i+1)+"");
        if(k>26) return false;
        return true;
    }
    
}*/