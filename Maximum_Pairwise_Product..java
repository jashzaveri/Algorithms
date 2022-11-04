import java.io.*;
import java.util.*;
import java.lang.*;


class Maximum_Pairwise_Product
{	   
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Scanner s = new Scanner(System.in);
	public static void main(String[] args)throws IOException
	{



		int a = 200;
		int count = Integer.parseInt(br.nextInt());
		int[] arr = Integer.parseInt(br.nextline().split(" "));
		int last = 0;
		int sLast = 0;
		for(int i = 0; i < count; i++)
		{
			if(arr[i] > last)
			{
				sLast = last;
				last = arr[i];
			}
			else if(sLast < arr[i])
			{
				sLast = arr[i];
			}
		}
		System.out.println(sLast*last);
	}
}


