//그룹단어 체커

package aug_17;
import java.io.*;
import java.util.*;

public class BJ1316 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//단어 개수 입력 및 버퍼 비우기
		int num = sc.nextInt();
		sc.nextLine();
		
		//단어를 입력받을 배열 선언 및 단어 입력
		ArrayList<String> arr = new ArrayList<String>();
		for(int i = 0;i<num;i++) {
			arr.add(sc.nextLine());
		}
		
		int cnt = 0;
		//각 단어별 for문
		for(String str : arr) {
			ArrayList<Character> cArr = new ArrayList<Character>();
			char prev = 0;
			//기본적으로 그룹넘버로 설정
			boolean isGroupNumber = true;
			//각 문자별 for문
			for(char c : str.toCharArray()) {
				if(cArr.contains(c)) {
					//이미 나온 알파벳일 경우
					if(prev == c) {
						continue;
					}else {
						//그룹넘버가 아니므로 break
						isGroupNumber = false;
						break;
					}
				}else {
					//새로운 알파벳이므로 나왔다고 체크 후 넘어감
					cArr.add(c);
					prev = c;
				}
			}
			//해당 단어는 그룹넘버이므로 count ++
			if(isGroupNumber == true) {
				cnt++;
			}
		}
		System.out.println(cnt);
		
	}
}
