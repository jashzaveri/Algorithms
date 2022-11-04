// https://www.hackerrank.com/challenges/recursive-digit-sum/problem
// Completed
import java.util.*;
import java.math.*;
class RecursiveDigitSum
{
    static Scanner s = new Scanner(System.in);
    public static void main(String args[])
    {
        String[] in = s.nextLine().split(" ");
        String num = in[0].trim();
        int time = Integer.parseInt(in[1].trim());
        int len = num.length();
        //int sum = 0;
        BigInteger sum = new BigInteger("0");
      //  System.out.println(num);
        for(int i = 0; i < len; i++)
        {
            String inc = Character.toString(num.charAt(i));
           // System.out.println(inc);
            BigInteger add = new BigInteger(inc);
            //System.out.println(add);
            sum = sum.add(add);  // += Character.getNumericValue(num.charAt(i));
           // System.out.println(sum);
        }
        BigInteger times = new BigInteger(Integer.toString(time));
        sum =  sum.multiply(times);
       // String sums = Integer.toString(sum);
       // System.out.println(sum);
        int ans = superDigit(sum);
        System.out.println(ans);
    }
    public static int superDigit(BigInteger sums)
    {
        String get = sums.toString();
       // System.out.println(get);
        int len = get.length();
        //int sum = 0;
      //  System.out.println(len);
        BigInteger sum = new BigInteger("0");
        if(len == 1)
        {
            return Integer.parseInt(get);
        }
        else
        {
            for(int i = 0; i < len; i++)
            {
                BigInteger add = new BigInteger(Character.toString(get.charAt(i)));
               sum = sum.add(add);  // += Character.getNumericValue(num.charAt(i));
            //    System.out.println(add);
            }
        }
        return superDigit(sum);
    }
}
