package Lesson20;

public class Code02_HorseMap {
	 public static int horseMap1(int a, int b, int n) {
		 return process(0, 0, n, a, b);
	 }
	 
	 public static int process(int x, int y, int rest, int a, int b) {
		 if(x > 9 || x < 0 || y > 8 || y < 0) {
			 return 0;
		 }
		 if(rest == 0) {
			 return ((x == a) && (y == b)) ? 1 : 0;
		 }
		 int ways = process(x - 2, y + 1, rest - 1, a, b);
		 ways += process(x - 2, y - 1, rest - 1, a, b);
		 ways += process(x - 1, y + 2, rest - 1, a, b);
		 ways += process(x - 1, y - 2, rest - 1, a, b);
		 ways += process(x + 1, y + 2, rest - 1, a, b);
		 ways += process(x + 1, y - 2, rest - 1, a, b);
		 ways += process(x + 2, y + 1, rest - 1, a, b);
		 ways += process(x + 2, y - 1, rest - 1, a, b);
		 return ways;
	 }
	 
	 public static int horseMap2(int a, int b, int n) {
		 int[][][] dp = new int[10][9][n + 1];
		 dp[a][b][0] = 1;
		 for(int rest = 1; rest < n + 1; rest++) {
			 for(int x = 0; x < 10; x++) {
				 for(int y = 0; y < 9; y++) {
					 int ways = pick(x - 2, y + 1, rest - 1, dp);
					 ways += pick(x - 2, y - 1, rest - 1, dp);
					 ways += pick(x - 1, y + 2, rest - 1, dp);
					 ways += pick(x - 1, y - 2, rest - 1, dp);
					 ways += pick(x + 1, y + 2, rest - 1, dp);
					 ways += pick(x + 1, y - 2, rest - 1, dp);
					 ways += pick(x + 2, y + 1, rest - 1, dp);
					 ways += pick(x + 2, y - 1, rest - 1, dp);
					 dp[x][y][rest] = ways;
				 }
			 }
		 }
		 return dp[0][0][n];
	 }
	 
	public static int pick(int x, int y, int rest, int[][][] dp) {
		 if(x > 9 || x < 0 || y > 8 || y < 0) {
			 return 0;
		 }else {
			 return dp[x][y][rest];
		 }
	}
	
	public static void main(String[] args) {
		System.out.println(horseMap1(4, 5, 5));
		System.out.println(horseMap1(4, 5, 5));
	}
}














