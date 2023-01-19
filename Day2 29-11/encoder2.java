/*
Mr. Bob is a Military Encoders. 
Mr. Bob writes a word as shown below and then merges them. 
Help Bob to write the code. 

Mr. Bob will be given a word 'w' and a number 'n' 

Sample Test Case - 1
input = 
ABCDE
2
output = ACEBD


This is How Bob writes the letters of the word 
A    C    E
   B    D

Now concatenate the two rows and ignore spaces in every row. We get ACEBD


Sample Test Case - 2
input = system 
3
output = seytms

s         e
  y    t    m
     s

Now concatenate the 3 rows we get seytms*/


import java.util.*;
class Test{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = sc.nextInt();
        System.out.println(convert(s,n));
    }

public static String convert(String s, int n) {
    
        ArrayList<StringBuilder> l=new ArrayList<>();
        for(int i=0;i<n;i++){
            l.add(new StringBuilder());
        }
        int c=0;
        while(c<s.length()){
            for(int i=0;i<n && c<s.length() ;i++,c++){
                l.get(i).append(s.charAt(c));
            }
            for(int i=n-2;i>=1 && c<s.length();i--,c++){
                l.get(i).append(s.charAt(c));
            }
        }
        String ans="";
        for(int i=0;i<n;i++){
            String str=new String(l.get(i));
            ans=ans+str;
        }

        return ans;
}

}

