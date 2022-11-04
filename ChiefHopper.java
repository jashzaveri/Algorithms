import java.util.*;
public class ChiefHopper
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int q = s.nextInt();
		String[] heights = s.nextLine().split(" ");
		int values[] = new int[q];
		int avg = 0;
		for (int i = 0; i< q; i++) 
		{
			values[i] = Integer.parseInt(heights[i].trim());
			avg += values[i];
		}
		avg = avg/q;
		int findMin(int[] value , int size , int a)
		{
			int result = a;
			for (int i = 0; i < size; i++)
			{
				result = 2*result - value[i];
			}
			return (result); 
		}
		int ans = 0;
		int previousValue = 0;
		int presentValue = findMin(values,q,avg);
		boolean gotIt = false;
		while(gotIt != true)
		{
			if(presentValue < 0)
			{
				avg++;
				previousValue = presentValue;
				presentValue = findMin(values,q,avg);
			}
			else if (presentValue >= 0 && previousValue < 0)
			{
				gotIt = true;
			}
			else if(presentValue < 0 && previousValue >=0)
			{
				avg--;
				gotIt = true;
			}
			else if(presentValue >= 0 && previousValue >= 0 )
			{
				avg--;
				previousValue = presentvalue;
				presentValue = findMin(values,q,avg);
			} 
		}
		System.out.println(avg);
	}
}