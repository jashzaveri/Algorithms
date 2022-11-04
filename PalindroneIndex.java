/* https://www.hackerrank.com/challenges/palindrome-index/problem  */

//6 test cases failed. Termination time out.
import java.util.*;

class PalindroneIndex
{
    static Scanner s = new Scanner(System.in);
    public static int getAns(String a)
    {
        int len = a.length();
        if(isPalin(a))
        {
            return -1;
        }
        else if(isPalin(a.substring(1,len)))
        {
            return 0;
        }
        else if(isPalin(a.substring(0,len-1)))
        {
            return len-1 ;
        }
        else
        {
            String a1 = null;
            String a2 = null;
            for(int i = 1; i < len-1; i++)
            {
                a1 = a.substring(0,i);
                a2 = a.substring(i+1,len);
                String con = a1 + a2;
                if(isPalin(con))
                {
                    return i;
                }
            }
        }
        return -2;
    }
    public static boolean isPalin(String a)
    {
        int len = a.length();
        String left = null;
        String right = null;
        if(len % 2 == 0)
        {
            left = a.substring(0,len/2);
            right = a.substring(len/2,len);
        }
        else
        {
            left = a.substring(0,len/2);
            right = a.substring(len/2 + 1,len);
        }
        int subLen = len/2;
        //StringBuilder b1 = new StringBuilder(left);
        StringBuilder b2 = new StringBuilder(right);
        StringBuilder b3 = b2.reverse();
        right = b3.toString();
        if(left.equals(right))
        {
            return true;
        }
        else
        {
            return false;
        }
        /*for(int i = 0; i < subLen; i++)
        {
            if(left.charAt(i) != right.charAt(subLen-i-1))
            {
                return false;
            }
        }
        return true;*/
    }
    public static void main(String args[])
    {
        int test = s.nextInt();
        s.nextLine();
        for(int i= 0; i < test; i++)
        {
            String a = s.nextLine();
            int ans = getAns(a);
            System.out.println(ans);
        }
    }
}
