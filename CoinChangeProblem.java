// https://www.hackerrank.com/challenges/coin-change/problem

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class CoinChangeProblem
 {
    static Scanner s = new Scanner(System.in);
    public static void main (String[] args) {
        //code
        String t = s.nextLine();
        for(int i = 0; i < Integer.parseInt(t); i++)
        {
            String m = s.nextLine();
            int M = Integer.parseInt(m);
            String[] S = s.nextLine().split(" ");
            int[] Ss = new int[M];
            for(int j = 0 ; j < M; j++)
            {
                Ss[j] = Integer.parseInt(S[j]);
            }
            String n = s.nextLine();
            int N = Integer.parseInt(n);
            System.out.println(count(Ss,M,N));
        }
    }
    
    static int count(int[] S , int m , int n)
    {
        int[] table = new int[n+1];
        Arrays.fill(table,0);
        table[0] = 1;
        for(int i = 0; i < m; i++)
        {
            for(int j = S[i] ; j <= n; j++)
            {
                table[j] += table[j - S[i]];
            }
        }
        return table[n];
    }
}
