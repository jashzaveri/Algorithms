/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
 //imports for BufferedReader
 import java.io.BufferedReader;
 import java.io.InputStreamReader;
 
 //import for Scanner and other utility classes
 */
import java.util.*;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class CapitalCities {
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input
         
         //BufferedReader
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         String name = br.readLine();                // Reading input from STDIN
         System.out.println("Hi, " + name + ".");    // Writing output to STDOUT
         
         //Scanner
         */Scanner s = new Scanner(System.in);
        // String name = s.nextLine();                 // Reading input from STDIN
        //System.out.println("Hi, " + name + ".");    // Writing output to STDOUT
        
        
        
        // Write your code here
        String[] get = s.nextLine().split(" ");
        int n = Integer.parseInt(get[0]);
        int k = Integer.parseInt(get[1]);
        float[] arr = new float[n];
        String[] val = s.nextLine().split(" ");
        float sum = 0;
        for(int i = 0; i < n; i++)
        {
            arr[i]  = Float.parseFloat(val[i]);
            sum += arr[i];
        }
        float avg = sum/n;
        float[] mat = new float[n];
        float min = 1000000000.0f;
        int index = -1;
        for(int i = 0; i< n; i++)
        {
            mat[i] = Math.abs(arr[i]-avg);
            float vals = Math.abs(arr[i]-mat[i]);
            if(min > vals )
            {
                min = vals;
                index = i;
                System.out.println(min);
            }
            System.out.println(mat);
        }
        float prS = 0;
        for(int i = 0; i < n; i++)
        {
            prS += Math.abs(arr[index]-arr[i]);
        }
        index++;
        System.out.println(Integer.toString(index) + " " + Integer.toString(Math.round(prS-k)));
    }
}

