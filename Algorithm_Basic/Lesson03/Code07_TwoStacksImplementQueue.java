package lesson03;
import java.util.Stack;
public class Code07_TwoStacksImplementQueue {
	 
	public static class TwoStackQueue{
		public Stack<Integer> stackPush;
		public Stack<Integer> stackPop;
		
		public TwoStackQueue() {
			stackPush = new Stack<Integer>();
			stackPop = new Stack<Integer>();
		}
		
		// push栈向pop栈倒数据
		private void pushToPop() {
			if(stackPop.empty()) {
				while(!stackPush.empty()) {
					stackPop.push(stackPush.pop());
				}
			}
		}
		
		public void add(int pushInt) {
			stackPush.push(pushInt);
			pushToPop();
		}
		
		public int poll() {
			if(stackPop.empty() && stackPush.empty()) {
				throw new RuntimeException("Queue is empty!");
			}
			pushToPop();
			return stackPop.pop();
		}
		
		public int peek() {
			if(stackPop.empty() && stackPush.empty()) {
				throw new RuntimeException("The queue is empty!");
			}
			pushToPop();
			return stackPop.peek();
		}
	}
}
