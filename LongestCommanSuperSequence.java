/*package whatever //do not write package name here */
// https://practice.geeksforgeeks.org/problems/shortest-common-supersequence/0
import java.util.*;
import java.lang.*;
import java.io.*;

class LongestCommanSuperSequence {
    public static void main (String[] args) {
        //code
        Scanner s = new Scanner(System.in);
        String test = s.nextLine();
        int t = Integer.parseInt(test);
        while( t != 0)
        {
            t--;
            String[] ts = s.nextLine().split(" ");
            String a = ts[0];
            String b = ts[1];
            int al = a.length();
            int bl = b.length();
            // first we wil find the longest comman subsequence then get the ans by using the length of both the strings
            int[][] mat = new int[al+1][bl+1];
            for(int i = 1; i<= al; i++)
            {
                for(int j = 1; j <= bl; j++)
                {
                    if(a.charAt(i-1) == b.charAt(j-1))
                    {
                        mat[i][j] = 1 + mat[i-1][j-1];
                    }
                    else
                    {
                        mat[i][j] = Math.max(mat[i-1][j],mat[i][j-1]);
                    }
                }
            }
            int sub = mat[al][bl];
            sub += (al-sub) + (bl-sub);
            System.out.println(sub);
        }
    }
}
