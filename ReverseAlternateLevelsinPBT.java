{
// INITIAL CODE
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
// class to access index value by reference
class Index 
{
   int index;
   
}
class ReverseAlternateLevelsinPBT
{
	int height(Node node)
	{
		if(node == null)
			return 0;
		int l = 1+height(node.left);
		int r = 1+height(node.right);
		if(l>r)
			return l;
		else
			return r;
	}
	
	void printInorder(Node node) 
	{
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }
	
    // driver function to test the above functions
    public static void main(String args[])
    {
		ReverseAlternateNode RAN = new ReverseAlternateNode();
		//Index index_obj = new Index();
        // Input the number of test cases you want to run
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0)
        {
            HashMap<Integer, Node> m = new HashMap<Integer, Node> ();
            int n = sc.nextInt();
            Node root = null;
            while (n > 0)
            {	
			
				int n1 = sc.nextInt();
                int n2 = sc.nextInt();
				char lr= sc.next().charAt(0);
				
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
			
			g.reverseAlternate(root);
			
            RAN.printInorder(root);
           System.out.println();
            t--;
			
        }
    }
}

}

/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

/*
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
// class to access index value by reference
class Index 
{
   int index;
}
*/
class GfG
{
	Index index_obj = new Index();  // Object of class Index
                // Your code here
        void reverseAlternate(Node node)
        {
                // Your code here
                Node root = node;
                int dep = 1;
                reverse(root,dep);
        }
        void reverse(Node node, int dep)
        {
            dep++;
            if(dep%2 == 0)
            {
                Node root = node;
                if(root.left != null && root.right != null)
                {
                    int a = (root.left).data;
                    (root.left).data = (root.right).data;
                    (root.right).data = a;
                    reverse(root.left,dep);
                    reverse(root.right,dep);
                }

            }
        }        
}