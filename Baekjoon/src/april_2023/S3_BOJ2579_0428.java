package april_2023;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class S3_BOJ2579_0428 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		int[][] stairs = new int[N][2];
		stairs[0][0] = Integer.parseInt(br.readLine());
		stairs[0][1] = stairs[0][0];
		//첫번째계단 값 저장.
		if(N!=1) {
			//계단이 한칸밖에 없다면 진행하지 않고 바로 출력
			stairs[1][0] = Integer.parseInt(br.readLine());
			stairs[1][1] = stairs[1][0] + stairs[0][0];
			//0번째 인덱스는 n-1번째 계단을 밟지 않은 경우
			//1번째 인덱스는 n-1번째 계단을 밟은 경우
			for (int i = 2; i < N; i++) {
				//입력을 받으며 배열 채우기
				int n = Integer.parseInt(br.readLine());
				stairs[i][0] = n + Math.max(stairs[i - 2][0], stairs[i - 2][1]);
				stairs[i][1] = n + stairs[i - 1][0];
			}
		}
		
		bw.write(Integer.toString(Math.max(stairs[N-1][0], stairs[N-1][1])));
		//N번째 계단을 밟았을 때에 최댓값 출력!
		bw.flush();
		bw.close();
	}
}