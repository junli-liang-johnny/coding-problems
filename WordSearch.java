
/*
 * Given an m x n grid of characters board and a string word, 
 * return true if word exists in the grid.
 * The word can be constructed from letters of sequentially 
 * adjacent cells, where adjacent cells are horizontally or 
 * vertically neighboring. 
 * The same letter cell may not be used more than once.
 */
import java.util.HashSet;
import java.util.HashMap;
import java.util.Set;

public class WordSearch {
	private int rowLength;
	private int colLength;
	Set<String> visited;

	public static void main(String[] args) {

	}

	/**
	 * the idea is to bruft force search 4 directions and find the next position
	 * We also count the positions visited
	 * trick is to start from the end of the word if possible: the occurence of last
	 * char is
	 * less than first char
	 */
	public boolean exist(char[][] board, String word) {
		rowLength = board.length;
		colLength = board[0].length;

		visited = new HashSet<String>();

		HashMap<Character, Integer> count = new HashMap<Character, Integer>();

		for (char c : word.toCharArray()) {
			count.put(c, count.getOrDefault(c, 0) + 1);
		}

		if (count.getOrDefault(word.charAt(0), 0) > count.getOrDefault(word.charAt(word.length() - 1), 0)) {
			word = new StringBuilder(word).reverse().toString();
		}

		for (int r = 0; r < rowLength; r++) {
			for (int c = 0; c < colLength; c++) {
				if (dfs(board, word, r, c, 0)) {
					return true;
				}
			}
		}

		return false;
	}

	private boolean dfs(char[][] board, String word, int row, int col, int k) {
		if (k == word.length()) {
			return true;
		}

		if (row < 0 ||
				row >= rowLength ||
				col < 0 ||
				col >= colLength ||
				visited.contains(row + "," + col) ||
				board[row][col] != word.charAt(k)) {
			return false;
		}

		visited.add(row + "," + col);
		boolean res = dfs(board, word, row + 1, col, k + 1) ||
				dfs(board, word, row - 1, col, k + 1) ||
				dfs(board, word, row, col + 1, k) ||
				dfs(board, word, row, col - 1, k + 1);
		visited.remove(row + "," + col);
		return res;
	}
}
