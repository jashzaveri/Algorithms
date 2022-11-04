
// paritally done
// https://www.codechef.com/JULY19B/problems/PRTAGN
import java.util.*;
import java.lang.*;
import java.io.*;

class ParityAgain
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t > 0)
        {
            t--;
            ArrayList<Integer> mlist = new ArrayList<Integer>();
            int n = Integer.parseInt(br.readLine());
            int odd = 0;
            int even = 0;
            for(int i = 0; i < n; i++)
            {
                ArrayList<Integer> tlist = new ArrayList<Integer>();
                int val = Integer.parseInt(br.readLine());
                if(!mlist.contains(val))
                {
                    tlist.add(val);
                    int get = checkVal(val);
                    if(get%2 == 0)
                    {
                        even++;
                    }
                    else
                    {
                        odd++;
                    }
                
                    Iterator<Integer> itr = mlist.iterator();
                    while(itr.hasNext())
                    {
                        int v = (Integer) itr.next();
                        int xor = v^val;
                        if(!mlist.contains(xor) && !tlist.contains(xor))
                        {
                            tlist.add(xor);
                            int gets = checkVal(xor);
                            if(gets%2 == 0)
                            {
                                even++;
                            }
                            else
                            {
                                odd++;
                            }
                        }
                    }
                    mlist.addAll(tlist);
                }
                System.out.println(Integer.toString(even) +" " + Integer.toString(odd));
            }
        }
    }
    // this function returns the no of 1's
    public static int checkVal(int val)
    {
        int ans = 0;
        while(val != 0)
        {
            if(val%2 == 1)
            {
                ans++;
            }
            val = val/2;
        }
        return ans;
    }
}
