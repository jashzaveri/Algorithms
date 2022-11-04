// https://www.codechef.com/APRIL19B/problems/FENCE

import java.util.Arrays;
import java.util.Scanner;
import java.util.*;
/*
public class Fencing {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int a=sc.nextInt();
            int b=sc.nextInt();
            int arr[][]=new int[a][b];
            int k=sc.nextInt();
            for(int i=0;i<k;i++)
            {
                int c=sc.nextInt();
                int d=sc.nextInt();
                arr[c-1][d-1]=1;
            }
            int t=0;
            for(int i=0;i<a;i++)
            {
                
                for(int j=0;j<b;j++)
                {
                    if(arr[i][j]==1)
                    {
                        if( j==b-1)
                        {
                            t++;
                            if(arr[i][j-1] == 0)
                            {
                                t++;
                            }
                        }
                        else if(j == 0)
                        {
                            t++;
                            if(arr[i][j+1] == 0)
                            {
                                t++;
                            }
                        }
                        else
                        {
                            if(arr[i][j-1]==0)
                                t++;
                            if(arr[i][j+1]==0)
                                t++;
                        }
                        
                        if(i==0)
                        {
                            t++;
                            if(arr[i+1][j] == 0)
                            {
                                t++;
                            }
                        }
                        else if(i==a-1)
                        {
                            t++;
                            if(arr[i-1][j] == 0)
                            {
                                t++;
                            }
                        }
                        else
                        {
                            if(arr[i-1][j]==0)
                                t++;
                            if(arr[i+1][j]==0)
                                t++;
                        }
                        
                    }
                }
                //System.out.println(t);
                
            }
            System.out.println(t);
        }
    }
}
*/
class object
{
    int p;
    int q;
    object(int p,int q)
    {
        this.p = p;
        this.q = q;
    }
}
public class Fencing
{
    static Scanner s = new Scanner(System.in);
    public static void main(String args[])
    {
        int t = s.nextInt();
        while (t-- > 0)
        {
            int count = 0;
            int m=s.nextInt();
            int n=s.nextInt();
            int k=s.nextInt();
            HashMap<object,Integer> map = new HashMap<object,Integer>();
            for(int i = 0; i < k; i++)
            {
                int a = s.nextInt();
                int b = s.nextInt();
                object obj = new object(a,b);
                map.put(obj,1);
            }
            
            Set<object> key = map.keySet();
            Iterator<object> itr = key.iterator();
            while(itr.hasNext())
            {
                object check = itr.next();
                if(!map.containsKey(new object(check.p+1,check.q) ))
                {
                    count++;
                }
                if(!map.containsKey(new object(check.p-1,check.q) ))
                {
                    count++;
                }
                if(!map.containsKey(new object(check.p,check.q-1) ))
                {
                    count++;
                }
                if(!map.containsKey(new object(check.p,check.q+1) ))
                {
                    count++;
                }
            }
            System.out.println(count);
        }

    }
}


