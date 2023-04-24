/*Vihaar is working with strings. 
He is given two strings A and B, and another string T,
where the length of A and B is same.

You can find the relative groups of letters from A and B,
using the following rule set:
- Equality rule: 'p' == 'p'
- Symmetric rule: 'p' == 'q' is same as 'q' == 'p'
- Transitive rule: 'p' == 'q' and 'q' == 'r' indicates 'p' == 'r'.

Vihaar has to form the relatively smallest string of T,
using the relative groups of letters.

For example, if A ="pqr" and B = "rst" , 
then we have 'p' == 'r', 'q' == 's', 'r' == 't' .

The relatives groups formed using above rule set are as follows: 
[p, r, t] and [q,s] and  String T ="tts", then relatively smallest string is "ppq".

You will be given the strings A , B and T.
Your task is to help Vihaar to find the relatively smallest string of T.


Input Format:
-------------
Three space separated strings, A , B and T

Output Format:
--------------
Print a string, relatively smallest string of T.


Sample Input-1:
---------------
kmit ngit mgit

Sample Output-1:
----------------
ggit

Explanation: 
------------
The relative groups using A nd B are [k, n], [m, g], [i], [t] and
the relatively smallest string of T is "ggit"


Sample Input-2:
---------------
attitude progress apriori

Sample Output-2:
----------------
aaogoog

Explanation: 
------------
The relative groups using A nd B are [a, p], [t, r, o], [i, g] and [u, e, d, s]
the relatively smallest string of T is "aaogoog"
 */

 

import java.util.*;
class DisjointUnionSets{
    int[] rank;
    char[] parent;
    public DisjointUnionSets(){
        rank = new int[26];
        parent = new char[26];
        makeSet();
    }
    
    void makeSet(){
        for(int i = 0;i<25;i++){
            parent[i]=(char)(97+i);
            rank[i] = 0;
        }
    }
    char find(char x){
        //System.out.println(x+"   "+parent[x-'a']);
        if(x==parent[x-'a']){
            return parent[x-'a'];
        }
        else{
            return parent[x-'a'] = find(parent[x-'a']); 
        }
    }
    void union(char a,char b){
        char aRoot = find(a);
        char bRoot = find(b);
        if(rank[aRoot-'a']<rank[bRoot-'a']){
            parent[aRoot-'a'] = bRoot; 
        }
        else if(rank[aRoot-'a']>rank[bRoot-'a']){
            parent[bRoot-'a'] = aRoot;
        }
        else{
            if(aRoot>bRoot){
                parent[aRoot-'a'] = bRoot;
            }
            else{
                parent[bRoot-'a'] = aRoot;
            }
        }
    }
    
}
class Test{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        DisjointUnionSets dus =	new DisjointUnionSets();
        String a = sc.next();
        String b = sc.next();
        String c = sc.next();
        
        for(int i = 0;i<a.length();i++){
            //System.out.println(a.charAt(i)+" "+b.charAt(i));
            dus.union(a.charAt(i),b.charAt(i));
        }
        String ans = "";
        for(int i = 0;i<c.length();i++){
            ans = ans + dus.find(c.charAt(i));
        }
        System.out.println(ans);
        
    }
}