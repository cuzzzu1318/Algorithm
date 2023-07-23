package algorithm2023.may;

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
		// N*N������ �ٴ�, +2�� ���ְ� -1�� ä�� �е�
		for (int i = 0; i < N + 2; i++) {
			Arrays.fill(sea[i], -1);
		}
		idx shark = new idx();
		// ���� ����� ��ġ ��ǥ�� ����� �ε���
		int size = 2;
		// ������ ������ 2
		int fish = 0;
		// �ݺ����� ������ �� ����� ��
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				sea[i][j] = Integer.parseInt(st.nextToken());
				if (sea[i][j] == 9) {
					// �ش� ������ ������ 9��� ����� ��ġ�̹Ƿ� ��� �ε��� �ʱ�ȭ
					sea[i][j] = 0;
					shark.x = i;
					shark.y = j;
				} else if (sea[i][j] > 0) {
					// 9�� �ƴϰ� 0���� ũ�ٸ� ������� �����̹Ƿ� ����� ���� +
					fish++;
				}
			}
		}
		int time = 0;
		// �ҿ�Ǵ� �ð�����

		int ate = 0;
		// ũ��� ���� ���� ����⸦ �Ծ����� Ȯ���ϱ� ���� ���� ����� ��
		loop: while (fish > 0) {
			// ����Ⱑ �ִٸ� �ݺ�
			Queue<idx> q = new LinkedList<>();
			boolean[][] v = new boolean[N + 2][N + 2];
			q.add(shark);
			v[shark.x][shark.y] = true;
			int curtime = 0;
			// ���� ��ǥ�κ��� ��ü Ž���ϴµ� �ɸ��� �ð�
			while (!q.isEmpty()) {
				// BFS
				int sz = q.size();
				// ���̸� ����ϱ� ���� ť�� �����ŭ �ݺ�
				curtime++;
				PriorityQueue<idx> eat = new PriorityQueue<>((e1, e2) -> {
					/*
					 * �Ÿ��� �����鼭 ���� �� �ִ� �������� �����ϱ� ���� ť.
					 * �� ������ �����, �׷� ����Ⱑ ����������� ���� ������ ����Ⱑ �켱
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
							//-1�̰ų� ũ�⺸�� ũ�� �湮�� �� ���� -> �湮ó�� �� ���� ��ǥ Ž��
							v[x][y] = true;
							continue;
						}
						if (!v[x][y]) {
							//�湮���� ���� ��쿡 �湮ó�� �� ť�� ����.
							v[x][y] = true;
							q.add(new idx(x, y));
							if (sea[x][y] > 0 && sea[x][y] < size) {
								//���� �� �ִ� ��� eatť�� ����
								eat.add(new idx(x, y));
							}
						}
					}
				}
				if (eat.size() > 0) {
					//���� �� �ִ� ����Ⱑ �ִ� ���
					shark = eat.poll();
					//���� �켱������ �Ǵ� ������� ��ǥ�� ��� �̵�.
					sea[shark.x][shark.y] = 0;
					//����⸦ �Ծ����� �ش� ��ġ�� 0���� �ʱ�ȭ
					ate++;
					//���� ���� +
					fish--;
					//����� ���� -
					if (ate == size) {
						//ũ�� ��ŭ �Ծ����� ũ�� �����ϰ� ate �ʱ�ȭ
						size++;
						ate = 0;
					}
					time += curtime;
					//����⸦ ���� �� �־����Ƿ� �ð� �����ְ� �ش� ��ǥ�κ��� �ٽ� BFS�����ϱ� ���� loop ����.
					continue loop;
				}
			}
			//���� �� �ִ� ����Ⱑ ������ ����̹Ƿ� ����� ���� 0���� �ٲ� �ݺ��� ����
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