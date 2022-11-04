/*package whatever //do not write package name here */
// https://practice.geeksforgeeks.org/problems/anagram/0/?ref=self


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
            String[] getS = s.nextLine().split(" ");
            String a = getS[0];
            String b = getS[1];
            int al = a.length();
            int bl = b.length();
            HashMap<String,Integer> check = new HashMap<String,Integer>();
            for(int i = 0; i < al; i++)
            {
                String alpha = a.substring(i,i+1);
                if(check.containsKey(alpha))
                {
                    int get = check.get(alpha);
                    get += 1;
                    check.put(alpha,get);
                }
                else
                {
                    check.put(alpha,1);
                }
            }
            
            for(int i = 0 ; i < bl; i++)
            {
                String alpha = b.substring(i,i+1);
                if(check.containsKey(alpha))
                {
                    int get = check.get(alpha);
                    get -= 1;
                    if(get != 0)
                    {
                        check.put(alpha,get);
                    }
                    else
                    {
                        check.remove(alpha);
                    }
                }
                else
                {
                    break;
                }
            }
            
            if(check.isEmpty())
            {
                System.out.println("YES");
            }
            else
            {
                System.out.println("NO");
            }
        }
    }
}
