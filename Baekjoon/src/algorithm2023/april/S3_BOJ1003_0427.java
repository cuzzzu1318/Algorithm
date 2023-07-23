package algorithm2023.april;

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
			//0�� 1�� ���� Ƚ���� ����ϱ� ���� 2�������� �迭 ����
			if(N==0) {
				//0�� �ԷµǸ� �ٷ� ��� �� ���� �׽�Ʈ���̽�
				bw.write("1 0\n");
				continue;
			}
			arr[0][0] = 1;
			arr[0][1] = 0;
			arr[1][0] = 0;
			arr[1][1] = 1;
			//0�� 1�� ���� �ʱ� �� �Է�
			
			for(int i = 2;i<N+1;i++) {
				//N���� ��ȸ�ϸ� ���� �� ���� ������
				arr[i][0] = arr[i-1][0]+arr[i-2][0];
				arr[i][1] = arr[i-1][1]+arr[i-2][1];
			}
			//N�� 0,1 ���Ƚ��
			bw.write(Integer.toString(arr[N][0])+" "+Integer.toString(arr[N][1])+"\n");
		}
		bw.flush();
		bw.close();
	}
}