package algorithm2023.mar;

/*  ���� DNA �迭���� �־���.
 * �ε��� �� DNA�� �ٸ� ������ �� = Hamming Distance
 * �������� �迭��� Hamming Distance�� ���� ���� �迭 ���ϱ�
 * ���̵� : �ǹ� 4
 * ���̵��: ���� �� ����Ͽ� ���
 * �ð����⵵:
 * �ҿ� �ð�: 18:55~19:50
 * */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ1969 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		char[] TGAC = { 'A', 'C', 'G', 'T' };
		// �񱳸� ���� ���ڿ� �迭
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		// DNA�� �� N�� ���ڿ��� ���� M
		ArrayList<String> arr = new ArrayList<>();
		int[] freq = new int[4];
		Arrays.fill(freq, 0);
		//�� ���� �� ���� Ƚ��, 0���� �ʱ�ȭ
		for (int i = 0; i < N; i++) {
			arr.add(br.readLine());
		}
		// DNA �迭 ����
		int cnt = 0;
		// �� Hamming Distance ī��Ʈ
		String ans = "";
		//������ �� DNA �迭
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < 4; k++) {
					//�� DNA���� ���ڸ� ���Ͽ� Ƚ�� ����
					if (arr.get(j).charAt(i) == TGAC[k]) {
						freq[k]++;
					}
				}

			}
			int max = 0;
			String maxC = "";
			for (int j = 0; j < 4; j++) {
				if (freq[j] > max) {
					//���� Ƚ���� ���� ���� ���� ����. ���� �迭�� ���ĺ� ���̹Ƿ� �ڵ������� �������ĵ�.
					max = freq[j];
					maxC = Character.toString(TGAC[j]);
				}
			}
			cnt+=(N-max);
			//���� ������ �� ������ Ƚ�� = Hamming Distance
			ans+=maxC;
			Arrays.fill(freq, 0);
			//���� �ε��� Ȯ�� �� 0���� �ʱ�ȭ
		}
		bw.write(ans+"\n"+cnt);

		bw.flush();
		bw.close();
	}
}