package algorithm2023.april;

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
		//dp ����� ���
		bw.flush();
		bw.close();
	}
	
	static int dp(int n){
		if(n==1||d[n]!=0) {
			//�̹� Ž���Ͽ� ����� �� ��쿣 �ٷ� ����
			return d[n];
		}else {
			int cnt = 1000000;
			//�ּڰ��� ���� �Էµ� �� �ִ� ���� ū ��
			if(n%3==0) {
				//3���� ������ ���
				cnt = Math.min(cnt, dp(n/3)+1);
			}
			if(n%2==0) {
				//2�� ������ ���
				cnt = Math.min(cnt, dp(n/2)+1);
			}
			cnt = Math.min(cnt, dp(n-1)+1);
			//1�� �� ���
			//������ �� �ּڰ� ���� �� dp �迭�� ����dd
			d[n] = cnt;
			return cnt;
		}
	}
	
}