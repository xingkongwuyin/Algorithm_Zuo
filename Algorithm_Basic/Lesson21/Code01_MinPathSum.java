package lesson21;

public class Code01_MinPathSum {
	
	// 暴力递归
	public static int minPathSum1(int[][] m) {
		if(m == null || m.length == 0 || m[0] == null || m[0] .length == 0) {
			return 0;
		}
		return process(m, m.length - 1, m[0].length - 1);
	}
	
	// 从(0, 0) -> (i, j)的最短距离
	public static int process(int[][]m,  int i, int j) {
		if(i == 0 && j == 0) {
			return m[0][0];
		}else if(i == 0) {
			int sum = 0;
			for(int k = j; k >= 0; k--) {
				sum += m[0][k];
			}
			return sum;
		}else if(j == 0) {
			int sum = 0;
			for(int k = i; k >= 0; k--) {
				sum += m[i][0];
			}
			return sum;
		}
		
		if(i < 0 || j < 0) {
			return 0;
		}
		// 上边
		int p1 = m[i][j] + process(m, i - 1, j);
		int p2 = m[i][j] + process(m, i, j - 1);
		return Math.min(p1, p2);
	}
	
	// dp1
	public static int minPathSum2(int[][] m) {
		if(m == null || m.length == 0 || m[0] == null || m[0] .length == 0) {
			return 0;
		}
		int row = m.length;
		int col = m[0].length;
		int[][] dp = new int[row][col];
		dp[0][0] = m[0][0];
		for(int i = 1; i < row; i++) {
			dp[i][0] = dp[i - 1][0] + m[i][0];
		}
		for(int j = 1; j < col; j++) {
			dp[0][j] = dp[0][j - 1] + m[0][j];
		}
		for(int i = 1; i < row; i++) {
			for(int j = 1; j < col; j++) {
				int p1 = m[i][j] + dp[i - 1][j];
				int p2 = m[i][j] + dp[i][j - 1];
				dp[i][j] = Math.min(p1, p2);
			}
		}
		return dp[row - 1][col - 1];
	}
	

	public static int minPathSum3(int[][] m) {
		if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
			return 0;
		}
		int row = m.length;
		int col = m[0].length;
		int[] dp = new int[col];
		dp[0] = m[0][0];
		for (int j = 1; j < col; j++) {
			dp[j] = dp[j - 1] + m[0][j];
		}
		for (int i = 1; i < row; i++) {
			dp[0] += m[i][0];
			for (int j = 1; j < col; j++) {
				dp[j] = Math.min(dp[j - 1], dp[j]) + m[i][j];
			}
		}
		return dp[col - 1];
	}
	
	public static void main(String args[]) {
		int[][] m= {{1, 2, 2}, {2, 3, 5}};
		System.out.println(minPathSum1(m));
		System.out.println(minPathSum2(m));
		System.out.println(minPathSum3(m));
	}
	
	
	
	
}
