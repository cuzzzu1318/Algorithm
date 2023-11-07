package algorithm2023.nov.day07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16967_배열복원하기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int H, W, X, Y, B[][];
	public static void main(String[] args) throws Exception{
		
		st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		
		B = new int[H+X][W+Y];
		for(int i = 0;i<H+X;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j= 0;j<W+Y;j++) {
				B[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
	}
}
