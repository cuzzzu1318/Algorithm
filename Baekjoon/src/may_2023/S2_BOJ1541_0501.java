package may_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class S2_BOJ1541_0501 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		String s = br.readLine();
		ArrayList<Character> calc = new ArrayList<>();
		ArrayList<Integer> nums = new ArrayList<>();
		for(int i= 0;i<s.length();i++) {
			if(s.charAt(i)=='+'||s.charAt(i)=='-') {
				calc.add(s.charAt(i));
			}
		}
		String[] num = s.split("\\+|-");
		for(String a : num) {
			nums.add(Integer.parseInt(a));
		}
		int sum = nums.get(0);
		
		boolean isMinus = false;
		for(int i = 1;i<nums.size();i++) {
			char c = calc.get(i-1);
			if(isMinus) {
				sum-=nums.get(i);
				continue;
			}
			else {
				if(c=='-') {
					sum-=nums.get(i);
					isMinus = true;
				}else {
					sum+=nums.get(i);
				}
				
			}
		}
		System.out.println(sum);
		
		
	}
}