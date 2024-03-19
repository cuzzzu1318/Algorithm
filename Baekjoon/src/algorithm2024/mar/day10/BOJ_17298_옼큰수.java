package algorithm2024.mar.day10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17298_옼큰수 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	/*인덱스와 수를 함께 다루기 위한 클래스*/
	static class Num{
		int idx, n;
		public Num(int idx, int n) {
			this.idx = idx;
			this.n = n;
		}
	}

	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		//오큰수를 저장할 배열
		int[] NGE = new int[N];
		st = new StringTokenizer(br.readLine());

		//Deque를 스택으로 사용
		Deque<Num> stk = new ArrayDeque<>();
		/*수를 입력받으며 스택을 확인*/
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			/*스택의 top이 입력받은 n보다 작은 경우*/
			while(!stk.isEmpty()&&stk.peek().n<n){
				/*pop하면서 해당하는 수의 인덱스에 오큰수 n으로 저장*/
				Num num = stk.pop();
				NGE[num.idx] = n;
			}
			/*스택에 n 저장*/
			stk.push(new Num(i,n));
		}
		/*입력 종료 후 스택에 수가 남은 경우
		* 내림차순으로 저장돼 있기에 전부 오큰수가 없다.
		* 오큰수를 -1로 저장*/
		while (!stk.isEmpty()){
			Num num = stk.pop();
			NGE[num.idx] =-1;
		}
		/*출력*/
		for (int i : NGE) {
			sb.append(i).append(" ");
		}
		System.out.println(sb);
	}
}
