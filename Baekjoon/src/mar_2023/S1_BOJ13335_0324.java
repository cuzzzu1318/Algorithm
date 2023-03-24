package mar_2023;

/*  
 * 난이도 : 
 * 아이디어: 
 * 시간복잡도:
 * 소요 시간: 13:40~
 * */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class S1_BOJ13335_0324 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws NumberFormatException, IOException {
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int w = Integer.parseInt(s[1]);
		int L = Integer.parseInt(s[2]);
		s = br.readLine().split(" ");
		int i = 0;

		int time = 0;
		int sum = 0;
		int cnt = 0;
		Queue<Integer> q = new LinkedList<>();
		int t = Integer.parseInt(s[i++]);

		while (true) {
			time++;
			//System.out.println(q + "\n" + t + " " + time + " " + cnt+" "+sum);
			if (q.size() >= w) {
				int poll = q.poll();
				if (poll != 0) {
					cnt++;
					sum -= poll;
					if (cnt == n) {
						break;
					}
				}
			}
			if (sum + t <= L) {
				q.add(t);
				sum += t;
				if(i<n) {
					t = Integer.parseInt(s[i++]);
				}else {
					t=0;
					
				}
				

			} else {
				q.add(0);

			}
		}
		bw.write(Integer.toString(time));
		bw.flush();
		bw.close();
	}
}