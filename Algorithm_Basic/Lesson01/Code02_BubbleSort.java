package Lesson01;

// BubbleSort

public class Code02_BubbleSort {
	
	// 1. bubbleSort
	public static void bubbleSort(int[] arr) {
		if(arr == null || arr.length <=2) {
			return;
		}
		for(int i = 0; i < arr.length - 1; i++) {
		int flag = 1;
		for(int j = 0; i < arr.length -1 -i; j++) {
			if(arr[j] > arr[j + 1]) {
				flag = 0;
				swap(arr, j , j + 1);
			}
		}
		if(flag == 1) {
			break;
		}
	}
}
	// 2. swap
	public static void swap(int[] arr, int i , int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
