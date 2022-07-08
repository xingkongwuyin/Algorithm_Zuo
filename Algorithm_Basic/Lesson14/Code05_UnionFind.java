package lesson14;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;


public class Code05_UnionFind {
	
	public static class Node<V>{
		V value;
		
		public Node(V v){
			value = v;
		}
	}
	
	public static class UnionFind<V>{
		public HashMap<V, Node<V>> nodes;
		public HashMap<Node<V>, Node<V>> parents;
		public HashMap<Node<V>, Integer> sizeMap;
		
		public UnionFind(List<V>values) {
			nodes = new HashMap<>();
			parents = new HashMap<>();
			sizeMap = new HashMap<>();
			
			for(V cur : values) {
				Node<V> node = new Node<>(cur);
				nodes.put(cur, node);
				parents.put(node, node);
				sizeMap.put(node, 1);
			}
		}
		
		public Node<V> findHead(Node<V> cur){
			Stack<Node<V>> path = new Stack<>();
			while(cur != parents.get(cur)) {
				path.add(cur);
				cur = parents.get(cur);
			}
			while(!path.isEmpty()) {
				parents.put(path.pop(), cur);
			}
			return cur;
		}
		
		public boolean isSameHead(V a, V b) {
			return findHead(nodes.get(a)) == findHead(nodes.get(b));
		}
		
		public void union(V a, V b) {
			Node<V> aHead = findHead(nodes.get(a));
			Node<V> bHead = findHead(nodes.get(b));
			if(aHead != bHead) {
				int aSetSize = sizeMap.get(aHead);
				int bSetSize = sizeMap.get(bHead);
				Node<V> big = aSetSize > bSetSize ? aHead : bHead;
				Node<V> small = big == aHead ? bHead : aHead;
				parents.put(small, big);
				sizeMap.put(big, aSetSize + bSetSize);
				sizeMap.remove(small);
			}
		}
		
		public int sets() {
			return sizeMap.size();
		}
	}
	
	
}






















