/* Find the Median value of an array given a minimum threshold value
 *    Time  Complexity: O(n)
 *    Space Complexity: O(n)
 */

public static double getMedianMinThreshold(int[] list, int minThreshold)
	{
		for(int i = 0; i<list.length; i++) //O(n) worst case. Simple modifications can be used to make O(log(n))
		{
			if(list[i] >= minThreshold)
			{
				System.out.println(getMean(list,i,list.length-1));
				return getMedian(list,i,list.length-1); //value passed threshold, find median
			}
		}
		return -1; //no median found
	}
	
	
private static double getMedian(int[] list, int positionSmall, int positionLarge)
	{
		int mid = (positionLarge+positionSmall)/2; //middle location
		if((positionLarge-positionSmall)%2 == 1) //2 median values, find average and return
			return (double)(list[mid] + list[mid+1])/(double)2.0;
		return list[mid]; //1 median value returned
	}
