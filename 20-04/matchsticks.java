/*You are given an integer array matchsticks where matchsticks[i] is the length of the ith matchstick. You want to use all the matchsticks to make one square. You should not break any stick, but you can link them up, and each matchstick must be used exactly one time.

Return true if you can make this square and false otherwise.
input : integer n which gives number of match sticks
        n integer values
output : true/false
example
input = 
5
1 1 2 2 2
output = true
Explanation : we can use match sticks with length 1 to form one side and other three sides are having match sticks with length 2
example 
input = 
5
3 3 3 3 4
output = false
Explanation we cannot for swuare using all the five matchsticks
 */

 import java.util.*;

public class Test{
    public static boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for(int stick : matchsticks) {
            sum += stick;
        }
        if(sum % 4 != 0) {
            return false; 
        }
        int side = sum / 4;
        Arrays.sort(matchsticks); 
        int[] sides = new int[4];
        return backtrack(matchsticks, sides, matchsticks.length-1, side); 
    }
    
    private static boolean backtrack(int[] matchsticks, int[] sides, int index, int sideLength) {
        if(index < 0) { 
            return true;
        }
        for(int i=0; i<4; i++) { 
            if(sides[i] + matchsticks[index] <= sideLength) {
                sides[i] += matchsticks[index];
                if(backtrack(matchsticks, sides, index-1, sideLength)) { 
                    return true;
                }
                sides[i] -= matchsticks[index];
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] matchsticks = new int[n];
        for(int i=0; i<n; i++) {
            matchsticks[i] = sc.nextInt();
        }
        System.out.println(makesquare(matchsticks));
    }
}