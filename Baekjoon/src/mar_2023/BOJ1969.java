package mar_2023;

/*  여러 DNA 배열들이 주어짐.
 * 인덱스 간 DNA가 다른 개수의 합 = Hamming Distance
 * 여러개의 배열들과 Hamming Distance가 가장 적은 배열 구하기
 * 난이도 : 실버 4
 * 아이디어: 등장 빈도 계산하여 출력
 * 시간복잡도:
 * 소요 시간: 18:55~19:50
 * */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ1969 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		char[] TGAC = { 'A', 'C', 'G', 'T' };
		// 비교를 위한 문자열 배열
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		// DNA의 수 N과 문자열의 길이 M
		ArrayList<String> arr = new ArrayList<>();
		int[] freq = new int[4];
		Arrays.fill(freq, 0);
		//각 문자 별 등장 횟수, 0으로 초기화
		for (int i = 0; i < N; i++) {
			arr.add(br.readLine());
		}
		// DNA 배열 저장
		int cnt = 0;
		// 총 Hamming Distance 카운트
		String ans = "";
		//정답이 될 DNA 배열
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < 4; k++) {
					//각 DNA마다 문자를 비교하여 횟수 저장
					if (arr.get(j).charAt(i) == TGAC[k]) {
						freq[k]++;
					}
				}

			}
			int max = 0;
			String maxC = "";
			for (int j = 0; j < 4; j++) {
				if (freq[j] > max) {
					//등장 횟수가 가장 많은 문자 저장. 문자 배열이 알파벳 순이므로 자동적으로 사전정렬됨.
					max = freq[j];
					maxC = Character.toString(TGAC[j]);
				}
			}
			cnt+=(N-max);
			//많이 등장한 것 제외한 횟수 = Hamming Distance
			ans+=maxC;
			Arrays.fill(freq, 0);
			//다음 인덱스 확인 전 0으로 초기화
		}
		bw.write(ans+"\n"+cnt);

		bw.flush();
		bw.close();
	}
}