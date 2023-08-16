package algorithm2023.aug.day14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17471_게리맨더링 {
	static int N, popul[];
	static boolean graph[][];
	static boolean[] v;
	static int min = Integer.MAX_VALUE;
	static int bm = 1<<N;

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
				int nb = Integer.parseInt(st.nextToken()) - 1;
				graph[i][nb] = true;
			}
		}
		for(int i =1;i<bm;i++) {
			
		}
		
		
	}
	
	static void red(int start) {
		Queue<Integer> red = new LinkedList<>();
		red.add(start);
		v[start]  =true;
		while(!red.isEmpty()) {
			int cur = red.poll();
			for(int i= 0;i<N;i++) {
				if(graph[cur][i]) {
					if(!v[i]) {
						red.offer(i);
						v[i]  = true;
					}
				}
			}
		}
		
	}
	
//	static boolean check() {
//		
//	}
}
