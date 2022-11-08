package nov_08;
/* N개의 숫자로 구성된 숫자열 A와 M개의 숫자로 구성된 숫자열 B. 서로 마주보는 위치를 바꾸어서 같은 인덱스끼리의 곱의 합의 최댓값 
* 난이도 : D2
* 아이디어: 긴 문자열과 짧은 문자열을 구분한다. 짧은문자열과 긴 문자열을 짧은 문자열만큼 계산하고 긴 문자열의 맨 앞 원소를 제거 후 같은 과정을 반복한다.
*  긴 문자열의 크기가 짧은 문자열보다 작아지면 종료한다.
* 시간복잡도:
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SWEA1959 {
	
	public static int retMax(ArrayList<Integer> longS, ArrayList<Integer> shortS) {
		if( longS.size() < shortS.size()) {
			return 0;
		}
		int max = 0;
		for(int i = 0;i<shortS.size();i++) {
			max+=longS.get(i)*shortS.get(i);
		}
		longS.remove(0);
		
		int next = retMax(longS, shortS);
		if(next>max) {
			max = next;
		}
		return max;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i = 0;i<T;i++) {
			String[] s = br.readLine().split(" ");
			int N = Integer.parseInt(s[0]);
			int M = Integer.parseInt(s[1]);
			ArrayList<Integer> longS = new ArrayList<>();
			ArrayList<Integer> shortS = new ArrayList<>();
			String s1 = br.readLine();
			for(String c : s1.split(" ")) {
				longS.add(Integer.parseInt(c));
			}
			String s2 = br.readLine();
			for(String c : s2.split(" ")) {
				shortS.add(Integer.parseInt(c));
			}
			if(longS.size()<shortS.size()) {
				ArrayList<Integer> temp = longS;
				longS = shortS;
				shortS = temp;
			}
			System.out.println("#"+(i+1)+" "+retMax(longS, shortS));
		}
	}
}