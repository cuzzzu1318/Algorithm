package algorithm2023.aug.day14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17471_게리맨더링 {
	static int N, popul[];
	static boolean graph[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		popul = new int[N];
		graph = new boolean[N][N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			popul[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int M = Integer.parseInt(st.nextToken());
			for (int j = 0; j < M; j++) {
				int nb = Integer.parseInt(st.nextToken())-1;
				graph[i][nb] = true;
			}
		}
		
		
		
	}
	
}
