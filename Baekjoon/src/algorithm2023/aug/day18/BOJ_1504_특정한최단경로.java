package algorithm2023.aug.day18;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1504_특정한최단경로 {
	static int N, E, v1, v2, graph[][];

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		//노드의 개수 N과 간선의 개수 E
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		//노드가 1부터 시작이기 때문에 1개 더 만들어줌
		graph = new int[N + 1][N + 1];
		
		//그래프 입력
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			//양방향 연결
			graph[a][b] = c;
			graph[b][a] = c;
		}
		st = new StringTokenizer(br.readLine(), " ");
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());
		//v1을 먼저 방문하는 경우
		long cnt = 0;
		cnt+=dijkstra(1,v1);
		cnt+=dijkstra(v1,v2);
		cnt+=dijkstra(v2,N);
		
		long cnt2 = 0;
		//v2를 먼저 방문하는 경우
		cnt2+=dijkstra(1,v2);
		cnt2+=dijkstra(v2,v1);
		cnt2+=dijkstra(v1,N);
		
		//둘 중 최솟값을 구함
		cnt = Math.min(cnt, cnt2);
		//int max value를 넘어서면 경로가 없는 리턴이 하나 이상 있다는 것이므로 -1 출력
		System.out.println((cnt>=Integer.MAX_VALUE)?-1:cnt);
		

	}
	
	//우선순위 큐 사용한 다익스트라
	static int dijkstra(int start, int dest) {
		PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.dist - o2.dist);
		int[] dijk = new int[N+1];
		Arrays.fill(dijk, Integer.MAX_VALUE);
		dijk[start] = 0;
		q.add(new Node(start,0));
		while (!q.isEmpty()) {
			Node cur = q.poll();
			for(int i= 1;i<=N;i++) {
				if(graph[cur.num][i]>0) {
					int nDist = cur.dist+graph[cur.num][i];
					if(nDist<=dijk[i]) {
						dijk[i] = nDist;
						q.offer(new Node(i,nDist));
					}
					
				}
			}
		}
		return dijk[dest];
	}

	static class Node {
		int num;
		int dist;

		public Node(int num, int dist) {
			this.num = num;
			this.dist = dist;
		}
	}
}
