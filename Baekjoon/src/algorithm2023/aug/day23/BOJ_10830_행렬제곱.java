package algorithm2023.aug.day23;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
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
				matrix[i][j] = Integer.parseInt(st.nextToken())%1000;
			}
		}
		
		int[][] ans = matPow(B);
		
		for(int i= 0;i<N;i++) {
			for(int j= 0;j<N;j++) {
				sb.append(ans[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		
		System.out.println(sb);
	}

	static int[][] matPow(long n) {
		int[][] ret;
		if (n == 1)
			return matrix;

		if (n % 2 == 0) {
			int[][] a = matPow(n / 2);
			ret = matMul(a, a);
		} else {
			int[][] a = matPow((n - 1) / 2);
			ret = matMul(a, a);
			ret = matMul(ret, matrix);
		}
		return ret;
	}

	static int[][] matMul(int[][] a, int[][] b) {
		int[][] ret = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					ret[i][j] += a[i][k] * b[k][j];
				}
				ret[i][j] %= 1000;
			}
		}
		return ret;
	}

}
