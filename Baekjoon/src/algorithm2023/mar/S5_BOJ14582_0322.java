package algorithm2023.mar;

/*  ���̴Ͻ��� �ɸ������� �߱����
 * 	���̴Ͻ��� ����.
 * 	��� �߰��� ���̴Ͻ��� �̱�� �ִ� ������ �ִ��� �˾ƺ���.
 * ���̵� : �ǹ� 5
 * ���̵��: �ܼ��� �հ�� ���. But ȸ���� �ʿ� �� ���̿� �̱� ���� ������ ����� �ɸ������� ���� ���� �������.
 * �ð����⵵:
 * �ҿ� �ð�: 09:49~09:56(7min)
 * */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class S5_BOJ14582_0322 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] jeminis = new int[9];
		int[] gullivers = new int[9];
		String[] s = br.readLine().split(" ");
		for(int i = 0;i<9;i++) {
			jeminis[i] = Integer.parseInt(s[i]);
		}
		s = br.readLine().split(" ");
		for(int i = 0;i<9;i++) {
			gullivers[i] = Integer.parseInt(s[i]);
		}
		int jemSum = 0;
		int gulSum = 0;
		boolean isReversal = false;
		for(int i =0;i<9;i++) {
			jemSum+=jeminis[i];
			
			if(jemSum>gulSum) {
				//System.out.println(i+" "+jemSum+" "+gulSum);
				isReversal = true;
			}
			gulSum+=gullivers[i];
		}
		if(isReversal) {
			bw.write("Yes");
		}else {
			bw.write("No");
		}
		bw.flush();
		bw.close();
		
	}
}