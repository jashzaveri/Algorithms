// https://practice.geeksforgeeks.org/problems/mirror-tree/1

//Initial Template for Java
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
class MirrorTree
{
    void inOrder(Node node) {
        if (node == null) {
            return;
        }
        
        inOrder(node.left);
        System.out.print(node.data + " ");
        
        inOrder(node.right);
    }
    
    // driver function to test the above functions
    public static void main(String args[])
    {
        // Input the number of test cases you want to run
        Scanner sc = new Scanner(System.in);
        MirrorTree mt = new MirrorTree();
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
            g.mirror(root);
            mt.inOrder(root);
            System.out.println();
            t--;
        }
    }
}

// FUNCTION CODE
/* A Binary Tree node
 class Node
 {
 int data;
 Node left, right;
 Node(int item)    {
 data = item;
 left = right = null;
 }
 } */



/*Please note that it's Function problem i.e.
 you need to write your solution in the form of Function(s) only.
 Driver Code to call/invoke your function is mentioned above.*/

//function Template for Java
// FUNCTION CODE
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
 } */
class GfG
{
  /*  void mirror(Node node)
    {
        // Your code here
        Node next = new Node(0);
        mirrors(node,next);
        next.data = node.data;
        node = next;
    }
    
    void mirrors(Node node , Node next)
    {
        if(node == null)
        {
            return;
        }
        if(node.left != null)
        {
            next.right = node.left;
          //  System.out.println(next.right.data);
            mirrors(node.left,next.right);
          //  System.out.println(next.right.data);
        }
        if(node.right != null)
        {
            System.out.println(node.right.data);
            next.left = node.right;
            System.out.println(next.left.data);
            mirrors(node.right,next.left);
            System.out.println(next.left.data);
        }*/
    void mirror(Node node)
    {
        // Your code here
        node = mirrors(node);
    }
    Node mirrors(Node node)
    {
        if(node == null)
        {
            return null;
        }
        Node left = mirrors(node.left);
        Node right = mirrors(node.right);
        
        //swapping
        node.left = right;
        node.right = left;
        return node;
    }
}
