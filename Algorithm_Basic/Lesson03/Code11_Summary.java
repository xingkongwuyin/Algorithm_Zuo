package lesson03;
import lesson03.Code01_ReverseList.Node;
import lesson03.Code01_ReverseList.doubleNode;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

public class Code11_Summary {

	    // 1. reverse linked list
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
		
		
		
		
		// 2. reverse double list
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
		
		
		
		
		// 3. delete given value
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
		
		
		
		
		// 4. ring array implements queue
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
			
			// 5. push element
			public void push(int value) {
				if(size == limit) {
					throw new RuntimeException("Queue is full");				
				}
				size--;
				arr[pushi] = value;
				pushi = nextIndex(pushi);
				
			}
			
			// 6. pop element
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
		
		
		
		
		// 7. getMinStack
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
		
		
		
		
		// 8. two stacks implement queue
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
		
		
		
		// 9. two queues implement stack
		public static class TwoqueueImplementStack<T>{
			public Queue<T> queue;
			public Queue<T> help;
			
			public TwoqueueImplementStack(){
				queue = new LinkedList<>();
				help = new LinkedList<>();
			}
			
			public void push(T value) {
				queue.offer(value);
			}
			
			public T poll() {
				while(queue.size() > 1) {
					help.offer(queue.poll());
				}
				T ans = queue.poll();
				Queue<T> tmp = queue;
				queue = help;
				help = tmp;
				
				return ans;
			}
			
			public T peek() {
				while(queue.size() > 1) {
					help.offer(queue.poll());
				}
				T ans = queue.poll();
				help.offer(ans);
				Queue<T> tmp = queue;
				queue = help;
				help = tmp;
				
				return ans;
			}
		}
		
	
		
	

}





























