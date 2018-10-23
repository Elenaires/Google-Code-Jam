import java.util.*;
import java.io.*;

public class CEOSearchLarge
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		int t = sc.nextInt();

		for(int i = 1; i <= t; i++)
		{
			int numLevels = sc.nextInt();

			long minLevel = 0;
			long carryOn = 0;
		
			long num1 = sc.nextLong();
			long level1 = sc.nextLong();
			long total1 = num1 * level1;

			long num2 = 0;
			long level2 = 0;
			long total2 = 0;

			if(numLevels == 1)
			{
				minLevel = Math.max(num1, level1+1); 
				System.out.println("Case #" + i + ": " + minLevel);
				continue;				
			}


			for(int j = 0; j < numLevels-1; j++)
			{
				num2 = sc.nextLong();
				level2 = sc.nextLong();
				total2 = num2 * level2;

				long result = total2 - (num1 + carryOn);				

				if(result >= 0)
				{
					carryOn = 0;
				}
				else 
				{
					carryOn = Math.abs(result);
				}				

				num1 = num2;
				level1 = level2;
				total1 = total2;
			}
		
			minLevel = Math.max(carryOn+num2, level2+1);
			System.out.println("Case #" + i + ": " + minLevel);
	
		}	
	}
}
