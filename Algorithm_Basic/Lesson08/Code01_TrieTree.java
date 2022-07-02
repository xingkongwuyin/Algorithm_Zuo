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
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}	  

