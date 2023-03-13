package mar_2023;

/*  2차원세계에 블록이 쌓여있을 때에 빗물이 쌓이는 높이.
 * 난이도 : 골드 5
 * 아이디어: 계산할 블록의 좌 우 에서 최댓값 구한 후 그 중 낮은 블록이 자신보다 크면 빗물 고임.
 * 시간복잡도:
 * 소요 시간: 20:10~21:10 / 14:20~14:45 (1h 20min)
 * */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ14719_0312 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");
		int H = Integer.parseInt(s[0]);
		int W = Integer.parseInt(s[1]);
		int[] block = new int[W];
		s = br.readLine().split(" ");
		for (int i = 0; i < W; i++) {
			block[i] = Integer.parseInt(s[i]);
		}
		// 블록 배열 입력

		int cnt = 0;
		// 고이는 양 카운트

		for (int i = 1; i < W - 1; i++) {
			int left = 0;
			int right = 0;
			for (int j = 0; j < i; j++) {
				left = Math.max(left, block[j]);
			}
			for (int j = i + 1; j < W; j++) {
				right = Math.max(right, block[j]);
			}
			if (left >block[i] && right >block[i]) {
			//	System.out.println(left+" "+right+" "+i);
				cnt += Math.min(left, right) - block[i];

			}
		}
		//해당 블록 기준으로 왼쪽과 오른쪽 가장 큰 블록 중 작은 블록과의 차를 더함. 물론 그 블록은 
		//해당 블록보다 높아야됨
		

		bw.write(Integer.toString(cnt));
		bw.flush();
		bw.close();

	}
}