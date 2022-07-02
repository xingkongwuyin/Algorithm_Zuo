package lesson08;

public class Code02_CountSort {
	
	// only for finite scale
	public static void countSort(int[] arr) {
		
		if(arr == null || arr.length < 2) {
			return;
		}
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < arr.length; i++) {
			max = Math.max(max, arr[i]);
		}
		int[] bucket = new int[max + 1];
		for(int i = 0; i < arr.length; i++) {
			bucket[arr[i]]++;
		}
		int j = 0;
		for(int i = 0; i < bucket.length; i++) {
			while(bucket[i]-- > 0) {
				arr[j++] = i; 
			}
		}
	}
	
	public static void print(int[] arr) {
		for(int num : arr) {
			System.out.print(num + " ");
		}
	}
	public static void main(String[] args) {
		int[] arr = {2,3,1241324,12,45,26,536,65};
		countSort(arr);
		print(arr);

	}
}
