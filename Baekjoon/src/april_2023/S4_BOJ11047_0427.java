package april_2023;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S4_BOJ11047_0427 {
   static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
   
   public static void main(String[] args) throws NumberFormatException, IOException {
	   String[] s = br.readLine().split(" ");
	   int N = Integer.parseInt(s[0]);
	   int K = Integer.parseInt(s[1]);
	   //동전의 종류 N개, 만들어야 하는 가치 K
	   
	   int[] coins = new int[N];
	   //동전 배열
	   for(int i = 0;i<N;i++) {
		   //입력으로 동전 배열 초기화
		   coins[i] = Integer.parseInt(br.readLine());
	   }
	   
	   int cnt = 0;
	   for(int i = N-1;i>=0;i--) {
		   //오름차순이므로 역순으로 탐색하여 큰 동전부터 탐색
		   if(K>=coins[i]) {
			   //큰 동전값보다 큼 -> 큰 동전 사용 가능. -> 큰 동전을 사용할 수 있는 만큼 사용하고 나머지를 남김
			   cnt+=K/coins[i];
			   K%=coins[i];
		   }
	   }
	   bw.write(Integer.toString(cnt));
	   bw.flush();
	   bw.close();
   }
}