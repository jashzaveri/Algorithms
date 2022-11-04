//  https://practice.geeksforgeeks.org/problems/minimal-moves-to-form-a-string/0


import java.util.*;
import java.lang.*;
import java.io.*;

class MinMovestoFormaString {
    static Scanner s = new Scanner(System.in);
    public static void main (String[] args) {
        //code
        int t = Integer.parseInt(s.nextLine());
        while(t != 0)
        {
            t--;
            String main = s.nextLine();
            System.out.println(ans(main));
        }
    }
    
    static int ans(String main)
    {
        int size = main.length();
        int[] arr = new int[size];
        arr[0] = 1;
        for(int i = 1; i < size; i++)
        {
            if(i%2 == 0)
            {
                int c = i/2;
                arr[i] = arr[i-1] + 1;
            }
            else
            {
                int c = i/2;
                String c1 = main.substring(0,c+1);
                String c2 = main.substring(c+1,i+1);
                if(c1.equals(c2))
                {
                    arr[i] = arr[c] + 1;
                }
                else
                {
                    arr[i] = arr[i-1] + 1;
                }
            }
        }
        return arr[size-1];
    }
}
