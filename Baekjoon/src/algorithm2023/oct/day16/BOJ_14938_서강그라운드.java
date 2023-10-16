package algorithm2023.oct.day16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14938_서강그라운드 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static StringTokenizer st;
	static StringBuilder sb =new  StringBuilder();
	
	static int n,m,r, item[], map[][];
	
	public static void main(String[] args) throws Exception{
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		item = new int[n];
		map = new int[n][n];
		
		st = new StringTokenizer(br.readLine());
		for(int i =0;i<n;i++) {
			item[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i =0;i<r;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			map[s][e] = l;
		}
		
		for(int i =0;i<n;i++) {
			for(int j= 0;j<n;j++) {
				for(int k =0 ;k<n;k++) {
					map[i][j] = Math.max(map[i][j], map[i][k]+map[k][j]);
				}
			}
		}
		
		
	}
}
