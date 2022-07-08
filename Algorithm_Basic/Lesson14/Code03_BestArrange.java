package lesson14;

import java.util.Arrays;
import java.util.Comparator;

public class Code03_BestArrange {
	
	public static class Program{
		public int start;
		public int end;
		
		public Program(int s, int e) {
			start = s;
			end = e;
		}
	}
	
	public static int BestArrange(Program[] programs) {
		Arrays.sort(programs, new ProgramComparator());
		int timeline = 0; // 最后一个会议结束的时间
		int res = 0;
		int i = 0;
		for(i = 0; i < programs.length; i++) {
			if(timeline <= programs[i].start) {
				res++;
				timeline = programs[i].end;
			}
		}
		return res;
	}
	
	public static class ProgramComparator implements Comparator<Program>{
		public int  compare(Program p1, Program p2) {
			return p1.end - p2.end;
		}
	}
	
}














