package lesson03;

public class Code05_RingArrayToQueue {
	
	// 内部类
	public static class MyQueue{
		private int[] arr;
		private int pushi;
		private int polli;
		private int size;
		private final int limit;
		public MyQueue(int limit) {
			arr = new int[limit];
			pushi = 0;
			polli = 0;
			size = 0;
			this.limit = limit;
		}
		
		// push element
		public void push(int value) {
			if(size == limit) {
				throw new RuntimeException("queue is full!");
			}
			size++;
			arr[pushi] = value;
			pushi = nextIndex(pushi);
		}
		
		// pop element
		public int pop() {
			if(size == limit) {
				throw new RuntimeException("queue is epmty!");
			}
			size--;
			int ans = arr[polli];
			polli = nextIndex(polli);
			return ans;
		}
		private int nextIndex(int i) {
			return i < limit - 1 ? i + 1 : 0 ;
		}
	}
	
	
	
	
	
	
}
