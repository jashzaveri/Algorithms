/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class CountStrings {
    static Scanner s = new Scanner (System.in);
    public static void main (String[] args) {
        //code
        int t= s.nextInt();
        while(t!=0)
        {
            t--;
            int count = 0;
            int m = s.nextInt();
           // long[] arr = new long[m+1];
           // arr[0] = 1;
            //arr[1] = 1;
            int[][] mat = new int[m+1][m+1];
            for(int i = 0; i <=m;i++)
            {
                mat[i][i] = 1;
            }
            for(int i = 0; i <=m;i++)
            {
                mat[0][i] = 1;
            }
            for(int i = 2 ; i<= m;i++)
            {
                for(int j = 1; j <i;j++)
                {
                    mat[j][i] = mat[j][i-1] + mat[j-1][i-1];
                }
            }
            /*for(int i = 2; i<= m; i++)
            {
                arr[i] = i*arr[i-1];
            }*/
            for(int b = 0; b <=1;b++)
            {
                for(int c = 0; c<=2;c++)
                {
                    int a = m-(b+c);
                    if(a>= 0)
                    {
                    //count += arr[m]/(arr[a]*arr[b]*arr[c]);
                        count += mat[a][m];
                    }
                }
            }
            System.out.println(count);
        }
    }
}
