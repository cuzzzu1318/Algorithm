package algorithm2023.oct.day18;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10159_저울 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, M, indegree[], ans[];
	static boolean[] v;
	static ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

	public static void main(String[] args) throws Exception {

		// N개의 물건, M개의 물건 쌍
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		indegree = new int[N + 1];
		ans = new int[N + 1];
		v = new boolean[N + 1];

		// 인접 리스트 초기화
		for (int i = 0; i <= N; i++) {
			adjList.add(new ArrayList<>());
			ans[i] = N;
		}

		// 입력 및 인접 리스트 값 추가
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adjList.get(a).add(b);
			indegree[b]++;
		}
		

	}
}
