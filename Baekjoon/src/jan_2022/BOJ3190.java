package jan_2022;

/*
 * ���̵� : 
 * ���̵��: 
 * �ð����⵵:
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BOJ3190 {

	static int dx[] = { 0, -1, 1, 0 };
	static int dy[] = { 1, 0, 0, -1 };

	static int changedir(int cur, char dir) {
		if (cur == 0) {
			if (dir == 'L') {
				return 1;
			} else {
				return 2;
			}
		} else if (cur == 1) {
			if (dir == 'L') {
				return 3;
			} else {
				return 0;
			}
		} else if (cur == 2) {
			if (dir == 'L') {
				return 0;
			} else {
				return 3;
			}
		} else {
			if (dir == 'L') {
				return 2;
			} else {
				return 1;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		ArrayList<int[]> apple = new ArrayList<>();
		// [K][0] �� �� [K][1]�� ��
		for (int i = 0; i < K; i++) {
			String[] s = br.readLine().split(" ");
			int[] apples = new int[2];
			apples[0] = Integer.parseInt(s[0]) - 1;
			apples[1] = Integer.parseInt(s[1]) - 1;
			apple.add(apples);
		}

		int L = Integer.parseInt(br.readLine());
		Queue<Integer> time = new LinkedList<>();
		Queue<Character> direction = new LinkedList<>();
		for (int i = 0; i < L; i++) {
			String[] s = br.readLine().split(" ");
			time.add(Integer.parseInt(s[0]));
			direction.add(s[1].charAt(0));
		}

		boolean isend = false;
		int d = 0;
		ArrayList<int[]> snake = new ArrayList<>();
		int curx = 0;
		int cury = 0;
		int[] temp = { 0, 0 };
		snake.add(temp);
		int cnt = 0;
		int curtime = 0;
		loop: while (!isend) {
			curx += dx[d];
			cury += dy[d];
			if (curx < 0 || cury < 0 || curx >= N || cury >= N) {
				break;
			}
			int[] cur = { curx, cury };
			for (int[] arr : snake) {
				if (arr[0] == cur[0] && arr[1] == cur[1]) {
					break loop;
				}
			}
			snake.add(cur);
			boolean isApple = false;
			if (!apple.isEmpty()) {
				for (int i = 0;i<apple.size();i++) {
					if (apple.get(i)[0] == cur[0] && apple.get(i)[1] == cur[1]) {
						isApple = true;
						apple.remove(i);
					}
				}
			}

			if (!isApple) {
				snake.remove(0);
			}
			cnt++;
			curtime++;
			if (!time.isEmpty() && curtime == time.peek()) {
				time.poll();
				d = changedir(d, direction.poll());
			}
			/*
			System.out.println(curx + " " + cury + " " + cnt);
			for (int i = 0; i < N; i++) {
				loop1: for (int j = 0; j < N; j++) {
					for (int[] arr : snake) {
						if (arr[0] == i && arr[1] == j) {
							System.out.print("��");
							continue loop1;
						}
					}
					System.out.print("��");
				}
				System.out.println();
			}
*/
		}
		System.out.println(++cnt);
	}
}