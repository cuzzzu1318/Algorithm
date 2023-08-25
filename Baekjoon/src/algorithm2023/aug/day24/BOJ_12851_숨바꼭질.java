package algorithm2023.aug.day24;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_12851_숨바꼭질 {
	static int N, K, ansT, ans, arr[];
	static boolean[] v;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		if (N > K) {
			arr = new int[N + 2];
			v = new boolean[N + 2];

		} else {
			arr = new int[K + 2];
			v = new boolean[K + 2];
		}

		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		v[N] = true;
		int time = 0;
		loop: while (!q.isEmpty()) {
			int size = q.size();
			boolean flag = false;
			for (int i = 0; i < size; i++) {
				int cur = q.poll();
				v[cur] = true;
				if (cur == K) {
					flag = true;
					ans++;
					ansT = time;
				}
				if (cur - 1 >= 0) {
					if (!v[cur - 1])
						q.offer(cur - 1);
				}
				if (cur * 2 <= arr.length - 1) {
					if (!v[cur * 2])
						q.offer(cur * 2);
				}
				if (cur + 1 <= arr.length - 1) {
					if (!v[cur + 1])
						q.offer(cur + 1);
				}
			}
			if (flag)
				break;
			time++;
		}
		System.out.println(ansT);
		System.out.println(ans);

	}
}
