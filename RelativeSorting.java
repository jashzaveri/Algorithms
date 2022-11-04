/*package whatever //do not write package name here */
// https://practice.geeksforgeeks.org/problems/relative-sorting/0
import java.util.*;
import java.lang.*;
import java.io.*;

class RelativeSorting
{
    public static void main (String[] args)
    {
        //code
        Scanner s = new Scanner(System.in);
        String test = s.nextLine();
        int t = Integer.parseInt(test);
        while( t > 0)
        {
            t--;
            String[] no = s.nextLine().split(" ");
            int n1 = Integer.parseInt(no[0]);
            int n2 = Integer.parseInt(no[1]);
            String[] get1 = s.nextLine().split(" ");
            int[] arr1 = new int[n1];
            HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
            map.clear();
            for(int i = 0; i < n1; i++)
            {
                arr1[i] = Integer.parseInt(get1[i]);
                if(map.containsKey(arr1[i]))
                {
                    int a = (Integer)map.remove(arr1[i]);
                    a++;
                    map.put(arr1[i],a);
                }
                else
                {
                    map.put(arr1[i],1);
                }
            }
            String[] get2 = s.nextLine().split(" ");
            int[] arr2 = new int[n2];
            for(int i = 0; i < n2; i++)
            {
                arr2[i] = Integer.parseInt(get2[i]);
            }
            int[] mat =  new int[n1];
            int j = 0;
            for(int i = 0; i < n2;i++)
            {
                //int k = 0;
                if(map.containsKey(arr2[i]))
                {
                    int b = (Integer)map.remove(arr2[i]);
                    for(int m = 0; m < b;m++)
                    {
                        mat[j] = arr2[i];
                        j++;
                    }
                }
            }
            Set<Integer> getSet = map.keySet();
            Iterator<Integer> itr = getSet.iterator();
            while(itr.hasNext())
            {
                int c = (Integer)itr.next();
                if(map.containsKey(c))
                {
                    int b = (Integer)map.get(c);
                    for(int m = 0; m < b;m++)
                    {
                        mat[j] = c;
                        j++;
                    }
                }
            }
            for(int i = 0; i < n1; i++)
            {
                System.out.print(Integer.toString(mat[i]) + " ");
            }
        }
    }
}
