package algorithm2023.aug.day22;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3289_서로소집합 {
	
	static int[] parent;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t= 1;t<=T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			makeSet(n);
			
			sb.append("#").append(t).append(" ");
			for(int i= 0;i<m;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken())-1;
				int c = Integer.parseInt(st.nextToken())-1;
				
				switch(a) {
				case 0:
					union(b,c);
					break;
				case 1:
					sb.append(findSet(b)==findSet(c)?1:0);
					break;
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static void makeSet(int size) {
		parent = new int[size];
		for(int i = 0;i<size;i++) {
			parent[i] = i;
		}
	}
	
	static int findSet(int x) {
		if(parent[x]==x)return x;
		
		return parent[x] = findSet(parent[x]);
	}
	
	static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		
		if(px==py)return;
		parent[findSet(y)]=findSet(x);
	}
	
	
}
