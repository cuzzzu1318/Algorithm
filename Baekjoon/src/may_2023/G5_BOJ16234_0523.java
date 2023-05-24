package may_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G5_BOJ16234_0523 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] map = new int[N + 2][N + 2];
		//지역의 인구수를 저장하는 지도 배열. 패딩을 위해 +2 해줌.

		for (int i = 0; i < N + 2; i++) {
			Arrays.fill(map[i], -1);
		}
		//패딩한 지역 -1로 채움. -> 사용하지 않는 인덱스

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//입력 완료
		
		int days = 0;
		//소요 일 수 
		
		
		while (true) {
			//계속 반복. 인구이동이 일어나지 않으면 종료.
			boolean[][] v = new boolean[N + 2][N + 2];
			boolean canOpen = false;
			//인구이동이 일어날 수 있는지 확인하는 Flag

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					//모든 좌표를 확인
					if (!v[i][j]) {
						//방문하지 않았다면 BFS실행. 
						Queue<idx> q = new LinkedList<>();
						ArrayList<idx> union = new ArrayList<>();
						q.add(new idx(i, j));
						v[i][j] = true;
						int cnt = 1;
						//연합의 나라 수
						int sum = map[i][j];
						//연합의 인구 수 총합
						union.add(new idx(i,j));
						//시작 국가부터 연합에 포함
						while (!q.isEmpty()) {
							idx cur = q.poll();
							for (int d = 0; d < 4; d++) {
								//방향벡터를 따라 탐색
								int x = cur.x + dx[d];
								int y = cur.y + dy[d];
								int diff = Math.abs(map[x][y] - map[cur.x][cur.y]);
								//인구수 차이
								if (map[x][y] == -1) {
									continue;
								}
								if (!v[x][y] && diff >= L && diff <= R) {
									//방문하지 않았고 인구수 차이가 L이상 R이하라면
									v[x][y] = true;
									canOpen = true;
									//인구이동이 일어났다고 표시
									cnt++;
									sum+=map[x][y];
									union.add(new idx(x,y));
									//연합에 넣어주고 인구수와 카운트 증가
									q.add(new idx(x,y));
								}
							}
						}
						for(idx c : union) {
							//연합의 인구수 조정
							map[c.x][c.y] = sum/cnt; 
						}
					}
				}
			}
			if(canOpen) {
				//인구이동이 일어났다면 일 수 증가
				days++;
			}else {
				//일어나지 않았다면 반복문 종료
				break;
			}
		}
		System.out.println(days);
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