package algorithm2023.aug.day07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_2493_탑 {

	static int N, tower[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		tower = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			tower[i] = Integer.parseInt(st.nextToken());
		}
		Deque<top> dq = new ArrayDeque<>();
		for (int i = N - 1; i >= 0; i--) {
			if (dq.isEmpty()) {
				dq.push(new top(tower[i], i));
			} else {
				while (!dq.isEmpty() && tower[i] >= dq.peek().h) {
					tower[dq.pop().idx] = i + 1;
				}
				dq.push(new top(tower[i], i));
			}
			tower[i] = 0;
		}
		for (int i = 0; i < N; i++) {
			sb.append(tower[i] + " ");
		}
		System.out.println(sb);
	}

	static class top {
		int h;
		int idx;

		public top(int h, int idx) {
			super();
			this.h = h;
			this.idx = idx;
		}

	}
}