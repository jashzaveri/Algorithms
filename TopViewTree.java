// https://www.geeksforgeeks.org/print-nodes-top-view-binary-tree/

import java.util.*;
class TreeNode
{
    int key;
    TreeNode left, right;
    public TreeNode(int key)
    {
        this.key = key;
        left = right = null;
    }
}
class TopViewTree
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int tc=sc.nextInt();
        while(tc-->0){
            int n=sc.nextInt();
            TreeNode root = null;
            if(n==0){
                System.out.println();
                continue;
            }
            for(int i=0;i<n;i++){
                int a1=sc.nextInt();
                int a2=sc.nextInt();
                char ch=sc.next().charAt(0);
                if(root==null){
                    root=new TreeNode(a1);
                    switch(ch){
                        case 'L':root.left=new TreeNode(a2);
                            break;
                        case 'R':root.right=new TreeNode(a2);
                            break;
                    }
                }
                else{
                    insert(root,a1,a2,ch);
                }
            }
            GfG g = new GfG();
            g.printTopView(root);
            System.out.println();
        }
    }
    public static void insert(TreeNode root,int a1,int a2,char ch){
        if(root==null)
            return;
        if(root.key==a1){
            switch(ch){
                case 'L':root.left=new TreeNode(a2);
                    break;
                case 'R':root.right=new TreeNode(a2);
                    break;
            }
        }
        else{
            insert(root.left,a1,a2,ch);
            insert(root.right,a1,a2,ch);
        }
    }
}



/*Please note that it's Function problem i.e.
 you need to write your solution in the form of Function(s) only.
 Driver Code to call/invoke your function is mentioned above.*/

/*Complete the function below
 Node is as follows
 class TreeNode
 {
 int key;
 TreeNode left, right;
 public TreeNode(int key)
 {
 this.key = key;
 left = right = null;
 }
 }*/
class GfG
{
    public void printTopView(TreeNode root)
    {
        TreeMap<Integer,TreeNode> map = new TreeMap<Integer,TreeNode>();
        int a = 0;
        map.put(0,root);
        System.out.print(root.key + " ");
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        check(a,map,root);
        
    }
    public void check(int a , TreeMap<Integer,TreeNode> map , Queue<TreeNode> q)
    {
        System.out.print(root.key + " ");
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        q.add(root);
        while(q.size() != 0)
        {
            TreeNode node = q.poll();
            if(node.left != null)
            {
                if(!map.containsKey(a-1))
                {
                    System.out.print(node.left.key + " ");
                    map.put(a-1,node.left);
                }
                queue.add(node.left);
            }
            if(node.right != null)
            {
                if(!map.containsKey(a+1))
                {
                    System.out.print(node.right.key + " ");
                    map.put(a+1,node.right);
                }
                queue.add(node.right);
            }
        }
        check()
    }
    /* public void printTopView(TreeNode root)
     {
     //add code here.
     int height = hei(root);
     System.out.print(root.key + " ");
     for(int i = 1; i <= height ; i++)
     {
     printLs(root.left,i-1);
     printRs(root.right , i-1);
     }
     }
     void printRs(TreeNode root , int a)
     {
     if(root == null || a < 0)
     {
     return;
     }
     if(a == 0)
     {
     System.out.print(root.key + " ");
     }
     printRs(root.right , a-1);
     }
     
     void printLs(TreeNode root , int a)
     {
     if(root == null || a< 0)
     {
     return;
     }
     if(a == 0)
     {
     System.out.print(root.key + " ");
     }
     printLs(root.left , a-1);
     }
     int hei(TreeNode root)
     {
     if(root == null)
     {
     return 0;
     }
     int a = 1 + hei(root.left);
     int b = 1+ hei(root.right);
     if(a < b)
     {
     return b;
     }
     else
     {
     return a;
     }
     }*/
}
