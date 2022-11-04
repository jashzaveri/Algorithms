
//compleeted
// https://www.codechef.com/JULY19B/problems/CHFM

import java.util.*;
import java.lang.*;
import java.io.*;
class ChefNMean
{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t > 0)
        {
            t--;
            int n = Integer.parseInt(br.readLine());
            String[] get = br.readLine().split(" ");
            long[] mat = new long[n];
            long sum = 0L;
            for(int i = 0; i < n; i++)
            {
                mat[i] = Long.parseLong(get[i]);
                sum += mat[i];
            }
            long mean = 0L;
            if(sum%Long.valueOf(n) == 0)
            {
                 mean = sum/Long.valueOf(n);
            }
            else
            {
                System.out.println("Impossible");
                continue;
            }
            boolean ans = false;
            for(int i= 0 ; i< n; i++)
            {
                if(mat[i] == mean)
                {
                    System.out.println(i+1);
                    ans = true;
                    break;
                }
            }
            if(!ans)
            {
                System.out.println("Impossible");
            }
        }
    }
}
