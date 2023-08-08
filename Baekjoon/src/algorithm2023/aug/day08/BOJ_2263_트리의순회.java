package algorithm2023.aug.day08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_2263_트리의순회 {
	static int N;
	static ArrayList<String> in = new ArrayList<>();
	static ArrayList<String> post = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			in.add(st.nextToken());
			post.add(st1.nextToken());
		}
		String head = post.get(N-1);
		int idx = in.indexOf(head);
		ArrayList<String> left = new ArrayList<>();
		ArrayList<String> right = new ArrayList<>();
		System.arraycopy(in, 0, left, 0, idx);
		System.arraycopy(in, idx+1, right, 0, in.size());
		System.out.println(left);
		System.out.println(right);
		
		
	}
	static void pre(ArrayList<String> left,ArrayList<String> right, int head ) {
		
	}
	
	

}
