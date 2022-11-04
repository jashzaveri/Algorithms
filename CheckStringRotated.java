/*package whatever //do not write package name here */
// https://practice.geeksforgeeks.org/problems/check-if-string-is-rotated-by-two-places/0

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main (String[] args) {
        //code
        Scanner s = new Scanner(System.in);
        String trst = s.nextLine();
        int t= Integer.parseInt(trst);
        while(t!= 0)
        {
            t--;
            String a = s.nextLine();
            String b = s.nextLine();
            String antiA1 = a.substring(0,2);
            String antiA2 = a.substring(2,a.length());
            String ca = antiA2 + antiA1;
            boolean check = false;
            if(ca.equals(b))
            {
                System.out.println("1");
                check = true;
            }
            else
            {
                String a1 = a.substring(a.length()-2,a.length());
                String a2 = a.substring(0,a.length()-2);
                String ac = a1+a2;
                if(ac.equals(b))
                {
                    System.out.println("1");
                    check = true;
                }
            }
            if(!check)
            {
                System.out.println("0");
            }
        }
    }
}
