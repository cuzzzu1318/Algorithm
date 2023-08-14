package algorithm2023.aug.day14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1992_쿼드트리 {
	static int N;
	static int[][] video;
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		video = new int[N][N];
		for(int i= 0;i<N;i++) {
			String[] s = br.readLine().split("");
			for(int j = 0;j<N;j++) {
				video[i][j] = Integer.parseInt(s[j]);
			}
		}
		comp(0,0,N,N);
		System.out.println(sb);
	}
	
	static void comp(int y1, int x1, int y2, int x2) {
		int compN = video[y1][x1];
		for(int y = y1;y<y2;y++) {
			for(int x = x1;x<x2;x++) {
				if(compN!=video[y][x]) {
					sb.append("(");
					comp(y1,x1, (y1+y2)/2, (x1+x2)/2);
					comp(y1,(x1+x2)/2, (y1+y2)/2, x2);
					comp((y1+y2)/2,x1, y2, (x1+x2)/2);
					comp((y1+y2)/2,(x1+x2)/2, y2, x2);
					sb.append(")");
					return;
				}
			}
		}
		sb.append(compN);
		
	}
}
