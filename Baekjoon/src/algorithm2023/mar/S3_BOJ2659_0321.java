package algorithm2023.mar;

/*  �����¿쿡 ���ڰ� ���ִ� ī�� ����. (1�̻� 9����)
 * 	�� ī�带 �ð�������� �о��� ���� ��������� ���ڸ� �� �� ���� ���� ���� '�ð��'
 * 	�Էµ� ī���� �ð���� ��� �ð�� �߿� ���°�� ���� �ð������ �˾Ƴ��� ���α׷� �ۼ�.
 * ���̵� : �ǹ� 3
 * ���̵��: �ð�������� �д� �Լ� ����� �������鼭 Ȯ��. v�迭�� ���� �̹� �鸥 ���ڴ� �н�.
 * �ð����⵵:
 * �ҿ� �ð�:10:50~ 11:17 (27min)
 * */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class S3_BOJ2659_0321 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int readClock(int index, int[] card) {
		int num = 0;
		int n = 1000;
		for(int i = 0;i<4;i++) {
			num+=card[index]*n;
			index++;
			if(index==4) {
				index=0;
			}
			n/=10;
		}
		return num;
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		String[] s = br.readLine().split(" ");
		int[] card = new int[4];
		boolean[] v = new boolean[10000];
		for (int i = 0; i < 4; i++) {
			card[i] = Integer.parseInt(s[i]);
		}
		int num = 9999;
		for(int i = 0;i<4;i++) {
			num=Math.min(num, readClock(i,card));
			//bw.write(num+"\n");
		}
		//bw.write(num+"\n");
		int cnt = 1;
		loop1:
		for(int i =1;i<=9;i++) {
			for(int j = 1;j<=9;j++) {
				for(int k = 1;k<=9;k++) {
					for(int l = 1;l<=9;l++) {
						int[] arr = new int[4];
						arr[0]=i;
						arr[1]=j;
						arr[2]=k;
						arr[3]=l;
						int num2 = 9999;
						for(int m = 0;m<4;m++) {
							num2=Math.min(num2, readClock(m,arr));
							//bw.write(num2+"\n");
						}
						if(v[num2]) {
							//bw.write(num2+" continue\n");
							continue;
						}
						v[num2]=true;
						if(num2>=num) {
							break loop1;
						}else {
							//bw.write(num2+"\n");
							cnt++;
						}
						
					}
				}
			}
		}
		bw.write(Integer.toString(cnt));
		bw.flush();
		bw.close();
	}
}