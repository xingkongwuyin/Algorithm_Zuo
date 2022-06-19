package Lesson01;
// Selection Sort
public class Code01_SelectionSort {
     // 1. selectionSort
	public static void selectionSort(int[] arr) {
		if(arr == null || arr.length <=2) {
			return;
		}
		for(int i = 0; i < arr.length - 1; i++) {
			int min = i;
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[min] > arr[j]) {
					min = j;
				}
				swap(arr, min, i);
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
