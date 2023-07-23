package algorithm2023.may;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G4_BOJ14499_0524 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		// ������ ���� ũ��
		int M = Integer.parseInt(st.nextToken());
		// ������ ���� ũ��
		int x = Integer.parseInt(st.nextToken())+1;
		int y = Integer.parseInt(st.nextToken())+1;
		// �ֻ����� ���� ��ǥ x, y
		int K = Integer.parseInt(st.nextToken());
		// ��ɾ��� ����

		int[][] map = new int[N + 2][M + 2];
		// ����
		for (int i = 0; i < N + 2; i++) {
			Arrays.fill(map[i], -1);
		}
		// �е��۾�
		
		
		int top = 0;
		//��ܿ� ���� ��
		int[] ud = { 0, 0 };
		//��� ���� �� �Ͽ� ���� ��
		int[] lr = { 0, 0 };
		//��� ���� �� �쿡 ���� ��
		int bottom = 0;
		//�ٴڿ� ���� ��

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// ���� �Է�

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < K; i++) {
			int func = Integer.parseInt(st.nextToken()) - 1;
			x = x + dx[func];
			y = y + dy[func];
			//���� ������ ��ǥ
			if (map[x][y] == -1) {
				//�������� -1�� ��� -> ������ ���̹Ƿ� �̵��� ����ϰ� ���� �̵������ ����
				x-=dx[func];
				y-=dy[func];
				continue;
			}
			int temp = top;
			//��� �� �ӽ�����
			// ���⺤�� �迭�� ����ϱ� ���� �ε��� ���ٿ� �����ϵ��� 0���� 3������ ������ ����
			switch (func) {
			//�̵���Ű�鼭 �ֻ����� �� ����
			case 0:
				top = lr[0];
				lr[0] = bottom;
				bottom = lr[1];
				lr[1] = temp;
				break;
			case 1:
				top = lr[1];
				lr[1] = bottom;
				bottom = lr[0];
				lr[0] = temp;
				break;
			case 2:
				top = ud[1];
				ud[1] = bottom;
				bottom = ud[0];
				ud[0] = temp;
				break;
			case 3:
				top = ud[0];
				ud[0] = bottom;
				bottom = ud[1];
				ud[1] = temp;
				break;
			}
			if(map[x][y]==0) {
				//������ ���� ���� 0�ΰ�� �ֻ��� �ٴ��� �� ����
				map[x][y] = bottom;
			}else {
				//0�� �ƴ� ��� �ֻ����� �����ϰ� �ٴ� 0���� �ʱ�ȭ
				bottom = map[x][y];
				map[x][y] = 0;
			}
			System.out.println(top);
		}
	}
}