package mar_2023;

/*  숫자 다섯개 중 세개르 ㄹ봅아서 1의자리수가 가장 큰거 뽑기
 * 난이도 : 실버 5
 * 아이디어: 그냥 조합으로 했음
 * 시간복잡도:
 * 소요 시간: 한 15분 걸린듯 쉬운문젠데,, 
 * */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class S5_BOJ2303_0321 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		int ans = 0;
		int idx =0;
		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			int max = 0;
			for(int j = 0;j<5;j++) {
				for(int k = j+1;k<5;k++) {
					for(int l = k+1;l<5;l++) {
						int n = Integer.parseInt(s[j]);
						int n1 = Integer.parseInt(s[k]);
						int n2 = Integer.parseInt(s[l]);
						int sum = n+n1+n2;
						System.out.println(n+" "+n1+" "+n2+" sum: "+sum+" "+sum%10);
						if(sum%10>=max) {
							max = sum%10;
						}
					}
				}
			}
			if(max>=ans) {
				ans = max;
				idx=i+1;
			}
		}
		bw.write(Integer.toString(idx));
		bw.flush();
		bw.close();

	}
}