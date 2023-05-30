package may_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G5_BOJ1916_0530 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int M;
	static int[][] bus;
	static int[] costs;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		bus = new int[N + 1][N + 1];
		//버스를 그래프 형식으로 저장.
		
		
		costs = new int[N + 1];
		//최소 가격을 저장할 배열.
		
		
		Arrays.fill(costs, 100000000);
		//초기 값은 모든 마을을 최대 비용으로 다닌 값인 100000000으로 초기화
		
		
		for(int i = 0;i<N+1;i++) {
			Arrays.fill(bus[i], 100000000);
			//버스 또한 초기화
		}
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			bus[a][b] = Math.min(bus[a][b], cost);
			
		}

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		find(a, b, 0);
		System.out.println(costs[b]);

	}

	static void find(int start, int dest, int cost) {
		PriorityQueue<cost> pq = new PriorityQueue<>((e1,e2)->{
			//다익스트라에 사용할 우선순위 큐 -> 클래스로 비교하기 위해 비교 함수 구현
			if(e1.cost>e2.cost) {
				return e1.cost-e2.cost;
			}else {
				return e2.cost-e1.cost;
			}
		}); 
		
		pq.add(new cost(start,0));
		while(!pq.isEmpty()) {
			//다익스트라
			cost c = pq.poll();
			for(int i =1;i<=N;i++) {
				int dist = c.cost+bus[c.num][i];
				if(costs[i]>dist) {
					costs[i]=dist;
					pq.add(new cost(i,dist));
				}
			}
		}
		
	}
	
	static class cost{
		int num;
		int cost;
		cost(int num, int cost){
			this.num = num;
			this.cost = cost;
		}
	}
}