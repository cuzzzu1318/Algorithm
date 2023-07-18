//���� ��ҹ��ڿ� �������� �̷���� ���ڿ��� �־�����. �� ���ڿ����� �� ���� �ܾ ������?
//�̸� ���ϴ� ���α׷��� �ۼ��Ͻÿ�. ��, �� �ܾ ���� �� �����ϸ� ������ Ƚ����ŭ ��� ����� �Ѵ�.

package aug_2022;
import java.io.*;
import java.util.*;

public class BJ1152 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//���ڿ� �Է� �� �ܾ� �迭�� ����
		String str = sc.nextLine();
		String[] arr = str.split(" ");
		
		//�ܾ� ���� ����
		int cnt = 0;
		for(String s :arr) {
			if(s!="") {
			cnt++;
			}
		}
		System.out.println(cnt);
		
		
	}
}
