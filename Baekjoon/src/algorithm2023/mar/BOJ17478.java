package algorithm2023.mar;

/*  
 * ���̵� : 
 * ���̵��: 
 * �ð����⵵:
 * �ҿ� �ð�: 
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ17478 {

	public static void recursive(int n, int depth) {
		String ub = "";
		for (int i = 0; i < depth; i++) {
			ub += "____";
		}
		if (depth == 0) {
			System.out.println("��� �� ��ǻ�Ͱ��а� �л��� ������ �������� ã�ư� ������.");
		}
		System.out.println(ub + "\"����Լ��� ������?\"");

		if (n == depth) {
			System.out.println(ub + "\"����Լ��� �ڱ� �ڽ��� ȣ���ϴ� �Լ����\"");
		} else {
			System.out.println(ub + "\"�� ����. �������� �� �� ����⿡ �̼��� ��� ������ ����� ������ �־���.");
			System.out.println(ub+"���� ������� ��� �� ���ο��� ������ ������ �߰�, ��� �����Ӱ� ����� �־���.");
			System.out.println(ub+"���� ���� ��κ� �ǾҴٰ� �ϳ�. �׷��� ��� ��, �� ���ο��� �� ���� ã�ƿͼ� ������.\"");
			recursive(n, depth + 1);
		}
		System.out.println(ub + "��� �亯�Ͽ���.");
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		recursive(n, 0);
	}
}