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
		return process(arr, L, M) 
				+ 
			   process(arr, M + 1, R) 
				+ 
			   merge2(arr, L, M, R);		   
	}
	
	public static int merge1(int[] arr, int L, int M, int R) {
		int[] help = new int[R - L + 1];
	//  int i = arr.length - 1;  bad!  
		int i = (help.length - 1);
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
	// 	while(p2 >= M);  bad!
		while(p2 >= (M + 1)) {  
			help[i--] = arr[p2--];
		}
		for(i = 0; i < help.length; i++) {
			arr[L + i] = help[i];
		}
		return ans;
	}
	
	public static int merge2(int[] arr, int L, int M, int R) {
		int ans = 0;
		int windowsR = M + 1;
	//	for(int j = 0; j <= M; j++) {  bad!
		for(int j = L; j <= M; j++) {
			while(windowsR <= R && arr[windowsR] < arr[j]) {
				windowsR++;
			}
			ans += windowsR - M - 1;
		}
		
		int[] help = new int[R - L + 1];
		int i = 0;
		int p1 = L;
		int p2 = M + 1;
		while(p1 <= M && p2 <= R){
			help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		}
		while(p1 <= M) {
			help[i++] = arr[p1++];
		}
		while(p2 <= R) {
			help[i++] = arr[p2++];
		}
		
	//	for(i = 0; i < arr.length; i++) {  bad!
		for(i = 0; i < help.length; i++) {  
			arr[L + i] = help[i];
		}
		return ans;
	}
	
	
	public static void main(String[] args) {
		int[] arr = {3, 2, 1, 2, 2, 6};
		int ans = reversePair(arr);
		
		System.out.println(ans);
	}

}
