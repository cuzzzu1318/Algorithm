package algorithm2023.aug.day01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G4_BOJ1043 {

	static int N, M;
	static boolean party[][], people[][], vPeople[], vParty[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		//파티 번호와 참가하는 사람 저장
		party = new boolean[M+1][N+1];
		//사람 번호와 참가하는 파티 저장
		people = new boolean[N+1][M+1];
		vPeople = new boolean[N+1];
		vParty = new boolean[M+1];
		//진실을 알고 있는 사람 저장
		st = new StringTokenizer(br.readLine(), " ");
		int knowN = Integer.parseInt(st.nextToken());
		Queue<Integer> know = new LinkedList<>();
		while(st.hasMoreTokens()) {
			int p = Integer.parseInt(st.nextToken());
			vPeople[p] = true;
			know.offer(p);
			
		}
		
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int size = Integer.parseInt(st.nextToken());
			for (int j = 0; j < size; j++) {
				int person = Integer.parseInt(st.nextToken());
				party[i][person] = true;
				people[person][i] = true;
			}
		}
		
		while(!know.isEmpty()) {
			int cur = know.poll();
			for(int i = 1;i<=M;i++) {
				if(people[cur][i]) {
					if(vParty[i])continue;
					vParty[i] = true;
					for(int j = 1;j<=N;j++) {
						if(party[i][j]) {
							if(vPeople[j])continue;
							vPeople[j] =true;
							know.offer(j);
						}
					}
				}
			}
		}
		int cnt = 0;
		for(int i =1 ;i<=M;i++) {
			if(!vParty[i])cnt++;
		}
		System.out.println(cnt);
		
				

	}
}
