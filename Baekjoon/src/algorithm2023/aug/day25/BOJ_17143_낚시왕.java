package algorithm2023.aug.day25;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_17143_낚시왕 {
	
	static int R, C, M, sum;
	static Shark[][] map;
	
	static int[] dy = {0,-1,1,0,0};
	static int[] dx = {0,0,0,1,-1};
	
	static ArrayList<Shark> sharks = new ArrayList<>();
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new Shark[R][C];
		
		for(int i =0 ;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int r= Integer.parseInt(st.nextToken())-1;
			int c= Integer.parseInt(st.nextToken())-1;
			int s= Integer.parseInt(st.nextToken());
			int d= Integer.parseInt(st.nextToken());
			int z= Integer.parseInt(st.nextToken());
			Shark shark = new Shark(r,c,s,d,z);
			sharks.add(shark);
			map[r][c] = shark;
		}
		
		for(int i = 0;i<C;i++) {
			catchShark(i);
			moveShark();
			killShark();
		}
		System.out.println(sum);
		
	}
	
	static void catchShark(int col) {
		for(int i =0;i<R;i++) {
			if(map[i][col]!=null) {
				sum+=map[i][col].z;
				sharks.remove(map[i][col]);
				break;
			}
		}
	}
	
	static void moveShark() {
		
		for(Shark shark : sharks) {
			int r = shark.r;
			int c = shark.c;
			int s = shark.s;
			int d = shark.d;
			
			switch(d) {
			//상, 하
			case 1:
			case 2:
				s = s % ((R-1)*2);
				for(int i = 0;i<s;i++) {
					//양끝이면 방향 전환
					
					if(r==0) d=2;
					else if(r==R-1)d = 1;
					r+=dy[d];
				}
				shark.r = r;
				shark.d = d;
				break;
			case 3:
			case 4:
				s = s % ((C-1)*2);
				for(int i = 0;i<s;i++) {
					//양끝이면 방향 전환
					
					if(c==0) d=3;
					else if(c==C-1)d = 4;
					c+=dx[d];
				}
				shark.c = c;
				shark.d = d;
				break;
			}
		}
	}
	
	//기존 맵 초기화
	//list -> map 기록하면서 겹치면 잡아먹음
	static void killShark() {
		
		//map 초기화
		for(int i =0;i<R;i++) {
			for(int j= 0;j<C;j++) {
				map[i][j] = null;
			}
		}
		
		//list를 이용해서 map 정리 
		int size = sharks.size();
		for(int i = size -1;i>=0;i--) {
			Shark s = sharks.get(i);
			if(map[s.r][s.c]==null)map[s.r][s.c]= s;
			else {
				if(s.z>map[s.r][s.c].z) {
					sharks.remove(map[s.r][s.c]);
					map[s.r][s.c]= s;
				}else sharks.remove(i);
			}
		}
	}
	
	static class Shark{
		int r;
		int c;
		int s;
		int d;
		int z;
		public Shark(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
		
		
		
	}
}
