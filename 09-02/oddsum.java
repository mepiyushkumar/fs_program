/*
There are a series of boxes and each box is labelled with a number.
Your task is to find the subsets of boxes such that addition of all 
the numbers written on each box makes an odd number.

Return only the number of such subsets exist.
Since the answer can be very large, return it modulo 10^9 + 7.

Input Format:
-------------
Line-1: an integer n represents the number of boxes
Line-2: n space seperated integers represents the numbers on the boxes.

Output Format:
--------------
return an integer represents number of subsets.

Sample Input-1:
---------------
3
1 5 7

Sample Output-1:
----------------
4

Explanation:
------------
subsets with odd sum are [1],[5],[7],[1,5,7].

Sample Input-2:
---------------
4
2 3 4 5

Sample Output-2:
----------------
6

Explanation:
-------------
subsets with odd sum are [3],[5],[2,3],[3,4],[4,5],[2,3,4].
*/

import java.util.*;
class Test{
    public static int res = 0;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s[] = new int[n];
        
        for(int i = 0;i<n;i++) s[i] = sc.nextInt();
        
        for(int i = 1;i<=n;i++){
            List<Integer> l = new ArrayList<>();
            for(int j = 0;j<i;j++){
                l.add(s[j]);
            }
            fn(l);
            for(int j = i;j<n;j++){
                l.remove(0);
                l.add(s[j]);
                fn(l);
            }
        }
        System.out.println(res);
        
    }
    
    public static void fn(List<Integer> l){
        int ans = 0;
        for(int i:l) ans+=i;
        if(ans%2!=0) res++;
    }
    
}