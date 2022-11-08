package nov_08;

/* 깊이 N만큼의 파스칼의 삼각형 출력하기
* 난이도 : D2
* 아이디어: 각 깊이 별로 깊이 -1 의 원소들을 더하여 추가
* 시간복잡도: ?
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SWEA2005 {

	static void pascal(ArrayList<ArrayList<Integer>> tri, int depth, int num) {
		if(depth>num) {
			return;
		}
		
		if (depth <= 2) {
			ArrayList<Integer> arr = new ArrayList<>();
			for (int i = 0; i < depth; i++) {
				arr.add(1);
			}
			tri.add(arr);
			pascal(tri, depth + 1, num);
		} else {
			ArrayList<Integer> arr = new ArrayList<>();
			arr.add(1);
			for (int i = 1; i < depth - 1; i++) {
				arr.add(tri.get(depth - 2).get(i - 1) + tri.get(depth - 2).get(i));
			}
			arr.add(1);
			tri.add(arr);
			pascal(tri,depth+1,num);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i =0;i<T;i++) {
			int N = Integer.parseInt(br.readLine());
			ArrayList<ArrayList<Integer>> triangle = new ArrayList<>();
			pascal(triangle, 1, N);
			System.out.println("#"+(i+1));
			for(ArrayList<Integer> a : triangle) {
				for(int item : a) {
					System.out.print(item+" ");
				}System.out.println("");
			}
		}
	}
}