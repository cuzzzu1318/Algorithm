package unResolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ14502 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		int[][] lab = new int[N][M];
		
		for(int i = 0;i<N;i++) {
			s = br.readLine().split(" ");
			for(int j =0;j<M;j++) {
				lab[i][j] = Integer.parseInt(s[j]);
			}
		}
		for(int[] arr : lab) {
			for(int a : arr) {
				System.out.print(a);
			}
			System.out.println("");
		}
	}
}
