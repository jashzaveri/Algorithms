/*package whatever //do not write package name here */
// https://practice.geeksforgeeks.org/problems/trapping-rain-water/0
import java.util.*;
import java.lang.*;
import java.io.*;

class TraapedRainWater {
    static int trapped = 0;
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
            boolean[] check = new boolean[n];
            int ind = findMax(arr,0,n);
            int indL = findMax(arr,0,ind);
            int indR = findMax(arr,ind+1,n);
            geTrap(ind,indL,indR,check,n,arr);
        }
    }
    
    static int findMax(int[] arr,int s, int n)
    {
        int max = 0;
        for(int i = s; i < n; i++)
        {
            if(max < arr[i])
            {
                max = arr[i];
                ind = i;
            }
        }
        return ind;
    }
    
    static void geTrap(int ind,int indL, int indR, boolean[] check, int n, int[] arr)
    {
        if(!check[ind])
        {
            check[ind] = true;
            if(!check[indL] && !check[indL+1])
            {
                for(int i = indL; i < ind;i++)
                {
                    if(!check[i])
                    {
                        check[i] = true;
                        trapped += arr[i] - arr[indL];
                    }
                }
            }
            if(!check[ind +1] && !check[ind+2])
            {
                for(int i = ind+ 1; i <= indR;i++)
                {
                    if(!check[i])
                    {
                        check[i] = true;
                        trapped += arr[i] - arr[indR];
                    }
                }
            }
            int aL =
        }
    }
}
