/*In a joint family, every person assigned with an ID, an integer value.
and the entire family is arranged in the form of a tree.

You will be given the family tree,
your task is to find and print the person ID, who is only child to his/her parent.
i.e, the person with no siblings. Print all such person ID's in ascending order.

NOTE: 
	- If only one person is there in the family, please consider him as a parent.
	- In the given tree, please consider '-1' as null.

Input Format:
-------------
Single line of space separated int egers, person ID's in the family.

Output Format:
--------------
Print the list of person IDs in ascending order.


Sample Input-1:
---------------
2 3 4 -1 5

Sample Output-1:
----------------
[5]

Sample Input-2:
---------------
11 99 88 77 -1 -1 66 55 -1 -1 -1 -1 -1 -1 44

Sample Output-2:
----------------
[44, 55, 66, 77]


*/

import java.util.*;

class BinaryTreeNode{
	public int data; 
	public BinaryTreeNode left, right; 
	public BinaryTreeNode(int data){
		this.data = data; 
		left = null; 
		right = null; 
	}
}

class Solution {
    public ArrayList<Integer> getPersonIDs(BinaryTreeNode root) {
		ArrayList<Integer> nodes = new ArrayList<>();
		getPersonIDs(root, false, nodes); // root is not lonely
		return nodes;
	}
	private void getPersonIDs(BinaryTreeNode root, boolean isLonely, ArrayList<Integer> nodes) {
		// Write your logic here 
	}
	
}
public class LonelyNodes{
	static BinaryTreeNode root;
	void insert(BinaryTreeNode temp, int key)
    {
			//write your logic here
    }
    
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		LonelyNodes ln=new LonelyNodes();
		Solution sol= new Solution();
		
		String str[]=sc.nextLine().split(" ");
		root=new BinaryTreeNode(Integer.parseInt(str[0]));
		for(int i=1; i<str.length; i++)
			ln.insert(root,Integer.parseInt(str[i]));
		ArrayList<Integer> result=sol.getPersonIDs(root);
		Collections.sort(result);
		System.out.println(result);
	}
}

/*
