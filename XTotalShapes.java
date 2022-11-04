/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class XTotalShapes {
    static Scanner s = new Scanner(System.in);
    int count = 0;
    public static void main (String[] args) {
        int t = s.nextInt();
        while(t!=0)
        {
            t--;
            int m = s.nextInt();
            int n = s.nextInt();
            int[][] mat = new int[m][n];
            s.nextLine();
            String[] set = s.nextLine().split(" ");
            int count = 0;
            for(int j = 0; j < m ; j++)
            {
                String here = set[j];
                // System.out.println(here);
                for(int i = 0; i < n; i++)
                {
                    if(here.charAt(i) == 'O')
                    {
                        mat[j][i] = 0;
                    }
                    else
                    {
                        mat[j][i] = 1;
                    }
                }
            }
            for(int i =0; i < m ; i++)
            {
                for(int j = 0; j < n; j++)
                {
                    if(mat[i][j] == 1)
                    {
                        count++;
                        check(i,j,m,n,mat);
                    }
                }
            }
            System.out.println(count);
        }
        //code
    }
    static void check(int i , int j ,int m , int n , int[][] mat)
    {
        if(i < 0|| j < 0 || i >= m || j >=n)
        {
            return;
        }
        else if(mat[i][j] == 0 )
        {
            return;
        }
        else
        {
            mat[i][j] = 0;
            check(i,j-1,m,n,mat);
            check(i,j+1,m,n,mat);
            check(i-1,j,m,n,mat);
            check(i+1,j,m,n,mat);
        }
    }
}
