// https://practice.geeksforgeeks.org/problems/min-distance-between-two-given-nodes-of-a-binary-tree/1/?ref=self

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
class MinDistBetweenNodesofaBinaryTree
{
    // driver function to test the above functions
    public static void main(String args[])
    {
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
            
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            GfG g = new GfG();
            //Node k = g.LCA(root,a,b);
            System.out.println(g.findDist(root,a,b));
            //System.out.println();
            t--;
            
        }
    }
}



/*Please note that it's Function problem i.e.
 you need to write your solution in the form of Function(s) only.
 Driver Code to call/invoke your function is mentioned above.*/

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
/* Should return minimum distance between a and b
 in a tree with given root*/
class GfG
{
    int dist(Node root , int a )
    {
        if(root == null)
        {
            return -1;
        }
        
        if(root.data == a)
        {
            return 0;
        }
        int list = dist(root.left, a);
        if(list != -1)
        {
            
            return list+1;
        }
        int rist = dist(root.right, a);
        if(rist != -1)
        {
            System.out.println(rist);
            return rist+1;
        }
        return -1;
    }
    
    public boolean check(Node node, int n1,int n2)
    {
        if(node == null)
        {
            return false;
        }
        if(node.data == n1 || node.data == n2)
        {
            return true;
        }
        
        return check(node.left,n1,n2) || check(node.right,n1,n2);
    }
    Node LCA(Node root, int n1,int n2)
    {
        // Your code here
        if(root == null)
        {
            return null;
        }
        if(root.data == n1 || root.data == n2)
        {
            return root;
        }
        boolean left = check(root.left,n1,n2);
        boolean right = check(root.right,n1,n2);
        if(left == true && right == true)
        {
            return root;
        }
        else if(left == true && right == false)
        {
            return LCA(root.left, n1,n2);
        }
        else if(left == false && right == true)
        {
            return LCA(root.right,n1,n2);
        }
        return null;
    }
    
    int findDist(Node root, int a, int b)
    {
        // Your code here
        if(a == b)
        {
            return 0;
        }
        System.out.println(root.data);
        Node lca = LCA(root,a,b);
        System.out.println(lca.data);
        int adist = dist(lca,a);
        System.out.println(adist);
        int bdist = dist(lca,b);
        System.out.println(adist);
        return adist+bdist;
        
    }
}
