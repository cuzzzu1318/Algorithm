package algorithm2023.may;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1_BOJ1931_0507 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		int[][] time = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			// ȸ���� ���۽ð� s�� ������ �ð� e
			time[i][0] = s;
			time[i][1] = e;
			
		}
		Arrays.sort(time, (e1,e2)-> {
			//����
			if(e1[1]==e2[1]) {
				//���� ������ ���� ��� ���� ������ ������ ������ ����
				return e1[0]-e2[0];
			}else {
				return e1[1]-e2[1];
			}
		});
		
		int cnt = 0;
		int end = 0;
		for(int i= 0;i<N;i++) {
			if(end<=time[i][0]) {
				//��ϵ� ������� ���Ŀ� ���۵Ǵ� ȸ���� ��� ī��Ʈ�ϰ� ������� ����
				cnt++;
				end = time[i][1];
			}
		}
		System.out.println(cnt);
		
		
	}
}