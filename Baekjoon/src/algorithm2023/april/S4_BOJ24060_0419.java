package algorithm2023.april;

/*  
 * ���̵� : 
 * ���̵��: 
 * �ð����⵵:
 * �ҿ� �ð�: 16:10~
 * */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class S4_BOJ24060_0419 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N;
	static int K;
	static int ans;
	static int cnt = 0;
	static int[] arr;
	
	
	static void canDivide(int start, int end) {
		if(end>start) {
			int m = (start+end)/2;
			canDivide(start,m);
			canDivide(m+1,end);
			find(start, end, m);
		}
	}
	
	static void find(int start, int end, int m) {
		for(int i = start; i<=end;i++) {
			cnt++;
			if(cnt==K) {
				//System.out.println(end+"   "+start);
				int[] temp = new int[end-start+1];
				int idx = 0;
				for(int j = start;j<=end;j++) {
					temp[idx++] = arr[j];
				}
				Arrays.sort(temp);
				System.out.println(temp[i-start]);
			}
			//System.out.println(arr[i]+" "+ cnt);
		}
	}
	
	static void merge(int start, int end) {
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		K = Integer.parseInt(s[1]);
		arr = new int[N];
		s = br.readLine().split(" ");
		for(int i = 0;i<N;i++) {
			arr[i] = Integer.parseInt(s[i]);
		}
		
		canDivide(0,arr.length-1);
		if(cnt<K) {
			System.out.println(-1);
		}

		
		
	}
}