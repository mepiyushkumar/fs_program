/*Viraj Aanand is a wedding planner, He ordered his assistant to decorate a wall.
The decorator plans to decorate the wall with two different colored balloons.
The wall size is M*N, The decorator can decorate the wall using M*N balloons
the balloons are blue or white in color.

Blue colored ballons represented with digit-1 and 
White colored ballons represented with digit-0.

The blue colored balloons forms different shapes, that are connected 4 directonally.
The directons are upwards, downwards, left, and right. Viraj Aanand got an idea to 
count the unique shapes formed by blue colored ballons.

You will be given the decorated wall as a matrix wall[][].
Your task is to help, Viraj Aanand to count the unique shapes.

Input Format:
-------------
Line-1: Two space separated integers M and N, size of the wall.
Next M lines: N space separated integers, either 0 or 1.

Output Format:
--------------
Print an integer, Number of distinct shapes formed by blue balloons.


Sample Input-1:
---------------
4 5
1 1 0 0 0
1 1 0 0 0
0 0 0 1 1
0 0 0 1 1

Sample Output-1:
----------------
1


Sample Input-2:
---------------
5 5
1 1 0 1 1
1 0 0 0 1
0 0 0 0 0
1 0 0 0 1
1 1 0 1 1



(0,0)(0,1)(1,1)

(0,0)(0,1)(1,0)
 
Sample Output-2:
----------------
4
 */

 import java.util.*;

public class Test{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int arr[][] = new int[a][b];
        for(int i=0; i<a; i++){
            for(int j=0; j<b; j++){
                arr[i][j]=sc.nextInt();
            }
        }
        Set<List<Integer>> s = new HashSet<>();
        for(int i = 0;i<a;i++){
            for(int j = 0;j<b;j++){
                if(arr[i][j]==1){
                    List<Integer> l = new ArrayList<>();
                    l.add(i);
                    l.add(j);
                    dfs(arr,i,j,l);
                    l.remove(0);
                    l.remove(0);
                    s.add(l);
                }
            }
        }
        System.out.println(s.size());
        
    }
    
    public static void dfs(int[][] arr,int i,int j,List<Integer> l){
        if(i<0 || j<0 || i==arr.length || j==arr[0].length || arr[i][j]==0) return;
        l.add(i-l.get(0));
        l.add(j-l.get(1));
        arr[i][j] = 0;
        dfs(arr,i+1,j,l);
        dfs(arr,i-1,j,l);
        dfs(arr,i,j+1,l);
        dfs(arr,i,j-1,l);  
    }
}