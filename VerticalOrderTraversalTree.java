//Initial Template for Java
import java.util.Scanner;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.*;
import java.lang.*;
import java.io.*;
class Node
{
    int data;
    Node left, right;
    
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}
class VerticalOrderTraversalTree
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            HashMap<Integer, Node> m = new HashMap<Integer, Node>();
            int n = sc.nextInt();
            Node root = null;
            while(n-- > 0)
            {
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                char lr= sc.next().charAt(0);
                
                
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
            }
            
            GFG gfg = new GFG();
            gfg.verticalOrder(root);
            System.out.println();
        }
    }
}


/*Please note that it's Function problem i.e.
 you need to write your solution in the form of Function(s) only.
 Driver Code to call/invoke your function is mentioned above.*/

//User function Template for Java
/* A binary tree node has data, pointer to left child
 and a pointer to right child
 class Node
 {
 int data;
 Node left;
 Node right;
 } */
class GFG
{
    HashMap<Integer,LinkedList<Node>> hash = new HashMap<Integer,LinkedList<Node>>();
    void verticalOrder(Node root)
    {
        // add your code
        int a = 2500;
        LinkedList<Node> list = new LinkedList<Node>();
        list.add(root);
        hash.put(a,list);
        vertical(a,root);
        Collection<LinkedList<Node>> collect = hash.values();
        Iterator<LinkedList<Node>> itr = collect.iterator();
        while(itr.hasNext())
        {
            LinkedList<Node> indList = (LinkedList<Node>)itr.next();
            Iterator i = indList.iterator();
            while(i.hasNext())
            {
                Node getNode = (Node)i.next();
                System.out.print(getNode.data + " ");
            }
        }
        
    }
    
    void vertical(int a , Node root)
    {
        if(root.left != null)
        {
            if(hash.containsKey(a-1))
            {
                LinkedList<Node> list =  hash.get(a-1);
                list.add(root.left);
                hash.replace(a-1,list);
            }
            else
            {
                LinkedList<Node> list = new LinkedList<Node>();
                list.add(root.left);
                hash.put(a-1,list);
            }
            vertical(a-1,root.left);
        }
        if(root.right != null)
        {
            if(hash.containsKey(a+1))
            {
                LinkedList<Node> list =  hash.get(a+1);
                list.add(root.right);
                hash.replace(a+1,list);
            }
            else
            {
                LinkedList<Node> list = new LinkedList<Node>();
                list.add(root.right);
                hash.put(a+1,list);
            }
            vertical(a+1,root.right);
        }
    }
}
