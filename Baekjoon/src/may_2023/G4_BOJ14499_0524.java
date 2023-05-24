package may_2023;

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
		// 지도의 세로 크기
		int M = Integer.parseInt(st.nextToken());
		// 지도의 가로 크기
		int x = Integer.parseInt(st.nextToken())+1;
		int y = Integer.parseInt(st.nextToken())+1;
		// 주사위의 현재 좌표 x, y
		int K = Integer.parseInt(st.nextToken());
		// 명령어의 개수

		int[][] map = new int[N + 2][M + 2];
		// 지도
		for (int i = 0; i < N + 2; i++) {
			Arrays.fill(map[i], -1);
		}
		// 패딩작업
		
		
		int top = 0;
		//상단에 적힌 수
		int[] ud = { 0, 0 };
		//상단 기준 상 하에 적힌 수
		int[] lr = { 0, 0 };
		//상단 기준 좌 우에 적힌 수
		int bottom = 0;
		//바닥에 적힌 수

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 지도 입력

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < K; i++) {
			int func = Integer.parseInt(st.nextToken()) - 1;
			x = x + dx[func];
			y = y + dy[func];
			//다음 목적지 좌표
			if (map[x][y] == -1) {
				//목적지가 -1인 경우 -> 지도의 밖이므로 이동을 취소하고 다음 이동명령을 실행
				x-=dx[func];
				y-=dy[func];
				continue;
			}
			int temp = top;
			//상단 수 임시젖아
			// 방향벡터 배열로 사용하기 위해 인덱스 접근에 용이하도록 0부터 3까지의 값으로 저장
			switch (func) {
			//이동시키면서 주사위의 값 변경
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
				//지도에 적힌 값이 0인경우 주사위 바닥의 값 복사
				map[x][y] = bottom;
			}else {
				//0이 아닌 경우 주사위로 복사하고 바닥 0으로 초기화
				bottom = map[x][y];
				map[x][y] = 0;
			}
			System.out.println(top);
		}
	}
}