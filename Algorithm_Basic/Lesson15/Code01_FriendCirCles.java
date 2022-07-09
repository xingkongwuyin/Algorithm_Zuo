package lesson15;

public class Code01_FriendCirCles {

	public static int friendCirClesNum(int[][] M){
		int N = M.length;
		UnionFind unionFind = new UnionFind(N);
		for(int i = 0; i < N; i++) {
			for(int j = i + 1; j < N; j++) {
				if(M[i][j] == 1) {
					unionFind.union(i, j);
				}
			}
		}
		return unionFind.sets;
	}
	
	public static class UnionFind{
		private int[] parents;
		private int[] help;
		private int[] size;
		private int sets;
		
		public UnionFind(int N) {
			parents = new int[N];
			help = new int[N];
			size = new int[N];
			sets = N;
			for(int i = 0; i < N; i++) {
				parents[i] = i;
				size[i] = 1;
			}
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
		
		public void union(int i , int j) {
			int f1 = find(i);
			int f2 = find(j);
			if(f1 != f2) {
				if(size[f1] >= size[f2]) {
					parents[f2] = f1;
					size[f1] = size[f1] + size[f2];
					size[f2] =0;
				}else {
					parents[f1] = f2;
					size[f2] = size[f1] + size[f2];
					size[f1] = 0;
				}
				sets--;
			}
		}
		
		public int sets() {
			return sets;
		}
	}
	
	
}























