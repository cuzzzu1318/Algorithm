package algorithm2022.jan;

/* 
 * ���̵� : ���5
 * ���̵��: ��Ʈ��ŷ
 * �ð����⵵:
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ15686 {

	public static void chDis(ArrayList<ArrayList<Integer>> home, ArrayList<ArrayList<Integer>> chicken, int[] visited,
			int start, int r, ArrayList<Integer> chickDis) {
		if (r == 0) {
			chickDis.add(dis(home, chicken, visited));
			return;
		} else {
			for (int i = start; i < chicken.size(); i++) {
				visited[i] = 1;
				chDis(home, chicken, visited, i + 1, r - 1, chickDis);
				visited[i] = 0;
			}
		}
	}

	public static int dis(ArrayList<ArrayList<Integer>> home, ArrayList<ArrayList<Integer>> chicken, int[] visited) {
		int chickDis = 0;
		for (int i = 0; i < home.size(); i++) {
			int min = 100;
			for (int j = 0; j < visited.length; j++) {
				if (visited[j] == 1) {
					int sum = 0;
					sum += Math.abs(home.get(i).get(0) - chicken.get(j).get(0));
					sum += Math.abs(home.get(i).get(1) - chicken.get(j).get(1));
					if (sum < min) {
						min = sum;
					}
				}
			}
			chickDis += min;
		}
		return chickDis;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		ArrayList<ArrayList<Integer>> home = new ArrayList<>();
		ArrayList<ArrayList<Integer>> chicken = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			s = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				int n = Integer.parseInt(s[j]);
				ArrayList<Integer> loc = new ArrayList<>();
				loc.add(i + 1);
				loc.add(j + 1);
				if (n == 1) {
					home.add(loc);
				} else if (n == 2) {
					chicken.add(loc);
				}
			}
		}
		int[] visited = new int[chicken.size()];
		ArrayList<Integer> chickDis = new ArrayList<>();
		//System.out.println(home);
		//System.out.println(chicken);
		chDis(home, chicken, visited, 0, M, chickDis);
		Collections.sort(chickDis);
		System.out.println(chickDis.get(0));
	}
}