package algorithm2023.aug.day22;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10830_행렬제곱 {
	static int N, matrix[][], temp[][];
	static long B;
	
	static StringBuilder sb = new StringBuilder();
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N  = Integer.parseInt(st.nextToken());
		B = Long.parseLong(st.nextToken());
		matrix = new int[N][N];
		
		for(int i=0 ;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j= 0;j<N;j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(sb);
		
		
	}
	

	
	
}
