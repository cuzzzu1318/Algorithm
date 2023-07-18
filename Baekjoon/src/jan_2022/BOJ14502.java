package jan_2022;

/* ������ �������� ���̷��� ���� ���� ����
 * �޸� ��뷮�� �ð��� �ʹ� ���� �� ���� �����ϰ� Ǭ����.
 * ���̵� : ���4
 * ���̵��: ��Ʈ��ŷ
 * �ð����⵵:
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ14502 {

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };

	static void setWall(ArrayList<ArrayList<Integer>> map, int[][] visited, int N, int M, int x, int y, int depth,
			ArrayList<Integer> safe) {
		if (depth == 0) {
			ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
			for (ArrayList<Integer> arr : map) {
				ArrayList<Integer> t = new ArrayList<>();
				for (int n : arr) {
					t.add(n);
				}
				temp.add(t);
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (visited[i][j] == 1) {
						temp.get(i + 1).set(j + 1, 1);
					}
				}
			}
			int[][] virus = new int[N+1][M+1];
			spread(temp, N, M, 1, 1,virus);

			int sum = 0;
			for (ArrayList<Integer> arr : temp) {
				for (int n : arr) {
					if (n == 0) {
						sum++;
					}
				}
			}

			safe.add(sum);
			return;
		}
		for (int i = x; i < N + 1; i++) {
			for (int j = y; j < M + 1; j++) {
				if (map.get(i).get(j) == 0) {
					if (visited[i - 1][j - 1] != 1) {
						visited[i - 1][j - 1] = 1;
						setWall(map, visited, N, M, x, y, depth - 1, safe);
						visited[i - 1][j - 1] = 0;
					}
				}

			}
		}
	}

	static void spread(ArrayList<ArrayList<Integer>> map, int N, int M, int x, int y, int[][] virus) {

		if(virus[x][y]==0) {
			if (map.get(x).get(y) == 2) {
			for (int i = 0; i < 4; i++) {
				if (map.get(x + dx[i]).get(y + dy[i]) == 0) {
					map.get(x + dx[i]).set(y + dy[i], 2);
					virus[x][y]=1;
					spread(map, N, M, x + dx[i], y + dy[i],virus);
				}
			}
		}
		int x1 = x;
		int y1 = y + 1;
		if (y1 > M) {
			x1 = x + 1;
			y1 = 1;
			if (x1 > N) {
				return;
			}
		}
		spread(map, N, M, x1, y1,virus);
		}
		

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		ArrayList<ArrayList<Integer>> map = new ArrayList<>();
		ArrayList<Integer> pad = new ArrayList<>();
		for (int i = 0; i < M + 2; i++) {
			pad.add(1);
		}
		map.add(pad);
		for (int i = 0; i < N; i++) {
			s = br.readLine().split(" ");
			ArrayList<Integer> arr = new ArrayList<>();
			arr.add(1);
			for (int j = 0; j < M; j++) {
				arr.add(Integer.parseInt(s[j]));
			}
			arr.add(1);
			map.add(arr);
		}
		map.add(pad);

		int[][] visited = new int[N][M];
		ArrayList<Integer> safe = new ArrayList<>();
		setWall(map, visited, N, M, 1, 1, 3, safe);
		Collections.sort(safe);
		System.out.println(safe.get(safe.size()-1));

	}
}