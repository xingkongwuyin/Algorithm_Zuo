package lesson06;

import java.util.PriorityQueue;

public class Code04_SortArrayDistanceLessK {
	
	public static void sortArrayDistanceLessK(int[] arr, int k){
		
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		
		// 添加[0 k - 1]范围的数进去
		int index = 0;
		for(; index <= Math.min(arr.length - 1, k - 1); index++) {
			heap.add(arr[index]);
		}
		int i = 0;
		for(; index < arr.length; index++, i++) {
			heap.add(arr[index]);
			arr[i] = heap.poll();
		}
		while(!heap.isEmpty()) {
			arr[i++] = heap.poll();
		}
		
	}
	
	public static void printArray(int[] arr) {
		for(int num : arr) {
			System.out.print(num + " ");
		}
	}
	
}
