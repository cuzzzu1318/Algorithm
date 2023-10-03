package algorithm2023.oct.day03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1135_뉴스전하기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, cost[];
	static boolean graph[][];

	public static void main(String[] args) throws Exception {

		// 직원의 수 N
		N = Integer.parseInt(br.readLine());

		graph = new boolean[N][N];
		cost = new int[N];

		st = new StringTokenizer(br.readLine());

		st.nextToken();

		for (int i = 1; i < N; i++) {
			int boss = Integer.parseInt(st.nextToken());
			graph[boss][i] = true;
			cost[boss] ++;
		}
		System.out.println(Arrays.toString(cost));
		for(int i= N-1;i>=0;i--) {
			if(cost[i]>0) {
				for(int j = i+1;j<N;j++) {
					if(graph[i][j]) {
						cost[i] = Math.max(cost[i], cost[j]+1);
					}
				}
				System.out.println(i+" "+cost[i]);
			}
		}
		
		System.out.println(Arrays.toString(cost));
		System.out.println(cost[0]);
		
	}
}
