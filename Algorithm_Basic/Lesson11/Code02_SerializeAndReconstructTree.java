package lesson11;

import java.util.Queue;
import java.util.LinkedList;

public class Code02_SerializeAndReconstructTree {
	
	public static class Node{
		public int value;
		public Node left;
		public Node right;
		
		public Node(int v) {
			value = v;
		}
	}
	
	// preSerial
	public static Queue<String> preSerial(Node head){
		Queue<String> ans = new LinkedList<>();
		
		// filling answer with the result of serializing
		// a binary with head Node
		pres(head, ans);
		return ans;
	}
	
	public static void pres(Node head, Queue<String> ans){
		
		if(head == null) {
			ans.add(null);
		}else{
			ans.add(String.valueOf(head.value));
			pres(head.left, ans);
			pres(head.right, ans);
		}
	}
	
	// build a binary Tree by preQueue
	public static Node bulidByPreQueue(Queue<String> prelist) {
		if(prelist == null || prelist.size() == 0) {
			return null;
		}else {
			return preb(prelist);
		}
	}
	
	public static Node preb(Queue<String> prelist) {
		
		String value = prelist.poll();
		if(value == null) {
			return null;
		}
		Node head = new Node(Integer.valueOf(value));
		head.left = preb(prelist);
		head.right = preb(prelist);
		return head;
	}
	
	// level serialize
	public static Queue<String> levelSerial(Node head) {

		Queue<String> ans = new LinkedList<>();
		if (head == null) {
			ans.add(null);
		} else {
			ans.add(String.valueOf(head.value));
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(head);
			// every node only serialize own children nodes.
			while (!queue.isEmpty()) {
				if (head.left == null) {
					ans.add(null);
				}else {
					queue.add(head.left);
					ans.add(String.valueOf(head.left.value));
				}
				if(head.right == null) {
					ans.add(null);
				}else {
					ans.add(String.valueOf(head.right.value));
					queue.add(head.right);
				}
			}

		}
		return ans;
	}
	
	// build binary Tree by level queue.
	public static Node bulidBTBylevelQueue(Queue<String> levelList) {
		
		if(levelList == null || levelList.size() == 0) {
			return null;
		}
		
		Node head = generateNode(levelList.poll());
		Queue<Node> queue = new LinkedList<Node>();
		if(head != null) {
			queue.add(head);
		}
		Node node = null;
		
		while(!queue.isEmpty()) {
			node = queue.poll();
			node.left = generateNode(levelList.poll());
			node.right = generateNode(levelList.poll());
			if(node.left !=null) {
				queue.add(node.left);
			}
			if(node.right != null) {
				queue.add(node.right);
			}
		}
		return head;
	}
	
	// generateNode with String.
	public static Node generateNode(String val) {
		if(val == null) {
			return null;
		}
		return new Node(Integer.valueOf(val));
	}
}

























