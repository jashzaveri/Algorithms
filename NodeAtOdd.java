//https://practice.geeksforgeeks.org/problems/nodes-at-odd-levels/1
//Not Completed
import java.util.*;
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
class NodeAtOdd{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            Node root=null;
            while(n-->0){
                int a=sc.nextInt();
                int a1=sc.nextInt();
                char lr=sc.next().charAt(0);
                if(root==null){
                    root=new Node(a);
                    switch(lr){
                        case 'L':root.left=new Node(a1);
                        break;
                        case 'R':root.right=new Node(a1);
                        break;
                    }
                }
                else{
                    insert(root,a,a1,lr);
                }
            }
            GfG g=new GfG();
            g.nodeAtOdd(root);
            System.out.println();
        }
    }
    public static void insert(Node root,int a,int a1,char lr){
        if(root==null)
            return;
        if(root.data==a){
            switch(lr){
                case 'L':root.left=new Node(a1);
                break;
                case 'R':root.right=new Node(a1);
                break;
            }
        }
        else{
            insert(root.left,a,a1,lr);
            insert(root.right,a,a1,lr);
        }
    }
}



/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

/*Complete the function below
Node is as follows
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}*/
class GfG{
    public int height(Node root)
    {
        if(root != null)
        {
            int a = 1+height(root.left);
            int b = 1 + height(root.right);
            if(a > b)
            {
                return a;
            }
            else
            {
                return b;
            }
        }
        return 0;
    }
    public void nodeAtOdd(Node root)
     {
       //add code here.
       if(root == null)
       {
           return ;
       }
       int hei = height(root);
       for(int i = 1; i <= hei; i++)
       {
       	   if(i%2 != 0)
       	   {
           		printOdd(root,i);
           }
       }
     }
     public void printOdd(Node root,int i)
     {
         if(root != null)
         {
             if(i != 1)
             {
             	System.out.println("yes");
                 printOdd(root.left,i--);
                 printOdd(root.right,i--);
             }
             else 
             {
                 System.out.print(Integer.toString(root.data) + " ");
             }
         }
     }
}
