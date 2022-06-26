package lesson04;

// 小黑盒
public class Code02_SmallSum {

	public static int smallSum(int[] arr) {
		if (arr == null || arr.length < 2) {
			return 0;
		}
		return process(arr, 0, arr.length - 1);
	}

	public static int process(int[] arr, int L, int R) {
		if (L == R) {
			return 0;
		}
		int M = L + ((R - L) >> 1);
		return process(arr, L, M) 
				+ 
				process(arr, M + 1, R) 
				+ 
				merge2(arr, L, M, R);
	}

	public static int merge1(int[] arr, int L, int M, int R) {
	// int[]  help = new int[R + L -1]; bad!	
		int[] help = new int[R - L + 1];
	//  int p1 = 0; bad!	
		int p1 = L;
		int p2 = M + 1;
		int ans = 0;
		int i = 0;
		while (p1 <= M && p2 <= R) {
			ans += arr[p1] < arr[p2] ? (arr[p1] * (R - p2 + 1)) : 0;
			help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		}
		while (p1 <= M) {
			help[i++] = arr[p1++];
		}
		while (p2 <= R) {
			help[i++] = arr[p2++];
		}
		for (i = 0; i < help.length; i++) {
			arr[L + i] = help[i++];
		}
		return ans;
	}
	
	public static int merge2(int[] arr, int L, int M, int R) {
		int[] help = new int[R - L + 1];
		int p1 = L;
		int p2 = M + 1 ;
		int windowsR = M;
		int ans = 0;
		int k = 0;
		for(int i = M + 1; i <= R; i++) {
			while(windowsR >= L && arr[windowsR] >= arr[i]) {
				windowsR--;
			}
			for(int j = L; j <= windowsR; j++) {
				ans += arr[j];
			}
		}	
		while(p1 <= M && p2 <= R) {
			help[k++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		}
		while(p1 <= M) {
			help[k++] = arr[p1++];
		}
		while(p2 <= R) {
			help[k++] = arr[p2++];
		}
		for (k = 0; k < help.length; k++) { 
		// 	arr[k] = help[k++];  bad!
			arr[L + k] = help[k++];
		}
		return ans;
	}
	

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 3, 3};
		int ans = smallSum(arr);
		System.out.println(ans);
	}

}
