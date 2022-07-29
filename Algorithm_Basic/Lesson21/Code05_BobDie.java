package lesson21;

public class Code05_BobDie {
	public static double livePosibility1(int row, int col,int k, int N, int M) {
		return (double)process(row, col, k, N, M) / Math.pow(4, k);
	}
	// brute force recursion
public static long process(int row, int col, int rest, int N, int M) {
	if(row < 0 || row == N || col < 0 || col == M) {
		return 0;
	}
	if(rest == 0) {
		return 1;
	}
	long up = process(row - 1, col, rest - 1, N, M);
	long down = process(row + 1, col, rest - 1, N, M);
	long left = process(row, col - 1, rest - 1, N, M);
	long right = process(row, col + 1, rest - 1, N, M);
	return up + down + left + right;
}

// dp1
	public static double livePosibility2 (int row, int col,int k, int N, int M) {
		if(row < 0 || row == N || col < 0 || col == M) {
			return 0;
		}
		long[][][] dp = new long[N][M][k + 1];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				dp[i][j][0] = 1;
			}
		}
		for(int rest = 1; rest <=k; rest++) {
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < M; c++) {
					dp[r][c][rest] = pick(dp, N, M, r - 1, c, rest - 1);
					dp[r][c][rest] += pick(dp, N, M, r + 1, c, rest - 1);
					dp[r][c][rest] += pick(dp, N, M, r, c - 1, rest - 1);
					dp[r][c][rest] += pick(dp, N, M, r, c + 1, rest - 1);
				}
			}
		}
		return (double)dp[row][col][k] / Math.pow(4, k);
	}
	
	public static long pick(long[][][]dp, int N, int M, int row, int col, int rest) {
		if(row < 0 || row == N || col < 0 || col == M) {
			return 0;
		}
		return dp[row][col][rest];
	}
	
	public static void main(String[] args) {
		System.out.println(livePosibility1(6, 6, 10, 50, 50));
		System.out.println(livePosibility2(6, 6, 10, 50, 50));
}
}
