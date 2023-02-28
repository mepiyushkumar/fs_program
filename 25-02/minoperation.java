/*You are given a positive integer n, you can do the following operation any number of times:

Add or subtract a power of 2 from n.
Return the minimum number of operations to make n equal to 0.

A number x is power of 2 if x == 2i where i >= 0.

 

Example 1:

Input: n = 39
Output: 3
Explanation: We can do the following operations:
- Add 20 = 1 to n, so now n = 40.
- Subtract 23 = 8 from n, so now n = 32.
- Subtract 25 = 32 from n, so now n = 0.
It can be shown that 3 is the minimum number of operations we need to make n equal to 0.
Example 2:

Input: n = 54
Output: 3
Explanation: We can do the following operations:
- Add 21 = 2 to n, so now n = 56.
- Add 23 = 8 to n, so now n = 64.
- Subtract 26 = 64 from n, so now n = 0.
So the minimum number of operations is 3.
 

Constraints:

1 <= n <= 105
*/
import java.util.*;
class Test{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = 0;
       /* while(n>0){
            System.out.println(n);
            if((Math.log(n)/Math.log(2))%2==0){
                break;
            }
            else if(n==3){
                n--;
            }
            else if(n%4==1){
                n--;
            }
            else if(n%4==3){
                n++;
            }
            else{
                n = n - (int)Math.pow(2,(int)(Math.log(n)/Math.log(2)));
            }
            c++;
        }*/
        while(n>0){
            if((n&1)==1){
                c++;
                n=n/2;
                if((n&1)==1){
                    n++;
                }
            }
            else{
                n=n/2;
            }
        }
        System.out.println(c);
        
    }
}