package code_primary;

//  假设某个函数f可以等概率输出1 ~ 5 间的整数（包括边值0和5），
// 设计一个函数g，可以输出等概率输出7~19


public class EquProOut {

	// 1. 自己设计f函数
	public static int f() {
		return ((int)(Math.random() * 5)) + 1; 
	}
	
	// 2. 将f函数等概率输出0和1
	public static int f1() {
		int tmp = 0;
		do
		{
			tmp = f();
		}while(tmp == 3);
		return tmp = tmp > 3 ? 1 : 0;
	}
	
	// 3. 将f1组合成一串二进制，组成的二进制序列的最大值应该大于f的最大值，
	//    且该二进制的序列的位数最少
	public static int f2() {
		return (f1() << 4) + (f1() << 3) + (f1() << 2) + (f1() <<1) + (f1() << 0);
	}
	
	// 4. f2等概率输出0 ~ (2^5 - 1),将f2等概率输出7 ~ 19
	//    方法：当f2时为0~6 && 20 ~ 2^5 - 1不返回
	public static int f3() {
		int tmp = 0;
	    do {
	    	tmp = f2();
	    }while(((tmp <= 6) && (tmp >= 0)) || ((tmp >= 20) && (tmp <= (Math.pow(2, 5)) - 1)));
	    return tmp;
	}
	

	// 5. 测试
	public static void main(String[] args) {
		int[] arr= new int[13]; 
		for(int i = 0; i <= 100000; i++)
		{
			int num = 0;
		  	num = f3() - 7;
		  	arr[num]++;
		}
		for(int i = 0; i < 13; i++)
		{
			System.out.println((i + 7) + " " +arr[i] + " " );
		}
	}
}
















