package algorithm2023.mar;

/*  2�������迡 ����� �׿����� ���� ������ ���̴� ����.
 * ���̵� : ��� 5
 * ���̵��: ����� ����� �� �� ���� �ִ� ���� �� �� �� ���� ����� �ڽź��� ũ�� ���� ����.
 * �ð����⵵:
 * �ҿ� �ð�: 20:10~21:10 / 14:20~14:45 (1h 20min)
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
		// ��� �迭 �Է�

		int cnt = 0;
		// ���̴� �� ī��Ʈ

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
		//�ش� ��� �������� ���ʰ� ������ ���� ū ��� �� ���� ��ϰ��� ���� ����. ���� �� ����� 
		//�ش� ��Ϻ��� ���ƾߵ�
		

		bw.write(Integer.toString(cnt));
		bw.flush();
		bw.close();

	}
}