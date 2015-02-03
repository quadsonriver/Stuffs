/* Find the largest two values of an UNSORTED array
	 * 		Time Complexity: O(n) 
	 */
	private static void findTopTwoNumbers(int[] arr)
	{
		int first = 0;
		int second = 0;
		for(int i = 0; i<arr.length;i++)
		{
			if(arr[i] > first)
			{
				second = first;
				first = arr[i];
			}
			else if(arr[i] > second)
				second = arr[i];
		}
		System.out.println("first: " + first + " second: " + second);
	}
