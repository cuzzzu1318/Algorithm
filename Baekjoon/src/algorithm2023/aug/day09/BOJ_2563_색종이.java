package algorithm2023.aug.day09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2563_색종이 {
	static int N;
	static boolean[][] paper = new boolean[100][100];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for(int i =0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			for(int y = a;y<a+10;y++) {
				for(int x = b;x<b+10;x++) {
					paper[y][x] =true;
				}
			}
		}
		int cnt = 0;
		for(int i =0;i<100;i++) {
			for(int j= 0;j<100;j++) {
				if(paper[i][j])cnt++;
			}
		}System.out.println(cnt);
	}
}
