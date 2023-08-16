package algorithm2023.aug.day16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_6987_월드컵 {

	static int[][] result;
	static int[][] game;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		result = new int[6][3];
		game = new int[15][2];
		int idx = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = i + 1; j < 6; j++) {
				game[idx][0] = i;
				game[idx][1] = j;
				idx++;
			}
		}
		for (int t = 0; t < 4; t++) {

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int sum = 0;
			for (int j = 0; j < 18; j++) {
				int n = Integer.parseInt(st.nextToken());
				sum += n;
				result[j / 3][j % 3] = n;
			}
			if (sum != 30) {
				sb.append(0).append(" ");
				continue;
			}
			
			//완탐
			
			if(dfs(0))sb.append(1).append(" ");
			else sb.append(0).append(" ");
//			
		}
		System.out.println(sb);

	}
	
	
	//game 배열을 이용해서 모든 1:1 게임을 순차적으로 진행. 
	//가지치기 -> 각 상황에 대해 양수일 때만 진행
	//game 배열의 마지막까지 도달하면 유효한 결과
	static boolean dfs(int idx) {
		if(idx==15)return true;
		int teamA = game[idx][0];
		int teamB = game[idx][1];
		
		//a팀이 이기는 경우
		if(result[teamA][0]>0&&result[teamB][2]>0) {
			result[teamA][0]--;
			result[teamB][2]--;
			if(dfs(idx+1))return true;
			result[teamA][0]++;
			result[teamB][2]++;
		}
		//b팀이 이기는 경우
		if(result[teamA][2]>0&&result[teamB][0]>0) {
			result[teamA][2]--;
			result[teamB][0]--;
			if(dfs(idx+1))return true;
			result[teamA][2]++;
			result[teamB][0]++;
		}
		//비기는 경우
		if(result[teamA][1]>0&&result[teamB][1]>0) {
			result[teamA][1]--;
			result[teamB][1]--;
			if(dfs(idx+1))return true;
			result[teamA][1]++;
			result[teamB][1]++;
		}
		return false;
	}
}
