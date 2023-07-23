package algorithm2023.mar;

/*  c�� ����, .�� �׳� �ϴ�.
 * 	1�ʸ��� ������ ���������� ������.
 * 	���� �Ŀ� ������ ��Ÿ������ ǥ��
 * ���̵� : �ǹ� 5
 * ���̵��: �ܼ� ����
 * �ð����⵵:
 * �ҿ� �ð�: �� 10�� 
 * */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class S5_BOJ10709_0321 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int H;
	static int W;

	public static void main(String[] args) throws NumberFormatException, IOException {
		String[] s = br.readLine().split(" ");
		H = Integer.parseInt(s[0]);
		W = Integer.parseInt(s[1]);
		for (int i = 0; i < H; i++) {
			s = br.readLine().split("");
			int cnt = -1;
			boolean hasCloud = false;
			for (int j = 0; j < W; j++) {

				if (s[j].equals("c")) {
					cnt = 0;
					hasCloud = true;
				} else {
					if (hasCloud) {
						cnt++;
					} else {
						bw.write("-1 ");
						continue;
					}
				}
				bw.write(cnt+" ");
			}
			bw.write("\n");

		}
		bw.flush();
		bw.close();

	}
}