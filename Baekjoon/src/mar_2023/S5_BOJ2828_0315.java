package mar_2023;

/*  M사이즈 바구니로 N개의 라인 중 하나에 떨어지는 사과를 모두 받기 위해 움직이는 최소 횟수
 * 난이도 : 실버 5
 * 아이디어: 좌우 좌표 잡아서 이동
 * 시간복잡도:
 * 소요 시간:한 30분 
 * */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class S5_BOJ2828_0315 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		int J = Integer.parseInt(br.readLine());
		
		int lb = 1;
		int rb = M;
		//바구니의 왼쪽 오른쪽 좌표
		
		int cnt =0;
		//바구니가 움직이는 거리
		for(int i = 0;i<J;i++) {
			int apple = Integer.parseInt(br.readLine());
			//bw.write(apple+" "+lb+" "+rb+"\n");
			if(apple>=lb&&apple<=rb) {
			//사과가 바구니 영역 안에 있으면 넘어감
				continue;
			}else {
				//아니라면 왼쪽 오른쪽 구분해서 움직
				if(apple>rb) {
					cnt+=apple-rb;
					lb+=apple-rb;
					rb+=apple-rb;
				}else {
					cnt+=lb-apple;
					rb-=lb-apple;
					lb-=lb-apple;
				}
			}
		}
		bw.write(Integer.toString(cnt));
		bw.flush();
		bw.close();
	}
}