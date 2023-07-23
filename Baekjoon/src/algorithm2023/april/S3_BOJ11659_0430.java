package algorithm2023.april;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class S3_BOJ11659_0430 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws NumberFormatException, IOException {
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		int[] arr = new int[N+1];
		s = br.readLine().split(" ");
		arr[0] = 0;
		for(int i = 1;i<=N;i++) {
			arr[i] = arr[i-1]+ Integer.parseInt(s[i-1]);
		}
		for(int i = 0;i<M;i++) {
			s = br.readLine().split(" ");
			int start = Integer.parseInt(s[0]);
			int end = Integer.parseInt(s[1]);
			
			bw.write(Integer.toString(arr[end]-arr[start-1])+"\n");
		}
		bw.flush();
		bw.close();
	}
}