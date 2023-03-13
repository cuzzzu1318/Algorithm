package unResolved;

/*  
 * 난이도 : 
 * 아이디어: 
 * 시간복잡도:
 * 소요 시간: 14:45~
 * */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ16234_0313 {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int L = Integer.parseInt(s[1]);
		int R = Integer.parseInt(s[2]);
		int[][] country = new int[N][N];
		for (int i = 0; i < N; i++) {
			s = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				country[i][j] = Integer.parseInt(s[j]);
			}
		}
		
	}
}