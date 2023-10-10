package algorithm2023.oct.day10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1135_뉴스전하기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N;
	static ArrayList<ArrayList<Integer>> graph;

	public static void main(String[] args) throws Exception {

		// 직원의 수 N
		N = Integer.parseInt(br.readLine());

		//인접리스트
		graph = new ArrayList<>();
		for(int i =0;i<=N;i++) {
			graph.add(new ArrayList<>());
		}
		

		st = new StringTokenizer(br.readLine());
		
		//0번째 인덱스는 상사가 -1이므로 버림.
		st.nextToken();

		for (int i = 1; i < N; i++) {
			int boss = Integer.parseInt(st.nextToken());
			graph.get(boss).add(i);
		}
		
		System.out.println(getMin(0));
		
		
		
	}
	
	static int getMin(int n) {
		//부하직원의 수 => 전화를 s분동안 돌릴 것
		int s = graph.get(n).size();
		//부하 직원들의 전화돌리는 시간 구할 배열
		int[] child = new int[s];
		//해당 직원이 전화를 모두 돌리는 시간
		int max = 0;
		int i =0;
		//부하직원이 전화를 돌리는데 걸리는 시간을 재귀로 구함.
		for(int next : graph.get(n)) {
			child[i++] = getMin(next);
		}
		//부하직원 정렬
		Arrays.sort(child);
		//시간이 오래걸리는 부하를 1분에 거는 것으로 하여 최댓값 구하기. 해당 경우가 반드시 가장 빠른 경우이므로 그 중 최댓값을 구해야 함.
		for(i= 1;i<=s;i++) {
			max = Math.max(max, child[s-i]+i);
		}
		
		return max;
	}
}
