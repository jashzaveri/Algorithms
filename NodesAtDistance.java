// https://www.geeksforgeeks.org/print-nodes-distance-k-given-node-binary-tree/
// look at PrintKNodesFromTarget.java
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

public class NodesAtDistance
{
    public static Node target;
    NodesAtDistance(){
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
            NodesAtDistance llist=new NodesAtDistance();
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
    public static int printkdistanceNode(Node root, Node target , int k)
    {
        //Add your code here.
        Node dist = new Node(0);
        Node reatT = getTarget(root ,target,0);
        System.out.println(reatT.data);
        LinkedList<Integer> list = new LinkedList<Integer>();
        values(k,reatT,list);
        int distance = dist.data;
        int diff = distance - k;
        if(diff == 0)
        {
            list.add(root.data);
        }
        Iterator itr = list.listIterator();
        while(itr.hasNext())
        {
            int a = (Integer)itr.next();
            System.out.print(Integer.toString(a) + " ");
        }
        return -1;
    }
    
    public static void values(int k , Node reatT , LinkedList<Integer> list)
    {
        if(reatT != null)
        {
            k--;
            if(k == 0)
            {
                if(reatT.left != null)
                {
                    list.add((reatT.left).data);
                }
                if(reatT.right != null)
                {
                    list.add((reatT.right).data);
                }
            }
            else
            {
                values(k,reatT.left,list);
                values(k,reatT.right,list);
            }
        }
    }
    
    public static Node getTarget(Node root, Node target ,int dis)
    {
        if(root == null)
            return null;
        else if(root == target)
        {
            dist.data = dis;
            return root;
        }
        else
        {
            dis++;
            Node left = getTarget(root.left,target,dis);
            Node right = getTarget(root.right,target,dis);
            if(left != null)
                return left;
            else if(right != null)
                return right;
        }
    }
}
