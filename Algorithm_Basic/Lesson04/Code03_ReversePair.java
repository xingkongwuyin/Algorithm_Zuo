package lesson04;

public class Code03_ReversePair {

	public static int reversePair(int[] arr) {
		if(arr == null || arr.length < 2) {
			return 0;
		}
		return process(arr, 0, arr.length - 1);
	}
	
	public static int process(int[] arr, int L , int R) {
		if(L == R) {
			return 0;
		}
		int M = L + ((R - L) >> 1);
		return process(arr, L, M) + 
			   process(arr, M + 1, R) + 
			   merge(arr, L, M, R);		   
	}
	
	public static int merge(int[] arr, int L, int M, int R) {
		int[] help = new int[R - L + 1];
		int i = arr.length - 1;
		int p1 = M;
		int p2 = R;
		int ans = 0;
		while(p1 >= L && p2 >= (M + 1)){
			ans += arr[p1] > arr[p2] ? (p2 - M) : 0;
		    help[i--] = arr[p1] > arr[p2] ? arr[p1--] : arr[p2--];
		}
		while(p1 >= L) {
			help[i--] = arr[p1--];
		}
		while(p2 >= M) {
			help[i--] = arr[p2--];
		}
		return ans;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
