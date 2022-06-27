package lesson05;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class Code03_QuickSortRecursiveAndUnrecursive {
	
	// 荷兰国旗问题
	public static int[] netherlandsFlag(int[] arr, int L, int R) {
		if(L > R) {
			return new int[] {-1, -1};
		}
		if(L == R) {
			return new int[] {L , R};
		}
		
		int index = L;
		int less = L - 1;
		int more = R;
		
		while(index < more) {
			if(arr[index] == arr[R]) {
				index++;
			}
			if(arr[index] < arr[R]) {
				swap(arr, index++, ++less);
			}
			if(arr[index] > arr[R]) {
				swap(arr, index, --more);
			}
		}
		swap(arr, more, R);
		return new int[] {++less, more};
	}
	
	public static void swap(int[] arr, int L, int R) {
		int tmp = arr[L];
		arr[L] = arr[R];
		arr[R] = tmp;
	}
	
	// 快排递归版本
	public static void quickSort1(int[] arr) {
		if(arr == null || arr.length <= 1) {
			return;
		}
		process(arr, 0, arr.length - 1);
	}
	
	public static void process(int[] arr, int L, int R) {
		if(L >= R) {
			return;
		}
		int num = L + (int)(Math.random() * (R - L + 1)); 
		swap(arr, num, R);
		int[] equalArea = netherlandsFlag(arr, L, R);
		process(arr, L, equalArea[0] - 1);
		process(arr, equalArea[1] + 1, R);
	}
	
	
	// 快排非递归版本 需要的辅助类
	// 要处理的是什么范围上的排序
	public static class Op{
		public int L;
		public int R;
		
		public Op(int left, int right){
			L = left;
			R = right;
		}
	}
	
	// 快排3.0版本 非递归版本 用栈来执行
	public static void quickSort2(int[] arr) {
		if(arr == null || arr.length < 2) {
			return;
		}
		int N = arr.length;
		int num = (int)(Math.random() * (N));
		swap(arr, num, N - 1);
		int[] equalArea = netherlandsFlag(arr, 0, N - 1);
		int eL = equalArea[0];
		int eR = equalArea[1];
		
		Stack<Op> stack = new Stack<>();
		stack.push(new Op(0, eL - 1));
		stack.push(new Op(eR + 1, N - 1));
		
		while(!stack.isEmpty()) {
			Op op = stack.pop();
			if(op.L < op.R) {
				int newNum = op.L + (int)(Math.random() * (op.R - op.L + 1));
				swap(arr, newNum, op.R);
			    equalArea = netherlandsFlag(arr, op.L, op.R);
			    eL = equalArea[0];
			    eR = equalArea[1];
			    stack.push(new Op(op.L, eL - 1));
			    stack.push(new Op(eR + 1, op.R));
			}
		}

	}
	
	// 快排4.0 非递归版本 用队列来执行
	public static void qucikSort3(int[] arr) {
		if(arr == null || arr.length < 2) {
			return;
		}
		int N = arr.length;
		int num = (int)(Math.random() * N);
		swap(arr, num, N - 1);
		int[] equalArea = netherlandsFlag(arr, 0, N - 1);
		int eL = equalArea[0];
		int eR = equalArea[1];
		Queue<Op> queue = new LinkedList<>();
		queue.offer(new Op(0, eL - 1));
		queue.offer(new Op(eR + 1, N - 1));
		while(!queue.isEmpty()) {
			Op op = queue.poll();
			if(op.R > op.L) {
				num = op.L + (int)(Math.random() * (op.R - op.L + 1));
				swap(arr, num, op.R);
				equalArea = netherlandsFlag(arr, op.L, op.R);
				eL = equalArea[0];
				eR = equalArea[1];
				queue.offer(new Op(op.L, eL - 1));
				queue.offer(new Op(eR + 1, op.R));
			}
		}
	}	
}























