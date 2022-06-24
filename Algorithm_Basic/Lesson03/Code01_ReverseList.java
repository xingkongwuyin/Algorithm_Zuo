package lesson03;
import java.util.Arrays;
import java.util.List;

public class Code01_ReverseList {

	// 单向链表
    public class Node{
    	public int value;
    	public Node next;
    	
    	public Node(int data) {
    		value = data;
    	}
    }
    
    // 双向链表
    public class doubleNode{
    	public int value;
    	public doubleNode last;
    	public doubleNode next;
    	
    	public  doubleNode(int data){
    		value = data;
    	}
    }
    
    // 反转单向链表
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
    
    // 反转双向链表
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
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
