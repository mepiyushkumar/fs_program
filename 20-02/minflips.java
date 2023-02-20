/*Given 3 positives numbers a, b and c. 
Return the minimum flips required in some bits of a and b to make ( a OR b == c ). (bitwise OR operation).
Flip operation consists of change any single bit 1 to 0 or change the bit 0 to 1 in their binary representation.

Example 1:
Input: a = 2, b = 6, c = 5
Output: 3
Explanation: After flips a = 1 , b = 4 , c = 5 such that (a OR b == c)




Example 2:
Input: a = 4, b = 2, c = 7
Output: 1

Example 3:
Input: a = 1, b = 2, c = 3
Output: 0
 
Constraints:

1 <= a <= 10^9
1 <= b <= 10^9
1 <= c <= 10^9
*/

import java.util.*;
class Test{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int a=sc.nextInt(),b=sc.nextInt(),c=sc.nextInt();
        int flip = 0;
        while(c>0){
            if((a&1)==0 && (b&1)==0){
                if((c&1)==1){
                    flip++;
                }
            }
            else if((a&1)==1 && (b&1)==1){
                if((c&1)==0){
                    flip+=2;
                }
            }
            else if((a&1)==0 && (b&1)==1){
                if((c&1)==0){
                    flip++;
                }
            }
            else if((a&1)==1 && (b&1)==0){
                if((c&1)==0){
                    flip++;
                }
            }
            a>>=1;
            b>>=1;
            c>>=1;
        }
        System.out.println(flip);
    }
}