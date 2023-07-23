package algorithm2022.jul;
import java.io.*;
import java.util.*;

/**
 * (A+B)%C�� ((A%C) + (B%C))%C �� ������?
 * (A��B)%C�� ((A%C) �� (B%C))%C �� ������?
 * �� �� A, B, C�� �־����� ��, ���� �� ���� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 */

public class BJ10430 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		System.out.println((a+b)%c);
		System.out.println(((a%c)+(b%c))%c);
		System.out.println((a*b)%c);
		System.out.println(((a%c)*(b%c))%c);

	}
}
