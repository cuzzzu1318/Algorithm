//영어 대소문자와 공백으로 이루어진 문자열이 주어진다. 이 문자열에는 몇 개의 단어가 있을까?
//이를 구하는 프로그램을 작성하시오. 단, 한 단어가 여러 번 등장하면 등장한 횟수만큼 모두 세어야 한다.


import java.io.*;
import java.util.*;

public class BJ1152 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//문자열 입력 및 단어 배열에 저장
		String str = sc.nextLine();
		String[] arr = str.split(" ");
		
		//단어 개수 세기
		int cnt = 0;
		for(String s :arr) {
			if(s!="") {
			cnt++;
			}
		}
		System.out.println(cnt);
		
		
	}
}
