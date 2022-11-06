package aug_15;
import java.io.*;
import java.util.*;

public class BJ1157 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//단어 입력
		String word = sc.nextLine();
		
		//단어 소문자로 변환
		word = word.toLowerCase();
		//알파벳 배열 선언 및 0으로 초기화
		int arr[] = new int[26];
		Arrays.fill(arr, 0);
		
		//알파벳 세어서 배열의 각 칸마다 더함
		for(int i = 0; i<word.length();i++) {
			arr[word.charAt(i)-97]++;
		}
		
		//최댓값 찾기, 같으면 ?의 아스키코드 63aaaa
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
		
		//출력
		System.out.println(cmax);
		
		
		
		
	}
}
