package algorithm2023.aug.day11;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BOJ_3040_백설공주와일곱난쟁이 {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int[] v = new int[9];
		int total = 0;
		for (int i = 0; i < 9; i++) {
			v[i] = sc.nextInt();
			total += v[i];
		}
		Map<Integer, Boolean> map = new HashMap<>();
find:	for (int i = 0; i < 9; i++) {
			for (int j = i + 1; j < 9; j++) {
				if (total - v[i] - v[j] == 100) {
					map.put(i, true);
					map.put(j, true);
					break find;
				}
			}
		}
		for (int i = 0; i < 9; i++) {
			if (!map.getOrDefault(i, false)) {
				sb.append(v[i] + "\n");
			}
		}
		System.out.println(sb.toString());
	}
}
