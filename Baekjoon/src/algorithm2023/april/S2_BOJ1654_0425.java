package algorithm2023.april;

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
		//�Է� �� �ִ� �ʱ�ȭ
		max++;
		//0���� ������ �ʱ� ���� max+1�� ����
		while (min < max) {
			//����Ͽ� �̺� Ž��
			long middle = (min + max) / 2;
			int cnt = 0;
			for (int i = 0; i < K; i++) {
				//���� ���� �߾Ӱ����� ���� �� -> �߾Ӱ��� ���� cnt���� ���� �� ����.
				cnt += lan[i] / middle;
			}
			

			if (cnt < N) {
				//���� ���̰� �����ϴٸ� �� ª�� ���̷� �ڸ�
				max = middle;
			} else {
				//���� ���̰� �����Ǹ� ���� �� ���̸� ��ȯ�ؾ� �ϱ⿡ �� ���� �ڸ�.
				min = middle + 1;
			}
		}

		bw.write(Long.toString(min - 1));

		bw.flush();
		bw.close();

	}
}