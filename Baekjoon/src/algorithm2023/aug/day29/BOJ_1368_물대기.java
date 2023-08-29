package algorithm2023.aug.day29;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
 * MST이용하여 풀이하는 문제
 * 각 논에 대해 선택지가 두개
 * - 스스로 우물을 뚫는 것 / 다른 논에 연결하는 것.
 * 스스로 우물을 뚫는 선택지를 가상의 노드로 두고 MST만들면 해결
 * 
 */

public class BOJ_1368_물대기 {

	//논의 개수 N
	static int N;
	//간선의 정보를 저장하는 그래프
	static ArrayList<Edge> graph = new ArrayList<>();
	
	//Union-Find
	static int[] parent;

	static StringTokenizer st;
	static StringBuilder sb;

	static int find(int x) {
		if (parent[x] == x)
			return x;

		return parent[x] = find(parent[x]);
	}

	static boolean union(int x, int y) {
		int px = find(x);
		int py = find(y);

		if (px == py)
			return false;

		parent[px] = py;
		return true;
	}

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		//Union-Find init
		parent = new int[N + 1];
		for(int i= 0;i<=N;i++) {
			parent[i] = i;
		}
		
		//가상의 노드 0번에 대한 정보 저장 -> 스스로 우물을 뚫는 경우
		for (int i = 1; i <= N; i++) {
			graph.add(new Edge(0,i,Integer.parseInt(br.readLine())));
		}

		//각각의 논을 연결하는 경우 저장, 중복되는 경우 제외
		for (int i =1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int cost = Integer.parseInt(st.nextToken());
				if(j>i) {
					graph.add(new Edge(i,j,cost));
				}
			}
		}
		
		//크루스칼 알고리즘을 사용하기 위해 정렬
		Collections.sort(graph, (o1,o2)->o1.cost-o2.cost);
		
		//총 비용을 저장할 변수
		int sum =0;
		
		//크루스칼 알고리즘
		for(int i= 0;i<graph.size();i++) {
			Edge cur = graph.get(i);
			if(union(cur.a,cur.b))sum+=cur.cost;
		}
		System.out.println(sum);

	}

	static class Edge {
		int a;
		int b;
		int cost;

		public Edge(int a, int b, int cost) {
			this.a = a;
			this.b = b;
			this.cost = cost;
		}

	}
}
