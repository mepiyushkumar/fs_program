/* Two brothers want to play a game, 
The rules of the game are: one player gives two sorted lists of 
numerical elements and a number (sum). 
The opponent has to find the closest pair of elements 
to the given sum.
-> pair consists of elements from each list

Please help those brothers to develop a program, that takes 
two sorted lists as input and return a pair as output.

Input Format:
-------------
size of list_1
list_1 values
size of list_2
list_2 values
closest number

Output Format:
--------------
comma-separated pair

Sample Input-1:
---------------
4
1 4 5 7
4
10 20 30 40
32
Sample Output-1
---------------
1,30

Sample Input-2
---------------
3
2 4 6
4
5 7 11 13
15

*/





import java.util.*;
class Test{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr1[] = new int[n];
        for(int i = 0;i<n;i++){
            arr1[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int arr2[] = new int[m];
        for(int i = 0;i<m;i++){
            arr2[i] = sc.nextInt();
        }
        
        int ans = sc.nextInt();
        
        int a = arr1[0];
        int b = arr2[m-1];
        
        int i = 0;
        int j = m-1;
        
        int min = Integer.MAX_VALUE;
            
        while(i!=n && j!=0){
            int diff = ans - (arr1[i]+arr2[j]);
            if(Math.abs(diff)<min){
                min = Math.abs(diff);
                a = arr1[i];
                b = arr2[j];
            }
            if(diff==0){
                break;
            }
            else if(diff<0){
                j--;
            }
            else{
                i++;
            }
        }
        
        System.out.println(a+","+b);
        
    }
}