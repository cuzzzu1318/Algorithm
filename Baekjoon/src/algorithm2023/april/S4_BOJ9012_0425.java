package algorithm2023.april;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S4_BOJ9012_0425 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static char[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for(int i = 0;i<T;i++) {
			arr = br.readLine().toCharArray();
			//��ȣ ���ڿ�
			int cnt = 0;
			//�� ����
			for(char c : arr) {
				if(c=='(') {
					//���� ��ȣ�� �� +
					cnt++;
				}else {
					//���� ��ȣ�� �� --
					cnt--;
				}
				if(cnt<0) {
					//���⵵ ���� ���� ��� �ٷ� �����Ͽ� cnt�� 0�� �ƴ� ���·� �����.
					break;
				}
			}
			if(cnt==0) {
				bw.write("YES\n");
			}else {
				bw.write("NO\n");
			}
		}
		bw.flush();
		bw.close();
	}

	

}