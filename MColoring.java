
import java.util.*;
import java.lang.*;
import java.io.*;

class MColoring {
    static boolean che = false;
    public static void main (String[] args) {
        //code
        Scanner s = new Scanner(System.in);
        int t= Integer.parseInt(s.nextLine());
        while( t > 0)
        {
            t--;
            che = false;
            int n = Integer.parseInt(s.nextLine());  // no of vertices
            int c = Integer.parseInt(s.nextLine());  // no of colors
            int e = Integer.parseInt(s.nextLine());  // no of edges
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
            int[] arr = new int[n];  // this ill contain the color of the vertices
            // Arrays.fill(arr,-1);
            getAns(mat,arr,n,c,0);   // the 0 represent the current index of the color
            if(!che)
            {
                System.out.print("0");
            }
            System.out.println();
        }
    }
    
    public static void getAns(int[][] mat, int[] arr, int n, int c, int z)
    {
        if(z >= n)
        {
            System.out.print("1");
            che = true;
            return;
        }
        for(int i = 1; i <= c; i++)
        {
            if(che)
            {
                return;
            }
            arr[z] = i;
            if(check(mat,arr,z))
            {
                getAns(mat,arr,n,c,z+1);
            }
            arr[z] = 0;
        }
    }
    
    public static boolean check(int[][] mat , int[] arr, int z)
    {
        for(int i = 0; i < mat[z].length ; i++)
        {
            if(mat[z][i] == 1)
            {
                if(arr[i] == arr[z])
                {
                    return false;
                }
            }
        }
        return true;
    }
}
