package algorithm2023.april;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class S3_BOJ1347_0424 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	// �Ʒ��ʺ��� �ð�������� ���� ���⺤��

	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split("");
		// ������ Ƚ���� ������ �Է�

		String[][] map;

		int x = 0;
		int y = 0;
		// ������ ȫ���� ��ġ�� 0,0���� �ʱ�ȭ

		int minX = 0;
		int maxX = 0;
		int minY = 0;
		int maxY = 0;
		// ������ ũ�⸦ ���ϱ� ���� �ּ�, �ִ� ���

		int d = 0;
		// ���⺤�� �ε���

		for (int i = 0; i < N; i++) {
			switch (s[i]) {
			case "R":
				// R�̸� ���⺤�� �ð���� 90�� ȸ��
				d++;
				d %= 4;
				break;
			case "L":
				// L�̸� ���⺤�� �ݽð���� 90�� ȸ��
				d--;	
				if(d<0) {
					d=3;
				}
				break;
			default:
				//F�̸� x�� ��ġ�� �ű�� �ּ�, �ִ� ����.
				x += dx[d];
				y += dy[d];
				minX = Math.min(minX, x);
				minY = Math.min(minY, y);
				maxX = Math.max(maxX, x);
				maxY = Math.max(maxY, y);
			}
		}
		x = 0-minX;
		y = 0-minY;
		//ȫ���̰� ���ִ� ��ġ�� ���
		
		map = new String[maxX-minX+1][maxY-minY+1];
		//������ ũ�� ���
		
		map[x][y]=".";
		//ó�� ȫ���̰� ���ִ� ��Ҹ� �̵��� �� �ִ� ĭ���� ǥ��
		d = 0;
		//���⺤�� �ε��� �ʱ�ȭ
		for (int i = 0; i < N; i++) {
			switch (s[i]) {
			case "R":
				// R�̸� ���⺤�� �ð���� 90�� ȸ��
				d++;
				d %= 4;
				break;
			case "L":
				// L�̸� ���⺤�� �ݽð���� 90�� ȸ��
				d--;if(d<0) {
					d=3;
				}
				break;
			default:
				//F�̸� �̵� �� �̵��� �� �ִ� ĭ ǥ��.
				x += dx[d];
				y += dy[d];
				map[x][y] = ".";
			}
		}
		for(int i = 0;i<map.length;i++) {
			for(int j =0;j<map[0].length;j++) {
				//������ ��ȸ�ϸ�
				if(map[i][j]!=null) {
					//ǥ�õǾ� �ִٸ� .���
					bw.write(".");
				}else {
					//ǥ�õǾ� ���� �ʴٸ� # ���.
					bw.write("#");
				}
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
}