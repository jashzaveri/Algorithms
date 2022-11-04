/*package whatever //do not write package name here */
//completed

// https://practice.geeksforgeeks.org/problems/minimum-cost-to-make-two-strings-identical/0

import java.util.*;
import java.lang.*;
import java.io.*;

class MinCostTwoStrIdentical {
    public static void main (String[] args) {
        //code
        Scanner s = new Scanner(System.in);
        int t = Integer.parseInt(s.nextLine());
        while(t > 0)
        {
            t--;
            String[] cost = s.nextLine().split(" ");
            int costX = Integer.parseInt(cost[0]);
            int costY = Integer.parseInt(cost[1]);
            String[] getS = s.nextLine().split(" ");
            String a = getS[0];
            String b = getS[1];
            int[][] mat = new int[a.length()+1][b.length()+1];
            for(int i = 1; i <= a.length();i++)
            {
                mat[i][0] = mat[i-1][0] + costX;
            }
            for(int i = 1; i <= b.length(); i++)
            {
                mat[0][i] = mat[0][i-1] + costY;
            }
            for(int i = 1; i <= a.length();i++)
            {
                for(int j = 1; j <= b.length(); j++)
                {
                    if(a.substring(i-1,i).equals(b.substring(j-1,j)))
                    {
                        mat[i][j] = mat[i-1][j-1];
                    }
                    else
                    {
                        mat[i][j] = Math.min(Math.min(mat[i-1][j-1] + costX+costY,mat[i-1][j]+costX),mat[i][j-1]+costY);
                    }
                }
            }
            System.out.println(mat[a.length()][b.length()]);
        }
    }
}
