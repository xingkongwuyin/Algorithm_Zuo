package lesson03;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;
public class Code10_HashMapAndSortedMap {
	
	public static class Node{
  		public int value;
  		
  		public Node(int v) {
  			value = v;
  		}
	}
	
	public static class Song{
		public int value;
		
		public Song(int v) {
			value  = v;
		}
	}
	

	public static void main(String[] args) {
		
		HashMap<Integer, String> test = new HashMap<>();
		Integer a = 100000;
		Integer b = 100000;
		System.out.println(a == b); // 引用传递，传递是值
		
		test.put(a, "woshi3");
		System.out.println(test.containsKey(b));
		
		Song s1 = new Song(1);
		//Song s2 = new Song(1);
		
		HashMap<Song, String> test2 = new HashMap<>();
		test2.put(s1, "woshis1");
		//System.out.println(test.containsKey(s2));
		
		// key
		HashSet<String> set = new HashSet<>();
		set.add("abc");
		set.contains("abc");
		set.remove("abc");
		
		// 哈希表，增删查改，在使用时，O(1)
		
		// TreeMap 有序表：接口名
		// 实现：红黑树、avl、sb树、跳表
		// O(logN) 默认log是以2为底
		TreeMap<Integer,String> treeMap = new TreeMap<>();
		
		treeMap.put(3, "我是3");
		treeMap.put(4, "我是4");
		treeMap.put(8, "我是8");
		treeMap.put(5, "我是5");
		treeMap.put(7, "我是7");
		treeMap.put(1, "我是1");
		treeMap.put(2, "我是2");
		
		System.out.println(treeMap.containsKey(2));
		
		System.out.println(treeMap.get(4));
		System.out.println(treeMap.get(10));
		
		treeMap.put(4, "444");
		System.out.println(treeMap.get(4));
		
		treeMap.remove(4);
		System.out.println(treeMap.containsKey(4));
		
		System.out.println(treeMap.firstKey());
		System.out.println(treeMap.lastKey());
		
		// <= 4
		System.out.println(treeMap.floorKey(4));
		System.out.println(treeMap.ceilingKey(4));
		
	}

}


