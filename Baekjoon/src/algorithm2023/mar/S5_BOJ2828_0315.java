package algorithm2023.mar;

/*  M������ �ٱ��Ϸ� N���� ���� �� �ϳ��� �������� ����� ��� �ޱ� ���� �����̴� �ּ� Ƚ��
 * ���̵� : �ǹ� 5
 * ���̵��: �¿� ��ǥ ��Ƽ� �̵�
 * �ð����⵵:
 * �ҿ� �ð�:�� 30�� 
 * */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class S5_BOJ2828_0315 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		int J = Integer.parseInt(br.readLine());
		
		int lb = 1;
		int rb = M;
		//�ٱ����� ���� ������ ��ǥ
		
		int cnt =0;
		//�ٱ��ϰ� �����̴� �Ÿ�
		for(int i = 0;i<J;i++) {
			int apple = Integer.parseInt(br.readLine());
			//bw.write(apple+" "+lb+" "+rb+"\n");
			if(apple>=lb&&apple<=rb) {
			//����� �ٱ��� ���� �ȿ� ������ �Ѿ
				continue;
			}else {
				//�ƴ϶�� ���� ������ �����ؼ� ����
				if(apple>rb) {
					cnt+=apple-rb;
					lb+=apple-rb;
					rb+=apple-rb;
				}else {
					cnt+=lb-apple;
					rb-=lb-apple;
					lb-=lb-apple;
				}
			}
		}
		bw.write(Integer.toString(cnt));
		bw.flush();
		bw.close();
	}
}