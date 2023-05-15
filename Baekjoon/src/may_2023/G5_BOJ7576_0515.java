package may_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G5_BOJ7576_0515 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] tomato;
	static int N;
	static int M;

	static class idx {
		int n;
		int m;

		public idx(int n, int m) {
			this.n = n;
			this.m = m;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		tomato = new int[N + 2][M + 2];
		for (int j = 0; j < N + 2; j++) {
			//패딩작업
			Arrays.fill(tomato[j], -1);
		}
		Queue<idx> q = new LinkedList<>();
		//bfs를 진행할 큐
		for (int n = 1; n <= N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int m = 1; m <= M; m++) {
				tomato[n][m] = Integer.parseInt(st.nextToken());
				if (tomato[n][m] == 1) {
					//익은 토마토인 경우 bfs시작노드로 삽입
					idx idx = new idx(n, m);
					q.add(idx);
				}

			}
		}

		while (!q.isEmpty()) {
			//bfs
			idx idx = q.poll();
			for (int i = 0; i < 4; i++) {
				idx next = new idx(idx.n + dx[i], idx.m + dy[i]);
				if (tomato[next.n][next.m] == 0) {
					//주변에 안익은 토마토가 있다면 현재 토마토가 익는데 걸리는 시간 +1을 넣어줌
					q.add(next);
					tomato[next.n][next.m] = tomato[idx.n][idx.m] + 1;
				}
			}
		}
		int max=0;
		loop:
		for (int j = 1; j <= N; j++) {
			for (int k = 1; k <= M; k++) {
				//최대 일수 찾기
				if(tomato[j][k]==0) {
					//아직 안익은 토마토가 있다면 종료
					max = 0;
					break loop;
				}
				if(tomato[j][k]>max) {
					//익은 토마토 중 가장 오래 걸리는 토마토 저장
					max = tomato[j][k];
				}
			}
		}
		max--;
		sb.append(max);
		System.out.println(sb);
	}
}