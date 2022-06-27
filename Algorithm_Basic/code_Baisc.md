# lesson01

# Lesson03

0. > ==前置知识 for\while思想==
   >
   > + 首先明确，大问题是指什么，大问题是指，翻转整个链表，也就是将链表中的每个结点翻转过来，那么小问题就是将链表中的每个结点进行翻转，这就是把大问题转换成了小问题，解决完小问题就等同于大问题解决了。这里值得注意的是，一个小问题的解决需要上一个小问题搭建环境，最主要的就是解决完小问题后，要来到下一个小问题，还有的是，需要用到上一步的结论
   > + 解决单链表
   >   * 方法：将每个只头指针指向的结点的前后结点和其指针，也就是pre和next，给找出来，每次将头节点翻转后，pre和head就往前移（这一步的目的是为下一步问题搭建环境，即来到下一个问题）
   >   * 步骤：将pre和next指向null（主要是将pre指向null，可以想象null是在head结点之后，而next的作用主要是为翻转结点前找到结点的下一个结点）——> 将head指向的结点翻转（小问题的核心就是这个）——> 将pre和head指针往前移(来到下一个结点) 
   >
   > ==thought==
   >
   > 1. 对于链表的题，每次操作，是针对单个节点进行操作的，也就是每次循环是针对单个节点进行操作，那么对每个节点进行操作之前，要把这个结点的前后节点的指针要展开，即要找到他前后节点的指针pre和next，然后再对这个节点进行操作，一定要记住，链表的操作，从局部来说是对单个结点进行操作，找前后指针，一是为了对结点操作时，用的到，二是为下一步循环搭建环境，
   > 2. 对于while循环
   >
   >   + 每次循环完不单单要完成局部的功能，还有为下一步循环操作搭建环境。这里的局部功能是指，整体实现某个大功能，分成局部有限个小功能去实现，也就是操作也就是把大问题分解成小问题去做。这和递归很像，递归是从大问题依次分解成规模较小的问题，从大到小，而whle循环是，要解决一个大问题，要从小到大去做，也就是一上来把问题分解成有限个同等规模的小问题，依次把这些小问题去解决，这些小问题不是彼此独立的，可能解决上一个小问题的之后，要用到其结论，或者为下一步解决的小问题搭建环境。所以解决一个问题，不管要完成其局部功能，还要为下一步的问题的解决提供一定的帮助，但有的就不用，具体得看题目，或者用for还是while，for有时就不用为下一步搭建环境，因为i++会自动搭建环境，也就是说搭建环境这个for循环给做了，总体来说，还是得为下一步搭建环境，也就说得达到下一个问题
   >
   > ![image-20220624104457156](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202206272145764.png)
   >
   > 
   >
   > ==Master公式==
   >
   > > 子问题的规模必须是一致的，比如，T(N)  = T(N / 3) + T(N / 4)，子问题的规模不一致，这类递归就不能用master公式来估计时间复杂度，也就是子问题规模一致的才可以用master公式 
   >
   > ![](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202206272146524.png)
   >
   > ==HashMap==
   >
   > > 1. <DataType, DataType>,DataType如果是原生内置的数据类型，例如String，Integer，会把String类型的数据放进hashMap中；如果是Node，自定义数据类型，那么在hashmap中存放的是其地址
   > > 2. hashmap的增删查改的时间复杂度都是O(1)
   > > 3. hashset可以看成只有key，即形式是<DataType>
   >
   > ==按值传递和按址传递==
   >
   > ```java
   > int a = 1000;
   > int b = 1000;
   > System.out.println(a == b);        // true  按值传递，比对的是值
   > 
   > Integer aa = 1000;
   > Integer bb = 1000;
   > System.out.println(a == b);        // false  按址传递，比对的是地址
   > System.out.println(a.equals(b));   // 用equals方法比对的是值    
   > ```
   >
   > 

1. ==单向链表和双向链表的结构==

   ```java
   // 单向链表结点结构（可以实现成泛型）
   pubic class Node{
   public int value;
   pubic Node next;
   
   public Node(int data){
     value = data;
   }
   }
   
   // 双向链表的结点结构
   public class DoubleNode{
    public int value;
    public DoubleNode last;
    public DoubleNode nest;
   
    public DoubleNode(int data){
        value = data;
    }
   }
   ```

2. ==单链表和双链表的翻转==

   ![image-20220624105910022](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202206272141643.png)

   ```java
   // 翻转单向链表 
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
   // 翻转双向链表
       public static doubleNode reversedoubleList(doubleNode head) {
       	doubleNode next = null;
       	doubleNode pre = null;
       	while(head != null) {
       		next = head.next;
       		head.last = next;
       		head.next = pre;
       		pre = head;
       		head = next;
       	}
       	return pre;
       }
   ```

3. ==在链表中删除指定值的所有节点==

   > 首先判断链表非空，非空返回null。用pre表示从头节点到pre符合节点，cur表示去找符合要求的节点，cur没找到，就把cur所指的节点删掉，即让pre的next指向cur的next，如果找到就让pre来到cur的位置，最后返回head

   ![image-20220624194736194](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202206272144973.png)

   ```java
   public static class Node {
   		public int value;
   		public Node next;
   
   		public Node(int data) {
   			this.value = data;
   		}
   	}
   
   	// head = removeValue(head, 2);
   	public static Node removeValue(Node head, int num) {
   		// head来到第一个不需要删的位置
   		while (head != null) {
   			if (head.value != num) {
   				break;
   			}
   			head = head.next;
   		}
   		// 1 ) head == null
   		// 2 ) head != null
   		Node pre = head;
   		Node cur = head;
   		while (cur != null) {
   			if (cur.value == num) {
   				pre.next = cur.next;
   			} else {
   				pre = cur;
   			}
   			cur = cur.next;
   		}
   		return head;
   	}
   ```

4. ==用双链表实现栈和队列==

   ```java
   import java.util.LinkedList;
   import java.util.Queue;
   import java.util.Stack;
   
   public class Code03_DoubleEndsQueueToStackAndQueue {
   
   	public static class Node<T> {
   		public T value;
   		public Node<T> last;
   		public Node<T> next;
   
   		public Node(T data) {
   			value = data;
   		}
   	}
   
   	public static class DoubleEndsQueue<T> {
   		public Node<T> head;
   		public Node<T> tail;
   
   		public void addFromHead(T value) {
   			Node<T> cur = new Node<T>(value);
   			if (head == null) {
   				head = cur;
   				tail = cur;
   			} else {
   				cur.next = head;
   				head.last = cur;
   				head = cur;
   			}
   		}
   
   		public void addFromBottom(T value) {
   			Node<T> cur = new Node<T>(value);
   			if (head == null) {
   				head = cur;
   				tail = cur;
   			} else {
   				cur.last = tail;
   				tail.next = cur;
   				tail = cur;
   			}
   		}
   
   		public T popFromHead() {
   			if (head == null) {
   				return null;
   			}
   			Node<T> cur = head;
   			if (head == tail) {
   				head = null;
   				tail = null;
   			} else {
   				head = head.next;
   				cur.next = null;
   				head.last = null;
   			}
   			return cur.value;
   		}
   
   		public T popFromBottom() {
   			if (head == null) {
   				return null;
   			}
   			Node<T> cur = tail;
   			if (head == tail) {
   				head = null;
   				tail = null;
   			} else {
   				tail = tail.last;
   				tail.next = null;
   				cur.last = null;
   			}
   			return cur.value;
   		}
   
   		public boolean isEmpty() {
   			return head == null;
   		}
   
   	}
   
   	public static class MyStack<T> {
   		private DoubleEndsQueue<T> queue;
   
   		public MyStack() {
   			queue = new DoubleEndsQueue<T>();
   		}
   
   		public void push(T value) {
   			queue.addFromHead(value);
   		}
   
   		public T pop() {
   			return queue.popFromHead();
   		}
   
   		public boolean isEmpty() {
   			return queue.isEmpty();
   		}
   
   	}
   
   	public static class MyQueue<T> {
   		private DoubleEndsQueue<T> queue;
   
   		public MyQueue() {
   			queue = new DoubleEndsQueue<T>();
   		}
   
   		public void push(T value) {
   			queue.addFromHead(value);
   		}
   
   		public T poll() {
   			return queue.popFromBottom();
   		}
   
   		public boolean isEmpty() {
   			return queue.isEmpty();
   		}
   
   	}
   
   	public static boolean isEqual(Integer o1, Integer o2) {
   		if (o1 == null && o2 != null) {
   			return false;
   		}
   		if (o1 != null && o2 == null) {
   			return false;
   		}
   		if (o1 == null && o2 == null) {
   			return true;
   		}
   		return o1.equals(o2);
   	}
   }
   ```

5. ==用环形数组实现栈和队列==

   ```java
   // 目前只有队列
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
   ```

6. ==实现有getMin的栈==

   ```java
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
   ```

   7. ==两个栈实现队列==

      ```java
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
      ```

   8. ==两个队列实现栈==

      ```java
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
      ```

      

# lesson04

0. > ==前置知识  归并排序==
   >
   > * 昨天他说，我们现在的递归都是符合master公式的递归，而符合master公式的递归，子问题的规模还必须是一致的，那是不是讲，我们以后思考递归问题如何分解，是不是可以考虑如何将子问题的规模一致作为一个切入点
   > * O(N^2)的排序大量浪费了比较的时间，而O(N* log(N)),相对他们来说，比较的时间就不是很多
   > * 一个问题可以由一个包含8条语句的for循环解决，也可以由两个包含4条语句的for循环解决，选择后中，有助于思维清晰
   > * mergedsort把比较的信息，变成有序的东西，而有序的东西，可以做很多事。
   > * mergedsort启示：当求某个数的右边或者左边怎么样的，再求整体个数的时候，可以往mergesort靠
   > * 技巧：
   >
   >   + 指针不回退，前提得是有序的数，即单调性
   >   + 表示不存在的数可以用左开右闭

1. ==归并排序的递归实现和非递归实现==

   ```java
   public class Code01_MergeSort {
   	
   	// recursion implement
   	public static void mergeSort1(int[] arr) {
   		if(arr == null || arr.length < 2) {
   			return;
   		}
   		process(arr, 0, arr.length - 1);
   	}
   	
   	// 请把arr[L R]派有序
   	// T(N) = 2 * T(N / 2) + O(N);
   	// O(N * logN)
   	public static void process(int[]arr, int L, int R) {
   		if(L == R) {
   			return ;
   		}
   		int mid = L  + ((R - L)>> 1);
   		process(arr, L, mid);
   		process(arr,mid + 1, R);
   		merge(arr, L, mid, R);
   	}
   	public static void merge(int[] arr, int L, int mid, int R) {
   		int[] help = new int[R - L + 1];
   		int p1 = L;
   		int p2 = mid + 1;
   		int i = 0;
   		while(p1 <= mid && p2 <= R) {
   			help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
   		}
   		while(p1 <= mid) {
   			help[i++] = arr[p1++];
   		}
   		while(p2 <= R) {
   			help[i++] = arr[p2++];
   		}
   		for(i = 0; i < help.length; i++) {
   			arr[L + i] = help[i];
   		}
   	}
   	
   	// not recusion implement
   	public static void mergeSort2(int[] arr) {
   		if(arr == null || arr.length < 2) {
   			return;
   		}
   		int N = arr.length;
   
   		int mergeSize = 1;
   		while (mergeSize < N) {
   			int L = 0;
   			while (L < N) {
   				if (mergeSize >= N - L) { // N - 1 - L  + 1
   					break;                // 看arr[N - 1]到arr[L]之间的数的个数，是不是
   				}                         // 小于步长 
   				int m = L + mergeSize - 1;
   				int R = m + Math.min(mergeSize,N - 1 -m);
   				merge(arr, L, m, R);      // 看arr[N - 1]与arr[m]之间的数的个数，小于
   				L = R + 1;                // mergeSize的话，就说明右组里面的个数不够步长
   			}                             // 这一步的目的是为了防止R溢出
   			if(mergeSize > N /2) {        
   				break;
   			}
   			mergeSize <<= 1;
   		}
   	}
   }
   ```

2.  ==在一个数组中，一个数左边比它小的数的总和，叫该数的小和，所有数的小和累加起来，求数组小和==

   ```java
   // 小黑盒
   public class Code02_SmallSum {
   
   	public static int smallSum(int[] arr) {
   		if (arr == null || arr.length < 2) {
   			return 0;
   		}
   		return process(arr, 0, arr.length - 1);
   	}
   
   	public static int process(int[] arr, int L, int R) {
   		if (L == R) {
   			return 0;
   		}
   		int M = L + ((R - L) >> 1);
   		return process(arr, L, M) 
   				+ 
   				process(arr, M + 1, R) 
   				+ 
   				merge2(arr, L, M, R);
   	}
   
   	public static int merge1(int[] arr, int L, int M, int R) {
   	// int[]  help = new int[R + L -1]; bad!	
   		int[] help = new int[R - L + 1];
   	//  int p1 = 0; bad!	
   		int p1 = L;
   		int p2 = M + 1;
   		int ans = 0;
   		int i = 0;
   		while (p1 <= M && p2 <= R) {
   			ans += arr[p1] < arr[p2] ? (arr[p1] * (R - p2 + 1)) : 0;
   			help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
   		}
   		while (p1 <= M) {
   			help[i++] = arr[p1++];
   		}
   		while (p2 <= R) {
   			help[i++] = arr[p2++];
   		}
   		for (i = 0; i < help.length; i++) {
   			arr[L + i] = help[i++];
   		}
   		return ans;
   	}
   	
   	public static int merge2(int[] arr, int L, int M, int R) {
   		int[] help = new int[R - L + 1];
   		int p1 = L;
   		int p2 = M + 1 ;
   		int windowsR = M;
   		int ans = 0;
   		int k = 0;
   		for(int i = M + 1; i <= R; i++) {
   			while(windowsR >= L && arr[windowsR] >= arr[i]) {
   				windowsR--;
   			}
   			for(int j = L; j <= windowsR; j++) {
   				ans += arr[j];
   			}
   		}	
   		while(p1 <= M && p2 <= R) {
   			help[k++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
   		}
   		while(p1 <= M) {
   			help[k++] = arr[p1++];
   		}
   		while(p2 <= R) {
   			help[k++] = arr[p2++];
   		}
   		for (k = 0; k < help.length; k++) { 
   		// 	arr[k] = help[k++];  bad!
   			arr[L + k] = help[k++];
   		}
   		return ans;
   	}
   }
   ```

3. ==在一个数组中，任何一个前面的数a，和任何一个后面的数b，如果(a,b)是降序的，就称为降序对，给定一个数组arr，求数组的降序对总数量==

   ```java
   public class Code03_ReversePair {
   
   	public static int reversePair(int[] arr) {
   		if(arr == null || arr.length < 2) {
   			return 0;
   		}
   		return process(arr, 0, arr.length - 1);
   	}
   	
   	public static int process(int[] arr, int L , int R) {
   		if(L == R) {
   			return 0;
   		}
   		int M = L + ((R - L) >> 1);
   		return process(arr, L, M) 
   				+ 
   			   process(arr, M + 1, R) 
   				+ 
   			   merge2(arr, L, M, R);		   
   	}
   	
   	public static int merge1(int[] arr, int L, int M, int R) {
   		int[] help = new int[R - L + 1];
   	//  int i = arr.length - 1;  bad!  
   		int i = (help.length - 1);
   		int p1 = M;
   		int p2 = R;
   		int ans = 0;
   		while(p1 >= L && p2 >= (M + 1)){
   			ans += arr[p1] > arr[p2] ? (p2 - M) : 0;
   		    help[i--] = arr[p1] > arr[p2] ? arr[p1--] : arr[p2--];
   		}
   		while(p1 >= L) {
   			help[i--] = arr[p1--];
   		}
   	// 	while(p2 >= M);  bad!
   		while(p2 >= (M + 1)) {  
   			help[i--] = arr[p2--];
   		}
   		for(i = 0; i < help.length; i++) {
   			arr[L + i] = help[i];
   		}
   		return ans;
   	}
   	
   	public static int merge2(int[] arr, int L, int M, int R) {
   		int ans = 0;
   		int windowsR = M + 1;
   	//	for(int j = 0; j <= M; j++) {  bad!
   		for(int j = L; j <= M; j++) {
   			while(windowsR <= R && arr[windowsR] < arr[j]) {
   				windowsR++;
   			}
   			ans += windowsR - M - 1;
   		}
   		
   		int[] help = new int[R - L + 1];
   		int i = 0;
   		int p1 = L;
   		int p2 = M + 1;
   		while(p1 <= M && p2 <= R){
   			help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
   		}
   		while(p1 <= M) {
   			help[i++] = arr[p1++];
   		}
   		while(p2 <= R) {
   			help[i++] = arr[p2++];
   		}
   		
   	//	for(i = 0; i < arr.length; i++) {  bad!
   		for(i = 0; i < help.length; i++) {  
   			arr[L + i] = help[i];
   		}
   		return ans;
   	}
   }
   ```

4. ==在一个数组中，对于任何一个数num，求有多少个(后面的数*2)依然<num，返回总个数==

   ```java
   public class Code04_BiggerThanRightTwice {
   
   	public static int biggerThanRightTwice(int[] arr) {
   		if(arr == null || arr.length < 2) {
   			return 0;
   		}
   		return process(arr, 0, arr.length -1);
   	}
   	
   	public static int process(int[] arr, int L, int R) {
   		if(L == R) {
   			return 0;
   		}
   		int M = L + ((R - L) >> 1);
   		return process(arr, L, M) +
   			   process(arr, M + 1, R) + 
   			   merge(arr, L, M, R);
   	}
   	
   	public static int merge(int[] arr, int L, int M, int R) {
   		int[] help = new int[R + L - 1];
   		int  i = 0;
   		int p1 = L;
   		int p2 = M + 1;
   		int ans = 0;
   		int windowR = M + 1;
   		
   		for(i = L; i <= M ; i++) {
   			while(windowR <= R && (arr[windowR] * 2 < arr[i]) ) {
   				windowR++;
   			}
   			ans += windowR - M - 1;
   		}
   		while(p1 <= M && p2 <= R) {
   			help[i++] = arr[p1] < arr[p2] ? arr[p1] :arr[p2];
   		}
   		while(p1 <= M) {
   			help[i++] = arr[p1++];
   		}
   		while(p2 <= R) {
   			help[i++] = arr[p2++];
   		}
   		return ans;	
   	}
   }
   ```

   

# Lesson05

1. ==给定一个数组arr，两个整数lower和upper，返回arr中多少个子数组的累加和在[lowwer  upper]的范围上==

   ```java
   public class Code01_CountOfRangeSum {
   
   	public static int countRangeSum(int[] nums, int lower, int upper) {
   		if (nums == null || nums.length == 0) {
   			return 0;
   		}
   		long[] sum = new long[nums.length];
   		sum[0] = nums[0];
   		for (int i = 1; i < nums.length; i++) {
   			sum[i] = sum[i - 1] + nums[i];
   		}
   		return process(sum, 0, sum.length - 1, lower, upper);
   	}
   
   	public static int process(long[] sum, int L, int R, int lower, int upper) {
   		if (L == R) {
   			return sum[L] >= lower && sum[L] <= upper ? 1 : 0;
   		}
   		int M = L + ((R - L) >> 1);
   		return process(sum, L, M, lower, upper) + process(sum, M + 1, R, lower, upper)
   				+ merge(sum, L, M, R, lower, upper);
   	}
   
   	public static int merge(long[] arr, int L, int M, int R, int lower, int upper) {
   		int ans = 0;
   		int windowL = L;
   		int windowR = L;
   		// [windowL, windowR)
   		for (int i = M + 1; i <= R; i++) {
   			long min = arr[i] - upper;
   			long max = arr[i] - lower;
   			while (windowR <= M && arr[windowR] <= max) {
   				windowR++;
   			}
   			while (windowL <= M && arr[windowL] < min) {
   				windowL++;
   			}
   			ans += windowR - windowL;
   		}
   		long[] help = new long[R - L + 1];
   		int i = 0;
   		int p1 = L;
   		int p2 = M + 1;
   		while (p1 <= M && p2 <= R) {
   			help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
   		}
   		while (p1 <= M) {
   			help[i++] = arr[p1++];
   		}
   		while (p2 <= R) {
   			help[i++] = arr[p2++];
   		}
   		for (i = 0; i < help.length; i++) {
   			arr[L + i] = help[i];
   		}
   		return ans;
   	}
   
   }
   ```

2. ==荷兰国旗、快速排序1.0、 快速排序2.0、 快速排序3.0（随机快排）==

   ```java
   package lesson05;
   
   public class Code02_PartionAndQuickSort {
   	
   	public static void swap(int[] arr, int L, int R) {
   		int tmp = arr[L];
   		arr[L] = arr[R];
   		arr[R] = tmp;
   	}
   	
   	// arr[L R]上，以arr[R]位置的数做划分指
   	// <= 画出小于等于arr[R]的区域
   	public static int partition(int[] arr, int L, int R) {
   		if(L > R) {
   			return -1;
   		}
   		if(L == R) {
   			return L;
   		}
   		int lessL = L - 1;
   		int index = L;
   		while(index < R) {
   			if(arr[index] <= arr[R]) {
   				swap(arr, index, ++lessL);
   			}
   			index++;
   		}
   		swap(arr, R,++lessL);
   		return lessL;
   	}
   	
   	// arr[L R]荷兰国旗的划分
   	// <arr[R] ==arr[R] >arr[R]
   	// 返回等于区域的左右边界
   	public static int[] netherlandsFlag(int[] arr, int L, int R) {
   		if(L > R) {
   			return new int[]{-1, -1};
   		}
   		if(L == R) {
   			return new int[] {L, L};
   		}
   		int lessL = L -1;
   		int moreR = R;
   		int index = L;
   		while(index < moreR) {
   			if(arr[index] < arr[R]) {
   				swap(arr, index++, ++lessL);
   			}
   			if(arr[index] > arr[R]) {
   				swap(arr, index, --moreR);
   			}
   			if(arr[index] == arr[R]) {
   				index++;
   			}
   		}
   		swap(arr, R, moreR);
   		return new int[] {lessL + 1, moreR};
   	}
   	
   	// 去重数组
   	public static void qiucksort1(int[] arr) {
   		if(arr == null || arr.length <= 1) {
   			return;
   		}
   		process1(arr, 0, arr.length - 1);
   	}
   	
   	public static void process1(int[] arr, int L, int R) {
   		if(L >= R) {
   			return;
   		}
   		int M = partition(arr, L, R);
   		process1(arr, L, M - 1);
   		process1(arr, M + 1, R);
   	}
   	
   	// 非去重数组
   	public static void quicksort2(int[] arr) {
   		if(arr == null || arr.length <= 1) {
   			return;
   		}
   		process2(arr, 0, arr.length - 1);
   	}
   	public static void process2(int[] arr, int L, int R) {
   		if(L >= R) {
   			return;
   		}
   		int[] help = netherlandsFlag(arr, L , R);
   		process2(arr, L, help[0] - 1);
   		process2(arr, help[1] + 1, R);
   	} 
   	
   	// 随机快排
   	public static void quickSort3(int[] arr) {
   		if(arr == null || arr.length <= 1) {
   			return;
   		}
   		process3(arr, 0, arr.length - 1);
   	}
   	
   	public static void process3(int[] arr, int L, int R) {
   		if(L >= R) {
   			return;
   		}
   		int num = (int)(Math.random() * (R - L + 1));
   		swap(arr, (L + num), R);
   		int[] euqalArea = netherlandsFlag(arr, L, R);
   		process3(arr, L, euqalArea[0] - 1);
   		process3(arr, euqalArea[1] + 1, R);
   	}
   	
   
   	public static void main(String[] args) {
   		// TODO Auto-generated method stub
   
   	}
   
   }
   
   ```

3. ==快速排序的递归实现和非递归实现（栈版本、队列版本）==

   ```java
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
   
   ```

4. ==双向链表进行快速排序的实现==

   ```java
   public class Code04_DoubleLinkedListQuickSort {
   
   	public static class Node {
   		public int value;
   		public Node last;
   		public Node next;
   
   		public Node(int v) {
   			value = v;
   		}
   	}
   
   	public static Node quickSort(Node h) {
   		if (h == null) {
   			return null;
   		}
   		int N = 0;
   		Node c = h;
   		Node e = null;
   		while (c != null) {
   			N++;
   			e = c;
   			c = c.next;
   		}
   		return process(h, e, N).h;
   	}
   
   	public static class HeadTail {
   		public Node h;
   		public Node t;
   
   		public HeadTail(Node head, Node tail) {
   			h = head;
   			t = tail;
   		}
   	}
   
   	// L...R是一个双向链表的头和尾,
   	// L的last指针指向null，R的next指针指向null
   	// 也就是说L的左边没有，R的右边也没节点
   	// 就是一个正常的双向链表，一共有N个节点
   	// 将这一段用随机快排的方式排好序
   	// 返回排好序之后的双向链表的头和尾(HeadTail)
   	public static HeadTail process(Node L, Node R, int N) {
   		if (L == null) {
   			return null;
   		}
   		if (L == R) {
   			return new HeadTail(L, R);
   		}
   		// L..R上不只一个节点
   		// 随机得到一个随机下标
   		int randomIndex = (int) (Math.random() * N);
   		// 根据随机下标得到随机节点
   		Node randomNode = L;
   		while (randomIndex-- != 0) {
   			randomNode = randomNode.next;
   		}
   		// 把随机节点从原来的环境里分离出来
   		// 比如 a(L) -> b -> c -> d(R), 如果randomNode = c，那么调整之后
   		// a(L) -> b -> d(R), c会被挖出来，randomNode = c
   		if (randomNode == L || randomNode == R) {
   			if (randomNode == L) {
   				L = randomNode.next;
   				L.last = null;
   			} else {
   				randomNode.last.next = null;
   			}
   		} else { // randomNode一定是中间的节点
   			randomNode.last.next = randomNode.next;
   			randomNode.next.last = randomNode.last;
   		}
   		randomNode.last = null;
   		randomNode.next = null;
   		Info info = partition(L, randomNode);
   		// <randomNode的部分去排序
   		HeadTail lht = process(info.lh, info.lt, info.ls);
   		// >randomNode的部分去排序
   		HeadTail rht = process(info.rh, info.rt, info.rs);
   		// 左部分排好序、右部分排好序
   		// 把它们串在一起
   		if (lht != null) {
   			lht.t.next = info.eh;
   			info.eh.last = lht.t;
   		}
   		if (rht != null) {
   			info.et.next = rht.h;
   			rht.h.last = info.et;
   		}
   		// 返回排好序之后总的头和总的尾
   		Node h = lht != null ? lht.h : info.eh;
   		Node t = rht != null ? rht.t : info.et;
   		return new HeadTail(h, t);
   	}
   
   	public static class Info {
   		public Node lh;
   		public Node lt;
   		public int ls;
   		public Node rh;
   		public Node rt;
   		public int rs;
   		public Node eh;
   		public Node et;
   
   		public Info(Node lH, Node lT, int lS, Node rH, Node rT, int rS, Node eH, Node eT) {
   			lh = lH;
   			lt = lT;
   			ls = lS;
   			rh = rH;
   			rt = rT;
   			rs = rS;
   			eh = eH;
   			et = eT;
   		}
   	}
   
   	// (L....一直到空)，是一个双向链表
   	// pivot是一个不在(L....一直到空)的独立节点，它作为划分值
   	// 根据荷兰国旗问题的划分方式，把(L....一直到空)划分成:
   	// <pivot 、 =pivot 、 >pivot 三个部分，然后把pivot融进=pivot的部分
   	// 比如 4(L)->6->7->1->5->0->9->null pivot=5(这个5和链表中的5，是不同的节点)
   	// 调整完成后:
   	// 4->1->0 小于的部分
   	// 5->5 等于的部分
   	// 6->7->9 大于的部分
   	// 三个部分是断开的
   	// 然后返回Info：
   	// 小于部分的头、尾、节点个数 : lh,lt,ls
   	// 大于部分的头、尾、节点个数 : rh,rt,rs
   	// 等于部分的头、尾 : eh,et
   	public static Info partition(Node L, Node pivot) {
   		Node lh = null;
   		Node lt = null;
   		int ls = 0;
   		Node rh = null;
   		Node rt = null;
   		int rs = 0;
   		Node eh = pivot;
   		Node et = pivot;
   		Node tmp = null;
   		while (L != null) {
   			tmp = L.next;
   			L.next = null;
   			L.last = null;
   			if (L.value < pivot.value) {
   				ls++;
   				if (lh == null) {
   					lh = L;
   					lt = L;
   				} else {
   					lt.next = L;
   					L.last = lt;
   					lt = L;
   				}
   			} else if (L.value > pivot.value) {
   				rs++;
   				if (rh == null) {
   					rh = L;
   					rt = L;
   				} else {
   					rt.next = L;
   					L.last = rt;
   					rt = L;
   				}
   			} else {
   				et.next = L;
   				L.last = et;
   				et = L;
   			}
   			L = tmp;
   		}
   		return new Info(lh, lt, ls, rh, rt, rs, eh, et);
   	}
   }
   ```

   

