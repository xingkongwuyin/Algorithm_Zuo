package lesson21;

import java.util.HashMap;
import java.util.Map.Entry;

public class Code04_CoinsWaySameValueSamePaper {
	
	public static class Info{
		public int[] coins;
		public int[] sheet;
		
		public Info(int[] c, int[] z) {
			coins = c;
			sheet = z;
		}
	}
	public static Info getInfo(int[] arr) {
		HashMap<Integer, Integer> counts = new HashMap<>();
		for(int value : arr) {
			if(!counts.containsKey(value)) {
				counts.put(value, 1);
			}else {
				counts.put(value, counts.get(value) + 1);
			}
		}
		int N = counts.size();
		int[] coins = new int[N];
		int[] sheet = new int[N];
		int index = 0;
		for(Entry<Integer, Integer> entry : counts.entrySet()) {
			coins[index++] = entry.getKey();
			sheet[index++] = entry.getValue();
		}
		return new Info(coins, sheet);
	}
	
	public static int coinsway1(int[] arr, int aim) {
		if(arr == null || arr.length < 1) {
			return 0;
		}
		Info info = getInfo(arr);
		return process(0, aim, info.coins, info.sheet);
	}
	public static int process(int index, int rest, int[]coins, int[] sheet) {
		if(index == coins.length) {
			return rest == 0 ? 1 : 0;
		}
		int ways = 0;
		for(int zhang = 0; zhang <= sheet[index] && zhang * sheet[index] <= rest; zhang++) {
			ways += process(index + 1, rest - zhang * sheet[index], coins, sheet);
		}
		return ways;
	}
	
	public static int coinsway2(int[] arr, int aim) {
		if(arr == null || arr.length < 1) {
			return 0;
		}
		Info info = getInfo(arr);
		int N = info.coins.length;
		int[] coins = info.coins;
		int[] sheet = info.sheet;
		int[][] dp = new int[N + 1][aim + 1];
		dp[N][0] = 1;
		for(int index =  N - 1; index >= 0; index--) {
			for(int rest = 0; rest <= aim; rest++) {
				dp[index][rest] = dp[index + 1][rest];
				if(rest - coins[index] >= 0) {
					dp[index][rest] += dp[index][rest - coins[index]];
				}
				int num = coins[index] * (sheet[index] + 1);
				if((rest-  num) >= 0) {
					dp[index][rest] -= dp[index][num];
				}
			}
		}
		return dp[0][aim];
		
	}
		
}
