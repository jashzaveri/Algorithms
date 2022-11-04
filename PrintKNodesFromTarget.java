// https://www.geeksforgeeks.org/print-nodes-distance-k-given-node-binary-tree/


import java.util.*;
import java.util.Scanner;
import java.util.HashSet;
import java.lang.Math;
class Node
{
    int data;
    Node left,right;
    Node(int d) {data = d; left =right= null; }
}

public class PrintKNodesFromTarget
{
    public static Node target;
    PrintKNodesFromTarget(){
        target=null;
    }
    public static void inorder(Node root,int key)
    {
        if(root==null)
            return;
        inorder(root.left,key);
        if(root.data==key)
            target=root;
        inorder(root.right,key);
    }
    /* Drier program to test above functions */
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        
        while(t-->0)
        {
            int n = sc.nextInt();
            PrintKNodesFromTarget llist=new PrintKNodesFromTarget();
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
            int key=sc.nextInt();
            inorder(root,key);
            int k=sc.nextInt();
            GFG obj = new GFG();
            obj.printkdistanceNode(root,target,k);
            System.out.println();
        }
    }
}

/*Please note that it's Function problem i.e.
 you need to write your solution in the form of Function(s) only.
 Driver Code to call/invoke your function is mentioned above.*/

/*class Node
 {
 int data;
 Node left,right;
 Node(int d){
 data=d;
 left=right=null;
 }
 }*/
//Complete the printkdistanceNode function.
/*This function returns distance of root from target node, it returns -1
 if target node is not present in tree rooted with root.*/
class GFG
{
    public static void printkdistanceDown(Node node , int k)
    {
        System.out.println(k);

        if(node == null || k < 0)
        {
            return;
        }
        if(k == 0 )
        {
            System.out.print(node.data);
            System.out.print(" ");
            return;
        }
        printkdistanceDown(node.left,k-1);
        printkdistanceDown(node.right,k-1);
    }
    
    public static int printkdistanceNode(Node root, Node target , int k)
    {
        //Add your code here.
        if(root == null)
        {
            return -1;
        }
        if(root == target)
        {
            printkdistanceDown(root,k);
            return 1;
        }
        
        int aist = printkdistanceNode(root.left,target,k);
        if(aist != -1)
            {
                if(aist == k)
                {
                    System.out.print(root.data);
                    System.out.print(" ");
                    return -1;
                }
                else
                {
                    printkdistanceDown(root.right,k-aist-1);
                }
                return aist + 1;
            }
        
        int rist = printkdistanceNode(root.right,target,k);
            if(rist != -1)
            {
                if(rist == k)
                {
                    System.out.print(root.data);
                    System.out.print(" ");
                    return -1;
                }
                else
                {
                    printkdistanceDown(root.left,k-rist-1);
                }
                return rist + 1;
            }
        return -1;
    
}
}

