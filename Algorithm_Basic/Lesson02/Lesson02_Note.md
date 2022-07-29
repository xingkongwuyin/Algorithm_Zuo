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
   >   ```
   >
   >   }
   >
   > 
   >
   >   ```java
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

