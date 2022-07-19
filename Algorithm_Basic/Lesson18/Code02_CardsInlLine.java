package Lesson18;

public class Code02_CardsInlLine {
	
	// 第一种方法： 暴力递归
	// 根据规则，返回获胜者的分数
	public static int win1(int[] arr) {
		if(arr == null || arr.length  < 1) {
			return 0;
		}
		int first = f1(arr, 0, arr.length);
		int second = g1(arr, 0, arr.length);
		return Math.max(first, second);
	}
	
	// 在arr[L R]上作为先手，获得最好的分数
	public static int f1(int[] arr, int L , int R) {
		if(L == R) {
			return arr[L];
		}
		int p1 = arr[L] + g1(arr, L + 1, R);
		int p2 = arr[R] + g1(arr, L, R - 1);
		return Math.max(p1, p2);
	}
	
	// 在arr[L R]上作为后手，获得的最好的分数
	public static int g1(int[] arr, int L, int R) {
		if(L == R) {
			return 0;
		}
		// p1和p2是对手所考虑出来得最两种情况下的最高分
		// 假设两个选手绝顶聪明，对手会把两种情况下最高分的最低分选出来
		// 自己能做的就是在对手做出选择后，把最高分选择出来
		int p1 = f1(arr, L + 1, R);
		int p2 = f1(arr, L, R - 1);
		return Math.min(p1, p2);
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
