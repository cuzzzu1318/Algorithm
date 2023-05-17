package may_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G4_BOJ9019_0516 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			//A를 B로 만들어야 함.
			boolean[] visit = new boolean[10000];
			//0부터 9999까지의 값만 저장되므로 10000개의 배열 생성
			Queue<command> q = new LinkedList<>();
			command first = new command(A, "");
			//명령어를 함께 저장하기 위해 별도의 클래스 사용.
			q.add(first);
			visit[A] = true;
			loop: while (!q.isEmpty()) {
				command cur = q.poll();
				if (cur.n == B) {
					//B가 만들어졌다면 해당 수 까지의 명령어 출력!
					sb.append(cur.command + "\n");
					break loop;
				}
				for (int i = 0; i < 4; i++) {
					int next = 0;
					String nextF = cur.command;
					switch (i) {
					case 0:
						//D
						next = cur.n * 2 % 10000;
						nextF+= "D";
						break;
					case 1:
						//S
						next = cur.n - 1;
						if (cur.n == 0) {
							next = 9999;
						}
						nextF += "S";
						break;
					case 2:
						//L
						next = ((cur.n * 10) % 10000 + cur.n / 1000);
						nextF += "L";
						break;
					default:
						//R
						next = cur.n / 10 + (cur.n % 10) * 1000;
						nextF += "R";
					}
					if (!visit[next]) {
						q.add(new command(next, nextF));
						visit[next] = true;
					}
				}
			}
		}
		System.out.println(sb);
	}
	
	static class command{
		int n;
		String command = "";
		command(int n, String command){
			this.n = n;
			this.command = command;
		}
	}
}