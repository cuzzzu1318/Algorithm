//ũ�ξ�Ƽ�� ���ĺ� ��ȯ�� ����

package aug_2022;
import java.io.*;
import java.util.*;

public class BJ2941 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//ũ�ξ�Ƽ�� ���ĺ� �ܾ� �Է�
		String str = sc.nextLine();
		
		//�� ���ڸ� �迭�� �Է�
		char[] s = str.toCharArray();
		int cnt = 0;
		char pre = '1';
		boolean b = false;
		
		//�� ���ڿ� ������ ���ڸ� ���Ͽ� ���� ���� 
		for(char c : s) {
			if(c=='-'||c=='='||c==' ') {
				if(c=='='&&b==true) {
					cnt--;
				}else {
				}
			}else if(c=='j'&&(pre=='l'||pre=='n')) {
			}else if(c!='z') {
				cnt++;
			}else if(c=='z'&&pre=='d'){
				b=true;
				cnt++;
				pre = c;
				continue;
			}
			else {
				cnt++;
			}
			b=false;
			pre = c;
		}
		System.out.println(cnt);
	}
}
