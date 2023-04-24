package april_2023;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class S3_BOJ1347_0424 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	// 아래쪽부터 시계방향으로 도는 방향벡터

	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split("");
		// 움직임 횟수와 움직임 입력

		String[][] map;

		int x = 0;
		int y = 0;
		// 최초의 홍준이 위치를 0,0으로 초기화

		int minX = 0;
		int maxX = 0;
		int minY = 0;
		int maxY = 0;
		// 지도의 크기를 구하기 위한 최소, 최대 기록

		int d = 0;
		// 방향벡터 인덱스

		for (int i = 0; i < N; i++) {
			switch (s[i]) {
			case "R":
				// R이면 방향벡터 시계방향 90도 회전
				d++;
				d %= 4;
				break;
			case "L":
				// L이면 방향벡터 반시계방향 90도 회전
				d--;	
				if(d<0) {
					d=3;
				}
				break;
			default:
				//F이면 x의 위치를 옮기고 최소, 최댓값 설정.
				x += dx[d];
				y += dy[d];
				minX = Math.min(minX, x);
				minY = Math.min(minY, y);
				maxX = Math.max(maxX, x);
				maxY = Math.max(maxY, y);
			}
		}
		x = 0-minX;
		y = 0-minY;
		//홍준이가 서있던 위치를 계산
		
		map = new String[maxX-minX+1][maxY-minY+1];
		//지도의 크기 계산
		
		map[x][y]=".";
		//처음 홍준이가 서있는 장소를 이동할 수 있는 칸으로 표시
		d = 0;
		//방향벡터 인덱스 초기화
		for (int i = 0; i < N; i++) {
			switch (s[i]) {
			case "R":
				// R이면 방향벡터 시계방향 90도 회전
				d++;
				d %= 4;
				break;
			case "L":
				// L이면 방향벡터 반시계방향 90도 회전
				d--;if(d<0) {
					d=3;
				}
				break;
			default:
				//F이면 이동 후 이동할 수 있는 칸 표시.
				x += dx[d];
				y += dy[d];
				map[x][y] = ".";
			}
		}
		for(int i = 0;i<map.length;i++) {
			for(int j =0;j<map[0].length;j++) {
				//지도를 순회하며
				if(map[i][j]!=null) {
					//표시되어 있다면 .출력
					bw.write(".");
				}else {
					//표시되어 있지 않다면 # 출력.
					bw.write("#");
				}
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
}