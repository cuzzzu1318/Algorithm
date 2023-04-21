package april_2023;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class S3_BOJ17952_0321 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N;
	static int sum;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		Stack<int[]> unSolved = new Stack<>();
		int[] cur = {0,0,0};
		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			if (!s[0].equals("0")) {
				//과제를 받았다면
				int[] hw = new int[3];
				hw[0] = Integer.parseInt(s[0]);
				hw[1] = Integer.parseInt(s[1]);
				hw[2] = Integer.parseInt(s[2]);
				//과제를 받은 시간, 점수, 걸리는 시간 순
				if(cur[0] != 0) {
					//현재 과제를 하고 있었다면
					unSolved.add(cur);
					// 현재 하고 있던 과제를 해결하지 못한 과제에 추가
				}
				
				cur = hw;
				//새로 받은 과제를 시작
			}
			cur[2]--;
			//현재 과제를 1분 진행
			if(cur[2]==0) {
				//과제를 다 했다면
				sum+=cur[1];
				//점수를 추가하고
				if(unSolved.isEmpty()) {
					//안한 과제가 없다면 cur 초기화
					cur[0]=0;
				}else {
					//안한 과제가 있다면 이어서 하기
					cur = unSolved.pop();
				}
			}
		}
		bw.write(Integer.toString(sum));
		bw.flush();
		bw.close();
	}
}