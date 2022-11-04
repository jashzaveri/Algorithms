import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class TopView {
    public static int[][] values = new int[500][2];
    public static void initialize(int[][] initialize)
    {
    	for(int j = 0; j < 500; j++)
    	{
    		values[j][1] = 1000;	
    	}
    }
    //Arrays.fill(values, -1) ;
	public static void topView(Node root) 
    {
    	initialize(values);
      if(root != null)
      {
            int dist = 249;
            int level = 0;
            if(values[dist][1] >= level)
            {
                 values[dist][0] = root.data;
                 values[dist][1] = level;
            }
            top(root.left,dist-1,level+1);
            top(root.right,dist+1,level+1);
      }
        print(values);
    }
    public static void top(Node root , int dist , int level)
    {
        if(root != null)
        {
            if(values[dist][1] >= level )
            {
                values[dist][0] = root.data;
                values[dist][1] = level;
            }
            top(root.left,dist-1,level+1);
            top(root.right,dist+1,level+1);
        }
    }
public static void print(int[][] values)
{
    for(int i = 0; i < 500; i++)
    {
        if(values[i][0] > 0)
        {
            System.out.print(Integer.toString(values[i][0]) + " ");
        }
    }
}
	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        topView(root);
    }	
}