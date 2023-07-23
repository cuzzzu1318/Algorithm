package algorithm2023.may;

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
		//�е�

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] > 0 && map[i][j] < 6) {
					cam.add(new cctv(i, j, map[i][j]));
					//cctv�� ���� ����
				}
				if(map[i][j]>0) {
					//������ �� ���� ĭ�̸� -1�� �����Ͽ� ���� ī��Ʈ�� ������� �ʵ��� ��.
					view[i][j]=-1;
				}
			}
		}
		
		watch(0);
		//ù��° cctv���� Ž��
		
		System.out.println(min);
	}

	static void watch(int idx) {
		//Ž�� �Լ�
		if(idx>=cam.size()) {
			//��� cctv�� Ž���ߴٸ� �ּڰ� ���� �� ����
			min = Math.min(min, count());
			return;
		}
		cctv cctv = cam.get(idx);
		//�ش� �ε����� cctv
		
		for (int i = 0; i < 4; i++) {
			switch (cctv.num) {
			//cctv��ȣ�� ���� Ž�� �� ���� �ε��� cctv�� �̵�. Ž���� �����ٸ� ���ð����� ���� �ٽ� �ʱ�ȭ
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
		//�簢������ ī��Ʈ �Լ�
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
		//cctv�� ���⿡ ���� ���� �������� ���
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
		//������ ���� �ٽ� �������� �Լ�
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