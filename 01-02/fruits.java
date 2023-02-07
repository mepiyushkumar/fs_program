/*You are visiting a farm that has a single row of fruit trees arranged from left to right.
 The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.
You want to collect as much fruit as possible. 

However, the owner has some strict rules that you must follow:
You only have two baskets, and each basket can only hold a single type of fruit. 
There is no limit on the amount of fruit each basket can hold.
Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree)
 while moving to the right. The picked fruits must fit in one of your baskets.
Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
Given the integer array fruits, return the maximum number of fruits you can pick.

Sample cases:

case 1:
Input: 
3
1 2 1
Output: 3
Explanation: We can pick from all 3 trees.

Case  2:
Input: 
4
0 1 2 2 
Output: 3
Explanation: We can pick from trees [1,2,2].
If we had started at the first tree, we would only pick from trees [0,1].

case 3:
Input: 
 5
1 2 3 2 2
Output: 4
Explanation: We can pick from trees [2,3,2,2].
If we had started at the first tree, we would only pick from trees [1,2].
*/
import java.util.*;
class har {
    public static int total(int[] arr) {
        int n = arr.length;
        int start  = 0;
        int dis = 0;
        int max = 0;
        Map<Integer,Integer> m = new HashMap<>();
        for(int i = 0;i<n;i++){
            if(!m.containsKey(arr[i]) || m.get(arr[i])==0){
                m.put(arr[i],1);
                dis++;
            }
            else{
                m.put(arr[i],m.getOrDefault(arr[i],0)+1);
            }
            
            while(dis>2){
                m.put(arr[start],m.get(arr[start])-1);
                if(m.get(arr[start])==0) dis--; 
                start++;
            }
            max = Math.max(max,i-start+1);
        }
        
        return max;
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(total(arr));
    }
}