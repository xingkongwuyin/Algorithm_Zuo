package Lesson18;

public class Code01_RobotWalk {
	
	// 暴力递归
	public static int ways1(int N, int start, int aim, int K) {
		if(N < 2 || start < 1 || start > N || aim < 1 || aim > N || K < 1) {
			return -1;
		}
		return process1(start, K, aim, N);
	}
	
	// cur: 当前机器人所在的位置
	// rest: 还可以走的步数
	// aim: 最终的目标位置
	// N: 数组的最大的位置
	// 返回：机器人从cur出发,最大的位置为N，走过rest步之后，来到aim位置的方法数
	public static int process1(int cur, int rest, int aim, int N) {
		if(rest == 0) {
			// 可以理解成走零步，有几种方法数
			return cur == aim ? 1 : 0;
		}
		if(cur == 1) {
			return process1(2, rest - 1, aim, N) ;
		}
		if(cur == N){
			return process1(N - 1, rest - 1, aim, N);
		}
		return process1(cur - 1,  rest - 1, aim, N) + process1(cur + 1, rest - 1, aim, N); 
	}
		
	// 用增加缓存的方法优化暴力递归	
	public static int ways2(int N, int start, int aim, int K) {
		if(N < 2 || start < 1 || start > N || aim < 1 || aim > N || K < 1) {
			return -1;
		}
		int[][]dp = new int[N + 1][K + 1];
		for(int i = 0; i < N + 1; N++) {
			for(int j = 0; j < K + 1; j++) {
				dp[i][j] = -1;
			}
		}
		return process2(start, K, aim, N, dp);
	}
	
	
	// dp[cur][rest] = -1 -> process2(cur, rest)之前没算过
	// dp[cur][rest] != -1 -> process2(cur, rest)之前算过,返回值，dp[cur][rest]
	public static int process2(int cur, int rest, int aim, int N, int[][] dp) {
		if(dp[cur][rest] != -1) {
			return dp[cur][rest];
		}
		int ans = 0;
		if(rest == 0) {
			ans = cur == aim ? 1 : 0;
		}else if(cur == 1) {
			ans = process2(2, rest - 1, aim, N, dp);
		}else if(cur == N) {
			ans = process2(N - 1, rest - 1, aim , N, dp);
		}else {
			ans = process2(cur + 1, rest - 1, aim, N, dp) + process2(cur - 1, rest - 1, aim, N, dp);
		}
		dp[cur][rest] = ans;
		return ans;
	}
	
	// 动态规划优化暴力递归
	public static int ways3(int N, int start, int aim, int K) {
		if(N < 2 || start < 1 || start > N || aim < 1 || aim > N || K < 1) {
			return -1;
		}
		int[][] dp = new int[N+ 1][K + 1];
		dp[aim][0] = 1;
		// 列
		for(int rest = 1; rest < K + 1; rest++) {
			dp[1][rest] = dp[2][rest - 1]; 
			// 行
			for(int cur = 2; cur < N ; cur++) {
				dp[cur][rest] = dp[cur + 1][rest - 1] + dp[cur - 1][rest - 1];
			}
			dp[N][rest] = dp[N - 1][rest - 1];
		}
		return dp[start][K];
	}
	
	 
	
	public static void main(String[] args) {
		System.out.println(ways1(5, 2, 4, 8));
		System.out.println(ways1(5, 2, 4, 8));
		System.out.println(ways1(5, 2, 4, 8));
	}

}
