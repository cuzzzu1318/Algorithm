package algorithm2023.april;

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
			//�Ұ�ȣ ����
			int cntB = 0;
			//���ȣ ����
			for(char c:s) {
				//���ڿ��� ���� ������ ��ȸ
				if(c=='('||c=='[') {
					//���� ��ȣ��� ���ÿ� �߰�
					stack.push(c);
				}else if(c==')') {
					//�ݴ� �Ұ�ȣ���
					if(stack.isEmpty()) {
						//������ ����ִ� ��� -> no��� ���� ǥ���ϱ� ���� �ݴ� ��ȣ�� �ְ� �ݺ��� ����
						// -> ���ÿ� ���ڰ� �ִ� ���·� ����Ǳ� ������ no ���
						stack.push(c);
						break;
					}
					if(stack.peek()=='(') {
						//������ �ֻ���� ���� �Ұ�ȣ�̸� ¦�� �´� ���̹Ƿ� pop
						stack.pop();
					}else {
						//�ƴ� ��� push�� ����
						stack.push(c);
						break;
					}
				}else if(c==']') {
					//�ݴ� ���ȣ���
					if(stack.isEmpty()) {
						//������ ����ִ� ��� push �� �ݺ��� ����
						stack.push(c);
						break;
					}
					if(stack.peek() == '[') {
						//������ �ֻ���� ���� ���ȣ�̸� ¦�� �´� ���̹Ƿ� pop
						stack.pop();
					}else {
						//�ƴ� ��� push �� ����
						stack.push(c);
						break;
					}
				}
			}
			if(stack.isEmpty()) {
				//¦�� ��� �¾� ������ ��� �ִٸ� yes
				bw.write("yes\n");
			}else {
				//¦�� ���� �ʾ� ������ ���� �ʾҴٸ� no
				bw.write("no\n");
			}
			s = br.readLine().toCharArray();
		}
		bw.flush();
		bw.close();
	}
}