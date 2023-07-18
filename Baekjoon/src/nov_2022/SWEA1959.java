package nov_2022;
/* N���� ���ڷ� ������ ���ڿ� A�� M���� ���ڷ� ������ ���ڿ� B. ���� ���ֺ��� ��ġ�� �ٲپ ���� �ε��������� ���� ���� �ִ� 
* ���̵� : D2
* ���̵��: �� ���ڿ��� ª�� ���ڿ��� �����Ѵ�. ª�����ڿ��� �� ���ڿ��� ª�� ���ڿ���ŭ ����ϰ� �� ���ڿ��� �� �� ���Ҹ� ���� �� ���� ������ �ݺ��Ѵ�.
*  �� ���ڿ��� ũ�Ⱑ ª�� ���ڿ����� �۾����� �����Ѵ�.
* �ð����⵵:
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SWEA1959 {
	
	public static int retMax(ArrayList<Integer> longS, ArrayList<Integer> shortS) {
		if( longS.size() < shortS.size()) {
			return 0;
		}
		int max = 0;
		for(int i = 0;i<shortS.size();i++) {
			max+=longS.get(i)*shortS.get(i);
		}
		longS.remove(0);
		
		int next = retMax(longS, shortS);
		if(next>max) {
			max = next;
		}
		return max;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i = 0;i<T;i++) {
			String[] s = br.readLine().split(" ");
			int N = Integer.parseInt(s[0]);
			int M = Integer.parseInt(s[1]);
			ArrayList<Integer> longS = new ArrayList<>();
			ArrayList<Integer> shortS = new ArrayList<>();
			String s1 = br.readLine();
			for(String c : s1.split(" ")) {
				longS.add(Integer.parseInt(c));
			}
			String s2 = br.readLine();
			for(String c : s2.split(" ")) {
				shortS.add(Integer.parseInt(c));
			}
			if(longS.size()<shortS.size()) {
				ArrayList<Integer> temp = longS;
				longS = shortS;
				shortS = temp;
			}
			System.out.println("#"+(i+1)+" "+retMax(longS, shortS));
		}
	}
}