package Lesson05;
// 位图的增删查操作 

import java.util.HashSet;

public class BitMap {

	private long[] bits;
	
	// 1. 根据所给整数，new bits
	public BitMap(int max) {
		bits = new long[(max + 64) >> 6];
	}
	
	// 2. 往位图里添加某个位，即将位图的某位置1
	public void add(int num) {
		bits[num >> 6] |= (1L << (num & 63));      // num >> 6：num在第几个字（因为bits是long，所以是字）。从第0字开始
	}                                              // num & 63：num在第几位。从第0位开始
	
	// 3. 删除位图里的某位，即将位图的某位置0
	public void delete(int num) {
		bits[num >> 6] &= ~(1L << (num & 63));
	}
	
	// 4. 查询位图里是否有某位
	public boolean contains(int num) {
		return (bits[num >> 6] & (1L << (num & 63))) != 0 ;
	}
	
	// 5. 测试
	public static void main(String[] args) {
		System.out.println("Test begin!!!");
		int max = 10000;
		BitMap bitMap = new BitMap(max);
		HashSet<Integer> set = new HashSet<>();
		int testTime = 10000000;
		for (int i = 0; i < testTime; i++) {
			int num = (int) (Math.random() * (max + 1));
			double decide = Math.random();
			if (decide < 0.333) {
				bitMap.add(num);
				set.add(num);
			} else if (decide < 0.666) {
				bitMap.delete(num);
				set.remove(num);
			} else {
				if (bitMap.contains(num) != set.contains(num)) {
					System.out.println("Oops!");
					break;
				}
			}
		}
		for (int num = 0; num <= max; num++) {
			if (bitMap.contains(num) != set.contains(num)) {
				System.out.println("Oops!");
			}
		}
		System.out.println("Test end!!!");
	}


}
