package may_2023;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class S2_BOJ1780_0501 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		// N*N크기의 종이

		int[][] paper = new int[N][N];

		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(s[j]);
			}
		}
		// 종이 값 입력

		int[] idx = { 0, 0 };
		int[] papers = isPaper(paper, idx, N);
		// 시작 인덱스 및 -1,0,1 종이의 개수
		System.out.println(papers[0] + " " + papers[1] + " " + papers[2]);

	}

	static int[] isPaper(int[][] paper, int[] start, int l) {
		int cnt[] = new int[3];
		// -1, 0, 1 세가지 경우를 모두 저장하기 위한 배열
		int n = paper[start[0]][start[1]];
		// 제일 왼쪽 위의 숫자를 기준으로 비교하기 위해 저장
		boolean isPaper = true;
		// 하나의 종이인지 아닌지 판별할 변수
		loop: for (int i = start[0]; i < start[0] + l; i++) {
			for (int j = start[1]; j < start[1] + l; j++) {
				// 종이를 l*l만큼 탐색하며
				if (paper[i][j] != n) {
					// n과 다르다면 하나의 종이가 아니라고 판단 후 루프 종료
					isPaper = false;
					break loop;
				}
			}
		}
		if (isPaper) {
			// 하나의 종이라면 해당 값에 +1, -1부터 시작하기 때문에 n+1에 저장
			cnt[n + 1]++;
		} else {
			// 하나의 종이가 아니라면 9등분
			for (int i = start[0]; i < start[0] + l; i += l / 3) {
				for (int j = start[1]; j < start[1] + l; j += l / 3) {
					int[] temp = { i, j };
					temp = isPaper(paper, temp, l / 3);
					// i,j부터 l/3길이만큼이 종이로 다시 재귀
					cnt[0] += temp[0];
					cnt[1] += temp[1];
					cnt[2] += temp[2];
				}
			}
		}

		return cnt;

	}

}