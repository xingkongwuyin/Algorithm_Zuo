[TOC]

# **Basic_Zuo**

## **Code01 SelectionSort**

### **Relevant Knowledge**

### **Question**

* **SelectionSort**

### **Illustration**

* **![选择排序](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207291113738.gif)**

### **Thinking**

* **每次从[i   N-1]选出最小的元素，与下标为i的元素进行交换**
* **i到N - 2就可以了，因为经过前面的排序，最后一个元素不用排**

### **Code**

```java
public class Code01_SelectionSort {
    public static void selectionSort(int[] arr){
        if(arr == null || arr.length < 1){
            return;
        }
        int N = arr.length;
        for(int i = 0; i <= N - 2; i++){
            int minIndex = i;
            for(int j = i + 1; j <= N - 1; j++){
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
```



## **Code02 BubbleSort**

### **Relevant Knowledge**

### **Question**

* **Bubble sort**

### **Illustration**

* **![冒泡排序](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207291118517.gif)**

### **Thinking**

* **一共要冒泡(N - 1)次，最后一个元素不用冒泡**

### **Code**

```java
public class Code02_BubbleSort {
    public static void bubbleSort(int[] arr){
        if(arr ==  null || arr.length < 2){
            return;
        }
        int N = arr.length;
        // 总共要冒(N - 1)次
        for(int i = 0; i <= N - 2; i++){
            int flag = 0;
            // 每次的冒泡的尾部是(N - 1 - i)
            // 以后判断条件尽量写'<=或者>=',因为
            // 这样可以j的结束条件比较好判断
            for(int j = 0; j <= N - 2 - i; j++){
                if(arr[j] > arr[j + 1]){
                    swap(arr, j , j + 1);
                    flag = 1;
                }
            }
            if(flag == 0){
                return;
            }
        }
    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
```



## **Code03 InsertSort**

### **Relevant Knowledge**

### **Question**

* **Insert sort**

### **Illustration**

* **![插入排序](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207291127372.gif)**

### **Thinking**

* **每次拿i位置的元素，先与（i- 1）位置的元素作比较，如果i位置的元素更小，就不用插，否则插入到i位置以前的元素中。每次插完，保持有序。**

### **Code**

```java
public class Code03_InsertSort {
    public static void insertionSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        int N = arr.length;
        for(int i = 1; i < N; i++){
            if(arr[i] > arr[i - 1]){
                continue;
            }else {
                for (int pre = i; (pre - 1 >= 0) && arr[pre] < arr[pre - 1]; pre--) {
                    swap(arr, pre, pre - 1);
                }
            }
        }
    }

    // 交换元素
    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

```



## **Code04 Binary Search** 

### **Relevant Knowledge**

### **Question**

* **使用二分查找，查询某个升序数组是否存在某个元素**

### **Illustration**

* **![image-20220729194417074](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207291944248.png)**

### **Thinking**

* **先定范围，再二分，后查找。**
* **二分的体现是`mid = (mid + R) / 2`,是用mid去找**
* **查找怎么查找，找到了怎么样，找不到，下一步又该如何找，去哪个范围找**

### **Code**

```java
public class Code04_BSExist {
    public static boolean bSExist(int[] arr, int n){
        if(arr == null || arr.length == 0){
            return false;
        }
        int L = 0;
        int R = arr.length - 1;
        // 在[L R]里面找，包括L和R位置的数
        while(L <= R){
            int mid = L + ((R - L) >> 1);
            if(arr[mid] == n){
                return true;
            }else if(arr[mid] < n){
                L = mid + 1;
            }else{
                R = mid - 1;
            }
        }
        // 能够出来，就代表没有找到
        return false;
    }
 }
```



## **Code05 nearest Left Index And Rightest Index**

### **Relevant Knowledge**

### **Question**

* **有序数组中找到>=num最左的位置，和>=num最右的位置**

### **Illustration**

* **![image-20220729200144978](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207292001140.png)**

### **Thinking**

* **以找到`>= value`最左的位置为例，但第一次找到`>= value`的位置后，紧接着再去该位置的左边去找，直至`L > R`**

### **Code**

```java
public class Code05_BSNearLeftAndRight {
    // 在arr上找到>= value最左的位置
    public static int bSNearLeft(int[] arr, int value) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int index = -1;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] >= value) {
                index = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return index;
    }
    //  在arr上找到 <= value最右的位置
    public static int bSNearRight(int[] arr, int value) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int index = -1;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] <= value) {
                index = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return index;
    }
```



## **Code06 Get Local Less Index**

### **Relevant Knowledge**

### **Question**

* **arr[0] < arr[1]，0位置是局部最小；**
  **arr[N-1] < arr[N-2]，N-1位置是局部最小；**
  **arr[i-1] > arr[i] < arr[i+1]，i位置是局部最小；**
  **给定一个数组arr，已知任何两个相邻的数都不相等，找到随便一个局部最小位置返回**

### **Illustration**

* **![image-20220619091420121](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207292004107.png)**

### **Thinking**

* **1)  数组长度为1，看arr[0]是否符合条件**

  **2）数组长度为2，看arr[0] 和arr[1]哪个符合**

  **3）数组长度长度为3，看arr[0]和arr[1]哪个符合**

  **4）数组长度大于等于3，找到局部最小值。到这一步，就剩下头部和尾部均不是局部最小值的          数组**

### **Code**

```java
public class Code06_BSLocalMinIndex {
    //数组arr的元素各不相等Index
    public static int BSLocalMin(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
       // 长度为1的情况
        if (arr.length == 1) {
            return 0;
        }
       // 长度为2的情况
        if (arr.length == 2) {
            if (arr[0] > arr[1]) {
                return 1;
            } else {
                return 0;
            }
        }
        // 长度为大于2的情况，这里就得用多个if，就不能用if……else
        if (arr[1] > arr[0]) {
            return 0;
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }
        // 长度大于2， 且最左边和最右边的元素都比相临值大
        int L = 1;
        int index = -1;
        int R = arr.length - 2;
        while (L <= R) {
            int mid = L + ((R - L) >> 1);
            if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                index = mid;
                // 一定加个break，不然找到index后，l和r就不会被改变，就会陷入死循环
                break;
            }

            if (arr[mid] > arr[mid - 1]) {
                R = mid - 1;
            } else if (arr[mid] > arr[mid + 1]) {
                L = mid + 1;
            }
        }
        return index;
    }
```



## **Code07 EvenTImeOddTimes**

### **Relevant Knowledge**

* **异或**

  ```java
  // 相同为0，相异为1
  // 可以看成无进位相加
  // 0 ^ N = N   N ^ N = 0
  // 满足交换律和结合律，且同时满足交换律和结合律
  
  // 交换律
  a ^ b = b ^ a;
  // 结合律
  (a ^ b) ^ c = a ^ (b ^ c);
  // 同时
  (a ^ b) ^ c = (a ^ c) ^ b
  ```

* **交换两个不相等的数，不用第三个**

  ```java
  a = a ^ b;
  b = a ^ b;
  a = a ^ b; 
  ```

  **![image-20220609204101268](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207292042924.png)**

  **![image-20220729210221198](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207292102261.png)**

  **![image-20220729210242805](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207292102842.png)**

### **Question**

1. **一个数组中有一个数出现了奇数次，其他数都出现了偶数次，怎么找到并打印这个数**

2. **一个数组中有两种数出现了奇数次，其他数出现了偶数次，怎么找到并打印这两种数**
3. **输出一个数中二进制位中1的个数**

### **Illustration**

### **Thinking**

### **Code**

```java
public class Code01_EvenTImeOddTimes {
    // arr中，只有一种数，出现奇数次
    public static int printOddTimesNum1(int[] arr){
        int eor = 0;
        for(int cur : arr){
            eor ^= cur;
        }
        return eor;
    }

    // arr中，有两种数出现奇数次
    public static int[] printOddTimesNums2(int[] arr){
        int eor = 0;
        for(int cur : arr){
            eor ^= cur;
        }

        int onlyOne = 0;
        // 找到eor二进制序列最右侧等于1位
        int num = eor & (~eor + 1);
        for(int cur : arr){
            if((cur & eor) != 0){
                onlyOne ^= cur;
            }
        }
        return new int[]{onlyOne, eor ^ onlyOne};
    }
    	// 二进制位中1的个数
       public static int bit1Count(int num){
        int count = 0;
        while(num != 0){
            count++;
            num &= (num - 1);
        }
        return count;
    }
}
```



## **Code08 KM**

### **Relevant Knowledge**

### **Question**

1. **一个数组中有一种数出现K次，其他数都出现了M次， M > k >= 1,找到出现了k次的数，要求额外空间复杂度O(1)**

2. **一个数组中，有n种数，n - 1种数出现了M次，剩下一种数出现的次数不确定，但肯定大于等于1，且小于M，求 如果剩下的那个数出现的次数等于K次，则找出这个数，如果不是则返回找不到**

### **Illustration**

### **Thinking**

* **因为每个数可以看成32为二进制，所以将每个数的32个二进制位求出来，创建一个数组help，来盛放二进制序列，分别加进数组中，然后模M，等于0，则说明那个数在该二进制位为0，否则为1，因为一个数出现了M次，那么这某位二进制为1，剩下的6个相同的数也得为1，所以得是M的倍数。**
* **建立长度为32的数组arr ——》循环求出每个数的2进制位，同时加到数组arr中 ——》对数组的每个元素取模M，如果等于0，那么要求的数在该位为1，否则为0**

### **Code**

```java
public class Code03_KM {
    public static int  KM(int[] arr, int K, int M){
        int[] help = new int[32];
        for(int cur : arr){
            for(int i = 0; i <= 31; i++){
                // 将每元素的二进制位分别加到位图
                 help[i] += ((cur >> i) & 1);
               // 这样写，不仅仅会把最后的二进制
               // 位显示出来，而且会把其他的二进制
               // 会显示出来，上面那种处理方式，仅仅
               // 会把最后一位显示出来，其他位全部置零
               // help[i] += ((cur >> i) | 0);
            }
        }
        int ans = 0;
        for(int i = 0; i <= 31; i++){
            help[i] %= M;
            if(help[i] != 0){
                // 将某位置1
                ans |= (1 << i);
                // 将某位置0
                // ans &= ~(1 << i);
            }
        }
        return ans;
    }

    // 这个方法不能判断含有K个Integer_MAX的数组
    public static int isKM(int[] arr, int K, int M){
        int[] help = new int[32];
        for(int cur : arr){
            for(int i = 0; i <= 31; i++){
                // 将每元素的二进制位分别加到位图
                help[i] += ((cur >> i) & 1);
                // 这样写，不仅仅会把最后的二进制
                // 位显示出来，而且会把其他的二进制
                // 会显示出来，上面那种处理方式，仅仅
                // 会把最后一位显示出来，其他位全部置零
                // help[i] += ((cur >> i) | 0);
            }
        }
        int ans = 0;
        for(int i = 0; i <= 31; i++){
            if(help[i] % M == 0){
                continue;
            }else if(help[i] % M == K){
                ans |= (1 << i);
            }else {
                return Integer.MAX_VALUE;
            }
        }
        int count = 0;
        if(0 == ans){
            for(int cur : arr){
                if(cur == 0){
                    count++;
                }
            }
        }
        if(count == K){
            return ans;
        }else{
            return Integer.MAX_VALUE;
        }
    }
}
```



## **Code09 Reverse Linked List And Double Linked List**

### **Relevant Knowledge**

1. **while循环**

   ```java
   while(判断条件)
   {
       循环体
   }
   // 1) 一般在()，放置每次循环的成立的条件，那么最后能出这个循环，肯定是条件不成立
   // 2) 在循环体中，既要进行本次循环的一些操作，最后还要进入下次循环，包含两个方面
   //    而for循环进入下次循环是在'()'进行
   ```

2. **Master公式**

   **子问题的规模必须是一致的，比如，T(N)  = T(N / 3) + T(N / 4)，子问题的规模不一致，这类递归就不能用master公式来估计时间复杂度，也就是子问题规模一致的才可以用master公式** 

   **![](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207301352519.png)**

3. **循环和递归的区别**

   **每次循环完不单单要完成局部的功能，还有为下一步循环操作搭建环境。这里的局部功能是指，整体实现某个大功能，分成局部有限个小功能去实现，也就是操作也就是把大问题分解成小问题去做。这和递归很像，递归是从大问题依次分解成规模较小的问题，从大到小，而whle循环是，要解决一个大问题，要从小到大去做，也就是一上来把问题分解成有限个同等规模的小问题，依次把这些小问题去解决，这些小问题不是彼此独立的，可能解决上一个小问题的之后，要用到其结论，或者为下一步解决的小问题搭建环境。所以解决一个问题，不管要完成其局部功能，还要为下一步的问题的解决提供一定的帮助，但有的就不用，具体得看题目，或者用for还是while，for有时就不用为下一步搭建环境，因为i++会自动搭建环境，也就是说搭建环境这个for循环给做了，总体来说，还是得为下一步搭建环境，也就说得达到下一个问题**

   **![image-20220624104457156](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207301354922.png)**

4. **HashMap**

   **1）<DataType, DataType>,DataType如果是原生内置的数据类型，例如String，Integer，会把String类型的数据放进hashMap中；如果是Node，自定义数据类型，那么在hashmap中存放的是其地址**

   **2）ashmap的增删查改的时间复杂度都是O(1)**

   **3）hashset可以看成只有key，即形式是< DataType >**

5. **按值传递和按址传递**

   ```java
   int a = 1000;
   int b = 1000;
   System.out.println(a == b);        // true  按值传递，比对的是值
   
   Integer aa = 1000;
   Integer bb = 1000;
   System.out.println(a == b);        // false  按址传递，比对的是地址
   System.out.println(a.equals(b));   // 用equals方法比对的是值    
   ```

### **Question**

* **反转单向链表和双向链表**

### **Illustration**

* **![image-20220624105910022](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207301346741.png)**

### **Thinking**

* **解决链表的题，一般需要三个指针：pre、cur和next**

  **pre：用来记录当前结点的前一个结点位置**

  **cur：当前结点的位置**

  **next：当前结点下一个位置**

### **Code**

```java
public class Code01_ReverseList {
    public static class Node{
        public int value;
        public Node next;

        public Node(int value){
            this.value = value;
        }
    }

    public static class DoubleNode{
        public int value;
        public DoubleNode next;
        public DoubleNode pre;

        public DoubleNode(int value){
            this.value = value;
        }
    }
    // 反转单向链表
    public static Node reverseLinkedList(Node head){
        if(head == null){
            return null;
        }
        Node pre = null;
        Node next = null;
        // head != null 是每次循环的判断条件
        while(head != null){
            next = head.next;
            head.next = pre;
        // 来到下一次循环
            pre = head;
            head = next;
        }
        return pre;
    }
    // 反转双向链表
    public static DoubleNode reverseDoubleLinkedList(DoubleNode head){
        if(head == null){
            return null;
        }
        DoubleNode pre = null;
        DoubleNode next = null;
        while(head != null){
            next = head.next;
            head.next = pre;
            head.pre = next;

            pre = head;
            head = next;
        }
        return pre;
    }
}
```



## **Code10 Remove Given Node**

### **Relevant Knowledge**

### **Question**

* **在链表中删除指定值的所有节点**

### **Illustration**

* **![image-20220624194736194](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207301401592.png)**

### **Thinking**

1. **写代码，总有很多边界条件，对于边界条件的处理，尽量能够先判断处理掉，就判断处理掉，**

   **不要和其他的边界条件放在一起。**

   **例如: (1)处，可以不写，可以下面的一起进行判断head是否为空，但下面的情况就多了一种可能性，这个容易混淆。一种情况有很多可能性，尽量把多种可能性拆成互斥，然后分别讨论可能性。**

2. **代码中：**

   **pre：当前不含有value值的结点的链表的尾结点**

   **cur：探测结点，判断结点是否含有value值。如果含有，就让pre结点的next指针指向cur结点的next指针指向的结点；如果不含有就让pre指向cur指向的结点**

### **Code**

```java
public class Code02_DeleteGivenValue {
    public static class Node{
        public int value;
        public Node next;

        public Node(int value){
            this.value = value;
        }
    }

    public static Node removeGivenValue(Node head, int value){
        if(head == null){
            return null;
        }
        while(head != null){
            if(head.value != value){
                break;
            }else{
                head = head.next;
            }
        }
        
        if(head == null){   // (1)
            return null;
        }
        // 向后移动，检测结点
        Node cur = head.next;
        // 记录目前不带有value值的结点的链表最后一个结点
        // 尾结点
        Node pre = head;
        while(cur != null){
            if(cur.value == value){
                pre.next = cur.next;
            }else{
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}
```



## **Code11 Double Linked List Implement Stack And     Queue** 

### **Relevant Knowledge**

### **Question**

* **双链表实现栈和队列**

### **Illustration**

* 

### **Thinking**

* 

### **Code**

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



## **Code12 Ring Array implement Stack And Queue**

### **Relevant Knowledge**

### **Question**

* **环形数组实现队列**
* **环形数组实现栈（还没有实现）**

### **Illustration**

* 

### **Thinking**

* **解决数组实现栈和队列浪费空间的问题**

### **Code**

```java
package lesson03;

public class Code03_RingArrayImplentStackAndQueue {
    public static class MyQueue{
        private int[] arr;
        private int pushi; // end 加入元素所要放的下标
        private int polli; // 所要弹出元素的下标
        private int size; // 目前所放元素的个数
        private final int limit;

        public MyQueue(int limit){
            this.limit = limit;
            pushi = 0;
            polli = 0;
            size = 0;
        }

        // push
        public void push(int value){
            if(size == limit){
                throw new RuntimeException("队列已满");
            }
            size++;
            arr[pushi] = value;
            pushi = nextIndex(pushi);
        }

        // pop
        public int pop(){
            if(size == 0){
                throw new RuntimeException("队列已空");
            }
            size--;
            int ans = arr[polli];
            polli = nextIndex(polli);
            return ans;
        }

        // isEmpty
        public boolean isEmpty(){
            return size == 0;
        }

        // pushi和polli下一个位置
        private int nextIndex(int i){
            return i < limit - 1 ? ++i : 0;
        }
    }
}

```





## **Code12 Implement stack which can get Min** 

### **Relevant Knowledge**

### **Question**

* **实现一个栈，可以查询当前栈中的最小值**

### **Illustration**

* 

### **Thinking**

* **首先建立两个栈：**

  **stackMin：每一个元素代表，自这个该元素往下，所有元素中的最小的元素**

  **stackData：数据栈**

* **然后：**

  **push：如果要push的元素小于stackMin的栈顶元素，将新元素push到数据栈的同时，也push**

  ​            **到stackMin的栈，否则将stackMin栈的栈顶元素再push一遍**

  **pop：同时pop stackData栈和stackMin栈**

  **getMin：peek stackMin栈，得出的就是当前stackData栈的最小值**

### **Code**

```java
package lesson03;

import java.util.Stack;

public class Code04_GetMinStack {

    public static class MyStack{
        private Stack<Integer> StackData ;
        // StackMin栈：每一个元素，代表StackData
        // 自该元素往下，包括该元素，的最小值
        private Stack<Integer> StackMin ;

        public MyStack(){
            this.StackData = new Stack<>();
            this.StackMin = new Stack<>();
        }

        // push
        public void push(int newNum){
            if(StackMin.isEmpty()){
                StackMin.push(newNum);
            }else if(newNum < StackMin.peek()){
                StackMin.push(newNum);
            }else{
                StackMin.push(StackMin.peek());
            }
            StackData.push(newNum);
        }

        // pop
        public int pop(){
            if(StackData.isEmpty()){
                throw new RuntimeException("栈已经空");
            }
            int value = StackData.pop();
            StackMin.pop();
            return StackData.pop();
        }

        // getMin
        public int getMin(){
            return StackMin.peek();
        }

        // isEmpty
        public boolean isEmpty(){
            return StackData.isEmpty();
        }
    }
}

```



## **Code13 Two Stacks implement queue**

### **Relevant Knowledge**

### **Question**

* **双栈实现队列**

### **Illustration**

* 

### **Thinking**

* **首先准备两个栈：**

  **stackPush：执行push操作时，将元素压入该栈中**

  **satackPop：执行pop操作，把元素从该栈弹出**

* **然后：**

  **每次push、pop和peek元素时，如果两站都不为空，首先都要将stackPush栈中的压入stackPop栈中**

### **Code**

```java
import java.util.Stack;

public class Code05_TwoStackImplementQueue {
    public static class TwoStackImplementQueue{
        public Stack<Integer> stackPush;
        public Stack<Integer> stackPop;

        public TwoStackImplementQueue(){
            stackPush = new Stack<>();
            stackPop = new Stack<>();
        }

        // 将push栈的元素压入pop栈
        public void pushToPop(){
            if(stackPop.empty()){
                while(!stackPush.empty()){
                    stackPop.push(stackPush.pop());
                }
            }
        }

        // push
        public void push(int num){
            stackPush.push(num);
            pushToPop();
        }

        // pop
        public int pop(){
            if(stackPop.empty() && stackPop.empty()){
               throw new RuntimeException("队列已空");
            }else {
                pushToPop();
                return stackPop.pop();
            }
        }

        // peek
        public int peek(){
            if(stackPop.empty() && stackPush.empty()){
                throw new RuntimeException("队列已空");
            }
            pushToPop();
            return stackPop.peek();
        }

        // isEmpty
        public boolean isEmpty(){
            return stackPop.empty() && stackPush.empty();
        }
    }
}
```



## **Code14 Two Queue Implement stack** 

### **Relevant Knowledge**

### **Question**

* **两个队列实现栈**

### **Illustration**

* **首先准备两个队列**

  **queue：执行push操作时，将元素压入该队列**

  **help：执行pop和peek操作时，留一个元素放在queue里，剩下的元素全部压入help队列**

* **pop：留一个元素放在queue里，剩下的元素全部压入help队列，然后将queue队列变成help队列**

  ​           **将help队列变成queue队列**

### **Thinking**

* 

### **Code**

```java
package lesson03;

import java.util.Queue;
import java.util.LinkedList;

public class Code06_TwoQueueImplementStack {
    public static class TwoQueueImplementStack<T> {
        public Queue<T> queue;
        public Queue<T> help;

        public TwoQueueImplementStack() {
            Queue<T> queue = new LinkedList<>();
            Queue<T> help = new LinkedList<>();
        }
        
        // push
        public void push(T num){
            queue.offer(num);
        }
        
        // pop
        public T poll(){
            if(queue.isEmpty()){
                throw new RuntimeException("栈已空");
            }
            while(queue.size() > 1){
                help.offer(queue.poll());
            }
            T ans = queue.poll();
            Queue<T> tmp = queue;
            queue = help;
            help = tmp;
            return ans;
        }
        
        // peek
        public T peek(){
            if(queue.isEmpty()){
                throw new RuntimeException("栈已空");
            }
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
        
        // isEmpty
        public boolean isEmpty(){
            return queue.isEmpty() && help.isEmpty(); 
        }
    }
}

```