
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int M;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int i= 1;i<=N;i++) {
			choose(i,1, "");
		}
		System.out.println(sb);
		
	}
	
	static void choose(int n, int m, String str) {
		str+=Integer.toString(n)+" ";
		if(m==M) {
			sb.append(str+"\n");
			return;
		}
		for(int i = n+1;i<=N;i++) {
			choose(i,m+1,str);
		}
	}
}