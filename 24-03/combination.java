/*Given an array of distinct integers candidates and a target integer target, return a list 
of all unique combinations of candidates where the chosen numbers sum to target. You may 
return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two 
combinations are unique if the 
frequency
 of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to 
target is less than 150 combinations for the given input.

 

Example 1:

Input: 4
2 3 6 7
 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
Example 2:
Input: 3
2 3 5 
8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:
Input: 1
2
1
Output: []
 */

 import java.util.*;
class Test{
    public static List<List<Integer>> res = new ArrayList<>();
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0;i<n;i++) arr[i] = sc.nextInt();
        int tar = sc.nextInt();
        List<Integer> l = new ArrayList<>();
        fn(arr,n,0,0,tar,l);
        System.out.println(res);
    }
    public static void fn(int arr[],int n,int idx,int sum,int target,List<Integer> l){
        if(sum==target){
            //System.out.println(new ArrayList<>(l));
            res.add(new ArrayList<>(l));
            //System.out.println(res);
            return;
        }
        if(idx==n || sum>target){
            return;
        }
        l.add(arr[idx]);
        fn(arr,n,idx,sum+arr[idx],target,l);
        l.remove(l.size()-1);
        fn(arr,n,idx+1,sum,target,l);
    }
}