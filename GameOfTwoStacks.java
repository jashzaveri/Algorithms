import java.util.*;
import java.lang.*;
class GameOfTwoStacks
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int g = s.nextInt();
		int finalAns[] = new int[g];
		for(int i = 0; i < g; i++)
		{
			String[] a = s.nextLine().split(" ");
			int n = Integer.parseInt(a[0].trim());
			int m = Integer.parseInt(a[1].trim());
			int x = Integer.parseInt(a[2].trim());
			Stack<Integer> A = new Stack<Integer>();
			Stack<Integer> B = new Stack<Integer>();
			String ofA[] = s.nextLine().split(" ");
			String ofB[] = s.nextLine().split(" ");
			for(int j = n-1; j >= 0; j--)
			{
				A.push(Integer.parseInt(ofA[j].trim()));
			} 
			for(int k = m-1; k >= 0; k--)
			{
				B.push(Integer.parseInt(ofB[k].trim()));
			} 
			int count = 0;
			int cost = 0;
			while(cost <= x && !A.isEmpty() && !B.isEmpty())
			{
				if(A.peek() < B.peek())
				{
					count +=1;
					cost += A.peek();
					A.pop();
				}
				else if(A.peek() > B.peek())
				{
					count +=1;
					cost += B.peek();
					B.pop();
				}
			}
			if(!A.isEmpty() && !B.isEmpty())
			{
				count -= 1;
			}
			finalAns[i] = count;
		}
		for(int p = 0; p < g; p++)
		{
			System.out.println(finalAns[p]);
		}
	}
}