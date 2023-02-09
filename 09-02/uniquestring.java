/*
Mr. Dhanush has provided the string NUM, which solely contains digits.
He is looking for substrings that are numbers and have an equal number of 
distinct digits in each of them. It follows the rule if the number is 123123, 
but not if the number is 12312.

Your task is to assist Mr. Dhanush in determining the number of distinct 
substrings (numbers) of NUM that adhere to the mentioned rule.


Input Format:
-------------
A string NUM, consist of diits [0-9]

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
6767


6 7 6 7
67 76 67 
676 767 
6767



Sample Output-1:
----------------
5

Explanation: 
------------
The list of words are: 6,7,67,76,6767


Sample Input-2:
---------------
2345432

Sample Output-2:
----------------
16

Explnation:
-----------
The list of words are: 2,3,4,5,23,34,45,54,43,32,234,345,543,432,2345,5432
 */


 import java.util.*;
class Test{
    public static Set<String> set = new HashSet<>();
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        
        for(int i = 1;i<=s.length();i++){
            StringBuffer sb = new StringBuffer("");
            for(int j = 0;j<i;j++){
                sb.append(s.charAt(j));
            }
            fn(sb.toString());
            for(int j = i;j<s.length();j++){
                sb.deleteCharAt(0);
                //System.out.println(sb.toString());
                sb.append(s.charAt(j));
                fn(sb.toString());
            }
        }
        //System.out.println(set);
        System.out.println(set.size());
        
    }
    
    public static void fn(String s){
        Map<Character,Integer> m = new HashMap<>();
        for(int i=0;i<s.length();i++){
            m.put(s.charAt(i),m.getOrDefault(s.charAt(i),0)+1);
        }
        //System.out.println(m);
        int v = m.get(s.charAt(0));
        for(int i :m.values()){
             if(i!=v) return;
        }
            set.add(s);
    }
    
}