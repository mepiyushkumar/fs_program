/*/*
There are N cities, and M routes[], each route is a path between two cities.
routes[i] = [city1, city2], there is a travel route between city1 and city2.
Each city is numbered from 0 to N-1.
 
There are one or more Regions formed among N cities. 
A Region is formed in such way that you can travel between any two cities 
in the region that are connected directly and indirectly.
 
Your task is to findout the number of regions formed between N cities. 
 
Input Format:
-------------
Line-1: Two space separated integers N and M, number of cities and routes
Next M lines: Two space separated integers city1, city2.
 
Output Format:
--------------
Print an integer, number of regions formed.
 
 
Sample Input-1:
---------------
5 4
0 1
0 2
1 2
3 4
 
Sample Output-1:
----------------
2
 
 
Sample Input-2:
---------------
5 6
0 1
0 2
2 3
1 2
1 4
2 4
 
Sample Output-2:
----------------
1
 */

import java.util.*;
class DisjointUnionSets{
    int[] rank;
    int[] parent;
    int n;
    public DisjointUnionSets(int n){
        rank = new int[n];
        parent = new int[n];
        this.n=n;
        makeSet();
    }
    
    void makeSet(){
        for(int i = 0;i<n;i++){
            parent[i]=i;
            rank[i] = 0;
        }
    }
    int find(int x){
        if(x==parent[x]){
            return parent[x];
        }
        else{
            return parent[x] = find(parent[x]); 
        }
    }
    void union(int a,int b){
        int aRoot = find(a);
        int bRoot = find(b);
        if(rank[aRoot]<rank[bRoot]){
            parent[aRoot] = bRoot; 
        }
        else if(rank[aRoot]>rank[bRoot]){
            parent[bRoot] = aRoot;
        }
        else{
            if(aRoot>bRoot){
                parent[aRoot] = bRoot;
            }
            else{
                parent[bRoot] = aRoot;
            }
        }
    }
    
}
class Test{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        DisjointUnionSets dus =	new DisjointUnionSets(n);
        int m = sc.nextInt();
        
        for(int i = 0;i<m;i++){
            int r1 = sc.nextInt();
            int r2 = sc.nextInt();
            dus.union(r1,r2);
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 0;i<n;i++){
            set.add(dus.find(i));
        }
        System.out.println(set.size());
        
    }
}