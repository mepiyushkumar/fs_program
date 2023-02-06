/*There are 10 poles in a line numbered from 0 to 9, and there are a bunch of bulbs, each bulb omits any one of the given color light, color-A, color-B, color-C.
All bulbs are fixed to all the 10 poles. You have given the arrangement as a string, consists of letters ABC and digits0-9(i.e., pole numbers).
For example, A1B2C1A2, indicates, 
A color bulb is fixed to pole-1, B color bulb is fixed to pole-2
C color bulb is fixed to pole-1, A color bulb is fixed to pole-2.

Your task is to find the number of poles, that are fixed with all three different color bulbs.
Input Format:
------------------
A String S, the arrangement. 

Output Format:
--------------------
Print an integer result.


Sample Input-1:
---------------------
C0C6B0A6A0A6B9

Sample Output-1:
----------------------
1

Explanation: 
----------------
Pole-0 fixed with 3 bulbs omits all colors: A, B, and C.
Pole-6 fixed with 3 bulbs, but omits only 2 colors, A and C.
Pole-9 fixed with only 1 bulb.
Thus, the number of poles fixed with the bulbs whihc omits 
all three colors is 1.


Sample Input-2:
---------------------
A1B2C1A2

Sample Output-2:
----------------------
0
*/

import java.util.*;
class Test{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        Map<Integer,String> m = new HashMap<>();
        for(int i = 0;i<s.length()/2;i++){
            if(!m.containsKey(s.charAt(2*i+1)-'0')){
                m.put(s.charAt(2*i+1)-'0',s.charAt(2*i)+"");
            }
            else{
                m.put(s.charAt(2*i+1)-'0',m.get(s.charAt(2*i+1)-'0')+s.charAt(2*i)+"");
            }
        }
        System.out.println(m.values());
        int c = 0;
        for(int i :m.keySet()){
            String ss = m.get(i);
            if(ss.indexOf('A')>=0 && ss.indexOf('B')>=0 && ss.indexOf('C')>=0) c++;
        }
        System.out.println(c);
        
    }
}