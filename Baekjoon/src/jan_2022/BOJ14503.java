package jan_2022;

/* �κ�û�ұ��� û�� ���� ���ϱ�
 * ���̵� : ���5
 * ���̵��: �ܼ� ����
 * �ð����⵵:
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ14503 {

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };

	public static void clean(ArrayList<ArrayList<Integer>> space, int N, int M, int r, int c, int d) {
		//���翵�� û���ߴٴ� ǥ��: 2�� �ٲٱ�
		space.get(r).set(c, 2);
		
		//�ѹ��� ���鼭 ���� ���� Ž��
		for (int i = 0; i < 4; i++) {
			//�������� ����: d-1�ϱ�
			d--;
			if (d == -1) {
				d = 3;
			}
			//���� ������ ���� ���̸� �ٽ� ����
			if (r + dy[d] < 0 || c + dx[d] >= M || r + dy[d] >= N || c + dx[d] < 0) {
				continue;
			}
			
			//���� ���� û�� �����ϸ� �̵�
			if (space.get(r + dy[d]).get(c + dx[d]) == 0) {
				clean(space, N, M, r + dy[d], c + dx[d], d);
				return;
			}
			//�ѹ��� ���Ҵٸ�
			if (i == 3) {
				//�ڷ� �� ����: d-2�ϱ�
				int temp = d;
				d -= 2;
				if (d < 0) {
					d += 4;
				}
				if (r + dy[d] < 0 || c + dx[d] >= M || r + dy[d] >= N || c + dx[d] < 0) {
					return;
				}
				//�ڰ� ���̶�� ����
				if (space.get(r + dy[d]).get(c + dx[d]) == 1) {
					return;
				} else {
					//���� �� û���� �� �ִٸ� ��
					clean(space, N, M, r + dy[d], c + dx[d], temp);
					return;
				}
			}

		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		// ���� ũ�� N, ���� ũ�� M
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		s = br.readLine().split(" ");
		// û�ұⰡ �ִ� ĭ (r,c), �ٶ󺸰� �ִ� ���� d
		// d: ��(0), ��(1), ��(2), ��(3)
		int r = Integer.parseInt(s[0]);
		int c = Integer.parseInt(s[1]);
		int d = Integer.parseInt(s[2]);

		// û���� ����
		ArrayList<ArrayList<Integer>> space = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			s = br.readLine().split(" ");
			ArrayList<Integer> arr = new ArrayList<>();
			for (int j = 0; j < M; j++) {
				arr.add(Integer.parseInt(s[j]));
			}
			space.add(arr);
		}
		clean(space, N, M, r, c, d);
		int sum = 0;
		//û�ҵ� ������ 2�� ���� ��� ���ϱ�
		for (ArrayList<Integer> arr : space) {
			for (int n : arr) {
				if (n == 2) {
					sum++;
				}
			}
		}
		System.out.println(sum);

	}
}