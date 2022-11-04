
// https://practice.geeksforgeeks.org/problems/count-of-subarrays/0

import java.util.*;
import java.lang.*;
import java.io.*;

class CountOfSubarrays {
    static Scanner s = new Scanner (System.in);
    public static void main (String[] args) {
        //code
        int t= s.nextInt();
        while(t!=0)
        {
            t--;
            int m = s.nextInt();
            int k = s.nextInt();
            int count = 0;
            int[] arr = new int[m];
            for(int i = 0; i < m; i++)
            {
                arr[i] = s.nextInt();
            }
            int[] val = new int[m];
            for(int i = m-1; i >=0;i--)
            {
                if(arr[i] > k)
                {
                    val[i] = m-i;
                    count+=val[i];
                }
                else
                {
                    if(i<m-1)
                    {
                        val[i] = val[i+1];
                        count += val[i];
                    }
                    else
                    {
                        val[i] = 0;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
