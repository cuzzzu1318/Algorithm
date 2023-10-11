package algorithm2023.oct.day11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_8382_방향전환 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N;
	static ArrayList<Integer> pos;
	
	static Pos start;
	static Pos dest;
	
	static class Pos{
		int x, y;

		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		
	}

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for(int t  =1;t<=T;t++) {
			st = new StringTokenizer(br.readLine());
			start = new Pos(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			dest = new Pos(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			int ans = 0;
			int diffY = Math.abs(start.y-dest.y);
			int diffX = Math.abs(start.x-dest.x);
			if(diffY<diffX) {
				ans+=diffY*2;
				ans+=(diffX-diffY)/2*4+(diffX-diffY)%2;
			}else {
				ans+=diffX*2;
				ans+=(diffY-diffX)*2-(diffY-diffX)%2;
			}
			
			
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
	
	
	
	
	
}
