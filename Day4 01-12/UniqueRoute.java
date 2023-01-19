/*
A professional thief entered into a floor in a building,
The floor has M*N inter connected rooms, the thief can enter into any room 
from any other room. And there are few rooms closed from inside, so the thief 
cannot enter into them. Initially the thief is at room[0][0] and has to exit 
from room[m-1][n-1].

You will be given the array room[][], filled with either 0 or 1.
Here, 1-indiactes a closed room, 0-indiactes a open room.
Your task is to find and print the number of unique escape routes 
from room[0][0] and room[m-1][n-1]. And the thief can move only in 
two directions one is forward direction and other is downward direction.


Input Format:
-------------
Line-1: Two space separated integers, M and N.
Next M lines: N space separated integers, either 0 or 1.

Output Format:
--------------
Print an integer result.

Sample Input-1:
---------------
3 4
0 0 0 0
0 1 0 0
0 0 1 0

Sample Output-1:
----------------
2


Sample Input-2:
---------------
4 4
0 0 0 0
0 0 1 0
1 0 0 0
0 0 1 0

Sample Output-2:
----------------
3
*/



import java.util.*;
class Test{
    public static int c = 0;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr[][] = new int[n][m];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        if(arr[0][0]==1){
            System.out.println(-1);
        }
        else{
            //dfs(arr,0,0);
            //System.out.println(c);
            int dp[][] = new int[n+1][m+1];
            for(int i = 1;i<=m;i++){
                if(arr[0][i-1]==0){
                    dp[1][i] = 1;
                }
                else{
                    break;
                }
            }
            for(int i = 2;i<=n;i++){
                for(int j = 1;j<=m;j++){
                    if(arr[i-1][j-1]==1) dp[i][j] = 0;
                    else dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
            System.out.println(dp[n][m]);
        }
        sc.close();
    }
    /*public static void dfs(int arr[][],int i,int j){
        if(i<0 || j<0 || i==arr.length || j==arr[0].length || arr[i][j]==1){
            return;
        }
        else if(i==arr.length-1 && j==arr[0].length-1){
            c++;
            return;
        }
        else{
            arr[i][j] = 1;
            dfs(arr,i+1,j);
            dfs(arr,i,j+1);
            arr[i][j] = 0;
        }
    }*/
}