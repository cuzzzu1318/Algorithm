package jan_2022;

/* n���� �������� k�� �����
 * ���̵� : ���5
 * ���̵��: ��� ������ �� ����
 * �ð����⵵:
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class BOJ2293 {

	
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int K = Integer.parseInt(s[1]);
		ArrayList<Integer> coins = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			coins.add(Integer.parseInt(br.readLine()));
		}
		int[] dp = new int[K+1];
		Arrays.fill(dp, 0);
		dp[0] = 1;
		for(int i = 0;i<N;i++) {
			for(int j = coins.get(i);j<=K;j++) {
				dp[j] +=dp[j-coins.get(i)];
			}
		}
		System.out.println(dp[K]);
	}
}