package algorithm2023.aug.day28;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//보글보글 타자감
//키보드 이뿌다 정호얌
//멋쨍이 정호
//존잘 정호
//정호 팬클럽 1호
//아니ㅣㅣㅣ가격도 괜찮네 
//나도살래나도살래나도살래나도살래나도살래 ㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎ우왕아아아아진짜 대박
//고마워 잘쓸께 ~~~
//안줘도 되는데 


public class BOJ_1647_도시분할계획 {
	static int N, M;
	static ArrayList<Edge> edge = new ArrayList<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i =0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			edge.add(new Edge(a,b,c));
		}
		
		
	}
	
	static class Edge{
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
