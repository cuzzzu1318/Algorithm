package algorithm2023.april;

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
	   //������ ���� N��, ������ �ϴ� ��ġ K
	   
	   int[] coins = new int[N];
	   //���� �迭
	   for(int i = 0;i<N;i++) {
		   //�Է����� ���� �迭 �ʱ�ȭ
		   coins[i] = Integer.parseInt(br.readLine());
	   }
	   
	   int cnt = 0;
	   for(int i = N-1;i>=0;i--) {
		   //���������̹Ƿ� �������� Ž���Ͽ� ū �������� Ž��
		   if(K>=coins[i]) {
			   //ū ���������� ŭ -> ū ���� ��� ����. -> ū ������ ����� �� �ִ� ��ŭ ����ϰ� �������� ����
			   cnt+=K/coins[i];
			   K%=coins[i];
		   }
	   }
	   bw.write(Integer.toString(cnt));
	   bw.flush();
	   bw.close();
   }
}