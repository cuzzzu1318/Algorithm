package algorithm2023.aug.day29;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
 * Union-Find 이용
 * 별의 위치를 입력받아 저장하고
 * 모든 별에 대해 서로의 거리를 저장.
 * 해당 값을 정렬하여 크루스칼 알고리즘
 */
public class BOJ_4386_별자리만들기 {
	static int n, parent[];
	static double sum;
	
	static StringTokenizer st;
	static StringBuilder sb;
	
	//별의 위치를 저장하는 배열과 해당 위치들을 이용하여 간선을 저장하는 배열
	static ArrayList<Star> star = new ArrayList<>();
	static ArrayList<Edge> edge = new ArrayList<>();
	
	static void init(int n) {
		parent = new int[n+1];
		for(int i =0 ;i<n+1;i++) {
			parent[i] = i;
		}
	}
	
	static int find(int x) {
		if(parent[x] == x)return x;
		
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
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		init(n);
		
		for(int i =0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			star.add(new Star(y,x));
		}

		for(int i =0;i<n;i++) {
			for(int j= 0;j<n;j++) {
				if(i!=j) {
					edge.add(new Edge(i,j, getDis(star.get(i), star.get(j))));
				}
			}
		}
		
		Collections.sort(edge,(o1,o2)->Double.compare(o1.cost, o2.cost));
		
		for(int i= 0;i<edge.size();i++) {
			Edge cur = edge.get(i);
			
			if(union(cur.a,cur.b)) {
				sum+=cur.cost;
			}
		}
		System.out.println(String.format("%.2f", sum));
	}
	
	static class Star{
		double y;
		double x;
		public Star(double y, double x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
	
	static class Edge{
		int a;
		int b;
		double cost;
		public Edge(int a, int b, double cost) {
			super();
			this.a = a;
			this.b = b;
			this.cost = cost;
		}
		
		
	}
	
	static double getDis(Star a, Star b) {
		return Math.sqrt(Math.pow(a.x-b.x, 2) + Math.pow(a.y-b.y, 2));
		
	}
}
