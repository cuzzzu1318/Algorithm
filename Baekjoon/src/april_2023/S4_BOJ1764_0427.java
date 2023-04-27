package april_2023;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class S4_BOJ1764_0427 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws NumberFormatException, IOException {
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		//듣도 못한 사람의 수 
		int M = Integer.parseInt(s[1]);
		//보도 못한 사람의 수
		
		HashMap<String,Integer> DBJ = new HashMap<>();
		//듣도 못한 사람이 들어갈 맵
		ArrayList<String> ans = new ArrayList<>();
		//듣도 보도 못한 사람이 들어갈 리스트
		int cnt = 0;
		//듣도 보도 못한 사람의 수
		
		for(int i = 0;i<N;i++) {
			DBJ.put(br.readLine(), 1);
			//듣도 못한 사람
		}
		for(int i= 0;i<M;i++) {
			String p = br.readLine();
			if(DBJ.containsKey(p)) {
				//보도 못한 사람이 듣도 못한 사람이라면 카운트 및 출력변수에 넣음.
				cnt++;
				ans.add(p);
			}
		}
		
		bw.write(Integer.toString(cnt)+"\n");
		Collections.sort(ans);
		//사전순 출력해야 하기 때문에 정렬
		for(String p : ans) {
			bw.write(p+"\n");
		}
		
		bw.flush();
		bw.close();
	}
}