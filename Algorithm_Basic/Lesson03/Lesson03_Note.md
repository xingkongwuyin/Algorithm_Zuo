1. > 单项链表
   >
   > ```java
   > // 单向链表结点结构（可以实现成泛型）
   > pubic class Node{
   >     public int value;
   >     pubic Node next;
   >     
   >     public Node(int data){
   >         value = data;
   >     }
   > }
   > 
   > 
   > ```

2. > 双向链表
   >
   > ```java
   > // 双向链表的结点结构
   > public class DoubleNode{
   >     public int value;
   >     public DoubleNode last;
   >     public DoubleNode nest;
   >     
   >     public DoubleNode(int data){
   >         value = data;
   >     }
   > }
   > ```

3. > 单向链表和双向链表最简单的练习
   >
   > ```java
   > //   链表相关的问题几乎都是coding问题
   > //   1）单链表和双链表如何反转
   > //   2）把给定值去除
   > //   这里是熟悉的结构。链表还有哪些常见的联系题，后续还有专门的一节来系统学习
   > ```
   >
   > * 1）单链表的旋转（利用for/while的思想)
   >
   > ![image-20220624105910022](https://dawn1314.oss-cn-beijing.aliyuncs.com/202206241059055.png)
   >
   > > + 首先明确，大问题是指什么，大问题是指，翻转整个链表，也就是将链表中的每个结点翻转过来，那么小问题就是将链表中的每个结点进行翻转，这就是把大问题转换成了小问题，解决完小问题就等同于大问题解决了。这里值得注意的是，一个小问题的解决需要上一个小问题搭建环境，最主要的就是解决完小问题后，要来到下一个小问题，还有的是，需要用到上一步的结论
   > > + 解决单链表
   > >   * 方法：将每个只头指针指向的结点的前后结点和其指针，也就是pre和next，给找出来，每次将头节点翻转后，pre和head就往前移（这一步的目的是为下一步问题搭建环境，即来到下一个问题）
   > >   * 步骤：将pre和next指向null（主要是将pre指向null，可以想象null是在head结点之后，而next的作用主要是为翻转结点前找到结点的下一个结点）——> 将head指向的结点翻转（小问题的核心就是这个）——> 将pre和head指针往前移(来到下一个结点) 
   > >
   > > * code
   > >
   > >   ```java
   > >   // 翻转单向链表 
   > >   public static Node reverseLinkedList(Node head) {
   > >       	Node pre = null;
   > >       	Node next = null;
   > >       
   > >       	while(head != null) {
   > >       		next = head.next;
   > >       		head.next = pre;
   > >       		pre = head;
   > >       		head = next;
   > >       	}
   > >       	return pre;
   > >       }
   > >   // 翻转双向链表
   > >       public static doubleNode reversedoubleList(doubleNode head) {
   > >       	doubleNode next = null;
   > >       	doubleNode pre = null;
   > >       	while(head != null) {
   > >       		next = head.next;
   > >       		head.last = next;
   > >       		head.next = pre;
   > >       		pre = head;
   > >       		head = next;
   > >       	}
   > >       	return pre;
   > >       }
   > >   ```
   > >
   >
   > * 2）给定单链表，删除指定数
   >
   >   ![image-20220624194736194](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202206241947239.png)
   >
   > > + analysis：首先判断链表非空，非空返回null。用pre表示从头节点到pre符合节点，cur表示去找符合要求的节点，cur没找到，就把cur所指的节点删掉，即让pre的next指向cur的next，如果找到就让pre来到cur的位置，最后返回head
   > >
   > >   ```java
   > >   public static class Node {
   > >   		public int value;
   > >   		public Node next;
   > >       
   > >   		public Node(int data) {
   > >   			this.value = data;
   > >   		}
   > >   	}
   > >       
   > >   	// head = removeValue(head, 2);
   > >   	public static Node removeValue(Node head, int num) {
   > >   		// head来到第一个不需要删的位置
   > >   		while (head != null) {
   > >   			if (head.value != num) {
   > >   				break;
   > >   			}
   > >   			head = head.next;
   > >   		}
   > >   		// 1 ) head == null
   > >   		// 2 ) head != null
   > >   		Node pre = head;
   > >   		Node cur = head;
   > >   		while (cur != null) {
   > >   			if (cur.value == num) {
   > >   				pre.next = cur.next;
   > >   			} else {
   > >   				pre = cur;
   > >   			}
   > >   			cur = cur.next;
   > >   		}
   > >   		return head;
   > >   	}
   > >   ```
   > >
   > >   
   >
   > 
   
4. >  ==thought==
   >
   > 1. 对于链表的题，每次操作，是针对单个节点进行操作的，也就是每次循环是针对单个节点进行操作，那么对每个节点进行操作之前，要把这个结点的前后节点的指针要展开，即要找到他前后节点的指针pre和next，然后再对这个节点进行操作，一定要记住，链表的操作，从局部来说是对单个结点进行操作，找前后指针，一是为了对结点操作时，用的到，二是为下一步循环搭建环境，
   > 2. 对于while循环
   >    + 每次循环完不单单要完成局部的功能，还有为下一步循环操作搭建环境。这里的局部功能是指，整体实现某个大功能，分成局部有限个小功能去实现，也就是操作也就是把大问题分解成小问题去做。这和递归很像，递归是从大问题依次分解成规模较小的问题，从大到小，而whle循环是，要解决一个大问题，要从小到大去做，也就是一上来把问题分解成有限个同等规模的小问题，依次把这些小问题去解决，这些小问题不是彼此独立的，可能解决上一个小问题的之后，要用到其结论，或者为下一步解决的小问题搭建环境。所以解决一个问题，不管要完成其局部功能，还要为下一步的问题的解决提供一定的帮助，但有的就不用，具体得看题目，或者用for还是while，for有时就不用为下一步搭建环境，因为i++会自动搭建环境，也就是说搭建环境这个for循环给做了，总体来说，还是得为下一步搭建环境，也就说得达到下一个问题
   >
   > ==mindmap==
   >
   > ![image-20220624104457156](https://dawn1314.oss-cn-beijing.aliyuncs.com/202206241044213.png)

5. > ```java
   > // 栈和队列
   > // 逻辑概念
   > // 栈：数据先进后出，犹如弹匣
   > // 队列：数据先进先出，好似排队
   > ```
   >
   > ```java
   > // 栈和队列的实际实现
   > // 双向链表的实现
   > // 数组实现
   > ```
   >
   > ```java
   > // 栈和队列的常见面试题
   > // 实现一个特殊的栈，在基本功能的基础上，再实现返回栈中最小元素的功能
   > // 1) pop、push、getMin、操作的时间复杂度都是O(1).
   > // 2) 设计的栈类型可以使现有的栈结构
   > ```
   >
   > ```java
   > // 栈和队列的常见面试题
   > // 1) 如何用栈结构实现队列结构
   > // 2) 如何用队列结构实现栈结构
   > 
   > // 这两种结构的应用实在是太多了，在刷题时会我们会大量见到
   > ```
   >
   > ```java
   > //递归？ 这东西是什么？
   > // * 怎么从思想上理解递归
   > // * 怎么从实际的角度出发理解递归
   > 
   > ```
   >
   > ```java
   > // 例子
   > // 求数组arr[L……R]中的最大值，怎么用递归方法实现
   > // 1) 将[L R]范围分成左右两半。左[L mid] 右[mid R]
   > // 2) 左部分求最大值，右部分求最大值
   > // 3) [L R]范围上的最大值，是max{左部分的最大值，右部分最大值}
   > // 4) 注意2)是个递归过程，当范围上只有一个数，就可以不用递归了
   > ```
   >
   > 

6. > 子问题的规模必须是一致的，比如，T(N)  = T(N / 3) + T(N / 4)，子问题的规模不一致，这类递归就不能用master公式来估计时间复杂度，也就是子问题规模一致的才可以用master公式 
   >
   > ![](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202206252004298.png)

7. > ==hashmap==
   >
   > 1. <DataType, DataType>,DataType如果是原生内置的数据类型，例如String，Integer，会把String类型的数据放进hashMap中；如果是Node，自定义数据类型，那么在hashmap中存放的是其地址
   >
   > 2. hashmap的增删查改的时间复杂度都是O(1)
   >
   > 3. hashset可以看成只有key，即形式是<DataType>
   >
   >    

8. > ```java
   > int a = 1000;
   > int b = 1000;
   > System.out.println(a == b);        // true  按值传递，比对的是值
   > 
   > Integer aa = 1000;
   > Integer bb = 1000;
   > System.out.println(a == b);        // false  按址传递，比对的是地址
   > System.out.println(a.equals(b));   // 用equals方法比对的是值    
   > ```
