/* https://www.hackerrank.com/challenges/bear-and-steady-gene/problem */
/*
import java.util.*;
class BearSteadyGene
{
    static Scanner s = new Scanner(System.in);
    public static void main(String args[])
    {
        HashMap<Integer,String> map = new HashMap<Integer,String>();
        Iterator itr;
        int size = s.nextInt();
        String gene = s.nextLine();
        int countA,countC,countG,countT = 0;
        for(int i = 0; i < size; i++)   // checking the no of occurences of ACTG in the string
        {
            if(gene.charAt(i) == 'A')
            {
                countA++;
            }
            else if(gene.charAt(i) == 'C')
            {
                countC++;
            }
            else if(gene.charAt(i) == 'G')
            {
                countG++;
            }
            else
            {
                countT++;
            }
        }
        int flagA,flagC,flagG,flagT = 0;   //checking the number of occurence exceding
        flagA = flagA - size/4;
        flagC = flagC - size/4;
        flagG = flagG - size/4;
        flagT = flagT - size/4;
        
        String base = "0A0C0G0T0:-1"; // index at 0 specifies if the keyvalue pair needs to be modified while the value associated to actg specifies the occurences of the req alpha and the last int defines the ending index of the sun=bstring
        for(i = 0; i < size; i++)
        {
            String a = gene.substring(i,i+1);
            itr = new map.entrySet().iterator();
            if(!map.isEmpty())
            {
                while(itr.hasNext())
                {
                    Integer a = itr.next();  //got the first map entry
                    String genSam = map.get(a);  // got the value corresponding to the key
                    if(genSam.charAt(0) == '0')
                    {
                        int aNo = genSam.indexOf('A');
                        int cNo = genSam.indexOf('C');
                        int gNo = genSam.indexOf('G');
                        int tNo = genSam.indexOf('T');
                        int _No = genSam.indexOf(':');
                        int ivalA,ivalC,ivalG,ivalT = 0;
                        if(flagA > 0)
                        {
                            String svalA = genSam.substring(aNo+1,cNo);
                            ivalA = Integer.parseInt(svalA);
                            if(flagA > ivalA)
                            {
                                ivalA++;
                                String modsvalA = ivalA.toString();
                                String modgenSam = "A" + modsvalA;
                                svalA = "A" + svalA;
                                genSam.replaceFirst(svalA,modgenSam);
                            }
                            String svalC = genSam.substring(cNo+1,gNo);
                            ivalC = Integer.parseInt(svalC);
                            if(flagC > ivalC)
                            {
                                ivalC++;
                                String modsvalC = ivalC.toString();
                                String modgenSam = "C" + modsvalC;
                                svalC = "C" + svalC;
                                genSam.replaceFirst(svalA,modgenSam);
                            }
                            String svalG = genSam.substring(gNo+1,tNo);
                            ivalG = Integer.parseInt(svalG);
                            if(flagG > ivalG)
                            {
                                ivalG++;
                                String modsvalG = ivalG.toString();
                                String modgenSam = "G" + modsvalG;
                                svalG = "G" + svalG;
                                genSam.replaceFirst(svalG,modgenSam);
                            }
                            String svalT = genSam.substring(tNo+1,_No);
                            ivalT = Integer.parseInt(svalT);
                            if(flagT > ivalT)
                            {
                                ivalT++;
                                String modsvalT = ivalT.toString();
                                String modgenSam = "T" + modsvalT;
                                svalT = "T" + svalT;
                                genSam.replaceFirst(svalT,modgenSam);
                            }
                            if(flagA > 0)
                                if(ivalA == flagA)
                                    if(
                            map.put(itr,genSam);
                            
                        }
                        
                    }
                }
            }
        }
    }
}
*/
import java.util.*;
class BearSteadyGene
{
    static Scanner s = new Scanner(System.in);
    public static void main(String args[])
    {
        int size = s.nextInt();
        s.nextLine();
        String test = s.nextLine();
        int countA = 0;
        int countC = 0;
        int countG = 0;
        int countT = 0;
        for(int i = 0; i < size; i++)  // to find the occurence of acgt.
        {
            if(test.charAt(i) == 'A')
                countA++;
            else if (test.charAt(i) == 'C')
                countC++;
            else if(test.charAt(i) == 'G')
                countG++;
            else
                countT++;
        }
        
        if(countA > size/4)     // to find the extra count of occurence of acgt.
            countA = countA - size/4;
        else
            countA = 0;
        if(countC > size/4)
            countC -= size/4;
        else
            countC = 0;
        if(countG > size/4)
            countG -= size/4;
        else
            countG = 0;
        if(countT > size/4)
            countT -= size/4;
        else
            countT = 0;
        
        int smallest = 500000;
        for(int i = 0; i < size; i++)
        {
            int cA = countA;
            int cC = countC;
            int cG = countG;
            int cT = countT;
            
            char check = test.charAt(i);
            if((check == 'A' && cA > 0) || (check == 'C' && cC > 0) || (check == 'G' && cG > 0) || (check == 'T' && cT > 0))
            {
                if(check == 'A' && cA > 0)
                    cA--;
                else if(check == 'C' && cC > 0)
                    cC--;
                else if(check == 'G' && cG > 0)
                    cG--;
                else if(check == 'T' && cT > 0)
                    cT--;
                for(int j = i+1; j < size; j++)
                {
                    char checks = test.charAt(j);
                    if( checks == 'A' && cA > 0)
                    {
                        cA--;
                        System.out.println("Am in cA " + Integer.toString(cA));
                    }
                    else if( checks == 'C' && cC > 0)
                    {
                        cC--;
                        System.out.println("Am in cC " + Integer.toString(cC));
                    }
                    else if( checks == 'G' && cG > 0)
                    {
                        cG--;
                        System.out.println("Am in cG " + Integer.toString(cG));
                    }
                    else if( checks == 'T' && cT > 0)
                    {
                        cT--;
                        System.out.println("Am in cT " + Integer.toString(cT));
                    }
                    if(cA == 0 && cC == 0 && cG == 0 && cT == 0)
                    {
                        int subSize = j - i + 1;
                        if(subSize < smallest)
                        {
                            smallest = subSize;
                        }
                        System.out.println(Integer.toString(i) + " " + Integer.toString(j));
                        j = size;
                    }
                }
            }
        }
        System.out.println(smallest);
    }
}
