package mar_2023;

/*  N���� �θ����ڷ� ���� �� �ִ� ���� ����
 * ���̵� : �ǹ� 3
 * ���̵��: �ߺ�����
 * �ð����⵵:
 * �ҿ� �ð�: 
 * */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class S3_BOJ16922_0320 {

	static int[] num = { 1, 5, 10, 50 };
	static int N;
	static boolean[] v;
	static int ans = 0;

	static void count(int depth, int d, int number) {
		if (depth == 0) {
			if (!v[number]) {
				v[number]=true;
				ans++;
			}
			return;
		} else {
			for (int i = d; i < 4; i++) {
				count(depth - 1, i, number + num[i]);
				// System.out.println(number + num[i] + " cnt: " + cnt);
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		v = new boolean[4845];
		N = Integer.parseInt(br.readLine());
		count(N,0,0);
		System.out.println(ans);

	}
}