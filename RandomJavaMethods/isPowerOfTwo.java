/* Determine if a number is a power of two or not
 *
 * Time complexity: O(1)
*/

	private static boolean ifPowerOfTwo(int x)
	{
		return (x > 0 && ((x & (x - 1))  == 0));
	}
