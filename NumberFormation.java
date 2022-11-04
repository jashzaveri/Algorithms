/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class NumberFormation {
    public static void main (String[] args) throws IOException{
        //code
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        long[] fact = new long[300];
        Arrays.fill(fact,-1L);
        fact[0] = 1;
        fact[1] = 1;
        fact[2] = 2;
        long[] tens = new long[301];
        tens[0] = 1L;
        tens[1] = 1L;
        int m = 2;
        
        
        
        
        
        
        
        
        for( m = 2 ; m < 20; m++)
        {
            System.out.print(m);
            tens[m] = (tens[m-1]*10L + 1L);
            System.out.println(tens[m]);
        }
        while(t > 0)
        {
            t--;
            String[] get = br.readLine().split(" ");
            int four = Integer.parseInt(get[0]);
            int five = Integer.parseInt(get[1]);
            int six = Integer.parseInt(get[2]);
            long[][][] mat = new long[four+1][five+1][six+1];
            long ans = 0L;
            for(int i = 0; i <= four;i++)
            {
                for(int j = 0; j <= five; j++)
                {
                    for(int k = 0; k <= six; k++)
                    {
                        long sum = 0L;
                        if(i != 0)
                        {
                            sum += (long)i;
                        }
                        if(j != 0)
                        {
                            sum += (long)j;
                        }
                        if(k != 0)
                        {
                            sum += (long)k;
                        }
                        int tot = i+j+k;
                        long facn = fac(fact,tot-1);
                        long mul = 0L;
                        if(i != 0)
                        {
                            mul = (mul + (facn*4L)/(fac(fact,i-1)*fac(fact,j)*fac(fact,k)))%1000000007L;
                        }
                        if(j != 0)
                        {
                            mul += (facn*5L)/(fac(fact,i)*fac(fact,j-1)*fac(fact,k));
                        }
                        if(k != 0)
                        {
                            mul += (facn*6L)/(fac(fact,i)*fac(fact,j)*fac(fact,k-1));
                        }
                        //System.out.println(tens[tot]);
                        mat[i][j][k] = (mul*tens[tot])%1000000007L;
                        ans = (ans + mat[i][j][k])%1000000007L;
                    }
                }
            }
            System.out.println(ans);
        }
    }
    public static long fac(long[] fact , int n)
    {
        if(n < 0)
        {
            return 1L;
        }
        if(fact[n] != -1L)
        {
            return fact[n];
        }
        else
        {
            fact[n] = (fac(fact,n-1)*n)%1000000007L;
            return fact[n];
        }
    }
}
