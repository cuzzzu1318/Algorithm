package algorithm2023.april;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class S3_BOJ17952_0321 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N;
	static int sum;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		Stack<int[]> unSolved = new Stack<>();
		int[] cur = {0,0,0};
		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			if (!s[0].equals("0")) {
				//������ �޾Ҵٸ�
				int[] hw = new int[3];
				hw[0] = Integer.parseInt(s[0]);
				hw[1] = Integer.parseInt(s[1]);
				hw[2] = Integer.parseInt(s[2]);
				//������ ���� �ð�, ����, �ɸ��� �ð� ��
				if(cur[0] != 0) {
					//���� ������ �ϰ� �־��ٸ�
					unSolved.add(cur);
					// ���� �ϰ� �ִ� ������ �ذ����� ���� ������ �߰�
				}
				
				cur = hw;
				//���� ���� ������ ����
			}
			cur[2]--;
			//���� ������ 1�� ����
			if(cur[2]==0) {
				//������ �� �ߴٸ�
				sum+=cur[1];
				//������ �߰��ϰ�
				if(unSolved.isEmpty()) {
					//���� ������ ���ٸ� cur �ʱ�ȭ
					cur[0]=0;
				}else {
					//���� ������ �ִٸ� �̾ �ϱ�
					cur = unSolved.pop();
				}
			}
		}
		bw.write(Integer.toString(sum));
		bw.flush();
		bw.close();
	}
}