
import java.util.*;
import java.lang.*;
import java.io.*;

class CombinationSum2
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
            String no = s.nextLine();
            int n = Integer.parseInt(no);
            String[] get = s.nextLine().split(" ");
            int[] arr = new int[n];
            for(int i = 0; i < n; i++)
            {
                arr[i] = Integer.parseInt(get[i]);
            }
            String sS = s.nextLine();
            int sum = Integer.parseInt(sS);
            Arrays.sort(arr);
            getCheck(arr,sum);
        }
    }
    public static void getCheck(int[] arr,int sum)
    {
        String s = "(";
        getChecks(arr,sum,0,s);
    }
    public static void getChecks(int[] arr, int sum, int i, String s )
    {
        if(i < arr.length && i >= 0)
        {
            getChecks(arr,sum,i+1,s);
            s = s + " " + Integer.toString(i) ;
            sum = sum - arr[i];
            if(sum == 0)
            {
                s = s + ")";
                System.out.print(s);
            }
            else if(sum > 0)
            {
                getChecks(arr,sum,i+1,s);
            }
            
        }
    }
}
