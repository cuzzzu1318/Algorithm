package algorithm2023.oct.day10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_4013_특이한자석 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int K;
	static Magnet[] magnets;

	static class Magnet {
		int[] m = new int[8];
		int l, r;

		public Magnet(int l, int r) {
			super();
			this.l = l;
			this.r = r;
		}

	}

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			K = Integer.parseInt(br.readLine());

			magnets = new Magnet[5];
			for (int i = 1; i <= 4; i++) {
				magnets[i] = new Magnet(6, 2);
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					magnets[i].m[j] = Integer.parseInt(st.nextToken());
				}

			}

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int n = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				rotate(n,d);
				for(int j = 1;j<=4;j++) {
					Magnet m = magnets[j];
				}
			}
			sb.append("#").append(t).append(" ").append(count()).append("\n");
		}
		System.out.println(sb);
		
	}
	
	static int count() {
		int sum = 0;
		for(int i =1;i<=4;i++) {
			if(magnets[i].m[(magnets[i].l+2)%8]==1) {
				sum+=Math.pow(2, i-1);
			}
		}
		
		return sum;
			
			
	}

	static void rotate(int n, int d) {
		// 왼쪽에 톱니가 있는 경우
		if (n > 1) {
			if (magnets[n - 1].m[magnets[n - 1].r] != magnets[n].m[magnets[n].l]) {
				leftR(n-1,-d);
			}

		}
		// 오른쪽에 톱니가 있는 경우
		if (n < 4) {
			if (magnets[n + 1].m[magnets[n + 1].l] != magnets[n].m[magnets[n].r]) {
				rightR(n+1,-d);
			}
		}
		magnets[n].l -= d;
		if(magnets[n].l<0)magnets[n].l=7;
		if(magnets[n].l>7)magnets[n].l=0;
		magnets[n].r -= d;
		if(magnets[n].r<0)magnets[n].r=7;
		if(magnets[n].r>7)magnets[n].r=0;
	}
	

	static void leftR(int n, int d) {
		if (n > 1) {
			if (magnets[n - 1].m[magnets[n - 1].r] != magnets[n].m[magnets[n].l]) {
				leftR(n-1,-d);
			}

		}
		magnets[n].l -= d;
		if(magnets[n].l<0)magnets[n].l=7;
		if(magnets[n].l>7)magnets[n].l=0;
		magnets[n].r -= d;
		if(magnets[n].r<0)magnets[n].r=7;
		if(magnets[n].r>7)magnets[n].r=0;
	}

	static void rightR(int n, int d) {
		if (n < 4) {
			if (magnets[n + 1].m[magnets[n + 1].l] != magnets[n].m[magnets[n].r]) {
				rightR(n+1,-d);
			}
		}
		magnets[n].l -= d;
		if(magnets[n].l<0)magnets[n].l=7;
		if(magnets[n].l>7)magnets[n].l=0;
		magnets[n].r -= d;
		if(magnets[n].r<0)magnets[n].r=7;
		if(magnets[n].r>7)magnets[n].r=0;
	}
}
