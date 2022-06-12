package Lesson03;
// Question:
// 给定一个有序整数数组（升序），和一个整数num,找出>=num最左的位置


public class LeftMost {

// 1. 构建任意数组
public static int[] randomArray(int MaxLen, int MaxValue) {
	int Len = (int)(Math.random() * MaxLen);
	int[] arr = new int[Len];
	if(Len > 0) {
		arr[0] = (int)(Math.random() * MaxValue);
		for(int i = 1; i < Len; i++) {
		    do {
			arr[i] = (int)(Math.random() * MaxValue);
		}while(arr[i] < arr[i - 1]);                  // 当创建的元素和上一个元素相等时，再返回重新生成
	   }
	}
	return arr;
}
	
// 2. 找出>=num最左的位置	
public static int MinLeftIndex(int[] arr, int num) {
	if(arr == null || arr.length == 0) {
		return -1;
	}
	int Len = arr.length;
	int tag = Len;
	int L = 0;
	int R = Len - 1;
	while(L <= R) {
		int mid = (L + R) / 2;
		if(arr[mid] >= num) {
			R = mid - 1;
			tag = mid;
		}
		else {
			L = mid + 1;
		}
	}
   return tag;	
}
	
// 3. 检测位置是否正确	
public static boolean check(int[] arr, int num, int ans) {
	if(arr == null || arr.length == 0) {
		if(-1 == ans) {
			return true;
		}
	}
	int Len = arr.length;
	int ANS = Len;
	for(int i = 0; i < Len; i++) {
		if(num <= arr[i]) {
			ANS = i;
			break;
		}
	}
	if(ANS == ans) {
		return true;
	}else {
		return false;
	}	
}	
	
// 4. 打印数组
public static void PrintArray(int[] arr) {
	for(int num : arr) {
		System.out.println(num + " ");
	}
	System.out.println();
}	

// 5. 测试
public static void main(String[] args) {
	int num = 5;
	int MaxLen = 10;
	int MaxValue = 100;
	int TestTimes = 10000;
	
	System.out.println("Test begin!!!");
	for(int i = 0; i < TestTimes; i++) {
		int[] arr = randomArray(MaxLen,MaxValue);
		int ans = MinLeftIndex(arr, num);
		if(!check(arr,num,ans)) {
			PrintArray(arr);
			System.out.println(ans + " " + num);
			break;
		}
	}
	System.out.println("The test end!!!");		

		}

	}


