/*
 Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 

input =cbaebabacd
abc
output =0 6
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

input=abab
ab
output =0 1 2

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

 */

import java.util.*;
class Test{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String p = sc.next();
        int k = p.length();
        List<Integer> res = new ArrayList<>();
        List<Character> l = new ArrayList<>();
        for(int i=0;i<k;i++){
            l.add(s.charAt(i));
        }
        if(fn(l,p)) res.add(0);
        
        for(int i=k;i<s.length();i++){
            l.remove(0);
            l.add(s.charAt(i));
            if(fn(l,p)) res.add(i-k+1);
        }
        
        for(int i:res)
        System.out.print(i+" ");
        
    }
    public static boolean fn(List<Character> l,String p){
        Set<Character> s = new HashSet<>();
        for(char i:l) s.add(i);
        for(int i = 0;i<p.length();i++){
            if(s.contains(p.charAt(i))) s.remove(p.charAt(i));
            else return false;
        }
        return s.size()==0;
    }
}

