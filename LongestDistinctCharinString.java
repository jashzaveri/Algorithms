
import java.util.*;
import java.lang.*;
import java.io.*;
// https://practice.geeksforgeeks.org/problems/longest-distinct-characters-in-string/0
//comleted
class LongestDistinctCharinString {
    public static void main (String[] args) {
        //code
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        String[] grp = new String[n];
        for(int i = 0; i < n; i++)
        {
            grp[i] = s.nextLine();
        }
        int j = 0;
        while(j < n)
        {
            LinkedList<String> list = new LinkedList<String>();
            String get = grp[j];
            j++;
            int max = 0;
            for(int k = 0; k < get.length(); k++)
            {
                String check = get.substring(k,k+1);
                if(!list.contains(check))
                {
                    list.addLast(check);
                }
                else
                {
                    int size = list.size();
                    if(max < size)
                    {
                        max = size;
                    }
                    while(true)
                    {
                        String checks = list.removeFirst();
                        if(checks.equals(check))
                        {
                            list.addLast(check);
                            break;
                        }
                    }
                }
            }
            if(list.size()>max)
            {
                max = list.size();
            }
            System.out.println(max);
        }
    }
}
