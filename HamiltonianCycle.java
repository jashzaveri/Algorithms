/*package whatever //do not write package name here */
// https://practice.geeksforgeeks.org/problems/hamiltonian-path/0

// completed
import java.util.*;
import java.lang.*;
import java.io.*;

class HamiltonianCycle {
    static boolean che = false;
    public static void main (String[] args) {
        //code
        che = false;
        Scanner s = new Scanner(System.in);
        int t= Integer.parseInt(s.nextLine());
        while( t > 0)
        {
            t--;
            String[] vas = s.nextLine().split(" ");
            int n = Integer.parseInt(vas[0]);  // no of vertices
            int e = Integer.parseInt(vas[1]);  // no of edges
            String[] get = s.nextLine().split(" ");
            int[][] mat = new int[n][n];
            int j = 0;
            for(int i = 0 ; i < e; i++)
            {
                int a = Integer.parseInt(get[j]);
                j = j+1;
                int b = Integer.parseInt(get[j]);
                j = j+1;
                mat[a-1][b-1] = 1;
                mat[b-1][a-1] = 1;
            }
            
           /* for(int p = 0; p < n; p++)
            {
                for(int o = 0 ; o < n ; o++)
                {
                    System.out.print(mat[p][o]);
                }
                System.out.println();
            }*/
            boolean[] check = new boolean[n];
            for(int i = 0; i < n; i++)
            {
                Arrays.fill(check,false);
                System.out.println("i");
                if(getCheck(mat,check,n,i))
                {
                    //System.out.println("1");
                    break;
                }
            }
            if(!che)
            {
                System.out.println("0");
            }
            else
            {
                System.out.println("1");
            }
        }
    }
    
    public static boolean getCheck(int[][] mat, boolean[] check, int n , int i)
    {
        // i is my starting index
        boolean val = getAns(check,n);
       // System.out.println(i);
        if(val || che)
        {
          //  System.out.println("1");
            che = true;
            return true;
        }
        if(check[i])
        {
            return false;
        }
        check[i] = true;
        for(int j = 0; j < n; j++)
        {
            if(mat[i][j] == 1 && i != j)
            {
                getCheck(mat,check,n,j);
             //   System.out.println("j");
            }
        }
        check[i] = false;
        return false;
    }
    
    public static boolean getAns(boolean[] check , int n)
    {
        for(int i = 0; i < n; i++)
        {
            if(!check[i])
            {
                return false;
            }
        }
        return true;
    }
}
