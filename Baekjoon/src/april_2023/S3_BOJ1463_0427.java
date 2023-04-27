package april_2023;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class S3_BOJ1463_0427 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[] d;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		d = new int[N+1];
		bw.write(Integer.toString(dp(N)));
		//dp 결과값 출력
		bw.flush();
		bw.close();
	}
	
	static int dp(int n){
		if(n==1||d[n]!=0) {
			//이미 탐색하여 결과를 얻어낸 경우엔 바로 리턴
			return d[n];
		}else {
			int cnt = 1000000;
			//최솟값을 위해 입력될 수 있는 가장 큰 값
			if(n%3==0) {
				//3으로 나뉘는 경우
				cnt = Math.min(cnt, dp(n/3)+1);
			}
			if(n%2==0) {
				//2로 나뉘는 경우
				cnt = Math.min(cnt, dp(n/2)+1);
			}
			cnt = Math.min(cnt, dp(n-1)+1);
			//1을 뺀 경우
			//세가지 중 최솟값 리턴 및 dp 배열에 저장dd
			d[n] = cnt;
			return cnt;
		}
	}
	
}