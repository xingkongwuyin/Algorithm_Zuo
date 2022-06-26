# Note
## lesson01

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
   >   > ![image-20220619091420121](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202206260750741.png)
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
   >   >        采用二分查找去找。 因为数组元素相邻不相等，所以第三步就把数组长度为2的数组       
   >   >             
   >   >        和数组长度大于2的数组中符合条件的找完了，剩下就是数组长度大于2的且左右
   >   >     
   >   >       边界都大于相邻值的数组。为什么强调数组长度，因为由下面的数组可以看到，如果
   >   >     
   >   >      如果数组的长度等于2，arr[mid - 1]就会溢出，所以要先把数组长度为2的数组找完。
   >   >     
   >   >      先把数组长度为2的数组找完还有一个好处就是，最后只剩下左右边界都大于相邻元素
   >   >     
   >   >       的数组，那么就容易去找中间元素了。          
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
   >   >        再去num左边去找
   >   >
   >   > （2） 对于arr[mid]来说只有>= 和 <两种情况，第一种情况已经讨论，如果arr[mid] 
   >   >
   >   >         < num,那么就去mid右边找  
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
   >  // int mid = left + (right - left) >> 1;   错误 （1）
   >   // 错的地方
   >   // 1. 左移运算符和右移运算符不会对变量产生影响，即right << 1,right的变量
   >   //    大小不发生变化
   >   // 2. + - 的优先级比左移和右移运算符高
   >   // 总而言之，left + (right - left) >> 1  == right >> 1,而每次right右移后
   >   // 又不改变大小，所以会造成死循环
   > 
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

2. >  <img src="https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202206260750748.png" alt="image-20220613160034441" style="zoom:150%;" />
   >
   >  <img src="https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202206260750731.png" alt="image-20220613160119245" style="zoom:200%;" />
   >
   >  * 如果流程随着数据情况的变化而变化，应该估计最难的流程
   >
   >   <img src="https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202206260750707.png" alt="image-20220613162812961" style="zoom:200%;" />

3. > <img src="https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202206260750711.png" alt="image-20220613162935566" style="zoom:200%;" />

4. > * 额外空间复杂度给的不算额外空间，即除了样本数据之外的空间。在整个算法流程中开辟的空间是有限的，跟样本数据量无关，用户需要的空间不算做空间复杂度，就是在一个函数中，开辟了一个数组，可是这个数组是函数的返回值，那么这个开辟的空间不算做额外空间复杂度。用户要什么，你给什么，输入什么参数，都不算额外空间。如果需要有限个变量，额外空间复杂度为O(1)。
   >
   > * 额外空间也是自主空间，和输入、功能都没有关的
   >
   >   ![image-20220613164238983](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202206260750729.png)

5. > ![image-20220613170441009](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202206260750116.png)

6. > * 拼常数项直接测数据运行时间
   >
   > * 算法一定要先对样本有个认识，有了样本数量才能设计更好的算法
   >
   > * 最优解：先PK时间复杂度，再PK额外空间复杂度，如果两者都相同，那么这两个算法都是最优解，不用PK常数项

7. > O(1),运行时间和样本没关系，N可以看成样本数量
   >
   > O(1),运行时间和样本没关系，N可以看成样本数量
   >
   > ![image-20220613171727212](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202206260750081.png)

## lesson02

1. > ==异或==
   >
   > * 相同为0，相异为1
   >
   > * 可以看成无进位相加
   >
   > * 性质
   >
   >   + 0 ^ N = N
   >
   >   + N ^ N = 0
   >
   >   + 满足交换律和结合律
   >
   >   + 一组数不管其位置如何，最终异或的结果一样
   >
   >     ```java
   >     // 交换律
   >     a ^ b = b ^ a;
   >     // 结合律
   >     (a ^ b) ^ c = a ^ (b ^ c);
   >     // 同时
   >     (a ^ b) ^ c = (a ^ c) ^ b
   >     ```
   >
   > ==题目一：交换两个不相等的数，不用第三个变量==
   >
   > * ```java
   >   a = a ^ b;
   >   b = a ^ b;
   >   a = a ^ b; 
   >   ```
   >
   >   ![image-20220609204101268](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202206260749309.png)
   >
   > ==题目二：一个数组中有一个数出现了奇数次，其他数都出现了偶数次，怎么找到并打印这个数==
   >
   > ```java
   > 	public static void printOddTimesNum(int[] arr) {
   > 		int eor = 0;
   > 		for(int i = 0; i < arr.length; i++) {
   > 			eor ^= arr[i];
   > 		}
   > 		System.out.println(eor);
   > 	}
   > ```
   >
   > ==题目三：怎么把一个int类型的数，提出最右侧的1来==
   >
   > ```java
   > a = 01011000  ----> ans = 00001000
   > ans = a & (-a) = a & (~a + 1);    
   > ```
   >
   > ==题目四：一个数组中有两种数出现了奇数次，其他数出现了偶数次，怎么找到并打印这两种数==
   >
   > * analysis：两个数不相同 ——> 异或后eor必不等于0 ——> eor的某位必等于1 -----> 两个数必有一个数在eor最右侧等于1的那个位置，是1，另一个是0
   >
   > ```java
   >  	public static void printOddTimesNum2(int[] arr) {
   > 		int eor = 0;
   > 		for(int i = 0; i < arr.length; i++) {
   > 			eor ^= arr[i];
   > 		}
   > 
   > 		int mostRightOne = eor & (-eor);
   > 		int onlyOne = 0;
   > 		for(int i = 0; i < arr.length; i++) {
   > 			if((mostRightOne & arr[i]) != 0) {
   > 				onlyOne ^= arr[i];
   > 			}
   > 		}
   > 		System.out.println(eor + " " + (eor ^ onlyOne));		
   > 	} 
   > ```
   >
   > ==题目五：一个数组中有一种数出现K次，其他数都出现了M次， M > k >= 1,找到出现了k次的数，要求额外空间复杂度O(1)==
   >
   > * analysis：因为每个数可以看成32为二进制，所以将每个数的32个二进制位求出来，创建一个数组help，来盛放二进制序列，分别加进数组中，然后模M，等于0，则说明那个数在该二进制位为0，否则为1，因为一个数出现了M次，那么这某位二进制为1，剩下的6个相同的数也得为1，所以得是M的倍数。
   >
   > * 建立长度为32的数组arr ——》循环求出每个数的2进制位，同时加到数组arr中 ——》对数组的每个元素取模M，如果等于0，那么要求的数在该位为1，否则为0
   >
   >   ```java
   >   package Lesson02;
   >   import java.util.HashMap;
   >   import java.util.HashSet;
   >       
   >   public class Code03_KM {
   >       
   >   	// km
   >   	public static int km(int[] arr, int k, int m) {
   >   		int[] help = new int[32];
   >   		for(int num : arr) {
   >   			for(int i = 0; i < 32; i++) {
   >   				help[i] += ((num >> i) & 1);    // arr上的num，从第1位到32位遍历num的二进制的每                                // 然后加到help数组中
   >   			}                                   // 一位，第i位是1，就在help数组第i个元素加一
   >   		}
   >   		int ans = 0;
   >   	    for(int i = 0; i < 32; i++) {
   >   	    	help[i] %= m;
   >   	    	if(help[i] != 0) {
   >   	    		ans |= (1 << i);
   >   	    	}
   >   	    }
   >   	    return ans;
   >   	}
   >       
   >   	// 对数器
   >   	// 1. 用哈希表的方式求出arr数组中出现k次的那个数
   >   	public static int haspMapNum(int[] arr, int k, int m) {
   >   		HashMap<Integer, Integer> map = new HashMap<>();
   >   		for(int num : arr) {
   >   			if(map.containsKey(num)) {
   >   				map.put(num, map.get(num) + 1);
   >   			}else {
   >   				map.put(num, 1);
   >   			}
   >   		}
   >       
   >   		// 这一步的前提是一定会找到出现k次的数，如果没有出现k次的数，最终的结果都要返回1
   >   		// 出现了k次
   >           for(int num : map.keySet()) {
   >               if(map.get(num) == k) {
   >                   return num;
   >               }
   >           }
   >           return -1;
   >   	}
   >       
   >   	// 2. 产生符合要求的随机数组，有kinds种数，且某个数出现k次，其他数都出现m次
   >   	public static int[] randomArray(int maxKinds, int range, int k, int m) {
   >   		int kTimesNum = randomNum(range);  // 真命天子
   >   		int times = k;                    //  真命天子出现的次数
   >   		int numKinds = (int)(Math.random() * maxKinds) + 2;   // 一共有numkinds种数
   >   		int[] arr = new int[times + (numKinds - 1) * m];    
   >   		int index = 0;
   >   		for(; index < times; index++) {
   >   			arr[index] = kTimesNum;
   >   		}
   >   		numKinds--;
   >   		HashSet<Integer> set = new HashSet<>();
   >   		set.add(kTimesNum);
   >   		while(numKinds != 0) {
   >   			int curNum = 0;
   >   			do {
   >   				curNum = randomNum(range);
   >   			}while(set.contains(curNum));
   >   			numKinds--;
   >   			for(int i = 0; i < m; i++) {
   >   				arr[index++] = curNum;
   >   			}
   >   		}
   >       
   >   		// 打乱顺序
   >   		for(int i = 0; i < arr.length; i++) {
   >   			int j = (int)(Math.random() * arr.length);
   >   			int tmp = arr[i];
   >   			arr[i] = arr[j];
   >   			arr[j] = tmp;
   >   		}
   >   		return arr;
   >       
   >   	}
   >       
   >   	// 3. 创造随机数 [-range range]
   >   	public static int randomNum(int range) {
   >   		return (int)(Math.random() * (range + 1 )) -(int)(Math.random() * (range + 1 ));
   >   	}
   >       
   >   	// 4.打印数组
   >   	public static void print(int[] arr) {
   >   		for(int num : arr) {
   >   			System.out.println(num + " ");
   >   		}
   >   	}
   >
   >
   > ```java
   > // 5.测试
   > public static void main(String[] args) {
   > 	int kinds = 52;
   > 	int range = 300;
   > 	int max = 91;
   > 	int testTimes = 100000;
   > 	System.out.println("begin!!!");
   > 	for(int i = 0; i < testTimes; i++) {
   > 		int a = (int)(Math.random() * max) + 1;
   > 		int b = (int)(Math.random() * max) + 1;
   > 		int k = Math.min(a, b);
   > 		int m = Math.max(a, b);
   > 
   > 		// K < m
   > 		if(k == m) {
   > 			m++;
   > 		}
   > 		int[] arr = randomArray(kinds, range, k, m);
   > 		int ans1 = km(arr, k, m);
   > 		int ans2 = haspMapNum(arr, k, m);
   > 		if(ans1 != ans2) {
   > 			print(arr);
   > 			System.out.println(" ");
   > 			System.out.println("ans1 =" + ans1 + "ans2 " + ans2 );
   > 			System.out.println("bad!!!");
   > 			break;
   > 		}
   > 	}
   > 	System.out.println("end!!!");
   > }
   > ```
   >
   >   }
   >
   > 
   >
   >   ```java
   > 
   > 
   > 
   > ==题目六：一个数组中，有n种数，n - 1种数出现了M次，剩下一种数出现的次数不确定，但肯定大于等于1，且小于M，求 如果剩下的那个数出现的次数等于K次，则找出这个数，如果不是则返回找不到==
   > 
   > * analysis：题目四的分析大体一致，不同的是
   >   + 模M的时候要看一下结果是否等于k，不等于k，那就不是要求的数
   >   + 而且最后返回值为0的话，也要判断下，是0出现了k次，还是没经过改变的0。
   >   + 没找到返回-1，这个我有点不理解，是因为HashMap找不到某个数就返回-1，这就相当于，找不到或者-1真的出现k次都会返回-1，这里只是判断这个代码是否正确，这点可以忽略
   > 
   > package Lesson02;
   > import java.util.HashMap;
   > import java.util.HashSet;
   > 
   > public class Code04_IsKM {
   > 
   > 	// km
   > 	public static int km(int[] arr, int k, int m) {
   > 		int[] help = new int[32];
   > 		for(int num : arr) {
   > 			for(int i = 0; i < 32; i++) {
   > 				help[i] += ((num >> i) & 1);    // arr上的num，从第1位到32位遍历num的二进制的每                                // 然后加到help数组中
   > 			}                                   // 一位，第i位是1，就在help数组第i个元素加一
   > 		}
   > 		int ans = 0;
   > 	    for(int i = 0; i < 32; i++) {
   > 	    	if(help[i] % m == 0) {
   > 	    		continue;
   > 	    	}
   > 	    	if(help[i] % m == k) {
   > 	    		ans |= (1 << i);
   > 	    	}else{
   > 	    		return -1;
   > 	    	}
   > 	    }
   > 	    // 因为ans == 0，但是不能确定0中了没有，所以下步遍历一下0出现的次数
   > 	  if(0 == ans) {
   > 		  int count = 0;
   > 		  for(int num : arr) {
   > 		    	if (num == ans) {
   > 		    		count++;
   > 		    	}
   > 		    }
   > 		    if(count != k) {
   > 		    	return -1;
   > 		    }
   > 	  }
   > 
   > 		return ans;
   > 	}
   > 
   > 	// 对数器
   > 	// 1. 用哈希表的方式求出arr数组中出现k次的那个数
   > 	public static int haspMapNum(int[] arr, int k, int m) {
   > 		HashMap<Integer, Integer> map = new HashMap<>();
   > 		for(int num : arr) {
   > 			if(map.containsKey(num)) {
   > 				map.put(num, map.get(num) + 1);
   > 			}else {
   > 				map.put(num, 1);
   > 			}
   > 		}
   > 
   > 		// 这一步的前提是一定会找到出现k次的数，如果没有出现k次的数，最终的结果都要返回1
   > 		// 出现了k次
   > 		for(int num : map.keySet()) {
   > 			if(map.get(num) == k) {
   > 				return num;
   > 			}
   > 		}
   > 		return -1;
   > 	}
   > 
   > 	// 2. 产生符合要求的随机数组，有kinds种数，且某个数出现k次，其他数都出现m次
   > 	public static int[] randomArray(int maxKinds, int range, int k, int m) {
   > 		int kTimesNum = randomNum(range);  // 真命天子
   > 		int times = Math.random() < 0.5 ? k : (int)(Math.random() * (m - 1)) + 1;                    //  真命天子出现的次数,且以50%的概率出现k，50概率出现1到m-1次
   > 		int numKinds = (int)(Math.random() * maxKinds) + 2;   // 一共有numkinds种数
   > 		int[] arr = new int[times + (numKinds - 1) * m];    
   > 		int index = 0;
   > 		for(; index < times; index++) {
   > 			arr[index] = kTimesNum;
   > 		}
   > 		numKinds--;
   > 		HashSet<Integer> set = new HashSet<>();
   > 		set.add(kTimesNum);
   > 		while(numKinds != 0) {
   > 			int curNum = 0;
   > 			do {
   > 				curNum = randomNum(range);
   > 			}while(set.contains(curNum));
   > 			numKinds--;
   > 			for(int i = 0; i < m; i++) {
   > 				arr[index++] = curNum;
   > 			}
   > 		}
   > 
   > 		// 打乱顺序
   > 		for(int i = 0; i < arr.length; i++) {
   > 			int j = (int)(Math.random() * arr.length);
   > 			int tmp = arr[i];
   > 			arr[i] = arr[j];
   > 			arr[j] = tmp;
   > 		}
   > 		return arr;
   > 
   > 	}
   > 
   > 	// 5. 创造随机数 [-range range]
   > 	public static int randomNum(int range) {
   > 		return (int)(Math.random() * (range + 1 )) -(int)(Math.random() * (range + 1 ));
   > 	}
   > 
   > 	// 4.打印数组
   > 	public static void print(int[] arr) {
   > 		for(int num : arr) {
   > 			System.out.println(num + " ");
   > 		}
   > 	}
   > 
   > 
   > 	// 5.测试
   > 	public static void main(String[] args) {
   > 		int kinds = 14;
   > 		int range = 110;
   > 		int max = 9;
   > 		int testTimes = 100000;
   > 		System.out.println("begin!!!");
   > 		for(int i = 0; i < testTimes; i++) {
   > 			int a = (int)(Math.random() * max) + 1;
   > 			int b = (int)(Math.random() * max) + 1;
   > 			int k = Math.min(a, b);
   > 			int m = Math.max(a, b);
   > 
   > 			// K < m
   > 			if(k == m) {
   > 				m++;
   > 			}
   > 			//int[] arr = randomArray(kinds, range, k, m);
   > 			int[] arr = {-6, 8, -6, 8, 8}; k = 2; m = 3;
   > 			int ans1 = km(arr, k, m);
   > 			int ans2 = haspMapNum(arr, k, m);
   > 			if(ans1 != ans2) {
   > 				print(arr);
   > 				System.out.println(" ");
   > 				System.out.println("ans1 = " + ans1 + " ans2 = " + ans2 );
   > 				System.out.println("bad!!!");
   > 				break;
   > 			}
   > 		}
   > 		System.out.println("end!!!");
   > 	}
   > 
   > }
   > 
   >   ```
   >
   > 

## lesson03
1. > 单项链表
   >
   > ```java
   > // 单向链表结点结构（可以实现成泛型）
   > pubic class Node{
   >  public int value;
   >  pubic Node next;
   > 
   >  public Node(int data){
   >      value = data;
   >  }
   > }
   > 
   > 
   > ```

2. > 双向链表
   >
   > ```java
   > // 双向链表的结点结构
   > public class DoubleNode{
   >     public int value;
   >     public DoubleNode last;
   >     public DoubleNode nest;
   >     
   >     public DoubleNode(int data){
   >         value = data;
   >     }
   > }
   > ```

3. > 单向链表和双向链表最简单的练习
   >
   > ```java
   > //   链表相关的问题几乎都是coding问题
   > //   1）单链表和双链表如何反转
   > //   2）把给定值去除
   > //   这里是熟悉的结构。链表还有哪些常见的联系题，后续还有专门的一节来系统学习
   > ```
   >
   > * 1）单链表的旋转（利用for/while的思想)
   >
   > ![image-20220624105910022](https://dawn1314.oss-cn-beijing.aliyuncs.com/202206241059055.png)
   >
   > > + 首先明确，大问题是指什么，大问题是指，翻转整个链表，也就是将链表中的每个结点翻转过来，那么小问题就是将链表中的每个结点进行翻转，这就是把大问题转换成了小问题，解决完小问题就等同于大问题解决了。这里值得注意的是，一个小问题的解决需要上一个小问题搭建环境，最主要的就是解决完小问题后，要来到下一个小问题，还有的是，需要用到上一步的结论
   > > + 解决单链表
   > >   * 方法：将每个只头指针指向的结点的前后结点和其指针，也就是pre和next，给找出来，每次将头节点翻转后，pre和head就往前移（这一步的目的是为下一步问题搭建环境，即来到下一个问题）
   > >   * 步骤：将pre和next指向null（主要是将pre指向null，可以想象null是在head结点之后，而next的作用主要是为翻转结点前找到结点的下一个结点）——> 将head指向的结点翻转（小问题的核心就是这个）——> 将pre和head指针往前移(来到下一个结点) 
   > >
   > > * code
   > >
   > >   ```java
   > >   // 翻转单向链表 
   > >   public static Node reverseLinkedList(Node head) {
   > >       	Node pre = null;
   > >       	Node next = null;
   > >               
   > >       	while(head != null) {
   > >       		next = head.next;
   > >       		head.next = pre;
   > >       		pre = head;
   > >       		head = next;
   > >       	}
   > >       	return pre;
   > >       }
   > >   // 翻转双向链表
   > >       public static doubleNode reversedoubleList(doubleNode head) {
   > >       	doubleNode next = null;
   > >       	doubleNode pre = null;
   > >       	while(head != null) {
   > >       		next = head.next;
   > >       		head.last = next;
   > >       		head.next = pre;
   > >       		pre = head;
   > >       		head = next;
   > >       	}
   > >       	return pre;
   > >       }
   > >   ```
   > >
   >
   > * 2）给定单链表，删除指定数
   >
   >   ![image-20220624194736194](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202206241947239.png)
   >
   > > + analysis：首先判断链表非空，非空返回null。用pre表示从头节点到pre符合节点，cur表示去找符合要求的节点，cur没找到，就把cur所指的节点删掉，即让pre的next指向cur的next，如果找到就让pre来到cur的位置，最后返回head
   > >
   > >   ```java
   > >   public static class Node {
   > >   		public int value;
   > >   		public Node next;
   > >               
   > >   		public Node(int data) {
   > >   			this.value = data;
   > >   		}
   > >   	}
   > >               
   > >   	// head = removeValue(head, 2);
   > >   	public static Node removeValue(Node head, int num) {
   > >   		// head来到第一个不需要删的位置
   > >   		while (head != null) {
   > >   			if (head.value != num) {
   > >   				break;
   > >   			}
   > >   			head = head.next;
   > >   		}
   > >   		// 1 ) head == null
   > >   		// 2 ) head != null
   > >   		Node pre = head;
   > >   		Node cur = head;
   > >   		while (cur != null) {
   > >   			if (cur.value == num) {
   > >   				pre.next = cur.next;
   > >   			} else {
   > >   				pre = cur;
   > >   			}
   > >   			cur = cur.next;
   > >   		}
   > >   		return head;
   > >   	}
   > >   ```
   > >
   > >   
   >
   > 
   
4. >  ==thought==
   >
   > 1. 对于链表的题，每次操作，是针对单个节点进行操作的，也就是每次循环是针对单个节点进行操作，那么对每个节点进行操作之前，要把这个结点的前后节点的指针要展开，即要找到他前后节点的指针pre和next，然后再对这个节点进行操作，一定要记住，链表的操作，从局部来说是对单个结点进行操作，找前后指针，一是为了对结点操作时，用的到，二是为下一步循环搭建环境，
   > 2. 对于while循环
   >    + 每次循环完不单单要完成局部的功能，还有为下一步循环操作搭建环境。这里的局部功能是指，整体实现某个大功能，分成局部有限个小功能去实现，也就是操作也就是把大问题分解成小问题去做。这和递归很像，递归是从大问题依次分解成规模较小的问题，从大到小，而whle循环是，要解决一个大问题，要从小到大去做，也就是一上来把问题分解成有限个同等规模的小问题，依次把这些小问题去解决，这些小问题不是彼此独立的，可能解决上一个小问题的之后，要用到其结论，或者为下一步解决的小问题搭建环境。所以解决一个问题，不管要完成其局部功能，还要为下一步的问题的解决提供一定的帮助，但有的就不用，具体得看题目，或者用for还是while，for有时就不用为下一步搭建环境，因为i++会自动搭建环境，也就是说搭建环境这个for循环给做了，总体来说，还是得为下一步搭建环境，也就说得达到下一个问题
   >
   > ==mindmap==
   >
   > ![image-20220624104457156](https://dawn1314.oss-cn-beijing.aliyuncs.com/202206241044213.png)

5. > ```java
   > // 栈和队列
   > // 逻辑概念
   > // 栈：数据先进后出，犹如弹匣
   > // 队列：数据先进先出，好似排队
   > ```
   >
   > ```java
   > // 栈和队列的实际实现
   > // 双向链表的实现
   > // 数组实现
   > ```
   >
   > ```java
   > // 栈和队列的常见面试题
   > // 实现一个特殊的栈，在基本功能的基础上，再实现返回栈中最小元素的功能
   > // 1) pop、push、getMin、操作的时间复杂度都是O(1).
   > // 2) 设计的栈类型可以使现有的栈结构
   > ```
   >
   > ```java
   > // 栈和队列的常见面试题
   > // 1) 如何用栈结构实现队列结构
   > // 2) 如何用队列结构实现栈结构
   > 
   > // 这两种结构的应用实在是太多了，在刷题时会我们会大量见到
   > ```
   >
   > ```java
   > //递归？ 这东西是什么？
   > // * 怎么从思想上理解递归
   > // * 怎么从实际的角度出发理解递归
   > 
   > ```
   >
   > ```java
   > // 例子
   > // 求数组arr[L……R]中的最大值，怎么用递归方法实现
   > // 1) 将[L R]范围分成左右两半。左[L mid] 右[mid R]
   > // 2) 左部分求最大值，右部分求最大值
   > // 3) [L R]范围上的最大值，是max{左部分的最大值，右部分最大值}
   > // 4) 注意2)是个递归过程，当范围上只有一个数，就可以不用递归了
   > ```
   >
   > 

6. > 子问题的规模必须是一致的，比如，T(N)  = T(N / 3) + T(N / 4)，子问题的规模不一致，这类递归就不能用master公式来估计时间复杂度，也就是子问题规模一致的才可以用master公式 
   >
   > ![](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202206252004298.png)

7. > ==hashmap==
   >
   > 1. <DataType, DataType>,DataType如果是原生内置的数据类型，例如String，Integer，会把String类型的数据放进hashMap中；如果是Node，自定义数据类型，那么在hashmap中存放的是其地址
   >
   > 2. hashmap的增删查改的时间复杂度都是O(1)
   >
   > 3. hashset可以看成只有key，即形式是<DataType>
   >
   >    

8. > ```java
   > int a = 1000;
   > int b = 1000;
   > System.out.println(a == b);        // true  按值传递，比对的是值
   > 
   > Integer aa = 1000;
   > Integer bb = 1000;
   > System.out.println(a == b);        // false  按址传递，比对的是地址
   > System.out.println(a.equals(b));   // 用equals方法比对的是值    
   > ```

## lesson04

1. > 归并排序
   >
   > * 昨天他说，我们现在的递归都是符合master公式的递归，而符合master公式的递归，子问题的规模还必须是一致的，那是不是讲，我们以后思考递归问题如何分解，是不是可以考虑如何将子问题的规模一致作为一个切入点
   > * O(N^2)的排序大量浪费了比较的时间，而O(N* log(N)),相对他们来说，比较的时间就不是很多
   >
   > * 一个问题可以由一个包含8条语句的for循环解决，也可以由两个包含4条语句的for循环解决，选择后中，有助于思维清晰
   >
   > * mergedsort把比较的信息，变成有序的东西，而有序的东西，可以做很多事。
   >
   > * mergedsort启示：当求某个数的右边或者左边怎么样的，再求整体个数的时候，可以往mergesort靠
   >
   > * 技巧：
   >
   >   + 指针不回退，前提得是有序的数，即单调性
   >
   >   + 表示不存在的数可以用左开右闭

# code

## lesson01



## lesson02

```java
package lesson02;

public class Code05_Summary  {

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
```



## lesson03

```java
package lesson03;
import lesson03.Code01_ReverseList.Node;
import lesson03.Code01_ReverseList.doubleNode;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

public class Code11_Summary {

	    // 1. reverse linked list
		public static Node reverseLinkedList(Node head) {
			Node pre = null;
			Node next = null;
			
			while(head != null) {
				next = head.next;
				head.next = pre;
				
				pre = head;
				head = next;
			}
			return pre;
		}
		
		
		
		
		// 2. reverse double list
		public static doubleNode reverseDoubleList(doubleNode head) {
			doubleNode pre = null;
			doubleNode next = null;
			
			while(head != null) {
				next = head.next;
				head.last = next;
				head.next = pre;
				
				pre = head;
				head = next;
			}
			return pre;		
		}
		
		
		
		
		// 3. delete given value
		public static Node deleteGivenValue(Node head, int num) {
			while(head != null) {
				if(head.value != num) {
					break;
				}
				head = head.next;
			}
			
			Node pre = head;
			Node cur = head;
			while(cur != null) {
				if(head.value == num) {
					pre.next = cur.next;
				}else {
					pre = cur;
				}
			}
			return head;
		}
		
		
		
		
		// 4. ring array implements queue
		public static class MyQueue{
			private int[] arr;
			private int pushi; // end
			private int polli; // begin
			private int size;
			private final int limit;
			public MyQueue(int limit) {
				arr = new int[limit];
				pushi = 0;
				polli = 0;
				size = 0;
				this.limit = limit;
			}
			
			// 5. push element
			public void push(int value) {
				if(size == limit) {
					throw new RuntimeException("Queue is full");				
				}
				size--;
				arr[pushi] = value;
				pushi = nextIndex(pushi);
				
			}
			
			// 6. pop element
			public int pop() {
				if(0 == size) {
					throw new RuntimeException("Queue is empty");
				}
				size++;
				int ans = arr[polli];
				polli = nextIndex(polli);
				return ans;
			}
			public int nextIndex(int i) {
				return i < limit - 1 ? (++i) : 0;
			}
		}
		
		
		
		
		// 7. getMinStack
		public static class Mystack{
			private  Stack<Integer> stackData;
			private Stack<Integer> stackMin;
			
			public Mystack(){
				stackData = new Stack<Integer>();
				stackMin = new Stack<Integer>();
			}
			
			public void push(int newNum) {
				if(stackData.isEmpty()) {
					this.stackData.push(newNum);
					this.stackMin.push(newNum);
				}else if(newNum < this.getMin()) {
					this.stackData.push(newNum);
					this.stackMin.push(newNum);
				}else {
					this.stackData.push(newNum);
					this.stackMin.push(this.getMin());
				}
			}
			
			public int pop(){
				if(stackData.isEmpty()) {
					throw new RuntimeException("stack is empty!");
				}
				this.stackMin.pop();
				return this.stackData.pop();
			}
			
			public int getMin() {
				if(this.stackMin.isEmpty()) {
					throw new RuntimeException("stack is empty!");
				}
				return this.stackMin.peek();
			}
		}
		
		
		
		
		// 8. two stacks implement queue
		public static class TwoStackImplement{
			public Stack<Integer> stackPush;
			public Stack<Integer> stackPop;
			
			public TwoStackImplement() {
				stackPush = new Stack<Integer>();
				stackPop = new Stack<Integer>();
			}
			
			// push data from stackpush to stackpop
			private void pushToPop() {
				if(stackPop.empty()) {
					while(!stackPush.empty()) {
						stackPop.push(stackPush.pop());
					}
				}
			}
			
			public void add(int pushInt) {
				stackPush.push(pushInt);
				pushToPop();
			}
			
			public int poll() {
				if(stackPop.empty() && stackPush.empty()) {
					throw new RuntimeException("queue is empty");
				}
				pushToPop();
				return stackPop.pop();
			}
			
			public int peek() {
				if(stackPop.empty() && stackPush.empty()) {
					throw new RuntimeException("queue is empty");
				}
				pushToPop();
				return stackPop.peek();
			}
		}
		
		
		
		// 9. two queues implement stack
		public static class TwoqueueImplementStack<T>{
			public Queue<T> queue;
			public Queue<T> help;
			
			public TwoqueueImplementStack(){
				queue = new LinkedList<>();
				help = new LinkedList<>();
			}
			
			public void push(T value) {
				queue.offer(value);
			}
			
			public T poll() {
				while(queue.size() > 1) {
					help.offer(queue.poll());
				}
				T ans = queue.poll();
				Queue<T> tmp = queue;
				queue = help;
				help = tmp;
				
				return ans;
			}
			
			public T peek() {
				while(queue.size() > 1) {
					help.offer(queue.poll());
				}
				T ans = queue.poll();
				help.offer(ans);
				Queue<T> tmp = queue;
				queue = help;
				help = tmp;
				
				return ans;
			}
		}		
}

```

## Lesson04


```java
// 一. 归并排序

public class Code01_MergeSort {

	// 递归方法实现
	public static void mergeSort1(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		process(arr, 0, arr.length - 1);
	} 

	// 请把arr[L..R]排有序
	// l...r N
	// T(N) = 2 * T(N / 2) + O(N)
	// O(N * logN)
	public static void process(int[] arr, int L, int R) {
		if (L == R) { // base case
			return;
		}
		int mid = L + ((R - L) >> 1);
		process(arr, L, mid);
		process(arr, mid + 1, R);
		merge(arr, L, mid, R);
	}

	public static void merge(int[] arr, int L, int M, int R) {
		int[] help = new int[R - L + 1];
		int i = 0;
		int p1 = L;
		int p2 = M + 1;
		while (p1 <= M && p2 <= R) {
			help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
		}
		// 要么p1越界了，要么p2越界了
		while (p1 <= M) {
			help[i++] = arr[p1++];
		}
		while (p2 <= R) {
			help[i++] = arr[p2++];
		}
		for (i = 0; i < help.length; i++) {
			arr[L + i] = help[i];
		}
	}

	// 非递归方法实现
	public static void mergeSort2(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		int N = arr.length;
		// 步长
		int mergeSize = 1;
		while (mergeSize < N) { // log N
			// 当前左组的，第一个位置
			int L = 0;
			while (L < N) {
				if (mergeSize >= N - L) {
					break;
				}
				int M = L + mergeSize - 1;
				int R = M + Math.min(mergeSize, N - M - 1);
				merge(arr, L, M, R);
				L = R + 1;
			}
			// 防止溢出
			if (mergeSize > N / 2) {
				break;
			}
			mergeSize <<= 1;
		}
	}

	// for test
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
		}
		return arr;
	}

	// for test
	public static int[] copyArray(int[] arr) {
		if (arr == null) {
			return null;
		}
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}

	// for test
	public static boolean isEqual(int[] arr1, int[] arr2) {
		if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
			return false;
		}
		if (arr1 == null && arr2 == null) {
			return true;
		}
		if (arr1.length != arr2.length) {
			return false;
		}
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}

	// for test
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	// for test
	public static void main(String[] args) {
		int testTime = 500000;
		int maxSize = 100;
		int maxValue = 100;
		System.out.println("测试开始");
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
			mergeSort1(arr1);
			mergeSort2(arr2);
			if (!isEqual(arr1, arr2)) {
				System.out.println("出错了！");
				printArray(arr1);
				printArray(arr2);
				break;
			}
		}
		System.out.println("测试结束");
	}

}
```

```java
// 二. 小盒问题：给定一个数组，先求出每个数左边小于自己的所有数列加起来，最后求出来的
//             数算一个累加和
// analysis: 求出每个数的右边多少个数比它大，那么小盒里就有几个它

public class Code02_SmallSum {

	public static int smallSum(int[] arr) {
		if (arr == null || arr.length < 2) {
			return 0;
		}
		return process(arr, 0, arr.length - 1);
	}

	// arr[L..R]既要排好序，也要求小和返回
	// 所有merge时，产生的小和，累加
	// 左 排序   merge
	// 右 排序  merge
	// merge
	public static int process(int[] arr, int l, int r) {
		if (l == r) {
			return 0;
		}
		// l < r
		int mid = l + ((r - l) >> 1);
		return 
				process(arr, l, mid) 
				+ 
				process(arr, mid + 1, r) 
				+ 
				merge(arr, l, mid, r);
	}

	public static int merge(int[] arr, int L, int m, int r) {
		int[] help = new int[r - L + 1];
		int i = 0;
		int p1 = L;
		int p2 = m + 1;
		int res = 0;
		while (p1 <= m && p2 <= r) {
			res += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;
			help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		}
		while (p1 <= m) {
			help[i++] = arr[p1++];
		}
		while (p2 <= r) {
			help[i++] = arr[p2++];
		}
		for (i = 0; i < help.length; i++) {
			arr[L + i] = help[i];
		}
		return res;
	}

	// for test
	public static int comparator(int[] arr) {
		if (arr == null || arr.length < 2) {
			return 0;
		}
		int res = 0;
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				res += arr[j] < arr[i] ? arr[j] : 0;
			}
		}
		return res;
	}

	// for test
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
		}
		return arr;
	}

	// for test
	public static int[] copyArray(int[] arr) {
		if (arr == null) {
			return null;
		}
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}

	// for test
	public static boolean isEqual(int[] arr1, int[] arr2) {
		if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
			return false;
		}
		if (arr1 == null && arr2 == null) {
			return true;
		}
		if (arr1.length != arr2.length) {
			return false;
		}
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}

	// for test
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	// for test
	public static void main(String[] args) {
		int testTime = 500000;
		int maxSize = 100;
		int maxValue = 100;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
			if (smallSum(arr1) != comparator(arr2)) {
				succeed = false;
				printArray(arr1);
				printArray(arr2);
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");
	}

}

```

```java
// 三. 在一个数组中，任何一个前面的数a，和任何一个后面的数b，如果(a,b)是降序的，就称为降序对。给定一个数组arr，求数组的降序对总数量


public class Code03_ReversePair {

	public static int reverPairNumber(int[] arr) {
		if (arr == null || arr.length < 2) {
			return 0;
		}
		return process(arr, 0, arr.length - 1);
	}

	// arr[L..R]既要排好序，也要求逆序对数量返回
	// 所有merge时，产生的逆序对数量，累加，返回
	// 左 排序 merge并产生逆序对数量
	// 右 排序 merge并产生逆序对数量
	public static int process(int[] arr, int l, int r) {
		if (l == r) {
			return 0;
		}
		// l < r
		int mid = l + ((r - l) >> 1);
		return process(arr, l, mid) + process(arr, mid + 1, r) + merge(arr, l, mid, r);
	}

	public static int merge(int[] arr, int L, int m, int r) {
		int[] help = new int[r - L + 1];
		int i = help.length - 1;
		int p1 = m;
		int p2 = r; 
		int res = 0;
		while (p1 >= L && p2 > m) {
			res += arr[p1] > arr[p2] ? (p2 - m) : 0;
			help[i--] = arr[p1] > arr[p2] ? arr[p1--] : arr[p2--];
		}
		while (p1 >= L) {
			help[i--] = arr[p1--];
		}
		while (p2 > m) {
			help[i--] = arr[p2--];
		}
		for (i = 0; i < help.length; i++) {
			arr[L + i] = help[i];
		}
		return res;
	}

	// for test
	public static int comparator(int[] arr) {
		int ans = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					ans++;
				}
			}
		}
		return ans;
	}

	// for test
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
		}
		return arr;
	}

	// for test
	public static int[] copyArray(int[] arr) {
		if (arr == null) {
			return null;
		}
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}

	// for test
	public static boolean isEqual(int[] arr1, int[] arr2) {
		if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
			return false;
		}
		if (arr1 == null && arr2 == null) {
			return true;
		}
		if (arr1.length != arr2.length) {
			return false;
		}
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}

	// for test
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	// for test
	public static void main(String[] args) {
		int testTime = 500000;
		int maxSize = 100;
		int maxValue = 100;
		System.out.println("测试开始");
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
			if (reverPairNumber(arr1) != comparator(arr2)) {
				System.out.println("Oops!");
				printArray(arr1);
				printArray(arr2);
				break;
			}
		}
		System.out.println("测试结束");
	}

}

```

```java
// 四. 在一个数组中，对于任何一个数num，求有多少个(后面的数*2)依然<num，返回总个数
//     比如：[3,1,7,0,2]
//     3的后面有：1，0
//     1的后面有：0
//     7的后面有：0，2
//     0的后面没有
//     2的后面没有
//     所以总共有5个
package class04;

//  本题测试链接 : https://leetcode.com/problems/reverse-pairs/
public class Code04_BiggerThanRightTwice {

	public static int reversePairs(int[] arr) {
		if (arr == null || arr.length < 2) {
			return 0;
		}
		return process(arr, 0, arr.length - 1);
	}

	public static int process(int[] arr, int l, int r) {
		if (l == r) {
			return 0;
		}
		// l < r
		int mid = l + ((r - l) >> 1);
		return process(arr, l, mid) + process(arr, mid + 1, r) + merge(arr, l, mid, r);
	}

	public static int merge(int[] arr, int L, int m, int r) {
		// [L....M] [M+1....R]
		int ans = 0;
		// 目前囊括进来的数，是从[M+1, windowR) 的个数为 windowR - m - 1
		int windowR = m + 1;  // windowR是指到不了的位置，一开始要表示一个到不了的位置，即让
		for (int i = L; i <= m; i++) {  // 囊括进来的数为0个
			while (windowR <= r && (long) arr[i] > (long) arr[windowR] * 2) {
				windowR++;
			}
			ans += windowR - m - 1;
		}
		int[] help = new int[r - L + 1];
		int i = 0;
		int p1 = L;
		int p2 = m + 1;
		while (p1 <= m && p2 <= r) {
			help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
		}
		while (p1 <= m) {
			help[i++] = arr[p1++];
		}
		while (p2 <= r) {
			help[i++] = arr[p2++];
		}
		for (i = 0; i < help.length; i++) {
			arr[L + i] = help[i];
		}
		return ans;
	}

	// for test
	public static int comparator(int[] arr) {
		int ans = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > (arr[j] << 1)) {
					ans++;
				}
			}
		}
		return ans;
	}

	// for test
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) ((maxValue + 1) * Math.random());
		}
		return arr;
	}

	// for test
	public static int[] copyArray(int[] arr) {
		if (arr == null) {
			return null;
		}
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}

	// for test
	public static boolean isEqual(int[] arr1, int[] arr2) {
		if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
			return false;
		}
		if (arr1 == null && arr2 == null) {
			return true;
		}
		if (arr1.length != arr2.length) {
			return false;
		}
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}

	// for test
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	// for test
	public static void main(String[] args) {
		int testTime = 500000;
		int maxSize = 100;
		int maxValue = 100;
		System.out.println("测试开始");
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
			if (reversePairs(arr1) != comparator(arr2)) {
				System.out.println("Oops!");
				printArray(arr1);
				printArray(arr2);
				break;
			}
		}
		System.out.println("测试结束");
	}

}
```
