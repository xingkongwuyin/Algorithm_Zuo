package lesson04;

public class Code04_BiggerThanRightTwice {

	public static int biggerThanRightTwice(int[] arr) {
		if(arr == null || arr.length < 2) {
			return 0;
		}
		return process(arr, 0, arr.length -1);
	}
	
	public static int process(int[] arr, int L, int R) {
		if(L == R) {
			return 0;
		}
		int M = L + ((R - L) >> 1);
		return process(arr, L, M) +
			   process(arr, M + 1, R) + 
			   merge(arr, L, M, R);
	}
	
	public static int merge(int[] arr, int L, int M, int R) {
		int[] help = new int[R + L - 1];
		int  i = 0;
		int p1 = L;
		int p2 = M + 1;
		int ans = 0;
		int windowR = M + 1;
		
		for(i = L; i <= M ; i++) {
			while(windowR <= R && (arr[windowR] * 2 < arr[i]) ) {
				windowR++;
			}
			ans += windowR - M - 1;
		}
		while(p1 <= M && p2 <= R) {
			help[i++] = arr[p1] < arr[p2] ? arr[p1] :arr[p2];
		}
		while(p1 <= M) {
			help[i++] = arr[p1++];
		}
		while(p2 <= R) {
			help[i++] = arr[p2++];
		}
		return ans;	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
