package algorithm2022.oct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class BJ1966 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());//�׽�Ʈ ���̽� ��
		for(int i = 0;i<num;i++) {
			LinkedList<Integer> PQ = new LinkedList<>();
			String[] s = br.readLine().split(" ");
			int N = Integer.parseInt(s[0]);//������ ����
			int M = Integer.parseInt(s[1]);//���°�� �μ�Ǿ����� �ñ��� ����
			s = br.readLine().split(" ");
			for(int j = 0;j<N;j++) {//�߿䵵 �Է�
				PQ.add(Integer.parseInt(s[j]));
			}
			int seq = 1;
			while(!PQ.isEmpty()) {//ť�� ��������
				int n = PQ.poll();
				boolean mostP = true;
				for(int k = 0;k<PQ.size();k++) {//�߿䵵�� �� ū ���Ұ� ������ mostP�ƴ�
					if(PQ.get(k)>n) {
						mostP = false;
					}
				}
				if(mostP == true) {//�߿䵵�� ���� Ŭ ��� poll, M��°������ ��� while�� Ż��
					if(M==0) {
						System.out.println(seq);
						break;
					}
					seq++;
				}else {//�ƴҰ�� �� �ڷ�, M��° ������ ��� Mũ�� �÷��� �ٽ� ���
					PQ.offer(n);
					if(M==0) {
						M+=PQ.size();
					}
				}
				M--;
			}
			
		}
	}
}
