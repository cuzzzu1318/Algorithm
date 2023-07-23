package algorithm2023.mar;

/*  N*Mũ���� ��� A�� M*Kũ���� ��� B�� ���ϴ� ���α׷�
 * ��İ� �������� �������ͼ� �����ɸ� �Ф�
 * ���̵� : �ǹ�5
 * ���̵��: �׳� ���ϸ� ��
 * �ð����⵵:O(NK)
 * �ҿ� �ð�: 19:35~20:00(25min)
 * */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ2740_0313 {
	static int N;
	static int M;
	static int K;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		int[][] A = new int[N][M];
		for(int i =0;i<N;i++) {
			s = br.readLine().split(" ");
			for(int j = 0;j<M;j++) {
				A[i][j] = Integer.parseInt(s[j]);
			}
		}
		s = br.readLine().split(" ");
		K = Integer.parseInt(s[1]);
		int[][] B = new int[M][K];
		for(int i = 0;i<M;i++) {
			s = br.readLine().split(" ");
			for(int j =0;j<K;j++) {
				B[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		int[][] ans = new int[N][K];
		for(int i = 0;i<N;i++) {
			for(int j =0;j<K;j++) {
				ans[i][j]=0;
				for(int k = 0;k<M;k++) {
					ans[i][j]+=A[i][k]*B[k][j];
				}
			}
		}
		for(int[] arr : ans) {
			for(int n :arr) {
				bw.write(n+" ");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
}