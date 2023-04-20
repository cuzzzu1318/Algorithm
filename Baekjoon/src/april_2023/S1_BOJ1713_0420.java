package april_2023;

/*  
 * 난이도 : 
 * 아이디어: 
 * 시간복잡도:
 * 소요 시간: 
 * */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class S1_BOJ1713_0420 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N;
	static int K;
	static int ts = 0;
	static ArrayList<student> q = new ArrayList<>();

	static void addN(int n) {
		student s = new student(n,1,ts++);
		if (q.isEmpty()) {
			q.add(s);
		} else {
			for (int i = 0; i < q.size(); i++) {
				// 해당 학생이 이미 있다면
				if (q.get(i).n == n) {
					s.cnt = q.get(i).cnt + 1;
					s.time = q.get(i).time;
					// 추천 수를 1 늘리고
					q.remove(i);
					// 기존 사진틀에서 삭제
					if (q.isEmpty()) {
						// 사진틀이 완전히 비어버리면 바로 추가하고 리턴
						q.add(s);
						return;
					}
					break;
				}
			}
			int idx = 0;
			//사진을 추가할 인덱스
			for(int i = 0;i<q.size();i++) {
				if(q.get(i).cnt>s.cnt) {
					idx++;
				}else if(q.get(i).cnt==s.cnt) {
					if(q.get(i).time>s.time) {
						idx++;
					}
				}
			}
			if(idx>N-1) {
				//N보다 많은 수가 저장될 경우엔 해당 사진 말고 이전 사진을 삭제해야 하기 때문에 그 전에 추가
				idx--;
			}
			q.add(idx, s);
			if(q.size()>N) {
				///꽉 찬 경우 마지막 인덱스 삭제
				q.remove(q.size()-1);
			}
			
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");
		for (int i = 0; i < K; i++) {
			int n = Integer.parseInt(s[i]);
			addN(n);
			/*
			for(student student : q) {
				bw.write(student.n+" ");
			}
			bw.write("\n"+n+"추가\n");
			*/
		}
		//bw.write("\n");
		
		ArrayList<Integer> ans = new ArrayList<>();

		for (student student : q) {
			ans.add(student.n);
		}
		
		Collections.sort(ans);
		for (int num : ans) {
			bw.write(num + " ");
		}
		bw.flush();
		bw.close();
	}
	
	static class student{
		private int n;
		private int cnt;
		private int time;
		
		student(int n, int cnt, int time){
			this.n = n;
			this.cnt = cnt;
			this.time = time;
		}
	}
	
}