package Lesson03;

public class BSAswsome {

// 1. 构建任意数组，相邻元素不相等
public static int[] randomArray(int MaxLen, int MaxValue) {
	int Len = (int)(Math.random() * MaxLen);
	int[] arr = new int[Len];
	if(Len > 0) {
		arr[0] = (int)(Math.random() * MaxValue);
		for(int i = 1; i < Len; i++) {
		    do {
			arr[i] = (int)(Math.random() * MaxValue);
		}while(arr[i] == arr[i - 1]);                  // 当创建的元素和上一个元素相等时，再返回重新生成
	   }
	}
	return arr;
}

// 2. 找出一个数组中局部最小值
public static int OneMinIndex(int[] arr) {
	if(null == arr || 0 == arr.length) {
		return -1;
	}
	int N = arr.length;
	if( 1 == N) {
		return 0;
	}
	if( arr[0] < arr[1]) {
		return 0;
	}
	if(arr[N - 1] < arr[N -2])
	{
		return N - 1;
	}
	int L = 0;
	int R = N - 1;
	while(L < R - 1) {
		int mid = (L + R) / 2;
		if(arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]) {
			return mid;
		}
		else {
			if(arr[mid] > arr[mid - 1]){
			   R = mid -1;
			}
		   else {
			   L = mid + 1;
		  }
	   }
	}
	return arr[L] < arr [R] ? L : R;
}

// 3. 检查的得出的局部最小值是否正确
public static boolean check(int[] arr, int MinIndex) {
	if(arr.length == 0) {
		return MinIndex == -1;
	}
	int L = MinIndex - 1;
	int R = MinIndex + 1;
	boolean LeftBigger = L >= 0 ? arr[L] > arr[MinIndex] : true; 
    boolean RightBigger = R < arr.length ? arr[R] > arr[MinIndex] :true;
    return LeftBigger &&  RightBigger;
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
	int MaxLen = 10;
	int MaxValue = 100;
	int TestTimes = 10000;
	
	System.out.println("Test begin!!!");
	for(int i = 0; i < TestTimes; i++) {
		int[] arr = randomArray(MaxLen,MaxValue);
		int ans = OneMinIndex(arr);
		if(!check(arr,ans)) {
			PrintArray(arr);
			System.out.println(ans);
			break;
		}
	}
	System.out.println("The test end!!!");		

	}

}
