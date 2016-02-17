/* Determine if a number is a power of two or not. 
 * Uses bitwise operation to check for only one positive bit in binary value.
 *
 * Time complexity: O(1)
 *
 * Method will check the existence of a positive number
 * Method will make binary check of value (x) with (x-1). Example below.
 * 
 * x = 4
 * 100  binary value of (4)
 * 011  binary value of (4-1)
 * ===
 * 000  bitwise operator value of 100 & 011 
 *
 * Check if 000 = 0 (true), therefore 4 is a power of 2
*/

	private static boolean ifPowerOfTwo(int x)
	{
		return (x > 0 && ((x & (x - 1))  == 0));
	}
