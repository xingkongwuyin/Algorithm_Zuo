package lesson15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Code02_NumberOfIslands {
		
	public static int numIslands3(char[][] board) {
		int islands = 0;
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				if(board[i][j] == '1') {
					islands++;
					infects(board, i, j);
				}
			}
		}
		return islands;
	}
	
	public static void infects(char[][] board, int i, int j) {
		if(i < 0 || i == board.length || j < 0 || j < board[0].length || board[i][j] != '1') {
			return;
		}
		board[i][j] = 0;
		infects(board,i, j - 1);
		infects(board,i, j + 1);
		infects(board,i + 1, j);
		infects(board,i - 1, j);
		
	}
}
