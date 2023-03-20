package mar_2023;

/* 수강신청 시스템
 * 클릭하면 목록에 들어가고 중복클릭 시 목록 맨 뒤로 빠짐.
 * 최종 3명 출력 
 * 난이도 : 실버 3
 * 아이디어: 처음에 큐 사용해서 풀었는데 시간초과 나옴.
 * 			자료구조를 신경쓰자. 검색해보니 링크드해쉬라는게 있어서 써봤음.
 * 시간복잡도:
 * 소요 시간: 16:15~ 16:38 ( 23min )
 * */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedHashSet;

public class S3_BOJ13414_0320 {

	static int K;
	static int L;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] s = br.readLine().split(" ");
		K = Integer.parseInt(s[0]);
		L = Integer.parseInt(s[1]);
		LinkedHashSet<String> set = new LinkedHashSet<>();
		int order = 1;
		for (int i = 0; i < L; i++) {
			String num = br.readLine();
			if (set.contains(num)) {
				set.remove(num);
			}
			set.add(num);
			//System.out.println(q);
		}
		for(String n : set) {
			if(K<=0) {
				break;
			}
			bw.write(n+"\n");
			K--;
		}
		bw.flush();
		bw.close();

	}
}