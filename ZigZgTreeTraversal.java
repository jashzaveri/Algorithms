// https://practice.geeksforgeeks.org/problems/zigzag-tree-traversal/1/?ref=self

//Initial Template for Java
import java.util.*;
import java.util.HashMap;
class Node
{
    int data;
    Node left,right;
    Node(int d) {data = d; left =right= null; }
}

public class ZigZgTreeTraversal
{
    public static void inorder(Node root)
    {
        if(root==null)
            return;
        inorder(root.left);
        System.out.print(root.data);
        inorder(root.right);
    }
    /* Drier program to test above functions */
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        
        while(t-->0)
        {
            int n = sc.nextInt();
            ZigZgTreeTraversal llist=new ZigZgTreeTraversal();
            Node root=null,parent=null;
            HashMap<Integer, Node> m = new HashMap<>();
            for(int i=0;i<n;i++)
            {
                int a=sc.nextInt();
                int b=sc.nextInt();
                char c=sc.next().charAt(0);
                if(m.containsKey(a)==false)
                {
                    parent=new Node(a);
                    m.put(a,parent);
                    if(root==null)
                        root=parent;
                }
                else
                    parent=m.get(a);
                Node child=new Node(b);
                if(c=='L')
                    parent.left=child;
                else
                    parent.right=child;
                m.put(b,child);
            }
            GFG obj = new GFG();
            obj.zigZagTraversal(root);
            System.out.println();
        }
    }
}



/*Please note that it's Function problem i.e.
 you need to write your solution in the form of Function(s) only.
 Driver Code to call/invoke your function is mentioned above.*/

//User function Template for Java
/*class Node
 {
 int data;
 Node left,right;
 Node(int d)
 {
 data=d;
 left=right=null;
 }
 }*/
// Print the zig zag traversal of tree.
class GFG
{
    void zigZagTraversal(Node root)
    {
        Stack<Node> left = new Stack<Node>();
        Stack<Node> right = new Stack<Node>();
        boolean bit = false;
        if(root == null)
        {
            return;
        }
        System.out.print(root.data + " ");
        left.push(root);
        ziggy(bit,left,right);
        //Add your code here.
    }
    
    void ziggy(boolean bit , Stack<Node> left, Stack<Node> right)
    {
        
            if(!bit)
            {
                while(!left.empty())
                {
                    Node a = left.pop();
                    if(a.right != null)
                    {
                        System.out.print(a.right.data + " ");
                        right.push(a.right);
                    }
                    if(a.left != null)
                    {
                        System.out.print(a.left.data + " ");
                        right.push(a.left);
                    }
                }
                bit = true;
            }
            else
            {
                while(!right.empty())
                {
                    Node a = right.pop();
                    if(a.left != null)
                    {
                        System.out.print(a.left.data + " ");
                        left.push(a.left);
                    }
                    if(a.right != null)
                    {
                        System.out.print(a.right.data + " ");
                        left.push(a.right);
                    }
                }
                bit = false;
            }
        if(!left.empty() || !right.empty())
        {
            ziggy(bit,left,right);
        }
    }
}
