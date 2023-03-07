package jan_28_2023;

/* * 사람들이 줄을 선다. 입력은 사람의 수 N과 키가 1인 사람부터 차례대로 왼쪽에 자신보다 키 큰 사람의 수가 주어짐.
 * 어느 순서대로 서 있는지 출력
 * 난이도 : 실버 2 한줄로 서기
 * 아이디어: 큰 사람부터 탐색해서 왼쪽에 있는 자신보다 큰 사람의 수 만큼 건너뛰어서 서기
 * 시간복잡도:
 * 소요 시간: 20m 
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ1138 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(0);
		for(String c : s) {
			arr.add(Integer.parseInt(c));
		}
		ArrayList<Integer> ans = new ArrayList<>();
		for(int i = n;i>0;i--) {
			int idx = 0;
			for(int j = 0;arr.get(i)>0;j++) {
				if(ans.get(j)>i) {
					idx++;
					arr.set(i, arr.get(i)-1);
				}
			}
			ans.add(idx, i);
		}
		for(int num : ans) {
			System.out.print(num+" ");
		}
	}
}