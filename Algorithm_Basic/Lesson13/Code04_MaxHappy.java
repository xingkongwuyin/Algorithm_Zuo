package lesson13;

import java.util.List;
import java.util.ArrayList;

public class Code04_MaxHappy {

	public static class Employee{
		public int happy;
		public List<Employee> nexts;
		
		public Employee(int h) {
			happy = h;
			nexts = new ArrayList<>();
		}
	}
	
	public static int maxHappy(Employee head) {
		if(head == null) {
			return 0;
		}
		return Math.max(process(head).no, process(head).yes);
	}
	
	public static class Info{
		public int no;
		public int yes;
		
		public Info(int n , int y) {
			no = n;
			yes = y;
		}
	}
	
	public static Info process(Employee x) {
		if(x == null) {
			return new Info(0, 0);
		}
		int no = 0;
		int yes = x.happy;
		for(Employee next : x.nexts) {
			Info nextInfo = process(next);
			no += Math.max(nextInfo.yes, nextInfo.no);
			yes += nextInfo.no;
		}
		return new Info(no, yes);
	}
}





















