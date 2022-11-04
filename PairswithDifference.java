/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class PairswithDifference {
    static Scanner s = new Scanner (System.in);
    public static void main (String[] args) {
        //code
        int t= s.nextInt();
        while(t!=0)
        {
            t--;
            int m = s.nextInt();
            int[] arr = new int[m];
            for(int i = 0; i < m; i++)
            {
                arr[i] = s.nextInt();
            }
            int k = s.nextInt();
            Arrays.sort(arr);
            int count = 0;
            for(int i = m-1; i>=0;i--)
            {
                if(i > 0)
                {
                    if(arr[i] - arr[i-1] < k)
                    {
                        count+= arr[i] + arr[i-1];
                        i--;
                    }
                }
            }
            System.out.println(count);
        }
        //code
    }
}
