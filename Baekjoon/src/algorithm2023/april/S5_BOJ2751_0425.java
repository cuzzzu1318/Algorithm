package algorithm2023.april;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S5_BOJ2751_0425 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[2000001];
		for(int i= 0;i<N;i++) {
			arr[Integer.parseInt(br.readLine())+1000000] = 1;
		}
		for(int i = 0;i<2000001;i++) {
			if(arr[i]==1) {
				bw.write(Integer.toString(i-1000000)+"\n");
			}
		}
		bw.flush();
		bw.close();
	}
}