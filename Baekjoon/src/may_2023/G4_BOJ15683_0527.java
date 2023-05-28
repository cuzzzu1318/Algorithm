package may_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class G4_BOJ15683_0527 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int N;
	static int M;
	static int[][] map;
	static int[][] view;
	static LinkedList<cctv> cam = new LinkedList<>();
	static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		min = N*M;
		map = new int[N + 2][M + 2];
		view = new int[N+2][M+2];
		for (int i = 0; i < N + 2; i++) {
			Arrays.fill(map[i], -1);
		}
		//패딩

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] > 0 && map[i][j] < 6) {
					cam.add(new cctv(i, j, map[i][j]));
					//cctv의 정보 저장
				}
				if(map[i][j]>0) {
					//감시할 수 없는 칸이면 -1로 저장하여 추후 카운트에 집계되지 않도록 함.
					view[i][j]=-1;
				}
			}
		}
		
		watch(0);
		//첫번째 cctv부터 탐색
		
		System.out.println(min);
	}

	static void watch(int idx) {
		//탐색 함수
		if(idx>=cam.size()) {
			//모든 cctv를 탐색했다면 최솟값 저장 후 종료
			min = Math.min(min, count());
			return;
		}
		cctv cctv = cam.get(idx);
		//해당 인덱스의 cctv
		
		for (int i = 0; i < 4; i++) {
			switch (cctv.num) {
			//cctv번호에 따라 탐색 후 다음 인덱스 cctv로 이동. 탐색이 끝났다면 감시가능한 범위 다시 초기화
			case 1:
				check(cctv, i);
				watch(idx+1);
				remove(cctv, i);
				break;
			case 2:
				if (i > 1) {
					break;
				}
				check(cctv, i);
				check(cctv, (i + 2)%4);
				watch(idx+1);
				remove(cctv, i);
				remove(cctv, (i+2)%4);
				break;
			case 3:
				check(cctv, i);
				check(cctv, (i + 1) % 4);
				watch(idx+1);
				remove(cctv, i);
				remove(cctv, (i + 1) % 4);
				break;
			case 4:
				check(cctv, i);
				check(cctv, (i + 1) % 4);
				check(cctv, (i + 2) % 4);
				watch(idx+1);
				remove(cctv, i);
				remove(cctv, (i + 1) % 4);
				remove(cctv, (i + 2) % 4);
				break;
			case 5:
				if (i == 0) {
					check(cctv, i);
					check(cctv, (i + 1) % 4);
					check(cctv, (i + 2) % 4);
					check(cctv, (i + 3) % 4);
					watch(idx+1);
					remove(cctv, i);
					remove(cctv, (i + 1) % 4);
					remove(cctv, (i + 2) % 4);
					remove(cctv, (i + 3) % 4);
				}

			}
		}
	}
	
	static int count() {
		//사각지대의 카운트 함수
		int cnt = 0;
		for(int i= 1;i<=N;i++) {
			for(int j= 1;j<=M;j++) {
				if(view[i][j]==0) {
					cnt++;
				}
			}
		}
		return cnt;
	}

	static void check(cctv cctv, int d) {
		//cctv의 방향에 따라 감시 가능으로 기록
		int x = cctv.x + dx[d];
		int y = cctv.y + dy[d];
		while (map[x][y] != -1 && map[x][y] != 6) {
			
			if (map[x][y] == 0) {
				view[x][y]++;
			}
			x += dx[d];
			y += dy[d];
		}
	}
	
	static void remove(cctv cctv, int d) {
		//감시한 방향 다시 돌려놓는 함수
		int x = cctv.x + dx[d];
		int y = cctv.y + dy[d];
		while (map[x][y] != -1 && map[x][y] != 6) {
			if (view[x][y] >0) {
				view[x][y]--;
			}
			x += dx[d];
			y += dy[d];
		}
	}

	static class cctv {
		int x;
		int y;
		int num;

		cctv(int x, int y, int num) {
			this.x = x;
			this.y = y;
			this.num = num;
		}
	}
}