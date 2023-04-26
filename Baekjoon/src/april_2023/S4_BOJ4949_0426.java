package april_2023;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class S4_BOJ4949_0426 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws NumberFormatException, IOException {
		char[] s  =br.readLine().toCharArray();
		while(s[0]!='.') {
			int cntS = 0;
			Stack<Character> stack = new Stack<>();
			//소괄호 세기
			int cntB = 0;
			//대괄호 세기
			for(char c:s) {
				//문자열을 문자 단위로 순회
				if(c=='('||c=='[') {
					//여는 괄호라면 스택에 추가
					stack.push(c);
				}else if(c==')') {
					//닫는 소괄호라면
					if(stack.isEmpty()) {
						//스택이 비어있는 경우 -> no라는 것을 표시하기 위해 닫는 괄호를 넣고 반복문 종료
						// -> 스택에 문자가 있는 상태로 종료되기 때문에 no 출력
						stack.push(c);
						break;
					}
					if(stack.peek()=='(') {
						//스택의 최상단이 여는 소괄호이면 짝이 맞는 것이므로 pop
						stack.pop();
					}else {
						//아닌 경우 push후 종료
						stack.push(c);
						break;
					}
				}else if(c==']') {
					//닫는 대괄호라면
					if(stack.isEmpty()) {
						//스택이 비어있는 경우 push 후 반복문 종료
						stack.push(c);
						break;
					}
					if(stack.peek() == '[') {
						//스택의 최상단이 여는 대괄호이면 짝이 맞는 것이므로 pop
						stack.pop();
					}else {
						//아닌 경우 push 후 종료
						stack.push(c);
						break;
					}
				}
			}
			if(stack.isEmpty()) {
				//짝이 모두 맞아 스택이 비어 있다면 yes
				bw.write("yes\n");
			}else {
				//짝이 맞지 않아 스택이 비지 않았다면 no
				bw.write("no\n");
			}
			s = br.readLine().toCharArray();
		}
		bw.flush();
		bw.close();
	}
}