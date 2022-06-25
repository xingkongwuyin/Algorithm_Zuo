package lesson03;
import lesson03.Code01_ReverseList.Node;
import lesson03.Code01_ReverseList.doubleNode;
import java.util.Stack;

public class Code11_Summary {

	// reverse linked list
		public static Node reverseLinkedList(Node head) {
			Node pre = null;
			Node next = null;
			
			while(head != null) {
				next = head.next;
				head.next = pre;
				
				pre = head;
				head = next;
			}
			return pre;
		}
		
		// reverse double list
		public static doubleNode reverseDoubleList(doubleNode head) {
			doubleNode pre = null;
			doubleNode next = null;
			
			while(head != null) {
				next = head.next;
				head.last = next;
				head.next = pre;
				
				pre = head;
				head = next;
			}
			return pre;		
		}
		
		// delete given value
		public static Node deleteGivenValue(Node head, int num) {
			while(head != null) {
				if(head.value != num) {
					break;
				}
				head = head.next;
			}
			
			Node pre = head;
			Node cur = head;
			while(cur != null) {
				if(head.value == num) {
					pre.next = cur.next;
				}else {
					pre = cur;
				}
			}
			return head;
		}
		
		// ring array implements queue
		public static class MyQueue{
			private int[] arr;
			private int pushi; // end
			private int polli; // begin
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
					throw new RuntimeException("Queue is full");				
				}
				size--;
				arr[pushi] = value;
				pushi = nextIndex(pushi);
				
			}
			
			// pop element
			public int pop() {
				if(0 == size) {
					throw new RuntimeException("Queue is empty");
				}
				size++;
				int ans = arr[polli];
				polli = nextIndex(polli);
				return ans;
			}
			public int nextIndex(int i) {
				return i < limit - 1 ? (++i) : 0;
			}
		}
		
		// getMinStack
		public static class Mystack{
			private  Stack<Integer> stackData;
			private Stack<Integer> stackMin;
			
			public Mystack(){
				stackData = new Stack<Integer>();
				stackMin = new Stack<Integer>();
			}
			
			public void push(int newNum) {
				if(stackData.isEmpty()) {
					this.stackData.push(newNum);
					this.stackMin.push(newNum);
				}else if(newNum < this.getMin()) {
					this.stackData.push(newNum);
					this.stackMin.push(newNum);
				}else {
					this.stackData.push(newNum);
					this.stackMin.push(this.getMin());
				}
			}
			
			public int pop(){
				if(stackData.isEmpty()) {
					throw new RuntimeException("stack is empty!");
				}
				this.stackMin.pop();
				return this.stackData.pop();
			}
			
			public int getMin() {
				if(this.stackMin.isEmpty()) {
					throw new RuntimeException("stack is empty!");
				}
				return this.stackMin.peek();
			}
		}
		
		
		// two stacks implement queue
		public static class TwoStackImplement{
			public Stack<Integer> stackPush;
			public Stack<Integer> stackPop;
			
			public TwoStackImplement() {
				stackPush = new Stack<Integer>();
				stackPop = new Stack<Integer>();
			}
			
			// push data from stackpush to stackpop
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
					throw new RuntimeException("queue is empty");
				}
				pushToPop();
				return stackPop.pop();
			}
			
			public int peek() {
				if(stackPop.empty() && stackPush.empty()) {
					throw new RuntimeException("queue is empty");
				}
				pushToPop();
				return stackPop.peek();
			}
		}
		
	
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
