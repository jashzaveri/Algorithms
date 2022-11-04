// https://practice.geeksforgeeks.org/problems/minimum-distinct-ids/0
// completed
// how to convert a collection into an LinkedList
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class MinimumDistinctIds {
    public static void main (String[] args)throws IOException {
        //code
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t > 0)
        {
            t--;
            int n = Integer.parseInt(br.readLine());
            String[] get = br.readLine().split(" ");
            HashMap<String,Integer> map = new HashMap<String,Integer>();
            for(int i = 0; i < get.length; i++)
            {
                if(!map.containsKey(get[i]))
                {
                    map.put(get[i],1);
                }
                else
                {
                    int a = map.get(get[i]);
                    map.put(get[i],a+1);
                }
            }
            int k = Integer.parseInt(br.readLine());
            Collection<Integer> coll = map.values();
            LinkedList<Integer> lis = new LinkedList<Integer>();
            lis.addAll(coll);
            Collections.sort(lis, new Comparator<Integer>(){
                @Override
                public int compare(Integer a,Integer b)
                {
                    return (int)(a-b);
                }
            });
            int j = 0;
            for(Integer i : lis)
            {
                if(k >= i)
                {
                    k -= i;
                }
                else
                {
                    j++;
                }
            }
            System.out.println(j);
        }
    }
}
