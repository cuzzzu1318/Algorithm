package may_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G4_BOJ2537_0528 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int N;
	static int M;
	static int[][] map;
	static int year = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 2][M + 2];
		//빙산 정보가 있는 지도, 패딩 작업까지
		for (int i = 0; i < N + 2; i++) {
			Arrays.fill(map[i], -1);
		}
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		melt();
		System.out.println(year);
	}

	static void melt() {
		//1년마다 빙산 녹이기
		int[][] temp = new int[N+2][M+2];
		//따로 녹아야 하므로 별도의 맵 저장
		int mass = mass();
		//덩어리의 수
		if(mass>1) {
			//덩어리가 2개 이상이라면 종료
			return;
		}
		if(mass==0) {
			//다녹았다면 0 출력
			year = 0;
			return;
		}
		year++;
		//녹여야 하므로 1년 추가
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				temp[i][j] = map[i][j];
				//임시 지도에 초기값 저장
				if (map[i][j] > 0) {
					//빙하가 있다면 
					for (int d = 0; d < 4; d++) {
						//상하 좌우를 탐색하여 빙하 녹이기
						int x = i + dx[d];
						int y = j + dy[d];
						if (map[x][y] == 0) {
							temp[i][j]--;
							if (temp[i][j] == 0) {
								//다 녹았다면 더 녹이지 않고 종료
								break;
							}
						}
					}
				}
			}
		}
		map = temp;
		//지도의 값 변경
		melt();
	}

	static int mass() {
		//덩어리 카운트 함수.
		//BFS가 일어난 횟수 만큼 카운트.
		boolean[][] v = new boolean[N + 2][M + 2];
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (!v[i][j]&&map[i][j] != 0) {
					cnt++;
					Queue<idx> q = new LinkedList<>();
					q.add(new idx(i, j));
					v[i][j] =true;
					while(!q.isEmpty()) {
						idx cur = q.poll();
						for(int d = 0;d<4;d++) {
							int x = cur.x+dx[d];
							int y = cur.y+dy[d];
							if(!v[x][y]&&map[x][y]>0) {
								q.offer(new idx(x,y));
								v[x][y] = true;
							}
						}
					}
				}
			}
		}
		return cnt;
	}

	static class idx {
		int x;
		int y;

		idx(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}