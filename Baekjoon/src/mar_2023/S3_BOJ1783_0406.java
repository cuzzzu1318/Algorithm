package mar_2023;

/*  오른쪽으로만 갈 수 있는 나이트가 방문할 수 있는 칸 수의 최댓값
 * 	--방문한 칸의 수가 5개 이상이면 모든 움직임을 한번씩 해야함.
 * 	--아니라면 움직임 종류 제한 X
 * 난이도 : 실버 3
 * 아이디어: 생각 정리가 안돼서 찾아봤음.
 * 		   직접 탐색하지 않아도 칸 개수로 계산 가능.
 * 시간복잡도:
 * 소요 시간: ? 
 * */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class S3_BOJ1783_0406 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N;
	static int M;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int cnt  = 1;
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		
		if(N==1||M==1) {
			cnt = 1;
		}else if(N==2) {
			cnt=(M+1)/2;
			if(cnt>4) {
				cnt=4;
			}
		}else {
			if(M>=7) {
				cnt=5+M-7;
			}else {
				cnt=M;
				if(M>4) {
					cnt=4;
				}
			}
		}
		bw.write(Integer.toString(cnt));
		bw.flush();
		bw.close();
		
	}
}