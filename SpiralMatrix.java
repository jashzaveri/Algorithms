// https://practice.geeksforgeeks.org/problems/spirally-traversing-a-matrix/0

import java.util.*;
import java.lang.*;
import java.io.*;

class SpiralMatrix {
    static Scanner s = new Scanner(System.in);
    public static void main (String[] args) {
        //code
        String t= s.nextLine();
        int no = Integer.parseInt(t);
        for(int z = 0; z < no; z++)
        {
            String[] cross = s.nextLine().split(" ");
            int n = Integer.parseInt(cross[0]);
            int m = Integer.parseInt(cross[1]);
            String[][] matrix = new String[n][m];
            String[] getVal = s.nextLine().split(" ");
            int k = 0;
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < m;j++)
                {
                    matrix[i][j] = getVal[k++];
                }
            }
            ans(matrix,n,m);
            System.out.println(" ");
        }
    }
    public static void ans(String[][] matrix , int n ,int m)
    {
        int i = 0;
        int j = 0;
        int rs= 0;
        int re = n;
        int cs = 0;
        int ce = m;
        while(rs < re && cs < ce)
        {
            for(i = cs; i< ce; i++)
            {
                System.out.print(matrix[rs][i] + " ");
            }
            rs++;
            
            for( j = rs; j <re; j++)
            {
                System.out.print(matrix[j][ce-1] + " ");
            }
            ce--;
            if(re > rs)
            {
                for(int k = ce - 1; k >=cs; k--)
                {
                    System.out.print(matrix[re-1][k] + " ");
                }
            }
            re--;
            if(ce > cs)
            {
                for(int l = re -1 ; l >= rs;l--)
                {
                    System.out.print(matrix[l][cs] + " ");
                }
            }
            cs++;
        }
    }
}
