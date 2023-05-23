package may_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class G3_BOJ16236_0523 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		int[][] sea = new int[N + 2][N + 2];
		// N*N공간의 바다, +2를 해주고 -1로 채워 패딩
		for (int i = 0; i < N + 2; i++) {
			Arrays.fill(sea[i], -1);
		}
		idx shark = new idx();
		// 현재 상어의 위치 좌표가 저장된 인덱스
		int size = 2;
		// 최초의 사이즈 2
		int fish = 0;
		// 반복문의 기준이 될 물고기 수
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				sea[i][j] = Integer.parseInt(st.nextToken());
				if (sea[i][j] == 9) {
					// 해당 공간의 정보가 9라면 상어의 위치이므로 상어 인덱스 초기화
					sea[i][j] = 0;
					shark.x = i;
					shark.y = j;
				} else if (sea[i][j] > 0) {
					// 9가 아니고 0보다 크다면 물고기의 정보이므로 물고기 개수 +
					fish++;
				}
			}
		}
		int time = 0;
		// 소요되는 시간정보

		int ate = 0;
		// 크기와 같은 수의 물고기를 먹었는지 확인하기 위한 먹은 물고기 수
		loop: while (fish > 0) {
			// 물고기가 있다면 반복
			Queue<idx> q = new LinkedList<>();
			boolean[][] v = new boolean[N + 2][N + 2];
			q.add(shark);
			v[shark.x][shark.y] = true;
			int curtime = 0;
			// 현재 좌표로부터 전체 탐색하는데 걸리는 시간
			while (!q.isEmpty()) {
				// BFS
				int sz = q.size();
				// 깊이를 계산하기 위해 큐의 사이즈만큼 반복
				curtime++;
				PriorityQueue<idx> eat = new PriorityQueue<>((e1, e2) -> {
					/*
					 * 거리가 같으면서 먹을 수 있는 물고기들을 정렬하기 위한 큐.
					 * 더 위쪽의 물고기, 그런 물고기가 여러마리라면 가장 왼쪽의 물고기가 우선
					 */
					if (e1.x > e2.x) {
						return e1.x - e2.x;
					} else {
						if (e1.x == e2.x) {
							return e1.y - e2.y;
						}
						return e1.x - e2.x;
					}
				});
				for (int s = 0; s < sz; s++) {
					idx cur = q.poll();
					for (int i = 0; i < 4; i++) {
						int x = cur.x + dx[i];
						int y = cur.y + dy[i];
						if (sea[x][y] == -1 || sea[x][y] > size) {
							//-1이거나 크기보다 크면 방문할 수 없음 -> 방문처리 후 다음 좌표 탐색
							v[x][y] = true;
							continue;
						}
						if (!v[x][y]) {
							//방문하지 않은 경우에 방문처리 후 큐에 넣음.
							v[x][y] = true;
							q.add(new idx(x, y));
							if (sea[x][y] > 0 && sea[x][y] < size) {
								//먹을 수 있는 경우 eat큐에 삽입
								eat.add(new idx(x, y));
							}
						}
					}
				}
				if (eat.size() > 0) {
					//먹을 수 있는 물고기가 있는 경우
					shark = eat.poll();
					//가장 우선순위가 되는 물고기의 좌표로 상어 이동.
					sea[shark.x][shark.y] = 0;
					//물고기를 먹었으니 해당 위치를 0으로 초기화
					ate++;
					//먹은 개수 +
					fish--;
					//물고기 개수 -
					if (ate == size) {
						//크기 만큼 먹었으면 크기 증가하고 ate 초기화
						size++;
						ate = 0;
					}
					time += curtime;
					//물고기를 먹을 수 있었으므로 시간 더해주고 해당 좌표로부터 다시 BFS실행하기 위해 loop 실행.
					continue loop;
				}
			}
			//먹을 수 있는 물고기가 없었던 경우이므로 물고기 개수 0으로 바꿔 반복문 종료
			fish = 0;
		}
		System.out.println(time);

	}

	static class idx {
		int x;
		int y;

		idx(int x, int y) {
			this.x = x;
			this.y = y;
		}

		idx() {
			this.x = 0;
			this.y = 0;
		}
	}

}