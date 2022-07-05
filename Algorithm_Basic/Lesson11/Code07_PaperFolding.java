package lesson11;

public class Code07_PaperFolding {

	public static void printAllFolds(int n) {
			
		process(1, n, true);
		System.out.println();
	}
	// 当前你来了一个节点，脑海中想象的！
		// 这个节点在第i层，一共有N层，N固定不变的
		// 这个节点如果是凹的话，down = T
		// 这个节点如果是凸的话，down = F
		// 函数的功能：中序打印以你想象的节点为头的整棵树！
	    // 功能: 将以处于N层大树的第i层的某个凸结点（或凹结点）的树进行中序遍历	
	public static void process(int i, int N, boolean down) {
		if(i > N) {
			return;
		}
		process(i + 1, N, true);
		System.out.print(down ? "凹 " : "凸 ");
		process(i + 1, N, false);
	}
	
	
	public static void main(String[] args) {
		printAllFolds(4);
	}

}

