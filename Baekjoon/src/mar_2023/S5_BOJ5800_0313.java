package mar_2023;

/*  시험 성적이 주어 졌을 때 최대, 최소, 점수 차 구하기
 * 난이도 : 실버 5
 * 아이디어: 
 * 시간복잡도:
 * 소요 시간: 21:06~ 
 * */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class S5_BOJ5800_0313 {

	static int K;
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		K = Integer.parseInt(br.readLine());
		for(int i = 0;i<K;i++) {
			String[] s = br.readLine().split(" ");
			N = Integer.parseInt(s[0]);
			int[] record = new int[N];
			for(int j = 1;j<=N;j++) {
				record[j-1] = Integer.parseInt(s[j]);
			}
			Arrays.sort(record);
			int max = 0;
			for(int j = 0;j<N-1;j++) {
				if(record[j+1]-record[j]>max) max = record[j+1]-record[j];
			}
			bw.write("Class "+(i+1)+"\n");
			bw.write("Max "+record[N-1]+", Min "+record[0]+", Largest gap "+max+"\n");
		}
		bw.flush();
		bw.close();
	}
}
