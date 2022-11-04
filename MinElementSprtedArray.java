/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class MinElementSprtedArray
{
    public static void main (String[] args) throws IOException
    {
        //code
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t > 0)
        {
            t--;
            int n = Integer.parseInt(br.readLine());
                                     String[] get = br.readLine().split(" ");
                                     int[] mat = new int[n];
                                     for(int i = 0; i < n; i++)
                                     {
                                         mat[i] = Integer.parseInt(get[i]);
                                     }
                                     int min = getMin(mat,0,n-1);
                                     System.out.println(min);
                                     }
                                     }
        public static int getMin(int[] mat , int start , int end)
            {
                if(start < end)
                {
                    int mid = (start+end)/2;
                    if(mat[mid] <= mat[mid-1] && mat[mid] <= mat[mid+1])
                    {
                        return mat[mid];
                    }
                    else if(mat[start] > mat[mid])
                    {
                        return getMin(mat,start,mid);
                    }
                    else if(mat[mid] > mat[start])
                    {
                        return getMin(mat,mid+1,end);
                    }
                    else
                    {
                        return 0;
                    }
                }
                return -1;
            }
        }
