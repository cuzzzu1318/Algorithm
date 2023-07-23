package algorithm2023.april;

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
			//�迭�� �ɸ��� �ð� �Է�
			fib[i] = Integer.parseInt(s[i]);
		}
		Arrays.sort(fib);
		//�ð��� ���� �ɸ��� ������ ����
		int sum = fib[0];
		//ù��° ����� �ð� �Է�
		for(int i= 1;i<N;i++) {
			//�ι�° ������� ���
			fib[i] +=fib[i-1];
			sum+=fib[i];
		}
		
		bw.write(Integer.toString(sum));
		bw.flush();
		bw.close();
	}
}