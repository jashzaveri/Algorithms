
// INITIAL CODE
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.HashMap;
import java.util.*;
import java.lang.*;
import java.io.*;
// A Binary Tree node
class Node
{
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
class ReverseLevelOrder
{
	int height(Node node)
		{
			if(node==null)
				return 0;
			int l = 1+height(node.left);
			int r = 1+height(node.right);
			if(l>r)
				return l;
			else
				return r;
		}
	
    // driver function to test the above functions
    public static void main(String args[])
    {
		
        // Input the number of test cases you want to run
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
		//Node root=null;
        while (t > 0)
        {
            HashMap<Integer, Node> m = new HashMap<Integer, Node> ();
            int n = sc.nextInt();
            Node root=null;
            while (n > 0)
            {
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                char lr = sc.next().charAt(0);
                //  cout << n1 << " " << n2 << " " << (char)lr << endl;
                Node parent = m.get(n1);
                if (parent == null)
                {
                    parent = new Node(n1);
                    m.put(n1, parent);
                    if (root == null)
                        root = parent;
                }
                Node child = new Node(n2);
                if (lr == 'L')
                    parent.left = child;
                else
                    parent.right = child;
                m.put(n2, child);
                n--;
            }
		
            GfG g = new GfG();
            g.reversePrint(root);
			System.out.println();
            t--;
			
        }
    }
}
}

/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

/* A Binary Tree node
class Node
{
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/
class GfG
{
	void reversePrint(Node node) 
        {
            // your code here
            LinkedList<Integer> arr = new LinkedList<Integer>();
            Queue<Node> queue = new LinkedList<Node>();
            if(node != null)
            {
                queue.add(node);
            }
            while(!queue.isEmpty())
            {
                Node a = queue.poll();
                arr.addFirst(a.data);
                if(a.left != null)
                {
                    queue.add(a.right);
                }
                if(a.right != null)
                {
                    queue.add(a.left);
                }
            }
            ListIterator<Integer> itr = arr.listIterator();
            while(itr.hasNext())
            {
                System.out.print(Integer.toString(itr.next()) + " ");
            }
        }
}      
       
