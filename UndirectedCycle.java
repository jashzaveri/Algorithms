
//Code by Saksham Raj Seth
import java.io.*;
import java.util.*;
class UndirectedCycle{
    @SuppressWarnings("unchecked")
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-- > 0){
            int v = in.nextInt();
            int e = in.nextInt();
            LinkedList<Integer>[] alist = new LinkedList[v];
            for(int i=0;i<v;i++) alist[i] = new LinkedList<Integer>();
            while(e-->0) {
                int n1 = in.nextInt();
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
        boolean[] visited = new boolean[V];
        return cycle(visited,0,-1,alist);
    }
    boolean cycle(boolean[] visited , int v , int prev, LinkedList<Integer>[] alist)
    {
        if(visited[v] && !alist[v].contains(prev))
        {
            return true;
        }
        if(!visited[v])
        {
            LinkedList<Integer> list = alist[v];
            visited[v] = true;
            Iterator<Integer> itr = list.iterator();
            while(itr.hasNext())
            {
                int check = itr.next();
                if(check == v)
                {
                    return true;
                }
                boolean ans = cycle(visited,check,v,alist);
                if(ans)
                {
                    return true;
                }
            }
        }
        return false;
    }
    
}
