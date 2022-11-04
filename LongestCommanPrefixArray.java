/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class LongestCommanPrefixArray {
    public static void main (String[] args) {
        //code
        Scanner s = new Scanner(System.in);
        int t = Integer.parseInt(s.nextLine());
        while( t > 0)
        {
            t--;
            int n = Integer.parseInt(s.nextLine());
            String[] sS = s.nextLine().split(" ");
            if(n == 1)
            {
                System.out.println(sS[0]);
            }
            else
            {
                String ans = new String() ;
                int i = 0;
                while(n > 0)
                {
                    String sub = new String();
                    if(sS[0].length() <= i)
                    {
                        System.out.println("prob");
                        break;
                    }
                    else
                    {
                        sub = sS[0].substring(i,i+1);
                    }
                    for(int j = 1; j < n; j++)
                    {
                        if(i >= sS[j].length())
                        {
                            System.out.println("prob1");
                            n = 0;
                            break;
                        }
                        else if(!sub.equals(sS[j].substring(i,i+1)))
                        {
                            System.out.println("prob2");
                            n = 0;
                            break;
                        }
                    }
                    if(n != 0)
                    {
                        System.out.println("here");
                        ans = ans + sub;
                    }
                    i++;
                }
                if(ans.length() != 0)
                {
                    System.out.println(ans);
                }
                else
                {
                    System.out.println("-1");
                }
            }
        }
    }
}
