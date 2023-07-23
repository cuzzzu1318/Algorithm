package algorithm2022.nov;

/* ������ ���� 8�ڸ� ��¥�� ��ȿ�� �Ǵ�
 * ���̵� : D1
 * ���̵��: ���ڿ� �Է� �� ��/��/�Ϸ� ������ ��ȿ�� �Ǵ�
 * �ð����⵵: ?
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class SWEA2056 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		ArrayList<String> ansList = new ArrayList<>();
		String[] is31 = { "01", "03", "05", "07", "08", "10", "12" };
		String[] is30 = { "04", "06", "09", "11" };
		String[] is28 = { "02" };
		for (int i = 0; i < T; i++) {
			String s = br.readLine();
			String year = s.substring(0, 4);
			String month = s.substring(4, 6);
			String date = s.substring(6, 8);
			if(Integer.parseInt(year)<1) {
				ansList.add("-1");
				continue;
			}
			if (Arrays.asList(is31).contains(month)) {
				if (Integer.parseInt(date) > 0 && Integer.parseInt(date) <= 31) {
					ansList.add(year + "/" + month + "/" + date);
					continue;
				}
			} else if (Arrays.asList(is30).contains(month)) {
				if (Integer.parseInt(date) > 0 && Integer.parseInt(date) <= 30) {
					ansList.add(year + "/" + month + "/" + date);
					continue;
				}
			} else if (Arrays.asList(is28).contains(month)) {
				if (Integer.parseInt(date) > 0 && Integer.parseInt(date) <= 28) {
					ansList.add(year + "/" + month + "/" + date);
					continue;
				}
			}
			ansList.add("-1");
		}
		int i = 1;
		for (String s : ansList) {
			System.out.println("#"+i+++" "+s);
		}
	}
}