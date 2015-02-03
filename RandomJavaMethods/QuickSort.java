//Quick sort

private static void quicksort(int[] arr, int low, int high)
	{
		if(low < high)
		{
			int p = partition(arr,low,high);
			quicksort(arr,low,p-1);
			quicksort(arr,p+1,high);
		}
	}
	
	private static int partition(int[] arr, int low, int high)
	{
		int pivot = (high+low)/2;
		int value = arr[pivot];
		arr[pivot] = arr[high];
		arr[high] = value;
		int index = low;
		for(int i = low; i<=high-1;i++)
		{
			if(arr[i] < value)
			{
				int temp = arr[i];
				arr[i] = arr[index];
				arr[index] = temp;
				index++;
			}
		}
		int temp = arr[index];
		arr[index] = arr[high];
		arr[high] = temp;
		return index;
	}
