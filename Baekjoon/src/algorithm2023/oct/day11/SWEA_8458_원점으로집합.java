package algorithm2023.oct.day11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class SWEA_8458_원점으로집합 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N;
	static ArrayList<Integer> pos;

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			
			N = Integer.parseInt(br.readLine());
			pos = new ArrayList<>();
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int dist = Math.abs(x) + Math.abs(y);
				pos.add(dist);
			}
			sb.append("#").append(t).append(" ");
			if (!isValid()) {
				sb.append(-1);
			} else {
				Collections.sort(pos);
				int far = pos.get(pos.size()-1);
				int i =0;
				
				while(true) {
					far-=i;
					if(far==0) {
						break;
					}
					if(far<0) {
						far = Math.abs(far);
						if(far%2==0) {
							break;
						}
					}
					i++;
					
				}
				sb.append(i);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static boolean isValid() {
		
		int first = pos.get(0);
		for(int i =1;i<pos.size();i++) {
			int d = pos.get(i);
			if(first%2!=d%2)return false;
		}
		
		return true;
	}
}
