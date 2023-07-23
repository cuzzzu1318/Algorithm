package algorithm2023.may;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class G4_BOJ17144_0529 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int R;
	static int C;
	static int T;

	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		map = new int[R + 2][C + 2];

		int[] clean = { 0, 0 };
		int c = 0;

		for (int i = 0; i < R + 2; i++) {
			Arrays.fill(map[i], -1);
		}
		
		
		
		for (int i = 1; i <= R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1) {
					//����û������ ��ġ
					clean[c++] = i;
				}
			}
		}

		for (int i = 0; i < T; i++) {
			LinkedList<idx> dust = new LinkedList<>();
			find(dust);
			//������ ��ġ ã��
			spread(dust);
			//���� �۶߸���
			clean(clean);
			//����û���� ����
			
		}
		System.out.println(count());

		

	}

	static void print(int[] clean) {
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	static void find(LinkedList<idx> dust) {
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				if (map[i][j] > 0) {
					//�̼������� ������ ����
					dust.add(new idx(i, j, map[i][j]));
				}
			}
		}
	}

	static void spread(LinkedList<idx> dust) {
		for (idx idx : dust) {
			int spread = idx.dust / 5;
			//������ ������ �� �ʱ� ���� ���� /5�� ���� ���
			for (int d = 0; d < 4; d++) {
				int x = idx.x + dx[d];
				int y = idx.y + dy[d];
				if (map[x][y] != -1) {
					//�۶߸��� �ֵ��� �۶߸��� �ش� ���� ���� �� ����
					map[x][y] += spread;
					map[idx.x][idx.y] -= spread;
				}
			}
		}
	}

	static void clean(int[] clean) {
		//����û����(���ʱ���)
		for (int i = clean[0]-1; i > 1; i--) {
			map[i][1] = map[i - 1][1];
		}
		for (int i = 1; i < C; i++) {
			map[1][i] = map[1][i + 1];
		}
		for (int i = 1; i < clean[0]; i++) {
			map[i][C] = map[i + 1][C];
		}
		for (int i = C; i > 1; i--) {
			if (i == 2) {
				map[clean[0]][i] = 0;
			} else {
				map[clean[0]][i] = map[clean[0]][i - 1];
			}
		}

		//����û����(�Ʒ��� ����)
		for (int i = clean[1]+1; i < R; i++) {
			map[i][1] = map[i + 1][1];
		}
		for (int i = 1; i < C; i++) {
			map[R][i] = map[R][i + 1];
		}
		for (int i = R; i > clean[1]; i--) {
			map[i][C] = map[i - 1][C];
		}
		for (int i = C; i > 1; i--) {
			if (i == 2) {
				map[clean[1]][i] = 0;
			} else {
				map[clean[1]][i] = map[clean[1]][i - 1];
			}
		}
	}

	static int count() {
		//�̼����� ī��Ʈ
		int cnt = 0;
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				if (map[i][j] > 0) {
					cnt += map[i][j];
				}
			}
		}
		return cnt;
	}

	static class idx {
		int x;
		int y;
		int dust;

		idx(int x, int y, int dust) {
			this.x = x;
			this.y = y;
			this.dust = dust;
		}
	}
}