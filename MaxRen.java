// https://www.codechef.com/APRIL19B/problems/MAXREM

import java.util.*;

class MaxRen
{
    public static void main(String args[])
    {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i< n; i++)
        {
            arr[i] = s.nextInt();
        }
        Arrays.sort(arr);
        int max = 0;
        int max2 = 0;
        max = arr[0];
        for(int i = 1; i < n; i++)
        {
            if(arr[i] > max)
            {
                max2  = max;
                max = arr[i];
            }
        }
        System.out.println(max2);
    }
}
