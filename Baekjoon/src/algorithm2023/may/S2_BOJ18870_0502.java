package algorithm2023.may;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class S2_BOJ18870_0502 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {

		int N = Integer.parseInt(br.readLine());
		ArrayList<Long> arr = new ArrayList<>();
		ArrayList<Long> sorted = new ArrayList<>();
		String[] s = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr.add(Long.parseLong(s[i]));
			sorted.add(Long.parseLong(s[i]));
		}
		Collections.sort(sorted);
		
		HashMap<Long, Integer> map = new HashMap<>();
		int rank = 0;
		for(int i =0;i<sorted.size();i++) {
			if(!map.containsKey(sorted.get(i))) {
				map.put(sorted.get(i),rank++);
			}
		}
		for(int i = 0;i<N;i++) {
			sb.append(map.get(arr.get(i))+" ");
		}
		System.out.println(sb);
		
		

	}
}