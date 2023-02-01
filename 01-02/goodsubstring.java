/*A string is good if there are no repeated characters.
Given a string s​​​​​, return the number of good substrings of length three in s​​​​​​.
Note that if there are multiple occurrences of the same substring, every occurrence should be counted.
A substring is a contiguous sequence of characters in a string.

Example 1:
input: s = "xyzzaz"
output: 1

Explanation: There are 4 substrings of size 3: "xyz", "yzz", "zza", and "zaz". 
The only good substring of length 3 is "xyz".


Example 2:
Input: s = "aababcabc"
Output: 4
Explanation: There are 7 substrings of size 3: "aab", "aba", "bab", "abc", "bca", "cab", and "abc".
The good substrings are "abc", "bca", "cab", and "abc".

*/



import java.util.*;
class Test{
    public static int c = 0; 
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int k = 3;
        
        char arr[] = s.toCharArray();
        List<Character> l = new ArrayList<>();
        for(int i=0;i<k;i++){
            l.add(arr[i]);
        }
        fn(l,k);
        for(int i=k;i<arr.length;i++){
            l.remove(0);
            l.add(arr[i]);
            fn(l,k);
        }
        System.out.print(c);
        
    }
    public static void fn(List<Character> l,int k){
        Set<Integer> s = new HashSet<>();
        int sum = 0;
        for(int i:l){
            s.add(i);
            sum+=i;
        }
        int x = s.size();
        s.clear();
        if(x==k){c++;
        return;}
        else return;
    }
}