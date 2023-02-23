/*
Given an integer array nums and an integer k, return the k most frequent elements. 

Note: If the frequency of the elements are same then pick the element with higher value.

Example 1:
input =6
1 1 1 2 2 3
2
output =1 2

explanation
nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Input: nums = [1], k = 1
Output: [1]
 


Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.

 */


 import java.util.*;
class Test{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer,Integer> m = new HashMap<>();
        List<Integer> l = new ArrayList<>();
        for(int i = 0;i<n;i++){
            int k = sc.nextInt();
            m.put(k,m.getOrDefault(k,0)+1);
        }
        int kk = sc.nextInt();
        for(int i :m.keySet()){
            l.add(i);
        }
        Collections.sort(l,(a,b)->{if(m.get(a)==m.get(b)){return b-a;}else{return m.get(b)-m.get(a);}});
        
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<kk;i++){
            res.add(l.get(i));
        }
        System.out.println(res.toString());
        
    }
}