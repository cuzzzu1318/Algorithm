package mar_2023;

/*  X는 땅, .은 바다
 * 50년이 지나면 3면 이상이 바다인 땅은 물에 잠김. 범위 넘어간 곳은 바다.
 * 50년후에 지도를 출력하라. 단 땅을 모두 출력하는 최소한의 직사각형
 * 난이도 : 실버 2
 * 아이디어: 방향벡터 이용. 범위가 넘어가도 카운트 되도록.
 * 			이후 x,y의 최대 최소 구해서 지도를 출력.
 * 시간복잡도:
 * 소요 시간: 21:20~21:35 (15min)
 * */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class S2_BOJ5212_0321 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int R;
	static int C;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		String[] s = br.readLine().split(" ");
		R = Integer.parseInt(s[0]);
		C = Integer.parseInt(s[1]);
		char[][] map = new char[R][C];
		for (int i = 0; i < R; i++) {
			char[] arr = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				map[i][j] = arr[j];
			}
		}
		int maxX = 0;
		int minX = 10;
		int maxY = 0;
		int minY = 10;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'X') {
					int cntSea = 0;
					for (int k = 0; k < 4; k++) {
						int nextX = i + dx[k];
						int nextY = j + dy[k];
						if (nextX < 0 || nextX >= R || nextY < 0 || nextY >= C) {
							cntSea++;
							continue;
						}
						if(map[nextX][nextY]=='.') {
							cntSea++;
						}
					}
					if(cntSea>=3) {
						map[i][j] = ' ';
					}else {
						if(i>=maxX) {
							maxX = i;
						}
						if(i<=minX) {
							minX = i;
						}
						if(j>=maxY) {
							maxY = j;
						}
						if(j<=minY) {
							minY = j;
						}
					}
				}
			}
		}
		for(int i = minX;i<=maxX;i++) {
			for(int j = minY;j<=maxY;j++) {
				if(map[i][j]==' ') {
					map[i][j] = '.';
				}
				bw.write(map[i][j]);
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();

	}
}