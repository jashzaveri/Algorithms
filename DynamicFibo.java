/*https://www.geeksforgeeks.org/program-for-nth-fibonacci-number/  */
// completed

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

class DynamicFibo {
static Scanner s = new Scanner(System.in);
static List<BigInteger> list = new LinkedList<BigInteger>();
public static BigInteger fibo(int val)
{
    if(val == 0 || val == 1)
    {
        return list.get(val);
    }
    else
    {
        if(val < list.size())
        {
            return list.get(val);
        }
        else
        {
            for(int i = list.size(); i <= val; i++)
            {
                BigInteger an = list.get(i - 1).add(list.get(i - 2));
               // System.out.println(an);
                list.add(an);
            }
            return list.get(val);
        }
    }
}

public static void main (String[] args) {
//code
BigInteger a = new BigInteger("0");
    BigInteger b = new BigInteger("1");
    list.add(a);
    list.add(b);
int test = s.nextInt();
int[] input = new int[test];
    for(int i = 0; i < test; i++)
    {
        input[i] = s.nextInt();
    }
    for(int j = 0; j < test; j++)
    {
        BigInteger ans = fibo(input[j]);
        BigInteger modd = new BigInteger("1000000007");
        ans = ans.mod(modd) ;
        System.out.println(ans);
    }
}
}
