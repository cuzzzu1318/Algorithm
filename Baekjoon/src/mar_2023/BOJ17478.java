package mar_2023;

/*  
 * 난이도 : 
 * 아이디어: 
 * 시간복잡도:
 * 소요 시간: 
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ17478 {

	public static void recursive(int n, int depth) {
		String ub = "";
		for (int i = 0; i < depth; i++) {
			ub += "____";
		}
		if (depth == 0) {
			System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		}
		System.out.println(ub + "\"재귀함수가 뭔가요?\"");

		if (n == depth) {
			System.out.println(ub + "\"재귀함수는 자기 자신을 호출하는 함수라네\"");
		} else {
			System.out.println(ub + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
			System.out.println(ub+"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
			System.out.println(ub+"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
			recursive(n, depth + 1);
		}
		System.out.println(ub + "라고 답변하였지.");
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		recursive(n, 0);
	}
}