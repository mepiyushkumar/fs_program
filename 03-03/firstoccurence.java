/*Given a string s consisting of lowercase English letters, return the first letter to appear twice.

Note:

A letter a appears twice before another letter b if the second occurrence of a is before the second occurrence of b.
s will contain at least one letter that appears twice.

input = abacab
output= a
input = aaccbbdd
output = a
*/
import java.util.*;
class Test{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        Set<Character> set = new HashSet<>();
        for(char a : s.toCharArray()){
            if(set.contains(a)){
                System.out.println(a);
                System.exit(0);
            }
            set.add(a);
        }   
    }
}