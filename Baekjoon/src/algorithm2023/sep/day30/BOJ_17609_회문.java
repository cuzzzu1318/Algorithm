package algorithm2023.sep.day30;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17609_회문 {
	static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static String str;
	static int l;
	
	public static void main(String[] args) throws Exception{
		
		int T = Integer.parseInt(br.readLine());
		for(int i= 0;i<T;i++) {
			str=br.readLine();
			l =str.length();
			int ret = isPalin();
			sb.append(ret).append("\n");
		}
		System.out.println(sb);
	}
	
	static int isPalin() {
		//지우는 문자의 개수
		int cnt = 0;
		
		int s = 0;
		int e = l-1;
		while(s<e) {
			System.out.println(str.charAt(s)+" "+str.charAt(e));
			if(str.charAt(s)==str.charAt(e)) {
				s++;
				e--;
			}else {
				cnt++;
				//왼쪽 문자를 지우는 경우
				if(str.charAt(s+1)==str.charAt(e)) {
					s++;
					//오른쪽 문자를 지우는 경우
				}else if(str.charAt(e-1)==str.charAt(s)) {
					e--;
					//둘다 해당되지 않을 경우
				}else {
					return 2;
				}
			}
		}
		return cnt;
	}
}
