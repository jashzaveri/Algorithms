
import java.util.*;
import java.lang.*;
import java.io.*;

class LongestCommanSubString {
    static Scanner s = new Scanner(System.in);
    public static void main (String[] args) {
    //code
    int t = Integer.parseInt(s.nextLine());
    while(t != 0)
    {
        t--;
        String[] mn = s.nextLine().split(" ");
        int m = Integer.parseInt(mn[0]);
        int n = Integer.parseInt(mn[1]);
        String M = s.nextLine();
        String N = s.nextLine();
        System.out.println(ans(M ,N, m , n));
    }
}

public static int ans(String M, String N, int m , int n)
{
    int[][] mat = new int[m+1][n+1];
    int max = 0;
    for(int i = 1; i <= m ; i++)
    {
        for(int j = 1; j <= n; j++)
        {
            if(M.charAt(i-1) == N.charAt(j-1))
            {
                mat[i][j] = mat[i-1][j-1]+1;
                if(max < mat[i][j])
                {
                    max = mat[i][j];
                }
            }
        }
    }
    return max;
    }
}
