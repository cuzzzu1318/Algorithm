package study.mst;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MinimumSpanningTree {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N, M;
	
	//프림을 위한 그래프
	static ArrayList<ArrayList<Edge>> pEdge = new ArrayList<>();
	
	//크루스칼을 위한 그래프
	static ArrayList<Edge> kEdge = new ArrayList<>();
	
	static int[] parent;
	
	
	static class Edge{
		int from,to,cost;

		public Edge(int from, int to, int cost) {
			super();
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", cost=" + cost + "]";
		}
	}
	
	static void init(int n) {
		parent = new int[n+1];
		for(int i =0 ;i<=n;i++) {
			parent[i] = i;
		}
	}
	
	static int find(int x) {
		if(parent[x]==x)return x;
		return parent[x] = find(parent[x]);
	}
	
	static boolean union(int x, int y) {
		int px = find(x);
		int py = find(y);
		
		if(px==py)return false;
		
		parent[px] = py;
		return true;
	}
	
	public static void main(String[] args) throws Exception{
		//정점의 수 N, 간선의 수 M
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		for(int i =0;i<=N;i++) {
			pEdge.add(new ArrayList<>());
		}
		
		for(int i =0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int from  = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			pEdge.get(from).add(new Edge(from, to, cost));
			pEdge.get(to).add(new Edge(to,from,cost));
			
			
			kEdge.add(new Edge(from, to, cost));
		}
		
//		System.out.println(prim());
		System.out.println(kruskal());
		
	}
	
	static int prim() {
/*		
		프림 알고리즘
		시작 정점을 정해 출발
		해당 정점의 간선을 모두 확인한 후 PQ에 넣으면서 확인
		가장 비용이 적은 값부터 확인해 나가며 사이클이 생기지 않게끔 함.
*/		
		int sum = 0;
		
		PriorityQueue<Edge> pq = new PriorityQueue<>((o1,o2)->{
			return o1.cost-o2.cost;
		}) ;
		boolean[] v = new boolean[N+1];
		pq.add(new Edge(1,1,0));
		
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			if(!v[cur.to]) {
				v[cur.to]= true;
				sum+=cur.cost;
				for(Edge e : pEdge.get(cur.to)) {
					if(!v[e.to]) {
						pq.add(e);
					}
				}
			}
		}
		
		
		return sum;
	}
	
	static int kruskal() {
/*		
		크루스칼 알고리즘
		그리디한 선택을 바탕으로 알고리즘을 진행
		간선의 연결비용을 기준으로 오름차순 정렬
		낮은 간선부터 시작하여 양 끝 점을 Union, 같은 집합에 속해 있다면 사이클이 생긴 것으로 판단
		사이클이 생기지 않았다면 성공적으로 union하고 mst에 포함시킴
*/		
		init(N);
		Collections.sort(kEdge, (o1,o2)->o1.cost-o2.cost);
		int sum = 0;
		for(Edge e : kEdge) {
			if(union(e.to, e.from)) {
				sum+=e.cost;
			}
		}
		return sum;
	}
}	
