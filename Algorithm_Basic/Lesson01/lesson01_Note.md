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

2. > * Qusetion01:
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
   >     // 2. 对数器
   >     	// 2.1 generateRandomArray
   >     	public static int[] generateRandomArray(int maxSize, int maxValue) {
   >     		int[] arr = new int[(int)(Math.random() * (maxSize  + 1))];
   >     		for(int i = 0; i < arr.length; i++) {
   >     			arr[i] = (int)(Math.random() * (maxValue + 1)) - (int)(Math.random() * maxValue);
   >     		}
   >     		return arr;
   >     	}
   >   // 2.2 test
   >   public static int test(int[] arr, int num) {
   >   	if(arr == null || arr.length <= 0) {
   >   		return -1;
   >   	}
   >   	for(int i = 0; i < arr.length; i++) {
   >   		if(arr[i] >= num) {
   >   			return i;
   >   		}
   >   	}
   >   	return -1;
   >   
   >   }
   >   
   >   // printArray
   >   public static void printArray(int[] arr) {
   >       for(int i = 0; i < arr.length; i++) {
   >           System.out.println(arr[i] + " ");
   >       }
   >   }
   >   
   >   public static void main(String[] args) {
   >       int testTimes = 10000000;
   >       int maxSize = 10;
   >       int maxValue = 100;
   >       boolean succeed = true;
   >       for(int i = 0; i < testTimes; i++) {
   >           int[] arr = generateRandomArray(maxSize, maxValue);
   >           Arrays.sort(arr);
   >           int num = (int)(Math.random() * (maxValue + 1)) - (int)       (Math.random() * maxValue);
   >           if(test(arr, num) != nearestIndex(arr, num)) {
   >               printArray(arr);
   >               System.out.println(num);
   >               System.out.println(test(arr, num));
   >               System.out.println(nearestIndex(arr, num));
   >               succeed = false;
   >               break;
   >           }
   >       }
   >       System.out.println(succeed ? "nice!" :"Bad");
   >   }
   >
   > * Question02:
   >
   >   > 有序数组<=num的最右位置
   >
   > * Code
   >
   >   ```java
   >   package Lesson01;
   >   import java.util.Arrays;
   >   // 有序数组中<= num最右的位置
   >       
   >   public class BSNearR_Code06 {
   >       
   >   	// 1. nearestIndex
   >   	public static int nearestIndex(int[] arr, int num) {
   >   		if(arr == null || arr.length <= 0) {
   >   			return -1;
   >   		}
   >   		int index = -1;
   >   		int L = 0;
   >   		int R = arr.length - 1;
   >   		while(L <= R) {
   >   			int mid = (L + R) /2;
   >   			if(arr[mid] <= num) {
   >   // ---------------不同之处--------------------------------------------		
   >                   index = mid;
   >   				L = mid + 1;
   >   			}else {
   >   				R = mid - 1;
   >   			}
   >   // ------------------------------------------------------------------           		}
   >   		return index;
   >   	}
   >   	
   >   	
   >   	
   >   	// 2.2 test
   >   	      public static int test(int[] arr, int num) {
   >   		if(arr == null || arr.length <= 0) {
   >   			return -1;
   >   		}
   >    // ------------- 不同之处 ---------------------------------------------     
   >   		for(int i = arr.length - 1; i >= 0; i--) {
   >   			if(arr[i] <= num) {
   >   				return i;
   >   			}
   >   // --------------------------------------------------------------------     
   >   		}
   >   		return -1;
   >   		
   >   	}
   >   	
   >   	
   >   ```

3. > * Question:
   >
   >   二分查找
   >
   > * Code
   >
   >   ```java
   >   package Lesson01;
   >   import java.util.Arrays;
   >       
   >   public class BSExist_Code04 {
   >       
   >   	// 1. exist
   >   	public static boolean exist(int[] arr, int num) {
   >   		if(arr == null || arr.length == 0) {
   >   			return false;
   >   		}
   >   		int left = 0;
   >   		int right = arr.length - 1;
   >   		while(left <= right) {
   >   		//	int mid = left + (right - left) >> 1;   错误 （1）
   >   			int mid = left + ((right - left) >> 1);
   >   			if(arr[mid] == num) {
   >   				return true;
   >   			}else if (arr[mid] < num) {
   >   				left = mid + 1;
   >   			}else {
   >   				right = mid - 1;
   >   			}
   >   		}
   >   		return false;
   >   	}
   >   	    
   >   	// 2.  对数器
   >   	// 2.1 generateRandomArray
   >   	public static int[] generateRandomArray(int maxSize, int maxValue) {
   >   		int[] arr= new int[(int)(Math.random() * (maxSize + 1))];
   >   		for(int i = 0; i < arr.length; i++) {
   >   			arr[i] = (int)(Math.random() * (maxValue + 1)) - (int)(Math.random() * (maxValue));
   >   		}
   >   		return arr;
   >   	}
   >   	    
   >   	// 2.2 test
   >   	public static boolean test(int[] arr, int num) {
   >   		for(int cur :arr ) {
   >   			if(cur == num) {
   >   				return true; 
   >   			}
   >   		}
   >   		return false;
   >   	}
   >   	
   >   	
   >        // 2.3 main
   >     public static void main(String[] args) {
   >     	int testTimes = 100000;
   >     	int maxSize = 100;
   >     	int maxValue = 100;
   >     	boolean succeed = true;
   >     	for(int i = 0; i < testTimes; i++) {
   >     		int[] arr = generateRandomArray(maxSize, maxValue);
   >     		Arrays.sort(arr);
   >     		int num = (int)(Math.random() * (maxValue + 1)) - (int)(Math.random() * maxValue);
   >     		if(test(arr, num) != exist(arr, num)) {
   >     			succeed = false;
   >     			break;
   >     		}
   >     	}
   >     	System.out.println(succeed ? "nice" : "bad");
   >     }
   >   
   >   }
   >   
   >   
   >   // int mid = left + (right - left) >> 1;   错误 （1）
   >   // 错的地方
   >   // 1. 左移运算符和右移运算符不会对变量产生影响，即right << 1,right的变量
   >   //    大小不发生变化
   >   // 2. + - 的优先级比左移和右移运算符高
   >   // 总而言之，left + (right - left) >> 1  == right >> 1,而每次right右移后
   >   // 又不改变大小，所以会造成死循环
   >   ```
   >
   >   ![image-20220619145943275](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202206191459330.png)

3. > * Qusetion:
   >
   >   插入排序、选择排序和冒泡排序
   >
   >   ```java
   >   // 1. selectionSort
   >   	public static void selectionSort(int[] arr) {
   >   		if(arr == null || arr.length <=2) {
   >   			return;
   >   		}
   >   		for(int i = 0; i < arr.length - 1; i++) {
   >   			int min = i;
   >   			for(int j = i + 1; j < arr.length; j++) {
   >   				if(arr[min] > arr[j]) {
   >   					min = j;
   >   				}
   >   				swap(arr, min, i);
   >   			}
   >   			    
   >   		}
   >   	}
   >       
   >   // 2. bubbleSort
   >   	public static void bubbleSort(int[] arr) {
   >   		if(arr == null || arr.length <=2) {
   >   			return;
   >   		}
   >   		for(int i = 0; i < arr.length - 1; i++) {
   >   		int flag = 1;
   >   		for(int j = 0; i < arr.length -1 -i; j++) {
   >   			if(arr[j] > arr[j + 1]) {
   >   				flag = 0;
   >   				swap(arr, j , j + 1);
   >   			}
   >   		}
   >   		if(flag == 1) {
   >   			break;
   >   		}
   >   	}
   >   }
   >       
   >   // 3. insetionSort
   >   	public static void insertionsSort(int[] arr) {
   >   		if(arr == null || arr.length <=2) {
   >   			return;
   >   		}
   >   		for(int i = 1; i < arr.length; i++) {
   >   			for(int pre = i - 1; pre >= 0 && arr[pre] > arr[pre + 1]; pre--) {
   >   				if(arr[i] >= arr[i - 1]) {
   >   					continue;
   >   				}
   >   				swap(arr,pre, pre + 1);
   >   			}
   >   		}
   >   	}
   >   	    
   >   ```
   >
   
5. > ==二分查找==
   >
   > * 先定范围，再二分，后查找。
   > * 二分的体现是`mid = (mid + R) / 2`
   > * 查找怎么查找，找到了怎么样，找不到，下一步又该如何找，去哪个范围找
   >

------------------------------------------ Note --------------------------------------------------------------------

1. >  常数时间的操作是O(1)

2. >  <img src="https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202206222212790.png" alt="image-20220613160034441" style="zoom:150%;" />
   >
   >  <img src="https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202206222212807.png" alt="image-20220613160119245" style="zoom:200%;" />
   >
   >  * 如果流程随着数据情况的变化而变化，应该估计最难的流程
   >
   >   <img src="https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202206222212786.png" alt="image-20220613162812961" style="zoom:200%;" />

3. > <img src="https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202206222212771.png" alt="image-20220613162935566" style="zoom:200%;" />

4. > * 额外空间复杂度给的不算额外空间，即除了样本数据之外的空间。在整个算法流程中开辟的空间是有限的，跟样本数据量无关，用户需要的空间不算做空间复杂度，就是在一个函数中，开辟了一个数组，可是这个数组是函数的返回值，那么这个开辟的空间不算做额外空间复杂度。用户要什么，你给什么，输入什么参数，都不算额外空间。如果需要有限个变量，额外空间复杂度为O(1)。
   >
   > * 额外空间也是自主空间，和输入、功能都没有关的
   >
   >   ![image-20220613164238983](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202206222212811.png)

5. > ![image-20220613170441009](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202206222212872.png)

6. > * 拼常数项直接测数据运行时间
   >
   > * 算法一定要先对样本有个认识，有了样本数量才能设计更好的算法
   >
   > * 最优解：先PK时间复杂度，再PK额外空间复杂度，如果两者都相同，那么这两个算法都是最优解，不用PK常数项

7. > O(1),运行时间和样本没关系，N可以看成样本数量
   >
   > O(1),运行时间和样本没关系，N可以看成样本数量
   >
   > ![image-20220613171727212](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202206222212210.png)
