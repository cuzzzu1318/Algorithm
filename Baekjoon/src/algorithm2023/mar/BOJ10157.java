package algorithm2023.mar;

/*  ���ʾƷ����� �������� �¼� ��ȣ�� �ð�������� ������ �ٶ� ����ȣ K�� ������ �¼���ȣ
 * ���̵� : �ǹ�4
 * ���̵��: ������
 * �ð����⵵:
 * �ҿ� �ð�: 14:10~ 
 * */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ10157 {

	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] s = br.readLine().split(" ");
		int C = Integer.parseInt(s[0]);
		// ����
		int R = Integer.parseInt(s[1]);
		// ����
		int K = Integer.parseInt(br.readLine());
		// ����ȣ
		if (K > R * C) {
			bw.write("0");
		} else {
			int[][] hall = new int[R][C];
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					hall[i][j] = 0;
				}
			}
			int x = R - 1;
			int y = 0;
			// ó�� �����Ǵ� �ڸ� ���� �Ʒ�
			int d = 0;
			// ���⺤�� �ε���

			for (int i = 1; i <= K; i++) {
				hall[x][y] = i;
				if (i == K) {
					break;
				}
				int nextX = x + dx[d];
				int nextY = y + dy[d];
				if (nextX >= R || nextX < 0 || nextY >= C || nextY < 0 || hall[nextX][nextY] != 0) {
					d++;
					if (d > 3) {
						d = 0;
					}
					nextX = x + dx[d];
					nextY = y + dy[d];
				}
				x = nextX;
				y = nextY;
			}
		/*
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					bw.write(hall[i][j] + " ");
				}
				bw.write("\n");
			}
			*/
			int temp = x;
			x = y + 1;
			y = R - temp;
			bw.write(x + " " + y + "\n");
		}
		bw.flush();
		bw.close();
	}
}