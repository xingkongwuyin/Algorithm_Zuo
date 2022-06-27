package lesson05;

public class Code01_CountOfRangeSum {
	
	public static int countOfRangeSum(int[] arr, int lowwer,int upper) {
		if(arr == null || arr.length == 0 ) {
			return 0;
		}
		// sum 前缀和数组
		int[] sum = new int[arr.length];
		sum[0] = arr[0];
		for(int i = 1; i < arr.length; i++) {
			sum[i] = sum[i - 1] + arr[i];
		}
		
		return process(sum, 0, arr.length,  lowwer, upper);
	}
	
	// 求数组中每个数的左边，加上自身，小于[lowwer upper]，统共有过少个
	public static int process(int[] sum, int L, int R, int lowwer, int upper) {
		if(L == R) {
			return sum[L] >= lowwer && sum[R] <= upper ? 1 : 0;
		}
		int M = L + ((R - L) >> 1);
		return process(sum, L, M, lowwer, upper) 
				+ 
				process(sum, M + 1, R, lowwer, upper) 
				+
				merge(sum, L, M, R, lowwer, upper);
	}
	
	public static int merge(int[] sum, int L, int M, int R, int lowwer, int upper) {
		int windowsR = M;
		int windowsL = L;
		int ans = 0;
		// [windowsL windowsR)
		for(int i = M + 1; i <= R; i++) {
			while(windowsR <= M && windowsR <= upper) {
				windowsR++;
			}
			while(windowsL <= M && windowsL < lowwer) {
				windowsL++;
			}
			ans = windowsR - windowsL;
		}
		
		int[] help = new int[R - L + 1];
		int i = 0;
		int p1 = L;
		int p2 = M + 1;
		while(p1 <= M && p2 <= R) {
			help[i++] = sum[p1] < sum[p2] ? sum[p1++] : sum[p2++];
		}
		while(p1 <= M) {
			help[i++] = sum[p1++];
		}
		while(p2 <= R) {
			help[i++] = sum[p2++];
		}
		for(i = 0; i < help.length; i++) {
			sum[L + i] = help[i];
		}
		return ans;
	}
	
}



