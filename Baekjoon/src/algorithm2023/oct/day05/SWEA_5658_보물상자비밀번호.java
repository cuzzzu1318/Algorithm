package algorithm2023.oct.day05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class SWEA_5658_보물상자비밀번호 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N, K, digit;
	static String str;
	static TreeSet<Integer> ts;
	
	public static void main(String[] args) throws Exception{
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1;t<=T;t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			ts = new TreeSet<>();
			
			digit = N/4;
			//문자열로 그냥 풀자
			str = br.readLine();
			
			//회전 수
			for(int i= 0;i<digit;i++) {
				//회전한 상태에서 자릿수만큼 10진수로 변환 후 트리셋에 삽입
				for(int j = 0;j<N;j+=digit) {
					ts.add(Integer.parseInt(str.substring(j, j+digit), 16));
				}
				//회전 -> 문자열이기때문에 앞에 한자리 잘라서 뒤에 붙힘
				str = str.substring(1)+str.charAt(0);
			}
			sb.append("#").append(t).append(" ");
			
			int cnt = ts.size();
			//트리셋 순회, 오름차순이므로 카운트도 반대로 
			for(int n : ts) {
				if(cnt--==K) {
					sb.append(n).append("\n");
				}
			}
			
		}
		System.out.println(sb);
	}
}
