/*package whatever //do not write package name here */
// https://www.geeksforgeeks.org/maximum-sum-bitonic-subarray/
import java.util.*;
import java.lang.*;
import java.io.*;
class SubArrayBitnoic {
    static Scanner s = new Scanner(System.in);
    public static void main (String[] args) {
        //code
        String getT = s.nextLine();
        int t = Integer.parseInt(getT);
        for(int i = 0; i < t; i++)
        {
            String getQ = s.nextLine();
            int q = Integer.parseInt(getQ);
            String[] vals = s.nextLine().split(" ");
            int[] arr = new int[q];
            for(int j = 0; j < q; j++)
            {
                arr[j] = Integer.parseInt(vals[j]);
            }
            int ans = value(arr,q);
            System.out.println(ans);
        }
    }
        
        static int value(int[] arr , int q)
        {
            boolean onlyDecrease = true;  // if only decreasing
            int max = 0;
            int prev = arr[0];
            boolean incdec = false;
            int decMax = prev;
            for(int i = 1; i < q; i++)
            {
                int val = arr[i];
                if(val < prev && onlyDecrease == true)
                {
                    decMax += val;
                    prev = val;
                }
                else if(val > prev && incdec == false && onlyDecrease == true)
                {
                    onlyDecrease = false;
                    if(max < decMax)
                    {
                        max = decMax;
                    }
                    decMax = val + prev;
                    prev = val;
                }
                else if(val > prev && incdec == false && onlyDecrease == false)
                {
                    decMax += val;
                    prev = val;
                }
                else if(val < prev && onlyDecrease == false && incdec == false)
                {
                    incdec = true;
                    decMax += val;
                    prev = val;
                }
                else if(val < prev && onlyDecrease == false && incdec == true)
                {
                    decMax += val;
                    prev = val;
                }
                else if(val > prev && onlyDecrease == false && incdec == true)
                {
                    incdec = false;
                    if(max < decMax)
                    {
                        max = decMax;
                    }
                    decMax = prev + val;
                    prev = val;
                }
            }
            if(onlyDecrease == true)
            {
                max = decMax;
            }
           /* if(decMax > max)
            {
                max = decMax;
            }*/
            return max;
        }
}
