package may_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_BOJ1992_0507 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int[][] tree;

	public static void main(String[] args) throws NumberFormatException, IOException {
	   int N = Integer.parseInt(br.readLine());
	  tree = new int[N][N];
	   for(int i =0;i<N;i++) {
		   String[] s = br.readLine().split("");
		   for(int j = 0;j<N;j++) {
			   tree[i][j] = Integer.parseInt(s[j]);
		   }
	   }
	   //입력
	   
	   print(0,0,N);
	   System.out.println(sb);
   }

	static void print(int x, int y, int l) {
		boolean isOne = true;
		//하나의 데이터로 된 구조인지 확인할 변수
		int n = tree[x][y];
		//첫번째 좌표의 값
		loop:
		for(int i =x;i<x+l;i++) {
			for(int j =y;j<y+l;j++) {
				if(tree[i][j]!=n) {
					//데이터를 탐색하고 다른값이 하나라도 있다면 하나의 데이터로 된 구조가 아님.
					isOne = false;
					break loop;
				}
			}
		}
		
		if(isOne) {
			//모두 n으로 이루어져 있다면 n출력
			sb.append(n);
		}else {
			//아니라면 다시 탐색, 괄호를 추가하여 출력
			sb.append("(");
			print(x, y, l/2);
			print(x, y+l/2, l/2);
			print(x+l/2, y, l/2);
			print(x+l/2, y+l/2, l/2);
			
			sb.append(")");
		}
	}
   
}