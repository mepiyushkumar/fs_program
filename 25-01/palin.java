/*Cliff Shaw is working on the singly linked list.
He is given a list of boxes arranged as a singly linked list,
where each box is printed with a positive number on it.

Your task is to help Mr. Cliff to find if the given list is equivalent to 
the reverse of it or not. If yes, print "true", otherwise print "false"

Implement the class Solution:
    - boolean isPalindrome(Node n)
    
Input Format:
-------------
Line-1: space separated integers, boxes as list.

Output Format:
--------------
Print a boolean a value.


Sample Input-1:
---------------
3 6 2 6 3

Sample Output-1:
----------------
true


Sample Input-2:
---------------
3 6 2 3 6

Sample Output-2:
----------------
false

*/


import java.util.*;

/*
// Node Structure for reference
class Node{    
	int data;    
	Node next;    
		
	public Node(int data) {    
		this.data = data;    
		this.next = null;    
	}    
}    
*/

class Solution
{
    boolean isPalindrome(Node head) 
    {
        Node slow = head;
        boolean ispalin = true;
        Stack<Integer> stack = new Stack<Integer>();
 
        while (slow != null) {
            stack.push(slow.data);
            slow = slow.next;
        }
 
        while (head != null) {
 
            int i = stack.pop();
            if (head.data == i) {
                ispalin = true;
            }
            else {
                ispalin = false;
                break;
            }
            head = head.next;
        }
        return ispalin;
    }
  
}
