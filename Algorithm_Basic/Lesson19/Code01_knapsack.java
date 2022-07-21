package Lesson19;

public class Code01_knapsack {
	public static int knapsack1(int[] w, int[] v, int bag) { 
		if(w == null || v == null || w.length != v.length || w.length == 0 || v.length == 0) {
			return 0;
		}
		return process1(w, v, 0, bag);
	}
	
	public static int process1(int[] w, int[] v, int index, int rest) {
		if(rest < 0) {
			return -1;
		}
		if(index == w.length) {
			return 0;
		}
		// 不要index的货物
		int p1 = process1(w, v, index + 1, rest);
		int p2 = 0;
		int next = process1(w, v, index + 1, rest - w[index]);
		if(next != -1) {
			p2 = v[index] + next;
		}
		return Math.max(p1, p2);
	}
	
	// 动态规划
	public static int  knapsack2(int[] w, int[] v, int bag) {
		if(w == null || v == null || w.length != v.length || w.length == 0 || v.length == 0) {
			return 0;
		}
		int N = w.length;
		int[][] dp = new int[N + 1][bag + 1];
		for(int index = N -1; index >= 0; index--) {
			for(int rest = 0; rest <= bag; rest++) {
				int p1 = dp[index + 1][rest];
				int p2 = 0; 
				int next = rest - w[index] < 0 ? -1 : dp[index + 1][rest - w[index]]; 
				if(next != -1) {
					p2 = v[index] + next;
				}
				dp[index][rest] = Math.max(p1, p2);
			}
		}
		return dp[0][bag];
	}
	
	public static void main(String[] args) {
	
		int[] weight = {12,2,4,5,4,7,6,2};
		int[] value = {2,3,4,5,1,9,7,2};
		System.out.println(knapsack1(weight, value, 13));
		System.out.println(knapsack2(weight, value, 13));
	}
	
}

