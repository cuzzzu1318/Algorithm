package algorithm2023.aug.day30;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10971_외판원순회2 {

	static int N, graph[][], selected[];
	static long min;
	static boolean v[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		graph = new int[N][N];
		selected = new int[N];
		min = Long.MAX_VALUE;
		v = new boolean[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i =0;i<N;i++) {
			selected[0] = i;
			v[i] = true;
			perm(1);
			v[i] = false;
		}
		System.out.println(min);

	}

	static void perm(int idx) {
		if (idx == N) {
			int sum = 0;
			for (int i = 1; i < N; i++) {
				sum += graph[selected[i-1]][selected[i]];
			}
			if(graph[selected[N-1]][selected[0]]==0)return;
			sum+=graph[selected[N-1]][selected[0]];
			min = Math.min(sum, min);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!v[i] && graph[selected[idx-1]][i] > 0) {
				v[i] = true;
				selected[idx] = i;
				perm(idx + 1);
				v[i] = false;
			}
		}
	}
}
