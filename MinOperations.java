//https://practice.geeksforgeeks.org/problems/find-optimum-operation/0
// completed
import java.util.*;
import java.lang.*;
import java.io.*;

class MinOperations {
    static Scanner s = new Scanner(System.in);
    public static void main (String[] args) {
        //code
        String t = s.nextLine();
        int no = Integer.parseInt(t);
        for(int i = 0; i < no; i++)
        {
            String val = s.nextLine();
            int vals = Integer.parseInt(val);
            int ans = value(vals);
            System.out.println(ans);
        }
        
    }
    static int value(int vals)
    {
        if(vals == 0)
            return 0;
        if(vals == 1)
            return 1;
        int[] seq = new int[vals+1];
        seq[0] = 0;
        seq[1] = 1;
        for(int i = 2; i < vals+1; i++)
        {
            if(i%2 == 0)
            {
                seq[i] = seq[i/2] + 1;
            }
            else
            {
                seq[i] = seq[i-1] + 1;
            }
        }
        return seq[vals];
    }
}
