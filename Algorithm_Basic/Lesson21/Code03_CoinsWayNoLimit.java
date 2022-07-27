package lesson21;

public class Code03_CoinsWayNoLimit {
	// brute dynamic recursion
	public static int coinsWay1(int[] arr, int aim) {
		if(arr == null || arr.length < 1) {
			return 0;
		}
		return process(arr, 0, aim);
	}
	public static int process(int[]arr, int index, int rest) {
		if(index == arr.length) {
			return rest == 0 ? 1 : 0;
		}
		int ways = 0;
		for(int sheet = 0; sheet * arr[index] <= rest; sheet++) {
			ways += process(arr, index + 1, rest - sheet * arr[index]);
		}
		return ways;
	}

	// dynamic program 1
	public static int coinsWay2(int[] arr, int aim) {
		if(arr == null || arr.length < 1) {
			return 0;
		}
		int N = arr.length;
		int[][] dp = new int[N + 1][aim + 1];
		dp[N][0] = 1;
		for(int index = N - 1; index >= 0; index--) {
			for(int rest = 0; rest <= aim; rest ++) {
				dp[index][rest] = 0;
				for(int sheet = 0; sheet * arr[index] <= rest; sheet++) {
					dp[index][rest] += dp[index + 1][ rest - sheet * arr[index]];
				}	
			}
		}
		return dp[0][aim];
	}
	// dynamic program 2
	public static int coinsWay3(int[] arr, int aim) {
		if(arr == null || arr.length < 1) {
			return 0;
		}
		int N = arr.length;
		int[][] dp = new int[N + 1][aim + 1];
		dp[N][0] = 1;
		for(int index = N - 1; index >= 0; index--) {
			for(int rest = 0; rest <= aim; rest++) {
				dp[index][rest]= (rest - arr[index]) >= 0 ? 
						dp[index + 1][rest] + dp[index][rest - arr[index]]: 
					    dp[index + 1][rest];
			}
		}
		return dp[0][aim];
	}	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
