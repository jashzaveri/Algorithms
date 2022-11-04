/*package whatever //do not write package name here */
// https://practice.geeksforgeeks.org/problems/longest-increasing-subsequence/0
// completed
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main (String[] args) {
        //code
        Scanner s = new Scanner(System.in);
        String test = s.nextLine();
        int t= Integer.parseInt(test);
        while(t != 0)
        {
            t--;
            String no = s.nextLine();
            int n= Integer.parseInt(no);
            String[] getS = s.nextLine().split(" ");
            int[] arr = new int[n];
            for(int i = 0; i < n; i++)
            {
                arr[i] = Integer.parseInt(getS[i]);
            }
            int[] mat = new int[n];
            mat[0] = 1;
            for(int i = 1 ; i < n ; i++)
            {
                int max = 0;
                for(int k = 0; k < i; k++)
                {
                    if(arr[k] < arr[i] && max < mat[k])
                    {
                        max = mat[k];
                    }
                }
                mat[i] = max + 1;
            }
            int maxi = 0;
            for(int i = 0; i < n; i++)
            {
                if(mat[i] > maxi)
                {
                    maxi = mat[i];
                }
            }
            System.out.println(maxi);
        }
    }
}
