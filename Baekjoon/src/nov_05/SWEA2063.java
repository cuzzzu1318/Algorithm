package nov_05;

/*N개의 정수 중 중간값 찾기
 * N은 항상 홀수
 * N은 9 이상 199이하의 정수
 * 난이도 : D1
 * 아이디어: 오름차순 정렬 후 N/2번째 값 찾기
 * 시간복잡도: 정렬의 시간복잡도 + O(1)
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class SWEA2063 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int med = 0;
		ArrayList<Integer> numList = new ArrayList<>();
		String[] s = br.readLine().split(" ");
		for (String str : s) {
			numList.add(Integer.parseInt(str));
		}
		Collections.sort(numList);
		med = numList.get(N/2);
		System.out.println(med);
	}
}