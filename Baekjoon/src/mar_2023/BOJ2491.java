package mar_2023;

/* 점점 커지거나 점점 작아지는 가장 긴 길이
 * 난이도 : 실버 5
 * 아이디어: 단순 구현
 * 시간복잡도:
 * 소요 시간:  
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ2491 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> arr = new ArrayList<>();
		String[] s = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr.add(Integer.parseInt(s[i]));
		}
		int max = 1;
		int cnt = 1;
		for(int i = 0;i<arr.size()-1;i++) {
			if(arr.get(i)<=arr.get(i+1)) {
				//System.out.println(arr.get(i)+" "+arr.get(i+1)+"cnt++");
				cnt++;
			}else {
				if(cnt>max) {
					//System.out.println("cnt초기화 "+cnt);
					max=cnt;
				}
					cnt=1;
			}
		}
		if(cnt>max) {
			max=cnt;
		}
		cnt = 1;
		for(int i = 0;i<arr.size()-1;i++) {
			if(arr.get(i)>=arr.get(i+1)) {
				cnt++;
			}else {
				if(cnt>max) {
					max=cnt;
				}
					cnt=1;
			}
		}
		if(cnt>max) {
			max=cnt;
		}
		System.out.println(max);
		
	}
}