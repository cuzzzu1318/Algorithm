package study;

/*다이나믹 프로그래밍 실습
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DP {

	static long[] fibDP = new long[100];

	static long fib(int n) {
		// 탑다운
		if (n == 0) {
			return 0;
		} else if (n == 1 || n == 2) {
			return 1;
		} else {
			if (fibDP[n] != 0) {
				return fibDP[n];
			} else {
				fibDP[n] = fib(n - 1) + fib(n - 2);
				return fibDP[n];
			}

		}
	}

	static int max(int a, int b) {
		if (a > b) {
			return a;
		} else {
			return b;
		}
	}

	
	static int forOne(int n, int[] d) {
		if(n==1) {
			return 1;
		}
		if(d[n]!=0) {
			return d[n];
		}
		d[n] = forOne(n-1,d)+1;
		if(n%5==0) {
			d[n] = Math.min(d[n], forOne(n/5,d)+1);
		}if(n%3==0) {
			d[n] = Math.min(d[n], forOne(n/3,d)+1);
		}if(n%2==0) {
			d[n] = Math.min(d[n], forOne(n/2,d)+1);
		}
		return d[n];
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//피보나치 문제
		//System.out.println("top-down: " + fib(50));
		Arrays.fill(fibDP, 0);
		fibDP[0] = 0;
		fibDP[1] = 1;
		fibDP[2] = 1;
		// 보텀업
		for (int i = 3; i <= 50; i++) {
			fibDP[i] = fibDP[i - 1] + fibDP[i - 2];
		}
		//System.out.println("bottom-up: " + fibDP[50]);
		
		//개미전사 문제
		int[] storage = {1,3,1,5};
		int[] d = new int[4];
		d[0] = storage[0];
		d[1] = max(d[0], storage[1]);
		for(int i = 2;i<4;i++) {
			//현재 창고+두칸 이전 창고까지의 최댓값 vs 이전 창고까지의 최댓값 비교 
			d[i] = max(d[i-1], d[i-2]+storage[i]);
		}
		Arrays.sort(d);
		//System.out.println(d[3]);
		
		
		int X = Integer.parseInt(br.readLine());
		
		d = new int[X+1];
		Arrays.fill(d, 0);
		d[0] = 1;
		d[1] = 1;
		System.out.println(forOne(X, d));
		
		
		
	}
}