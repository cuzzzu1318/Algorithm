package algorithm2023.oct.day23;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1865_웜홀 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, M, W;
	static int INF = 999_999_999;
	static int[][] graph;


	public static void main(String[] args) throws Exception {
		int TC = Integer.parseInt(br.readLine());
		loop: for (int t = 0; t < TC; t++) {
			st = new StringTokenizer(br.readLine());
			// 지점의 수 N, 도로의 개수 M, 웜홀의 개수 W
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			graph = new int[N + 1][N + 1];

			for (int i = 0; i <= N; i++) {
				Arrays.fill(graph[i], INF);
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				graph[s][e] = cost;
				graph[e][s] = cost;
			}

			for (int i = 0; i < W; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				graph[s][e] = -cost;
			}

			for (int i = 1; i <= N; i++) {
				if (bellmanFord(i)) {
					sb.append("YES\n");
					continue loop;
				}
			}
			sb.append("NO\n");
		}
		System.out.println(sb);
	}

	static boolean bellmanFord(int start) {
		int[] dist = new int[N + 1];
		Arrays.fill(dist, INF);
		dist[start] = 0;
		for (int next = 1; next <= N; next++) {
			boolean isUpdate = false;
			for (int i = 1; i <= N; i++) {
					if(dist[next]==INF)continue;
					if (dist[next] + graph[next][i] < dist[i]) {
						isUpdate = true;
						dist[i] = dist[next] + graph[next][i];
						if (next == N)
							return true;
					}
			}
			if(!isUpdate) break;
		}
		
		return false;
	}
	
	static void print() {
		for(int i= 1;i<=N;i++) {
			System.out.println(Arrays.toString(graph[i]));
		}
		System.out.println();
	}
}
