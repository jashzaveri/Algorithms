// https://practice.geeksforgeeks.org/problems/subarray-with-given-sum/0

// completed
// time out is the error
import java.util.*;
import java.lang.*;
import java.io.*;

class SubarrayGivenSum {
    static Scanner s = new Scanner(System.in);
    public static void main (String[] args) {
        //code
        int t = Integer.parseInt(s.nextLine());
        //int t = s.nextInt();
        //System.out.print(t);
        while(t>0)
        {
            t--;
            //s.nextLine();
            String[] get = s.nextLine().split(" ");
            int n = Integer.parseInt(get[0]);
            int sum = Integer.parseInt(get[1]);
            //s.nextLine();
            int[] arr = new int[n];
            String[] arrs = s.nextLine().split(" ");
            for(int i = 0 ; i < n; i++)
            {
                arr[i] = Integer.parseInt(arrs[i]);
                
            }
            boolean done = false;
            for(int i = 0; i < n; i++)
            {
                int check = 0;
                for(int j = i; j < n; j++)
                {
                    check += arr[j];
                    if(check > sum)
                    {
                        while( check > sum && i < j)
                        {
                            check -= arr[i];
                            i++;
                        }
                        //System.out.println(i);
                    }
                     if(check == sum)
                    {
                        System.out.print(Integer.toString(i+1) + " " + Integer.toString(j+1));
                        done = true;
                        i = n;
                        j = n;
                    }
                    /*else if(check > sum)
                    {
                        continue;
                    }*/
                }
            }
            if(!done)
            {
                System.out.print("-1");
            }
            System.out.println();
        }
    }
}
