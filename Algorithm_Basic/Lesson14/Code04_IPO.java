package lesson14;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Code04_IPO {
	
	public static class Program {
		public int p;
		public int c;

		public Program(int p, int c) {
			this.p = p;
			this.c = c;
		}
	}

	public static int findMaxCapital(int k, int w, int[] profit, int[] capital) {
			
		PriorityQueue<Program> minCostQ = new PriorityQueue<>(new MinComparator());
		PriorityQueue<Program> maxProfit = new PriorityQueue<>(new MaxComparator());
		for(int i = 0; i < profit.length; i++) {
			minCostQ.add(new Program(profit[i], capital[i]));
		}
		for(int i = 0; i < k; i++) {
			while(!minCostQ.isEmpty() && minCostQ.peek().c <= w) {
					maxProfit.add(minCostQ.poll());
			}
			if(maxProfit.isEmpty()) {
				return w; 
			}
			w += maxProfit.poll().p;
		}
		return w;
	}
	
	public static class MinComparator implements Comparator<Program>{
		public int compare(Program p1, Program p2) {
			return p1.c - p2.c;
		}
	}
	
	public static class MaxComparator implements Comparator<Program>{
		public int compare(Program p1, Program p2) {
			return p2.p - p1.p;
		}
	}
	
	
}



















