package april_2023;

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
			//괄호 문자열
			int cnt = 0;
			//셀 변수
			for(char c : arr) {
				if(c=='(') {
					//열린 괄호일 때 +
					cnt++;
				}else {
					//닫힌 괄호일 때 --
					cnt--;
				}
				if(cnt<0) {
					//열기도 전에 닫은 경우 바로 종료하여 cnt가 0이 아닌 상태로 종료됨.
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