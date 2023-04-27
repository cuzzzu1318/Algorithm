package april_2023;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class S4_BOJ11399_0427 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		int[] fib = new int[N];
		String[] s = br.readLine().split(" ");
		for(int i = 0;i<N;i++) {
			//배열에 걸리는 시간 입력
			fib[i] = Integer.parseInt(s[i]);
		}
		Arrays.sort(fib);
		//시간이 적게 걸리는 순으로 정렬
		int sum = fib[0];
		//첫번째 사람의 시간 입력
		for(int i= 1;i<N;i++) {
			//두번째 사람부터 계산
			fib[i] +=fib[i-1];
			sum+=fib[i];
		}
		
		bw.write(Integer.toString(sum));
		bw.flush();
		bw.close();
	}
}