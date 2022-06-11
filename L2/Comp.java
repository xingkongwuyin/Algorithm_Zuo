package code_primary;

public class Comp {

	// 1. 创建随机数组,len范围为[0 MaxLen-1],arr中每个值的在[0 MaxValue-1]
	public static int[] LenRandValueRand(int MaxLen, int MaxValue) {
		int len = (int)(Math.random() * MaxLen);
		int[] arr = new int[len];
		for(int i = 0; i < len; i++)
		{
			arr[i] = (int)(Math.random()*MaxValue);
		}
		return arr;
	}
	
    // 2. copy数组
	public static int[] Copy(int[] arr) {
		int[] tmp = new int[arr.length];
		for(int i =0; i < arr.length; i++)
		{
			tmp[i] = arr[i];
		}
		return tmp;
	}
	
	// 3. 插入排序
	public static void InsertSort(int[] arr)  {
		
		for(int i = 1; i < arr.length; i++) {
			for(int pre = i -1; pre >= 0 && arr[pre] > arr[pre +1]; pre--)
			{
				int tmp = arr[pre];
				arr[pre] = arr[pre + 1];
				arr[pre + 1] = tmp;
			}
		}
					
	}
	
	// 4. 检测排序是否正确
	public static boolean IsSort(int[] arr) {
		if(arr.length < 2) {
			return true; 
		}
		for(int i = 0; i < arr.length - 1; i++) {
			if(arr[i] > arr[i + 1]) {
				return false;
			}
		}
		return true;
	}
	

	// 5. 测试每一次排序是否正确
	public static void main(String[] args) {
		int MaxLen = 10;
		int MaxValue = 1000;
		int TsetTimes = 10000;
		for(int i = 0; i < TsetTimes; i++) {
			int[] arr = LenRandValueRand(MaxLen, MaxValue);
			int[] tmp = Copy(arr);
			InsertSort(arr);
			if(!IsSort(arr)) {
				
				for(int j = 0; j < tmp.length; j++) {
					System.out.println(arr[i] + " ");
				}
				System.out.println(" ");
				System.out.println("the sort is Wrong!");
				break;
			}
			
		}
		System.out.println("this sorted method is correct!");
	}

}


























