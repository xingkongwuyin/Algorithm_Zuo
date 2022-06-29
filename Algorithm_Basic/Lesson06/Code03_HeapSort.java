package lesson06;

public class Code03_HeapSort {
	
		 // 堆排序的额外空间复杂度为O(1) 
	public static void heapSort(int[] arr) {
	
		// 第一种建立大根堆方式(经典)从上往下排 时间复杂度为O(N * logN)
		// 这种方式既适用于数据一次给完的情况，也适合数据一次一次给的情况
		for(int i = 0; i < arr.length; i++) {
			heapInsert(arr, i);
		}
		// 第二种建立大根堆的方式 从下往上排  时间复杂度(logN)
		// 只适用于数据一次性全部给完的情况
		for(int i = arr.length - 1; i >=0; i--) {
			heapify(arr, i, arr.length);
		}
		
		int heapSize = arr.length;
		swap(arr, 0, --heapSize);
		while(heapSize > 0) {
			heapify(arr, 0, heapSize);
			swap(arr, 0, --heapSize);
		}
		
	}
	
	// 2. heapInsert
	public static void heapInsert(int[] arr, int index) {
		int left = (index - 1) / 2;
		
		// 第一种比较方式
		while(arr[index] > arr[left]) {
			swap(arr, index, left);
			index = left;
			left = (index - 1) / 2; 
		}
		
		// 第二种比较方式，选一种即可
		while(left >= 0) {
			if(arr[index] > arr[left]) {
				swap(arr, index, left);
			}else {
				break;
			}
		}
		index = left;
		left = (index - 1) / 2;
	}
	
	// 3. heapify
	public static void heapify(int[] arr, int index, int heapSize) {
		int left = (2 * index) + 1;
		while(left <= heapSize - 1) {
			int largest = (left + 1) <= heapSize - 1 && arr[left] < arr[left + 1] ?  (left + 1) : left;
			if(arr[largest] > arr[index]) {
				break;
			}
			swap(arr, index, largest);
			index = largest;
			left = (2 * index) + 1;
		}						
	}
	 
    // 4. swap
	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
