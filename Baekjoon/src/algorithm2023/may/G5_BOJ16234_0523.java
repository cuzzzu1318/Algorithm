package algorithm2023.may;

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
		//������ �α����� �����ϴ� ���� �迭. �е��� ���� +2 ����.

		for (int i = 0; i < N + 2; i++) {
			Arrays.fill(map[i], -1);
		}
		//�е��� ���� -1�� ä��. -> ������� �ʴ� �ε���

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//�Է� �Ϸ�
		
		int days = 0;
		//�ҿ� �� �� 
		
		
		while (true) {
			//��� �ݺ�. �α��̵��� �Ͼ�� ������ ����.
			boolean[][] v = new boolean[N + 2][N + 2];
			boolean canOpen = false;
			//�α��̵��� �Ͼ �� �ִ��� Ȯ���ϴ� Flag

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					//��� ��ǥ�� Ȯ��
					if (!v[i][j]) {
						//�湮���� �ʾҴٸ� BFS����. 
						Queue<idx> q = new LinkedList<>();
						ArrayList<idx> union = new ArrayList<>();
						q.add(new idx(i, j));
						v[i][j] = true;
						int cnt = 1;
						//������ ���� ��
						int sum = map[i][j];
						//������ �α� �� ����
						union.add(new idx(i,j));
						//���� �������� ���տ� ����
						while (!q.isEmpty()) {
							idx cur = q.poll();
							for (int d = 0; d < 4; d++) {
								//���⺤�͸� ���� Ž��
								int x = cur.x + dx[d];
								int y = cur.y + dy[d];
								int diff = Math.abs(map[x][y] - map[cur.x][cur.y]);
								//�α��� ����
								if (map[x][y] == -1) {
									continue;
								}
								if (!v[x][y] && diff >= L && diff <= R) {
									//�湮���� �ʾҰ� �α��� ���̰� L�̻� R���϶��
									v[x][y] = true;
									canOpen = true;
									//�α��̵��� �Ͼ�ٰ� ǥ��
									cnt++;
									sum+=map[x][y];
									union.add(new idx(x,y));
									//���տ� �־��ְ� �α����� ī��Ʈ ����
									q.add(new idx(x,y));
								}
							}
						}
						for(idx c : union) {
							//������ �α��� ����
							map[c.x][c.y] = sum/cnt; 
						}
					}
				}
			}
			if(canOpen) {
				//�α��̵��� �Ͼ�ٸ� �� �� ����
				days++;
			}else {
				//�Ͼ�� �ʾҴٸ� �ݺ��� ����
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