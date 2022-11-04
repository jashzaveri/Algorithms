/*package whatever //do not write package name here */

// https://practice.geeksforgeeks.org/problems/count-palindrome-sub-strings-of-a-string/0
// completed
import java.util.*;
import java.lang.*;
import java.io.*;

class CountPalindroneinString {
    public static void main (String[] args)throws IOException {
        //code
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t > 0)
        {
            t--;
            int n = Integer.parseInt(br.readLine());
            System.out.println(n);
            String get = br.readLine();
            boolean[][] mat = new boolean[n][n];
            for(int i= 0; i < n; i++)
            {
                mat[i][i] = true;
            }
            int max = 0;
            for(int k = 2; k <= n; k++)
            {
                for(int i = 0; i <= n-k; i++)
                {
                    int j = i+k-1;
                    System.out.print(j);
                    if(k == 2 && get.substring(i,i+1).equals(get.substring(j,j+1)))
                    {
                        System.out.print("1");
                        mat[i][j] = true;
                        max+=1;
                    }
                    if(mat[i+1][j-1] && get.substring(i,i+1).equals(get.substring(j,j+1)))
                    {
                        System.out.print("2");
                        mat[i][j] = true;
                        max+=1;
                    }
                }
            }
            System.out.println(max);
        }
    }
}
