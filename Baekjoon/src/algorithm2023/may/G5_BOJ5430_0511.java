package algorithm2023.may;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class G5_BOJ5430_0511 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		loop: for (int t = 0; t < T; t++) {
			String[] p = br.readLine().split("");
			//��ɾ� �迭
			int n = Integer.parseInt(br.readLine());
			//�迭�� �ִ� �ʱⰪ�� ����
			int[] arr = new int[n];
			String[] s = br.readLine().replace("[", "").replace("]", "").split(",");
			//"[", ",", "]"�� �� �迭�� ��Ҹ� ����
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(s[i]);
			}
			int start = 0;
			//���� �ε���
			int end = n - 1;
			//������ �ε���
			boolean isReverse = false;
			//�迭�� ���������� Ȯ���� ����
			for (int i = 0; i < p.length; i++) {
				//��ɾ Ȯ��
				if (p[i].equals("R")) {
					//R�̸� �迭�� ���� �ε����� ������ �ε��� �����ϰ� isReverse ����
					int temp = end;
					end = start;
					start = temp;
					isReverse = !isReverse;
				} else {
					if (isReverse) {
						if (start < end) {
							//������ �����ε� ���� �ε����� �� ������ Ž���� �� �����Ƿ� ����
							sb.append("error\n");
							continue loop;
						}
						///������ �ƴ϶�� ���� �ε��� ���̱� -> ������ �����̹Ƿ� �����ʿ��� ���Ҹ� ������ ���� �ٿ���
						start--;
					} else {
						if (start > end) {
							//�������� �ʾҴµ� ���� �ε����� �� ũ�� Ž���� �� �����Ƿ� ����
							sb.append("error\n");
							continue loop;
						}
						//������ �ƴ϶�� ���� �ε��� ++
						start++;
					}
				}
			}

			sb.append("[");
			//������ ���¿� �ƴ� ���� �����Ͽ� ������ / ������ ���
			if (isReverse) {
				for (int i = start; i >= end; i--) {
					sb.append(arr[i]);
					if(i!=end) {
						sb.append(",");
					}
				}
			} else {
				for(int i= start;i<=end;i++) {
					sb.append(arr[i]);
					if(i!=end) {
						sb.append(",");
					}
				}
			}
			sb.append("]\n");
		}
		System.out.println(sb);
	}
}