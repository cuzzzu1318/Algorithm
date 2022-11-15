package nov_12;
/* 퀸을 배치하며 공격할 수 있는 칸을 제외한 나머지 칸에 다른 퀸 배치, 퀸을 N개 배치하면 종료하면서 해당 칸을 순회하지 않도록 함
 * 난이도 : D3
 * 아이디어: 
 * 시간복잡도:
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

class N_Queen {
	private ArrayList<ArrayList<Integer>> q = new ArrayList<>();
	private ArrayList<Integer> v = new ArrayList<>();
	private int ans = 0;
	private int N;

	public N_Queen(int N) {
		this.N = N;
		for (int i = 0; i < N; i++) {
			v.add(-1);
		}
	}

	void bt(int level) {
		if (level == N) {
			ans++;
			return;
		}
		for (int n = 0; n < N; n++) {
			v.set(level, n);
			boolean bool = true;
			for (int i = 0; i < level; i++) {
				if (v.get(i) == v.get(level) || level - i == Math.abs(v.get(i) - v.get(level))) {
					bool = false;
				}
			}
			if(bool) {
				bt(level+1);
			}
		}

	}
	
	int getAns() {
		return ans;
	}
}

public class SWEA2806 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			N_Queen nq = new N_Queen(N);
			nq.bt(0);
			System.out.println("#"+(t+1)+" "+nq.getAns());
		}
	}
}