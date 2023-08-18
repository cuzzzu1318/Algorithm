package algorithm2023.aug.day18;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_5644_무선충전 {

	static int[] dy = { 0, -1, 0, 1, 0 };
	static int[] dx = { 0, 0, 1, 0, -1 };

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int M = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			int[] pA = new int[M];
			int[] pB = new int[M];

			int ay = 1;
			int ax = 1;
			int by = 10;
			int bx = 10;

			ArrayList<BC> bc = new ArrayList<>();

			st = new StringTokenizer(br.readLine(), " ");
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			//사람 움직임 저장
			for (int i = 0; i < M; i++) {
				pA[i] = Integer.parseInt(st.nextToken());
				pB[i] = Integer.parseInt(st2.nextToken());
			}
			//bc 저장
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				bc.add(new BC(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}

			//총 충전량 저장할 변수
			int cnt = 0;
			
			//이동시키며 확인
			for (int i = 0; i <= M; i++) {
				//연결됐는지 확인하는 배열
				boolean[][] isConnected = new boolean[A][2];
				
				//모든 BC를 확인하며 연결 가능한지 확인
				for (int j = 0; j < A; j++) {
					BC charger = bc.get(j);
					int dA = Math.abs(charger.X - ax) + Math.abs(charger.Y - ay);
					int dB = Math.abs(charger.X - bx) + Math.abs(charger.Y - by);
					if (dA <= charger.C)
						isConnected[j][0] = true;
					if (dB <= charger.C)
						isConnected[j][1] = true;
				}
				int sum = 0;

				//BC 확인하며 최댓값 구함
				for (int j = 0; j < A; j++) {
					if (isConnected[j][0]) {
						sum = Math.max(sum, bc.get(j).P);
						for (int k = 0; k < A; k++) {
							if (j!=k&&isConnected[k][1]) {
								sum = Math.max(sum, bc.get(j).P + bc.get(k).P);
							}
						}
					}
					if (isConnected[j][1]) {
						sum = Math.max(sum, bc.get(j).P);
						for (int k = 0; k < A; k++) {
							if (j!=k&&isConnected[k][0]) {
								sum = Math.max(sum, bc.get(j).P + bc.get(k).P);
							}
						}
					}
				}
				cnt += sum;
				//처음위치부터 구했으므로 종료조건 추가
				if (i == M)
					break;
				//이동
				ax += dx[pA[i]];
				ay += dy[pA[i]];
				bx += dx[pB[i]];
				by += dy[pB[i]];
			}
			sb.append("#").append(t).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
	}

	static class BC {
		int X;
		int Y;
		int C;
		int P;

		public BC(int x, int y, int c, int p) {
			super();
			X = x;
			Y = y;
			C = c;
			P = p;
		}

	}
}
