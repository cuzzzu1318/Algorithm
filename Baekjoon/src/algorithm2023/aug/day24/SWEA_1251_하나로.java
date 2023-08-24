package algorithm2023.aug.day24;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_1251_하나로 {

	static int N;
	static double E;
	static boolean[] v;

	static ArrayList<Island> isl;
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			isl = new ArrayList<>();
			v = new boolean[N];

			for (int i = 0; i < N; i++) {
				isl.add(new Island());
			}

			StringTokenizer st = new StringTokenizer(br.readLine());
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				isl.get(i).setX(Integer.parseInt(st.nextToken()));
				isl.get(i).setY(Integer.parseInt(st2.nextToken()));
			}
			E = Double.parseDouble(br.readLine());
			
			sb.append("#").append(t).append(" ").append(String.format("%.0f", prim(0))).append("\n");
			
		}
		System.out.println(sb);

	}

	static double prim(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		double ret = 0;
		pq.add(new Edge(start, 0));
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			if (!v[cur.to]) {
				v[cur.to] = true;
				ret += cur.cost;
				for (int i = 0; i < isl.size(); i++) {
					if (!v[i]) {
						double cost = (Math.pow(isl.get(cur.to).y - isl.get(i).y, 2)
								+ Math.pow(isl.get(cur.to).x - isl.get(i).x, 2));
						pq.add(new Edge(i, cost));
					}
				}
			}
		}
		return E*ret;

	}

	static class Edge implements Comparable<Edge>{
		int to;
		double cost;

		public Edge(int start, double cost) {
			this.to = start;
			this.cost = cost;
		}

		@Override
		
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return (int) (this.cost-o.cost);
		}
		
		

	}

	static class Island {
		int y;
		int x;

		void setY(int y) {
			this.y = y;
		}

		void setX(int x) {
			this.x = x;
		}
	}
}
