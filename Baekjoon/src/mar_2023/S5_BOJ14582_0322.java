package mar_2023;

/*  제미니스와 걸리버스의 야구경기
 * 	제미니스는 졌다.
 * 	경기 중간에 제미니스가 이기고 있는 순간이 있는지 알아보라.
 * 난이도 : 실버 5
 * 아이디어: 단순히 합계로 계산. But 회차별 초와 말 사이에 이길 수도 있으니 계산을 걸리버스의 득점 전에 해줘야함.
 * 시간복잡도:
 * 소요 시간: 09:49~09:56(7min)
 * */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class S5_BOJ14582_0322 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] jeminis = new int[9];
		int[] gullivers = new int[9];
		String[] s = br.readLine().split(" ");
		for(int i = 0;i<9;i++) {
			jeminis[i] = Integer.parseInt(s[i]);
		}
		s = br.readLine().split(" ");
		for(int i = 0;i<9;i++) {
			gullivers[i] = Integer.parseInt(s[i]);
		}
		int jemSum = 0;
		int gulSum = 0;
		boolean isReversal = false;
		for(int i =0;i<9;i++) {
			jemSum+=jeminis[i];
			
			if(jemSum>gulSum) {
				//System.out.println(i+" "+jemSum+" "+gulSum);
				isReversal = true;
			}
			gulSum+=gullivers[i];
		}
		if(isReversal) {
			bw.write("Yes");
		}else {
			bw.write("No");
		}
		bw.flush();
		bw.close();
		
	}
}