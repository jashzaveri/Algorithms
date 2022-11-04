/*package whatever //do not write package name here */
//https://practice.geeksforgeeks.org/problems/flood-fill-algorithm/0
import java.util.*;
import java.lang.*;
import java.io.*;

class FloodFill {
    static Scanner s = new Scanner(System.in);
    public static void main (String[] args) {
        //code
        String test = s.nextLine();
        int t = Integer.parseInt(test);
        while(t> 0)
        {
            t--;
            String[] nm = s.nextLine().split(" ");
            int m = Integer.parseInt(nm[0]);
            int n = Integer.parseInt(nm[1]);
            String[] get = s.nextLine().split(" ");
            int[][] mat = new int[m][n];
            for(int i = 0; i < m; i++)
            {
                for(int j = 0; j <n; j++)
                {
                    mat[i][j] = Integer.parseInt(get[i*n + j]);
                    System.out.print(get[i*n+j] + " ");
                }
                System.out.println();
            }
            
            String[] vals = s.nextLine().split(" ");
            int x = Integer.parseInt(vals[0]);
            int y = Integer.parseInt(vals[1]);
            int c = Integer.parseInt(vals[2]);
            getAns(x,y,m,n,c,mat[x][y],mat);
            for(int i = 0; i < m;i++)
            {
                for(int p = 0; p < n; p++)
                {
                    System.out.print(Integer.toString(mat[i][p]) + " ");
                }
            }
            System.out.println();
        }
    }
    public static void getAns(int x , int y ,int m , int n, int c , int cxy , int[][] mat)
    {
        if(x >= 0 && y >= 0 && x < m && y <n)
        {
            if(mat[x][y] == cxy)
            {
                mat[x][y] = c;
                getAns(x-1,y,m,n,c,cxy,mat);   //here there can be a problem if we use the incremenrt operator
                getAns(x,y-1,m,n,c,cxy,mat);
                getAns(x+1,y,m,n,c,cxy,mat);
                getAns(x,y+1,m,n,c,cxy,mat);
            }
        }
    }
}
