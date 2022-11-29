package nov_21;

/* N*N 보드에서 인접한 사탕의 색이 다를 경우 1회 교환 가능, 인접한 사탕의 수가 가장 길 때의 사탕 수를 출력
 * 난이도 : 실버 3
 * 아이디어: 
 * 시간복잡도:
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ3085 {

	static int[] dx = { 1, 0 };
	static int[] dy = { 0, 1 };

	static int check(ArrayList<ArrayList<Character>> board, int N) {
		int max = 0;
		for (int i = 0; i < N; i++) {
			int cntW = 1;
			for (int j = 0; j < N - 1; j++) {
				//System.out.println(board.get(i).get(j) + " " + board.get(i).get(j + 1));
				if (board.get(i).get(j) == board.get(i).get(j + 1)) {
					cntW++;
					//System.out.println(true + " " + cntW);
					if (max < cntW) {
						max = cntW;
					}
				} else {
					if (max < cntW) {
						max = cntW;
					}
					cntW = 1;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			int cntV = 1;
			for (int j = 0; j < N - 1; j++) {
				if (board.get(j).get(i) == board.get(j + 1).get(i)) {
					cntV++;
					if (max < cntV) {
						max = cntV;
					}
				} else {
					if (max < cntV) {
						max = cntV;
					}
					cntV = 1;
				}
			}
		}
		return max;

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<Character>> board = new ArrayList<>();
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			ArrayList<Character> arr = new ArrayList<>();
			for (char s : br.readLine().toCharArray()) {
				arr.add(s);
			}
			board.add(arr);
		}
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < 2; k++) {
					if (i + dx[k] >= N || j + dy[k] >= N) {
						continue;
					}
					if (board.get(i).get(j) != board.get(i + dx[k]).get(j + dy[k])) {
						char temp = board.get(i + dx[k]).get(j + dy[k]);
						board.get(i + dx[k]).set(j + dy[k], board.get(i).get(j));
						board.get(i).set(j, temp);
						/*for (ArrayList<Character> as : board) {
							System.out.println(as);
						}*/
						int a = check(board, N);
						if (a > max) {
							max = a;
						}
						temp = board.get(i + dx[k]).get(j + dy[k]);
						board.get(i + dx[k]).set(j + dy[k], board.get(i).get(j));
						board.get(i).set(j, temp);
					}
				}
			}
		}
		System.out.println(max);
	}
}