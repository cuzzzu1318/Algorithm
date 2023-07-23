package algorithm2023.mar;

/*  
 * ���̵� : 
 * ���̵��: 
 * �ð����⵵:
 * �ҿ� �ð�: 
 * */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class S5_BOJ1769_0314 {
	
	static int trans(String X,int depth) {
		if(X.length()==1) {
			System.out.println(depth);
			return Integer.parseInt(X);
		}else {
			int Y = 0;
			for(int i =0;i<X.length();i++) {
				int n = X.charAt(i) - '0';
				Y+=n;
				//System.out.println(Y+" "+n);
			}
			return trans(Integer.toString(Y),depth+1);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String X = br.readLine();
		int n = trans(X,0);
		String ans = "NO";
		if(n%3==0) {
			ans = "YES";
		}
		bw.write(ans);
		bw.flush();
		bw.close();
	}
}