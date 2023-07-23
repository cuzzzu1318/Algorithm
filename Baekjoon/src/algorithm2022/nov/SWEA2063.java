package algorithm2022.nov;

/*N���� ���� �� �߰��� ã��
 * N�� �׻� Ȧ��
 * N�� 9 �̻� 199������ ����
 * ���̵� : D1
 * ���̵��: �������� ���� �� N/2��° �� ã��
 * �ð����⵵: ������ �ð����⵵ + O(1)
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class SWEA2063 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int med = 0;
		ArrayList<Integer> numList = new ArrayList<>();
		String[] s = br.readLine().split(" ");
		for (String str : s) {
			numList.add(Integer.parseInt(str));
		}
		Collections.sort(numList);
		med = numList.get(N/2);
		System.out.println(med);
	}
}