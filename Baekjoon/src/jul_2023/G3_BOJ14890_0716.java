package jul_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G3_BOJ14890_0716 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int L;
	static int[][] map;
	static int cnt = 0;
	static int cntSlope = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		L = Integer.parseInt(s[1]);
		map = new int[N][N];
		// N*N의 지도

		for (int i = 0; i < N; i++) {
			s = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(s[j]);
			}
		}
		// 여기까지 입력

		// 위에서 아래로 가는 길
		loop:
		for (int x = 0; x < N; x++) {
			cntSlope = 0;
			for (int y = 1; y < N; y++) {
				int cur = map[y-1][x];
				int next = map[y][x];
				int diff = cur - next;
				switch (diff) {
				case 1:
					if(cntSlope!=0) {
						continue loop;
					}else {
						cntSlope++;
					}
					break;
				case -1:
					if(cntSlope!=0) {
						continue loop;
					}else {
						
					}
					break;
				case 0:
					if(cntSlope!=0) {
						if(cntSlope>0) {
							cntSlope++;
						}else {
							cntSlope--;
						}
					}
					break;
				default:
					continue loop;
				}
				if(Math.abs(cntSlope)==L) {
					cntSlope = 0;
				}
			}
			cnt++;
			System.out.println(x);
		}
		System.out.println(cnt);

	}
}