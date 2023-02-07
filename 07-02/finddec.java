/*
 There is a party happening in Novotel. There are N guests in the party.
There is a detective in the party and he/she is among one of the guests.
The guests are identified with unique ID's starts from 1 to N.

The rules to identify the detective are:
	- Every guest in the party knows the detective.
	- The detective knows no one in the party.
	- There is only one guest who satisfy both rule-1 and rule-2

You are given two integers N and R and the relations as an array, relations[], where relation[i]={guest-i, guest-j}, indicates guest-i knows h=guest-j.
Your task is to find the detective among the guests in the party and print the ID of the detective, Otherwise print -1.

Input Format:
-------------
Line-1: Two integers N and R, the number of guests and relations in the party.
Next R lines: contains 2 space-separated integers, relation[i]

Output Format:
--------------
Print an integer, the id of the detective.


Sample Input-1:
---------------
3 2		// N and R values
1 3
2 3

Sample Output-1:
----------------
3


Sample Input-2:
---------------
3 3
1 2
2 3
3 1

Sample Output-2:
----------------
-1

 */


 import java.util.*;
class Test{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int r=sc.nextInt();
        Map<Integer,Set<Integer>>m=new HashMap<>();
        for(int i=0;i<r;i++){
            int k=sc.nextInt();
            int v=sc.nextInt();
            if(m.containsKey(k)){
            Set<Integer>s=m.get(k);
            s.add(v);
                m.put(k,s);
            }
            else{
                Set<Integer>s=new HashSet<>();
                s.add(v);
                m.put(k,s);
            }
        }
        System.out.println(detect(m,n));
    }
    static int detect(Map<Integer,Set<Integer>>m,int n){
        //2nd detective knows no one
        int tempdet=0;
        for(int i=1;i<=n;i++){
            if(!m.containsKey(i)){
                tempdet=i;
            }
        }
        int c=0;
        for(Set<Integer>s:m.values())
        {
            if(s.contains(tempdet)){
                c++;
            }
        }
        if(c==n-1){
            return tempdet;
        }
        else{
            return -1;
        }
    }
}