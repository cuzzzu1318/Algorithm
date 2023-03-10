package mar_2023;

/*  N*N 방에서 짐을 피해서 누울 수 있는 자리 찾기
 * 난이도 : 실버 5
 * 아이디어: 
 * 시간복잡도:
 * 소요 시간: 12:50 ~  13:25
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ1652 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] room = new int[N][N];
		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				if (s[j].equals(".")) {
					// 빈 공간--0으로 표시
					room[i][j] = 0;
				} else {
					// 짐이 있음--1로 표시
					room[i][j] = 1;
				}
			}
		}
		int cnt = 0;
		int ver = 0;
		int hor = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (room[i][j] == 0) {
					cnt++;
				}
				if (room[i][j] == 1 || j == N - 1) {
					if(cnt>=2) {
						ver++;
						//System.out.println(i+" "+j+" "+cnt+" "+ver);
					}
					cnt=0;
				}
				
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(room[j][i]==0) {
					cnt++;
				}
				if(room[j][i]==1||j==N-1) {
					//System.out.println(i+ " "+j+"끝 or 1");
					if(cnt>=2) {
						hor++;
						//System.out.println(i+" "+j+" "+cnt+" "+hor);
					}
					cnt=0;
				}
				
			}
		}
		System.out.println(ver + " " + hor);

		/*
		 * for(int[] arr : room) { for(int n : arr) { System.out.print(n); }
		 * System.out.println(); }
		 */
	}
}