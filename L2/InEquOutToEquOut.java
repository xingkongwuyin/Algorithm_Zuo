package code_primary;

//  Question：构造函数f1以0.8概率输出3，以0.2概率输出7，通过f函数，设计一个函数可以等概率输出5和8

public class InEquOutToEquOut {

	// 1. 构造f1函数
	public static int f1() {
		return Math.random() < 0.8 ? 3 : 7;      
	}
	
	// 2. f2，0和1的发生器
	public static int f2() {
		return f1() == 3 ? 0 : 1;
	}
	
	// 3. f3,等概率输出0和1
	public static int f3() {
		int tmp = 0;
		do {
			tmp = f2();
		}while(tmp == f2());
		return tmp;
	}
    
	// 4. 测试
   public static void main(String[] args) {
       int[] arr = new int[2];
       for(int i = 0;i < 10000; i++)
       {
    	   int num = f3();
    	   arr[num]++; 
       }
       System.out.println( arr[0] + " " + arr[1]);
}

}
