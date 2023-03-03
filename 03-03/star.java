/*You are given a string s, which contains stars *.

In one operation, you can:

Choose a star in s.
Remove the closest non-star character to its left, as well as remove the star itself.
Return the string after all stars have been removed.

input= kes**hav**mem**orial
output= khmorial
 */

 import java.util.*;
class Test{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        Stack<Character> st = new Stack<>();
        for(char i : s.toCharArray()){
            if(s.isEmpty()) st.push(i);
            else if(i=='*') st.pop();
            else st.push(i);
        }
        s = "";
        while(!st.isEmpty()) s= st.pop()+s;
        System.out.println(s);
    }
}