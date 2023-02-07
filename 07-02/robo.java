/*Chitti(ROBO) is busy in turning the people into chittis(ROBOS) by surrounding them.
In a room there are n*n boxes occupied by ROBOS and people.
   1.A person will be turned into ROBO if he is surrounded by all ROBOs. 
   2.A person will not be turned into ROBO if he is on the edge of the room
     and all the connected people to him (directly or indirectly) are also not to be turned.
 Return the n*n boxes after conversion.
 
Input Format
-------------
Line-1:integer n represent the n*n boxes of the room..
Next n lines:Each line of string consists of combination of 'X'(represents ROBO) and 'O'(represents a person)
   
Output Format:
--------------
Print n*n space seperated values after conversion.
  
   
Sample Input-1:
---------------
4
XXXX
XOOX
XXOX
OXXX
   
Sample Output-1:
----------------
X X X X 
X X X X 
X X X X 
O X X X 
   
Explanation:
------------
The people at second row and third row are converted to ROBOs as they are surrounded by ROBOs.
But the person at fourth row is safe as he is on edge.
  
   
Sample Input-2:
---------------
5
XOOOX
XXXXX
XOXXX
XXXOX
OXXXX
  
Sample Output-2:
----------------
X O O O X 
X X X X X 
X X X X X 
X X X X X 
O X X X X 
*/

import java.util.*;
class Test{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char arr[][] = new char[n][n];
        for(int i = 0;i<n;i++){
            String s = sc.next();
            for(int j = 0;j<n;j++){
                arr[i][j] = s.charAt(j);
            }
        }
        
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
               if((i==0 || j==0 || i==n-1 || j==n-1) && arr[i][j]=='O'){
                   dfs(arr,i,j);
               }
            }
        }
        

        
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(arr[i][j]=='K') arr[i][j]='O';
                else if(arr[i][j]=='O') arr[i][j] = 'X';
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        
        
    }
    static void dfs(char[][] arr,int i,int j){
        if(i<0 || j<0 || i==arr.length || j==arr.length || arr[i][j]=='X' || arr[i][j]=='K') return;
        arr[i][j] = 'K';
        dfs(arr,i+1,j);
        dfs(arr,i-1,j);
        dfs(arr,i,j+1);
        dfs(arr,i,j-1);
    }
}