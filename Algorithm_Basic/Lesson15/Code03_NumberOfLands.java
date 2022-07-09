package lesson15;

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

public class Code03_NumberOfLands {
		
	public static List<Integer> numberOfLand21(int m, int n, int[][]positions){
		UnionFind1 uf = new UnionFind1(m, n);
		List <Integer> ans = new ArrayList<>();
		for(int[] position : positions) {
			ans.add(uf.connect(position[0], position[1]));
		}
		return ans ;
	}
	
	public static class UnionFind1{
		private int[] size;
		private int[] help;
		private int[] parents;
		private final int row;
		private final int col;
		private int sets;
		
		public UnionFind1(int m, int n) {
			row = m;
			col = n;
			int len = row * col;
			parents = new int[len];
			size = new int[len];
			help = new int[len];
		}
		
		private int index(int r, int c) {
			return r * col + c;
		}
		
		private int find(int i) {
			int hi = 0;
			while(i != parents[i]) {
				help[hi++] = i;
				i = parents[i];
			}
			for(hi--; hi >= 0; hi--) {
				parents[help[hi]] = i;
			}
			return i;
		}
		
		private void union(int r1, int c1, int r2, int c2) {
			if(r1 < 0 || r1 == row || r2 < 0 || r2 == row || c1 <0
			   || c1 == col || c2 < 0 || c2 == col) {
				return;
			}
			int i1 = index(r1, c1);
			int i2 = index(r2, c2);
			if(size[i1] == 0 || size[i2] == 0) {
				return;
			}
			int f1 = find(i1);
			int f2 = find(i2);
			if(f1 != f2) {
				if(size[f1] >= size[f2]) {
					size[f1] = size[f1] + size[f2];
					parents[f2] = f1;
				}else
				{
					size[f2] = size[f1] + size[f2];
					parents[f1] = f2;
				}
			}
			sets--;
		}
		
		public int connect(int r, int c) {
			int index = index(r, c);
			if(size[index] == 0) {
				parents[index] = index;
				size[index]  = 1;
				sets++;
				// 只要[r, c]能和四周连上，岛的数量就减一
				union(r - 1, c, r, c);
				union(r + 1, c, r, c);
				union(r, c - 1, r, c);
				union(r, c + 1, r, c);
			}
			return sets;
		}
	}
	
	
	public static List<Integer> numberOfLand22(int m, int n, int[][] positions){
		UnionFind2 uf = new UnionFind2();
		List<Integer> ans = new ArrayList<>();
		for(int[] position : positions) {
			ans.add(uf.connect(position[0], position[1]));
		}
		return ans;
	}
	
	public static class UnionFind2{
		private HashMap<String, String> parent;
		private HashMap<String, Integer> size;
		private ArrayList<String> help;
		private int sets;
		
		public UnionFind2() {
			parent = new HashMap<>();
			size = new HashMap<>();
			help = new ArrayList<>();
			sets = 0;
		}
		
		private String find(String cur) {
			while(!cur.equals(parent.get(cur))) {
				help.add(cur);
				cur = parent.get(cur);
			}
			for(String str : help) {
				parent.put(str, cur);
			}
			help.clear();
			return cur;
		}
		
		private void union(String s1, String s2) {
			if(parent.containsKey(s1) && parent.containsKey(s2)) {
				String f1 = find(s1);
				String f2 = find(s2);
				if(f1 != f2) {
					int size1 = size.get(s1);
					int size2 = size.get(s2);
					String big = size1 >= size2 ? f1 : f2;
					String small = big == f1 ? f2 : f1;
					parent.put(small, big);
					size.put(big, size1 + size2);
					sets--;
				}
			}
		}
		
		public int connect(int r, int c) {
			String key = String.valueOf(r) + "_" + String.valueOf(c);
			if(!parent.containsKey(key)) {
				parent.put(key, key);
				size.put(key, 1);
				sets++;
				String up = String.valueOf(r - 1) + "_" + String.valueOf(c);
				String down = String.valueOf(r + 1) + "_" + String.valueOf(c);
				String left = String.valueOf(r) + "_" + String.valueOf(c - 1);
				String right = String.valueOf(r) + "_" + String.valueOf(c + 1);
				
				union(up, key);
				union(down, key);
				union(left, key);
				union(right, key);
			}
			return sets;
		}
	}

}






















