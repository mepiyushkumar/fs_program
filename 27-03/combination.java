/*shobraj is  a professional robber planning to rob houses along a street. Each house has a 
certain amount of money stashed, the only constraint stopping him from robbing each of 
them is that adjacent houses have security systems connected and it will automatically 
contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the 
maximum amount of money he can rob tonight without alerting the police.

 

Example 1:

Input: 
4
1 2 3 1
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: 5 
2 7 9 3 1
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.
 */

 import java.util.*;
class Test{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0;i<n;i++) arr[i] = sc.nextInt();
        int dp[] = new int[n];
        dp[0] = arr[0];
        dp[1] = Math.max(dp[0],arr[1]);
        for(int i = 2;i<n;i++){
            dp[i] = Math.max(arr[i]+dp[i-2],dp[i-1]);
        }
        System.out.println(dp[n-1]);
    }
}