package may_2023;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class S2_BOJ2630_0502 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int[][] paper;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		paper = new int[N][N];
		for(int i = 0;i<N;i++) {
			String[] s = br.readLine().split(" ");
			for(int j =0;j<N;j++) {
				paper[i][j] = Integer.parseInt(s[j]);
			}
		}
		//입력
		int[] idx = {0,0};
		//시작 인덱스
		int[] papers = isPaper(paper, idx, N);
		//종이 개수 반환
		sb.append(papers[0]+"\n");
		sb.append(papers[1]+"\n");
		System.out.println(sb);
	}
	
	static int[] isPaper(int[][] paper, int[] start, int l) {
		int cnt[] = new int[2];
		// 0, 1 세가지 경우를 모두 저장하기 위한 배열
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
			// 하나의 종이라면 해당 값에 저장
			cnt[n]++;
		} else {
			// 하나의 종이가 아니라면 4등분
			for (int i = start[0]; i < start[0] + l; i += l / 2) {
				for (int j = start[1]; j < start[1] + l; j += l / 2) {
					int[] temp = { i, j };
					temp = isPaper(paper, temp, l / 2);
					// i,j부터 l/2길이만큼이 종이로 다시 재귀
					cnt[0] += temp[0];
					cnt[1] += temp[1];
				}
			}
		}
		return cnt;

	}
}