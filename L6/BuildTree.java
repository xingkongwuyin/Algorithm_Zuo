package Lesson06;
import java.util.HashMap;

public class BuildTree {
	public static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int val){
			this.val = val;
		}
	}
	
	// 1. 采用遍历的方式找find
	public static TreeNode builTree1(int[] pre, int[] in) {
		if(pre == null || in == null || pre.length  != in.length) {
			return null;
		}
		return f(pre, 0, pre.length - 1, in, 0, in.length - 1);
	}
	
    // 给定一棵树，先序结果pre[L1,L2],中序结果in[L2,R2]
	public static TreeNode f(int[] pre, int L1, int R1, int[] in, int L2, int R2) {
		if(L1 > R1) {
			return null;
		}
		TreeNode head = new TreeNode(pre[L1]);
		if(L1 == R1) {
			return head;
		}
		int find = L2;
		while(in[find] != pre[L1]) {
			find++;
		}
		head.left = f( pre, L1 + 1, L1 -L2 + find,  in, L2 , find - 1);
		head.right = f(pre,L1 -L2 + find +1 , R1, in, find + 1,R2);
		return head;
	}
	
	// 2. 采用HashMap方式找find
	public static TreeNode buildTree2(int[] pre, int[] in) {
		if(pre == null || in == null || pre.length != in.length) {
			return null;
		}
		HashMap<Integer, Integer> valueIndexMap = new HashMap<>();
		for(int i = 0; i < in.length; i++) {
			valueIndexMap.put(in[i], i);
		}
		return f1(pre, 0, pre.length -1, in, 0, in.length -1, valueIndexMap);
	}
	
	// 给定一棵树，先序结果pre[L1,L2],中序结果in[L2,R2]
		public static TreeNode f1(int[] pre, int L1, int R1, int[] in, int L2, int R2, HashMap<Integer, Integer> valueIndexMap) {
			if(L1 > R1) {
				return null;
			}
			TreeNode head = new TreeNode(pre[L1]);
			if(L1 == R1) {
				return head;
			}
			int find = valueIndexMap.get(pre[L1]);
			
			head.left = f1( pre, L1 + 1, L1 -L2 + find,  in, L2 , find - 1, valueIndexMap);
			head.right = f1(pre,L1 -L2 + find +1 , R1, in, find + 1, R2, valueIndexMap);
			return head;
		}
	

}























