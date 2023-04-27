package april_2023;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class S3_BOJ1003_0427 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N + 1][2];
			//0과 1이 나온 횟수를 계산하기 위해 2차원으로 배열 구성
			if(N==0) {
				//0이 입력되면 바로 출력 후 다음 테스트케이스
				bw.write("1 0\n");
				continue;
			}
			arr[0][0] = 1;
			arr[0][1] = 0;
			arr[1][0] = 0;
			arr[1][1] = 1;
			//0과 1에 대한 초기 값 입력
			
			for(int i = 2;i<N+1;i++) {
				//N까지 순회하며 앞의 두 값을 더해줌
				arr[i][0] = arr[i-1][0]+arr[i-2][0];
				arr[i][1] = arr[i-1][1]+arr[i-2][1];
			}
			//N의 0,1 출력횟수
			bw.write(Integer.toString(arr[N][0])+" "+Integer.toString(arr[N][1])+"\n");
		}
		bw.flush();
		bw.close();
	}
}