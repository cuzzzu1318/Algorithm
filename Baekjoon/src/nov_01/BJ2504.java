package nov_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class BJ2504 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<Character> list = new LinkedList<>();
		for(char c : br.readLine().toCharArray()) {
			list.add(c);
		}
		int ans = 0;
		
		for(int i = 0; !list.isEmpty();i++) {
			System.out.println(i+": i");
			System.out.println(ans+": ans");
			if(i>list.size()-2) {
				break;
			}
			if(list.get(i)==')'||list.get(i)==']') {
				
			}
		}
		System.out.println(ans);
	}
}
