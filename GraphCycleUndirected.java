import java.io.*;
import java.util.*;
class GraphCycleUndirected{
    @SuppressWarnings("unchecked")
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-- > 0){
            int v = in.nextInt();
            int e = in.nextInt();
            LinkedList<Integer>[] alist = new LinkedList[v];
            for(int i=0;i<v;i++)
                alist[i] = new LinkedList<Integer>();
            while(e-->0) {    int n1 = in.nextInt();
                int n2 = in.nextInt();
                alist[n1].add(n2);
                alist[n2].add(n1);
            }
            GfG g = new GfG();
            if(g.isCyclic(v,alist)) {
                System.out.println(1);
            }
            else
                System.out.println(0);
        }
    }
}
/*Please note that it's Function problem i.e.
 you need to write your solution in the form of Function(s) only.
 Driver Code to call/invoke your function is mentioned above.*/

/*Complete the function below*/
class GfG
{
    Boolean isCyclic(int V,LinkedList<Integer>[] alist)
    {
        //add code here.
        System.out.println(alist);
        int check = 0;
       // Arrays.fill(visited,false);
        boolean visit[] = new boolean[V];
        for(int i = 0; i < V; i++)
        {
            System.out.println(i);
            if(is(i,-1,alist,visit))
            {
                return true;
            }
        }
        return false;
    }
    
    boolean is(int i,int parent,LinkedList<Integer>[] alist , boolean[] visited)
    {
        System.out.println("m here" + Integer.toString(i) + Integer.toString(parent));
        String abc = Arrays.toString(visited);
        System.out.println(abc + " hi");
        if(i != parent && visited[i] == true)
        {
            return true;
        }
        visited[i] = true;
        Iterator<Integer> a = alist[i].listIterator();
        while(a.hasNext())
        {
            int val = (Integer)a.next();
            if(val != parent)
            {
                System.out.println(parent);
                if(is(val,i,alist,visited))
                {
                    return true;
                }
            }
        }
        return false;
    }
}
