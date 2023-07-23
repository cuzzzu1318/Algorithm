package algorithm2023.may;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_BOJ6064_0510 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			boolean can = false;
			
			
			int gcd = gcd(M,N);
			//�ִ�����
			
			for(int i = 0;i<N/gcd;i++) {
				//M*N/gcd�� �ּҰ�����̹Ƿ� �ּҰ�������� ����
				if(y%N==(i*M+x)%N) {
					//y�� N�� ���� ��츦 ���� N���� ���� �������� ���
					can = true;
					sb.append(i*M+x+"\n");
					break;
				}
			}
			if(!can) {
				sb.append("-1\n");
			}
		}
		System.out.println(sb);
	}
	
	static int gcd(int a, int b) {
		if(a%b==0) {
			return b;
		}else {
			return gcd(b, a%b);
		}
	}
}