//크로아티아 알파벳 변환자 세기

package aug_16;
import java.io.*;
import java.util.*;

public class BJ2941 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//크로아티아 알파벳 단어 입력
		String str = sc.nextLine();
		
		//각 문자를 배열에 입력
		char[] s = str.toCharArray();
		int cnt = 0;
		char pre = '1';
		boolean b = false;
		
		//각 문자와 이전의 문자를 비교하여 개수 구함 
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
