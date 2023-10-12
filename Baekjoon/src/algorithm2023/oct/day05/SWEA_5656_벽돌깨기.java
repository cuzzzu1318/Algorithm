package algorithm2023.oct.day05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA_5656_벽돌깨기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, W, H, map[][],ans;
	static ArrayList<LinkedList<Integer>> block;
	
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1};
	
	static boolean isValid(int y, int x) {
		if(y<0||x<0||y>=H||x>=W)return false;
		return true;
	}

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			ans = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			block = new ArrayList<>();

			map = new int[H][W];

			for (int i = 0; i < W; i++) {
				block.add(new LinkedList<>());
			}

			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0;i<W;i++) {
				for(int j = H-1;j>=0;j--) {
					if(map[j][i]>0)block.get(i).add(map[j][i]);
				}
				
			}
			
			
			
			perm(0);

			sb.append("#").append(t).append(" ").append(ans==Integer.MAX_VALUE?0:ans).append("\n");
		}
		System.out.println(sb);
	}

	static void perm(int idx) {
		if (idx == N) {
			ans = Math.min(ans, count());
			return;
		}
		
		for(int i = 0;i<W;i++) {
			if(!block.get(i).isEmpty()) {
				ArrayList<LinkedList<Integer>> temp = new ArrayList<>();
				for(int j = 0;j<W;j++) {
					temp.add((LinkedList<Integer>) block.get(j).clone());
				}
				int y = H-block.get(i).size();
				check(y,i );
				remove();
				perm(idx+1);
				for(int j = 0;j<W;j++) {
					block.set(j, (LinkedList<Integer>) temp.get(j).clone());
				}
			}
		}
	}
	
	static void check(int y, int x) {
		int pow = block.get(x).get(H-y-1);
		block.get(x).set(H-y-1, -1);
		
		for(int d = 0;d<4;d++){
			int ny = y;
		int nx = x;
			for(int i = 1;i<pow;i++) {
				ny +=dy[d];
				nx +=dx[d];
				if(!isValid(ny,nx))continue;
				if(H-block.get(nx).size()<=ny) {
					if(block.get(nx).get(H-ny-1)>1) {
						check(ny,nx);
					}
					block.get(nx).set(H-ny-1, -1);
				}
			}
		}
	}
	
	static void remove() {
		for(int i =0;i<W;i++) {
			for(int j = block.get(i).size()-1;j>=0;j--) {
				if(block.get(i).get(j)==-1)block.get(i).remove(j);
			}
		}
	}

	static int count() {
		int cnt = 0;
		for(int i = 0;i<W;i++) {
			cnt+=block.get(i).size();
		}
		return cnt;
	}
	
	static void print() {
		for(int i =0;i<W;i++) {
			System.out.println(block.get(i));
		}
	}
}
