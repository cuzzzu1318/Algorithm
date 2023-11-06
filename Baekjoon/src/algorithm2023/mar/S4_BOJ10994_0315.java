package algorithm2023.mar;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class S4_BOJ10994_0315 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static void makeStar(int n, int depth) throws IOException {
		String first = "*";
		String second = "   ";
		for(int i = 1;i<depth;i++) {
			first+="****";
		}
		for(int i = 2;i<depth;i++) {
			second+="    ";
		}
		second = "*"+second+"*";
		for(int i =depth;i<n;i++) {
			first = "* "+first+" *";
			second = "* "+second+" *";
		}
		
		if(depth == 1) {
			bw.write(first+"\n");
		}else {
			bw.write(first+"\n");
			bw.write(second+"\n");
			makeStar(n,depth-1);
			bw.write(second+"\n");
			bw.write(first+"\n");
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		int N = Integer.parseInt(br.readLine());
		makeStar(N, N);
		bw.flush();
		bw.close();
	}
}