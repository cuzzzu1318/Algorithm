package algorithm2023.oct.day10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class __BOJ_12100_2048_Easy {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, ans;

	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		int[][] board = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		game(0,board);
		
		System.out.println(ans);
	}

	static void game(int idx, int[][] board) {
		if (idx == N) {
			// 카운트 해서 최댓값 갱신
			ans = Math.max(ans, getMax(board));
			return;
		}

		for (int d = 0; d < 4; d++) {

			// 배열 복사
			int[][] temp = new int[N][];
			for (int i = 0; i < N; i++) {
				temp[i] = board[i].clone();
			}

			// d방향으로 밀기 및 합치기
			push(d,temp);
			if(!compare(board,temp))continue;
			print(temp);
			// 다음 인덱스로 탐색
			game(idx + 1, temp);

		}
	}

	static int getMax(int[][] board) {
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] > max)
					max = board[i][j];
			}
		}
		return max;
	}

	static void push(int d, int[][] board) {

		switch (d) {
		case 0:
			// d방향으로 가면서 숫자들을 스택에 기록 및 0으로 갱신
			for (int i = 0; i < N; i++) {
				int idx = 0;
				int prev = board[idx][i];
				board[idx][i] = 0;
				int next = 0;
				for (int j = 1; j<N; j++) {
					next = board[j][i];
					board[j][i] = 0;
					if (next > 0) {
						if (prev == next) {
							board[idx++][i] = prev * 2;
							prev = 0;
						}else {
							board[idx++][i] = prev;
							prev = next;
						}
					}
				}
				board[idx][i] = prev;
			}
			break;
		case 1:
			for (int i = 0; i < N; i++) {
				int idx = N-1;
				int prev = board[i][idx];
				board[i][idx] = 0;
				int next = 0;
				for (int j = N-2; j>=0; j--) {
					next = board[i][j];
					board[i][j] = 0;
					if (next > 0) {
						if (prev == next) {
							board[i][idx--] = prev * 2;
							prev = 0;
						}else {
							board[i][idx--] = prev;
							prev = next;
						}
					}
					
				}
				board[i][idx] = prev;
			}
			break;

		case 2:
			for (int i = 0; i < N; i++) {
				int idx = N-1;
				int prev = board[idx][i];
				board[idx][i] = 0;
				int next = 0;
				for (int j = N-2; j>=0; j--) {
					next = board[j][i];
					board[j][i] = 0;
					if (next > 0) {
						if (prev == next) {
							board[idx--][i] = prev * 2;
							prev = 0;
						}else {
							board[idx--][i] = prev;
							prev = next;
						}
					}
				}
				board[idx][i] = prev;
			}
			break;
		case 3:
			for (int i = 0; i < N; i++) {
				int idx = 0;
				int prev = board[i][idx];
				board[i][idx] = 0;
				int next =0 ;
				for (int j = 1; j<N; j++) {
					next = board[i][j];
					board[i][j] = 0;
					if (next > 0) {
						if (prev == next) {
							board[i][idx++] = prev * 2;
							prev = 0;
						}else {
							board[i][idx++] = prev;
							prev = next;
						}
					}
				}
				board[i][idx] = prev;
			}
			break;
		}

	}
	
	static void print(int[][] board) {
		for(int i =0;i<N;i++) {
			System.out.println(Arrays.toString(board[i]));
		}
		System.out.println();
	}
	
	static boolean compare(int[][] board, int[][] temp) {
		for(int i= 0;i<N;i++) {
			for(int j =0;j<N;j++) {
				if(board[i][j]!=temp[i][j])return true;
			}
		}
		return false;
	}
}
