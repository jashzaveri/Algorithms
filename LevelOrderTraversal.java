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
class LevelOrderTraversal
{
    
    
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
            g.levelOrder(root);
            System.out.println();
            t--;
            
        }
    }
}



/*Please note that it's Function problem i.e.
 you need to write your solution in the form of Function(s) only.
 Driver Code to call/invoke your function is mentioned above.*/

class GfG
{
    void levelOrder(Node node)
    {
        // Your code here
        Queue<Node> queue = new LinkedList<Node>();
        System.out.print(node.data + " ");
        queue.add(node);
        level(queue);
    }
    
    void level(Queue<Node> queue)
    {
        Queue<Node> next = new LinkedList<Node>();
        while(queue.size() > 0)
        {
            Node a = queue.poll();
            if(a.left != null)
            {
                System.out.print(a.left.data + " ");
                next.add(a.left);
            }
            if(a.right != null)
            {
                System.out.print(a.right.data + " ");
                next.add(a.right);
            }
        }
        if(next.size() != 0)
        {
            level(next);
        }
    }
}
