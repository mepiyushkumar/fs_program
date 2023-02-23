/*Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.

Example 1:
input =1432219
3
output =1219

num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.


Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.
*/
import java.util.*;
class Test{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        List<Integer> l = new ArrayList<>();
        while(n>0){
            l.add(n%10);
            n=n/10;
        }
        Collections.reverse(l);
        //System.out.println(l);
        for(int i = 0;i<k;i++){
            int kk = 0;
            while(kk<l.size()-1 && l.get(kk)==l.get(kk+1)){ 
                kk++;
            }
            if(kk == l.size()-1) l.remove(0);
            else if(l.get(kk)>l.get(kk+1)) l.remove(kk); // 54321 // 12345
            else{
                int kkk = kk;
                while(kkk<l.size()-1 && l.get(kkk)<l.get(kkk+1)){
                    kkk++;
                }
                l.remove(kkk);
            }
        }
        //System.out.println(l);
        if(l.size()==0) System.out.println("0");
        else{
            StringBuffer sb = new StringBuffer("");
            for(int i = 0;i<l.size();i++) sb.append(l.get(i));
            System.out.println(Integer.parseInt(sb.toString()));
        }
        
    }
}