//������� ���� ����� ������ ���� ���Ѵ�. ����� ���ڸ� �дµ� ������ �ִ�. 
//�̷��� ������ ���ϴ� ����� ���ؼ� ����̴� ���� ũ�⸦ ���ϴ� ������ ���־���. 
//����̴� �� �ڸ� �� �� ���� ĥ�ǿ� ���־���. �� ������ ũ�Ⱑ ū ���� ���غ���� �ߴ�.
//����� ���� �ٸ� ����� �ٸ��� �Ųٷ� �д´�. ���� ���, 734�� 893�� ĥ�ǿ� �����ٸ�,
//����� �� ���� 437�� 398�� �д´�. ����, ����� �� ���� ū ���� 437�� ū ����� ���� ���̴�.
//�� ���� �־����� ��, ����� ����� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

import java.io.*;
import java.util.*;

public class BJ2941 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//���ڸ� �� �ΰ� ���� ���� �Է�
		String str = sc.nextLine();
		String[] arr = str.split(" ");
		
		int num = 1;
		int a = 0;
		for(String i: arr[0].split("")) {
			a+=Integer.parseInt(i)*num;
			num*=10;
		}
		
		num = 1;
		int b = 0;
		for(String i: arr[1].split("")) {
			b+=Integer.parseInt(i)*num;
			num*=10;
		}
		
		if(a>b) {
			System.out.println(a);
		}else {
			System.out.println(b);
		}
		
	}
}