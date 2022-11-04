import java.util.*;
class Snselect
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		s.nextLine();
		String[] ans = new String[t+1];
		for(int i = 0; i < t; i++)
		{
			String arr = s.nextLine();
			//System.out.println(arr[i]);
			int len = arr.length();
			int mong = 0;
			int seat = 0;
			boolean[] visited = new boolean[len];
			for(int j = 0; j < len;j++)
			{
				if(arr.charAt(j) == 'm' && j == 0) // for the first element
				{
				//System.out.println(mong);
					mong++;
					if(j+1 != len)
					{
						if(arr.charAt(j+1) == 's' && visited[j+1] == false) // for first element
						{
							visited[j+1] = true;
							seat++;
						}
					}
				}
				else if(arr.charAt(j) == 'm' && j+1 == len) //for the last element
				{
				//System.out.println(mong);
					mong++;
					if(arr.charAt(j-1) == 's' && visited[j-1] == false)
					{
						visited[j-1] = true;
						seat++;
					}
				} 
				else 
				{
				//System.out.println(mong);
					if(arr.charAt(j) == 'm')
					{
						mong++;
						if(arr.charAt(j-1) == 's' && visited[j-1] == false)
						{
							visited[j-1] = true;
							seat++;
						}
						else if (arr.charAt(j+1) == 's' && visited[j+1] == false)
						{
							visited[j+1] = true;
							seat++;
						}
					}
				}
			}
			int snakes = len - mong - seat;
			if(snakes > mong)
			{
				ans[i] = "snakes";
			}
			else if (snakes < mong)
			{
				ans[i] = "mongooses";
			}
			else
			{
				ans[i] = "tie";
			}
		}
		for(int i = 0; i < t ;i++)
		{
			System.out.println(ans[i]);
		}
	}
}
