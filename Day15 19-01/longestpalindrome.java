/*
Mr. Gnanesh is working with words. He has given a list of words. 
Each word in the list contains only two lowercase letters [a-z].

He wants to create the biggest word BW, by concatenating words from the list, which 
is a palindrome too. He is allowed to use each word from the list at most once.

Return the length of the biggest word that can be formed using the list.
If it is impossible to create a such word, return 0.

Input Format:
-------------
Space separated strings, words[], two letter words.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
ab ba dd

Sample Output-1:
----------------
6

Explanation: 
------------
The biggest word is, ab,dd,ba => abddba, which is a palindrome.


Sample Input-2:
---------------
pq rs sr mk km pq

Sample Output-2:
----------------
8

Explanation: 
------------
The biggest word is, rs,sr,mk,km => rsmkkmsr or mkrssrkm..etc, 
which is a palindrome.


Sample Input-3:
---------------
aa bb cc

Sample Output-3:
----------------
2


*/

import java.util.*;
class Test{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String l[] = sc.nextLine().split(" ");
        Map<String,Integer> m1 = new HashMap<>();
        Map<String,Integer> m2 = new HashMap<>();
        for(String i :l){
            if(i.charAt(0)==i.charAt(1)){
                m2.put(i,m2.getOrDefault(i,0)+1);
            }
            else{
                m1.put(i,m1.getOrDefault(i,0)+1);
            }
        }

        int c = 0;
        for(String s:m1.keySet()){
            StringBuffer sb = new StringBuffer(s);
            String ss = sb.reverse().toString();
            if(m1.containsKey(ss)){
                c+=Math.min(m1.get(s),m1.get(ss));
            }
        }
        for(String s : m2.keySet()){
            if(m2.get(s)>1){
                if(m2.get(s)%2==0){
                    c = c + m2.get(s);
                }
                else{
                    c = c + m2.get(s)-1;
                }
                m2.put(s,m2.get(s)%2);
            }
        }
        
        if(m2.containsValue(1)){
            c+=1;
        }

        System.out.println(2*c);
        
    }
}




