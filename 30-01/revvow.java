/* Given a string s, .reverse only all the vowels in the 
string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can 
appear in both lower and upper cases, more than once.

Example 1:
Input: hello
Output: holle


Example 2:
Input: Keshavmemorial
Output: Kashivmomerael

Example 3:
Input: variations
Output: voriatians

*/

import java.util.*;
class Test{
    public static String RevVow(String s){
        int i = 0;
        int j = s.length()-1;
        char arr[] = s.toCharArray();
        String vowel = "aeiou";
        while(i!=j){
            if((i+1)==j){
                if(vowel.indexOf(arr[i])>=0 && vowel.indexOf(arr[j])>=0){
                    char temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                    i++;
                    j--;
                }
                break;
            }
            else if(vowel.indexOf(arr[i])>=0 && vowel.indexOf(arr[j])>=0){
                char temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i++;
                j--;
            }
            else if(vowel.indexOf(arr[i])>=0){
                j--;
            }
            else if(vowel.indexOf(arr[j])>=0){
                i++;
            }
            else{
                i++;
                j--;
            }
        }
        String res = new String(arr);
        return res;
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(RevVow(s));
    }
}