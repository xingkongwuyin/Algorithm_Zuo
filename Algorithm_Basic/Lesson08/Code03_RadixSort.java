package lesson08;

public class Code03_RadixSort {
	
	public static void radixSort(int[] arr) {
		if(arr == null || arr.length < 2) {
			return;
		}
		radixSort(arr, 0, arr.length - 1, maxbits(arr));
	}
	
	public static int maxbits(int[] arr) {
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < arr.length; i++) {
			max = Math.max(max, arr[i]);
		}
		int num = 1;
		while(max / 10 != 0) {
			num++;
			max /= 10;
		}
		return num;
	}
	
	// [L R] sort  digit: the decimal digit of the maximum value
	public static void radixSort(int[] arr, int L , int R, int digit) {
		final int radix = 10;
		int i = 0;
		int j = 0;
		int[] help = new int[R - L + 1];
		for(int d = 1; d <= digit; d++) {
			// 10 space
			// count[i] how many  current digit <= i
			int[] count = new int[radix];
			for( i = L; i <= R ; i++) {
				j = getDigit(arr[i], d);
				count[j]++;
			}
			for( i = 1; i < radix; i++) {
				count[i] = count[i - 1] + count[i];
			}
			for(i = R; i >= L; i--) {
				j = getDigit(arr[i], d);
				help[count[j] - 1] = arr[i];
				count[j]--;
			}
			for(i = L, j = 0; i <= R; i++, j++) {
				arr[i] = help[j];
			}
		}
	}
	
	// get digit
	public static int getDigit(int x, int d) {
		int num = x / (int)(Math.pow(10, d - 1));
		return num % 10;
	}
	
	public static void print(int[] arr) {
		for(int num : arr) {
			System.out.print(num + " ");
		}
	}
	public static void main(String[] args) {
		
		int[] arr = {2,3,1,13,565,67,143,352,4,654,3674};
		radixSort(arr);
		print(arr);

	}

}
