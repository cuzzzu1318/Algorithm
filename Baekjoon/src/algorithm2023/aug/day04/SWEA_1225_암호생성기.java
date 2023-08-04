package algorithm2023.aug.day04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1225_암호생성기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= 10; t++) {
			br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			Queue<Integer> q = new LinkedList<>();
			while (st.hasMoreTokens()) {
				q.offer(Integer.parseInt(st.nextToken()));
			}
			loop:
			while (true) {
				for (int i = 1; i <= 5; i++) {
					int n = q.poll();
					n -= i;
					if (n <= 0) {
						n = 0;
						q.offer(0);
						break loop;
					}
					q.offer(n);
				}
			}
			sb.append("#").append(t).append(" ");
			while(!q.isEmpty()) {
				sb.append(q.poll()).append(" ");
			}
			sb.append("\n");

		}
		System.out.println(sb);
	}
}
