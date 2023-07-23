package algorithm2023.april;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class S4_BOJ1764_0427 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws NumberFormatException, IOException {
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		//�赵 ���� ����� �� 
		int M = Integer.parseInt(s[1]);
		//���� ���� ����� ��
		
		HashMap<String,Integer> DBJ = new HashMap<>();
		//�赵 ���� ����� �� ��
		ArrayList<String> ans = new ArrayList<>();
		//�赵 ���� ���� ����� �� ����Ʈ
		int cnt = 0;
		//�赵 ���� ���� ����� ��
		
		for(int i = 0;i<N;i++) {
			DBJ.put(br.readLine(), 1);
			//�赵 ���� ���
		}
		for(int i= 0;i<M;i++) {
			String p = br.readLine();
			if(DBJ.containsKey(p)) {
				//���� ���� ����� �赵 ���� ����̶�� ī��Ʈ �� ��º����� ����.
				cnt++;
				ans.add(p);
			}
		}
		
		bw.write(Integer.toString(cnt)+"\n");
		Collections.sort(ans);
		//������ ����ؾ� �ϱ� ������ ����
		for(String p : ans) {
			bw.write(p+"\n");
		}
		
		bw.flush();
		bw.close();
	}
}