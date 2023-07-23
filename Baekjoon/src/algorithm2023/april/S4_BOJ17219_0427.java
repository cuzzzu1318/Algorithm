package algorithm2023.april;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class S4_BOJ17219_0427 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws NumberFormatException, IOException {
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		//�Է�
		HashMap<String, String> map = new HashMap<>();
		//����Ʈ�� ��й�ȣ ������ map
		for(int i = 0;i<N;i++) {
			s = br.readLine().split(" ");
			//�Է°� map�� ����
			map.put(s[0], s[1]);
		}
		for(int i= 0;i<M;i++) {
			//map���� �����ͼ� ���
			bw.write(map.get(br.readLine())+"\n");
		}
		bw.flush();
		bw.close();
	}
}