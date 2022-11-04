package nov_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;

public class SWEA1244 {

	public static HashMap<LinkedList<Integer>, Integer> visited = new HashMap<>();

	public static void swap(LinkedList<Integer> arr, int idx1, int idx2) {
		int temp = arr.get(idx1);
		arr.set(idx1, arr.get(idx2));
		arr.set(idx2, temp);
	}

	public static int dfs(LinkedList<Integer> arr, int N) {
		int ans = 0;
		int max = 0;
		if (N == 0) {
			String s = "";
			for (int item : arr) {
				s += item;
			}
			ans = Integer.parseInt(s);
			return ans;
		}

		for (int i = 0; i < arr.size(); i++) {
			for (int j = i + 1; j < arr.size(); j++) {
				swap(arr, i, j);
				if (visited.containsKey(arr)&& visited.get(arr) == (N - 1)) {
				}else {
					int a = dfs(arr, N - 1);
					visited.put(arr, N - 1);
					if (a > max) {
						max = a;
					}
				}
				swap(arr, j, i);
			}
		}

		return max;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		LinkedList<Integer> ansArr = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			LinkedList<Integer> arr = new LinkedList<>();
			String[] str = br.readLine().split(" ");
			for (char item : str[0].toCharArray()) {
				arr.add(item - '0');
			}

			int sCnt = Integer.parseInt(str[1]);
			ansArr.add(dfs(arr, sCnt));
		}
		int cnt = 1;
		for (int i : ansArr) {
			System.out.println("#"+cnt+++" "+i);
		}
	}
}