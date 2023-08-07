package algorithm2023.aug.day07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA_1228_암호문1 {
	static int N, M;
	static LinkedList<Integer> arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int t= 1;t<=10;t++) {
			N = Integer.parseInt(br.readLine());
			arr = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i =0;i<N;i++) {
				arr.add( Integer.parseInt(st.nextToken()));
			}
			M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			for(int i =0;i<M;i++) {
				//명령어가 I뿐이므로 버림.
				st.nextToken();
				//x의 뒤에 y개의 수 삽입
				int x = Integer.parseInt(st.nextToken());
				int y= Integer.parseInt(st.nextToken());
				//y개의 수를 입력받을 때 마다 한칸씩 뒤로 삽입
				for(int j= 0;j<y;j++) {
					arr.add((x++), Integer.parseInt(st.nextToken()));
				}
			}
			
			
			//출력부
			sb.append("#").append(t).append(" ").append("\n");
			for(int i= 0;i<10;i++) {
				sb.append(arr.get(i)+" ");
			}
			
			
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
