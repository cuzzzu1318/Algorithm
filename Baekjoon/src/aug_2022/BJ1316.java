//�׷�ܾ� üĿ

package aug_2022;
import java.io.*;
import java.util.*;

public class BJ1316 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//�ܾ� ���� �Է� �� ���� ����
		int num = sc.nextInt();
		sc.nextLine();
		
		//�ܾ �Է¹��� �迭 ���� �� �ܾ� �Է�
		ArrayList<String> arr = new ArrayList<String>();
		for(int i = 0;i<num;i++) {
			arr.add(sc.nextLine());
		}
		
		int cnt = 0;
		//�� �ܾ for��
		for(String str : arr) {
			ArrayList<Character> cArr = new ArrayList<Character>();
			char prev = 0;
			//�⺻������ �׷�ѹ��� ����
			boolean isGroupNumber = true;
			//�� ���ں� for��
			for(char c : str.toCharArray()) {
				if(cArr.contains(c)) {
					//�̹� ���� ���ĺ��� ���
					if(prev == c) {
						continue;
					}else {
						//�׷�ѹ��� �ƴϹǷ� break
						isGroupNumber = false;
						break;
					}
				}else {
					//���ο� ���ĺ��̹Ƿ� ���Դٰ� üũ �� �Ѿ
					cArr.add(c);
					prev = c;
				}
			}
			//�ش� �ܾ�� �׷�ѹ��̹Ƿ� count ++
			if(isGroupNumber == true) {
				cnt++;
			}
		}
		System.out.println(cnt);
		
	}
}
