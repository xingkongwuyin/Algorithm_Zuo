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
   



# Lesson 06

0. ==前置知识 堆==

   > * 0的父节点是自己
   >
   > * 大根堆：在一颗完全二叉树中，任何一颗子树的最大值等于其头节点的值
   > * 小根堆 ：在一颗完全二叉树中，任何一颗子树的最小值等于其头节点的值
   > * 堆也叫优先级队列
   >
   > ![image-20220629073429317](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202206292109802.png)

1. ==堆结构的实现==

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



2. ==堆排序==

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



3. ==已知一个几乎有序的数组。几乎有序是指，如果把数组排好顺序的话，每个元素移动的距离一定不超过k，k相对于数组长度来说是比较小的。请选择一个合适的排序策略，对这个数组进行排序==

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

1. ==给定很多线段，每个线段都有两个数[start, end]，表示线段开始位置和结束位置，左右都是闭区间。返回线段最多重合区域中，包含了几条线段==

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




2. ==加强堆==

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

   ![image-20220704200734060](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207042007145.png)

3. ==**证明已知某一个二叉树节点的先序遍历和后序遍历，则A和B的交集是且尽是x的所有的祖先节点**==

   ![image-20220704201141239](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207042011334.png)

   ![image-20220704202729653](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207042027786.png)

   ![image-20220704212744287](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207042225746.png)

   > * 所有的结点分成，第一类x的祖先结点，第二类x结点自身，第三类x的孩子结点，第四类，x的作为左树的右兄弟结点，第五类，x作为右树的左兄弟结点们
   > * 先序遍历中，X结点的前边是它的祖先结点(可以用反证法去证)和它的作为右树的左兄弟的结点（可以用头 左 右去推 ），后边是它的孩子结点和作为左数的右兄弟结点
   > * 后续遍历中，x结点的前面是，它的孩子结点（可以用反证法去证）和作为右树的左兄弟结点；x结点的后边是它的祖先结点和它的作为左树的右兄弟结点（可以用左 右  头去证）
   > * 所以A和B的交集只有祖先结点



  



































