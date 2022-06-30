package lesson07;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Code01_CoverArea {

	// 1. Lines class
	public static class Line{
		public int start;
		public int end;
		
		public Line(int s, int e){
			start = s;
			end = e;
		}
	}
	
	// 2. overwrite comparator
	public static class StartComparator implements Comparator<Line>{
		
		public int compare(Line L1, Line L2) {
			
			return L1.start - L2.start;
		}
	}
	
	// 3. coverArea
	public static int coverArea(int[][] line) {
		
		Line[] lines = new Line[line.length];
		for(int i = 0; i < line.length; i++) {
			lines[i] = new Line(line[i][0], line[i][1]);
		}
		Arrays.sort(lines, new StartComparator());
		int max = 0;
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		for(int i = 0; i < line.length; i++) {
			while(!heap.isEmpty() && heap.peek() <= lines[i].start) {
				heap.poll();
			}
			heap.add(lines[i].end);
			max = Math.max(max, heap.size());
		}
		return 0;
	}
	
}


























