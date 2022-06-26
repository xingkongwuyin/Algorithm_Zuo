package lesson04;

public class Code01_MergeSort {
	
	// recursion implement
	public static void mergeSort1(int[] arr) {
		if(arr == null || arr.length < 2) {
			return;
		}
		process(arr, 0, arr.length - 1);
	}
	
	// 请把arr[L R]派有序
	// T(N) = 2 * T(N / 2) + O(N);
	// O(N * logN)
	public static void process(int[]arr, int l, int r) {
		if(l == r) {
			return ;
		}
		int mid = l  + ((r - l)>> 1);
		process(arr, l, mid);
		process(arr,mid + 1, r);
		merge(arr, l, mid, r);
	}
	public static void merge(int[] arr, int L, int mid, int R) {
		int[] help = new int[R + L - 1];
		int p1 = L;
		int p2 = mid + 1;
		int i = 0;
		while(p1 <= mid && p2 <= R) {
			help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		}
		while(p1 <= mid) {
			help[i++] = arr[p1++];
		}
		while(p2 <= R) {
			help[i++] = arr[p2++];
		}
		for(i = 0; i < help.length; i++) {
			arr[L + i] = help[i];
		}
	}
	
	// not recusion implement
	public static void mergesort2(int[] arr) {
		if(arr == null || arr.length < 2) {
			return;
		}
		int N = arr.length;

		int mergeSize = 1;
		while (mergeSize < N) {
			int L = 0;
			while (L < N) {
				if (mergeSize >= N - L) { // N - 1 - L  + 1
					break;                // 看arr[N - 1]到arr[L]之间的数的个数，是不是
				}                         // 小于步长 
				int m = L + mergeSize - 1;
				int R = m + Math.min(mergeSize,N - 1 -m);
				merge(arr, L, m, R);      // 看arr[N - 1]与arr[m]之间的数的个数，小于
				L = R + 1;                // mergeSize的话，就说明右组里面的个数不够步长
			}                             // 这一步的目的是为了防止R溢出
			if(mergeSize > N /2) {        
				break;
			}
			mergeSize <<= 1;
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}














