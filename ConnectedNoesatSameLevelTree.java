// https://practice.geeksforgeeks.org/problems/connect-nodes-at-same-level/1/?ref=self

import java.util.*;
import java.lang.Integer;
import java.util.HashMap;
//import java.lang.Math;
import java.util.Queue;
import java.util.LinkedList;
import java.io.*;
// A Binary Tree node
class Node
{
    int data;
    Node left, right, nextRight;
    Node(int item)
    {
        data = item;
        left = right = nextRight = null;
        
    }
}
class ConnectedNoesatSameLevelTree
{
    void inorder(Node node)
    {
        if(node==null)
            return ;
        else
            inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
        
    }
    void printSpecial(Node root)
    {
        if(root == null)
            return ;
        Node node = root;
        while(node != null)
        {
            System.out.print(node.data+" ");
            node = node.nextRight;
        }
        if(root.left != null)
            printSpecial(root.left);
        else
            printSpecial(root.right);
        
    }
    
    
    
    // driver function to test the above functions
    public static void main(String args[])
    {
        
        // Input the number of test cases you want to run
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        ConnectedNoesatSameLevelTree  can = new ConnectedNoesatSameLevelTree ();
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
            
            g.connect(root);
            can.printSpecial(root);
            System.out.println();
            can.inorder(root);
            System.out.println();
            t--;
            
        }
    }
}


/*Please note that it's Function problem i.e.
 you need to write your solution in the form of Function(s) only.
 Driver Code to call/invoke your function is mentioned above.*/

// A Binary Tree node
/* class Node
 {
 int data;
 Node left, right, nextRight;
 Node(int item)
 {
 data = item;
 left = right = nextRight = null;
 
 }
 } */
class GfG
{
    void connect(Node root)
    {
        // Your code here
        Queue<Node> q = new LinkedList<Node>();
        if(root != null)
        {
            q.add(root);
            connected(q);
        }
    }
    void connected(Queue<Node> q)
    {
        Queue<Node> next = new LinkedList<Node>();
        if(q.size() >=2)
        {
            Iterator itr = q.iterator();
            Node a = (Node)itr.next();
            Node b = new Node(0);
            while(itr.hasNext())
            {
                b= (Node)itr.next();
                a.nextRight = b;
                a = b;
            }
            a.nextRight = null;
        }
        while(q.size() != 0)
        {
            Node a = q.poll();
            if(a.left != null)
            {
                next.add(a.left);
            }
            if(a.right != null)
            {
                next.add(a.right);
            }
        }
        if(next.size() != 0)
        {
            connected(next);
        }
    }
}
