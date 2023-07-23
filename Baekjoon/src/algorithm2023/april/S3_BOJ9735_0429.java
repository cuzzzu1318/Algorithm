package algorithm2023.april;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.HashMap;

public class S3_BOJ9735_0429 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		//�׽�Ʈ ���̽��� ��
		for(int t = 0;t<T;t++) {
			int n = Integer.parseInt(br.readLine());
			//���� ���� ��
			HashMap<String, ArrayList<String>> map = new HashMap<>();
			//���� �������� �����ϱ� ���� HashMap���
			for(int i = 0;i<n;i++) {
				String[] s = br.readLine().split(" ");
				if(map.containsKey(s[1])) {
					//�ش� ������ �ʿ� �ִٸ� �ʸ� �߰�
					map.get(s[1]).add(s[0]);
				}else {
					//�ʿ� ���� ������ ���̶�� ������ �Բ� �߰�
					ArrayList<String> temp = new ArrayList<>();
					temp.add(s[0]);
					map.put(s[1], temp);
				}
			}
			int sum = 1;
			for(ArrayList<String> val : map.values()) {
				//���
				sum*= val.size()+1;
			}
			sum--;
			if(n==0) {
				//���� �ϳ��� ���ٸ� �԰� ���� �� ���� ������ 0���� �ٽ� �ʱ�ȭ
				sum=0;
			}
			bw.write(Integer.toString(sum)+"\n");
		}

		bw.flush();
		bw.close();
	}
}