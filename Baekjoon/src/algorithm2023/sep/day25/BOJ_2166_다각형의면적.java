package algorithm2023.sep.day25;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2166_다각형의면적 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N;
	static ArrayList<Node> nodeList = new ArrayList<>();
	
	static class Node{
		int num,x,y;

		public Node(int num,int x, int y) {
			super();
			this.num = num;
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		
		for(int i =0 ;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			nodeList.add(new Node(i,x,y));
		}
		
		
	}
}
