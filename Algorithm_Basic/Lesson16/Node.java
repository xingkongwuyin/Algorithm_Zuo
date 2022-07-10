package lesson16;

import java.util.ArrayList;

// 点结构的描述
public class Node {
	public int value;
	public int in;
	public int out;
	public ArrayList<Node> nexts;
	public ArrayList<Edge> edges;
	
	public Node(int v) {
		value = v;
		in = 0;
		out = 0;
		nexts = new ArrayList<>();
		edges = new ArrayList<>();
	}
}
