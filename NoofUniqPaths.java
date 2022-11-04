// completed
//https://www.geeksforgeeks.org/count-possible-paths-top-left-bottom-right-nxm-matrix/

import java.util.*;
import java.lang.*;
import java.io.*;

class NoofUniqPaths {
    static Scanner s = new Scanner(System.in);
    public static void main (String[] args) {
        //code
        //s.nextLine();
        String t = s.nextLine();
        int no = Integer.parseInt(t);
        System.out.println(t);

        for(int i = 0; i < no; i++)
        {
            String[] ab = s.nextLine().split(" ");
            int m = Integer.parseInt(ab[0]);
            int n = Integer.parseInt(ab[1]);
            int ans = value(m,n);
            System.out.println(ans);
        }
    }
    static int value(int m , int n)
    {
        int table[][] = new int[m][n];
        for(int i = 0 ; i < m; i++)
        {
            table[i][0] = 1;
        }
        for(int j = 0; j < n ; j++)
        {
            table[0][j] = 1;
        }
        
        for(int k = 1; k < m; k++)
        {
            for(int l = 1; l < n; l++)
            {
                table[k][l] = table[k-1][l] + table[k][l-1];
            }
        }
        return table[m-1][n-1];
    }
    
}
