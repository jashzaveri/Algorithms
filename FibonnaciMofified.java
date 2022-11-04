// https://www.hackerrank.com/challenges/fibonacci-modified/problem
// completed
import java.util.*;
import java .math.*;
class FibonnaciMofified
{
    static Scanner s = new Scanner(System.in);
    public static void main(String args[])
    {
        HashMap<Integer,BigInteger> map = new HashMap<Integer,BigInteger>();
        String[] take = new String[3];
        take = s.nextLine().split(" ");
        BigInteger first = new BigInteger(take[0].trim());
        map.put(1,first);
        BigInteger second = new BigInteger(take[1].trim());
        map.put(2,second);
        int n = Integer.parseInt(take[2].trim());
        for(int i = 3; i <= n; i++)
        {
            BigInteger s2 = map.get(i-1).pow(2);
            BigInteger next = map.get(i-2).add(s2);
            map.put(i,next);
        }
        System.out.println(map.get(n));
    }
}
