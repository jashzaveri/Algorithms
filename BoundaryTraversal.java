//  https://practice.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1/?ref=self


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
class BoundaryTraversal
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
            g.printBoundary(root);
            System.out.println();
            t--;
            
        }
    }
}
/*This is a function problem.You only need to complete the function given below*/
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
 }*/
class GfG
{
    void printBoundary(Node node)
    {
        // Your code here
        System.out.print(Integer.toString(node.data) + " ");
        printLeft(node.left);
        printNode(node);
        printRight(node.right,node.data);
    }
    void printLeft(Node node)
    {
        if(node == null)
        {
            return;
        }
        if(node.left == null && node.right == null)
        {
            return;
        }
        System.out.print(Integer.toString(node.data) + " ");
        if(node.left != null)
        {
            printLeft(node.left);
        }
        else if(node.right != null)
        {
            printLeft(node.right);
        }
        else
        {
            return;
        }
    }
    void printNode(Node node)
    {
        if(node == null )
        {
            return;
        }
        else if(node.left == null && node.right == null)
        {
            System.out.print(Integer.toString(node.data) + " ");
            return;
        }
        printNode(node.left);
        printNode(node.right);
    }
    void printRight(Node node , int dat)
    {
        if(node == null)
        {
            return ;
        }
        if(node.left == null && node.right == null)
        {
            return ;
        }
        if(node.right != null)
        {
            printRight(node.right,dat);
        }
        else if(node.left != null)
        {
            printRight(node.left,dat);
        }
        if(node.data != dat)
        {
            System.out.print(Integer.toString(node.data) + " ");
        }
    }
}
