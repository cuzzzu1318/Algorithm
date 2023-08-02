package algorithm2023.aug.day02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ14697 {
	static int N, room[], dp[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i= 0;i<3;i++) {
			room[i] = Integer.parseInt(st.nextToken());
		}
		N = Integer.parseInt(st.nextToken());
		dp = new int[N+1];
		for(int i =1;i<=N;i++) {
			
		}
		
	}
}
