//������� �ҸӴϴ� �Ʒ� �׸��� ���� ������ ���̾� ��ȭ�⸦ ����Ѵ�.
//��ȭ�� �ɰ� ���� ��ȣ�� �ִٸ�, ���ڸ� �ϳ��� ���� ������ �ݼ� ���� �ִ� �� ���� �ð�������� ������ �Ѵ�. 
//���ڸ� �ϳ� ������ ���̾��� ó�� ��ġ�� ���ư���, ���� ���ڸ� �������� ���̾��� ó�� ��ġ���� �ٽ� ������ �Ѵ�.
//���� 1�� �ɷ��� �� 2�ʰ� �ʿ��ϴ�. 1���� ū ���� �Ŵµ� �ɸ��� �ð��� �̺��� �� �ɸ���, 
//�� ĭ ���� �ִ� ���ڸ� �ɱ� ���ؼ� 1�ʾ� �� �ɸ���.
//������� �ҸӴϴ� ��ȭ ��ȣ�� �� ���ڿ� �ش��ϴ� ���ڷ� �ܿ��. ��, � �ܾ �� ��, 
//�� ���ĺ��� �ش��ϴ� ���ڸ� �ɸ� �ȴ�. ���� ���, UNUCIC�� 868242�� ����.
//�ҸӴϰ� �ܿ� �ܾ �־����� ��, �� ��ȭ�� �ɱ� ���ؼ� �ʿ��� �ּ� �ð��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

package algorithm2022.aug;
import java.io.*;
import java.util.*;

public class BJ5622 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		int cnt = 0;
		for(char c: str.toCharArray()) {
			int i = (int)c;
			if(i<65||i>90) {
				System.out.println("Error!");
				break;
			}else if(i>=65&&i<68) {
				cnt+=3;
			}else if(i>=68&&i<71) {
				cnt+=4;
			}else if(i>=71&&i<74) {
				cnt+=5;
			}else if(i>=74&&i<77) {
				cnt+=6;
			}else if(i>=77&&i<80) {
				cnt+=7;
			}else if(i>=80&&i<84) {
				cnt+=8;
			}else if(i>=84&&i<87) {
				cnt+=9;
			}else if(i>=87&&i<91) {
				cnt+=10;
			}
		}
		System.out.println(cnt);
		
	}
}
