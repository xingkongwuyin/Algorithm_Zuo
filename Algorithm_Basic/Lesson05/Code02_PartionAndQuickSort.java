package lesson05;

public class Code02_PartionAndQuickSort {
	
	public static void swap(int[] arr, int L, int R) {
		int tmp = arr[L];
		arr[L] = arr[R];
		arr[R] = tmp;
	}
	
	// arr[L R]上，以arr[R]位置的数做划分指
	// <= 画出小于等于arr[R]的区域
	public static int partition(int[] arr, int L, int R) {
		if(L > R) {
			return -1;
		}
		if(L == R) {
			return L;
		}
		int lessL = L - 1;
		int index = L;
		while(index < R) {
			if(arr[index] <= arr[R]) {
				swap(arr, index, ++lessL);
			}
			index++;
		}
		swap(arr, R,++lessL);
		return lessL;
	}
	
	// arr[L R]荷兰国旗的划分
	// <arr[R] ==arr[R] >arr[R]
	// 返回等于区域的左右边界
	public static int[] netherlandsFlag(int[] arr, int L, int R) {
		if(L > R) {
			return new int[]{-1, -1};
		}
		if(L == R) {
			return new int[] {L, L};
		}
		int lessL = L -1;
		int moreR = R;
		int index = L;
		while(index < moreR) {
			if(arr[index] < arr[R]) {
				swap(arr, index++, ++lessL);
			}
			if(arr[index] > arr[R]) {
				swap(arr, index, --moreR);
			}
			if(arr[index] == arr[R]) {
				index++;
			}
		}
		swap(arr, R, moreR);
		return new int[] {lessL + 1, moreR};
	}
	
	// 去重数组
	public static void qiucksort1(int[] arr) {
		if(arr == null || arr.length <= 1) {
			return;
		}
		process1(arr, 0, arr.length - 1);
	}
	
	public static void process1(int[] arr, int L, int R) {
		if(L >= R) {
			return;
		}
		int M = partition(arr, L, R);
		process1(arr, L, M - 1);
		process1(arr, M + 1, R);
	}
	
	// 非去重数组
	public static void quicksort2(int[] arr) {
		if(arr == null || arr.length <= 1) {
			return;
		}
		process2(arr, 0, arr.length - 1);
	}
	public static void process2(int[] arr, int L, int R) {
		if(L >= R) {
			return;
		}
		int[] help = netherlandsFlag(arr, L , R);
		process2(arr, L, help[0] - 1);
		process2(arr, help[1] + 1, R);
	} 
	
	// 随机快排
	public static void quickSort3(int[] arr) {
		if(arr == null || arr.length <= 1) {
			return;
		}
		process3(arr, 0, arr.length - 1);
	}
	
	public static void process3(int[] arr, int L, int R) {
		if(L >= R) {
			return;
		}
		int num = (int)(Math.random() * (R - L + 1));
		swap(arr, (L + num), R);
		int[] euqalArea = netherlandsFlag(arr, L, R);
		process3(arr, L, euqalArea[0] - 1);
		process3(arr, euqalArea[1] + 1, R);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
