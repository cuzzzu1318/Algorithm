package mar_2023;

/*  N*M크기의 행렬 A와 M*K크기의 행렬 B를 곱하는 프로그램
 * 행렬곱 원리에서 뇌정지와서 오래걸림 ㅠㅠ
 * 난이도 : 실버5
 * 아이디어: 그냥 곱하면 됨
 * 시간복잡도:O(NK)
 * 소요 시간: 19:35~20:00(25min)
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