package algorithm2023.april;

/*  
 * ���̵� : 
 * ���̵��: 
 * �ð����⵵:
 * �ҿ� �ð�: 
 * */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S1_BOJ2564_0420 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int w;
	static int h;

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer s = new StringTokenizer(br.readLine(), " ");
		w = Integer.parseInt(s.nextToken());
		h = Integer.parseInt(s.nextToken());
		int n = Integer.parseInt(br.readLine());
		// ����, ����, ���� ����
		int sum = 0;
		// �Ÿ� �� �� ����� ����
		ArrayList<store> arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			// ������ ��ġ ���� ���
			s = new StringTokenizer(br.readLine(), " ");
			store st = new store(s.nextToken(), s.nextToken());
			arr.add(st);
		}
		s = new StringTokenizer(br.readLine(), " ");

		int dDir = Integer.parseInt(s.nextToken());
		int dDis = Integer.parseInt(s.nextToken());
		// �������� ��ġ ����
		for(store st : arr) {
			sum+=st.calcDis(dDir, dDis);
		}
		bw.write(Integer.toString(sum));
		bw.flush();
		bw.close();

	}

	static class store {
		int dir;
		// ���� - 1: ��, 2: ��, 3: ��, 4: ��
		int dis;
		// �Ÿ� - �� ���� ��� ���ʱ���, �� ���ϰ�� ���ʱ���

		store(String dir, String dis) {
			this.dir = Integer.parseInt(dir);
			this.dis = Integer.parseInt(dis);
		}

		private int calcDis(int dDir, int dDis) {
			int min = 0;

			int clock;
			//�ð���� �Ÿ�
			int rClock;
			//�ݽð���� �Ÿ�
			switch (dDir) {
			// �������� ����
			case 1:
				// ��
				switch (dir) {
				// ������ ����
				case 1:
					// ��
					min = Math.abs(dDis-dis);
					break;
				case 2:
					// ��
					clock = w-dDis+h+w-dis;
					rClock = dDis+h+dis;
					min = Math.min(clock, rClock);
					break;
				case 3:
					// ��
					min = dDis+dis;
					break;
				default:
					// ��
					min = w-dDis+dis;
				}
				break;
			case 2:
				// ��
				switch (dir) {
				// ������ ����
				case 1:
					// ��
					clock = dDis+h+dis;
					rClock = w-dDis+h+w-dis;
					min = Math.min(clock, rClock);
					break;
				case 2:
					// ��
					min = Math.abs(dis-dDis);
					break;
				case 3:
					// ��
					min = dDis+h-dis;
					break;
				default:
					// ��
					min = w-dDis+h-dis;
				}
				break;
			case 3:
				// ��
				switch (dir) {
				// ������ ����
				case 1:
					// ��
					min = dDis+dis;
					break;
				case 2:
					// ��
					min = h-dDis+dis;
					break;
				case 3:
					// ��
					min = Math.abs(dDis-dis);
					break;
				default:
					// ��
					clock = dDis+w+dis;
					rClock = h-dDis+w+h-dis;
					min = Math.min(clock, rClock);
					
				}
				break;
			default:
				// ��
				switch (dir) {
				// ������ ����
				case 1:
					// ��
					min = dDis+w-dis;
					break;
				case 2:
					// ��
					min = h-dDis+w-dis;
					break;
				case 3:
					// ��
					clock = h-dDis+w+h-dis;
					rClock = dDis+w+dis;
					min = Math.min(clock, rClock);
					break;
				default:
					// ��
					min = Math.abs(dDis-dis);
				}
			}
			return min;
		}
	}
}