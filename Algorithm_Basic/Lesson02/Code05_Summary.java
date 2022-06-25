package lesson02;

public class Code05_Summary {

	// 1.swap
	public static void swap(int[] arr, int i, int j) {
		arr[i] = arr[i] ^ arr[j];
		arr[j] = arr[i] ^ arr[j];
		arr[i] = arr[i] ^ arr[j];
	}
	
	// 2. EvenTimesOddTimes1
	public static int evenTimesOddTimes1(int[] arr) {
		int eor = 0;
		for(int num : arr) {
			eor ^= num;
		}
		return  eor;
	}
	
	// 3. evenTimesOddTimes
	public static void evenTimesOddTimes2(int[] arr, int k, int m) {
		int eor = 0;
		for(int num : arr) {
			eor ^= num;
		}
		int mostRight = eor & (-eor);
		int onlyNum = 0;
		for(int num : arr) {
			if((num & mostRight) != 0) {
				onlyNum ^= num;
			}
		}
		System.out.println("num1 = " + eor + " num2 = " + (eor ^ onlyNum) );	
	}
	
	// 4. KM
	public static int KM(int[] arr, int k, int m) {
		int[] help = new int[32];
		for(int num : arr) {
			for(int i = 0; i < 32; i++) {
				help[i] += ((num >> i) & 1);
			}
		}
		int ans = 0;
		for(int i = 0; i < 32; i++) {
			help[i] %= m;
			if(help[i] != 0) {
				ans |= (1 << i);
			}
		}
		return ans;		
	}
	
	// 5. isKM
	public static int isKM(int[] arr, int k, int m) {
		int[] help = new int[32];
		for(int num : arr) {
			for(int i = 0; i < 32; i++) {
				help[i] += ((num >> i) & 1);
			}
		}
		int ans = 0;
		for(int i = 0; i < 32; i++) {
			if(help[i] % m == 0) {
				continue;
			}
			if(help[i] % m == k) {
				ans |= (1 << i);
			}else {
				return -1;
			}
		}
		if(0 == ans) {
			int count = 0;
			for(int num : arr) {
				if(0 == num) {
					count++;
				}
			}
			if(count != k) {
				return -1;
			}
		}
		return ans;		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

















