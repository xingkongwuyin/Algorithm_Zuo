package Lesson17;

public class Code02_Hanoi {
	
	public static void hanoi1(int n) {
		if(n > 0) {
			process1(n, "left", "right", "mid");
		}
	}
	
	public static void process1(int N, String from, String to, String others) {
		if(N == 1) {
			System.out.println("Move 1 from " + from + " to " + to);
		}else {
			process1(N - 1, from, others, to);
			// 这里的N是指第在这一层递归中，第N块圆盘
			System.out.println("Move " + N + " from " + from + " to " + to);
			process1(N - 1, others, to, from);
		}
	}
	
	public static void main(String[] args) {
		int n = 4;
		hanoi1(n);
		System.out.println("==============");
	}
}
