import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
public class PrimMST {
 // Complete the prims function below.
    static int prims(int n, int[][] edges, int start) {
        boolean[] visited = new boolean[n];
        Arrays.fill(visited,false);
        int len = edges[0].length;
        int[] distW = new int[n];
        Arrays.fill(distW,100);
        distW[start - 1] = 0;
        int nodesAdd = 0;
        int cost = 0;
        while(nodesAdd != n)
        {
            int node = 100000;
            int val = 0;
            for(int p = 0; p < n ; p++)
            {
                if((distW[p] < node) && (visited[p] == false))
                {
                    node = distW[p];
                    val = p;
                }
            }
            visited[val] = true;
            System.out.println(Integer.toString(val) + " " + Integer.toString(node) + " done true");
            nodesAdd++;
           
            cost += node;
            for(int i = 0; i < len; i++)
            {
                if(edges[i][0] == (val + 1))
                {
                    int other1 = edges[i][1] - 1;
                    if((visited[other1] == false) && (distW[other1] > edges[i][2]))
                    {
                        distW[other1] = edges[i][2];
                        int b = other1 + 1;
                        System.out.println(Integer.toString(b) + " " + Integer.toString(distW[other1]) + " of 1");
                    }
                }
                if(edges[i][1] == (val + 1))
                {
                    int other2 = edges[i][0] - 1;
                    System.out.println(Integer.toString(other2) + " in 2");
                    if((visited[other2] == false) && (distW[other2] > edges[i][2]))
                    {
                        distW[other2] = edges[i][2];
                        int a = other2 + 1;
                        System.out.println(Integer.toString(a) + " " + Integer.toString(distW[other2]) + " of 2");
                    }
                }
            }
        } 
        return cost;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] edges = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] edgesRowItems = scanner.nextLine().split(" ");

            for (int j = 0; j < 3; j++) {
                int edgesItem = Integer.parseInt(edgesRowItems[j]);
                edges[i][j] = edgesItem;
            }
        }

        int start = scanner.nextInt();

        int result = prims(n, edges, start);

        System.out.println(String.valueOf(result));


        scanner.close();
    }
}

