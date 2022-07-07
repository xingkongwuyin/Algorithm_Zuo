package lesson13;

public class Code02_MaxSubSBThead {
	
	public static class Node{
		public int value;
		public Node left;
		public Node right;
		
		public Node(int v) {
			value = v;
		}
	}
	
	public static Node maxSubSBThead(Node head) {
		if(head == null) {
			return null;
		}
		return process(head).maxSubHead;
	}
	
	public static class Info{
		public Node maxSubHead;
		public int maxSubSize;
		public int max;
		public int min;
		
		public Info(Node s, int sub, int ma, int mi) {
			maxSubHead = s;
			maxSubSize = sub;
			max = ma;
			min = mi;
		}
	}
	
	public static Info process(Node x) {
		if(x == null) {
			return null;
		}
		Info leftInfo = process(x.left);
		Info rightInfo = process(x.right);
		int max = x.value;
		int min = x.value;
		Node maxSubHead = null;
		int maxSubSize = 0;
		if(leftInfo != null) {
			max = Math.max(leftInfo.max, max);
			min = Math.min(leftInfo.min, min);
			maxSubHead = leftInfo.maxSubHead;
			maxSubSize = leftInfo.maxSubSize;
		}
		if(rightInfo != null) {
			max = Math.max(rightInfo.max, max);
			min = Math.min(rightInfo.min, min);
			if(maxSubSize < rightInfo.maxSubSize) {
				maxSubSize = rightInfo.maxSubSize;
				maxSubHead = rightInfo.maxSubHead;
			}
		}
		
		boolean isLeftCBT = leftInfo == null ? true  : leftInfo.maxSubHead == x.left;
		boolean isRightCBT = rightInfo == null ? true  : rightInfo.maxSubHead == x.right;
		if(isLeftCBT && isRightCBT) {
			boolean left = leftInfo == null ? true : leftInfo.max < x.value;
			boolean right = leftInfo == null ? true : rightInfo.min > x.value;
			if(left && right) {
				maxSubSize = (leftInfo == null ? 0 :leftInfo.maxSubSize) + (rightInfo == null ? 0 : rightInfo.maxSubSize) + 1;
				maxSubHead = x;
			}
		}
		return new Info(maxSubHead, maxSubSize, max, min);
	}
}


























