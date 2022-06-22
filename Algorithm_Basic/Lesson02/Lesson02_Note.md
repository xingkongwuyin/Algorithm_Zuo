# Lesson note

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
   >   ![image-20220609204101268](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202206222247268.png)
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
   > ==题目五：一个数组中有一种数出现K次，其他数都出现了M次，M > 1, K < M,找到出现了k次的数，要求额外空间复杂度O(1)==