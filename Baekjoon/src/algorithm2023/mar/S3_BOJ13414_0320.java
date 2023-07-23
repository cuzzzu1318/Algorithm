package algorithm2023.mar;

/* ������û �ý���
 * Ŭ���ϸ� ��Ͽ� ���� �ߺ�Ŭ�� �� ��� �� �ڷ� ����.
 * ���� 3�� ��� 
 * ���̵� : �ǹ� 3
 * ���̵��: ó���� ť ����ؼ� Ǯ���µ� �ð��ʰ� ����.
 * 			�ڷᱸ���� �Ű澲��. �˻��غ��� ��ũ���ؽ���°� �־ �����.
 * �ð����⵵:
 * �ҿ� �ð�: 16:15~ 16:38 ( 23min )
 * */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedHashSet;

public class S3_BOJ13414_0320 {

	static int K;
	static int L;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] s = br.readLine().split(" ");
		K = Integer.parseInt(s[0]);
		L = Integer.parseInt(s[1]);
		LinkedHashSet<String> set = new LinkedHashSet<>();
		int order = 1;
		for (int i = 0; i < L; i++) {
			String num = br.readLine();
			if (set.contains(num)) {
				set.remove(num);
			}
			set.add(num);
			//System.out.println(q);
		}
		for(String n : set) {
			if(K<=0) {
				break;
			}
			bw.write(n+"\n");
			K--;
		}
		bw.flush();
		bw.close();

	}
}