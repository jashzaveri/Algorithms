// https://practice.geeksforgeeks.org/problems/sum-of-digit-is-pallindrome-or-not/0

// Completed Easy
import java.util.*;

class SumDigitPalindrone
{
    static Scanner s = new Scanner(System.in);
    
    public static boolean palin(String test, int digit, int len)
    {
        if(digit == len/2)
            return true;
        else if(digit < len/2)
        {
           // String chan = Integer.toString(test);
            if(test.charAt(digit) == test.charAt(len-digit-1))
            {
               // digit++;
                return palin(test,++digit,len);
            }
        }
        return false;
    }
    public static void main (String args[])
    {
        int cases = s.nextInt();
       // s.nextLine();
        for(int i = 0; i < cases; i++)
        {
            int a = s.nextInt();
            String as = Integer.toString(a);
            int alen = as.length();
            int sum = 0;
            for(int j = 0; j < alen; j++)
            {
                sum += Character.getNumericValue(as.charAt(j));
            }
            String sums = Integer.toString(sum);
            int slen = sums.length();
            boolean ans = palin(sums,0,slen);
            if(ans == true)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
        /*String test = s.nextLine();
        int len = test.length();
        boolean ans = palin(test,0,len);
        System.out.println(ans);*/
    }
}
