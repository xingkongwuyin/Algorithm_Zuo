# lesson01

0. > ==**前置知识**==
   >
   > <img src="https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202206260750748.png" alt="image-20220613160034441" style="zoom:150%;" />
   >
   > <img src="https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202206260750731.png" alt="image-20220613160119245" style="zoom:200%;" />
   >
   > <img src="https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202206260750711.png" alt="image-20220613162935566" style="zoom:200%;" />
   >
   > > * 额外空间复杂度给的不算额外空间，即除了样本数据之外的空间。在整个算法流程中开辟的空间是有限的，跟样本数据量无关，用户需要的空间不算做空间复杂度，就是在一个函数中，开辟了一个数组，可是这个数组是函数的返回值，那么这个开辟的空间不算做额外空间复杂度。用户要什么，你给什么，输入什么参数，都不算额外空间。如果需要有限个变量，额外空间复杂度为O(1)。
   > > * 额外空间也是自主空间，和输入、功能都没有关的
   >
   > <img src="https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202206281015183.png" alt="image-20220613164238983" style="zoom:200%;" />
   >
   > ![image-20220613170441009](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202206281015736.png)
   >
   > > * 拼常数项直接测数据运行时间
   > > * 算法一定要先对样本有个认识，有了样本数量才能设计更好的算法
   > > * 最优解：先PK时间复杂度，再PK额外空间复杂度，如果两者都相同，那么这两个算法都是最优解，不用PK常数项
   >
   > > O(1),运行时间和样本没关系，N可以看成样本数量
   > >
   > > 常数时间的操作的时间复杂度为O(1)
   >
   > ![image-20220613171727212](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202206281016814.png)

   

1. **==选择排序、冒泡排序和插入排序==**

   ```java
   // 1. selectionSort
   	public static void selectionSort(int[] arr) {
   		if(arr == null || arr.length <=2) {
   			return;
   		}
   		for(int i = 0; i < arr.length - 1; i++) {
   			int min = i;
   			for(int j = i + 1; j < arr.length; j++) {
   				if(arr[min] > arr[j]) {
   					min = j;
   				}
   				swap(arr, min, i);
   			}
   
   		}
   	}
   
   // 2. bubbleSort
   	public static void bubbleSort(int[] arr) {
   		if(arr == null || arr.length <=2) {
   			return;
   		}
   		for(int i = 0; i < arr.length - 1; i++) {
   		int flag = 1;
   		for(int j = 0; i < arr.length -1 -i; j++) {
   			if(arr[j] > arr[j + 1]) {
   				flag = 0;
   				swap(arr, j , j + 1);
   			}
   		}
   		if(flag == 1) {
   			break;
   		}
   	}
   }
   
   // 3. insetionSort
   	public static void insertionsSort(int[] arr) {
   		if(arr == null || arr.length <=2) {
   			return;
   		}
   		for(int i = 1; i < arr.length; i++) {
   			for(int pre = i - 1; pre >= 0 && arr[pre] > arr[pre + 1]; pre--) {
   				if(arr[i] >= arr[i - 1]) {
   					continue;
   				}
   				swap(arr,pre, pre + 1);
   			}
   		}
   	}
   ```

2. **==二分查找==**

   > * 先定范围，再二分，后查找。
   > * 二分的体现是`mid = (mid + R) / 2`
   > * 查找怎么查找，找到了怎么样，找不到，下一步又该如何找，去哪个范围找

     ![image-20220619145943275](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202206281004716.png)

   ```java
   	public static boolean exist(int[] arr, int num) {
   		if(arr == null || arr.length == 0) {
   			return false;
   		}
   		int left = 0;
   		int right = arr.length - 1;
   		while(left <= right) {
   		//	int mid = left + (right - left) >> 1;   错误 （1）
   			int mid = left + ((right - left) >> 1);
   			if(arr[mid] == num) {
   				return true;
   			}else if (arr[mid] < num) {
   				left = mid + 1;
   			}else {
   				right = mid - 1;
   			}
   		}
   		return false;
   	}
     // 1. 左移运算符和右移运算符不会对变量产生影响，即right << 1,right的变量
     //    大小不发生变化
     // 2. + - 的优先级比左移和右移运算符高
     // left + (right - left) >> 1  == (right - left) / 2
     
   
     
   ```

   

3. **==有序数组中找到>=num最左的位置，和>=num最右的位置==**

   ```java
   // >=num
   public static int nearestLeftIndex(int[] arr, int num) {
   		if(arr == null || arr.length <= 0) {
   			return -1;
   		}
   		int index = -1;
   		int L = 0;
   		int R = arr.length - 1;
   		while(L <= R) {
   			int mid = (L + R) /2;
   			if(arr[mid] >= num) {
   				index = mid;
   				R = mid - 1;
   			}else {
   				L = mid + 1;
   			}	
   		}
   		return index;
   
   	}
   
   // <= num
   public static int nearestIndex(int[] arr, int num) {
       if(arr == null || arr.length <= 0) {
           return -1;
       }
       int index = -1;
       int L = 0;
       int R = arr.length - 1;
       while(L <= R) {
           int mid = (L + R) /2;
           if(arr[mid] <= num) {
               index = mid;
               L = mid + 1;
           }else {
               R = mid - 1;
           }
           return index;
       }
           
   ```

4. **==给定一个数组，找到该数组中的一个局部最小值==**

   ![image-20220619091420121](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202206281012581.png)

   ```java
   // 定义何为局部最小值：
   // arr[0] < arr[1]，0位置是局部最小；
   // arr[N-1] < arr[N-2]，N-1位置是局部最小；
   // arr[i-1] > arr[i] < arr[i+1]，i位置是局部最小；
   // 给定一个数组arr，已知任何两个相邻的数都不相等，找到随便一个局部最小位置返回
   public static int getLessIndex(int[] arr) {
   		if(arr == null || arr.length == 0) {
   			return -1;
   		}
   		if(arr.length == 1 || arr[0] < arr[1]) {
   			return 0;
   		}
   	     if(arr[arr.length - 1] < arr[arr.length - 2]) {
   			return arr.length - 1;
   		}
   	    int R = arr.length - 2;                 // （1）
   	    int L = 1;                      
   		while(L <= R) {
   			int mid = L + ((R - L) >> 1);       // （2）
          //   int mid = L + ((R - L) >> 2);       错误
   			if(arr[mid] > arr[mid + 1]) {
   				L = mid + 1;
   			}else if(arr[mid] > arr[mid - 1]) {
   				R = mid - 1;
   			}else {
   				return mid;
   			}
   		}
   		return -1;                             //  （3）
   	}
   ```



# Lesson02

0. > **==前置知识==**
   >
   > **==异或==**
   >
   > ```java
   > // 相同为0，相异为1
   > // 可以看成无进位相加
   > // 0 ^ N = N   N ^ N = 0
   > // 满足交换律和结合律，且同时满足交换律和结合律
   > 
   > // 交换律
   > a ^ b = b ^ a;
   > // 结合律
   > (a ^ b) ^ c = a ^ (b ^ c);
   > // 同时
   > (a ^ b) ^ c = (a ^ c) ^ b
   > ```



1. **==交换两个不相等的数，不用第三个变量==**

   ```java
   a = a ^ b;
   b = a ^ b;
   a = a ^ b; 
   ```

   ![image-20220609204101268](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202206281022177.png)



2. **==一个数组中有一个数出现了奇数次，其他数都出现了偶数次，怎么找到并打印这个数==**

   ```java
   	public static void printOddTimesNum(int[] arr) {
   		int eor = 0;
   		for(int i = 0; i < arr.length; i++) {
   			eor ^= arr[i];
   		}
   		System.out.println(eor);
   	}
   ```

3. **==怎么把一个int类型的数，提出最右侧的1来==**

   ```java
   a = 01011000  ----> ans = 00001000
   ans = a & (-a) = a & (~a + 1);    
   ```



4. **==一个数组中有两种数出现了奇数次，其它数出现了偶数次，怎么找到并打印这两种数==**

   ```java
   // analysis：两个数不相同 ——> 异或后eor必不等于0 ——> eor的某位必等于1 -----> 两个数必有一个数在eor最右侧等于1的那个位置，是1，另一个是0
   public static void printOddTimesNum2(int[] arr) {
   		int eor = 0;
   		for(int i = 0; i < arr.length; i++) {
   			eor ^= arr[i];
   		}
   
   		int mostRightOne = eor & (-eor);
   		int onlyOne = 0;
   		for(int i = 0; i < arr.length; i++) {
   			if((mostRightOne & arr[i]) != 0) {
   				onlyOne ^= arr[i];
   			}
   		}
   		System.out.println(eor + " " + (eor ^ onlyOne));		
   	} 
   ```



5. **==一个数组中有一种数出现了K次，其他数都出现了M次，M  > K >= 1,找到出现k次的数，要求额外空间复杂度为O(1)==**

   ```java
   //analysis：因为每个数可以看成32为二进制，所以将每个数的32个二进制位求出来，创建个数组help，来盛放二进制序列，分别加进数组中，然后模M，等于0，则说明那个数在该二进制位为0，否则为1，因为一个数出现了M次，那么这某位二进制为1，剩下的6个相同的数也得为1，所以得是M的倍数。
   
   // 建立长度为32的数组arr ——》循环求出每个数的2进制位，同时加到数组arr中 ——》对数组的每个元素取模M，如果等于0，那么要求的数在该位为1，否则为0
   
   public static int km(int[] arr, int k, int m) {
   		int[] help = new int[32];
   		for(int num : arr) {
   			for(int i = 0; i < 32; i++) {
   				help[i] += ((num >> i) & 1);    // arr上的num，从第1位到32位遍历num的二进制的每                                // 然后加到help数组中
   			}                                   // 一位，第i位是1，就在help数组第i个元素加一
   		}
   		int ans = 0;
   	    for(int i = 0; i < 32; i++) {
   	    	help[i] %= m;
   	    	if(help[i] != 0) {
   	    		ans |= (1 << i);
   	    	}
   	    }
   	    return ans;
   	}
   ```



6. **==题目六：一个数组中，有n种数，n - 1种数出现了M次，剩下一种数出现的次数不确定，但肯定大于等于1，且小于M，求 如果剩下的那个数出现的次数等于K次，则找出这个数，如果不是则返回找不到==**

   ```java
   public static int km(int[] arr, int k, int m) {
         		int[] help = new int[32];
   		for(int num : arr) {
   			for(int i = 0; i < 32; i++) {
   				help[i] += ((num >> i) & 1);    // arr上的num，从第1位到32位遍历num的二进制的每                                // 然后加到help数组中
   			}                                   // 一位，第i位是1，就在help数组第i个元素加一
   		}
   		int ans = 0;
   	    for(int i = 0; i < 32; i++) {
   	    	if(help[i] % m == 0) {
         	    		continue;
   	    	}
         	    	if(help[i] % m == k) {
   	    		ans |= (1 << i);
   	    	}else{
   	    		return -1;
   	    	}
         	    }
   	    // 因为ans == 0，但是不能确定0中了没有，所以下步遍历一下0出现的次数
   	  if(0 == ans) {
   		  int count = 0;
   		  for(int num : arr) {
   		    	if (num == ans) {
   		    		count++;
   		    	}
   		    }
   		    if(count != k) {
   		    	return -1;
   		    }
   	  }
   
   		return ans;
   	}
   ```

   

# Lesson03

0. > ==**前置知识 for\while思想**==
   >
   > + 首先明确，大问题是指什么，大问题是指，翻转整个链表，也就是将链表中的每个结点翻转过来，那么小问题就是将链表中的每个结点进行翻转，这就是把大问题转换成了小问题，解决完小问题就等同于大问题解决了。这里值得注意的是，一个小问题的解决需要上一个小问题搭建环境，最主要的就是解决完小问题后，要来到下一个小问题，还有的是，需要用到上一步的结论
   > + 解决单链表
   >   * 方法：将每个只头指针指向的结点的前后结点和其指针，也就是pre和next，给找出来，每次将头节点翻转后，pre和head就往前移（这一步的目的是为下一步问题搭建环境，即来到下一个问题）
   >   * 步骤：将pre和next指向null（主要是将pre指向null，可以想象null是在head结点之后，而next的作用主要是为翻转结点前找到结点的下一个结点）——> 将head指向的结点翻转（小问题的核心就是这个）——> 将pre和head指针往前移(来到下一个结点) 
   >
   > ==**thought**==
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
   > **==Master公式==**
   >
   > > 子问题的规模必须是一致的，比如，T(N)  = T(N / 3) + T(N / 4)，子问题的规模不一致，这类递归就不能用master公式来估计时间复杂度，也就是子问题规模一致的才可以用master公式 
   >
   > ![](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202206272146524.png)
   >
   > **==HashMap==**
   >
   > > 1. <DataType, DataType>,DataType如果是原生内置的数据类型，例如String，Integer，会把String类型的数据放进hashMap中；如果是Node，自定义数据类型，那么在hashmap中存放的是其地址
   > > 2. hashmap的增删查改的时间复杂度都是O(1)
   > > 3. hashset可以看成只有key，即形式是<DataType>
   >
   > **==按值传递和按址传递==**
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
   
   
   
1. **==单向链表和双向链表的结构==**

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

   

2. **==单链表和双链表的翻转==**

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

3. **==在链表中删除指定值的所有节点==**

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

4. **==用双链表实现栈和队列==**

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

   

5. **==用环形数组实现栈和队列==**

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

   

6. **==实现有getMin的栈==**

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
   
   


7. **==两个栈实现队列==**

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

   

8. **==两个队列实现栈==**

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

0. > **==前置知识  归并排序==**
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

1. **==归并排序的递归实现和非递归实现==**

   ![image-20220628111916971](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202206281119051.png)

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

   

2. **==在一个数组中，一个数左边比它小的数的总和，叫该数的小和，所有数的小和累加起来，求数组小和==**

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
   
           int windows = L;
           int ans = 0;
           for(int i = M + 1; i <= R; i++) {
               while(windows <= M && arr[windows] < arr[i]) {
                   windows++;
               }
               for(int j = L; j < windows; j++) {
                   ans += arr[j];
               }
           }
   
           int[] help = new int[R - L + 1];
           int p1 = L;
           int p2 = M + 1 ;
           int k = 0;
           while(p1 <= M && p2 <= R) {
               help[k++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
           }
           while(p1 <= M) {
               help[k++] = arr[p1++];
           }
           while(p2 <= R) {
               help[k++] = arr[p2++];
           }
           for ( k = 0; k < help.length; k++) { 
               // 	arr[k] = help[k++];  bad!
               arr[L + k] = help[k++];
           }
           return ans;
       }
   	
       // 这种方法是直接遍历，没有利用有序这个条件
       public static int merge2(int[] arr, int L, int M, int R) {
           // 求返回值	
           int ans = 0;
           for(int i = M + 1; i <= R; i++) {
               for(int j = L ; j <= M; j++) {
                   if(arr[j] < arr[i]) {
                       ans += arr[j];
                   }
               }
           }
   
           // 排序
           int[] help = new int[R - L + 1];
           int p1 = L;
           int p2 = M + 1 ;
           int k = 0;
           while(p1 <= M && p2 <= R) {
               help[k++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
           }
           while(p1 <= M) {
               help[k++] = arr[p1++];
           }
           while(p2 <= R) {
               help[k++] = arr[p2++];
           }
           for ( k = 0; k < help.length; k++) { 
               //	arr[k] = help[k++];  bad!
               arr[L + k] = help[k];
           }
           return ans;
       }
   
   }
   ```
   
   
   
3. **==在一个数组中，任何一个前面的数a，和任何一个后面的数b，如果(a,b)是降序的，就称为降序对，给定一个数组arr，求数组的降序对总数量==**

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

   

4. **==在一个数组中，对于任何一个数num，求有多少个(后面的数*2)依然<num，返回总个数==**

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

1. **==给定一个数组arr，两个整数lower和upper，返回arr中多少个子数组的累加和在[lowwer  upper]的范围上==**

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

2. **==荷兰国旗、快速排序1.0、 快速排序2.0、 快速排序3.0（随机快排）==**

   ![image-20220628110539878](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202206281105978.png)

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
   	
   	// 划分区域为<= 和 > 区域
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
   	
   	// 划分区域为 < = >三个区域
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

   

3. **==快速排序的递归实现和非递归实现（栈版本、队列版本）==**

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

4. **==双向链表进行快速排序的实现==**

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

   ​	

# Lesson06

1. **==比较器==**

   ```java
   package lesson06;
   
   import java.util.Arrays;
   import java.util.TreeMap;
   import java.util.ArrayList;
   import java.util.Comparator; 
   
   
   public class Code01_Comparator {
   	
   	public static class Student{
   		public String name;
   		public int id;
   		public int age;
   		
   		public Student(String name, int id, int age) {
   			this.name = name;
   			this.id = id;
   			this.age = age;
   		}
   	}
   	
   	// 比较器的思想： 只要知道如何比大小，比较器就可以调用内部统一的策略进行排序
   	// 任何比较：
   	// compare方法里，遵循一个同一的思想：
   	// 返回负数的时候，认为第一个参数应该排在前面
   	// 返回正数的时候，认为第二个参数应该排在前面
   	// 返回0的时候，认为无所谓谁放在前面
   	// 系统的排序的时间复杂度是O(N * log(N));
   	
   	// 根据id从小到大，但是如果id一样，按照年龄从小到大 
   	public static class IdUpAgeDownOrder implements Comparator<Student>{
   		
   		public int compare (Student s1, Student s2) {
   			return s1.id != s2.id ? s1.id - s2.id : s2.age - s1.age;
   		}
   	}
   	
   	// 根据id从小到大排
   	public static class idUpComparator implements Comparator<Student>{
   		public int compare(Student s1, Student s2) {
   			return s1.id - s2.id;
   		}
   	}
   	
   	// 根据id从大到小排
   	public static class idDownComparator implements Comparator<Student>{
   		public int compare(Student s1, Student s2) {
   			return s2.id - s1.id;
   		}
   	}
   	
   	// for test
   	public static void main(String[] args) {
   
   		Student s1 = new Student("A", 1, 11);
   		Student s2 = new Student("B", 2, 12);
   		Student s3 = new Student("C", 3, 14);
   		Student s4 = new Student("D", 6, 115);
   		Student s5 = new Student("E", 4, 131);
   		Student s6 = new Student("F", 4, 1111);
   		
   	//  数组排序
   	    Student[] students = new Student[] {s1, s2, s3, s4, s5, s6};	
       //	Arrays.sort(students, new idDownComparator());
       //  Arrays.sort(students, new idUpComparator());
           Arrays.sort(students, new IdUpAgeDownOrder());
   	//  System.out.println("ArraysSort IdUp");
   	    for(int i = 0; i < students.length; i++)
   	    {
   	//		System.out.println(students[i].name);
   	    }
   	  
   	//  链表排序
   	    ArrayList<Student> studentList = new ArrayList<>();
   	    studentList.add(s1);
   	    studentList.add(s2);
   	    studentList.add(s3);
   	    studentList.add(s4);
   	    studentList.add(s5);
   	    studentList.add(s6);
   	    
       //  studentList.sort(new idDownComparator());
       //  studentList.sort(new idUpComparator());
       //  studentList.sort(new IdUpAgeDownOrder());
           
           for(int i = 0; i < studentList.size(); i++) {
           	Student s =  studentList.get(i);
           	System.out.println(s.name);
           }
          
           
       // 有序表排序
       // 比较器里没有相同的Key，在这里也就是没有相同的对象。当放进去相同的key进去，有序表不会覆盖掉旧的，但是hashmap
       // 会。根据对象的某一属性进行比较 
          System.out.println("treemap sort"); 
       // TreeMap<Student, String>treeMap = new TreeMap<>(new idDownComparator()); 
       // TreeMap<Student, String>treeMap = new TreeMap<>((a, b) -> a.id - b.id);
          TreeMap<Student, String>treeMap = new TreeMap<>((a, b) -> a.id != b.id ? (a.id - b.id) : (b.hashCode() - a.hashCode()));  
          treeMap.put(s1, "A");
          treeMap.put(s2, "B");
          treeMap.put(s3, "C");
          treeMap.put(s4, "D");
          treeMap.put(s5, "E");
          treeMap.put(s6, "F");
          
          for(Student s : treeMap.keySet()) {
       	   System.out.println(s.name);
          }
   	}
   
   }
   ```
   





## 堆



0. **==前置知识 堆==**

   > * 0的父节点是自己
   >
   > * 大根堆：在一颗完全二叉树中，任何一颗子树的最大值等于其头节点的值
   > * 小根堆 ：在一颗完全二叉树中，任何一颗子树的最小值等于其头节点的值
   > * 堆也叫优先级队列
   >
   > ![image-20220629073429317](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202206292109802.png)

1. **==堆结构的实现==**

   ```java
   package lesson06;
   
   import java.util.Comparator;
   import java.util.PriorityQueue;
   
   public class Code02_Heap {
   	
   	   // construct maxHeap class
   	public static class MyMaxheap{
   		private int[] heap;
   		private final int limit;
   		private int heapSize;
   		
   		// 1. constructor
   		public MyMaxheap(int limit) {
   			heap = new int[limit];
   			this.limit = limit;
   			heapSize = 0;
   		}
   		
   		// 2. judge whether is empty
   		public boolean isEmpty() {
   			return heapSize == 0;
   		}
   		
   		// 3. judge whether is full
   		public boolean isFull() {
   			return heapSize == limit;
   		}
   		
   		// 4. push element
   		public void push(int value) {
   			if(heapSize == limit) {
   				throw new RuntimeException("heap is full");
   			}
   			heap[heapSize] = value;
   			heapInsert(heap, heapSize++);
   		}
   		
   		// 5. pop element
   		public int pop() {
   			if(heapSize == 0) {
   				throw new RuntimeException("the heap is empty");
   			}
   			int ans = heap[0];
   			swap(heap, 0, --heapSize);
   			heapify(heap, 0, heapSize);
   			return ans;
   		}
   	
   		// 6. 新加上来的数落在了index的位置，请依往上移动
   		//    剩下的数依然保持大根堆组织
   		private void heapInsert(int[] arr, int index) {
   			int left = (index - 1) / 2;
   			// 第一种比较方式
   			while(arr[index] > arr[left]) {
   				swap(arr, index, left);
   				index = left;
   				left = (index - 1) / 2; 
   			}
   			
   			// 第二种比较方式，选一种即可
   			while(left >= 0) {
   				if(arr[index] > arr[left]) {
   					swap(arr, index, left);
   				}else {
   					break;
   				}
   			}
   			index = left;
   			left = (index - 1) / 2;
   		}
   		
   		// 7. 从index位置，往下看，不断的下沉
   		//    较大的孩子都不再比index位置的数大，停！
   		private void heapify(int[] arr, int index, int heapSize) {
   			int left = (2 * index) + 1;
   			while(left <= heapSize - 1) {
   				int largest = (left + 1) <= heapSize - 1 && arr[left] < arr[left + 1] ?  (left + 1) : left;
   				if(arr[largest] > arr[index]) {
   					break;
   				}
   				swap(arr, index, largest);
   				index = largest;
   				left = (2 * index) + 1;
   			}						
   		}
   		 
   	// 8. swap
   		private void swap(int[] arr, int i, int j) {
   			int tmp = arr[i];
   			arr[i] = arr[j];
   			arr[j] = tmp;
   		}
   	}
   	
   	// 9. the constructor changing maxheap to minheap
   	public static class MyComparator implements Comparator<Integer>{
   		
   		public int compare(Integer o1, Integer o2) {
   			return o2 - o1;
   		}
   	}
   	
   	// 10. test
   	public static void main(String[] args) {
   		
   		// 系统默认小根堆
   		PriorityQueue<Integer> heap = new PriorityQueue<>();
   		heap.add(3);
   		heap.add(7);
   		heap.add(4);
   		heap.add(6);
   		
   		//System.out.println(heap.poll());
   		
   		// 由小根堆改写大根堆：添加自定义的构造器
   		PriorityQueue<Integer> heap1 = new PriorityQueue<Integer>(new MyComparator());
   		heap1.add(3);
   		heap1.add(7);
   		heap1.add(7);
   		heap1.add(6);
   		
   //		System.out.println(heap1.peek());
   		while(!heap1.isEmpty()){
   			System.out.println(heap1.poll());
   		}
   
   	}
   
   }
   ```



2. **==堆排序==**

   ```java
   package lesson06;
   
   public class Code03_HeapSort {
   	
   		 // 堆排序的额外空间复杂度为O(1) 
   	public static void heapSort(int[] arr) {
   	
   		// 第一种建立大根堆方式(经典)从上往下排 时间复杂度为O(N * logN)
   		// 这种方式既适用于数据一次给完的情况，也适合数据一次一次给的情况
   		for(int i = 0; i < arr.length; i++) {
   			heapInsert(arr, i);
   		}
   		// 第二种建立大根堆的方式 从下往上排  时间复杂度(logN)
   		// 只适用于数据一次性全部给完的情况
   		for(int i = arr.length - 1; i >=0; i--) {
   			heapify(arr, i, arr.length);
   		}
   		
   		int heapSize = arr.length;
   		swap(arr, 0, --heapSize);
           // O( N * logN)
   		while(heapSize > 0) {            // O(N)
   			heapify(arr, 0, heapSize);   // O(logN)
   			swap(arr, 0, --heapSize);    // O(1)
   		}
   		
   	}
   	
   	// 2. heapInsert
   	public static void heapInsert(int[] arr, int index) {
   		int left = (index - 1) / 2;
   		
   		// 第一种比较方式
   		while(arr[index] > arr[left]) {
   			swap(arr, index, left);
   			index = left;
   			left = (index - 1) / 2; 
   		}
   		
   		// 第二种比较方式，选一种即可
   		while(left >= 0) {
   			if(arr[index] > arr[left]) {
   				swap(arr, index, left);
   			}else {
   				break;
   			}
   		}
   		index = left;
   		left = (index - 1) / 2;
   	}
   	
   	// 3. heapify
   	public static void heapify(int[] arr, int index, int heapSize) {
   		int left = (2 * index) + 1;
   		while(left <= heapSize - 1) {
   			int largest = (left + 1) <= heapSize - 1 && arr[left] < arr[left + 1] ?  (left + 1) : left;
   			if(arr[largest] > arr[index]) {
   				break;
   			}
   			swap(arr, index, largest);
   			index = largest;
   			left = (2 * index) + 1;
   		}						
   	}
   	 
       // 4. swap
   	public static void swap(int[] arr, int i, int j) {
   		int tmp = arr[i];
   		arr[i] = arr[j];
   		arr[j] = tmp;
   	}
   }
   ```



3. **==已知一个几乎有序的数组。几乎有序是指，如果把数组排好顺序的话，每个元素移动的距离一定不超过k，k相对于数组长度来说是比较小的。请选择一个合适的排序策略，对这个数组进行排序==**

   ```java
   	public static void sortArrayDistanceLessK(int[] arr, int k){
   		
   		PriorityQueue<Integer> heap = new PriorityQueue<>();
   		
   		// 添加[0 k - 1]范围的数进去
   		int index = 0;
   		for(; index <= Math.min(arr.length - 1, k - 1); index++) {
   			heap.add(arr[index]);
   		}
   		int i = 0;
   		for(; index < arr.length; index++, i++) {
   			heap.add(arr[index]);
   			arr[i] = heap.poll();
   		}
   		while(!heap.isEmpty()) {
   			arr[i++] = heap.poll();
   		}
   		
   	}
   ```






# Lesson07

1. **==给定很多线段，每个线段都有两个数[start, end]，表示线段开始位置和结束位置，左右都是闭区间。返回线段最多重合区域中，包含了几条线段==**

   > 规定：
   >
   > 1）线段的开始和结束位置一定都是整数值
   > 2）线段重合区域的长度必须>=1

   > 思路：最大重合区域的左边界与某个线段的左边界重合。所以分别求出以每个线段的左边界为重合区域的左边界的重合线段数，最大的重合线段数就是所要求得
   
   ```java
   package lesson07;
   
   import java.util.Arrays;
   import java.util.Comparator;
   import java.util.PriorityQueue;
   
   public class Code01_CoverArea {
   
   	// 1. Lines class
   	public static class Line{
   		public int start;
   		public int end;
   		
   		public Line(int s, int e){
   			start = s;
   			end = e;
   		}
   	}
   	
   	// 2. overwrite comparator
   	public static class StartComparator implements Comparator<Line>{
   		
   		public int compare(Line L1, Line L2) {
   			
   			return L1.start - L2.start;
   		}
   	}
   	
   	// 3. coverArea
   	public static int coverArea(int[][] line) {
   		
   		Line[] lines = new Line[line.length];
   		for(int i = 0; i < line.length; i++) {
   			lines[i] = new Line(line[i][0], line[i][1]);
   		}
   		Arrays.sort(lines, new StartComparator());
   		int max = 0;
   		PriorityQueue<Integer> heap = new PriorityQueue<>();
   		for(int i = 0; i < line.length; i++) {
   			while(!heap.isEmpty() && heap.peek() <= lines[i].start) {
   				heap.poll();
   			}
   			heap.add(lines[i].end);
   			max = Math.max(max, heap.size());
   		}
   		return 0;
   	}
   	
   }
   ```




2. **==加强堆==**

   > * 使用加强堆的理由
   >   * 当堆里的某个对象的属性变了，现有的堆无法进行调整，即使调整也是O(N)的时间复杂度
   >
   > * 反向索引表
   >   * 用来记住，堆里每个对象在数组中的位置。因为堆是数组来实现的，所以找某个对象，只能遍历，这样一来时间复杂度就变高。建立一张反向索引表，记住每个对象在数组中的位置，找某个对象时，就方便很多，时间复杂度即使O(1)
   >
   > * HashMap
   >   * 不可以有相同的key，有的话就会覆盖掉。而在Treemap，根本就进不来
   >
   > * ArrayList（动态数组）
   >   * `set(i, v)`将i位置的元素，用v代替
   >   * `insert(i, v)`将i位置的元素及以后的元素向后移，在原来的i位置加入v

   <img src="https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202206302014582.png" alt="image-20220630104956536" style="zoom:200%;" /><img src="https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202206302014801.png" alt="image-20220630105036300" style="zoom:200%;" />

   ```java
   package lesson07;
   
   import java.util.ArrayList;
   import java.util.Comparator;
   import java.util.HashMap;
   import java.util.List;
   
   
   public class HeapGreater<T> {
   
   //	T一定要是非基础类型，有基础类型需求包一层
   	private ArrayList<T> heap;
   	private HashMap<T, Integer> indexMap;
   	private int heapSize;
   	private Comparator<? super T> comp;
   	
   	// 1. constructor
   	public HeapGreater(Comparator<? super T> c) {
   		
   		heap = new ArrayList<>();
   		indexMap = new HashMap<>();
   		heapSize = 0;
   		comp = c ;
   	}
   	
   	// 2. isEmpty
   	public boolean isEmpty() {
   		return heapSize == 0;
   	}
   	
   	// 3. size
   	public int size() {
   		return heapSize;
   	}
   	
   	// 4. whether contains the T obj
   	public boolean contains(T obj) {
   		return indexMap.containsKey(obj);
   	}
   	
   	// 5. peek
   	public T peek() {
   		return heap.get(0);
   	}
   	
   	// 6. push
   	public void push(T obj) {
   		
   		heap.add(obj);
   		indexMap.put(obj, heapSize);
   		heapInsert(heapSize++);
   	}
   	
   	// 7. pop
   	public T pop() {
   		
   		T ans = heap.get(0);
   		swap(0, heapSize - 1);
   		indexMap.remove(ans);
   		heap.remove(--heapSize);
   		heapify(0);
   		return ans;
   	}
   	
   	// 8. remove  
   	public void remove(T obj) {
   		
   		T replace = heap.get(heapSize - 1);
   		int num = indexMap.get(obj);
   		indexMap.remove(obj);
   		
   		if(obj != replace) {
   			heap.set(num, replace);
   			indexMap.put(replace, num);
   			resign(replace);
   		}
   	}
   	
   	// 9. resign 
   	public void resign(T obj) {
   		heapInsert(indexMap.get(obj));
   		heapify(indexMap.get(obj));
   	}
   	
   	// 10. 返回堆上的所有元素
   	public List<T> getALlElements(){
   		List<T> ans = new ArrayList<>();
   		for(T c : heap) {
   			ans.add(c);
   		}
   		return ans;
   	}
   	
   	// 11. heapInsert
   	private void heapInsert(int index) {
   		int R = (index - 1) / 2;
   		// 比较器返回负数，第一个参数放在前面，返回正数第二个参数返回前面
   		while(comp.compare(heap.get(index), heap.get(R)) < 0) {
   			swap(index, R);
   			index = R;
   			R = (index - 1) / 2;
   		}
   	}
   	
   	// 12. heapify
   	private void heapify(int index) {
   		int L = (index * 2) + 1;
   		while(L < heapSize) {
   			boolean b = comp.compare(heap.get(L + 1), heap.get(L))< 0;
   			int best = (L + 1 < heapSize - 1) && (comp.compare(heap.get(L + 1), heap.get(L))< 0) 
   					   ? L + 1 : L; 
   			if(best == index ) {
   				break;
   			}
   			swap(best, index);
   			index = best;
   			best = (index * 2) + 1;
   		}
   	}
   
   	// 13. swap
   	public void swap(int i, int j) {
   		T t1 = heap.get(i);
   		T t2 = heap.get(j);
   		heap.set(i, t2);
   		heap.set(j, t1);
   		indexMap.put(t1, j);
   		indexMap.put(t2, i);
   	}
   	
   }
   ```




# Lesson08

0. **==前置知识==**

    > **==前缀树==**
    >
    > * 哈希表的增删改查的时间复杂度是O(1),前提是单样本的数据的大小无足轻重。例如，放一个整型，32位，这样的数据大小无足轻重，如果放一个字符串，哈希表首先是要遍历一遍字符串的所有字符，再算出一个哈希值（用来内部组织），再放进哈希表，它的时间复杂度为O(K),k是字符串的长度。比如放100万个字符串，而平均长度为100，一个字符串那么放进哈希表的时候就是O(100),不能忽略字符串的长度
    >
    > * 当一个字符串数组放进哈希表的时间复杂度是O(M),M是字符的总个数。因为进哈希表的前提是遍历一遍字符。查询的某个字符是否存在的复杂度也是O(M),因为还是得遍历。
    >
    > * 而前缀树的放字符串的时间复杂度虽然也是O(M),但是查某个字符就不用每个都遍历，直接从头节点出发，看有没有通往所要查询字符串的字符的路即可。且功能比哈希表更加强大，因为可以查前缀。
    >
    > * **==排序算法的稳定性==**
    >
    >   ![image-20220702094218021](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207020942093.png)
    >
    > * 

1. **==前缀树==**

   > * 求"abc"字符串出现得次数，出现得次数等于e，也就是如果有c的路，那么c的路下面的节点的e值就是"abc"字符串出现的次数
   > * 有没有以字符串"bc"做前缀的字符串。从头节点出发，若是有b的路和c的路，可以看c的路下面的节点p的值

   <img src="https://dawn1314.oss-cn-beijing.aliyuncs.com/202207011423198.png" alt="image-20220701070613837" style="zoom:200%;" />

   ![image-20220701073531704](https://dawn1314.oss-cn-beijing.aliyuncs.com/202207011423802.png)

   ```java
   package lesson08;
   
   import java.util.HashMap;
   
   public class Code01_TrieTree {
   
   	// letter type
   	public static class Node1 {
   		// 0. field
   		public int pass; // 建一条路，就要来到新路的下端节点，则pass加1
   		public int end; // 每个字符串最后一个字符的那条路的下端节点加1
   		public Node1[] nexts; // 每个节点建立后，建立26条null路
   
   		// 1. constructor
   		// char tmp = 'b'; (tmp - 'a')
   		public Node1() {
   			pass = 0;
   			end = 0;
   			nexts = new Node1[26];
   		}
   	}
   
   	// suitable for 26 letters
   	public static class trieTree1 {
   
   		// 0. field
   		private Node1 root;
   
   		// 1.constructor
   		public trieTree1() {
   			root = new Node1();
   		}
   
   		// 2.1 insert
   		public void insert(String word) {
   			if (word == null) {
   				return;
   			}
   			char[] chs = word.toCharArray();
   			root.pass++;
   			Node1 node = root;
   			for (int i = 0; i < chs.length; i++) {
   				int index = chs[i] - 'a';
   				if (node.nexts[index] == null) {
   					node.nexts[index] = new Node1();
   				}
   				node = node.nexts[index];
   				node.pass++;
   			}
   			node.end++;
   		}
   
   		// 2.2 search out of the number of occurrence
   		public int search(String word) {
   			if (word == null) {
   				return 0;
   			}
   			char[] chs = word.toCharArray();
   			Node1 node = root;
   			for (int i = 0; i < chs.length; i++) {
   				int index = chs[i] - 'a';
   				if (node.nexts[index] == null) {
   					return 0;
   				}
   				node = node.nexts[index];
   			}
   			return node.end;
   		}
   
   		// 2.3 delete "word"
   		public void detele(String word) {
   			if (search(word) == 0) {
   				return;
   			}
   			char[] chs = word.toCharArray();
   			Node1 node = root;
   			node.pass--;
   			for (int i = 0; i < chs.length; i++) {
   				int index = chs[i] - 'a';
   				node.nexts[index].pass--;
   				if (node.nexts[index].pass == 0) {
   					node.nexts[index] = null;
   					return;
   				}
   				node = node.nexts[index];
   			}
   			node.end--;
   		}
   
   		// 2.4 prefixNumber
   		// how many of all the joined strings are
   		// prefixed with the string "word".
   		public int prefixNumber(String word) {
   			if (word == null) {
   				return 0;
   			}
   			Node1 node = root;
   			char[] chs = word.toCharArray();
   			for (int i = 0; i < chs.length; i++) {
   				int index = chs[i] - 'a';
   				if (node.nexts[index] == null) {
   					return 0;
   				}
   				node = node.nexts[index];
   			}
   			return node.pass;
   		}
   
   	}
   	
   	
   	// ASCII type
   	public static class Node2{
   		
   		public int pass;
   		public int end;
   		public HashMap<Integer, Node2> nexts;
   		
   		public Node2(){
   			pass = 0;
   			end = 0;
   			nexts = new HashMap<>();
   		}
   
   	}
   	
   	// trieTree2
   	public static class trieTree2{
   		// 0. field
   		private Node2 root;
   		
   		// 1. constructor
   		public trieTree2() {
   			root = new Node2();
   		}
   		
   		// 2.1 insert node
   		public void insert(String word) {
   			if(word == null) {
   				return;
   			}
   			char[] chs = word.toCharArray();
   			Node2 node2 = root;
   			node2.pass++;
   			for(int i = 0; i < chs.length; i++) {
   				int index = (int)chs[i];
   				if(!node2.nexts.containsKey(index)) {
   					node2.nexts.put(index, new Node2());
   				}
   				node2 = node2.nexts.get(index);
   				node2.pass++;
   			}
   			node2.end++;
   		}
   	
   		// 2.2 search out the number of occurrence
   		public int search(String word) {
   			if(word == null) {
   				return 0;
   			}
   			char[] chs = word.toCharArray();
   			int index = 0;
   			Node2 node2 = root;
   			for(int i = 0; i < chs.length; i++) {
   				index = (int)chs[i];
   				if(!node2.nexts.containsKey(index)) {
   					return 0;
   				}
   				node2 = node2.nexts.get(index);
   			}
   			return node2.end;
   		}
   		
   		// 2.3 delete "word"
   		public void delete(String word) {
   			if(search(word) == 0) {
   				return;
   			}
   			char[] chs = word.toCharArray();
   			int index = 0;
   			Node2 node2 = root;
   			node2.pass--;
   			for(int i = 0; i < chs.length; i++) {
   				index = (int)chs[i];
   				if(--node2.nexts.get(index).pass == 0) {
   					node2.nexts.remove(index);
   					return;
   				}
   				node2 = node2.nexts.get(index);			
   			}
   			node2.end--;
   		}
   		
   		// 2.4 prefixNumber
   		// how many of all the joined String are prefixed with
   		// "word".
   		public int prefixNumber(String word) {
   			if(word == null) {
   				return 0;
   			}
   			char[] chs = word.toCharArray();
   			int index = 0;
   			Node2 node2 = root;
   			for(int i = 0; i < chs.length; i++) {
   				index = (int)chs[i];
   				if(!node2.nexts.containsKey(index)) {
   					return 0;
   				}
   				node2 = node2.nexts.get(index);
   			}
   			return node2.pass;
   		}
   	}
   }	  
   ```
   



2. **==计数排序==**

   > * 数据限制：本身的大小须在一定范围内，即单个数据在`10<= num =< 100`
   > * 桶排序的思想，桶就是容器，所以利用容器的思想排序就是桶排序。在这里每一个年纪就是一个桶，看每个年纪有多少人
   > * 
   >
   > 
   >
   > * 排序
   >   * 基于比较的排序：冒泡、插入、选择、归并、快排和希尔排序。这类排序的时间复杂度极限为O(N * logN)
   >   * 不基于比较的排序：桶排序（计数排序）。这类排序时间复杂度极限为O(N)

   ![image-20220701200234470](https://dawn1314.oss-cn-beijing.aliyuncs.com/202207012002565.png)

​	

3.  **==基数排序==**

   > * 数据限制：非负的，能够表达成十进制的数
   >
   > * 先按个位排序，再按十位排序、、、最后按数据中的最高位排序。这里注意的是，先放进去的时候，那拿出来的时候也先拿出来

   ![image-20220701211825902](https://dawn1314.oss-cn-beijing.aliyuncs.com/202207012118023.png)

   ![image-20220701210900872](https://dawn1314.oss-cn-beijing.aliyuncs.com/202207012109973.png)

   ```java
   package class08;
   
   import java.util.Arrays;
   
   public class Code04_RadixSort {
   
   	// only for no-negative value
   	public static void radixSort(int[] arr) {
   		if (arr == null || arr.length < 2) {
   			return;
   		}
   		radixSort(arr, 0, arr.length - 1, maxbits(arr));
   	}
   
   	public static int maxbits(int[] arr) {
   		int max = Integer.MIN_VALUE;
   		for (int i = 0; i < arr.length; i++) {
   			max = Math.max(max, arr[i]);
   		}
   		int res = 0;
   		while (max != 0) {
   			res++;
   			max /= 10;
   		}
   		return res;
   	}
   
   	// arr[L..R]排序  ,  最大值的十进制位数digit
       // L..R,就扩展了，不一定将整个数组都要排序，也可以从L到R上排序、
       // 这个代码就是为了省十个桶，但还是利用了进桶出桶的思想
   	public static void radixSort(int[] arr, int L, int R, int digit) {
   		final int radix = 10;
   		int i = 0, j = 0;
   		// 有多少个数准备多少个辅助空间
   		int[] help = new int[R - L + 1];
   		for (int d = 1; d <= digit; d++) { // 有多少位就进出几次
   			// 10个空间
   		    // count[0] 当前位(d位)是0的数字有多少个
   			// count[1] 当前位(d位)是(0和1)的数字有多少个
   			// count[2] 当前位(d位)是(0、1和2)的数字有多少个
   			// count[i] 当前位(d位)是(0~i)的数字有多少个
   			int[] count = new int[radix]; // count[0..9]
   			for (i = L; i <= R; i++) {
   				// 103  1   3
   				// 209  1   9
   				j = getDigit(arr[i], d); // 将d位的数字提取出来，然后在count数组
   				count[j]++;              // 所对应的下表加1，表示该数字的个数加一
   			}
   			for (i = 1; i < radix; i++) {
   				count[i] = count[i] + count[i - 1];
   			}
   			for (i = R; i >= L; i--) {
   				j = getDigit(arr[i], d);
   				help[count[j] - 1] = arr[i];
   				count[j]--;
   			}
   			for (i = L, j = 0; i <= R; i++, j++) {
   				arr[i] = help[j];
   			}
   		}
   	}
   
   	public static int getDigit(int x, int d) {
   		return ((x / ((int) Math.pow(10, d - 1))) % 10);
   	}
   }
   
   ```




# Lesson09

0. ==**排序总结**==

<img src="https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207021654761.png" alt="image-20220702165422682" style="zoom:200%;" />

<img src="https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207021659805.png" alt="image-20220702165935732" style="zoom:200%;" />

> * 快排的常数时间要远远小于堆排和归并的，所以虽然时间复杂度一样，快排的速度最优 

<img src="https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207021707138.png" alt="image-20220702170734068" style="zoom:200%;" />

<img src="https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207021710589.png" alt="image-20220702171046532" style="zoom:200%;" />

<img src="https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207021718015.png" alt="image-20220702171856967" style="zoom:200%;" />

> 面试中可能会出这样的面试题
>
> * 为什么对不同的数据类型，排序的方法不一样，从上图中的两点回答
> * 

![](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207021725988.png)

![image-20220702174133196](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207021741306.png)

> *  上图的程序，结合了数据量小时，插排常数项小的优势和数据量大时，快排的调度优势。
> * 上面的60不是随机设的，是快排和插排的一个分解。
> * 也就是说，考虑一个算法时，要从数据量大时和小时两方面考虑，大时看复杂度，小时，看常数项。
> * 排序不仅仅解决排序的问题，可以利用排序的思想解其他的一些问题，就像前几几节课，讲到的利用归并排序解决小数和的问题





1. ==**前置知识 链表**==

   ![image-20220702200757084](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207022007173.png)

   ![image-20220702201959007](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207022019103.png)

   

2. **==快慢指针==**

   > 快指针：一次走两步；慢指针：一次走一步

   ![image-20220702201743557](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207022017650.png)

   

3. **==给定一个单链表的头节点head，请判断该链表是否为回文结构==**

   ![image-20220702202222751](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207022022850.png)

   ![image-20220702202517410](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207022025499.png)

   ![image-20220702203046334](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207022030452.png)

   ```java
   package class09;
   
   import java.util.Stack;
   
   public class Code02_IsPalindromeList {
   
   	public static class Node {
   		public int value;
   		public Node next;
   
   		public Node(int data) {
   			this.value = data;
   		}
   	}
   
   	// need n extra space stack slotution
   	public static boolean isPalindrome1(Node head) {
   		Stack<Node> stack = new Stack<Node>();
   		Node cur = head;
   		while (cur != null) {
   			stack.push(cur);
   			cur = cur.next;
   		}
   		while (head != null) {
   			if (head.value != stack.pop().value) {
   				return false;
   			}
   			head = head.next;
   		}
   		return true;
   	}
   
   	// need n/2 extra space
   	public static boolean isPalindrome2(Node head) {
   		if (head == null || head.next == null) {
   			return true;
   		}
   		Node right = head.next;
   		Node cur = head;
   		while (cur.next != null && cur.next.next != null) {
   			right = right.next;
   			cur = cur.next.next;
   		}
   		Stack<Node> stack = new Stack<Node>();
   		while (right != null) {
   			stack.push(right);
   			right = right.next;
   		}
   		while (!stack.isEmpty()) {
   			if (head.value != stack.pop().value) {
   				return false;
   			}
   			head = head.next;
   		}
   		return true;
   	}
   
   	// need O(1) extra space
   	public static boolean isPalindrome3(Node head) {
   		if (head == null || head.next == null) {
   			return true;
   		}
   		Node n1 = head;
   		Node n2 = head;
           // 快慢指针  看一下如果是偶数的时候，中点是否为上中点
   		while (n2.next != null && n2.next.next != null) { // find mid node
   			n1 = n1.next; // n1 -> mid
   			n2 = n2.next.next; // n2 -> end
   		}
   		// n1 中点
   		
   		
   		n2 = n1.next; // n2 -> right part first node
   		n1.next = null; // mid.next -> null
   		Node n3 = null;
   		while (n2 != null) { // right part convert
   			n3 = n2.next; // n3 -> save next node
   			n2.next = n1; // next of right node convert
   			n1 = n2; // n1 move
   			n2 = n3; // n2 move
   		}
   		n3 = n1; // n3 -> save last node
   		n2 = head;// n2 -> left first node
   		boolean res = true;
   		while (n1 != null && n2 != null) { // check palindrome
   			if (n1.value != n2.value) {
   				res = false;
   				break;
   			}
   			n1 = n1.next; // left to mid
   			n2 = n2.next; // right to mid
   		}
   		n1 = n3.next;
   		n3.next = null;
   		while (n1 != null) { // recover list
   			n2 = n1.next;
   			n1.next = n3;
   			n3 = n1;
   			n1 = n2;
   		}
   		return res;
   	}
   
   	public static void printLinkedList(Node node) {
   		System.out.print("Linked List: ");
   		while (node != null) {
   			System.out.print(node.value + " ");
   			node = node.next;
   		}
   		System.out.println();
   	}
   
   
   }
   
   ```

   

4. **==回文变形题==**

   > * 将原来的L1L2L3L4R1R2R3R4变成L1R1L2R2L3R3L4R4
   >
   > * 思路：还是先将上中点以下的结构反转，然后一对一对连接

   ![image-20220702204519382](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207022045478.png)

   ![image-20220702204609486](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207022046598.png)

   

5. ==将单向链表按某值划分成左边小、中间相等、右边大的形式==

   ![image-20220702205247145](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207022052223.png)

   ![image-20220702205459125](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207022054217.png)

   ![image-20220702210100585](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207022101711.png)

   > 有稳定性的需求把大尾留着，没有则把大尾去掉

   ```java
   package class09;
   
   public class Code03_SmallerEqualBigger {
   
   	public static class Node {
   		public int value;
   		public Node next;
   
   		public Node(int data) {
   			this.value = data;
   		}
   	}
   
   	public static Node listPartition1(Node head, int pivot) {
   		if (head == null) {
   			return head;
   		}
   		Node cur = head;
   		int i = 0;
   		while (cur != null) {
   			i++;
   			cur = cur.next;
   		}
   		Node[] nodeArr = new Node[i];
   		i = 0;
   		cur = head;
   		for (i = 0; i != nodeArr.length; i++) {
   			nodeArr[i] = cur;
   			cur = cur.next;
   		}
   		arrPartition(nodeArr, pivot);
   		for (i = 1; i != nodeArr.length; i++) {
   			nodeArr[i - 1].next = nodeArr[i];
   		}
   		nodeArr[i - 1].next = null;
   		return nodeArr[0];
   	}
   
   	public static void arrPartition(Node[] nodeArr, int pivot) {
   		int small = -1;
   		int big = nodeArr.length;
   		int index = 0;
   		while (index != big) {
   			if (nodeArr[index].value < pivot) {
   				swap(nodeArr, ++small, index++);
   			} else if (nodeArr[index].value == pivot) {
   				index++;
   			} else {
   				swap(nodeArr, --big, index);
   			}
   		}
   	}
   
   	public static void swap(Node[] nodeArr, int a, int b) {
   		Node tmp = nodeArr[a];
   		nodeArr[a] = nodeArr[b];
   		nodeArr[b] = tmp;
   	}
   
   	public static Node listPartition2(Node head, int pivot) {
   		Node sH = null; // small head
   		Node sT = null; // small tail
   		Node eH = null; // equal head
   		Node eT = null; // equal tail
   		Node mH = null; // big head
   		Node mT = null; // big tail
   		Node next = null; // save next node
   		// every node distributed to three lists
   		while (head != null) {
   			next = head.next;
   			head.next = null;
   			if (head.value < pivot) {
   				if (sH == null) {
   					sH = head;
   					sT = head;
   				} else {
   					sT.next = head;
   					sT = head;
   				}
   			} else if (head.value == pivot) {
   				if (eH == null) {
   					eH = head;
   					eT = head;
   				} else {
   					eT.next = head;
   					eT = head;
   				}
   			} else {
   				if (mH == null) {
   					mH = head;
   					mT = head;
   				} else {
   					mT.next = head;
   					mT = head;
   				}
   			}
   			head = next;
   		}
   		// 小于区域的尾巴，连等于区域的头，等于区域的尾巴连大于区域的头
   		if (sT != null) { // 如果有小于区域
   			sT.next = eH;
   			eT = eT == null ? sT : eT; // 下一步，谁去连大于区域的头，谁就变成eT
   		}
   		// 下一步，一定是需要用eT 去接 大于区域的头
   		// 有等于区域，eT -> 等于区域的尾结点
   		// 无等于区域，eT -> 小于区域的尾结点
   		// eT 尽量不为空的尾巴节点
   		if (eT != null) { // 如果小于区域和等于区域，不是都没有
   			eT.next = mH;
   		}
   		return sH != null ? sH : (eH != null ? eH : mH);
   	}
   
   	public static void printLinkedList(Node node) {
   		System.out.print("Linked List: ");
   		while (node != null) {
   			System.out.print(node.value + " ");
   			node = node.next;
   		}
   		System.out.println();
   	}
   
   	public static void main(String[] args) {
   		Node head1 = new Node(7);
   		head1.next = new Node(9);
   		head1.next.next = new Node(1);
   		head1.next.next.next = new Node(8);
   		head1.next.next.next.next = new Node(5);
   		head1.next.next.next.next.next = new Node(2);
   		head1.next.next.next.next.next.next = new Node(5);
   		printLinkedList(head1);
   		// head1 = listPartition1(head1, 4);
   		head1 = listPartition2(head1, 5);
   		printLinkedList(head1);
   
   	}
   
   }
   
   ```



6. **==特殊的单链表节点==**

   ![image-20220702215258925](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207022152043.png)

   ![image-20220702220858241](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207022208394.png)

   ![image-20220702221400140](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207022214280.png)
   
   ```java
   import java.util.HashMap;
   
   public class Code04_CopyListWithRandom {
   
   	public static class Node {
   		int val;
   		Node next;
   		Node random;
   
   		public Node(int val) {
   			this.val = val;
   			this.next = null;
   			this.random = null;
   		}
   	}
   
   	public static Node copyRandomList1(Node head) {
   		// key 老节点
   		// value 新节点
   		HashMap<Node, Node> map = new HashMap<Node, Node>();
   		Node cur = head;
   		while (cur != null) {
   			map.put(cur, new Node(cur.val));
   			cur = cur.next;
   		}
   		cur = head;
   		while (cur != null) {
   			// cur 老
   			// map.get(cur) 新
   			// 新.next ->  cur.next克隆节点找到
   			map.get(cur).next = map.get(cur.next);
   			map.get(cur).random = map.get(cur.random);
   			cur = cur.next;
   		}
   		return map.get(head);
   	}
   
   	public static Node copyRandomList2(Node head) {
   		if (head == null) {
   			return null;
   		}
   		Node cur = head;
   		Node next = null;
   		// 1 -> 2 -> 3 -> null
   		// 1 -> 1' -> 2 -> 2' -> 3 -> 3'
   		while (cur != null) {
   			next = cur.next;
   			cur.next = new Node(cur.val);
   			cur.next.next = next;
   			cur = next;
   		}
   		cur = head;
   		Node copy = null;
   		// 1 1' 2 2' 3 3'
   		// 依次设置 1' 2' 3' random指针
   		while (cur != null) {
   			next = cur.next.next;
   			copy = cur.next;
   			copy.random = cur.random != null ? cur.random.next : null;
   			cur = next;
   		}
   		Node res = head.next;
   		cur = head;
   		// 老 新 混在一起，next方向上，random正确
   		// next方向上，把新老链表分离
   		while (cur != null) {
   			next = cur.next.next;
   			copy = cur.next;
   			cur.next = next;
   			copy.next = next != null ? next.next : null;
   			cur = next;
   		}
   		return res;
   	}
   
   }
   
   ```
   
   

​	

# Lesson10

1. ==**链表相交**==

   ![image-20220703195346320](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207031953386.png)

   ![image-20220703200130971](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207032001049.png)

   

   ![image-20220703200732880](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207032007953.png)

   ![image-20220703201833180](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207032018263.png)

   > ==上一张图的rules==
   >
   > * 如果fast pointer走到空，肯定无环（真有环，带环的链表无空的）
   >
   > * 如果有环，快慢指针一定会相遇的，但不一定会在第一个入环节点相遇。快指针的步伐为2，慢指针为1
   >
   > * 当快慢指针相遇时，然后将快指针指向头节点，慢指针还在相遇的位置，且快指针的
   >
   >   步伐变为1，然后快慢指针一起走，最后肯定会在第一个入环节点相遇

   ![image-20220703204910163](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207032049259.png)

   ![image-20220703205818155](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207032058245.png)

   ![image-20220703211935452](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207032119530.png)

   ![image-20220703212256285](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207032122364.png)

   ![image-20220703213310636](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207032133711.png)

   ```java
   
   
   public class Code01_FindFirstIntersectNode {
   
   	public static class Node {
   		public int value;
   		public Node next;
   
   		public Node(int data) {
   			this.value = data;
   		}
   	}
   
   	public static Node getIntersectNode(Node head1, Node head2) {
   		if (head1 == null || head2 == null) {
   			return null;
   		}
   		Node loop1 = getLoopNode(head1);
   		Node loop2 = getLoopNode(head2);
   		// 若是相交，肯定两个都是无环，要么都是有环
           // 如果一个链表有环，一个链表无环，不可能相交
           if (loop1 == null && loop2 == null) {
   			return noLoop(head1, head2);
   		}
   		if (loop1 != null && loop2 != null) {
   			return bothLoop(head1, loop1, head2, loop2);
   		}
   		return null;
   	}
   
   	// 找到链表第一个入环节点，如果无环，返回null
   	public static Node getLoopNode(Node head) {
   		if (head == null || head.next == null || head.next.next == null) {
   			return null;
   		}
   		// n1 慢  n2 快
   		Node slow = head.next; // n1 -> slow
   		Node fast = head.next.next; // n2 -> fast
   		while (slow != fast) {
   			if (fast.next == null || fast.next.next == null) {
   				return null;
   			}
   			fast = fast.next.next;
   			slow = slow.next;
   		}
   		// slow fast  相遇
   		fast = head; // n2 -> walk again from head
   		while (slow != fast) {
   			slow = slow.next;
   			fast = fast.next;
   		}
   		return slow;
   	}
   
   	// 如果两个链表都无环，返回第一个相交节点，如果不想交，返回null
   	public static Node noLoop(Node head1, Node head2) {
   		if (head1 == null || head2 == null) {
   			return null;
   		}
   		Node cur1 = head1;
   		Node cur2 = head2;
   		int n = 0;
   		while (cur1.next != null) {
   			n++;
   			cur1 = cur1.next;
   		}
   		while (cur2.next != null) {
   			n--;
   			cur2 = cur2.next;
   		}
   		if (cur1 != cur2) {
   			return null;
   		}
   		// n  :  链表1长度减去链表2长度的值
   		cur1 = n > 0 ? head1 : head2; // 谁长，谁的头变成cur1
   		cur2 = cur1 == head1 ? head2 : head1; // 谁短，谁的头变成cur2
   		n = Math.abs(n);
   		while (n != 0) {
   			n--;
   			cur1 = cur1.next;
   		}
   		while (cur1 != cur2) { 
   			cur1 = cur1.next;
   			cur2 = cur2.next;
   		}
   		return cur1;
   	}
   
   	// 两个有环链表，返回第一个相交节点，如果不相交返回null
   	public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
   		Node cur1 = null;
   		Node cur2 = null;
   		if (loop1 == loop2) {
   			cur1 = head1;
   			cur2 = head2;
   			int n = 0;
   			while (cur1 != loop1) {
   				n++;
   				cur1 = cur1.next;
   			}
   			while (cur2 != loop2) {
   				n--;
   				cur2 = cur2.next;
   			}
   			cur1 = n > 0 ? head1 : head2;
   			cur2 = cur1 == head1 ? head2 : head1;
   			n = Math.abs(n);
   			while (n != 0) {
   				n--;
   				cur1 = cur1.next;
   			}
   			while (cur1 != cur2) {
   				cur1 = cur1.next;
   				cur2 = cur2.next;
   			}
   			return cur1;
   		}      else {
   			cur1 = loop1.next;
   			while (cur1 != loop1) {
   				if (cur1 == loop2) {
   					return loop1;
   				}
   				cur1 = cur1.next;
   			}
   			return null;
   		}
   	}
   }
   
   ```

   

2. ==**递归序**==

   > 一个结点总可以到自己三次，第一次自己的双亲结点到自己的时候，第二次跑完自己的左树到自己的时候，第三次跑完自己的右树到自己的时候。这也是二叉树递归能够返回的机制。

   ![image-20220704200734060](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207042007145.png)

3. ==**证明已知某一个二叉树节点的先序遍历和后序遍历，则A和B的交集是且尽是x的所有的祖先节点**==

   ![image-20220704201141239](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207042011334.png)

   ![image-20220704202729653](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207042027786.png)

   ![image-20220704212744287](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207042225746.png)

   > * 所有的结点分成，第一类x的祖先结点，第二类x结点自身，第三类x的孩子结点，第四类，x的作为左树的右兄弟结点，第五类，x作为右树的左兄弟结点们
   > * 先序遍历中，X结点的前边是它的祖先结点(可以用反证法去证)和它的作为右树的左兄弟的结点（可以用头 左 右去推 ），后边是它的孩子结点和作为左数的右兄弟结点
   > * 后续遍历中，x结点的前面是，它的孩子结点（可以用反证法去证）和作为右树的左兄弟结点；x结点的后边是它的祖先结点和它的作为左树的右兄弟结点（可以用左 右  头去证）
   > * 所以A和B的交集只有祖先结点

3. **==非递归实现先序遍历后序遍历==**

   ```java
   // preface 
   public static void pre(Node head) {
       System.out.println("pre-order");
       if(head != null) {
           Stack<Node> stack = new Stack<Node>();
           stack.add(head);
           while(!stack.isEmpty()) {
               head = stack.pop();
               System.out.println(head.value + " ");
               if(head.right != null) {
                   stack.push(head.right);
               }
               if(head.left != null) {
                   stack.push(head.left);
               }
           }
       }
       // post
       public static void pos(Node head) {
           System.out.println("in-order");
           if(head != null) {
               Stack<Node> stack1 = new Stack<Node>();
               Stack<Node> stack2 = new Stack<Node>();
               stack1.push(head);
               while(!stack1.isEmpty()) {
                   head = stack1.pop();
                   stack1.push(head);
                   if(head.left != null) {
                       stack1.push(head.left);
                   }
                   if(head.right != head.right) {
                       stack2.push(head.right);
                   }
               }
               while(!stack2.isEmpty()) {
                   head = stack2.pop();
                   System.out.print( head.value + " ");
               }
           }
       }
   ```

   

4. **==非递归实现中序遍历==**

   ![image-20220704225951625](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207050815120.png)

   ```java
   public static void in(Node cur) {
   		System.out.print("in-order: ");
   		if (cur != null) {
   			Stack<Node> stack = new Stack<Node>();
   			while (!stack.isEmpty() || cur != null) {
   				if (cur != null) {
   					stack.push(cur);
   					cur = cur.left;
   				} else {
   					cur = stack.pop();
   					System.out.print(cur.value + " ");
   					cur = cur.right;
   				}
   			}
   		}
   		System.out.println();
   	}
   ```

   

# lesson11

1. **==给定一个单链表的结点，要求从这个单链表删除这个这节点（没有给该单链表的头节点）==**

   > * 一个比较抖机灵的做法：将这个结点的属性刷成后面一个结点的属性，然后删除后面那个结点。
   > * 缺点：
   >   * 尾结点删除不掉，因为尾结点指向空，没有办法用刷值得方法去做
   >   * 如果存在这样的拷贝，如果结点是服务器，需要对外部依赖提供信息，这种拷贝的方法，就会导致被删除的结点无法给外部依赖提供信息
   >   * 可能不存在这样的拷贝，因为如果结点的属性都是一些指纹等机密信息，是不允许拷贝的
   > * 总结：想要删除一个结点，一定要找到这个节点的前一个结点

   ![image-20220705083849432](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207050838510.png)



2. **==实现二叉树的按层遍历 1）==**

   ![image-20220705084029825](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207050840879.png)

   ![image-20220705085808279](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207050858376.png)

   ![image-20220705090236503](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207050902602.png)

   ```java
   import java.util.LinkedList;
   import java.util.Queue;
   
   public class Code01_LevelTraversalBT {
   
   	public static class Node {
   		public int value;
   		public Node left;
   		public Node right;
   
   		public Node(int v) {
   			value = v;
   		}
   	}
   
   	public static void level(Node head) {
   		if (head == null) {
   			return;
   		}
           // queue是一个接口名。stack直接是一个类
           // LinkedList底层是双端队列，可以用来实现单向队列
   		Queue<Node> queue = new LinkedList<>();
   		queue.add(head);
   		while (!queue.isEmpty()) {
   			Node cur = queue.poll();
   			System.out.println(cur.value);
   			if (cur.left != null) {
   				queue.add(cur.left);
   			}
   			if (cur.right != null) {
   				queue.add(cur.right);
   			}
   		}
   	} 
   }
   
   ```



3. **==二叉树的序列化和反序列化==**

   ![image-20220705090822434](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207050908482.png)

   ![image-20220705091344117](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207050913207.png)

   ![image-20220705092208614](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207050922697.png)

   ```java
   import java.util.LinkedList;
   import java.util.Queue;
   import java.util.Stack;
   
   public class Code02_SerializeAndReconstructTree {
       /*
        * 二叉树可以通过先序、后序或者按层遍历的方式序列化和反序列化，
        * 以下代码全部实现了。
        * 但是，二叉树无法通过中序遍历的方式实现序列化和反序列化
        * 因为不同的两棵树，可能得到同样的中序序列，即便补了空位置也可能一样。
        * 比如如下两棵树
        *         __2
        *        /
        *       1
        *       和
        *       1__
        *          \
        *           2
        * 补足空位置的中序遍历结果都是{ null, 1, null, 2, null}
        *       
        * */
   	public static class Node {
   		public int value;
   		public Node left;
   		public Node right;
   
   		public Node(int data) {
   			this.value = data;
   		}
   	}
   
   	public static Queue<String> preSerial(Node head) {
   		Queue<String> ans = new LinkedList<>();
   		// 将以head为头结点的树的序列化的结果填到ans里面
           pres(head, ans);
   		return ans;
   	}
   
   	public static void pres(Node head, Queue<String> ans) {
   		if (head == null) {
               // 队列里面是可以放空的，所以可以放null。也可以放其他的占                位符，例如“#”
   			ans.add(null);
   		} else {
   			ans.add(String.valueOf(head.value));
   			pres(head.left, ans);
   			pres(head.right, ans);
   		}
   	}
   
   	
   
   	public static Node buildByPreQueue(Queue<String> prelist) {
   		if (prelist == null || prelist.size() == 0) {
   			return null;
   		}
   		return preb(prelist);
   	}
   
   	public static Node preb(Queue<String> prelist) {
   		String value = prelist.poll();
   		if (value == null) {
   			return null;
   		}
   		Node head = new Node(Integer.valueOf(value));
   		head.left = preb(prelist);
   		head.right = preb(prelist);
   		return head;
   	}
   
   
   
   
   	public static Queue<String> levelSerial(Node head) {
   		Queue<String> ans = new LinkedList<>();
   		if (head == null) {
   			ans.add(null);
   		} else {
   			ans.add(String.valueOf(head.value));
   			Queue<Node> queue = new LinkedList<Node>();
   			queue.add(head);
   			while (!queue.isEmpty()) {
   				head = queue.poll();    // head 父   子
   				if (head.left != null) {// 每一个结点只序列化自己                                            的孩子
   					ans.add(String.valueOf(head.left.value));
   					queue.add(head.left);
   				} else {
   					ans.add(null);
   				}
   				if (head.right != null) {
   					ans.add(String.valueOf(head.right.value));
   					queue.add(head.right);
   				} else {
   					ans.add(null);
   				}
   			}
   		}
   		return ans;
   	}
   
   	public static Node buildByLevelQueue(Queue<String> levelList) {
   		if (levelList == null || levelList.size() == 0) {
   			return null;
   		}
   		Node head = generateNode(levelList.poll());
   		Queue<Node> queue = new LinkedList<Node>();
   		if (head != null) {
   			queue.add(head);
   		}
   		Node node = null;
           // 利用父来反序列化自己的孩子
   		while (!queue.isEmpty()) {
   			node = queue.poll(); 
   			node.left = generateNode(levelList.poll());
   			node.right = generateNode(levelList.poll());
   			if (node.left != null) {
   				queue.add(node.left);
   			}
   			if (node.right != null) {
   				queue.add(node.right);
   			}
   		}
   		return head;
   	}
   
   	public static Node generateNode(String val) {
   		if (val == null) {
   			return null;
   		}
   		return new Node(Integer.valueOf(val));
   	}
   }
   ```

   

4. **==Encode N—ary Tree to Binary Tree==**

   > 将一颗多叉树序列化成一棵二叉树，反过来，也可以将一个二叉树反序列化成一个多叉树

   ![image-20220705103149433](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207051031478.png)

   ![image-20220705105928273](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207051059345.png)

   > 看一个结点有没有孩子，就看有没有左树右边界有没有结点

   ![image-20220705105308926](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207051053006.png)

   ```java
   package class11;
   
   import java.util.ArrayList;
   import java.util.List;
   
   // 本题测试链接：https://leetcode.com/problems/encode-n-ary-tree-to-binary-tree
   public class Code03_EncodeNaryTreeToBinaryTree {
   
   	// 提交时不要提交这个类
   	public static class Node {
   		public int val;
   		public List<Node> children;
   
   		public Node() {
   		}
   
   		public Node(int _val) {
   			val = _val;
   		}
   
   		public Node(int _val, List<Node> _children) {
   			val = _val;
   			children = _children;
   		}
   	}
   
   	// 提交时不要提交这个类
   	public static class TreeNode {
   		int val;
   		TreeNode left;
   		TreeNode right;
   
   		TreeNode(int x) {
   			val = x;
   		}
   	}
   
   	// 只提交这个类即可
   	class Codec {
   		// Encodes an n-ary tree to a binary tree.
   		public TreeNode encode(Node root) {
   			if (root == null) {
   				return null;
   			}
   			TreeNode head = new TreeNode(root.val);
               // en：先让root.children挂起来，再让root.children
               //     下面每一个结点的所有子节点挂在自己左树右边界上
   			head.left = en(root.children);
   			return head;
   		}
   
   		private TreeNode en(List<Node> children) {
   			TreeNode head = null;
   			TreeNode cur = null;
   			for (Node child : children) {
   				TreeNode tNode = new TreeNode(child.val);
   				if (head == null) {
   					head = tNode;
   				} else {
   					cur.right = tNode;
   				}
   				cur = tNode;
   				cur.left = en(child.children);
   			}
   			return head;
   		}
   
   		// Decodes your binary tree to an n-ary tree.
   		public Node decode(TreeNode root) {
   			if (root == null) {
   				return null;
   			}
   			return new Node(root.val, de(root.left));
   		}
   
           // root相当于长兄，将它的兄弟们弄成一个链表，返回给上游的父亲
           // 深度遍历，先将各自的孩子弄好，再几个原来的兄弟结点连在一起
   		public List<Node> de(TreeNode root) {
   			List<Node> children = new ArrayList<>();
   			while (root != null) {
   				Node cur = new Node(root.val, de(root.left));
   				children.add(cur);
   				root = root.right;
   			}
   			return children;
   		}
   
   	}
   
   }
   
   ```

   

5. ==**如何设计一个打印整棵树的打印函数**==

   ![image-20220705144543642](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207051445694.png)

   ```java
   public class Code04_PrintBinaryTree {
   
   	public static class Node {
   		public int value;
   		public Node left;
   		public Node right;
   
   		public Node(int data) {
   			this.value = data;
   		}
   	}
   
   	public static void printTree(Node head) {
   		System.out.println("Binary Tree:");
   		printInOrder(head, 0, "H", 17);
   		System.out.println();
   	}
   
   	public static void printInOrder(Node head, int height, String to, int len) {
   		if (head == null) {
   			return;
   		}
   		printInOrder(head.right, height + 1, "v", len);
   		String val = to + head.value + to;
   		int lenM = val.length();
   		int lenL = (len - lenM) / 2;
   		int lenR = len - lenM - lenL;
   		val = getSpace(lenL) + val + getSpace(lenR);
   		System.out.println(getSpace(height * len) + val);
   		printInOrder(head.left, height + 1, "^", len);
   	}
   
   	public static String getSpace(int num) {
   		String space = " ";
   		StringBuffer buf = new StringBuffer("");
   		for (int i = 0; i < num; i++) {
   			buf.append(space);
   		}
   		return buf.toString();
   	}
   
   	public static void main(String[] args) {
   		Node head = new Node(1);
   		head.left = new Node(-222222222);
   		head.right = new Node(3);
   		head.left.left = new Node(Integer.MIN_VALUE);
   		head.right.left = new Node(55555555);
   		head.right.right = new Node(66);
   		head.left.left.right = new Node(777);
   		printTree(head);
   
   		head = new Node(1);
   		head.left = new Node(2);
   		head.right = new Node(3);
   		head.left.left = new Node(4);
   		head.right.left = new Node(5);
   		head.right.right = new Node(6);
   		head.left.left.right = new Node(7);
   		printTree(head);
   
   		head = new Node(1);
   		head.left = new Node(1);
   		head.right = new Node(1);
   		head.left.left = new Node(1);
   		head.right.left = new Node(1);
   		head.right.right = new Node(1);
   		head.left.left.right = new Node(1);
   		printTree(head);
   
   	}
   
   }
   
   ```
   
   

6. **==求二叉树最宽的层有多少个结点==**

   > 每层的结点的个数，叫做该层的宽度

   > curEnd:     当前层结束的的结点
   >
   > nextEnd：下一层结束的结点

   ![image-20220705150943519](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207051509618.png)

   ```java
   // 在层序遍历的基础上，增加一个知道每层结束的标志
   
   package class11;
   
   import java.util.HashMap;
   import java.util.LinkedList;
   import java.util.Queue;
   
   public class Code05_TreeMaxWidth {
   
   	public static class Node {
   		public int value;
   		public Node left;
   		public Node right;
   
   		public Node(int data) {
   			this.value = data;
   		}
   	}
   
   	public static int maxWidthUseMap(Node head) {
   		if (head == null) {
   			return 0;
   		}
   		Queue<Node> queue = new LinkedList<>();
   		queue.add(head);
   		// key 在 哪一层，value
   		HashMap<Node, Integer> levelMap = new HashMap<>();
   		levelMap.put(head, 1);
   		int curLevel = 1; // 当前你正在统计哪一层的宽度
   		int curLevelNodes = 0; // 当前层curLevel层，宽度目前是多少
   		int max = 0;
   		while (!queue.isEmpty()) {
   			Node cur = queue.poll();
   			int curNodeLevel = levelMap.get(cur);
   			if (cur.left != null) {
   				levelMap.put(cur.left, curNodeLevel + 1);
   				queue.add(cur.left);
   			}
   			if (cur.right != null) {
   				levelMap.put(cur.right, curNodeLevel + 1);
   				queue.add(cur.right);
   			}
   			if (curNodeLevel == curLevel) {
   				curLevelNodes++;
   			} else {
   				max = Math.max(max, curLevelNodes);
   				curLevel++;
   				curLevelNodes = 1;
   			}
   		}
   		max = Math.max(max, curLevelNodes);
   		return max;
   	}
   
   	public static int maxWidthNoMap(Node head) {
   		if (head == null) {
   			return 0;
   		}
   		Queue<Node> queue = new LinkedList<>();
   		queue.add(head);
   		Node curEnd = head; // 当前层，最右节点是谁
   		Node nextEnd = null; // 下一层，最右节点是谁
   		int max = 0;
   		int curLevelNodes = 0; // 当前层的节点数
   		while (!queue.isEmpty()) {
   			Node cur = queue.poll();
   			if (cur.left != null) {
   				queue.add(cur.left);
   				nextEnd = cur.left;
   			}
   			if (cur.right != null) {
   				queue.add(cur.right);
   				nextEnd = cur.right;
   			}
   			curLevelNodes++;
   			if (cur == curEnd) {
   				max = Math.max(max, curLevelNodes);
   				curLevelNodes = 0;
   				curEnd = nextEnd;
   			}
   		}
   		return max;
   	}
   
   
   }
   
   
   ```
   
   

  

7. **==给定一颗二叉树的某个结点，返回该结点的后继结点==**

   > * 每一个结点可以看作是一个树的头节点
   > * 不管是中序遍历，还是前序遍历出来的序列，序列上的每一个结点，可以看作是一个树的头结点，然后再按头 左树 右树或者其他方式去推。也就是说，一个结点能够写进序列里面，肯定是以某个树的头节点写进去的

   ![image-20220705152544399](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207051525453.png)

   ![image-20220705153413690](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207051534799.png)

   ![image-20220705153547889](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207051535977.png)

   > 后继结点的两种情况
   >
   > * 如果这个结点有右树，则其后继结点就是其右树的最左的结点
   > * 如果这个结点没有右树，如下

   ![image-20220705160931580](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207051609659.png)

   ![image-20220705161219595](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207051612677.png)

   ```java
   package class11;
   
   pubpublic class Code06_SuccessorNode {
   
   	public static class Node {
   		public int value;
   		public Node left;
   		public Node right;
   		public Node parent;
   
   		public Node(int data) {
   			this.value = data;
   		}
   	}
   
   	public static Node getSuccessorNode(Node node) {
   		if (node == null) {
   			return node;
   		}
   		if (node.right != null) {
   			return getLeftMost(node.right);
   		} else { // 无右子树
   			Node parent = node.parent;
     // parent == null，中的是这个结点是中序遍历的最后一个结点，无后继
   			while (parent != null && parent.right == node) { // 当前节点是其父亲节点右孩子
   				node = parent;
   				parent = node.parent;
   			}
   			return parent;
   		}
   	}
   
   	public static Node getLeftMost(Node node) {
   		if (node == null) {
   			return node;
   		}
   		while (node.left != null) {
   			node = node.left;
   		}
   		return node;
   	}
   }
   
   ```

   

8. **==折纸条==**

   ![image-20220705162512806](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207051625878.png)

   ![image-20220705164907880](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207051649968.png)

   ```java
   package class11;
   // O(N): N是深度 
   public class Code07_PaperFolding {
   
   	public static void printAllFolds(int N) {
   		process(1, N, true);
   		System.out.println();
   	}
   
   	// 当前你来了一个节点，脑海中想象的！
   	// 这个节点在第i层，一共有N层，N固定不变的
   	// 这个节点如果是凹的话，down = T
   	// 这个节点如果是凸的话，down = F
   	// 函数的功能：中序打印以你想象的节点为头的整棵树！
   	public static void process(int i, int N, boolean down) {
   		if (i > N) {
   			return;
   		}
   		process(i + 1, N, true); // true代表左树
   		System.out.print(down ? "凹 " : "凸 ");
   		process(i + 1, N, false);
   	}
   
   	public static void main(String[] args) {
   		int N = 4;
   		printAllFolds(N);
   	}
   }
   
   ```




# Lesson12

1. **==判断二叉树是否为完全二叉树==**

   > * 判断：
   >   * 如果左右子树都是满二叉树，且左子树的高度比左子树的高度大1，则这棵树是完全二叉树。
   >   * 如果左右子树都是满二叉树，且左子树的高度比左子树的高度相等，则这棵树是完全二叉树。
   >   * 如果左子树是满二叉树，右子树是完全二叉树，且左子树的高度等于右子树的高度，则这棵树是完全二叉树。
   >   * 如果左子树是完全二叉树，右子树是满二叉树，且左子树的高度等右子树的高度加1，则这棵树是完全二叉树。

   ![image-20220706075301460](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207060753741.png)

   ```java
   package class12;
   
   import java.util.LinkedList;
   
   public class Code01_IsCBT {
   
   	public static class Node {
   		public int value;
   		public Node left;
   		public Node right;
   
   		public Node(int data) {
   			this.value = data;
   		}
   	}
       // first method
      	public static boolean isCBT1(Node head) {
   		if (head == null) {
   			return true;
   		}
   		LinkedList<Node> queue = new LinkedList<>();
   		// 是否遇到过左右两个孩子不双全的节点
   		boolean leaf = false;
   		Node l = null;
   		Node r = null;
   		queue.add(head);
   		while (!queue.isEmpty()) {
   			head = queue.poll();
   			l = head.left;
   			r = head.right;
   			if (
   			// 如果遇到了不双全的节点之后，又发现当前节点不是叶节点
   			    (leaf && (l != null || r != null)) 
   			    || 
   			    (l == null && r != null)
   
   			) {
   				return false;
   			}
   			if (l != null) {
   				queue.add(l);
   			}
   			if (r != null) {
   				queue.add(r);
   			}
   			if (l == null || r == null) {
   				leaf = true;
   			}
   		}
   		return true;
   	}
   	
      
   }
   
   ```

   

2. **==二叉树的递归套路==**

   ![image-20220706081008299](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207060810397.png)

   ![image-20220706081025598](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207060810801.png)

   > 补充：
   >
   > * 目前救我而知，答案的可能性一般有两种，一种要么是带有头节点，一种不带。知道答案的可能性后，重要的是，满足这个可能性，需要的的条件，知道条件后，才知道向左右子树要信息。
   > * 如果可能性带有头节点，那么左右子树也有答案的可能性，这种题的一般做法是，先算出自己的解，然后与带有头节点的解PK，谁最优，谁就是这棵树的解
   >
   > 

3. **==给定一棵二叉树的头节点head,返回这颗树是不是平衡二叉树==**

   > * 平衡二叉树：在一个二叉树中，任何一颗子树的左右子树的高度之差不超过1。也就是说在一棵二叉树中，每一棵子树都是平衡二叉树，且这颗二叉树的左右子树的高度差不超过1，这棵树是平衡二叉树。
   > * 递归方法：
   >   + x（头节点）的右子树是平衡二叉树
   >   + x的左子树是平衡二叉树
   >   + x的左右子树的高度之差的绝对值小于1
   >
   > 

   ![image-20220706081142999](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207060811092.png)

   ![image-20220706081522483](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207060815606.png)

   ![image-20220706082041502](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207060820756.png)

   ```java
   package class12;
   
   public class Code03_IsBalanced {
   
   	public static class Node {
   		public int value;
   		public Node left;
   		public Node right;
   
   		public Node(int data) {
   			this.value = data;
   		}
   	}
   
   
   	public static boolean isBalanced(Node head) {
   		return process(head).isBalanced;
   	}
   	
   	public static class Info{
   		public boolean isBalanced;
   		public int height;
   		
   		public Info(boolean i, int h) {
   			isBalanced = i;
   			height = h;
   		}
   	}
   	
   	public static Info process(Node x) {
   		if(x == null) {
   			return new Info(true, 0);
   		}
   		Info leftInfo = process(x.left);
   		Info rightInfo = process(x.right);
   		int height = Math.max(leftInfo.height, rightInfo.height)  + 1;
   		boolean isBalanced = true;
   		if(!leftInfo.isBalanced) {
   			isBalanced = false;
   		}
   		if(!rightInfo.isBalanced) {
   			isBalanced = false;
   		}
   		if(Math.abs(leftInfo.height - rightInfo.height) > 1) {
   			isBalanced = false;
   		}
   		return new Info(isBalanced, height);
   	}
   }
   
   ```

   

4. **==判断二叉树是否是搜索二叉树==**

   > * 搜索二叉树：在一颗二叉树中，左子树的每个结点都比头节点小，右子树的每个结点都比头节点大。经典二叉树是没有重复值的。也就是说任意一颗子树都必须是搜索二叉树，且这颗左子树的最大值比头节点，右子树的最小值比头节点大，这才能说这棵树是搜索二叉树。
   >
   > * 判断搜索二叉树的经典方法：
   >   * 用中序遍历一遍二叉树，得到序列，如果这个序列是递增的，则这颗树是搜索二叉树。
   > * 判断搜索二叉树的递归方法：
   >   * 先列可能性（是搜索二叉树的可能性，是在可以向左子树和右子树的情况下要信息）
   >   * x的左子树是搜索二叉树
   >   * x的右子树是搜索二叉树
   >   * x的左子树的最大值小于x
   >   * x的右子树的最小值大于x
   >
   > 

   ![image-20220706113531837](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207061135953.png)

   ![image-20220706113844318](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207061138434.png)

   ![image-20220706114556631](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207061145877.png)

   ![image-20220706115709683](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207061157931.png)

   ```java
   package class12;
   
   import java.util.ArrayList;
   
   public class Code02_IsBST {
   
   	public static class Node {
   		public int value;
   		public Node left;
   		public Node right;
   
   		public Node(int data) {
   			this.value = data;
   		}
   	}
   
   	public static boolean isBST(Node head) {
   		if (head == null) {
   			return true;
   		}
   		return process(head).isBST;
   	}
   
   	public static class Info {
   		public boolean isBST;
   		public int max;
   		public int min;
   
   		public Info(boolean i, int ma, int mi) {
   			isBST = i;
   			max = ma;
   			min = mi;
   		}
   
   	}
   
   	public static Info process(Node x) {
   		if (x == null) {// 如果是空树，且它的信息不好设，那就返回空，在上游处理空 
   			return null;
   		}
   		Info leftInfo = process(x.left);
   		Info rightInfo = process(x.right);
   		int max = x.value;
   		if (leftInfo != null) {
   			max = Math.max(max, leftInfo.max);
   		}
   		if (rightInfo != null) {
   			max = Math.max(max, rightInfo.max);
   		}
   		int min = x.value;
   		if (leftInfo != null) {
   			min = Math.min(min, leftInfo.min);
   		}
   		if (rightInfo != null) {
   			min = Math.min(min, rightInfo.min);
   		}
   		boolean isBST = true;
   		if (leftInfo != null && !leftInfo.isBST) {
   			isBST = false;
   		}
   		if (rightInfo != null && !rightInfo.isBST) {
   			isBST = false;
   		}
   		if (leftInfo != null && leftInfo.max >= x.value) {
   			isBST = false;
   		}
   		if (rightInfo != null && rightInfo.min <= x.value) {
   			isBST = false;
   		}
   		return new Info(isBST, max, min);
   	}
   
   
   }
   
   ```

   

5. **==判断一棵树是不是满二叉树==**

      > 判断满二叉树（可能性）：如果这棵树的高度是H，那么这棵满二叉树的结点数是(2^H) -1个结点

      ```java
      package class12;
      
      public class Code04_IsFull {
      
      	public static class Node {
      		public int value;
      		public Node left;
      		public Node right;
      
      		public Node(int data) {
      			this.value = data;
      		}
      	}
      
      	// 第一种方法
      	// 收集整棵树的高度h，和节点数n
      	// 只有满二叉树满足 : 2 ^ h - 1 == n
      	public static boolean isFull1(Node head) {
      		if (head == null) {
      			return true;
      		}
      		Info1 all = process1(head);
      		return (1 << all.height) - 1 == all.nodes;
      	}
      
      	public static class Info1 {
      		public int height;
      		public int nodes;
      
      		public Info1(int h, int n) {
      			height = h;
      			nodes = n;
      		}
      	}
      
      	public static Info1 process1(Node head) {
      		if (head == null) {
      			return new Info1(0, 0);
      		}
      		Info1 leftInfo = process1(head.left);
      		Info1 rightInfo = process1(head.right);
      		int height = Math.max(leftInfo.height, rightInfo.height) + 1;
      		int nodes = leftInfo.nodes + rightInfo.nodes + 1;
      		return new Info1(height, nodes);
      	}
      
      	// 第二种方法
      	// 收集子树是否是满二叉树
      	// 收集子树的高度
      	// 左树满 && 右树满 && 左右树高度一样 -> 整棵树是满的
      	public static boolean isFull2(Node head) {
      		if (head == null) {
      			return true;
      		}
      		return process2(head).isFull;
      	}
      
      	public static class Info2 {
      		public boolean isFull;
      		public int height;
      
      		public Info2(boolean f, int h) {
      			isFull = f;
      			height = h;
      		}
      	}
      
      	public static Info2 process2(Node h) {
      		if (h == null) {
      			return new Info2(true, 0);
      		}
      		Info2 leftInfo = process2(h.left);
      		Info2 rightInfo = process2(h.right);
      		boolean isFull = leftInfo.isFull && rightInfo.isFull && leftInfo.height == rightInfo.height;
      		int height = Math.max(leftInfo.height, rightInfo.height) + 1;
      		return new Info2(isFull, height);
      	}
      }
      
      ```

   

6. ==**给定一颗二叉树的头结点head，任何两个结点之间都存在距离，返回整棵二叉树的最大距离**==

   ![image-20220706152758125](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207061527193.png)

   ![image-20220706153341429](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207061533505.png)

   ![image-20220706154602333](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207061546430.png)

   ![image-20220706154728792](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207061547897.png)

   ```java
   import java.util.ArrayList;
   import java.util.HashMap;
   import java.util.HashSet;
   
   public class Code06_MaxDistance {
   
   	public static class Node {
   		public int value;
   		public Node left;
   		public Node right;
   
   		public Node(int data) {
   			this.value = data;
   		}
   	}
       
   	public static int maxDistance(Node head) {
   		return process(head).maxDistance;
   	}
   
   	public static class Info {
   		public int maxDistance;
   		public int height;
   
   		public Info(int m, int h) {
   			maxDistance = m;
   			height = h;
   		}
   
   	}
   
   	public static Info process(Node x) {
   		if (x == null) {
   			return new Info(0, 0);
   		}
   		Info leftInfo = process(x.left);
   		Info rightInfo = process(x.right);
   		int height = Math.max(leftInfo.height, rightInfo.height) + 1;
   		int p1 = leftInfo.maxDistance;
   		int p2 = rightInfo.maxDistance;
   		int p3 = leftInfo.height + rightInfo.height + 1;
   		int maxDistance = Math.max(Math.max(p1, p2), p3);
   		return new Info(maxDistance, height);
   	}
   }
   ```

   ![image-20220706155723726](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207061557797.png)



7. **==给定一棵二叉树的头节点head，返回这颗二叉树中最大的二叉搜索子树的大小（即结点的个数）==**

   ![image-20220706162033338](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207061620400.png)

   ![image-20220706162935304](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207061629378.png)

   ![image-20220706163017605](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207061630669.png)

   ![image-20220706163810754](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207061638834.png)

   ```java
   package class12;
   
   // 在线测试链接 : https://leetcode.com/problems/largest-bst-subtree
   public class Code05_MaxSubBSTSize {
   
   	// 提交时不要提交这个类
   	public static class TreeNode {
   		public int val;
   		public TreeNode left;
   		public TreeNode right;
   
   		public TreeNode(int value) {
   			val = value;
   		}
   	}
   
   	// 提交如下的代码，可以直接通过
   	public static int largestBSTSubtree(TreeNode head) {
   		if (head == null) {
   			return 0;
   		}
   		return process(head).maxBSTSubtreeSize;
   	}
   
   	public static class Info {
   		public int maxBSTSubtreeSize;
   		public int allSize;
   		public int max;
   		public int min;
   
   		public Info(int m, int a, int ma, int mi) {
   			maxBSTSubtreeSize = m;
   			allSize = a;
   			max = ma;
   			min = mi;
   		}
   	}
   
   	public static Info process(TreeNode x) {
   		if (x == null) {
   			return null;
   		}
   		Info leftInfo = process(x.left);
   		Info rightInfo = process(x.right);
   		int max = x.val;
   		int min = x.val;
   		int allSize = 1;
   		if (leftInfo != null) {
   			max = Math.max(leftInfo.max, max);
   			min = Math.min(leftInfo.min, min);
   			allSize += leftInfo.allSize;
   		}
   		if (rightInfo != null) {
   			max = Math.max(rightInfo.max, max);
   			min = Math.min(rightInfo.min, min);
   			allSize += rightInfo.allSize;
   		}
   		int p1 = -1;
   		if (leftInfo != null) {
   			p1 = leftInfo.maxBSTSubtreeSize;
   		}
   		int p2 = -1;
   		if (rightInfo != null) {
   			p2 = rightInfo.maxBSTSubtreeSize;
   		}
   		int p3 = -1;
   		boolean leftBST = leftInfo == null ? true : (leftInfo.maxBSTSubtreeSize == leftInfo.allSize);
   		boolean rightBST = rightInfo == null ? true : (rightInfo.maxBSTSubtreeSize == rightInfo.allSize);
   		if (leftBST && rightBST) {
   			boolean leftMaxLessX = leftInfo == null ? true : (leftInfo.max < x.val);
   			boolean rightMinMoreX = rightInfo == null ? true : (x.val < rightInfo.min);
   			if (leftMaxLessX && rightMinMoreX) {
   				int leftSize = leftInfo == null ? 0 : leftInfo.allSize;
   				int rightSize = rightInfo == null ? 0 : rightInfo.allSize;
   				p3 = leftSize + rightSize + 1;
   			}
   		}
   		return new Info(Math.max(p1, Math.max(p2, p3)), allSize, max, min);
   	}
   
   }
   
   ```

   

# Lesson13

1. **==用递归判断一颗二叉树是完全二叉树==**

   > ==判断方法：==
   >
   > * 左右子树都是满二叉树，且高度相等
   > * 左右子树都是满二叉树，且左子树的高度比右子树的高度大1
   > * 左子树的满二叉树，右子树是完全二叉树，且高度相等
   > * 左子树是完全二叉树，右子树的满二叉树，且左子树的高度比右子树的高度大1

   ```java
   	public static boolean isCompleteTree2(TreeNode head) {
   		return process(head).isCBT;
   	}
   
   	public static class Info {
   		public boolean isFull;
   		public boolean isCBT;
   		public int height;
   
   		public Info(boolean full, boolean cbt, int h) {
   			isFull = full;
   			isCBT = cbt;
   			height = h;
   		}
   	}
   
   	public static Info process(TreeNode x) {
   		if (x == null) {
   			return new Info(true, true, 0);
   		}
   		Info leftInfo = process(x.left);
   		Info rightInfo = process(x.right);
   		int height = Math.max(leftInfo.height, rightInfo.height) + 1;
   		boolean isFull = leftInfo.isFull && rightInfo.isFull && leftInfo.height == rightInfo.height;
   		boolean isCBT = false;
   		if (leftInfo.isFull && rightInfo.isFull && leftInfo.height == rightInfo.height) {
   			isCBT = true;
   		} else if (leftInfo.isCBT && rightInfo.isFull && leftInfo.height == rightInfo.height + 1) {
   			isCBT = true;
   		} else if (leftInfo.isFull && rightInfo.isFull && leftInfo.height == rightInfo.height + 1) {
   			isCBT = true;
   		} else if (leftInfo.isFull && rightInfo.isCBT && leftInfo.height == rightInfo.height) {
   			isCBT = true;
   		}
   		return new Info(isFull, isCBT, height);
   	}
   ```

   

2. **==给定一颗二叉树的头结点head，返回这颗二叉树中最大的二叉搜索子树的头节点==**

   ```java
   package class13;
   
   import java.util.ArrayList;
   
   public class Code02_MaxSubBSTHead {
   
   	public static Node maxSubBSTHead(Node head) {
   		if (head == null) {
   			return null;
   		}
   		return process(head).maxSubBSTHead;
   	}
   
   	// 每一棵子树
   	public static class Info {
   		public Node maxSubBSTHead;
   		public int maxSubBSTSize;
   		public int min;
   		public int max;
   
   		public Info(Node h, int size, int mi, int ma) {
   			maxSubBSTHead = h;
   			maxSubBSTSize = size;
   			min = mi;
   			max = ma;
   		}
   	}
   
   	public static Info process(Node X) {
   		if (X == null) {
   			return null;
   		}
   		Info leftInfo = process(X.left);
   		Info rightInfo = process(X.right);
   		int min = X.value;
   		int max = X.value;
   		Node maxSubBSTHead = null;
   		int maxSubBSTSize = 0;
   		if (leftInfo != null) {
   			min = Math.min(min, leftInfo.min);
   			max = Math.max(max, leftInfo.max);
   			maxSubBSTHead = leftInfo.maxSubBSTHead;
   			maxSubBSTSize = leftInfo.maxSubBSTSize;
   		}
   		if (rightInfo != null) {
   			min = Math.min(min, rightInfo.min);
   			max = Math.max(max, rightInfo.max);
   			if (rightInfo.maxSubBSTSize > maxSubBSTSize) {
   				maxSubBSTHead = rightInfo.maxSubBSTHead;
   				maxSubBSTSize = rightInfo.maxSubBSTSize;
   			}
   		}
   		if ((leftInfo == null ? true : (leftInfo.maxSubBSTHead == X.left && leftInfo.max < X.value))
   				&& (rightInfo == null ? true : (rightInfo.maxSubBSTHead == X.right && rightInfo.min > X.value))) {
   			maxSubBSTHead = X;
   			maxSubBSTSize = (leftInfo == null ? 0 : leftInfo.maxSubBSTSize)
   					+ (rightInfo == null ? 0 : rightInfo.maxSubBSTSize) + 1;
   		}
   		return new Info(maxSubBSTHead, maxSubBSTSize, min, max);
   	}
   }
   ```
   
   



3. **==给定一颗二叉树的头节点head，和另外两个结点a和b。返回a和b的最低公共祖先==**

   ![image-20220707093833606](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207070938846.png)

   ![image-20220707093937935](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207070939124.png)

   ![image-20220707094030267](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207070940513.png)

   ![image-20220707095454639](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207070954939.png)

   

   

   ```java
   import java.util.ArrayList;
   import java.util.HashMap;
   import java.util.HashSet;
   
   // 因为这个递归套路是或许遍历，所以时间复杂度就是O(N)
   
   public class Code03_lowestAncestor {
   
   	public static class Node {
   		public int value;
   		public Node left;
   		public Node right;
   
   		public Node(int data) {
   			this.value = data;
   		}
   	}
   
   	public static Node lowestAncestor1(Node head, Node o1, Node o2) {
   		if (head == null) {
   			return null;
   		}
   		// key的父节点是value
   		HashMap<Node, Node> parentMap = new HashMap<>();
   		parentMap.put(head, null);
   		fillParentMap(head, parentMap);
   		HashSet<Node> o1Set = new HashSet<>();
   		Node cur = o1;
   		o1Set.add(cur);
   		while (parentMap.get(cur) != null) {
   			cur = parentMap.get(cur);
   			o1Set.add(cur);
   		}
   		cur = o2;
   		while (!o1Set.contains(cur)) {
   			cur = parentMap.get(cur);
   		}
   		return cur;
   	}
   
   	public static void fillParentMap(Node head, HashMap<Node, Node> parentMap) {
   		if (head.left != null) {
   			parentMap.put(head.left, head);
   			fillParentMap(head.left, parentMap);
   		}
   		if (head.right != null) {
   			parentMap.put(head.right, head);
   			fillParentMap(head.right, parentMap);
   		}
   	}
   
   	public static Node lowestAncestor2(Node head, Node a, Node b) {
   		return process(head, a, b).ans;
   	}
   
   	public static class Info {
   		public boolean findA;
   		public boolean findB;
   		public Node ans;
   
   		public Info(boolean fA, boolean fB, Node an) {
   			findA = fA;
   			findB = fB;
   			ans = an;
   		}
   	}
   
   	public static Info process(Node x, Node a, Node b) {
   		if (x == null) {
   			return new Info(false, false, null);
   		}
   		Info leftInfo = process(x.left, a, b);
   		Info rightInfo = process(x.right, a, b);
   		boolean findA = (x == a) || leftInfo.findA || rightInfo.findA;
   		boolean findB = (x == b) || leftInfo.findB || rightInfo.findB;
   		Node ans = null;
   		if (leftInfo.ans != null) {
   			ans = leftInfo.ans;
   		} else if (rightInfo.ans != null) {
   			ans = rightInfo.ans;
   		} else {
               // 能到这一步，肯定是左右子树都没答案
               // 如果findA && findB成立，肯定有答案，那么答案就是头节点
   			if (findA && findB) {
   				ans = x;
   			}
   		}
   		return new Info(findA, findB, ans);
   	}
   }
   
   
   ```

   

4. **==排队的最大快乐值==**

   ![image-20220707101549815](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207071015901.png)

   ![image-20220707102645032](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207071029633.png)

   ![image-20220707102852826](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207071030254.png)

   ```java
   package class13;
   
   import java.util.ArrayList;
   import java.util.List;
   
   public class Code04_MaxHappy {
   
   	public static class Employee {
   		public int happy;
   		public List<Employee> nexts;
   
   		public Employee(int h) {
   			happy = h;
   			nexts = new ArrayList<>();
   		}
   
   	}
   
   	public static int maxHappy1(Employee boss) {
   		if (boss == null) {
   			return 0;
   		}
   		return process1(boss, false);
   	}
   
   	// 当前来到的节点叫cur，
   	// up表示cur的上级是否来，
   	// 该函数含义：
   	// 如果up为true，表示在cur上级已经确定来，的情况下，cur整棵树能够提供最大的快乐值是多少？
   	// 如果up为false，表示在cur上级已经确定不来，的情况下，cur整棵树能够提供最大的快乐值是多少？
   	public static int process1(Employee cur, boolean up) {
   		if (up) { // 如果cur的上级来的话，cur没得选，只能不来
   			int ans = 0;
   			for (Employee next : cur.nexts) {
   				ans += process1(next, false);
   			}
   			return ans;
   		} else { // 如果cur的上级不来的话，cur可以选，可以来也可以不来
   			int p1 = cur.happy;
   			int p2 = 0;
   			for (Employee next : cur.nexts) {
   				p1 += process1(next, true);
   				p2 += process1(next, false);
   			}
   			return Math.max(p1, p2);
   		}
   	}
   
   	public static int maxHappy2(Employee head) {
   		Info allInfo = process(head);
   		return Math.max(allInfo.no, allInfo.yes);
   	}
   
   	public static class Info {
   		public int no;
   		public int yes;
   
   		public Info(int n, int y) {
   			no = n;
   			yes = y;
   		}
   	}
   
   	public static Info process(Employee x) {
   		if (x == null) {
   			return new Info(0, 0);
   		}
   		int no = 0;
   		int yes = x.happy;
   		for (Employee next : x.nexts) {
   			Info nextInfo = process(next);
   			no += Math.max(nextInfo.no, nextInfo.yes);
   			yes += nextInfo.no;
   
   		}
   		return new Info(no, yes);
   	}
   }
   
   ```

   

## 贪心算法

0. ==**前置知识**==

   > * 贪心算法，在于贪心策略先提出，后证明，证明可以用方法论，一步一步推，也可以用对数器的方法，实验出来，也就是实验论。因为证明贪心策略出来的结果是最优解，是比较困难的，所以最好是用对数器的方法直接证明。
   > * 笔试常见，面试不常见，即使面试中碰见这类题，可以跟面试官先提出策略，再用对数器的方式实验出来，后面用方法证明，可以慢慢来

   ![image-20220707103825646](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207071038728.png)

1. **==字典序最小的结果==**

   ![image-20220707103946213](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207071039290.png)

   ![image-20220707110443414](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207071104518.png)

   ```java
   	public static class MyComparator implements Comparator<String> {
   		@Override
   		public int compare(String a, String b) {
   			return (a + b).compareTo(b + a);
   		}
   	}
   
   	public static String lowestString(String[] strs) {
   		if (strs == null || strs.length == 0) {
   			return "";
   		}
   		Arrays.sort(strs, new MyComparator());
   		String res = "";
   		for (int i = 0; i < strs.length; i++) {
   			res += strs[i];
   		}
   		return res;
   	}
   ```

   

# Lesson14

0. **==贪心的题很多跟排序和堆有关==**

1. **==最多的宣讲场次==**

   > 贪心策略：每次选结束时间最早的宣讲会

   ![image-20220708100954649](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207081009715.png)

   ```java
   import java.util.Arrays;
   import java.util.Comparator;
   
   public class Code03_BestArrange {
   
   	public static class Program {
   		public int start;
   		public int end;
   
   		public Program(int start, int end) {
   			this.start = start;
   			this.end = end;
   		}
   	}
   
   	// 会议的开始时间和结束时间，都是数值，不会 < 0
   	public static int bestArrange(Program[] programs) {
   		Arrays.sort(programs, new ProgramComparator());
   		int timeLine = 0;  // 可以看作会议结束的时间，也可以看作
   		int result = 0;    // 一天的时间走向
   		// 依次遍历每一个会议，结束时间早的会议先遍历
   		for (int i = 0; i < programs.length; i++) {
   			if (timeLine <= programs[i].start) {
   				result++;
   				timeLine = programs[i].end;
   			}
   		}
   		return result;
   	}
   
   	public static class ProgramComparator implements Comparator<Program> {
   
   		@Override
   		public int compare(Program o1, Program o2) {
   			return o1.end - o2.end;
   		}
   
   	}
   }
   
   
   ```



2. **==返回最小分割代价==**

   ![image-20220708104953238](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207081050637.png)

   ```java
   import java.util.PriorityQueue;
   
   public class Code02_LessMoneySplitGold {
   
   	public static int lessMoney(int[] arr) {
   		PriorityQueue<Integer> pQ = new PriorityQueue<>();
   		for (int i = 0; i < arr.length; i++) {
   			pQ.add(arr[i]);
   		}
   		int sum = 0;
   		int cur = 0;
   		while (pQ.size() > 1) {
   			cur = pQ.poll() + pQ.poll();
   			sum += cur;
   			pQ.add(cur);
   		}
   		return sum;
   	}
   }
   
   ```



3. **==最后获得最大钱数==**

   > ==有时候面试官出一个问题，把条件含含糊糊的说，他的目的是想让你去问他这个问题的条件有哪些，把这个问题declare，所以在面试的时候，你想不懂这个问题，可能就是面试官的条件没说清，等着你去问！，一定要搞清楚这个问题后再去做这个题！==

   > 建立一个根据花费大小的小根堆，和一个根据利润大小的大根堆。根据M，解锁项目到大根堆，然后从大根堆弹出利润最高的项目。

   ![image-20220708110512926](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207081105052.png)

   ```java
   import java.util.Comparator;
   import java.util.PriorityQueue;
   
   public class Code04_IPO {
   
   	// 最多K个项目
   	// W是初始资金
   	// Profits[] Capital[] 一定等长
   	// 返回最终最大的资金
   	public static int findMaximizedCapital(int K, int W, int[] Profits, int[] Capital) {
   		PriorityQueue<Program> minCostQ = new PriorityQueue<>(new MinCostComparator());
   		PriorityQueue<Program> maxProfitQ = new PriorityQueue<>(new MaxProfitComparator());
   		for (int i = 0; i < Profits.length; i++) {
   			minCostQ.add(new Program(Profits[i], Capital[i]));
   		}
   		for (int i = 0; i < K; i++) {
               // 堆 队列 在poll之前一i的一定要判空
   			while (!minCostQ.isEmpty() && minCostQ.peek().c <= W) {
   				maxProfitQ.add(minCostQ.poll());
   			}
   			if (maxProfitQ.isEmpty()) {
   				return W;
   			}
   			W += maxProfitQ.poll().p;
   		}
   		return W;
   	}
   
   	public static class Program {
   		public int p;
   		public int c;
   
   		public Program(int p, int c) {
   			this.p = p;
   			this.c = c;
   		}
   	}
   
   	public static class MinCostComparator implements Comparator<Program> {
   
   		@Override
   		public int compare(Program o1, Program o2) {
   			return o1.c - o2.c;
   		}
   
   	}
   
   	public static class MaxProfitComparator implements Comparator<Program> {
   
   		@Override
   		public int compare(Program o1, Program o2) {
   			return o2.p - o1.p;
   		}
   
   	}
   
   }
   
   ```

   

4. **==至少需要几盏灯==**

   ![image-20220708114014736](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207081140870.png)
   
   ![image-20220708192822684](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207081928773.png)
   
   > 思路：
   >
   > * 来到i位置，如果是点，只考虑i位置即i位置以后的事，即i位置和后面位置的可能性，和i位置的如果是点，只能由自己位置的等点亮，或者后面的等点亮。
   >
   > 贪心策略：
   >
   > * 如果来到i位置，i ， i + 1，  i + 2位置都是点，那么就在i + 1位置放灯
   >
   > 
   
   ![image-20220708194750177](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207081947331.png)
   
   ```java
   public class Code01_Light {
   
   	public static int minLight(String road) {
   		char[] str = road.toCharArray();
   		int i = 0;
   		int light = 0;
   		while (i < str.length) {
   			if (str[i] == 'X') {
   				i++;
   			} else {
   				light++;
   				if (i + 1 == str.length) {
   					break;
   				} else { // 有i位置 i+ 1 X .
   					if (str[i + 1] == 'X') {
   						i = i + 2;
   					} else {
   						i = i + 3;
   					}
   				}
   			}
   		}
   		return light;
   	}	
   }
   
   ```
   
   

## 并查集（支持集合 合并和查询的一个结构）

0. **==前置知识==**

   ![image-20220708200315006](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207082003110.png)

   ```java
   import java.util.HashMap;
   import java.util.List;
   import java.util.Stack;
   
   // 并查集的查询达到了（或大于）样本量的规模，则每次查询的时间复杂度平均下来是O(1)
   // 主要是findHead做了优化，将链表扁平化
   public class Code05_UnionFind {
   
   	public static class Node<V> {
   		V value;
   
   		public Node(V v) {
   			value = v;
   		}
   	}
   
   	public static class UnionFind<V> {
           // Node<V>是V包了一层，加了个value，也就是指针
   		public HashMap<V, Node<V>> nodes;
           // 用一张表代替指针，即第一个Node<V>的父亲结点是第二个Node<V>
   		public HashMap<Node<V>, Node<V>> parents;
           // 记录每个集合的头节点即Node<V>,Integer是Node<V>所在集合的大小
   		public HashMap<Node<V>, Integer> sizeMap;
   
   		public UnionFind(List<V> values) {
   			nodes = new HashMap<>();
   			parents = new HashMap<>();
   			sizeMap = new HashMap<>();
               // 每一个样本生成自己的小集合
   			for (V cur : values) {
   				Node<V> node = new Node<>(cur);
   				nodes.put(cur, node);
   				parents.put(node, node);
   				sizeMap.put(node, 1);
   			}
   		}
   
   		// 给你一个节点，请你往上到不能再往上，把代表返回
   		public Node<V> findHead(Node<V> cur) {
   			Stack<Node<V>> path = new Stack<>();
   			while (cur != parents.get(cur)) {
   				path.push(cur);
   				cur = parents.get(cur);
   			}
   			while (!path.isEmpty()) {
   				parents.put(path.pop(), cur);
   			}
   			return cur;
   		}
   		
           // father这里应该是ancessor，因为是要找到所在集合的代表结点可能是父亲也            可能是祖先
   		public boolean isSameSet(V a, V b) {
   			return findHead(nodes.get(a)) == findHead(nodes.get(b));
   		}
   	
           // 小的集合挂大的集合，即小的集合的代表结点的指针指向大的集合的代表结点
   		public void union(V a, V b) {
   			Node<V> aHead = findHead(nodes.get(a));
   			Node<V> bHead = findHead(nodes.get(b));
   			if (aHead != bHead) {
   				int aSetSize = sizeMap.get(aHead);
   				int bSetSize = sizeMap.get(bHead);
   				Node<V> big = aSetSize >= bSetSize ? aHead : bHead;
   				Node<V> small = big == aHead ? bHead : aHead;
   				parents.put(small, big);
   				sizeMap.put(big, aSetSize + bSetSize);
   				sizeMap.remove(small);
   			}
   		}
   
   		public int sets() {
   			return sizeMap.size();
   		}
   
   	}
   }
   
   ```



# Lesson15

1. **==Friend Circles==**

   ![image-20220709100156489](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207091001570.png)

   

   ```java
   package class15;
   
   // 本题为leetcode原题
   // 测试链接：https://leetcode.com/problems/friend-circles/
   // 可以直接通过
   public class Code01_FriendCircles {
   
   	public static int findCircleNum(int[][] M) {
   		int N = M.length;
   		// {0} {1} {2} {N-1}
   		UnionFind unionFind = new UnionFind(N);
   		for (int i = 0; i < N; i++) {
   			for (int j = i + 1; j < N; j++) {
   				if (M[i][j] == 1) { // i和j互相认识
   					unionFind.union(i, j);
   				}
   			}
   		}
   		return unionFind.sets();
   	}
   
   	public static class UnionFind {
   		// parent[i] = k ： i的父亲是k
   		private int[] parent;
   		// size[i] = k ： 如果i是代表节点，size[i]才有意义，否则无意义
   		// i所在的集合大小是多少
   		private int[] size;
   		// 辅助结构
   		private int[] help;
   		// 一共有多少个集合
   		private int sets;
   
   		public UnionFind(int N) {
   			parent = new int[N];
   			size = new int[N];
   			help = new int[N];
   			sets = N;
   			for (int i = 0; i < N; i++) {
   				parent[i] = i;
   				size[i] = 1;
   			}
   		}
   
   		// 从i开始一直往上，往上到不能再往上，代表节点，返回
   		// 这个过程要做路径压缩
   		private int find(int i) {
   			int hi = 0;
   			while (i != parent[i]) {
   				help[hi++] = i;
   				i = parent[i];
   			}
   			for (hi--; hi >= 0; hi--) {
   				parent[help[hi]] = i;
   			}
   			return i;
   		}
   
   		public void union(int i, int j) {
   			int f1 = find(i);
   			int f2 = find(j);
   			if (f1 != f2) {
   				if (size[f1] >= size[f2]) {
   					size[f1] += size[f2];
   					parent[f2] = f1;
   				} else {
   					size[f2] += size[f1];
   					parent[f1] = f2;
   				}
   				sets--;
   			}
   		}
   
   		public int sets() {
   			return sets;
   		}
   	}
   
   }
   
   ```



2. **==岛问题==**

   ![image-20220709100328054](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207091003110.png)

   ![image-20220709102802157](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207091028279.png)

   ![image-20220709141239770](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207091412860.png)

   ![image-20220709215407032](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207092154105.png)

   ```java
   package class15;
   
   import java.util.ArrayList;
   import java.util.HashMap;
   import java.util.List;
   import java.util.Stack;
   
   // 本题为leetcode原题
   // 测试链接：https://leetcode.com/problems/number-of-islands/
   // 所有方法都可以直接通过
   public class Code02_NumberOfIslands {
   
       // 时间复杂度O(M * N) M * N是矩阵的行数和列数 
   	public static int numIslands3(char[][] board) {
   		int islands = 0;
   		for (int i = 0; i < board.length; i++) {
   			for (int j = 0; j < board[0].length; j++) {
   				if (board[i][j] == '1') {
   					islands++;
   					infect(board, i, j);
   				}
   			}
   		}
   		return islands;
   	}
   
   	// 从(i,j)这个位置出发，把所有练成一片的'1'字符，变成0
   	public static void infect(char[][] board, int i, int j) {
   		if (i < 0 || i == board.length || j < 0 || j == board[0].length || board[i][j] != '1') {
   			return;
   		}
           // 如果感染过程不把字符‘1’，改成0，递归过程就会成死递归
   		board[i][j] = 0;
   		infect(board, i - 1, j);
   		infect(board, i + 1, j);
   		infect(board, i, j - 1);
   		infect(board, i, j + 1);
   	}
   
       
       // 并查集 HashMap
   	public static int numIslands1(char[][] board) {
   		int row = board.length;
   		int col = board[0].length;
   		Dot[][] dots = new Dot[row][col];
   		List<Dot> dotList = new ArrayList<>();
   		for (int i = 0; i < row; i++) {
   			for (int j = 0; j < col; j++) {
   				if (board[i][j] == '1') {
   					dots[i][j] = new Dot();
   					dotList.add(dots[i][j]);
   				}
   			}
   		}
   		UnionFind1<Dot> uf = new UnionFind1<>(dotList);
   		for (int j = 1; j < col; j++) {
   			// (0,j)  (0,0)跳过了(该位置既没有左也没有上)  (0,1) (0,2) (0,3)
   			if (board[0][j - 1] == '1' && board[0][j] == '1') {
   				uf.union(dots[0][j - 1], dots[0][j]);
   			}
   		}
   		for (int i = 1; i < row; i++) {
   			if (board[i - 1][0] == '1' && board[i][0] == '1') {
   				uf.union(dots[i - 1][0], dots[i][0]);
   			}
   		}
   		for (int i = 1; i < row; i++) {
   			for (int j = 1; j < col; j++) {
   				if (board[i][j] == '1') {
   					if (board[i][j - 1] == '1') {
   						uf.union(dots[i][j - 1], dots[i][j]);
   					}
   					if (board[i - 1][j] == '1') {
   						uf.union(dots[i - 1][j], dots[i][j]);
   					}
   				}
   			}
   		}
   		return uf.sets();
   	}
   
   	public static class Dot {
   
   	}
   
   	public static class Node<V> {
   
   		V value;
   
   		public Node(V v) {
   			value = v;
   		}
   
   	}
   
   	public static class UnionFind1<V> {
   		public HashMap<V, Node<V>> nodes;
   		public HashMap<Node<V>, Node<V>> parents;
   		public HashMap<Node<V>, Integer> sizeMap;
   
   		public UnionFind1(List<V> values) {
   			nodes = new HashMap<>();
   			parents = new HashMap<>();
   			sizeMap = new HashMap<>();
   			for (V cur : values) {
   				Node<V> node = new Node<>(cur);
   				nodes.put(cur, node);
   				parents.put(node, node);
   				sizeMap.put(node, 1);
   			}
   		}
   
   		public Node<V> findFather(Node<V> cur) {
   			Stack<Node<V>> path = new Stack<>();
   			while (cur != parents.get(cur)) {
   				path.push(cur);
   				cur = parents.get(cur);
   			}
   			while (!path.isEmpty()) {
   				parents.put(path.pop(), cur);
   			}
   			return cur;
   		}
   
   		public void union(V a, V b) {
   			Node<V> aHead = findFather(nodes.get(a));
   			Node<V> bHead = findFather(nodes.get(b));
   			if (aHead != bHead) {
   				int aSetSize = sizeMap.get(aHead);
   				int bSetSize = sizeMap.get(bHead);
   				Node<V> big = aSetSize >= bSetSize ? aHead : bHead;
   				Node<V> small = big == aHead ? bHead : aHead;
   				parents.put(small, big);
   				sizeMap.put(big, aSetSize + bSetSize);
   				sizeMap.remove(small);
   			}
   		}
   
   		public int sets() {
   			return sizeMap.size();
   		}
   
   	}
   
       
       // 并查集 Array
       // 左和上
   	public static int numIslands2(char[][] board) {
   		int row = board.length;
   		int col = board[0].length;
   		UnionFind2 uf = new UnionFind2(board);
   		for (int j = 1; j < col; j++) {
   			if (board[0][j - 1] == '1' && board[0][j] == '1') {
   				uf.union(0, j - 1, 0, j);
   			}
   		}
   		for (int i = 1; i < row; i++) {
   			if (board[i - 1][0] == '1' && board[i][0] == '1') {
   				uf.union(i - 1, 0, i, 0);
   			}
   		}
   		for (int i = 1; i < row; i++) {
   			for (int j = 1; j < col; j++) {
   				if (board[i][j] == '1') {
   					if (board[i][j - 1] == '1') {
   						uf.union(i, j - 1, i, j);
   					}
   					if (board[i - 1][j] == '1') {
   						uf.union(i - 1, j, i, j);
   					}
   				}
   			}
   		}
   		return uf.sets();
   	}
   
   	public static class UnionFind2 {
   		private int[] parent;
   		private int[] size;
   		private int[] help;
   		private int col;
   		private int sets;
   
   		public UnionFind2(char[][] board) {
   			col = board[0].length;
   			sets = 0;
   			int row = board.length;
   			int len = row * col;
   			parent = new int[len];
   			size = new int[len];
   			help = new int[len];
   			for (int r = 0; r < row; r++) {
   				for (int c = 0; c < col; c++) {
   					if (board[r][c] == '1') {
   						int i = index(r, c);
   						parent[i] = i;
   						size[i] = 1;
   						sets++;
   					}
   				}
   			}
   		}
   
   		// (r,c) -> i
   		private int index(int r, int c) {
   			return r * col + c;
   		}
   
   		// 原始位置 -> 下标
   		private int find(int i) {
   			int hi = 0;
   			while (i != parent[i]) {
   				help[hi++] = i;
   				i = parent[i];
   			}
               // hi是先减减的
   			for (hi--; hi >= 0; hi--) {
   				parent[help[hi]] = i;
   			}
   			return i;
   		}
   
   		public void union(int r1, int c1, int r2, int c2) {
   			int i1 = index(r1, c1);
   			int i2 = index(r2, c2);
   			int f1 = find(i1);
   			int f2 = find(i2);
   			if (f1 != f2) {
   				if (size[f1] >= size[f2]) {
   					size[f1] += size[f2];
   					parent[f2] = f1;
   				} else {
   					size[f2] += size[f1];
   					parent[f1] = f2;
   				}
   				sets--;
   			}
   		}
   
   		public int sets() {
   			return sets;
   		}
   
   	}
   }
   
   ```

   

3. **==Number of Islands ||==**

   > 动态数组动态连

   ![image-20220709145207467](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207091452539.png)

   ```java
   package class15;
   
   import java.util.ArrayList;
   import java.util.HashMap;
   import java.util.List;
   
   // 本题为leetcode原题
   // 测试链接：https://leetcode.com/problems/number-of-islands-ii/
   // 所有方法都可以直接通过
   public class Code03_NumberOfIslandsII {
   
   	public static List<Integer> numIslands21(int m, int n, int[][] positions) {
   		UnionFind1 uf = new UnionFind1(m, n);
   		List<Integer> ans = new ArrayList<>();
   		for (int[] position : positions) {
   			ans.add(uf.connect(position[0], position[1]));
   		}
   		return ans;
   	}
   
   	public static class UnionFind1 {
   		private int[] parent;
           //  一个技巧，以前是i位置和j位置决出之后，会删掉一个，j位置胜出，在size里面会删掉i位置，在这个题中就不用删掉，也就是size数组的作用成了，size[i]！= 0，证明i位置被初始化过
   		private int[] size;
   		private int[] help;
   		private final int row;
   		private final int col;
   		private int sets;
   
   		public UnionFind1(int m, int n) {
   			row = m;
   			col = n;
   			sets = 0;
   			int len = row * col;
   			parent = new int[len];
   			size = new int[len];
   			help = new int[len];
   		}
   
   		private int index(int r, int c) {
   			return r * col + c;
   		}
   
   		private int find(int i) {
   			int hi = 0;
   			while (i != parent[i]) {
   				help[hi++] = i;
   				i = parent[i];
   			}
   			for (hi--; hi >= 0; hi--) {
   				parent[help[hi]] = i;
   			}
   			return i;
   		}
   
   		private void union(int r1, int c1, int r2, int c2) {
   			if (r1 < 0 || r1 == row || r2 < 0 || r2 == row || c1 < 0 || c1 == col || c2 < 0 || c2 == col) {
   				return;
   			}
   			int i1 = index(r1, c1);
   			int i2 = index(r2, c2);
   			if (size[i1] == 0 || size[i2] == 0) {
   				return;
   			}
   			int f1 = find(i1);
   			int f2 = find(i2);
   			if (f1 != f2) {
   				if (size[f1] >= size[f2]) {
   					size[f1] += size[f2];
   					parent[f2] = f1;
   				} else {
   					size[f2] += size[f1];
   					parent[f1] = f2;
   				}
   				sets--;
   			}
   		}
   
   		public int connect(int r, int c) {
   			int index = index(r, c);
   			if (size[index] == 0) {
   				parent[index] = index;
   				size[index] = 1;
   				sets++;
   				union(r - 1, c, r, c);
   				union(r + 1, c, r, c);
   				union(r, c - 1, r, c);
   				union(r, c + 1, r, c);
   			}
   			return sets;
   		}
   
   	}
   
   	// 课上讲的如果m*n比较大，会经历很重的初始化，而k比较小，怎么优化的方法
   	public static List<Integer> numIslands22(int m, int n, int[][] positions) {
   		UnionFind2 uf = new UnionFind2();
   		List<Integer> ans = new ArrayList<>();
   		for (int[] position : positions) {
   			ans.add(uf.connect(position[0], position[1]));
   		}
   		return ans;
   	}
   
   	public static class UnionFind2 {
   		private HashMap<String, String> parent;
   		private HashMap<String, Integer> size;
   		private ArrayList<String> help;
   		private int sets;
   
   		public UnionFind2() {
   			parent = new HashMap<>();
   			size = new HashMap<>();
   			help = new ArrayList<>();
   			sets = 0;
   		}
   
   		private String find(String cur) {
   			while (!cur.equals(parent.get(cur))) {
   				help.add(cur);
   				cur = parent.get(cur);
   			}
   			for (String str : help) {
   				parent.put(str, cur);
   			}
   			help.clear();
   			return cur;
   		}
   
   		private void union(String s1, String s2) {
   			if (parent.containsKey(s1) && parent.containsKey(s2)) {
   				String f1 = find(s1);
   				String f2 = find(s2);
   				if (!f1.equals(f2)) {
   					int size1 = size.get(f1);
   					int size2 = size.get(f2);
   					String big = size1 >= size2 ? f1 : f2;
   					String small = big == f1 ? f2 : f1;
   					parent.put(small, big);
   					size.put(big, size1 + size2);
   					sets--;
   				}
   			}
   		}
   
   		public int connect(int r, int c) {
   			String key = String.valueOf(r) + "_" + String.valueOf(c);
   			if (!parent.containsKey(key)) {
   				parent.put(key, key);
   				size.put(key, 1);
   				sets++;
   				String up = String.valueOf(r - 1) + "_" + String.valueOf(c);
   				String down = String.valueOf(r + 1) + "_" + String.valueOf(c);
   				String left = String.valueOf(r) + "_" + String.valueOf(c - 1);
   				String right = String.valueOf(r) + "_" + String.valueOf(c + 1);
   				union(up, key);
   				union(down, key);
   				union(left, key);
   				union(right, key);
   			}
   			return sets;
   		}
   
   	}
   
   }
   
   ```

   

4. **==岛问题（扩展）==**

   ![image-20220709152511790](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207091525860.png)

   ![image-20220709154824344](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207091548464.png)



# Lesson16  

0. ==**图**==

   ![image-20220710100650593](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207101006650.png)

   ![image-20220710100711873](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207101007922.png)

   ![image-20220710100732414](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207101007469.png)

   ![image-20220710100753961](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207101007012.png)

   ![image-20220710093827921](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207100938005.png)

   ![image-20220710094120913](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207100941010.png)

   ![image-20220710094420545](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207100944621.png)

   ![image-20220710095001035](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207100950121.png)

   ![image-20220710095337850](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207100953933.png)

   ```java
   import java.util.ArrayList;
   
   // 点结构的描述
   public class Node {
   	public int value;
   	public int in;
   	public int out;
   	public ArrayList<Node> nexts;
   	public ArrayList<Edge> edges;
   
   	public Node(int value) {
   		this.value = value;
   		in = 0;
   		out = 0;
   		nexts = new ArrayList<>();
   		edges = new ArrayList<>();
   	}
   }
   ```

   ```java
   // 接上个代码中的edge
   public class Edge {
   	public int weight;
   	public Node from;
   	public Node to;
   
   	public Edge(int weight, Node from, Node to) {
   		this.weight = weight;
   		this.from = from;
   		this.to = to;
   	}
   
   }
   ```

   ```java
   import java.util.HashMap;
   import java.util.HashSet;
   
   public class Graph {
   	public HashMap<Integer, Node> nodes;
   	public HashSet<Edge> edges;
   	
   	public Graph() {
   		nodes = new HashMap<>();
   		edges = new HashSet<>();
   	}
   }
   ```

   ```java
   public class GraphGenerator {
   
   	// matrix 所有的边
   	// N*3 的矩阵
   	// [weight, from节点上面的值，to节点上面的值]
   	// 
   	// [ 5 , 0 , 7]
   	// [ 3 , 0,  1]
   	// 
   	public static Graph createGraph(int[][] matrix) {
   		Graph graph = new Graph();
   		for (int i = 0; i < matrix.length; i++) {
   			 // 拿到每一条边， matrix[i] 
   			int weight = matrix[i][0];
   			int from = matrix[i][1];
   			int to = matrix[i][2];
   			if (!graph.nodes.containsKey(from)) {
   				graph.nodes.put(from, new Node(from));
   			}
   			if (!graph.nodes.containsKey(to)) {
   				graph.nodes.put(to, new Node(to));
   			}
   			Node fromNode = graph.nodes.get(from);
   			Node toNode = graph.nodes.get(to);
   			Edge newEdge = new Edge(weight, fromNode, toNode);
   			fromNode.nexts.add(toNode);
   			fromNode.out++;
   			toNode.in++;
   			fromNode.edges.add(newEdge);
   			graph.edges.add(newEdge);
   		}
   		return graph;
   	}
   
   }
   
   ```



1. **==宽度优先遍历==**

   ```java
   import java.util.HashSet;
   import java.util.LinkedList;
   import java.util.Queue;
   
   public class Code01_BFS {
   
   	// 从node出发，进行宽度优先遍历
   	public static void bfs(Node start) {
   		if (start == null) {
   			return;
   		}
   		Queue<Node> queue = new LinkedList<>();
   		HashSet<Node> set = new HashSet<>();
   		queue.add(start);
   		set.add(start);
   		while (!queue.isEmpty()) {
   			Node cur = queue.poll();
   			System.out.println(cur.value);
   			for (Node next : cur.nexts) {
   				if (!set.contains(next)) {
   					set.add(next);
   					queue.add(next);
   				}
   			}
   		}
   	}
   }
   ```

   

2. **==深度优先遍历==**

   ![image-20220710110622410](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207101106494.png)

   ```java
   // set有两个功能
   // 1. 禁止走环路
   // 2. 禁止走回路
   
   // 思路：先将head压入栈和set，在while循环里，弹出一个结点，再将弹出结点的
   //      指向结点的中的任意一个压入栈，在压入栈之前，在把弹出的结点压入栈，循环
   //      直到栈为空
   import java.util.HashSet;
   import java.util.Stack;
   
   public class Code02_DFS {
   
   	public static void dfs(Node node) {
   		if (node == null) {
   			return;
   		}
   		Stack<Node> stack = new Stack<>();
   		HashSet<Node> set = new HashSet<>();
   		stack.add(node);
   		set.add(node);
   		System.out.println(node.value);
   		while (!stack.isEmpty()) {
   			Node cur = stack.pop();
   			for (Node next : cur.nexts) {
   				if (!set.contains(next)) {
   					stack.push(cur);
   					stack.push(next);
   					set.add(next);
                       // 入栈就打印
   					System.out.println(next.value);
   					break;
   				}
   			}
   		}
   	}
   }
   ```

   

3. ==**图的拓扑排序算法**==

   > ==拓扑排序的一定是有向无环图==

   ![image-20220710111122596](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207101111675.png)

   ```java
   //拓扑排序不唯一
   
   import java.util.ArrayList;
   import java.util.HashMap;
   import java.util.LinkedList;
   import java.util.List;
   import java.util.Queue;
   
   public class Code03_TopologySort {
   
   	// directed graph and no loop
   	public static List<Node> sortedTopology(Graph graph) {
   		// key 某个节点   value 剩余的入度
   		HashMap<Node, Integer> inMap = new HashMap<>();
   		// 只有剩余入度为0的点，才进入这个队列
   		Queue<Node> zeroInQueue = new LinkedList<>();
   		for (Node node : graph.nodes.values()) {
   			inMap.put(node, node.in);
   			if (node.in == 0) {
   				zeroInQueue.add(node);
   			}
   		}
   		List<Node> result = new ArrayList<>();
   		while (!zeroInQueue.isEmpty()) {
   			Node cur = zeroInQueue.poll();
   			result.add(cur);
   			for (Node next : cur.nexts) {
   				inMap.put(next, inMap.get(next) - 1);
   				if (inMap.get(next) == 0) {
   					zeroInQueue.add(next);
   				}
   			}
   		}
   		return result;
   	}
   }
   ```



4. **==拓扑序（自己改写图结构）==**

   ![image-20220710113811169](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207101138243.png)

   ![image-20220710114434874](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207101144954.png)

   ![image-20220710115306349](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207101153425.png)

   ```java
   package class16;
   
   import java.util.ArrayList;
   import java.util.HashMap;
   import java.util.LinkedList;
   import java.util.Queue;
   
   // OJ链接：https://www.lintcode.com/problem/topological-sorting
   public class Code03_TopologicalOrderBFS {
   
   	// 不要提交这个类
   	public static class DirectedGraphNode {
   		public int label;
   		public ArrayList<DirectedGraphNode> neighbors;
   
   		public DirectedGraphNode(int x) {
   			label = x;
   			neighbors = new ArrayList<DirectedGraphNode>();
   		}
   	}
   
   	// 提交下面的
   	public static ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
   		HashMap<DirectedGraphNode, Integer> indegreeMap = new HashMap<>();
   		for (DirectedGraphNode cur : graph) {
   			indegreeMap.put(cur, 0);
   		}
   		for (DirectedGraphNode cur : graph) {
   			for (DirectedGraphNode next : cur.neighbors) {
   				indegreeMap.put(next, indegreeMap.get(next) + 1);
   			}
   		}
   		Queue<DirectedGraphNode> zeroQueue = new LinkedList<>();
   		for (DirectedGraphNode cur : indegreeMap.keySet()) {
   			if (indegreeMap.get(cur) == 0) {
   				zeroQueue.add(cur);
   			}
   		}
   		ArrayList<DirectedGraphNode> ans = new ArrayList<>();
   		while (!zeroQueue.isEmpty()) {
   			DirectedGraphNode cur = zeroQueue.poll();
   			ans.add(cur);
   			for (DirectedGraphNode next : cur.neighbors) {
   				indegreeMap.put(next, indegreeMap.get(next) - 1);
   				if (indegreeMap.get(next) == 0) {
   					zeroQueue.offer(next);
   				}
   			}
   		}
   		return ans;
   	}
   
   }
   
   ```

   ```java
   // 根据点次，如果x的点次大于y的点次，则x的拓扑序 <= y的拓扑序
   package class16;
   
   import java.util.ArrayList;
   import java.util.Comparator;
   import java.util.HashMap;
   
   // OJ链接：https://www.lintcode.com/problem/topological-sorting
   public class Code03_TopologicalOrderDFS2 {
   
   	// 不要提交这个类
   	public static class DirectedGraphNode {
   		public int label;
   		public ArrayList<DirectedGraphNode> neighbors;
   
   		public DirectedGraphNode(int x) {
   			label = x;
   			neighbors = new ArrayList<DirectedGraphNode>();
   		}
   	}
   
   	// 提交下面的
   	public static class Record {
   		public DirectedGraphNode node;
   		public long nodes;
   
   		public Record(DirectedGraphNode n, long o) {
   			node = n;
   			nodes = o;
   		}
   	}
   
   	public static class MyComparator implements Comparator<Record> {
   
   		@Override
   		public int compare(Record o1, Record o2) {
   			return o1.nodes == o2.nodes ? 0 : (o1.nodes > o2.nodes ? -1 : 1);
   		}
   	}
   
   	public static ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
   		HashMap<DirectedGraphNode, Record> order = new HashMap<>();
   		for (DirectedGraphNode cur : graph) {
   			f(cur, order);
   		}
   		ArrayList<Record> recordArr = new ArrayList<>();
   		for (Record r : order.values()) {
   			recordArr.add(r);
   		}
   		recordArr.sort(new MyComparator());
   		ArrayList<DirectedGraphNode> ans = new ArrayList<DirectedGraphNode>();
   		for (Record r : recordArr) {
   			ans.add(r.node);
   		}
   		return ans;
   	}
   
   	// 当前来到cur点，请返回cur点所到之处，所有的点次！
   	// 返回（cur，点次）
   	// 缓存！！！！！order   
   	//  key : 某一个点的点次，之前算过了！
   	//  value : 点次是多少
   	public static Record f(DirectedGraphNode cur, HashMap<DirectedGraphNode, Record> order) {
   		if (order.containsKey(cur)) {
   			return order.get(cur);
   		}
   		// cur的点次之前没算过！
   		long nodes = 0;
   		for (DirectedGraphNode next : cur.neighbors) {
   			nodes += f(next, order).nodes;
   		}
   		Record ans = new Record(cur, nodes + 1);
   		order.put(cur, ans);
   		return ans;
   	}
   
   }
   
   ```

   ```java
   // 根据最大深度，如果x的深度大于y的深度，则x的拓扑序 <= y的拓扑序
   
   import java.util.ArrayList;
   import java.util.Comparator;
   import java.util.HashMap;
   
   // OJ链接：https://www.lintcode.com/problem/topological-sorting
   public class Code03_TopologicalOrderDFS1 {
   
   	// 不要提交这个类
   	public static class DirectedGraphNode {
   		public int label;
   		public ArrayList<DirectedGraphNode> neighbors;
   
   		public DirectedGraphNode(int x) {
   			label = x;
   			neighbors = new ArrayList<DirectedGraphNode>();
   		}
   	}
   
   	// 提交下面的
   	public static class Record {
   		public DirectedGraphNode node;
   		public int deep;
   
   		public Record(DirectedGraphNode n, int o) {
   			node = n;
   			deep = o;
   		}
   	}
   
   	public static class MyComparator implements Comparator<Record> {
   
   		@Override
   		public int compare(Record o1, Record o2) {
   			return o2.deep - o1.deep;
   		}
   	}
   
   	public static ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
   		HashMap<DirectedGraphNode, Record> order = new HashMap<>();
   		for (DirectedGraphNode cur : graph) {
   			f(cur, order);
   		}
   		ArrayList<Record> recordArr = new ArrayList<>();
   		for (Record r : order.values()) {
   			recordArr.add(r);
   		}
   		recordArr.sort(new MyComparator());
   		ArrayList<DirectedGraphNode> ans = new ArrayList<DirectedGraphNode>();
   		for (Record r : recordArr) {
   			ans.add(r.node);
   		}
   		return ans;
   	}
   
   	public static Record f(DirectedGraphNode cur, HashMap<DirectedGraphNode, Record> order) {
   		if (order.containsKey(cur)) {
   			return order.get(cur);
   		}
   		int follow = 0;
   		for (DirectedGraphNode next : cur.neighbors) {
   			follow = Math.max(follow, f(next, order).deep);
   		}
   		Record ans = new Record(cur, follow + 1);
   		order.put(cur, ans);
   		return ans;
   	}
   }
   ```

   

5. **==最小生成树算法==**

   > 无向图

   ![image-20220710145345949](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207101453038.png)

   ![image-20220710121523742](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207101215827.png)

   ```java
   // 思路：每个结点先生成自己的集合，然后权重从小到大，依次筛选边，
   //      如何该边两端的两个结点，不在一个集合，那就要这条边，且
   //      将这两个结点放在同一个集合中，同样的步骤，遍历完所有的
   //      边，这时所有结点放在了同一个集合里了
   
   import java.util.Collection;
   import java.util.Comparator;
   import java.util.HashMap;
   import java.util.HashSet;
   import java.util.PriorityQueue;
   import java.util.Set;
   import java.util.Stack;
   
   //undirected graph only
   public class Code04_Kruskal {
   
   	// Union-Find Set
   	public static class UnionFind {
   		// key 某一个节点， value key节点往上的节点
   		private HashMap<Node, Node> fatherMap;
   		// key 某一个集合的代表节点, value key所在集合的节点个数
   		private HashMap<Node, Integer> sizeMap;
   
   		public UnionFind() {
   			fatherMap = new HashMap<Node, Node>();
   			sizeMap = new HashMap<Node, Integer>();
   		}
   		
   		public void makeSets(Collection<Node> nodes) {
   			fatherMap.clear();
   			sizeMap.clear();
   			for (Node node : nodes) {
   				fatherMap.put(node, node);
   				sizeMap.put(node, 1);
   			}
   		}
   
   		private Node findFather(Node n) {
   			Stack<Node> path = new Stack<>();
   			while(n != fatherMap.get(n)) {
   				path.add(n);
   				n = fatherMap.get(n);
   			}
   			while(!path.isEmpty()) {
   				fatherMap.put(path.pop(), n);
   			}
   			return n;
   		}
   
   		public boolean isSameSet(Node a, Node b) {
   			return findFather(a) == findFather(b);
   		}
   
   		public void union(Node a, Node b) {
   			if (a == null || b == null) {
   				return;
   			}
   			Node aDai = findFather(a);
   			Node bDai = findFather(b);
   			if (aDai != bDai) {
   				int aSetSize = sizeMap.get(aDai);
   				int bSetSize = sizeMap.get(bDai);
   				if (aSetSize <= bSetSize) {
   					fatherMap.put(aDai, bDai);
   					sizeMap.put(bDai, aSetSize + bSetSize);
   					sizeMap.remove(aDai);
   				} else {
   					fatherMap.put(bDai, aDai);
   					sizeMap.put(aDai, aSetSize + bSetSize);
   					sizeMap.remove(bDai);
   				}
   			}
   		}
   	}
   	
   
   	public static class EdgeComparator implements Comparator<Edge> {
   
   		@Override
   		public int compare(Edge o1, Edge o2) {
   			return o1.weight - o2.weight;
   		}
   
   	}
   
   	public static Set<Edge> kruskalMST(Graph graph) {
   		UnionFind unionFind = new UnionFind();
   		unionFind.makeSets(graph.nodes.values());
   		// 从小的边到大的边，依次弹出，小根堆！
   		PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
   		for (Edge edge : graph.edges) { // M 条边
   			priorityQueue.add(edge);  // O(logM)
   		}
   		Set<Edge> result = new HashSet<>();
   		while (!priorityQueue.isEmpty()) { // M 条边
   			Edge edge = priorityQueue.poll(); // O(logM)
   			if (!unionFind.isSameSet(edge.from, edge.to)) { // O(1)
   				result.add(edge);
   				unionFind.union(edge.from, edge.to);
   			}
   		}
   		return result;
   	}
   }
   
   ```

   

6. **==P算法==**

   ![image-20220710151029629](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207101510712.png)

   ![image-20220710152302480](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207101523585.png)

   ```java
   // 在第三个步骤中，判断这个边会不会形成环，那就看这个边to结点
   // 是否已经在解锁的结点中，如果在，那就不要这条边，如果不在，那就
   // 那就要这条边
   
   import java.util.Comparator;
   import java.util.HashSet;
   import java.util.PriorityQueue;
   import java.util.Set;
   
   // undirected graph only
   public class Code05_Prim {
   
   	public static class EdgeComparator implements Comparator<Edge> {
   
   		@Override
   		public int compare(Edge o1, Edge o2) {
   			return o1.weight - o2.weight;
   		}
   
   	}
   
   	public static Set<Edge> primMST(Graph graph) {
   		// 解锁的边进入小根堆
   		PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
   
   		// 哪些点被解锁出来了
   		HashSet<Node> nodeSet = new HashSet<>();
   		
   		
   		
   		Set<Edge> result = new HashSet<>(); // 依次挑选的的边在result里
   
   		for (Node node : graph.nodes.values()) { // 随便挑了一个点
   			// node 是开始点
   			if (!nodeSet.contains(node)) {
   				nodeSet.add(node);
   				for (Edge edge : node.edges) { // 由一个点，解锁所有相连的边
   					priorityQueue.add(edge);
   				}
   				while (!priorityQueue.isEmpty()) {
   					Edge edge = priorityQueue.poll(); // 弹出解锁的边中，最小的边
   					Node toNode = edge.to; // 可能的一个新的点
   					if (!nodeSet.contains(toNode)) { // 不含有的时候，就是新的点
   						nodeSet.add(toNode);
   						result.add(edge);
   						for (Edge nextEdge : toNode.edges) {
   							priorityQueue.add(nextEdge);
   						}
   					}
   				}
   			}
   			// break;  // 如果防森林就不注释break，如果所有的点能联                             通，那就注释掉break
   		}
   		return result;
   	}
   
   	// 请保证graph是连通图
   	// graph[i][j]表示点i到点j的距离，如果是系统最大值代表无路
   	// 返回值是最小连通图的路径之和
   	public static int prim(int[][] graph) {
   		int size = graph.length;
   		int[] distances = new int[size];
   		boolean[] visit = new boolean[size];
   		visit[0] = true;
   		for (int i = 0; i < size; i++) {
   			distances[i] = graph[0][i];
   		}
   		int sum = 0;
   		for (int i = 1; i < size; i++) {
   			int minPath = Integer.MAX_VALUE;
   			int minIndex = -1;
   			for (int j = 0; j < size; j++) {
   				if (!visit[j] && distances[j] < minPath) {
   					minPath = distances[j];
   					minIndex = j;
   				}
   			}
   			if (minIndex == -1) {
   				return sum;
   			}
   			visit[minIndex] = true;
   			sum += minPath;
   			for (int j = 0; j < size; j++) {
   				if (!visit[j] && distances[j] > graph[minIndex][j]) {
   					distances[j] = graph[minIndex][j];
   				}
   			}
   		}
   		return sum;
   	}
   
   	public static void main(String[] args) {
   		System.out.println("hello world!");
   	}
   
   }
   
   ```

   > K算法和P算法的总结：
   >
   > * K算法是遍历完所有的边（解锁完所有的边），程序才能结束，这就不适合边比较多的图。
   > * P算法是遍历完所有的点（解锁完所有的边），程序才能结束，这就不适合点特别多的图。

   ![image-20220710155211733](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207101552849.png)



7. **==Dijkstra==**

   > * 有向，无负权重，可以有环的图
   >
   > * 求一个图中一个点到其他所有点的最短路径的算法

   ![image-20220710155958571](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207101559683.png)
   
   ```java
   
   
   import java.util.HashMap;
   import java.util.HashSet;
   import java.util.Map.Entry;
   
   // no negative weight
   public class Code06_Dijkstra {
   
   	public static HashMap<Node, Integer> dijkstra1(Node from) {
   		HashMap<Node, Integer> distanceMap = new HashMap<>();
   		distanceMap.put(from, 0);
   		// 打过对号的点
   		HashSet<Node> selectedNodes = new HashSet<>();
           // 在distanceMap中选出，还未打过对号的，distanceMap中value最小的Node
   		Node minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
   		while (minNode != null) {
   			//  原始点  ->  minNode(跳转点)   最小距离distance
   			int distance = distanceMap.get(minNode);
   			for (Edge edge : minNode.edges) {
   				Node toNode = edge.to;
   				if (!distanceMap.containsKey(toNode)) {
   					distanceMap.put(toNode, distance + edge.weight);
   				} else { // toNode 
   					distanceMap.put(edge.to, Math.min(distanceMap.get(toNode), distance + edge.weight));
   				}
   			}
   			selectedNodes.add(minNode);
   			minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
   		}
   		return distanceMap;
   	}
   
   	public static Node getMinDistanceAndUnselectedNode(HashMap<Node, Integer> distanceMap, HashSet<Node> touchedNodes) {
   		Node minNode = null;
   		int minDistance = Integer.MAX_VALUE;
   		for (Entry<Node, Integer> entry : distanceMap.entrySet()) {
   			Node node = entry.getKey();
   			int distance = entry.getValue();
   			if (!touchedNodes.contains(node) && distance < minDistance) {
   				minNode = node;
   				minDistance = distance;
   			}
   		}
   		return minNode;
   	}
   
   	public static class NodeRecord {
   		public Node node;
   		public int distance;
   
   		public NodeRecord(Node node, int distance) {
   			this.node = node;
   			this.distance = distance;
   		}
   	}
   
   	public static class NodeHeap {
   		private Node[] nodes; // 实际的堆结构
   		// key 某一个node， value 上面堆中的位置
   		private HashMap<Node, Integer> heapIndexMap;
   		// key 某一个节点， value 从源节点出发到该节点的目前最小距离
   		private HashMap<Node, Integer> distanceMap;
   		private int size; // 堆上有多少个点
   
   		public NodeHeap(int size) {
   			nodes = new Node[size];
   			heapIndexMap = new HashMap<>();
   			distanceMap = new HashMap<>();
   			size = 0;
   		}
   
   		public boolean isEmpty() {
   			return size == 0;
   		}
   
   		// 有一个点叫node，现在发现了一个从源节点出发到达node的距离为distance
   		// 判断要不要更新，如果需要的话，就更新
   		public void addOrUpdateOrIgnore(Node node, int distance) {
   			if (inHeap(node)) {
   				distanceMap.put(node, Math.min(distanceMap.get(node), distance));
   				insertHeapify(heapIndexMap.get(node));
   			}
   			if (!isEntered(node)) {
   				nodes[size] = node;
   				heapIndexMap.put(node, size);
   				distanceMap.put(node, distance);
   				insertHeapify(size++);
   			}
   		}
   
   		public NodeRecord pop() {
   			NodeRecord nodeRecord = new NodeRecord(nodes[0], distanceMap.get(nodes[0]));
   			swap(0, size - 1);
   			heapIndexMap.put(nodes[size - 1], -1);
   			distanceMap.remove(nodes[size - 1]);
   			// free C++同学还要把原本堆顶节点析构，对java同学不必
   			nodes[size - 1] = null;
   			heapify(0, --size);
   			return nodeRecord;
   		}
   
   		private void insertHeapify(int index) {
   			while (distanceMap.get(nodes[index]) < distanceMap.get(nodes[(index - 1) / 2])) {
   				swap(index, (index - 1) / 2);
   				index = (index - 1) / 2;
   			}
   		}
   
   		private void heapify(int index, int size) {
   			int left = index * 2 + 1;
   			while (left < size) {
   				int smallest = left + 1 < size && distanceMap.get(nodes[left + 1]) < distanceMap.get(nodes[left])
   						? left + 1
   						: left;
   				smallest = distanceMap.get(nodes[smallest]) < distanceMap.get(nodes[index]) ? smallest : index;
   				if (smallest == index) {
   					break;
   				}
   				swap(smallest, index);
   				index = smallest;
   				left = index * 2 + 1;
   			}
   		}
   
   		private boolean isEntered(Node node) {
   			return heapIndexMap.containsKey(node);
   		}
   
   		private boolean inHeap(Node node) {
   			return isEntered(node) && heapIndexMap.get(node) != -1;
   		}
   
   		private void swap(int index1, int index2) {
   			heapIndexMap.put(nodes[index1], index2);
   			heapIndexMap.put(nodes[index2], index1);
   			Node tmp = nodes[index1];
   			nodes[index1] = nodes[index2];
   			nodes[index2] = tmp;
   		}
   	}
   
   	// 改进后的dijkstra算法
   	// 从head出发，所有head能到达的节点，生成到达每个节点的最小路径记录并返回
   	public static HashMap<Node, Integer> dijkstra2(Node head, int size) {
   		NodeHeap nodeHeap = new NodeHeap(size);
   		nodeHeap.addOrUpdateOrIgnore(head, 0);
   		HashMap<Node, Integer> result = new HashMap<>();
   		while (!nodeHeap.isEmpty()) {
   			NodeRecord record = nodeHeap.pop();
   			Node cur = record.node;
   			int distance = record.distance;
   			for (Edge edge : cur.edges) {
   				nodeHeap.addOrUpdateOrIgnore(edge.to, edge.weight + distance);
   			}
   			result.put(cur, distance);
   		}
   		return result;
   	}
   
   }
   
   ```
   
   

# Lesson17

1. ==加强堆实现Dijkstra算法（后续学）==

## 暴力递归

0. ==**前置知识**==

![image-20220714120950500](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207141209575.png)



1. **==汉诺塔问题==**

   > * 递归函数，可以通过增加参数的方式，增加问题可能性

   ![image-20220714121109940](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207141211019.png)
   
   ```java
   package class17;
   
   import java.util.Stack;
   
   public class Code02_Hanoi {
   
       // 把主过程的每一步写清，就可以写出递归，但这种递归是多个子过程
       // 相互嵌套的
   	public static void hanoi1(int n) {
   		leftToRight(n);
   	}
   	// 递归的边界条件，可以从一开始就考虑，就考虑那些已知的，不需要递归的情况
       // 就不用考虑递归最后结束的条件
   	// 请把1~N层圆盘 从最左 -> 最右
   	public static void leftToRight(int n) {
   		if (n == 1) { // base case
   			System.out.println("Move 1 from left to right");
   			return;
   		}
   		leftToMid(n - 1);
           // 把第n层圆盘从最左移到最右，不是把n个圆盘从最左移到最右
   		System.out.println("Move " + n + " from left to right");
   		midToRight(n - 1);
   	}
   
   	// 请把1~N层圆盘 从左 -> 中
   	public static void leftToMid(int n) {
   		if (n == 1) {
   			System.out.println("Move 1 from left to mid");
   			return;
   		}
   		leftToRight(n - 1);
   		System.out.println("Move " + n + " from left to mid");
   		rightToMid(n - 1);
   	}
   
   	public static void rightToMid(int n) {
   		if (n == 1) {
   			System.out.println("Move 1 from right to mid");
   			return;
   		}
   		rightToLeft(n - 1);
   		System.out.println("Move " + n + " from right to mid");
   		leftToMid(n - 1);
   	}
   
   	public static void midToRight(int n) {
   		if (n == 1) {
   			System.out.println("Move 1 from mid to right");
   			return;
   		}
   		midToLeft(n - 1);
   		System.out.println("Move " + n + " from mid to right");
   		leftToRight(n - 1);
   	}
   
   	public static void midToLeft(int n) {
   		if (n == 1) {
   			System.out.println("Move 1 from mid to left");
   			return;
   		}
   		midToRight(n - 1);
   		System.out.println("Move " + n + " from mid to left");
   		rightToLeft(n - 1);
   	}
   
   	public static void rightToLeft(int n) {
   		if (n == 1) {
   			System.out.println("Move 1 from right to left");
   			return;
   		}
   		rightToMid(n - 1);
   		System.out.println("Move " + n + " from right to left");
   		midToLeft(n - 1);
   	}
   
   	public static void hanoi2(int n) {
   		if (n > 0) {
   			func(n, "left", "right", "mid");
   		}
   	}
   
       
   	public static void func(int N, String from, String to, String other) {
   		if (N == 1) { // base
   			System.out.println("Move 1 from " + from + " to " + to);
   		} else {
   			func(N - 1, from, other, to);
   			System.out.println("Move " + N + " from " + from + " to " + to);
   			func(N - 1, other, to, from);
   		}
   	}
   
   	public static class Record {
   		public boolean finish1;
   		public int base;
   		public String from;
   		public String to;
   		public String other;
   
   		public Record(boolean f1, int b, String f, String t, String o) {
   			finish1 = false;
   			base = b;
   			from = f;
   			to = t;
   			other = o;
   		}
   	}
   
       // 递归版本
   	public static void hanoi3(int N) {
   		if (N < 1) {
   			return;
   		}
   		Stack<Record> stack = new Stack<>();
   		stack.add(new Record(false, N, "left", "right", "mid"));
   		while (!stack.isEmpty()) {
   			Record cur = stack.pop();
   			if (cur.base == 1) {
   				System.out.println("Move 1 from " + cur.from + " to " + cur.to);
   				if (!stack.isEmpty()) {
   					stack.peek().finish1 = true;
   				}
   			} else {
   				if (!cur.finish1) {
   					stack.push(cur);
   					stack.push(new Record(false, cur.base - 1, cur.from, cur.other, cur.to));
   				} else {
   					System.out.println("Move " + cur.base + " from " + cur.from + " to " + cur.to);
   					stack.push(new Record(false, cur.base - 1, cur.other, cur.to, cur.from));
   				}
   			}
   		}
   	}
   
   	public static void main(String[] args) {
   		int n = 3;
   		hanoi1(n);
   		System.out.println("============");
   		hanoi2(n);
   //		System.out.println("============");
   //		hanoi3(n);
   	}
   
   }
   
   ```
   
2. **==打印一个字符串的所有子序列和去重子数列==**

   > * 对于递归函数，可以一个黑盒，定义这个函数一开始，就把功能明确定好，在函数内部调用自己的时候，就把它当成一个黑盒
   >
   
   ![image-20220715151705337](https://dawn1314.oss-cn-beijing.aliyuncs.com/202207151517404.png)
   
   ```java
   package class17;
   
   import java.util.ArrayList;
   import java.util.HashSet;
   import java.util.List;
   
   public class Code03_PrintAllSubsquences {
   
   	// s -> "abc" ->
       // 子序列包括空序列和自己本身
   	public static List<String> subs(String s) {
   		char[] str = s.toCharArray();
   		String path = "";
   		List<String> ans = new ArrayList<>();
   		process1(str, 0, ans, path);
   		return ans;
   	}
   
   	// str 固定参数
   	// 来到了str[index]字符，index是位置
   	// str[0..index-1]已经走过了！之前的决定，都在path上
   	// 之前的决定已经不能改变了，就是path
   	// str[index....]还能决定，之前已经确定，而后面还能自由选择的话，
   	// 把所有生成的子序列，放入到ans里去
       // 将从index以后生成的子序列分别和path合并，然后分别放入ans里
       // 这里从index开始，就成了一个通用的，可以从一个数组的任意位置处求子序列，
       // 就不是非得从0位置开始打印
   	public static void process1(char[] str, int index, List<String> ans, String path) {
   		if (index == str.length) {
   			ans.add(path);
   			return;
   		}
   		// 没有要index位置的字符
   		process1(str, index + 1, ans, path);
   		// 要了index位置的字符
   		process1(str, index + 1, ans, path + String.valueOf(str[index]));
   	}
   
   	public static List<String> subsNoRepeat(String s) {
   		char[] str = s.toCharArray();
   		String path = "";
           // hashset有去重的功能
   		HashSet<String> set = new HashSet<>();
   		process2(str, 0, set, path);
   		List<String> ans = new ArrayList<>();
   		for (String cur : set) {
   			ans.add(cur);
   		}
   		return ans;
   	}
   
   	public static void process2(char[] str, int index, HashSet<String> set, String path) {
   		if (index == str.length) {
   			set.add(path);
   			return;
   		}
   		String no = path;
   		process2(str, index + 1, set, no);
   		String yes = path + String.valueOf(str[index]);
   		process2(str, index + 1, set, yes);
   	}
   
   	public static void main(String[] args) {
   		String test = "acccc";
   		List<String> ans1 = subs(test);
   		List<String> ans2 = subsNoRepeat(test);
   
   		for (String str : ans1) {
   			System.out.println(str);
   		}
   		System.out.println("=================");
   		for (String str : ans2) {
   			System.out.println(str);
   		}
   		System.out.println("=================");
   
   	}
   
   }
   
   ```
   
3. **==打印字符串的全排列，要求不要出现重复的排列==**

   > * 深度优先遍历的常用技巧之一：遍历完恢复现场
   > * 动态规划的关键之一：递归函数可变参数的设计
   > * 总结
   >   + 第二题去重，是在最后过滤掉相同的序列；而这题的去重是在排列的过程中就排除掉相同的排列，这种方法也叫做剪枝（在递归中，排除掉不符合条件）
   >   + 比较来说，剪枝比过滤更快，因为过滤的前提是得把全部的序列求出，所以比较慢

   ![image-20220715151721764](https://dawn1314.oss-cn-beijing.aliyuncs.com/202207151517823.png)

   ```java
   package class17;
   
   import java.util.ArrayList;
   import java.util.List;
   
   public class Code04_PrintAllPermutations {
   
   	public static List<String> permutation1(String s) {
   		List<String> ans = new ArrayList<>();
   		if (s == null || s.length() == 0) {
   			return ans;
   		}
   		char[] str = s.toCharArray();
   		ArrayList<Character> rest = new ArrayList<Character>();
   		for (char cha : str) {
   			rest.add(cha);
   		}
   		String path = "";
   		f(rest, path, ans);
   		return ans;
   	}
   
   	public static void f(ArrayList<Character> rest, String path, List<String> ans) {
   		if (rest.isEmpty()) {
   			ans.add(path);
   		} else {
   			int N = rest.size();
   			for (int i = 0; i < N; i++) {
   				char cur = rest.get(i);
   				rest.remove(i);
   				f(rest, path + cur, ans);
   				rest.add(i, cur);
   			}
   		}
   	}
   
   	public static List<String> permutation2(String s) {
   		List<String> ans = new ArrayList<>();
   		if (s == null || s.length() == 0) {
   			return ans;
   		}
   		char[] str = s.toCharArray();
   		g1(str, 0, ans);
   		return ans;
   	}
   
   	public static void g1(char[] str, int index, List<String> ans) {
   		if (index == str.length) {
   			ans.add(String.valueOf(str));
   		} else {
   			for (int i = index; i < str.length; i++) {
   				swap(str, index, i);
   				g1(str, index + 1, ans);
   				swap(str, index, i);
   			}
   		}
   	}
   
   	public static List<String> permutation3(String s) {
   		List<String> ans = new ArrayList<>();
   		if (s == null || s.length() == 0) {
   			return ans;
   		}
   		char[] str = s.toCharArray();
   		g2(str, 0, ans);
   		return ans;
   	}
   
   	public static void g2(char[] str, int index, List<String> ans) {
   		if (index == str.length) {
   			ans.add(String.valueOf(str));
   		} else {
   			boolean[] visited = new boolean[256];
   			for (int i = index; i < str.length; i++) {
   				if (!visited[str[i]]) {
   					visited[str[i]] = true;
   					swap(str, index, i);
   					g2(str, index + 1, ans);
   					swap(str, index, i);
   				}
   			}
   		}
   	}
   
   	public static void swap(char[] chs, int i, int j) {
   		char tmp = chs[i];
   		chs[i] = chs[j];
   		chs[j] = tmp;
   	}
   }
   ```

4. **==逆序一个栈==**

   ![image-20220715164407427](https://dawn1314.oss-cn-beijing.aliyuncs.com/202207151644487.png)

   ![image-20220715165300401](https://dawn1314.oss-cn-beijing.aliyuncs.com/202207151653489.png)

   ![image-20220715165908082](https://dawn1314.oss-cn-beijing.aliyuncs.com/202207151659165.png)

   ```java
   package class17;
   
   import java.util.Stack;
   
   public class Code05_ReverseStackUsingRecursive {
   
   	public static void reverse(Stack<Integer> stack) {
   		if (stack.isEmpty()) {
   			return;
   		}
   		int i = f(stack);
   		reverse(stack);
   		stack.push(i);
   	}
   
   	// 栈底元素移除掉
   	// 上面的元素盖下来
   	// 返回移除掉的栈底元素
   	public static int f(Stack<Integer> stack) {
   		int result = stack.pop();
   		if (stack.isEmpty()) {
   			return result;
   		} else {
   			int last = f(stack);
   			stack.push(result);
   			return last;
   		}
   	}
   
   	public static void main(String[] args) {
   		Stack<Integer> test = new Stack<Integer>();
   		test.push(1);
   		test.push(2);
   		test.push(3);
   		test.push(4);
   		test.push(5);
   		reverse(test);
   		while (!test.isEmpty()) {
   			System.out.println(test.pop());
   		}
   
   	}
   
   }
   ```

   

## Lesson18

0. 前置知识

   * 动态规划的总结：

     算过一次后把答案记下来，如果发现有重复调用的过程，直接调之前的答案（之前算的放在一张表里，这叫做缓存）就叫做动态规划，空间换时间的一种做法

   + 动态规划是从尝试开始，把好的尝试写出来，后面优化是水到渠成的，这个尝试就是先把递归写出来，哪怕是暴力递归

   

   ![image-20220716081015204](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207160810343.png)

   * 递归的结束条件就是已知条件

1. ==机器人走路==

   + 什么样的暴力递归可以优化，出现重复解的暴力递归，如果暴力递归的么一个子过程都是不一样的，就没有办法动态规划。因为动态规划的目的就是为了防止子过程展开了一遍，再展开相同的子过程时，就不用展开了，直接拿值了，如果子过程是各不相同的，动态规划是，没办法使用的
   + 动态规划，好像是要记住子过程和其返回值
   + 这个题，如图所示，是从顶到下的动态规划，这种缓存是不关心位置依赖的。

   ![image-20220719124437145](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207191244240.png)

   ![image-20220719085207259](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207190852393.png)

   ![image-20220719121457827](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207191214958.png)

   ![image-20220719121746030](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207191217176.png)

   > * 上图是二维动态规划表
   > * 动态规划是结果，不是原因，写出一个最基本的尝试，一步一步的做缓存，一步一步分析位置依赖，你的尝试策略就是状态转移的东西，状态转移只是结果，不是原因，非常强调尝试，因为尝试是自然智慧，只要带有尝试的想法，是都能写来的，动态优化的版本只是最终优化的结果，尝试策略和状态转移方程是一码事，所以动态规划，一定要先尝试，也就是先暴力递归，先写出来
   > * 上面的那张表就是根据暴力递归的方法填出来的

   ```C
   package class18;
   
   public class Code01_RobotWalk {
   
   	public static int ways1(int N, int start, int aim, int K) {
   		if (N < 2 || start < 1 || start > N || aim < 1 || aim > N || K < 1) {
   			return -1;
   		}
   		return process1(start, K, aim, N);
   	}
   
   	// 机器人当前来到的位置是cur，
   	// 机器人还有rest步需要去走，
   	// 最终的目标是aim，
   	// 有哪些位置？1~N
   	// 返回：机器人从cur出发，走过rest步之后，最终停在aim的方法数，是多少？
   	public static int process1(int cur, int rest, int aim, int N) {
   		if (rest == 0) { // 如果已经不需要走了，走完了！
   			return cur == aim ? 1 : 0;
   		}
   		// (cur, rest)
   		if (cur == 1) { // 1 -> 2
   			return process1(2, rest - 1, aim, N);
   		}
   		// (cur, rest)
   		if (cur == N) { // N-1 <- N
   			return process1(N - 1, rest - 1, aim, N);
   		}
   		// (cur, rest)
   		return process1(cur - 1, rest - 1, aim, N) + process1(cur + 1, rest - 1, aim, N);
   	}
   
       // 缓存法
       // cur:1~N
       // rest:0~K
   	public static int ways2(int N, int start, int aim, int K) {
   		if (N < 2 || start < 1 || start > N || aim < 1 || aim > N || K < 1) {
   			return -1;
   		}
   		int[][] dp = new int[N + 1][K + 1];
   		for (int i = 0; i <= N; i++) {
   			for (int j = 0; j <= K; j++) {
   				dp[i][j] = -1;
   			}
   		}
   		// dp就是缓存表
   		// dp[cur][rest] == -1 -> process1(cur, rest)之前没算过！
   		// dp[cur][rest] != -1 -> process1(cur, rest)之前算过！返回值，dp[cur][rest]
   		// N+1 * K+1
   		return process2(start, K, aim, N, dp);
   	}
   
   	// cur 范: 1 ~ N
   	// rest 范：0 ~ K
   	public static int process2(int cur, int rest, int aim, int N, int[][] dp) {
   		if (dp[cur][rest] != -1) {
   			return dp[cur][rest];
   		}
   		// 之前没算过！
   		int ans = 0;
   		if (rest == 0) {
   			ans = cur == aim ? 1 : 0;
   		} else if (cur == 1) {
   			ans = process2(2, rest - 1, aim, N, dp);
   		} else if (cur == N) {
   			ans = process2(N - 1, rest - 1, aim, N, dp);
   		} else {
   			ans = process2(cur - 1, rest - 1, aim, N, dp) + process2(cur + 1, rest - 1, aim, N, dp);
   		}
   		dp[cur][rest] = ans;
   		return ans;
   
   	}
   
   	public static int ways3(int N, int start, int aim, int K) {
   		if (N < 2 || start < 1 || start > N || aim < 1 || aim > N || K < 1) {
   			return -1;
   		}
   		int[][] dp = new int[N + 1][K + 1];
   		dp[aim][0] = 1;
   		for (int rest = 1; rest <= K; rest++) {
   			dp[1][rest] = dp[2][rest - 1];
   			for (int cur = 2; cur < N; cur++) {
   				dp[cur][rest] = dp[cur - 1][rest - 1] + dp[cur + 1][rest - 1];
   			}
   			dp[N][rest] = dp[N - 1][rest - 1];
   		}
   		return dp[start][K];
   	}
   
   	public static void main(String[] args) {
   		System.out.println(ways1(5, 2, 4, 6));
   		System.out.println(ways2(5, 2, 4, 6));
   		System.out.println(ways3(5, 2, 4, 6));
   	}
   
   }
   
   ```

   

2. **==获胜者的分数==**

   ![image-20220719133316009](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207191333110.png)

   ![image-20220719133820829](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207191338941.png)

   ![image-20220719134536983](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207191345144.png)

   ![image-20220719134859938](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207191349071.png)

   ![image-20220719224602637](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207192246751.png)

   ![image-20220719224641582](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207192246730.png)

   ```C
   package class18;
   
   public class Code02_CardsInLine {
   
   	// 根据规则，返回获胜者的分数
   	public static int win1(int[] arr) {
   		if (arr == null || arr.length == 0) {
   			return 0;
   		}
   		int first = f1(arr, 0, arr.length - 1);
   		int second = g1(arr, 0, arr.length - 1);
   		return Math.max(first, second);
   	}
   
   	// arr[L..R]，先手获得的最好分数返回
   	public static int f1(int[] arr, int L, int R) {
   		if (L == R) {
   			return arr[L];
   		}
   		int p1 = arr[L] + g1(arr, L + 1, R);
   		int p2 = arr[R] + g1(arr, L, R - 1);
   		return Math.max(p1, p2);
   	}
   
   	// // arr[L..R]，后手获得的最好分数返回
   	public static int g1(int[] arr, int L, int R) {
   		if (L == R) {
   			return 0;
   		}
   		int p1 = f1(arr, L + 1, R); // 对手拿走了L位置的数
   		int p2 = f1(arr, L, R - 1); // 对手拿走了R位置的数
           // 因为是零和博弈，对手一定会给你最差的分数，这个返回不是自己
           // 决定的，是对手做决定
           // 对手会把两个可能的最优中的最小扔给你
           // p1有一个最优，p2也有一个最优，但对手会把最小的最优扔给你
   		return Math.min(p1, p2);
   	}
   
   	public static int win2(int[] arr) {
   		if (arr == null || arr.length == 0) {
   			return 0;
   		}
   		int N = arr.length;
   		int[][] fmap = new int[N][N];
   		int[][] gmap = new int[N][N];
   		for (int i = 0; i < N; i++) {
   			for (int j = 0; j < N; j++) {
   				fmap[i][j] = -1;
   				gmap[i][j] = -1;
   			}
   		}
   		int first = f2(arr, 0, arr.length - 1, fmap, gmap);
   		int second = g2(arr, 0, arr.length - 1, fmap, gmap);
   		return Math.max(first, second);
   	}
   
   	// arr[L..R]，先手获得的最好分数返回
   	public static int f2(int[] arr, int L, int R, int[][] fmap, int[][] gmap) {
   		if (fmap[L][R] != -1) {
   			return fmap[L][R];
   		}
   		int ans = 0;
   		if (L == R) {
   			ans = arr[L];
   		} else {
   			int p1 = arr[L] + g2(arr, L + 1, R, fmap, gmap);
   			int p2 = arr[R] + g2(arr, L, R - 1, fmap, gmap);
   			ans = Math.max(p1, p2);
   		}
   		fmap[L][R] = ans;
   		return ans;
   	}
   
   	// // arr[L..R]，后手获得的最好分数返回
   	public static int g2(int[] arr, int L, int R, int[][] fmap, int[][] gmap) {
   		if (gmap[L][R] != -1) {
   			return gmap[L][R];
   		}
   		int ans = 0;
   		if (L != R) {
   			int p1 = f2(arr, L + 1, R, fmap, gmap); // 对手拿走了L位置的数
   			int p2 = f2(arr, L, R - 1, fmap, gmap); // 对手拿走了R位置的数
   			ans = Math.min(p1, p2);
   		}
   		gmap[L][R] = ans;
   		return ans;
   	}
   
   	public static int win3(int[] arr) {
   		if (arr == null || arr.length == 0) {
   			return 0;
   		}
   		int N = arr.length;
   		int[][] fmap = new int[N][N];
   		int[][] gmap = new int[N][N];
   		for (int i = 0; i < N; i++) {
   			fmap[i][i] = arr[i];
   		}
   		for (int startCol = 1; startCol < N; startCol++) {
   			int L = 0;
   			int R = startCol;
   			while (R < N) {
   				fmap[L][R] = Math.max(arr[L] + gmap[L + 1][R], arr[R] + gmap[L][R - 1]);
   				gmap[L][R] = Math.min(fmap[L + 1][R], fmap[L][R - 1]);
   				L++;
   				R++;
   			}
   		}
   		return Math.max(fmap[0][N - 1], gmap[0][N - 1]);
   	}
   
   	public static void main(String[] args) {
   		int[] arr = { 5, 7, 4, 5, 8, 1, 6, 0, 3, 4, 6, 1, 7 };
   		System.out.println(win1(arr));
   		System.out.println(win2(arr));
   		System.out.println(win3(arr));
   
   	}
   
   }
   ```

   









































