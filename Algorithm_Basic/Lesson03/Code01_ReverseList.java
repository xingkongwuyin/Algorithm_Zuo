package lesson03;
import java.util.ArrayList;
import java.util.List;

public class Code01_ReverseList {

	// 单向链表
    public static class Node{
    	public int value;
    	public Node next;
    	
    	public Node(int data) {
    		value = data;
    	}
    }
    public static class Node1{
		public int value;
		public Node next;

		public Node1(int data) {
			value = data;
		}
	}
    
     // 双向链表
    public static class doubleNode{
    	public int value;
    	public doubleNode last;
    	public doubleNode next;
    	
    	public  doubleNode(int data){
    		value = data;
    	}
    }
    
    // 利用指针反转单向链表
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
    
    
    // 利用指针反转双向链表
    public static doubleNode reverseDoubleList(doubleNode head) {
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
    

    // comparsion methods
    // 1. linkedList comparsion
    // 1.1 ues containner as linkedList comparsion
    public  static Node containnerReverseLinkedlist(Node head) {
    	if(head == null) {
    		return null;
    	}
    	ArrayList<Node> list = new ArrayList<>();
    	while(head != null) {
    		list.add(head);
    		head = head.next;
    	}
    	list.get(0).next = null;
    	int N = list.size();
    	for(int i = 1; i < N; i++) {
    		list.get(i).next = list.get(i - 1);
    	}
    	return list.get( N - 1);
    }
    
    // 1.2 generate random linked list
    public static Node generateRandomLinkedList(int len, int value) {
    	int size = (int)(Math.random() * (len + 1)); // [0 len]
    	if(0 == size) {
    		return null;
    	}
    	size--;
		Node head = new Node((int)(Math.random() * (value + 1)));
    	Node pre= head;
    	while(size != 0) {
    		Node cur = new Node((int)(Math.random() * (value + 1)));
    		pre.next = cur;  // if the method is static,  the feild called must be static!																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																			                                        
    		pre = cur;
    		size--;
    	}
    	return head;
    }
    
    // 1.3 get the linked list original order
    public static List<Integer> getlinkedListOriginalOrder(Node head){
    	List<Integer> ans = new ArrayList<>();
    	while(head != null) {
    		ans.add(head.value);
    		head = head.next; 
    	}
    	return ans;
    }
    
  // 1.4 check tha ans from pointer and the ans from list
    public static boolean checkLinkedListReverse(List<Integer> origin, Node head) {
    	for(int i = origin.size() - 1; i >= 0; i++) {
    		if(!origin.get(i).equals(head.value)) {
    			return false;
    		}
    	}
    	return true;
    }
    
    // 2. doubleList comparison
    // 2.1 use containner reverses double list
    public static doubleNode containnerReverseDoubleList(doubleNode head) {
    	if(head == null) {
    		return null;
    	}
    	ArrayList<doubleNode> list = new ArrayList<>();
    	while(head != null) {
    		list.add(head);
    		head = head.next;
    	}
    	list.get(0).next = null;
    	doubleNode pre = list.get(0);
    	int N = list.size();
    	for(int i = 1; i < N; i++) {
    		doubleNode cur = list.get(i);
    		cur.next = pre;
    		pre.last = cur;
    		cur.last = null;
    		
    		pre = cur;
    				
    	}
    	return list.get(N - 1);
    }
     
    // 2.2 generate random double list
    public static doubleNode generateRandomDoubleList(int len, int value) {
    	int size = (int)(Math.random() * (len + 1));
    	if(size == 0) {
    		return null;
    	}
    	doubleNode head = new doubleNode((int)(Math.random() * (value + 1)));
    	doubleNode pre = head;
    	while(size != 0)
    	{
    		doubleNode cur = new doubleNode((int)(Math.random() * (value + 1)));
    		pre.next = cur;
    		cur.last = pre;
    		pre = cur;
    		size--;
    	}
    	return head;
    }
    
    // 2.3 get double List original order
    public static List<Integer> getDoubleListoriginorder(doubleNode head){
    	List<Integer> ans = new ArrayList<>();
    	while(head != null) {
    		ans.add(head.value);
    		head = head.next;
    	}
    	return ans;
    }
    
    // 2.4 check the ans from pointer and the ans from list
    public static boolean checkdoubleListReverse(List<Integer>origin, doubleNode head) {
    	doubleNode end = null;
    	for(int i  = origin.size() - 1; i >= 0; i--) {
    		if(!origin.get(i).equals(head.value)) {
    			return false;
    		}
    		end = head;
    		head =head.next;
    	}
    	for(int i = 0; i < origin.size(); i++) {
    		if(!origin.get(i).equals(end.value)) {
    			return false;
    		}
    		end = end.last;
    	}
    	return true;
    }
    
    
    // test
    public static void main(String[] args) {
		int len = 50;
		int value = 100;
		int testTimes = 100000;
		System.out.println("test begin!");
		for(int i = 0; i < testTimes; i++) {
			Node node1 = generateRandomLinkedList(len, value);
			List<Integer> list1 = getlinkedListOriginalOrder(node1);
			node1 = reverseLinkedList(node1);
			if(!checkLinkedListReverse(list1, node1));
			System.out.println("Oops1!");
		}
		
		Node node2 = generateRandomLinkedList(len, value);
		List<Integer> list2 = getlinkedListOriginalOrder(node2);
		node2 = containnerReverseLinkedlist(node2);
		if(!checkLinkedListReverse(list2, node2));
		System.out.println("Oops2!");
		
		doubleNode node3 = generateRandomDoubleList( len, value);
		List<Integer> list3 = getDoubleListoriginorder(node3);
		node3 = reverseDoubleList(node3);
		if(!checkdoubleListReverse(list3, node3));
		System.out.println("Oops3!");
		
		doubleNode node4 = generateRandomDoubleList( len, value);
		List<Integer> list4 = getDoubleListoriginorder(node4);
		node4 = containnerReverseDoubleList(node4);
		if(!checkdoubleListReverse(list4, node4));
		System.out.println("Oops4!");
		
	}
					
	}




