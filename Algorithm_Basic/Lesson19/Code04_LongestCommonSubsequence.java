package Lesson19;

public class Code04_LongestCommonSubsequence {
	public static int LongestCommonSubsequence1(String s1, String s2) {
		if(s1 == null || s2 == null || s1.length() <1 || s2.length() < 1) {
			return 0;
		}
		char[] str1 = s1.toCharArray();
		char[] str2 = s2.toCharArray();
		return process1(str1, str2, str1.length - 1, str2.length - 1);
	}
	 public static int process1(char[] str1, char[] str2, int i, int j) {
		 if(i == 0 && j == 0) {
			 return str1[i] == str2[2] ? 1 : 0;
		 }else if (i == 0){
			 if(str1[i] == str2[i]) {
				 return 1;
			 }else {
				 return process1(str1, str2, 0, j -1);
			 }
		 }else if(j == 0) {
			 if(str1[j] == str2[j]) {
				 return 1;
			 }else {
				 return process1(str1, str2, i - 1, 0);
			 }
		 }else {
			 int p1 = process1(str1, str2, i - 1, j);
			 int p2 = process1(str1, str2, i, j - 1);
			 int p3 = str1[i] == str2[j] ? (1 + process1(str1, str2, i - 1, j - 1)) : 0;
			 return Math.max(p1, Math.max(p2, p3));
		 }
	 }
	 
	 public static int LongestCommonSubsequence2(String s1, String s2) {
		 if(s1 == null || s2 == null || s1.length() <1 || s2.length() < 1) {
				return 0;
			}
			char[] str1 = s1.toCharArray();
			char[] str2 = s2.toCharArray();
			int N = str1.length;
			int M = str2.length;
			int[][] dp = new int[N][M];
			dp[0][0] = str1[0] == str2[0] ? 1 : 0;
			for(int j = 1; j < M; j++) {
				if(str1[0] == str2[j]) {
					 dp[0][j] = 1;
				 }else {
					 dp[0][j] = dp[0][j - 1];
				 }
			}
			for(int i = 1; i < N; i++) {
				if(str1[0] == str2[i]) {
					 dp[i][0] = 1;
				 }else {
					 dp[i][0] = dp[i - 1][0];
				 }
			}
			for(int i = 1; i < N; i++) {
				for(int j = 1; j < M; j++) {
					int p1 = dp[i - 1][j];
					int p2 = dp[i][j - 1];
					int p3 = str1[i] == str2[j] ? (1 + dp[i - 1][j -1]) : 0;
					dp[i][j] = Math.max(p1, Math.max(p2, p3));
				}
			}
			return dp[N - 1][M - 1];
	 }
	
	
	public static void main(String[] args) {
		String str1 = "123f2f4";
		String str2 = "1j2f32l4";
		System.out.println(LongestCommonSubsequence1(str1, str2));
		System.out.println(LongestCommonSubsequence2(str1, str2));

	}

}
