package algorithm2023.sep.day30;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 양 끝의 글자를 비교해서 회문인지 판별
 * 글자 하나를 지우는 경우를 판별
 * 	- 왼쪽을 지우는 경우와 오른쪽을 지우는 경우를 모두 봐야 하므로 재귀로 풀이
 * 	- 양 끝의 글자가 다를 경우 두 경우 를 재귀 후 더 작은 값으로 리턴
*/
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
			//입력받은 문자열에 대해 재귀 시행
			int ret = isPalin(0,l-1,0);
			sb.append(ret).append("\n");
		}
		System.out.println(sb);
	}
	
	
	//왼쪽 인덱스 s, 오른쪽 인덱스 e, 글자를 2번이상 바꾸지 않기 위한 cnt
	static int isPalin(int s, int e, int cnt) {
		//이미 글자가 바뀌었다면 2 리턴
		if(cnt>1)return 2;
		//모든 인덱스를 탐색한 경우 글자 바꾼 횟수 리턴
		if(s>=e)return cnt;
		//양쪽 글자가 같다면 양쪽 인덱스를 1씩 줄여서 다시 탐색
		if(str.charAt(s)==str.charAt(e)) {
			return isPalin(s+1,e-1, cnt);
		}else {
			//다르다면
			//왼쪽 글자를 지운 경우
			int left = isPalin(s+1,e,cnt+1);
			//오른쪽 글자를 지운 경우
			int right = isPalin(s,e-1,cnt+1);
			//둘 중 더 작은 값 리턴
			return Math.min(left, right);
		}
		
	}
}
