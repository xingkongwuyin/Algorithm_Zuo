package Lesson08;
// 利用归并方法排序
public class MergerSort1 {

	// 1. 递归方法实现
	public static void mergeSort1(int[] arr) {
		if(arr == null && arr ==null) {
			return ;
		}
		process(arr, 0, arr.length - 1);
	}
	
	// 2. process
	public static void process(int[] arr, int L, int R) {
		if(L == R) {
			return ;
		}
		int mid = L + (R - L) >> 1;   // mid = (L + R) / 2   之所以那么写，是为了防止L + R过界
		process(arr, L, mid);
		process(arr, mid + 1, R);
		merge(arr, L, mid ,R);
	}
	
	// 3. merge
	public static void merge(int[] arr, int L, int M, int R) {
		int[] tmp = new int[L + R - 1];
		int i = 0;
		int p1 = L;
		int p2 = M + 1;
		while(p1 <= M && p2 <= R) {
			tmp[i++] = arr[L] > arr[R] ? arr[R++] : arr[L++];
		}
		
		// 要么p1越界，要么p2越界
		while(p1 <= M) {
			tmp[i++] = arr[p1++];
		}
		while(p2 <= M) {
			tmp[i++] = arr[p2++];
		}
		for( i = 0; i < L + R - 1; i++) {
			arr[L + i] = tmp[i++];
		}
		
		
		// for test
		public static int[] generateRandomArray(int maxSize, int maxValue) {
			int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
			for (int i = 0; i < arr1.length; i++) {
				arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
			}
			return arr;
		}

		// for test
		public static int[] copyArray(int[] arr) {
			if (arr == null) {
				return null;
			}
			int[] res = new int[arr.length];
			for (int i = 0; i < arr.length; i++) {
				res[i] = arr[i];
			}
			return res;
		}

		// for test
		public static boolean isEqual(int[] arr1, int[] arr2) {
			if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
				return false;
			}
			if (arr1 == null && arr2 == null) {
				return true;
			}
			if (arr1.length != arr2.length) {
				return false;
			}
			for (int i = 0; i < arr1.length; i++) {
				if (arr1[i] != arr2[i]) {
					return false;
				}
			}
			return true;
		}

		// for test
		public static void printArray(int[] arr) {
			if (arr == null) {
				return;
			}
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}

		// for test
		public static void main(String[] args) {
			int testTime = 500000;
			int maxSize = 100;
			int maxValue = 100;
			System.out.println("测试开始");
			for (int i = 0; i < testTime; i++) {
				int[] arr1 = generateRandomArray(maxSize, maxValue);
				int[] arr2 = copyArray(arr1);
				mergeSort1(arr1);
				mergeSort2(arr2);
				if (!isEqual(arr1, arr2)) {
					System.out.println("出错了！");
					printArray(arr1);
					printArray(arr2);
					break;
				}
			}
			System.out.println("测试结束");
		}	
	}
	
	

}
