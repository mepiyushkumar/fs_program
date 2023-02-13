/*Mr.Sathya is playing with numbers he converts the decimal to binary and try to find number of positions at which the corresponding
bits are different. Help sathya by giving solution to the problem to find sum of bits differences between all the pairs of the 
integers in given numbers.
Input
Number of integers and List of integers
output
Return the sum of bit differences between all the pairs of the integers.
 
Example 1:

Input:
3
4 14 2
Output:4 14
4 2
14 2
6
Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just
showing the four bits relevant in this case).
The answer will be:
HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.

Example 2:
Input: 
3
4 14 4
Output: 4 14
4 4
14 4
4*/

/*

Calculate the XOR of two numbers.
Count the number of set bits.

*/
import java.util.*;
class Test
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0; i<n; i++)
        {
            a[i]=sc.nextInt();
        }
        System.out.println(func(a));
    }
    public static int fn(int a,int b){
        int sum = 0;
        int n =a^b;
        while(n>0){
            sum+= n&1;
            n >>= 1;
        }
        return sum;
    }
    public static int func(int[] a)
    {
        int sum = 0;
        int n = a.length;
        for(int i=0; i<=n-2; i++)
        {
            for(int j=i+1; j<=n-1; j++)
            {   
                System.out.println(a[i]+" "+a[j]);
                sum+=fn(a[i],a[j]);
            }
        }
        return sum;
    }
}