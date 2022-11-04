// https://practice.geeksforgeeks.org/problems/node-at-distance/1
// very good question
import java.util.*;
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
class KDistanceFromLeaf
{
    static Node root;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node root = null;
            for(int i = 0; i < n; i++)
            {
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                char lr = sc.next().charAt(0);
                if(root == null)
                {
                    root=new Node(n1);
                    switch(lr){
                        case 'L': root.left=new Node(n2);
                            break;
                        case 'R': root.right=new Node(n2);
                            break;
                    }
                }
                else
                {
                    insert(root, n1,n2, lr);
                }
                
            }
            
            GfG gfg = new GfG();
            int k = sc.nextInt();
            System.out.println(gfg.printKDistantfromLeaf(root, k));
            
        }
    }
    
    public static void insert(Node root, int n1, int n2, char ch)
    {
        if(root==null)
            return;
        if(root.data == n1)
        {
            switch(ch)
            {
                case 'L': root.left = new Node(n2);
                    break;
                case 'R': root.right=new Node(n2);
                    break;
            }
        }
        else
        {
            insert(root.left,n1,n2,ch);
            insert(root.right,n1,n2,ch);
        }
    }
}



/*Please note that it's Function problem i.e.
 you need to write your solution in the form of Function(s) only.
 Driver Code to call/invoke your function is mentioned above.*/

//User function Template for Java
class GfG
{
    /*
     static LinkedList<Integer> list = new LinkedList<Integer>();
     public static int printKDistantfromLeaf(Node node, int k)
     {
     // your code here
     printNode(node,k);
     return list.size();
     }
     public static int printNode(Node node , int k)
     {
     if(node.left == null && node.right == null)
     {
     return 1;
     }
     if(node == null)
     {
     return 0;
     }
     int lnode = printNode(node.left,k);
     if(lnode != 0)
     {
     if(lnode == k)
     {
     if(!list.contains(node.data))
     {
     list.add(node.data);
     }
     }
     return lnode + 1;
     }
     int rnode = printNode(node.right,k);
     if(lnode != 0)
     {
     if(rnode == k)
     {
     if(!list.contains(node.data))
     {
     list.add(node.data);
     }
     }
     return rnode + 1;
     }
     return 0;
     
     }*/
    static   LinkedList<Integer> list = new LinkedList<Integer>();
    public static int printKDistantfromLeaf(Node node, int k)
    {
        list.clear();
        int[] path = new int[1000];
        boolean[] visited = new boolean[1000];
        printKDistantfromLeaf(node,path,visited,0,k);
        return list.size();
    }
    
    public static void printKDistantfromLeaf(Node node, int[] path, boolean[] visited, int pathlen, int k)
    {
        if(node == null)
        {
            return;
        }
        
        path[pathlen] = node.data;
        visited[pathlen] = false;
        pathlen++;
        
        if(node.left == null && node.right == null && pathlen - k -1 >=0 && visited[pathlen-k-1] == false)
        {
            list.add(node.data);
            visited[pathlen - k -1] = true;
        }
        printKDistantfromLeaf(node.left,path,visited,pathlen,k);
        printKDistantfromLeaf(node.right,path,visited,pathlen,k);
        
    }
    
    
}
