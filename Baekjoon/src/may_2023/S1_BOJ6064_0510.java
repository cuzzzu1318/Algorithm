package may_2023;

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
			//최대공약수
			
			for(int i = 0;i<N/gcd;i++) {
				//M*N/gcd가 최소공배수이므로 최소공배수까지 진행
				if(y%N==(i*M+x)%N) {
					//y가 N과 같은 경우를 위해 N으로 나눈 나머지를 사용
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