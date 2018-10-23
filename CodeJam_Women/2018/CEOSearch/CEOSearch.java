import java.util.*;
import java.io.*;

public class CEOSearch
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		int t = sc.nextInt();

		for(int i = 1; i <= t; i++)
		{
			int numLevels = sc.nextInt();

			List<Integer> list = new ArrayList<>();
			for(int j = 0; j < numLevels; j++)
			{
				long numPeople = sc.nextInt();
				int level = sc.nextInt();

				for(long k = 0; k < numPeople; k++)
				{
					list.add(level);
				}

			}
			long a = 0;
			long b = 0;
			
			while(b < list.size())
			{
				if(list.get(a) == list.get(b))
				{
					b++;
				}
				else
				{
					long steps = a + Long.valueOf(list.get(b));
					while(list.get(a) < list.get(b) && a < steps)
					{
						a++;
					}
					if(steps == a)
					{
						b++;
					}
				}
			}
	
			int minLevel = Math.max(list.get(b-1) + 1, b-a);
			
			System.out.println("Case #" + i + ": " + minLevel);
		}
	}
}
