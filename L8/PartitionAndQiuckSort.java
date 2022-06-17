package Lesson08;

public class PartitionAndQiuckSort {
	
	
	// 1. splitNum1
	public static void splitNum1(int[] arr) {
		int lessEqualR = -1;
		int index = 0;
		int N = arr.length;
		
		while(index < N) {
			if(arr[index] <= arr[N - 1]) {
				swap(arr, ++lessEqualR, index);
			}else {
				index++;
			}
		}
	}

	
	// 2. splitNum2
	public static void splitNum2(int[] arr) {
		int N = arr.length;
		int lessR = -1;
		int moreL = N - 1;
		int index = 0;
		
		while(index < moreL) {
			if(arr[index] <= arr[N - 1]) {
				swap(arr, ++lessR, index++);
			}else if(arr[index] >= arr[N - 1]) {
				swap(arr, --moreL, index);
			}else{
				index++;
			}
			swap(arr, index, moreL);
		}
	}
	
	// 3. swap
	public static void swap(int[] arr, int L, int R) {
		  int tmp = arr[L];
			arr[L] = arr[R];
			arr[R] = tmp;
		}
	
	// 4. partition
	public static int[] patition(int[] arr, int L, int R) {
		int lessR = L -1;
		int moreL = R ;
		int index = L;
		
		while(index < moreL) {
			if(arr[index] <= arr[R]) {
				swap(arr, ++lessR, index++);
			}else if(arr[index] >= arr[R]) {
				swap(arr, --moreL, index);
			}else{
				index++;
			}
		}
		swap(arr, index, moreL);
		return new int[] { lessR + 1, moreL };
	
	}
	
	
   // 5. quciksort
   public static void quickSort(int[] arr) {
	   if(arr == null && arr.length < 2) {
		   return;
	   }
	   process(arr, 0, arr.length);
   }  
   
   // 6. process
   public static void process(int[] arr, int L, int R) {
	   if(L >= R) {
		   return;
	   }
	   
	   int[] equal = patition(arr, L, R);
	   process(arr, L ,equal[0]);
	   process(arr, equal[1], R);
   }
	
	
	
}
