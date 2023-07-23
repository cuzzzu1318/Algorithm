package algorithm2023.april;

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
		//ù��°��� �� ����.
		if(N!=1) {
			//����� ��ĭ�ۿ� ���ٸ� �������� �ʰ� �ٷ� ���
			stairs[1][0] = Integer.parseInt(br.readLine());
			stairs[1][1] = stairs[1][0] + stairs[0][0];
			//0��° �ε����� n-1��° ����� ���� ���� ���
			//1��° �ε����� n-1��° ����� ���� ���
			for (int i = 2; i < N; i++) {
				//�Է��� ������ �迭 ä���
				int n = Integer.parseInt(br.readLine());
				stairs[i][0] = n + Math.max(stairs[i - 2][0], stairs[i - 2][1]);
				stairs[i][1] = n + stairs[i - 1][0];
			}
		}
		
		bw.write(Integer.toString(Math.max(stairs[N-1][0], stairs[N-1][1])));
		//N��° ����� ����� ���� �ִ� ���!
		bw.flush();
		bw.close();
	}
}