//Initial Template for Java
import java.util.*;
import java.io.*;
import java.lang.*;
class DetectCycleUndirected
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int nov = sc.nextInt();
            int edg = sc.nextInt();
            
            for(int i = 0; i < nov+1; i++)
                list.add(i, new ArrayList<Integer>());
            
            for(int i = 1; i <= edg; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            if(new DetectCycle().isCyclic(list, nov) == true)
                System.out.println("1");
            else System.out.println("0");
        }
    }
}

/*This is a function problem.You only need to complete the function given below*/
//User function Template for Java
/*
 ArrayList<ArrayList<Integer>> list: represent graph containing 'V' number of
 vertices and edges between them
 V: represent number of vertices
 */
class DetectCycle
{
    static boolean isCyclic(ArrayList<ArrayList<Integer>> list, int V)
    {
        // add your code here
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int j = 0;
        for(ArrayList<Integer> at : list)
        {
            map.put(j,1);
            System.out.print(j);
            if(cycle(map,at,-1,j,list))
            {
                return true;
            }
            map.remove(j);
            j++;
        }
        return false;
    }
    static boolean cycle(HashMap<Integer,Integer> map, ArrayList<Integer> at , int j,int from ,ArrayList<ArrayList<Integer>> list)
    {
        int ans = 0;
        for(Integer i : at)
        {
            if(i != j)
            {
                System.out.print(i);
                if(!map.containsKey(i))
                {
                    System.out.print(" " + Integer.toString(i));
                    map.put(i,1);
                    if(cycle(map,list.get(i),from,i,list))
                    {
                        return true;
                    }
                    map.remove(i);
                }
                else
                {
                    return true;
                }
            }
            else if(i == j && ans == 0)
            {
                ans++;
            }
            else
            {
                return true;
            }
        }
        return false;
    }
}
