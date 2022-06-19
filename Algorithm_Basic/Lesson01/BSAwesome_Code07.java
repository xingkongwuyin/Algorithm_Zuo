package lesson01;
 // ����һ���������飬���������������㣬������Ԫ�ز���ȣ��ҳ�һ���ֲ���Сֵ
 // ��߽�ֵ��arr[0] < arr[1] ,��arr[0]��С
 // �ұ߽�ֵ��arr[N] < arr[N - 1],��arr[0]��С
 // ��arr[m-1] < arr[m] < arr[m + 1],��arr[m]����һ���ֲ���С 

public class BSAwesome_Code07 {

	// 1. getLessIndex
	public static int getLessIndex(int[] arr) {
		if(arr == null || arr.length == 0) {
			return -1;
		}
		if(arr.length == 1 || arr[0] < arr[1]) {
			return 0;
		}
	     if(arr[arr.length - 1] < arr[arr.length - 2]) {
			return arr.length - 1;
		}
	    int R = arr.length - 2;   // �ֲ���Сֵ����߽���ұ߽�֮�䣬�Ǿ������ұ߽��ҾͿ�����
	    int L = 1;
		while(L < R) {
			int mid = L + ((R - L) >> 1);
			if(arr[mid] > arr[mid + 1]) {
				L = mid + 1;
			}else if(arr[mid] > arr[mid - 1]) {
				R = mid - 1;
			}else {
				return mid;
			}
		}
		return L;
	}
	
	
	// 2. ������
	// 2.1 generateRandomArray
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int)(Math.random() * maxSize + 1)];
		arr[0] = (int)(Math.random() * maxValue) - (int)(Math.random() * maxValue);
		for(int i = 1; i < arr.length; i++) {
			do {
				arr[i] = (int)(Math.random() * maxValue) - (int)(Math.random() * maxValue);
			}while(arr[i] == arr[i - 1]);
		}
		return arr;
	}
	// 2.2 isRight �ж�����ľֲ���Сֵ�Ƿ���ȷ
	public static boolean isRight(int arr[], int ans) {
		if(arr.length <= 1) {
			return true;
		}
		if(ans == 0) {
			return arr[ans] < arr[ans + 1];
		}
		if(ans == arr.length - 1) {
			return arr[ans] < arr[ans - 1];
		}
		return arr[ans] < arr[ans - 1]  && arr[ans] < arr[ans + 1];
	}
	
	// 2.3 print ��ӡ����
	public static void print(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	
	// 2.4 test
	public static void main(String[] args) {
		int testTimes = 500000;
		int maxSize = 10;
		int maxValue = 100;
		
		System.out.println("test begin!");
		for(int i = 0; i < testTimes; i++){
			int[] arr = generateRandomArray(maxSize, maxValue);
		//	int[] arr = [77 -2 -75 -10 85 23 66 76 5 42 ];
				int ans = getLessIndex(arr);
				if(!isRight(arr, ans)){
					System.out.println("bad!");
					print(arr);
					break;	
				}
		}
	}

}

















