package algorithm2023.aug.day17;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260_DFS와BFS {
	static int N, M, V;
	static boolean[][] graph;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		graph = new boolean[N+1][N+1];
		for(int i = 0;i<M;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a][b] = true;
			graph[b][a]  = true;
		}
		DFS(V,new boolean[N+1]);
		sb.append("\n");
		
		Queue<Integer> q = new LinkedList<>();
		q.add(V);
		boolean[] v = new boolean[N+1];
		v[V] = true;
		while(!q.isEmpty()) {
			int cur = q.poll();
			sb.append(cur).append(" ");
			for(int i = 1;i<=N;i++) {
				if(graph[cur][i]) {
					if(v[i])continue;
					q.offer(i);
					v[i] = true;
				}
			}
		}
		System.out.println(sb);
		
	}
	
	static void DFS(int cur, boolean[] v) {
		sb.append(cur).append(" ");
		v[cur] = true;
		for(int i =1;i<=N;i++) {
			if(graph[cur][i]) {
				if(v[i])continue;
				DFS(i,v);
			}
		}
	}
}
