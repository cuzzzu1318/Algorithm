package algorithm2022.aug;
import java.io.*;
import java.util.*;

public class BJ1157 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//�ܾ� �Է�
		String word = sc.nextLine();
		
		//�ܾ� �ҹ��ڷ� ��ȯ
		word = word.toLowerCase();
		//���ĺ� �迭 ���� �� 0���� �ʱ�ȭ
		int arr[] = new int[26];
		Arrays.fill(arr, 0);
		
		//���ĺ� ��� �迭�� �� ĭ���� ����
		for(int i = 0; i<word.length();i++) {
			arr[word.charAt(i)-97]++;
		}
		
		//�ִ� ã��, ������ ?�� �ƽ�Ű�ڵ� 63aaaa
		int max = 0;
		char cmax = 63;
		for(int i = 0; i<26;i++) {
			if(arr[i]>max) {
				max = arr[i];
				cmax = (char)(i+65);
			}
		}
		for(int i = 0; i<26;i++) {
			if(i!=(int)(cmax-65)&&arr[i]==max) {
				cmax = 63;
				break;
			}
		}
		
		//���
		System.out.println(cmax);
		
		
		
		
	}
}
