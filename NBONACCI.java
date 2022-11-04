import java.util.*;
import java.math.*;
// https://www.codechef.com/COOK104B/submit/NBONACCI
class NBONACCI
{
    static Scanner s = new Scanner(System.in);
    public static void main(String args[])
    {
        String[] ab = s.nextLine().split(" ");
        int n = Integer.parseInt(ab[0]);
        int q = Integer.parseInt(ab[1]);
        String[] getN = s.nextLine().split(" ");
        BigInteger[] N = new BigInteger[n];
        for(int i =0 ; i < n; i++)
        {
            BigInteger big = new BigInteger(getN[i]);
            if(i != 0)
            {
                N[i] = big.xor(N[i-1]);
            }
            else
            {
                N[i] = big;
            }
        }
        for(int k = 0; k < q; k++)
        {
            String a = s.nextLine();
            BigInteger ans = value(Integer.parseInt(a),N,n);
            System.out.println(ans);
        }
    }
    static BigInteger value(int q , BigInteger[] N , int n)
    {
        BigInteger[] val = new BigInteger[q];
       /* System.out.println(N.length );
        System.out.println(N[0] );*/
        System.out.println(val.length );
       // System.out.println(q );

        val[0] = N[0];
        /*for(int i = 1; i < n; i++)
        {
            val[i] = val[i-1]^N[i];
        }*/
        
        if(q < n)
        {
            return N[q-1];
        }
        else
        {
            for(int p = 0; p < n; p++)
            {
                val[p] = N[p];
            }
            for(int j = n; j < q; j++)
            {
                BigInteger getv ;
                getv = new BigInteger("0");
                for(int k = 1; k <= n; k++)
                {
                    BigInteger vals = getv.xor(val[j-k]);
                    getv = vals;
                }
                val[j] = getv;
            }
        }
        return val[q-1];
        
    }
}
