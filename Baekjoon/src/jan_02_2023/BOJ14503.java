package jan_02_2023;

/* 로봇청소기의 청소 영역 구하기
 * 난이도 : 골드5
 * 아이디어: 단순 구현
 * 시간복잡도:
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ14503 {

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };

	public static void clean(ArrayList<ArrayList<Integer>> space, int N, int M, int r, int c, int d) {
		//현재영역 청소했다는 표시: 2로 바꾸기
		space.get(r).set(c, 2);
		
		//한바퀴 돌면서 다음 구역 탐색
		for (int i = 0; i < 4; i++) {
			//왼쪽으로 돌기: d-1하기
			d--;
			if (d == -1) {
				d = 3;
			}
			//다음 방향이 영역 밖이면 다시 돌기
			if (r + dy[d] < 0 || c + dx[d] >= M || r + dy[d] >= N || c + dx[d] < 0) {
				continue;
			}
			
			//다음 방향 청소 가능하면 이동
			if (space.get(r + dy[d]).get(c + dx[d]) == 0) {
				clean(space, N, M, r + dy[d], c + dx[d], d);
				return;
			}
			//한바퀴 돌았다면
			if (i == 3) {
				//뒤로 갈 방향: d-2하기
				int temp = d;
				d -= 2;
				if (d < 0) {
					d += 4;
				}
				if (r + dy[d] < 0 || c + dx[d] >= M || r + dy[d] >= N || c + dx[d] < 0) {
					return;
				}
				//뒤가 벽이라면 정지
				if (space.get(r + dy[d]).get(c + dx[d]) == 1) {
					return;
				} else {
					//후진 후 청소할 수 있다면 고
					clean(space, N, M, r + dy[d], c + dx[d], temp);
					return;
				}
			}

		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		// 세로 크기 N, 가로 크기 M
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		s = br.readLine().split(" ");
		// 청소기가 있는 칸 (r,c), 바라보고 있는 방향 d
		// d: 북(0), 동(1), 남(2), 서(3)
		int r = Integer.parseInt(s[0]);
		int c = Integer.parseInt(s[1]);
		int d = Integer.parseInt(s[2]);

		// 청소할 공간
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
		//청소된 구역인 2의 갯수 모두 더하기
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