package lesson11;

import java.util.LinkedList;
import java.util.Queue;

public class Code05_TreeMaxWidth {
	
	public static class Node{
		public int val;
		public Node left;
		public Node right;
		
		public Node(int data) {
			this.val = data;
		}
	}
	
	public static int maxWidthNoMap(Node head) {
		
		if(head == null) {
			return 0;
		}
		Queue<Node> queue = new  LinkedList<>();
		queue.add(head);
		Node curEnd = head;
		Node nextEnd = null;
		int max = 0;
		int curLevelNodes = 0; // nodes in current layers
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			if(cur.left != null) {
				queue.add(cur.left);
				nextEnd = cur.left;
			}
			if(cur.right != null) {
				queue.add(cur.right);
				nextEnd = cur.right;
			}
			curLevelNodes++;
			if(cur == curEnd) {
				max = Math.max(max, curLevelNodes);
				curEnd = nextEnd;
				curLevelNodes = 0;
			}
		}
		return max;
	}
}



















