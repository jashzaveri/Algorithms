// completed

// https://www.geeksforgeeks.org/topological-sorting/

import java.util.*;
class TopologicalSort{
    @SuppressWarnings("unchecked")
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        while(T-->0)
        {
            ArrayList<Integer>[] graph;
            int N,E;
            E=sc.nextInt();
            N=sc.nextInt();
            graph = new ArrayList[10001];
            for (int i=0; i<10001; ++i)
                graph[i] = new ArrayList();
            for(int i=0;i<E;i++)
            {
                int u,v;
                u=sc.nextInt();
                v=sc.nextInt();
                graph[u].add(v);
            }
            GfG g=new GfG();
            int res[] = g.topoSort(graph,N);
            boolean valid =true;
            for(int i=0;i<N;i++)
            {
                int n=graph[res[i]].size();
                for(int j=0;j<graph[res[i]].size();j++)
                {
                    for(int k=i+1;k<N;k++)
                    {
                        if(res[k]==graph[res[i]].get(j))
                            n--;
                    }
                }
                if(n!=0)
                {
                    valid =false;
                    break;
                }
            }
            if(valid==false)
                System.out.println("0");
            else
                System.out.println("1");
        }
    }
}


/*Please note that it's Function problem i.e.
 you need to write your solution in the form of Function(s) only.
 Driver Code to call/invoke your function is mentioned above.*/

/*Complete the function below*/
class GfG
{
    public static int[] topoSort(ArrayList<Integer> graph[],int N)
    {
        //add code here.
        boolean[] visited = new boolean[N];
        LinkedList<Integer> stack = new LinkedList<Integer>();
        for(int i = 0; i < N; i++)
        {
            if(!visited[i] )
            {
                check(i,visited,stack,graph);
            }
            if(!stack.contains(i))
                stack.addFirst(i);
        }
        Iterator a = stack.listIterator();
        int[] arr = new int[N];
        int b = 0;
        while(a.hasNext())
        {
            arr[b] = (Integer)a.next();
            System.out.println(arr[b]);
            b++;
        }
        return arr;
    }
    
    static void check(int i, boolean[] visited, LinkedList<Integer> stack ,ArrayList<Integer>[] graph)
    {
        visited[i] = true;
        Iterator itr = graph[i].listIterator();
        while(itr.hasNext())
        {
            int a = (Integer)itr.next();
            if(!visited[a])
            {
                check(a,visited,stack,graph);
            }
            if(!stack.contains(a))
            {
                stack.addFirst(a);
            }
        }
    }
}
