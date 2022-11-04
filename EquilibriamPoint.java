/*package whatever //do not write package name here */
// not completed getting error of tle

// https://www.geeksforgeeks.org/how-to-get-rid-of-java-tle-problem/
import java.util.*;
import java.lang.*;
import java.io.*;

/*class GFG {
    public static void main (String[] args) {
        //code
        Scanner s = new Scanner(System.in);
        String test = s.nextLine();
        int t= Integer.parseInt(test);
        while(t != 0)
        {
            t--;
            String no = s.nextLine();
            int n = Integer.parseInt(no);
            String[] getS = s.nextLine().split(" ");
            int[] arr = new int[n];
            if(n == 1)
            {
                System.out.println(n);
            }
            else
            {
                int mid = n/2;
                int sumL = 0;
                int sumR = 0;
                for(int i = 0; i < n; i++)
                {
                    arr[i] = Integer.parseInt(getS[i]);
                    if(i < mid)
                    {
                        sumL+=arr[i];
                    }
                    if(i > mid)
                    {
                        sumR += arr[i];
                    }
                }
                boolean[] check = new boolean[n];
                int ans = getCheck(arr,check,mid,sumL,sumR);
                if(ans == -1)
                {
                    System.out.println(-1);
                }
                else
                {
                    System.out.println(ans+1);
                }
            }
        }
    }
    public static int getCheck(int[] arr , boolean[] check, int mid,int sumL, int sumR)
    {
        if(check[mid] || mid == 0 || mid == arr.length)
        {
            return -1;
        }
        else
        {
            check[mid] = true;
            if(sumL == sumR)
            {
                return mid;
            }
            else if(sumL > sumR)
            {
                return getCheck(arr,check,mid-1,sumL-arr[mid-1],sumR+arr[mid]);
            }
            else if(sumL < sumR)
            {
                return getCheck(arr,check,mid+1,sumL+arr[mid],sumR-arr[mid+1]);
            }
        }
        return -1;
    }
}*/

// there is another ethod as well which is better the this one

class GFG {
    public static void main (String[] args) {
        //code
        Scanner s = new Scanner(System.in);
        String test = s.nextLine();
        int t= Integer.parseInt(test);
        while(t > 0)
        {
            t--;
            String no = s.nextLine();
            int n = Integer.parseInt(no);
            String[] getS = s.nextLine().split(" ");
            int[] arr = new int[n];
            if(n == 1)
            {
                System.out.println(1);
            }
            else
            {
                int sumL = 0;
                int sumR = 0;
                int sum = 0;
                for(int i = 0; i < n; i++)
                {
                    arr[i] = Integer.parseInt(getS[i]);
                    sum += arr[i];
                }
                int index = -1;
                for(int i = 0; i < n; i++)
                {
                    sumR = sum - sumL - arr[i];
                    if(sumL == sumR)
                    {
                        System.out.println(i+1);
                        index = i+1;
                        n = i;
                    }
                    sumL += arr[i];
                }
                if(index == -1)
                {
                    System.out.println(-1);
                }
            }
        }
    }
}
