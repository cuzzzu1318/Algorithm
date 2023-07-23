package algorithm2022.nov;

/*
 * ���̵� : 
 * ���̵��: 
 * �ð����⵵:
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class SWEA4615 {

	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 }; // 0 1 2 3 4 5 6 7
	static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 }; // �� �ϵ� �� ���� �� ���� �� �ϼ�

	static boolean othello(int[][] board, int x, int y, int direction, int color, int N) {
		if (x == N || y == N || x == -1 || y == -1 || board[x][y] == 0) {
			return false;
		}
		if (board[x][y] == color) {
			return true;
		} else {
			if (othello(board, x + dx[direction], y + dy[direction], direction, color, N)) {
				board[x][y] = color;
				return true;
			}

			return false;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			String[] s = br.readLine().split(" ");
			int N = Integer.parseInt(s[0]);
			int M = Integer.parseInt(s[1]);
			int[][] board = new int[N][N];
			board[N / 2][N / 2] = 2;
			board[N / 2 - 1][N / 2 - 1] = 2;
			board[N / 2][N / 2 - 1] = 1;
			board[N / 2 - 1][N / 2] = 1;
			for (int i = 0; i < M; i++) {
				s = br.readLine().split(" ");
				int x = Integer.parseInt(s[1]) - 1;
				int y = Integer.parseInt(s[0]) - 1;
				int color = Integer.parseInt(s[2]);
				board[x][y] = color;
				for (int j = 0; j < 8; j++) {
					othello(board, x + dx[j], y + dy[j], j, color, N);
				}
			}
			int wSum = 0;
			int bSum = 0;
			for (int[] a : board) {
				for (int item : a) {
					if (item == 1) {
						bSum++;
					} else if (item == 2) {
						wSum++;
					}
				}
			}
			System.out.println("#" + t + " " + bSum + " " + wSum);
		}
	}
}