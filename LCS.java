import java.util.*;
import java.lang.*;
import java.io.*;
import java.lang.Math.*;

class LCS {
    static Scanner s = new Scanner(System.in);
    public static void main (String[] args) {
        //code
        String tt = s.nextLine();
        int t = Integer.parseInt(tt);
        for(int i = 0 ; i < t; i++)
        {
            String[] ss = s.nextLine().split(" ");
            int sSize = Integer.parseInt(ss[0]);
            int tSize = Integer.parseInt(ss[1]);
            String S = s.nextLine();
            String T = s.nextLine();
            System.out.println(len(S,T,sSize,tSize));
        }
    }
    static int len(String S ,String T ,int sSize , int tSize)
    {
        int[][] mat = new int[sSize+1][tSize+1];
        for(int i = 1; i<sSize + 1; i++)
        {
            for(int j = 1; j < tSize +1; j++)
            {
                if(S.charAt(i-1) == T.charAt(j-1))
                {
                    mat[i][j] = 1 + mat[i-1][j-1];
                }
                else
                {
                    mat[i][j] = Math.max(mat[i-1][j],mat[i][j-1]);
                }
            }
        }
        return mat[sSize][tSize];
    }
}
