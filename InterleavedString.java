//initial code
import java.util.*;
import java.lang.*;
class InterleavedString
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t>0)
        {
            String a =sc.next();
            String b = sc.next();
            String c = sc.next();
            GfG g=new GfG();
            
            System.out.println(g.isInterLeave(a,b,c)==true?1:0);
            t--;
        }
    }
}



/*Please note that it's Function problem i.e.
 you need to write your solution in the form of Function(s) only.
 Driver Code to call/invoke your function is mentioned above.*/

/*you are required to complete this method */
class GfG{
    public boolean isInterLeave(String a,String b,String c)
    {
        //Your code here
        int as,ae,bs,be,cs,ce;
        as = 0;
        ae = a.length() ;
        bs = 0;
        be = b.length() ;
        cs = 0;
        ce = c.length() ;
        if(ae + be != ce)
        {
            return false;
        }
        return check(a,b,c,as,ae,bs,be,cs,ce);
    }
    boolean check(String A,String B,String C, int as,int ae,int bs,int be, int cs, int ce)
    {
        System.out.println(Integer.toString(as) + " " + Integer.toString(bs) + " " + Integer.toString(cs));
        if(as == ae && bs == be && cs == ce)
        {
            return true;
        }
        else if(as < ae && bs < be)
        {
            if(A.charAt(as) == C.charAt(cs) && B.charAt(bs) == C.charAt(cs))
            {
                return check(A,B,C,as + 1,ae,bs,be,cs + 1,ce) || check(A,B,C,as,ae,bs+ 1,be,cs+ 1,ce);
            }
            else if( as < ae)
            {
                if(A.charAt(as) == C.charAt(cs))
                {
                    return check(A,B,C,as+ 1,ae,bs,be,cs+ 1,ce);
                }
                else if(bs < be)
                {
                    if(B.charAt(bs) == C.charAt(cs))
                    {
                        return check(A,B,C,as,ae,bs+ 1,be,cs+ 1,ce);
                    }
                }
            }
        }
        return false;
    }
}

