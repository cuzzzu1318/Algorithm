package algorithm2023.oct.day04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_5643_키순서 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static int graph[][];

	static int INF = 1000000000;

	public static void main(String[] args) throws Exception {

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			
			graph = new int[N+1][N+1];
			
			for(int i =1;i<=N;i++) {
				Arrays.fill(graph[i], INF);
				graph[i][i] = 0;
			}
			
			

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				graph[a][b] = 1;
			}
			int cnt = 0;
			for(int k = 1;k<=N;k++) {
				for(int i = 1;i<=N;i++) {
					for(int j =1;j<=N;j++) {
						graph[i][j] = Math.min(graph[i][j], graph[i][k]+graph[k][j]);
					}
				}
			}
			loop:
			for(int i = 1;i<=N;i++) {
				for(int j= 1;j<=N;j++) {
					if(graph[i][j]==INF&&graph[j][i]==INF) continue loop;
				}
				cnt++;
			}
			
			
			

			sb.append("#").append(t).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);

	}
}
