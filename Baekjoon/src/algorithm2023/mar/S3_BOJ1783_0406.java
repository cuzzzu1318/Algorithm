package algorithm2023.mar;

/*  ���������θ� �� �� �ִ� ����Ʈ�� �湮�� �� �ִ� ĭ ���� �ִ�
 * 	--�湮�� ĭ�� ���� 5�� �̻��̸� ��� �������� �ѹ��� �ؾ���.
 * 	--�ƴ϶�� ������ ���� ���� X
 * ���̵� : �ǹ� 3
 * ���̵��: ���� ������ �ȵż� ã�ƺ���.
 * 		   ���� Ž������ �ʾƵ� ĭ ������ ��� ����.
 * �ð����⵵:
 * �ҿ� �ð�: ? 
 * */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class S3_BOJ1783_0406 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N;
	static int M;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int cnt  = 1;
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		
		if(N==1||M==1) {
			cnt = 1;
		}else if(N==2) {
			cnt=(M+1)/2;
			if(cnt>4) {
				cnt=4;
			}
		}else {
			if(M>=7) {
				cnt=5+M-7;
			}else {
				cnt=M;
				if(M>4) {
					cnt=4;
				}
			}
		}
		bw.write(Integer.toString(cnt));
		bw.flush();
		bw.close();
		
	}
}