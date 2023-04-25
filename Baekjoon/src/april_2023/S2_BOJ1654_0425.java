package april_2023;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S2_BOJ1654_0425 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int K;
	static int N;
	static long[] lan;

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		lan = new long[K];
		long min = 0;
		long max = 0;
		for (int i = 0; i < K; i++) {
			lan[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, lan[i]);
		}
		//입력 및 최댓값 초기화
		max++;
		//0으로 나누지 않기 위해 max+1을 해줌
		while (min < max) {
			//계속하여 이분 탐색
			long middle = (min + max) / 2;
			int cnt = 0;
			for (int i = 0; i < K; i++) {
				//랜선 길이 중앙값으로 나눈 값 -> 중앙값의 길이 cnt개를 만들 수 있음.
				cnt += lan[i] / middle;
			}
			

			if (cnt < N) {
				//랜선 길이가 부족하다면 더 짧은 길이로 자름
				max = middle;
			} else {
				//랜선 길이가 충족되면 가장 긴 길이를 반환해야 하기에 더 위쪽 자름.
				min = middle + 1;
			}
		}

		bw.write(Long.toString(min - 1));

		bw.flush();
		bw.close();

	}
}