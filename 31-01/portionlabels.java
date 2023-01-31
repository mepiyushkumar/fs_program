/* You are given a string s. We want to partition the string into 
as many parts as possible so that each letter appears in at most 
one part. 

Note that the partition is done so that after concatenating 
all the parts in order, the resultant string should be s.


Return a list of integers representing the size of these parts. 

 

Example 1:
Input: ababcbacadefegdehijhklij 
Output: [9, 7, 8]

Explanation:
The partition is "ababcbaca", "defegde", "hijhklij". 
This is a partition so that each letter appears in at most one part. 
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts. 

Example 2:
Input: eccbbbbdec
Output: [10]

Example 3:
Input: abacadcklmklmxyyzx 
Output: [7, 6, 5]

*/

import java.util.*;
class Test {
    public static List<Integer> par(String s) {
        Map<Character,Integer> m = new HashMap<>();
        for(int i = s.length()-1;i>=0;i--){
            if(!m.containsKey(s.charAt(i))){
                m.put(s.charAt(i),i);
            }
        }
        //System.out.println(m.values());
        int i = 0;
        int j = 0;
        List<Integer> res = new ArrayList<>();
        while(i<s.length()){
            if(i<s.length() && m.get(s.charAt(i))>j){
                j = m.get(s.charAt(i));
                
                i++;
            }
            else if(i==j){
                res.add(j);
                i++;
                if(i<s.length()){
                    j=m.get(s.charAt(i));
                }
            }
            else{
                i++;
            }
        }
        for(int k =res.size()-1;k>0;k--){
            res.set(k,res.get(k)-res.get(k-1));
        }
        res.set(0,res.get(0)+1);

        return res;
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(par(s));
    }
}
