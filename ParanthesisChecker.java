
import java.util.*;
import java.lang.*;
import java.io.*;

class ParanthesisChecker {
    static Scanner s = new Scanner(System.in);
    public static void main (String[] args) {
        //code
        String t = s.nextLine();
        int tt = Integer.parseInt(t);
        for(int i = 0; i < tt; i++)
        {
            String dyn = s.nextLine();
            check(dyn);
        }
    }
    public static void check(String dyn)
    {
        int size = dyn.length();
        // System.out.println(size);
        LinkedList<String> str = new LinkedList<String>();
        for(int i = 0; i < size; i++)
        {
            String small = dyn.substring(i,i+1);
            //  System.out.println(small);
            if(small.equals("[") || small.equals("{") || small.equals("("))
            {
                str.addFirst(small);
                // System.out.println(str.size());
            }
            else if(small.equals(")"))
            {
                if(str.size() == 0)
                {
                    System.out.println("not balanced");
                    return ;
                }
                
                String c = str.removeFirst();
                //System.out.println(c);
                //str.pop();
                if(!c.equals("("))
                {
                    System.out.println("not balanced");
                    return;
                }
            }
            else if(small.equals("]"))
            {
                if(str.size() == 0)
                {
                    System.out.println("not balanced");
                    return ;
                }
                
                String c = str.removeFirst();
                // str.pop();
                
                if(!c.equals("["))
                {
                    System.out.println("not balanced");
                    return;
                }
            }
            else if(small.equals("}"))
            {
                if(str.size() == 0)
                {
                    System.out.println("not balanced");
                    return;
                }
                
                String c = str.removeFirst();
                //str.pop();
                // System.out.println(str.size());
                
                if(!c.equals("{"))
                {
                    System.out.println("not balanced");
                    return;
                }
            }
            
        }
        //System.out.println(str.size());
        if(str.size() == 0)
        {
            System.out.println("balanced");
        }
        else
        {
            System.out.println("not balanced");
        }
    }
}

