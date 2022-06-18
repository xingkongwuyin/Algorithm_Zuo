package Lesson07;
import java.util.ArrayList;
import java.util.List;

import Lesson07.HasPathSum.TreeNode;

// 给定一棵树和一个key，求出所有的路径和等于key的路径

public class AllPathSum {
	
	// 1. 创造结点
	public static class TreeNode{
		public int val;
		public TreeNode left;
		public TreeNode right;
		
		TreeNode(int val){
			this.val = val;
		}
	}
    
	// 2. allPathsum
	public static List<List<Integer>> allPathSum(TreeNode root, int sum){
		List<List<Integer>> ans = new ArrayList<>();
		if(root == null) {
			return ans;
		}
		ArrayList<Integer> path  = new ArrayList<>();
		process(root, path, 0, sum, ans);
		return ans;
	}
	
	// 3. process
	public static void process(TreeNode x, List<Integer> path, int presum, int sum, List<List<Integer>> ans) {
		if(x.left == null && x.right == null) {
			if(presum + x.val == sum) {
				path.add(x.val);
				ans.add(copy(path));
				path.remove(path.size() - 1);
			}
		// 非叶节点	
		path.add(x.val);	
		presum += x.val;
		if(x.left != null) {
			process(x.left, path, presum, sum, ans);
		}
		if(x.right != null) {
			process(x.right, path, presum, sum, ans);
		}
		path.remove(path.size() -1);
		}
	}
	// 4. copy
    public static List<Integer> copy(List<Integer> path){
    	List<Integer> ans = new ArrayList<>();
    	for(Integer num : path) {
    		ans.add(num);
    	}
    	return ans;
    }
}
