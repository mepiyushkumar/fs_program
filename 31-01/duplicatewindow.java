/* Given an integer array of nums and an integer X(Window size -1), 
return true if there are duplicate values in that Window(X)
X size is always == abs(i - j)    where i and j are two two 
distinct indices of array.

Sample Input/output
------------------
input:
--------------
array size
array elements
X   
output:
-----------
true

Example 1:
Input: 4            
1 2 3 1  
3       
Output: true

case 2:
Input: 6
1 2 3 1 2 3
2
Output: false
*/


import java.util.*;
class Test{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        
        System.out.println(sliWin(n,k+1,arr));
    }
    
    static boolean sliWin(int n,int k,int[] arr){
        List<Integer> l = new ArrayList<>();
        for(int i = 0;i<k;i++){
            l.add(arr[i]);
            if(cheak(l)){
                return true;
            }
        }
        for(int i=k;i<n;i++){
            if(cheak(l)){
                return true;
            }
            l.remove(0);
            l.add(arr[i]);
        }
        return false;
    }
    
    static boolean cheak(List<Integer> l){
        Set<Integer> hSet = new HashSet<>();
        for(int x : l)
            hSet.add(x);
        if(hSet.size()==l.size()) return false;
        return true;
    }
    
    
}