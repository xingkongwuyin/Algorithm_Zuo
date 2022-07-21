package Lesson19;

import java.util.HashMap;

public class Code03_StickersToSpellWord {
	public static int minStickers1(String[] stickers, String target) {
		int ans = process1(stickers, target);
		return ans == Integer.MAX_VALUE ? -1 : ans;
	}
	
	// 先让每一张包含target字符的贴纸做第一张贴纸，然后分别得出还需多少贴纸，能够拼齐rest
	// 然后分别加上各自对应的做第一张贴纸的贴纸，最后从中得出最小值
	public static int process1(String[] stickers, String target) {
		if(target.length() == 0) {
			return 0;
		}
		int min = Integer.MAX_VALUE;
		for(String str : stickers) {
			String rest = minus(target, str);
			// rest == target 比的是地址
			if(rest.length() != target.length()) { 
				min = Math.min(min,process1(stickers, rest));
			}
		}
		return min + (min == Integer.MAX_VALUE ? 0 : 1);
	}
	
	public static String minus(String target, String str) {
		char[] str1 = target.toCharArray();
		char[] str2 = str.toCharArray();
		int[] count = new int[26];
		for(char cha : str1) {
			count[cha - 'a']++;
		}
		for(char cha : str2) {
			count[cha - 'a']--;
		}
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < 26; i++) {
			if(count[i] > 0) {
				for(int j = 0 ; j < count[i]; j++) {
					builder.append((char)(i + 'a'));
				}
			}
		}
		return builder.toString();
	}
	
	
	public static int minStickers2(String[] stickers, String target) {
		int N = stickers.length;
		int[][] count = new int[N][26];
		for(int i = 0; i < N; i++) {
			char[] str = stickers[i].toCharArray();
			for(char cha : str) {
				count[i][cha - 'a']++;
			}
		}
		int ans = process2(count, target);
		return ans == Integer.MAX_VALUE ?  -1 : ans;
	}
	
	public static int process2(int[][] stickers, String t) {
		if(t.length() == 0) {
			return 0;
		}
		char[] target = t.toCharArray(); 
		int[] tcounts = new int[26];
		for(char cha : target) {
			tcounts[cha - 'a']++;
		}
		int N = stickers.length;
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < N; i++) {
			int[] sticker = stickers[i];
			if(sticker[target[0] - 'a'] != 0) {
				StringBuilder builder = new StringBuilder();
				for(int j = 0; j < 26; j++) {
					int nums = tcounts[j] -sticker[j];
					for(int k = 0; k < nums; k++) {
						builder.append((char)(j + 'a'));
					}
				}
				String rest = builder.toString();
				min = Math.min(min, process2(stickers, rest));
			}
		}
		return min + (min == Integer.MAX_VALUE ? 0 : 1);
	}
	
	
	public static int minStickers3(String[] stickers, String target) {
		int N = stickers.length;
		int[][] counts = new int[N][26];
		for(int i = 0; i < N; i++) {
			char[] str = stickers[i].toCharArray();
			for(char cha : str) {
				counts[i][cha - 'a']++; 
			}
		}
		HashMap<String, Integer> dp = new HashMap<>();
		dp.put("", 0);
		int ans = process3(counts, target, dp);
		return ans == Integer.MAX_VALUE ? -1 : ans;
	}
	
	public static int process3(int[][] stickers, String t, HashMap<String, Integer> dp) {
		if(dp.containsKey(t)) {
			return dp.get(t);
		}
		char[] target = t.toCharArray();
		int[] tcounts = new int[26];
		for(char cha : target) {
			tcounts[cha - 'a']++;
		}
		int N = stickers.length;
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < N; i++) {
			int[] sticker = stickers[i];
			if(sticker[target[0] - 'a'] > 0) {
				StringBuilder builder = new StringBuilder();
				for(int j = 0; j < 26; j++) {
					if(tcounts[j] > 0) {
						int nums = tcounts[j] - sticker[j];
						for(int k = 0; k < nums; k++) {
							builder.append((char)(j + 'a'));
						}
					}	
				}
				String rest = builder.toString();
				min = Math.min(min, process3(stickers, rest, dp));
			}
		}
		int ans = min + (min == Integer.MAX_VALUE ? 0 : 1);
		dp.put(t, ans);
		return ans;
	}
	
	
	public static void main(String[] args) {
		String[] str = {"a","b","abc"};
		System.out.println(minStickers1(str, "abfsad"));
		System.out.println(minStickers2(str, "abfas"));
		System.out.println(minStickers3(str, "afdsab"));
	}

}
