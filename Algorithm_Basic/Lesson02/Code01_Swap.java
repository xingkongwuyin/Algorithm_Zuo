package Lesson02;

public class Code01_Swap {

	public static void main(String[] args) {
		int a = 7;
		int b = 0;
		
		// 交换
		a = a ^ b;
		System.out.println(a);
		b = a ^ b;
		System.out.println(b);
		a = a ^ b;
		System.out.println(a);
	}

}
