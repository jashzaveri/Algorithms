
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main (String[] args) {
        //code
        Scanner s = new Scanner(System.in);
        int cases = s.nextInt();
        HashMap<Double,Integer> map = new HashMap<Double,Integer>();
        double[] n = new double[cases];
        for(int i = 0; i < cases; i++)
        {
            n[i] = s.nextDouble();
        }
        
        for(int j = 0; j < cases; j++)
        {
            double present = n[j];
            int aPrev = 0;
            Iterator itr = map.entrySet().iterator();
            double before = 0.0;
            while(itr.hasNext())
            {
                Map.Entry me = (Map.Entry)itr.next();
                if((Double)me.getKey() > before && (Double)me.getKey() < present)
                {
                    before = (Double)me.getKey();
                    aPrev = (Integer)me.getValue();
                }
            }
            int ans = prime(present,before,aPrev);
            map.put(present,ans);
            System.out.println(ans);
        }
    }
    public static int prime(double n, double prev , int aPrev)
    {
        int a = aPrev;
        for(double i = prev + 1; i <= n; i++)
        {
            if(i%2 != 0 && i%3 != 0 && i%5 != 0 && i%7 != 0 )
            {
                a++;
            }
        }
        return a;
    }
}

