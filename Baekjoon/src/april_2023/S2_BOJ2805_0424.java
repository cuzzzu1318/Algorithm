package april_2023;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S2_BOJ2805_0424 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static long[] trees;

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		trees = new long[N];
		st = new StringTokenizer(br.readLine(), " ");
		long max = 0;
		for (int i = 0; i < N; i++) {
			trees[i] = Long.parseLong(st.nextToken());
			max = Math.max(max, trees[i]);
		}
		// 입력 및 최댓값 구하기.

		long h = sawTree(0, max, N, M);
		bw.write(Long.toString(h));

		bw.flush();
		bw.close();

	}

	static long sawTree(long l, long max, int N, int M) {
		long cnt = 0;
		//해당 중앙값까지 얻을 수 있는 나무의 양
		long middle = (max + l) / 2;
		//중앙값
		for (int i = 0; i < N; i++) {
			//나무 배열을 돌면서
			if (trees[i] > middle) {
				//나무가 중앙값보다 길다면 잘랐을 때 얻을 수 있는 양 계산.
				cnt += trees[i] - middle;
			}
		}
		if (l >= max) {
			//최솟값이 최댓값보다 크거나 작다 -> 더이상 이분할 수 없다. -> 리턴
			return middle - 1;
		} else {
			if (cnt < M) {
				//나무를 더 잘라야 하면
				return sawTree(l, middle, N, M);
				//아래쪽을 잘라야 하므로 최솟값과 중앙값으로 다시 계산
			} else {
				//나무를 덜 잘라야 하면
				return sawTree(middle + 1, max, N, M);
				//위쪽을 잘라야 하므로 중앙값+1과 최댓값으로 다시 계산
			}
		}
	}
}