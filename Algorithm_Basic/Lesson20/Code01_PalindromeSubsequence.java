package lesson20;

public class Code01_PalindromeSubsequence {

	public static int PalindromeSubsequence1(String s) {
		if(s == null || s.length() == 0) {
			return 0;
		}
		char[] str = s.toCharArray();
		return process(str, 0, str.length - 1);
	}
	
	public static int process(char[] str, int L, int R) {
		if(L == R) {
			return 1;
		}else if(L == R - 1) {
			return str[L] == str[R] ? 2 : 1;
		}
				
//      上下两种方法都行，上面的方法没有重叠，下面的方法有重叠
//		int p1 = process(str, L + 1, R - 1);
//		一定以L开头，一定不以R结尾 
//		int p2 = process(str, L, R - 1);
//		int p3 = process(str, L + 1, R);
//		int p4 = str[L] == str[R] ? (2 + p1) : 0;
//		return Math.max(Math.max(p1, p2), Math.max(p3, p4));
		
		// 可能以L开头，一定不以R结尾
		int p2 = process(str, L, R - 1);
		int p3 = process(str, L + 1, R);
		int p4 = str[L] == str[R] ? (2 + process(str, L + 1, R - 1)) : 0;
		return Math.max(Math.max(p3, p2), p4);
		
		
	}
	public static int PalindromeSubsequence2(String s) {
		if(s == null || s.length() == 0) {
			return 0;
		}
		char[] str = s.toCharArray();
		int N = str.length;
		int[][] dp = new int[N][N];
		dp[N - 1][N - 1] = 1;
		for(int L = 0; L < N - 1;  L++) {
			dp[L][L] = 1;
			dp[L][L + 1] = str[L] == str[L + 1] ? 2 : 1;
		}
		for(int L = N - 3; L >= 0; L--) {
			for(int R = L + 2; R < N; R++) {
				dp[L][R] = Math.max(dp[L][R - 1], dp[L + 1][R]);
				if(str[L] == str[R]) {
					dp[L][R] = Math.max(dp[L][R], 2 + dp[L + 1][R - 1]);
				}
			}
		}
		return dp[0][N - 1];
		
	}
	
	public static void main(String[] args) {
		String s = "12gs3dnhdgjnhfjaf43gsgs21";
		System.out.println(PalindromeSubsequence1(s));
		System.out.println(PalindromeSubsequence2(s));


	}

}
