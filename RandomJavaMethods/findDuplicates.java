/* Find duplicate values in an UNSORTED array
	 * 		Time  Complexity: O(n)
	 * 		Space Complexity: O(n)
	 */
	private static List findDuplicates(int[] arr)
	{
		List<Integer> l = new ArrayList<Integer>();
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		int count;
		for(int i = 0;i<arr.length;i++)
		{
			if(map.get(arr[i]) != null && map.get(arr[i])==1)
				l.add(arr[i]);
			else
				map.put(arr[i], 1);
		}
		return l;
	}
