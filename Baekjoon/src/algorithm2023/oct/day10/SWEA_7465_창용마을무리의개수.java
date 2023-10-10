package algorithm2023.oct.day10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_7465_창용마을무리의개수 {
	static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N, M;
	
	static int parent[];
	
	static int find(int x) {
		if(parent[x]==x)return x;
		return parent[x] = find(parent[x]);
	}
	
	static boolean union(int x, int y) {
		int px = find(x);
		int py = find(y);
		
		if(px==py)return false;
		
		parent[px] = py;
		return true;
	}
	
	public static void main(String[] args) throws Exception{
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1;t<=T;t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			parent = new int[N+1];
			for(int i =0;i<=N;i++) {
				parent[i] = i;
			}
			
			for(int i =0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				union(a,b);
			}
			
			boolean[] v = new boolean[N+1];
			v[0] = true;
			int cnt =0 ;
			for(int i =1;i<=N;i++) {
				if(!v[find(i)]) {
					cnt++;
					v[find(i)] =  true;
				}
			}
			
			sb.append("#").append(t).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
		
	}
}
