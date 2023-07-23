package algorithm2023.mar;

/*  N*N �濡�� ���� ���ؼ� ���� �� �ִ� �ڸ� ã��
 * ���̵� : �ǹ� 5
 * ���̵��: 
 * �ð����⵵:
 * �ҿ� �ð�: 12:50 ~  13:25
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
					// �� ����--0���� ǥ��
					room[i][j] = 0;
				} else {
					// ���� ����--1�� ǥ��
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
					//System.out.println(i+ " "+j+"�� or 1");
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