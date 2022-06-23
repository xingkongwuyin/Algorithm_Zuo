package Lesson02;
import java.util.HashMap;
import java.util.HashSet;

public class Code03_KM {

	// km
	public static int km(int[] arr, int k, int m) {
		int[] help = new int[32];
		for(int num : arr) {
			for(int i = 0; i < 32; i++) {
				help[i] += ((num >> i) & 1);    // arr上的num，从第1位到32位遍历num的二进制的每                                // 然后加到help数组中
			}                                   // 一位，第i位是1，就在help数组第i个元素加一
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
	
	// 对数器
	// 1. 用哈希表的方式求出arr数组中出现k次的那个数
	public static int haspMapNum(int[] arr, int k, int m) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int num : arr) {
			if(map.containsKey(num)) {
				map.put(num, map.get(num) + 1);
			}else {
				map.put(num, 1);
			}
		}
		
		// 这一步的前提是一定会找到出现k次的数，如果没有出现k次的数，最终的结果都要返回0，那就默认0
		// 出现了k次
		int ans = 0;
		for(int num : map.keySet()) {
			if(map.get(num) == k) {
				ans = num;
				break;
			}
		}
		return ans;
	}
	
	// 2. 产生符合要求的随机数组，有kinds种数，且某个数出现k次，其他数都出现m次
	public static int[] randomArray(int maxKinds, int range, int k, int m) {
		int kTimesNum = randomNum(range);  // 真命天子
		int times = k;                    //  真命天子出现的次数
		int numKinds = (int)(Math.random() * maxKinds) + 2;   // 一共有numkinds种数
		int[] arr = new int[times + (numKinds - 1) * m];    
		int index = 0;
		for(; index < times; index++) {
			arr[index] = kTimesNum;
		}
		numKinds--;
		HashSet<Integer> set = new HashSet<>();
		set.add(kTimesNum);
		while(numKinds != 0) {
			int curNum = 0;
			do {
				curNum = randomNum(range);
			}while(set.contains(curNum));
			numKinds--;
			for(int i = 0; i < m; i++) {
				arr[index++] = curNum;
			}
		}

		// 打乱顺序
		for(int i = 0; i < arr.length; i++) {
			int j = (int)(Math.random() * arr.length);
			int tmp = arr[i];
			arr[i] = arr[j];
			arr[j] = tmp;
		}
		return arr;
		
	}
	
	// 5. 创造随机数 [-range range]
	public static int randomNum(int range) {
		return (int)(Math.random() * (range + 1 )) -(int)(Math.random() * (range + 1 ));
	}
	
	// 4.打印数组
	public static void print(int[] arr) {
		for(int num : arr) {
			System.out.println(num + " ");
		}
	}
	
	
	// 5.测试
	public static void main(String[] args) {
		int kinds = 52;
		int range = 300;
		int max = 91;
		int testTimes = 100000;
		System.out.println("begin!!!");
		for(int i = 0; i < testTimes; i++) {
			int a = (int)(Math.random() * max) + 1;
			int b = (int)(Math.random() * max) + 1;
			int k = Math.min(a, b);
			int m = Math.max(a, b);
			
			// K < m
			if(k == m) {
				m++;
			}
			int[] arr = randomArray(kinds, range, k, m);
			int ans1 = km(arr, k, m);
			int ans2 = haspMapNum(arr, k, m);
			if(ans1 != ans2) {
				print(arr);
				System.out.println(" ");
				System.out.println("ans1 =" + ans1 + "ans2 " + ans2 );
				System.out.println("bad!!!");
				break;
			}
		}
		System.out.println("end!!!");
	}

}







































