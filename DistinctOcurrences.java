// https://practice.geeksforgeeks.org/problems/disL

import java.util.*;
class DistinctOcurrences
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t>0)
        {
            String line = sc.nextLine();
            String S = line.split(" ")[0];
            String T = line.split(" ")[1];
            
            GfG g = new GfG();
            System.out.println(g.subsequenceCount(S,T));
            t--;
        }
    }
}


/*Please note that it's Function problem i.e.
 you need to write your solution in the form of Function(s) only.
 Driver Code to call/invoke your function is mentioned above.*/

/*You are required to complete this method*/
class GfG
{
    /* int subsequenceCount(String S, String T)
     {
     // Your code here
     int sizeS = S.length();
     int sizeT = T.length();
     int i = 0;
     int j = 0;
     return sub(i,j,sizeS,sizeT,S,T);
     }
     int sub(int i , int j ,int sizeS, int sizeT, String S , String T)
     {
     if(i >= sizeS || j >= sizeT)
     {
     System.out.println("yes");
     return 0;
     }
     //char s = S.charAt(i);
     //char t = T.charAt(j);
     if( S.charAt(i) == T.charAt(j))
     {
     if(j == sizeT-1)
     {
     return 1+ sub(i++,j,sizeS,sizeT,S,T);
     }
     else
     {
     return sub(i++,j++,sizeS,sizeT,S,T) + sub(i++,j,sizeS,sizeT,S,T);
     }
     }
     else
     {
     return sub(i++,j,sizeS,sizeT,S,T);
     }
     }*/
    int subsequenceCount(String S, String T)
    {
        int sizeS = S.length();
        int sizeT = T.length();
        int[][] mat = new int[sizeT+1][sizeS + 1];
        for(int i = 0; i< sizeS; i++)
        {
            mat[0][i] = 1;
        }
        for(int j = 1 ; j <= sizeS;j++)
        {
            for(int k = 1 ; k <= sizeT; k++)
            {
                if(S.charAt(j-1) == T.charAt(k-1))
                {
                    mat[k][j] = mat[k][j-1] + mat[k-1][j-1];
                }
                else
                {
                    mat[k][j] = mat[k][j-1];
                }
            }
        }
        return mat[sizeT][sizeS];
    }
}
