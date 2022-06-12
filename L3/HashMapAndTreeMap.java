package Lesson03;

import java.util.HashMap;
import java.util.TreeMap;

public class HashMapAndTreeMap {
    // 自定义数据类型Node
	public static class Node {
		public int value;
		
		public Node(int v) {
			value = v;
		}
	}

	// HashMap
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<>();
		map.put("sgj", "song");                        // 增
		//System.out.println(map.containsKey("sgj"));  // 查
		//System.out.println(map.get("sgj"));          // 取
        map.put("sgj", "guang");                       // 改
        //System.out.println(map.get("sgj"));  
        map.remove("sgj");                             // 删
        //System.out.println(map.containsKey("sgj"));
        
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        HashMap<Node,Node> map1 = new HashMap<>();
        map1.put(node1,node2);
        
        //System.out.println(map1.get(node1));
    
        
       // Treemap(有序)
        TreeMap<Integer, String> Treemap1 = new TreeMap();
        Treemap1.put(1,"s");
        Treemap1.put(2,"o");
        Treemap1.put(3,"n");
        Treemap1.put(4,"g");
        Treemap1.put(5,"j");
        Treemap1.put(7,"i");
        System.out.println(Treemap1.firstKey());
        System.out.println(Treemap1.lastKey());
        // <=
        System.out.println(Treemap1.floorKey(4));
        // >=
        System.out.println(Treemap1.ceilingKey(6));
        
        //TreeMap<Node,Integer> Treemap2 = new TreeMap();
        //Treemap2.put(node1, 1);
        //Treemap2.put(node2,2);
        //System.out.println(Treemap2.get(node1));
        
	}

}


















