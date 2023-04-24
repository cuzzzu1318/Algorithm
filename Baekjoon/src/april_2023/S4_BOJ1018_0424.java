package april_2023;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S4_BOJ1018_0424 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N;
	static int M;
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				map[i][j] = s[j].equals("W") ? (i + j) % 2 : (i + j + 1) % 2;
				//가로 세로 인덱스의 합이 짝수이면서 값이 W가 아니라면 1 저장
			}
		}
		int min = 64;
		for (int i = 0; i < N - 7; i++) {
			for (int j = 0; j < M - 7; j++) {
				//i,j위치부터 8*8 탐색해서 1의 개수 세고 최솟값 갱신
				min = Math.min(min, count(i, j));
			}
		}
		bw.write(Integer.toString(min));
		bw.flush();
		bw.close();
	}

	static int count(int x, int y) {
		//1의 개수 세는 함수
		int cnt = 0;
		for (int i = x; i < x + 8; i++) {
			for (int j = y; j < y + 8; j++) {
				cnt += map[i][j];
			}
		}
		if (cnt > 32) {
			//절반 이상을 바꿔야 한다면 첫 글자가 "B"인 경우로 계산
			cnt = 64 - cnt;
		}

		return cnt;
	}
}