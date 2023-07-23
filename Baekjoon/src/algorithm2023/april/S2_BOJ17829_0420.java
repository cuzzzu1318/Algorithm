package algorithm2023.april;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S2_BOJ17829_0420 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		pooling(map);
		// N*N ��� �Է� �Ϸ�

	}

	static void pooling(int[][] map) {
		int N = map.length;
		// ���� ����� ���� ���� ����
		if (N == 1) {
			// 1*1 ����̶�� �ش� ���� ���
			System.out.println(map[0][0]);
		} else {
			// 222-Ǯ���� ������ �� �ִٸ�
			int[][] temp = new int[N / 2][N / 2];
			//N/2ũ���� ���ο� ���
			int w = 0;
			int h = 0;
			for (int i = 0; i < N - 1; i += 2) {
				for (int j = 0; j < N - 1; j += 2) {
					//��ĭ�� �ǳʶٸ鼭 ���
					int[] sortMax = new int[4];
					// �ִ��� ���� �迭,
					sortMax[0] = map[i][j];
					sortMax[1] = map[i + 1][j];
					sortMax[2] = map[i][j + 1];
					sortMax[3] = map[i + 1][j + 1];
					Arrays.sort(sortMax);
					temp[w][h++] = sortMax[2];
					//���ο� ��Ŀ� 2��°�� ū �� �ֱ�
				}
				w++;
				h = 0;
			}
			pooling(temp);
		}
	}

}