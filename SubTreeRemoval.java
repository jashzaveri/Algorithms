import java.util.*;
import java.lang.*;

class Node
{
    int data;
    Node left;
    Node right;
    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
class SubTreeRemoval
{
    static Scanner s = new Scanner(System.in);
    public static void main(String args[])
    {
        int t= s.nextInt();
        while(t != 0)
        {
            t--;
            int n = s.nextInt();
            int x = s.nextInt();
            Node[] arr = new Node[n];
            for(int i = 0; i < n; i++)
            {
                arr[i] = new Node(s.nextInt());
            }
            for(int i = 0; i < n-1; i++)
            {
                int u = s.nextInt();
                int v = s.nextInt();
                
            }
        }
    }
}
