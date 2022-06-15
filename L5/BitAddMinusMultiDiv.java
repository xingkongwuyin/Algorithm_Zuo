package Lesson05;
// 位运算实现加减乘除

public class BitAddMinusMultiDiv {
   
	// 1. Add 
	// a + b =  a^b + (a & b) << 1
	// a ^ b 无进位相加的结果
	// （a & b） << 1 进位信息
	public static int Add (int a, int b) {
		int sum = a;
		while(b != 0 ) {
			sum = a ^ b;
			b= (a & b) << 1;
			a = sum;
		}
		return sum;
	}
	
	// 2. Minus 
	public static int Minus(int a, int b) {
		return Add(a,Add(~b,1));
	}
	
	// 3. Multi 
	public static int Multi(int a, int b) {
		int res = 0;
		while(b != 0) {
			if((b & 1) == 1) {
				res = Add(res,a);
			}
			a <<= 1;
			b >>>= 1;
		}
		return res;
	}
	
	// 4. Div 
	// a / b = c ————》 a = b * c ————》 a = b * (pow(2,m1) + pow(2,m2) + pow(2,m3) + ......)
	// ————》 a = (b << m1) + (b << m2) + (b << m3) + ......
	// c由多个二进制序列组合而成
	// 注意：在正式的逻辑之前一定要把每个数转成正数
	
	// 5. IsNeg 
	public static boolean IsNeg(int n) {
		return n < 0;
	}
	
	// 6. NegNum 
	public static int NegNum(int n) {
		return Add(~n,1);
	}
	
	// 7. Div 
	// 9 / 4 向下取整
	// 这个函数是将数先转成绝对值，再去计算，可系统最小值无法去转，所以无法计算系统最小值的除法
	public static int Div(int a, int b) {
		int x = IsNeg(a) ? NegNum(a) : a;
		int y = IsNeg(b) ? NegNum(b) : b;
		int res = 0;
		for(int i = 30; i >= 0; i++) {
			if((x >> i) >= y) {
				res |= (1 << i);
				x = Minus(x, y<<i);
			}
		}
		return IsNeg(a) ^ IsNeg(b) ? NegNum(res) : res;
	}
	
	// 8. Divide  适用系统最小值
	public static int Divide(int a, int b) {
		if( (a == Integer.MIN_VALUE) && (b == Integer.MIN_VALUE)){
			return 1;
		}
		else if(b == Integer.MIN_VALUE) {
			return 0;
		}
		else if(a == Integer.MIN_VALUE) {
			if(b == Integer.MIN_VALUE) {
				return Integer.MAX_VALUE;    // leetcode规定： 系统最小值除以-1，返回系统最大值
			}
			else {
				int ans = Div(a+1, b);                                 // a / b = ans
				return Add(ans, Div(Minus(a,Multi(ans, b)), b));       // (a + 1) / b  = ans1
			}                                                          // a - (ans1 * b) = ans2
		}                                                              // ans2 /b = ans3 
		else {                                                         // ans = ans1 + ans2
			return Div(a,b);
		}
	}
	
	
	
	public static void main(String[] args) {
       int a = -8;
       int b = -2;
       System.out.println(Multi(a,b));
	}

}



























