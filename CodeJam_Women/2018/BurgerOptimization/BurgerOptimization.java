
// https://code.google.com/codejam/contest/8384486/dashboard

/* More straight forward solution would be
* 1) read in and sort optimal distance (input)
* 2) distance-to-bun is always this pattern 0,0,1,1,2,2,3,3,4...
* 3) a) we can either create another array to store distance-to-bun
*    by populating arr[i] = i/2 starting with i = 0;
*    OR
*    b) we do not need an array but a variable set to 0 (say distance)
* 4) for 3a) sum up square of (optimalDistance[i] - arr[i])
*    for 3b) sum up square of (optimalDistance[i] - distance)
*            where distance will be incremented after the summation if i is odd
*            for(int i = 0; i < n; i++) 
*			 { 
*				sum += Math.pow(optimalDistance[i] - distance;
*				if(i % 2 == 1)
*				{
*					distance++;	
*				}
*			 }
*/
			  
import java.util.*;
import java.io.*;

public class BurgerOptimization
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));		
		int T = sc.nextInt();

		int K = 0;
		List<Integer> list;

		for(int i = 1; i <= T; i++)
		{
			K = sc.nextInt();
			list = new ArrayList<>();

			for(int j = 0; j < K; j++)
			{
				int value = sc.nextInt();
				list.add(value);
			}
			Collections.sort(list);
			int minError = calcMinError(K, list);
			System.out.println("Case #" + i + ": " + minError); 
		}
	}

	public static int calcMinError(int K, List<Integer> list)
	{
		List<Integer> distance = new ArrayList<>();
		int descendingIndex;

		if(K % 2 == 0) // even
		{
			descendingIndex = list.size()-1;
			for(int a = 0; a <= K/2-1; a++)
			{
				distance.add(a);
			}
			for(int a = K/2-1; a >= 0; a--)
			{
				distance.add(a);		
			}
		}
		else // odd
		{
			descendingIndex = list.size()-2;
			for(int a = 0; a <= (K-1)/2; a++)
			{
				distance.add(a);
			}
			for(int a = (K-1)/2-1; a >= 0; a--)
			{
				distance.add(a);
			}
		}

		// sum up min error
		int sum = 0;
		int j = 0;
		for(int i = 0; i < distance.size(); i+=2)
		{
			int diff = Math.abs(list.get(i) - distance.get(j));
			sum += Math.pow(diff, 2);
			j++;
		}

		for(int i = descendingIndex; i > 0; i-=2)
		{
			int diff = Math.abs(list.get(i) - distance.get(j));
			sum += Math.pow(diff, 2);
			j++;
		}	
		return sum;
	}
}
