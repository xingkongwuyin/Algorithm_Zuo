package Lesson20;


 import java.util.Comparator;
 import java.util.PriorityQueue;

public class Code03_Coffee {
	
	public static class Machine{
		public int timePoint;
		public int workTime;
		
		public Machine(int t, int w) {
			timePoint = t;
			workTime = w;
		}	
	}
	
	public static class MachineComparator implements Comparator<Machine>{
		public int compare(Machine o1, Machine o2) {
			return (o1.timePoint + o1.workTime) - (o2.timePoint + o2.workTime);
		}
	}
	
	// 暴力递归
	public static int minTime1(int[] arr, int n, int a, int b) {
		PriorityQueue<Machine> heap = new PriorityQueue<Machine>(new MachineComparator());
		for(int i = 0; i < arr.length; i++) {
			heap.add(new Machine(0, arr[i]));
		}
		// drinks 每个人喝完咖啡的时间
		int[] drinks = new int[n];
		for(int i = 0; i < n; i++) {
			// 每一个人去选去哪个咖啡机等待
			Machine cur = heap.poll();
			cur.timePoint += cur.workTime;
			drinks[i] = cur.timePoint;
			heap.add(cur);
			
		}
		
		return process(drinks, a, b, 0, 0);
	}
	
	public static int process(int[] drinks, int wash, int air, int index, int free) {
		// 站在0点去看（上帝视角），一开始就给他们分配好
		if(index == drinks.length) {
			return 0;
		}
		// 第index个人 用机器洗
		// 机器洗完第index个人杯子后的空闲时刻
		int machineClean =  Math.max(drinks[index], free) + wash;
		int restTime1 = process(drinks, wash, air, index + 1, machineClean);
		int p1 = machineClean + restTime1;
		
		// 第index个人 挥发完，所到的时刻
		int volatilazation = drinks[index] + air;
		int restTime2 = process(drinks, wash, air,  index + 1,free);
		int p2 = volatilazation + restTime2;
		
		return Math.min(p1, p2);
	}
	
	// 动态规划
	public static int minTime2(int[] arr, int n, int a, int b) {
		PriorityQueue<Machine> heap = new PriorityQueue<Machine>(new MachineComparator());
		for(int i = 0; i < arr.length; i++) {
			heap.add(new Machine(0, arr[i]));
		}
		// drinks 每个人喝完咖啡的时间
		int[] drinks = new int[n];
		for(int i = 0; i < n; i++) {
			// 每一个人去选去哪个咖啡机等待
			Machine cur = heap.poll();
			cur.timePoint += cur.workTime;
			drinks[i] = cur.timePoint;
			heap.add(cur);
			
		}
		
		return dp(drinks, a, b);
	}
	
	public static int dp(int[] drinks, int a, int b) {
		int N = drinks.length;
		int maxFree = 0;
		// 假设每个人都用机器洗，机器最后空闲的时刻
		for(int i = 0; i < N; i++) {
			// 第i个人，洗完杯子，机器空闲的时刻
			maxFree = Math.max(maxFree, drinks[i]) + b;		
		}
		int[][] dp = new int[N + 1][maxFree + 1];
		for(int index = N - 1; index >= 0; index--) {
			for(int free = 0; free <= maxFree; free++) {
				
				int machineClean =  Math.max(drinks[index], free) + a;
				if(machineClean > maxFree) {
					break;
				}
				int restTime1 = dp[index + 1][machineClean];	
				int p1 = machineClean + restTime1;
			
				int volatilazation = drinks[index] + b;
				int restTime2 = dp[index + 1] [free];
				int p2 = volatilazation + restTime2;
				
				dp[index][free] = Math.min(p1, p2);
			}
		}
		return dp[0][0];
	}

	
	public static void main(String[] args) {
		int[] arr = {2,3,4,6};
		System.out.println(minTime1(arr, 5, 5, 6));
		System.out.println(minTime2(arr, 5, 5, 6));

	}

}
