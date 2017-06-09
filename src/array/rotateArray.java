package array;

/**
 * 
 * @author xu
 * Rotate an array of n elements to the right by k steps.
 * 
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * 
 * https://leetcode.com/problems/rotate-array/#/description
 * 
 */
public class rotateArray {

	public static void main(String[] args) {
		
		int[] arr = new int[]{1,2,3,4,5,6,7};
		solution(arr, 3);
		
		for (int n:arr)
			System.out.print(n);
	}
	/* normal way 
	 * Copy the last k elements to temp array
	 * */
	static int[] solution (int[] arr, int k) {
		int[] tmp = new int[k % arr.length];
		
		// copy last k elements
		int n = 0;
		int len = arr.length;
		for (int i = len-k; i < len; i++) {
			tmp[n] = arr[i];
			n++;
		}
		// copy the first n-k elements from backwards otherwise will cause error
		// tmp 5 6 7
		// 1,2,3,4,5,6,7 -> 5,6,7,1,2,3,4
		for (int i = len-k-1; i>=0; i--) {
			arr[i+k]  = arr[i];
		}
		
//		for (int i=0; i<len-k; i++) { // wrong 
//			arr[i+k] = arr[i];
//		}
		
		for (int i=0; i<k; i++) {
			arr[i] = tmp[i];
		}
		return arr;
	}
	/* reverse the array like {1,2,3,4,5,6,7}->{7,6,5,4,3,2,1}->{5,6,7,}->{,1,2,3,4}
	 *  helper function reverse
	 * 
	 * */
	static int[] solution2(int[] arr, int k) {
		reverse(arr, 0, arr.length-1);
		reverse(arr, 0, k-1);
		reverse(arr, k, arr.length-1);
		return arr;
		
	}
	static void reverse(int[] arr, int left, int right) {
		
		while (left < right) {
			int tmp = arr[left];
			arr[left] = arr[right];
			arr[right] = tmp;
			left++;
			right--;
		}
		
	}
	 // let array[1,2,3,4,5,6,7,8,9], k=4;
    // first step [5,4,3,2,1, 6,7,8,9]
    // second step [5,4,3,2,1, 9,8,7,6]
    // third step [6,7,8,9,1,2,3,4,5] done.
	static int[] solution3(int[]arr, int k) {
		reverse(arr, 0, arr.length - k -1);
		reverse(arr, arr.length - k, arr.length);
		reverse(arr, 0, arr.length-1);
		
		return arr;
	}
	
	
	
	/* method 3 */

}
