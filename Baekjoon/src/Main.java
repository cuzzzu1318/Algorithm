import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {

	// 좌측상단에서 우측 하단으로 내려가기 때문에 8방향을 다 보는 것이 아닌 4방향만 탐색
	// 다른 방향을 탐색하게 되면 좌측 바둑알만을 출력할 수 없음.
	// 0: ↗, 1: →, 2: ↘, 3: ↓ 총 네 방향
	static int[] dy = { -1, 0, 1, 1};
	static int[] dx = { 1, 1, 1, 0};

	static int[][] board = new int[19][19];
	static boolean[][] v = new boolean[19][19];

	public static void main(String[] args) throws Exception {
		//////////////////////////////////////////////////////////////
		// 테스트 후 아래 파일 입력을 표준입력으로 처리하는 문장은 주석 처리해주세요!!!! ( System.setIn처리 코드 )
		//////////////////////////////////////////////////////////////
//		System.setIn(new FileInputStream("Test5.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 승자의 정보를 [색, y좌표, x좌표}로 저장.
		int[] winner = new int[3];

		// 입력
		for (int i = 0; i < 19; i++) {
			String[] s = br.readLine().split(" ");
			for (int j = 0; j < 19; j++) {
				board[i][j] = Integer.parseInt(s[j]);
			}
		}

		// 모든 오목판을 탐색
		loop: for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				int color = board[j][i];
				// 해당 칸에 오목알이 있다면
				if (color > 0) {
					// 네 방향에 대해 탐색 시작
					for (int d = 0; d < 4; d++) {
						// 이긴 것이 확정이라면 승자로 저장 후 반복문 종료
						if (isWin(color, j, i, d)) {
							winner[0] = color;
							// 배열의 인덱스는 0부터 시작이므로 1씩 더한 값 저장
							winner[1] = j + 1;
							winner[2] = i + 1;
							break loop;
						}
					}
				}
			}
		}
		System.out.println(winner[0]);
		if (winner[0] != 0) {
			System.out.println(winner[1] + " " + winner[2]);
		}

	}

	// 승자 판단 함수
	static boolean isWin(int color, int y, int x, int d) {
		int cnt = 1;
		int ny = y;
		int nx = x;
		while (true) {
			ny += dy[d];
			nx += dx[d];
			if (isValid(ny, nx) && board[ny][nx] == color && !v[ny][nx]) {
				cnt++;
			} else {
				break;
			}
		}
		ny = y;
		nx = x;
		while (true) {
			ny -= dy[d];
			nx -= dx[d];
			if (isValid(ny, nx) && board[ny][nx] == color && !v[ny][nx]) {
				cnt++;
			} else {
				break;
			}
		}
		if(cnt==5) {
			return true;
		}
		return false;

	}

	// 범위 유효성 판단 함수
	static boolean isValid(int y, int x) {
		if (y < 0 || x < 0 || y >= 19 || x >= 19)
			return false;
		return true;
	}
}