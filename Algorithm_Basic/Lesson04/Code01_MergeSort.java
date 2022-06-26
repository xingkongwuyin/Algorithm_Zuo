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
	public static void process(int[]arr, int L, int R) {
		if(L == R) {
			return ;
		}
		int mid = L  + ((R - L)>> 1);
		process(arr, L, mid);
		process(arr,mid + 1, R);
		merge(arr, L, mid, R);
	}
	public static void merge(int[] arr, int L, int mid, int R) {
		int[] help = new int[R - L + 1];
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
	public static void mergeSort2(int[] arr) {
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
	
	public static void print(int[] arr) {
		for(int num : arr) {
			System.out.println(num + " " );
		}
	}
	public static boolean check(int[] arr1, int[] arr2) {
		boolean ans = true;
		if(arr1 == null || arr2 == null) {
			return false;
		}
		if(arr1.length != arr2.length) {
			return false;
		}
		for(int i = 0; i < arr1.length; i++) {
			if(arr1[i] != arr2[i]) {
				return false;
			}
		}
		return ans;
	}
	
	public static int[] generateRandomArray(int maxLen, int maxValue) {
		int len = (int)(Math.random() * (maxLen + 1)); // [0 maxLen]
		int[] arr = new int[len];
		for(int  i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * (maxValue + 1)) - (int)(Math.random() * (maxValue + 1));
		}
		return arr;
	}
	
	public static void main(String[] args) {
		int maxValue = 100;
		int maxLen = 100;
		int testTimes = 10000;
		System.out.println("test begins!");
		int i = 0;
		for (i = 0; i < testTimes; i++) {
			int[] arr = generateRandomArray(maxLen, maxValue);
			int[] tmp1 = arr;
			//print(tmp1);
			//System.out.println(" ");
			int[] tmp2 = arr;
			//print(tmp2);
			//System.out.println(" ");
			mergeSort1(tmp1);
			mergeSort2(tmp2);

			if (!check(tmp1, tmp2)) {
				print(arr);
				System.out.println("bad!");
				break;
			}
		}
		System.out.println("end!");
	}

}
















