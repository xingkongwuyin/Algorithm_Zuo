package lesson06;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Code02_Heap {
	
	   // construct maxHeap class
	public static class MyMaxheap{
		private int[] heap;
		private final int limit;
		private int heapSize;
		
		// 1. constructor
		public MyMaxheap(int limit) {
			heap = new int[limit];
			this.limit = limit;
			heapSize = 0;
		}
		
		// 2. judge whether is empty
		public boolean isEmpty() {
			return heapSize == 0;
		}
		
		// 3. judge whether is full
		public boolean isFull() {
			return heapSize == limit;
		}
		
		// 4. push element
		public void push(int value) {
			if(heapSize == limit) {
				throw new RuntimeException("heap is full");
			}
			heap[heapSize] = value;
			heapInsert(heap, heapSize++);
		}
		
		// 5. pop element
		public int pop() {
			if(heapSize == 0) {
				throw new RuntimeException("the heap is empty");
			}
			int ans = heap[0];
			swap(heap, 0, --heapSize);
			heapify(heap, 0, heapSize);
			return ans;
		}
	
		// 6. 新加上来的数落在了index的位置，请依往上移动
		//    剩下的数依然保持大根堆组织
		private void heapInsert(int[] arr, int index) {
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
		
		// 7. 从index位置，往下看，不断的下沉
		//    较大的孩子都不再比index位置的数大，停！
		private void heapify(int[] arr, int index, int heapSize) {
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
		 
	// 8. swap
		private void swap(int[] arr, int i, int j) {
			int tmp = arr[i];
			arr[i] = arr[j];
			arr[j] = tmp;
		}
	}
	
	// 9. the constructor changing maxheap to minheap
	public static class MyComparator implements Comparator<Integer>{
		
		public int compare(Integer o1, Integer o2) {
			return o2 - o1;
		}
	}
	
	// 10. test
	public static void main(String[] args) {
		
		// 系统默认小根堆
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		heap.add(3);
		heap.add(7);
		heap.add(4);
		heap.add(6);
		
		//System.out.println(heap.poll());
		
		// 由小根堆改写大根堆：添加自定义的构造器
		PriorityQueue<Integer> heap1 = new PriorityQueue<Integer>(new MyComparator());
		heap1.add(3);
		heap1.add(7);
		heap1.add(7);
		heap1.add(6);
		
//		System.out.println(heap1.peek());
		while(!heap1.isEmpty()){
			System.out.println(heap1.poll());
		}

	}

}
































