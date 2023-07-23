package algorithm2023.may;

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
		//���� ������ �ִ� ����, �е� �۾�����
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
		//1�⸶�� ���� ���̱�
		int[][] temp = new int[N+2][M+2];
		//���� ��ƾ� �ϹǷ� ������ �� ����
		int mass = mass();
		//����� ��
		if(mass>1) {
			//����� 2�� �̻��̶�� ����
			return;
		}
		if(mass==0) {
			//�ٳ�Ҵٸ� 0 ���
			year = 0;
			return;
		}
		year++;
		//�쿩�� �ϹǷ� 1�� �߰�
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				temp[i][j] = map[i][j];
				//�ӽ� ������ �ʱⰪ ����
				if (map[i][j] > 0) {
					//���ϰ� �ִٸ� 
					for (int d = 0; d < 4; d++) {
						//���� �¿츦 Ž���Ͽ� ���� ���̱�
						int x = i + dx[d];
						int y = j + dy[d];
						if (map[x][y] == 0) {
							temp[i][j]--;
							if (temp[i][j] == 0) {
								//�� ��Ҵٸ� �� ������ �ʰ� ����
								break;
							}
						}
					}
				}
			}
		}
		map = temp;
		//������ �� ����
		melt();
	}

	static int mass() {
		//��� ī��Ʈ �Լ�.
		//BFS�� �Ͼ Ƚ�� ��ŭ ī��Ʈ.
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