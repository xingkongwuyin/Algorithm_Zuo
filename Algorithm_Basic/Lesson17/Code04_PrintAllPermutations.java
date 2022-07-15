package Lesson17;

import java.util.ArrayList;
import java.util.List;

public class Code04_PrintAllPermutations {
	
	// 打印一个字符串的全排列 first method
	public static List<String> permutation1(String s){
		List<String> ans = new ArrayList<>();
		if(s == null || s.length() == 0) {
			return ans;
		}
		char[] str = s.toCharArray();
		ArrayList<Character> rest = new ArrayList<Character>();
		for(char cha : str) {
			rest.add(cha);
		}
		String path = " ";
		f(rest, path, ans);
		return ans;
	}
	
	// f: 将rest里面的字符全排列后，产生的每一个排列与path相结合，然后加入ans中
	public static void f(ArrayList<Character> rest, String path, List<String> ans){
		if(rest.isEmpty()) {
			ans.add(path);
			return;
		}
		int N = rest.size();
		for(int i = 0; i < N; i++) {
			char cur = rest.get(i);
			rest.remove(i);
			f(rest, path + cur, ans);
			rest.add(i, cur);
		}
	}
	
	// second method
	public static List<String> permutation2(String s){
		List<String> ans = new ArrayList<>();
		if(s == null || s.length() == 0) {
			return ans;
		}
		char[] str = s.toCharArray();
		f2(str, 0, ans);
		return ans;
	}
	
	// f2:将index和index之后的元素全排列且与index之前结合，产生的每一个序列都放进ans中
	public static void f2(char[] str, int index, List<String> ans) {
		if(index == str.length) {
			ans.add(String.valueOf(str));
			return;
		}else {
			for(int i  = index; i < str.length; i++) {
				swap(str, index, i);
				f2(str, index + 1,  ans);
				// 恢复现场
				swap(str, i, index);
			}
		}
	}
	
	// 打印去重字符串的全排列
	public static List<String> permutation3(String s){ 
		List<String> ans = new ArrayList<>();
		if(s == null || s.length() == 0) {
			return ans;
		}
		char[] str = s.toCharArray();
		f3(str, 0, ans);
		return ans;
	}
	
	public static void f3(char[] str, int index, List<String> ans){
		if(index == str.length) {
			ans.add(String.valueOf(str));
			return;
		}else {
			boolean[] visited = new boolean[256];
			for(int i = index; i < str.length; i++) {
				if(!visited[str[i]]) {
					visited[str[i]] = true;
					swap(str, index, i);
					f3(str, index + 1, ans);
					swap(str, i, index);
				}
			}
		}
	}
	

	public static void swap(char[] str, int i, int j) {
		char tmp = str[i];
		str[i] = str[j];
		str[j] = tmp;
	}
	
	public static void main(String[] args) {
		String s = "acc";
		List<String> ans1 = permutation1(s);
		for(String str : ans1) {
			System.out.println(str);
		}
		System.out.println("====================");
		List<String> ans2 = permutation2(s);
		for(String str : ans2) {
			System.out.println(str);
		}
		System.out.println("====================");
		List<String> ans3 = permutation3(s);
		for(String str : ans3) {
			System.out.println(str);
		}
		System.out.println("====================");
		
	}
}
