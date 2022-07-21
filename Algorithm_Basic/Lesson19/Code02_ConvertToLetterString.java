package Lesson19;

public class Code02_ConvertToLetterString {
	
	public static int ConvertToLetterString1(String str) {
		if(str ==null || str.length() == 0) {
			return 0;
		}
		return process1(str.toCharArray(), 0);
	}
	
	public static int process1(char[] str, int index) {
		if(index == str.length) {
			return 1;
		}
		if(str[index] == '0') {
			return 0;
		}
		int ways = process1(str, index + 1);
		if((index + 1) < str.length && ((str[index] - '0') * 10 -str[index + 1]) < 27) {
			ways += process1(str, index + 2);
		}
		return ways;
	}
	
	// 动态规划
	public static int ConvertToLetterString2(String s) {
		if(s ==null || s.length() == 0) {
			return 0;
		}
		char[] str = s.toCharArray();
		int N = str.length;
		int[] dp = new int[N + 1];
		dp[N] = 1;
		for(int index = N - 1; index >= 0; index--) {
			if(str[index] != '0'){
			int ways = dp[index + 1];
			if((index + 1) < str.length && (((str[index] - '0') * 10 -str[index + 1]) < 27)) {
				ways += dp[index + 2];
			}
			dp[index] = ways;
			}
		}
		return dp[0];
	}
	
	
	
	// 为了测试
		public static String randomString(int len) {
			char[] str = new char[len];
			for (int i = 0; i < len; i++) {
				str[i] = (char) ((int) (Math.random() * 10) + '0');
			}
			return String.valueOf(str);
		}

		// 为了测试
		public static void main(String[] args) {
			int N = 30;
			int testTime = 1000000;
			System.out.println("测试开始");
			for (int i = 0; i < testTime; i++) {
				int len = (int) (Math.random() * N);
				String s = randomString(len);
				int ans0 = ConvertToLetterString1(s);
				int ans1 = ConvertToLetterString2(s);
				if (ans0 != ans1 ) {	
					System.out.println(s);
					System.out.println(ans0);
					System.out.println(ans1);
					System.out.println("Oops!");
					break;
				}
			}
			System.out.println("测试结束");
		}


}










