package april_2023;

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
		// N*N 행렬 입력 완료

	}

	static void pooling(int[][] map) {
		int N = map.length;
		// 들어온 행렬의 가로 세로 길이
		if (N == 1) {
			// 1*1 행렬이라면 해당 원소 출력
			System.out.println(map[0][0]);
		} else {
			// 222-풀링을 진행할 수 있다면
			int[][] temp = new int[N / 2][N / 2];
			//N/2크기의 새로운 행렬
			int w = 0;
			int h = 0;
			for (int i = 0; i < N - 1; i += 2) {
				for (int j = 0; j < N - 1; j += 2) {
					//두칸씩 건너뛰면서 계산
					int[] sortMax = new int[4];
					// 최댓값을 구할 배열,
					sortMax[0] = map[i][j];
					sortMax[1] = map[i + 1][j];
					sortMax[2] = map[i][j + 1];
					sortMax[3] = map[i + 1][j + 1];
					Arrays.sort(sortMax);
					temp[w][h++] = sortMax[2];
					//새로운 행렬에 2번째로 큰 값 넣기
				}
				w++;
				h = 0;
			}
			pooling(temp);
		}
	}

}