package algorithm2023.may;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class S1_BOJ2002_0527 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		LinkedList<String> car = new LinkedList<>();
		//���� �� N, ���� ������ ����Ʈ car
		int cnt = 0;
		//ī��Ʈ
		for (int i = 0; i < N; i++) {
			car.add(br.readLine());
		}
		//���� ���� ����
		
		
		for (int i = 0; i < N; i++) {
			String Exit = br.readLine();
			//���� ��
			if(!car.get(i).equals(Exit)) {
				//���� ������ �ٸ��ٸ�
				cnt++;
				car.add(i, car.remove(car.indexOf(Exit)));
				//�߿��� ���̹Ƿ� ī��Ʈ �߰��ϰ� �ε��� ����
			}
		}
		System.out.println(cnt);
	}
}