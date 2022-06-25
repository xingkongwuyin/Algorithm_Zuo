package lesson03;

public class Code09_GetMax {
	// 求arr中的最大值
	public static int getMax(int[] arr) {
		return process(arr, 0, arr.length - 1);
	}
	
	// arr[L R]范围上求最大值
	public static int process(int[] arr, int L, int R) {
		if(R == L) {
			return arr[L];
		}
		int mid = L + ((R - L) >> 1);
		int leftMax = process(arr, L, mid);
		int rightMax = process(arr, mid, R);
		return Math.max(leftMax, rightMax);
	}
}
