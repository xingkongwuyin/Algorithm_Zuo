package lesson03;
import java.util.Stack;

public class Code06_GetMinStack {
	public static class MyStack{
		private Stack<Integer> stackData;
		private Stack<Integer> stackMin;
		
		public MyStack(){
			this.stackData = new Stack<Integer>();
			this.stackMin = new Stack<Integer>();
			
		}
		public void push(int newNum) {
			if(this.stackMin.isEmpty()) {
				this.stackMin.push(newNum);
			}else if(newNum < this.getMin()){
				this.stackMin.push(newNum);
			}else {
				int newMin = this.getMin();
				this.stackMin.push(newMin);
			}
			this.stackData.push(newNum);
		}
		public int pop() {
			if(this.stackData.isEmpty()) {
				throw new RuntimeException("Your stack is empty!");
			}
			this.stackMin.pop();
			return stackData.pop();
		}
		public int getMin() {
			if (this.stackMin.isEmpty()) {
				throw new RuntimeException("Your stack is empty!");
			}
			return this.stackMin.peek();
		}
		
	}

}
