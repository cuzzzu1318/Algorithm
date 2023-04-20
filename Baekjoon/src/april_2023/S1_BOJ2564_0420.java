package april_2023;

/*  
 * 난이도 : 
 * 아이디어: 
 * 시간복잡도:
 * 소요 시간: 
 * */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S1_BOJ2564_0420 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int w;
	static int h;

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer s = new StringTokenizer(br.readLine(), " ");
		w = Integer.parseInt(s.nextToken());
		h = Integer.parseInt(s.nextToken());
		int n = Integer.parseInt(br.readLine());
		// 가로, 세로, 상점 개수
		int sum = 0;
		// 거리 총 합 기록할 변수
		ArrayList<store> arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			// 상점의 위치 정보 기록
			s = new StringTokenizer(br.readLine(), " ");
			store st = new store(s.nextToken(), s.nextToken());
			arr.add(st);
		}
		s = new StringTokenizer(br.readLine(), " ");

		int dDir = Integer.parseInt(s.nextToken());
		int dDis = Integer.parseInt(s.nextToken());
		// 동근이의 위치 정보
		for(store st : arr) {
			sum+=st.calcDis(dDir, dDis);
		}
		bw.write(Integer.toString(sum));
		bw.flush();
		bw.close();

	}

	static class store {
		int dir;
		// 방향 - 1: 북, 2: 남, 3: 서, 4: 동
		int dis;
		// 거리 - 북 남일 경우 왼쪽기준, 동 서일경우 위쪽기준

		store(String dir, String dis) {
			this.dir = Integer.parseInt(dir);
			this.dis = Integer.parseInt(dis);
		}

		private int calcDis(int dDir, int dDis) {
			int min = 0;

			int clock;
			//시계방향 거리
			int rClock;
			//반시계방향 거리
			switch (dDir) {
			// 동근이의 방향
			case 1:
				// 북
				switch (dir) {
				// 상점의 방향
				case 1:
					// 북
					min = Math.abs(dDis-dis);
					break;
				case 2:
					// 남
					clock = w-dDis+h+w-dis;
					rClock = dDis+h+dis;
					min = Math.min(clock, rClock);
					break;
				case 3:
					// 서
					min = dDis+dis;
					break;
				default:
					// 동
					min = w-dDis+dis;
				}
				break;
			case 2:
				// 남
				switch (dir) {
				// 상점의 방향
				case 1:
					// 북
					clock = dDis+h+dis;
					rClock = w-dDis+h+w-dis;
					min = Math.min(clock, rClock);
					break;
				case 2:
					// 남
					min = Math.abs(dis-dDis);
					break;
				case 3:
					// 서
					min = dDis+h-dis;
					break;
				default:
					// 동
					min = w-dDis+h-dis;
				}
				break;
			case 3:
				// 서
				switch (dir) {
				// 상점의 방향
				case 1:
					// 북
					min = dDis+dis;
					break;
				case 2:
					// 남
					min = h-dDis+dis;
					break;
				case 3:
					// 서
					min = Math.abs(dDis-dis);
					break;
				default:
					// 동
					clock = dDis+w+dis;
					rClock = h-dDis+w+h-dis;
					min = Math.min(clock, rClock);
					
				}
				break;
			default:
				// 동
				switch (dir) {
				// 상점의 방향
				case 1:
					// 북
					min = dDis+w-dis;
					break;
				case 2:
					// 남
					min = h-dDis+w-dis;
					break;
				case 3:
					// 서
					clock = h-dDis+w+h-dis;
					rClock = dDis+w+dis;
					min = Math.min(clock, rClock);
					break;
				default:
					// 동
					min = Math.abs(dDis-dis);
				}
			}
			return min;
		}
	}
}