1. > * Question :
   >
   >   > + 给定一个无序数组，有整数、负数和零，且相邻元素不相等，找出一个局部最小值
   >   > + 左边界值若arr[0] < arr[1] ,则arr[0]最小
   >   > +  右边界值若arr[N] < arr[N - 1],则arr[0]最小
   >   > + 若arr[m-1] < arr[m] < arr[m + 1],则arr[m]就是一个局部最小 
   >
   > * Analysis：
   >
   >   > 如果一个数组arr,arr[0]和arr[arr.length - 1]都比相邻的元素大，即下图所示，那么在两者之间必有一个局部最小值，那么就用二分查找去找
   >   >
   >   > ![image-20220619091420121](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202206190914165.png)
   >
   > * Solution
   >
   >   > （1）先判断是否数组是否有效，是否为空
   >   >
   >   > （2）数组元素为1的时候，返回下标值
   >   >
   >   > （3）数组元素为2的时候，看数组的左边界和右边界哪个符合条件，就返回哪个。  
   >   >
   >   > （4）左右边界的元素都大于相邻元素，所以在左右边界之间必存在一个局部最小值，
   >   >
   >   > ​          采用二分查找去找。 因为数组元素相邻不相等，所以第三步就把数组长度为2的数组       
   >   >
   >   > ​          和数组长度大于2的数组中符合条件的找完了，剩下就是数组长度大于2的且左右
   >   >
   >   > ​         边界都大于相邻值的数组。为什么强调数组长度，因为由下面的数组可以看到，如果
   >   >
   >   > ​        如果数组的长度等于2，arr[mid - 1]就会溢出，所以要先把数组长度为2的数组找完。
   >   >
   >   > ​        先把数组长度为2的数组找完还有一个好处就是，最后只剩下左右边界都大于相邻元素
   >   >
   >   > ​         的数组，那么就容易去找中间元素了。          
   >
   > * Code
   >
   >   ```java
   >   public static int getLessIndex(int[] arr) {
   >   		if(arr == null || arr.length == 0) {
   >   			return -1;
   >   		}
   >   		if(arr.length == 1 || arr[0] < arr[1]) {
   >   			return 0;
   >   		}
   >   	     if(arr[arr.length - 1] < arr[arr.length - 2]) {
   >   			return arr.length - 1;
   >   		}
   >   	    int R = arr.length - 2;                 // （1）
   >   	    int L = 1;                      
   >   		while(L <= R) {
   >   			int mid = L + ((R - L) >> 1);       // （2）
   >          //   int mid = L + ((R - L) >> 2);       错误
   >   			if(arr[mid] > arr[mid + 1]) {
   >   				L = mid + 1;
   >   			}else if(arr[mid] > arr[mid - 1]) {
   >   				R = mid - 1;
   >   			}else {
   >   				return mid;
   >   			}
   >   		}
   >   		return -1;                             //  （3）
   >   	}
   >   // 注意
   >   // （1） 因为确定是在左右边界直接，那就去arr[1]和arr[arr.length - 2]之间
   >   //      找，而不是arr[0]和arr[arr.length - 1]之间找。二分查找是在要查找
   >   //      的元素之间。arr[0]和arr[arr.length - 1]明显不是，如果是的话，那
   >   //      就会在第二步的时候被返回。
   >   // （2） mid = (L + R) / 2  = L + (R - L) >> 1,因为怕（L + R）溢出所
   >   //      以用位运算，右移一位等同于除以2，我之前就写错了，除以2，就是左移2位
   >   // （3） 最后必须要返回一个值，在while里面已经有返回值了，为什么最后一定要
   >   //      返回一个值，是怕while返回不了吗，但我最后随便返回一个数，最后的都是
   >   //      正确，这个问题后面再去研究吧
   >   ```

2. > * Qusetion:
   >
   >   > 有序数组中>= num最左的位置
   >
   > * Analysis
   >
   >   > （1）第一次找到num，不能保证num左边没有更小的下标，所以第一次找到后
   >   >
   >   > ​          再去num左边去找
   >   >
   >   > （2） 对于arr[mid]来说只有>= 和 <两种情况，第一种情况已经讨论，如果arr[mid] 
   >   >
   >   > ​           < num,那么就去mid右边找  
   >   >
   >   > ==找是用二分查找，只不过找到了之后，再去左边找==
   >
   > * Code
   >
   >   ```java
   >   public static int nearestIndex(int[] arr, int num) {
   >   		if(arr == null || arr.length <= 0) {
   >   			return -1;
   >   		}
   >   		int index = -1;
   >   		int L = 0;
   >   		int R = arr.length - 1;
   >   		while(L <= R) {
   >   			int mid = (L + R) /2;
   >   			if(arr[mid] >= num) {
   >   				index = mid;
   >   				R = mid - 1;
   >   			}else {
   >   				L = mid + 1;
   >   			}	
   >   		}
   >   		return index;
   >   		
   >   	}
   >   
   >   
   >   // 2. 对数器
   >   	// 2.1 generateRandomArray
   >   	public static int[] generateRandomArray(int maxSize, int maxValue) {
   >   		int[] arr = new int[(int)(Math.random() * (maxSize  + 1))];
   >   		for(int i = 0; i < arr.length; i++) {
   >   			arr[i] = (int)(Math.random() * (maxValue + 1)) - (int)(Math.random() * maxValue);
   >   		}
   >   		return arr;
   >   	}
   >   	
   >   	// 2.2 test
   >   	public static int test(int[] arr, int num) {
   >   		if(arr == null || arr.length <= 0) {
   >   			return -1;
   >   		}
   >   		for(int i = 0; i < arr.length; i++) {
   >   			if(arr[i] >= num) {
   >   				return i;
   >   			}
   >   		}
   >   		return -1;
   >   		
   >   	}
   >   	
   >   	// printArray
   >   	public static void printArray(int[] arr) {
   >   		for(int i = 0; i < arr.length; i++) {
   >   			System.out.println(arr[i] + " ");
   >   		}
   >   	}
   >   		
   >   	public static void main(String[] args) {
   >   		int testTimes = 10000000;
   >   		int maxSize = 10;
   >   		int maxValue = 100;
   >   		boolean succeed = true;
   >   		for(int i = 0; i < testTimes; i++) {
   >   			int[] arr = generateRandomArray(maxSize, maxValue);
   >   			Arrays.sort(arr);
   >   			int num = (int)(Math.random() * (maxValue + 1)) - (int)(Math.random() * maxValue);
   >   			if(test(arr, num) != nearestIndex(arr, num)) {
   >   				printArray(arr);
   >   				System.out.println(num);
   >   				System.out.println(test(arr, num));
   >   				System.out.println(nearestIndex(arr, num));
   >   				succeed = false;
   >   		        break;
   >   			}
   >   		}
   >   		System.out.println(succeed ? "nice!" :"Bad");
   >   	}
   >   
   >   ```
   >
   >   