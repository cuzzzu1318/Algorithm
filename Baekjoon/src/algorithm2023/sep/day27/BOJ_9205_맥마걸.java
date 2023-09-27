package algorithm2023.sep.day27;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9205_맥마걸 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb =  new StringBuilder();
	
	static int n;
	static Node nodes[];
	static boolean[] v;
	
	
	static class Node{
		int x,y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		
	}
	
	public static void main(String[] args) throws Exception{
		int T = Integer.parseInt(br.readLine());
		for(int t = 0;t<T;t++) {
			n = Integer.parseInt(br.readLine());
			nodes = new Node[n+2];
			v = new boolean[n+2];
			for(int i =0;i<n+2;i++) {
				st =new StringTokenizer(br.readLine());
				nodes[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			
			Queue<Node> q = new ArrayDeque<>();
			
			q.add(nodes[0]);
			
			l:
			while(!q.isEmpty()) {
				Node node = q.poll();
				for(int i =0;i<n+2;i++) {
					if(v[i])continue;
					
					int dist =  Math.abs(node.x-nodes[i].x) + Math.abs(node.y-nodes[i].y);
					if(dist<=1000) {
						v[i] = true;
						q.add(nodes[i]);
						if(i==n+1) break l;
					}
				}
			}
			
			
			if(v[n+1])sb.append("happy\n");
			else sb.append("sad\n");
		}
		System.out.println(sb);
		
	}
	
	
	
}
