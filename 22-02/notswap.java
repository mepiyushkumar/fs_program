/* 
 
You are given a positive integer num. You may swap any two digits of num that have the same parity (i.e. both odd digits or both even digits).
Return the largest possible value of num after any number of swaps.


Example 1:

Input: num = 1234

Output: 3412
Explanation: Swap the digit 3 with the digit 1, this results in the number 3214.
Swap the digit 2 with the digit 4, this results in the number 3412.
Note that there may be other sequences of swaps but it can be shown that 3412 is the largest possible number.
Also note that we may not swap the digit 4 with the digit 1 since they are of different parities.
Example 2:

1325686

1 3 5 

2 6 6 8



5 3 8 1 6 6 2




Input: num = 65875

55678

Output: 87655
Explanation: Swap the digit 8 with the digit 6, this results in the number 85675.
Swap the first digit 5 with the digit 7, this results in the number 87655.
Note that there may be other sequences of swaps but it can be shown that 87655 is the largest possible number.


*/


import java.util.*;
class Test{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = 0;
        PriorityQueue<Integer> even = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> odd = new PriorityQueue<>(Collections.reverseOrder());
        
        while(n>0){
            if((n%10)%2==0) even.add(n%10);
            else odd.add(n%10);
            m=m*10+n%10;
            n=n/10;
        }
        int res = 0;
        while(m>0){
            if((m%10)%2==0){
                res = res*10 + even.remove();
            }
            else{
                res = res*10 + odd.remove();
            }
            m=m/10;
        }
        
        System.out.println(res);
        
    }
}