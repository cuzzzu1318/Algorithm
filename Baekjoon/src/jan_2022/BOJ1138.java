package jan_2022;

/* * ������� ���� ����. �Է��� ����� �� N�� Ű�� 1�� ������� ���ʴ�� ���ʿ� �ڽź��� Ű ū ����� ���� �־���.
 * ��� ������� �� �ִ��� ���
 * ���̵� : �ǹ� 2 ���ٷ� ����
 * ���̵��: ū ������� Ž���ؼ� ���ʿ� �ִ� �ڽź��� ū ����� �� ��ŭ �ǳʶپ ����
 * �ð����⵵:
 * �ҿ� �ð�: 20m 
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ1138 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(0);
		for(String c : s) {
			arr.add(Integer.parseInt(c));
		}
		ArrayList<Integer> ans = new ArrayList<>();
		for(int i = n;i>0;i--) {
			int idx = 0;
			for(int j = 0;arr.get(i)>0;j++) {
				if(ans.get(j)>i) {
					idx++;
					arr.set(i, arr.get(i)-1);
				}
			}
			ans.add(idx, i);
		}
		for(int num : ans) {
			System.out.print(num+" ");
		}
	}
}