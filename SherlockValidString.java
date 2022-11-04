//https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem

/*import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

 class SherlockValidString {

    // Complete the isValid function below.
    static String isValid(String s) {
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        LinkedList<Character> vals = new LinkedList<Character>();
    char[] a = s.toCharArray();
        int len = a.length;
        for(int i = 0; i <len ; i++)
        {
            if(map.containsKey(a[i]))
            {
                int val = map.get(a[i]);
                val +=1;
                map.put(a[i],val);
            }
            else{
                int val = 1;
                map.put(a[i],val);
                vals.add(a[i]);
            }
        } 
        int length = vals.size();
        int count = 0;
        for(int j = 1; j <length-1 ; j++)
        {
        	int a1 =map.get(vals.get(0)) ;
        	int a2 = map.get(vals.get(j));
            if(a1 != a2) 
            {
            	if(a1 <a2)
               {
               		 count += a2 - a1 ;
               	}
               	else
               	{
               		count += a1 - a2;
               	}
            }
            
        }
        System.out.println(count);
        if(count >1)
        {return "NO";}
        return "YES";
    }

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)  {

        String s = scanner.nextLine();

        String result = isValid(s);

        System.out.println(result);
        scanner.close();

    }
}
*/








import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

 class SherlockValidString {

    // Complete the isValid function below.
    static String isValid(String s) {
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        LinkedList<Character> vals = new LinkedList<Character>();
    char[] a = s.toCharArray();
        int len = a.length;
        for(int i = 0; i <len ; i++)
        {
            if(map.containsKey(a[i]))
            {
                int val = map.get(a[i]);
                val +=1;
                map.put(a[i],val);
            }
            else{
                int val = 1;
                map.put(a[i],val);
                vals.add(a[i]);
            }
        } 
        int length = vals.size();
        int count1 = 1;
        int count2 = 0;
        int a1 = map.get(vals.get(0));
        int a2 = 0;
        String result = "YES";
        for(int j = 1; j <length; j++)
        {
            int b = map.get(vals.get(j));
        	if(b == a1)
            {
                count1 += 1;
            }
            else if(b != a1 && a2 == 0)
            {
                a2 = b;
                count2 += 1;
            }
            else if(a2 != 0 && b == a2)  
            {
                count2 += 1;
            }
            else if((b != a1 && b != a2))
            {
                result = "NO";
                break;
            }
        }
        if((count1 > 1 && count2 > 1)&&((a1-a2)>1))
        {
        	result = "NO";
        }
        System.out.println(count1);
        System.out.println(count2);
        return result ;
    }

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)  {

        String s = scanner.nextLine();

        String result = isValid(s);

        System.out.println(result);
        scanner.close();

    }
}



